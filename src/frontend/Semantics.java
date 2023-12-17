package frontend;

import intermediate.symtab.*;
import antlr4.*;
import intermediate.type.Typespec;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static frontend.SemanticErrorHandler.Code.*;

public class Semantics extends NeoBaseVisitor<Object> {
    private SymtabStack symtabStack;
    private SymtabEntry programId;
    private SemanticErrorHandler error;

    private Symtab functionSymtab;

    //private Typespec declaredTypeOfCurrentFunction;
    private Symtab localVarSymtab;
    private FunctionSymtabEntry currentFunction;
//    private int sizeOfReturnTypeOfCurrentFunction;

    public Semantics()
    {
        // Create and initialize the symbol table stack.
        //this.symtabStack = new SymtabStack();
        //Predefined.initialize(symtabStack);
        this.symtabStack = new SymtabStack();
        this.error = new SemanticErrorHandler();

        this.functionSymtab = new Symtab(1);        // don't care about nesting level
        this.localVarSymtab = new Symtab(1);
    }

    public SymtabEntry getProgramId() {
        return programId;
    }
    public int getErrorCount() { return error.getCount(); };

    @Override
    public Object visitProgram(NeoParser.ProgramContext ctx) {
        visitProgramHeader(ctx.programHeader());
        visitFunctionDefinitionList(ctx.functionDefinitionList());
        localVarSymtab = new Symtab(1);
        visitVariableList(ctx.variableDeclarationList().variableList());
        visitCompoundStatement(ctx.compoundStatement());
        return null;
    }

    @Override
    public Object visitProgramHeader(NeoParser.ProgramHeaderContext ctx)
    {
        NeoParser.ProgramIdentifierContext idCtx = ctx.programIdentifier();
        String programName = idCtx.IDENTIFIER().getText();  // don't shift case

        programId = symtabStack.enterLocal(programName);
        // programId.setRoutineSymtab(symtabStack.push());

        symtabStack.setProgramId(programId);
        symtabStack.getLocalSymtab().setOwner(programId);

        // idCtx.entry = programId;
        return null;
    }

    @Override
    public Object visitAssignmentStatement(NeoParser.AssignmentStatementContext ctx) {
        if (ctx.lhs().matrixEntry() != null || ctx.lhs().variable().realVariable() != null) {          // lhs is real variable or matrix entry
            if (ctx.rhs().expression().matrixExpression().size() > 0) {   // rhs is a matrix expression
                error.flag(TYPE_MISMATCH, ctx);
            }
        }
        else if (ctx.lhs().variable().matrixVariable() != null) {   // lhs is matrix variable
            if (ctx.rhs().expression().realExpression().size() > 0) {     // rhs is a real expression
                error.flag(TYPE_MISMATCH, ctx);
            }

            int lhsMatrixSize = Integer.valueOf(ctx.lhs().variable().matrixVariable().INTEGER().getText());
            int rhsMatrixSize = (int) visitExpression(ctx.rhs().expression());      // checks that rhs is valid along the way

            if (lhsMatrixSize != rhsMatrixSize) error.flag(MATRIX_SIZE_MISMATCH, ctx);
        }
        return null;
    }



    @Override
    public Object visitExpression(NeoParser.ExpressionContext ctx){
        //Expression is a real Expression
        if (ctx.realExpression().size() > 0){
            List<NeoParser.RealExpressionContext> l = ctx.realExpression();
            for (int i = 0; i < l.size(); i++) {
                visitRealExpression(l.get(i));
            }
            return 0;
        }
        //Expression is a matrix expression
        List<NeoParser.MatrixExpressionContext> l = ctx.matrixExpression();
        int size = (int) visitMatrixExpression(l.get(0));
        for(int i = 1; i < l.size(); i++){
            if (size != (int) visitMatrixExpression(l.get(i))){
                error.flag(MATRIX_SIZE_MISMATCH, ctx);
            }
        }
        return size;
    }

    @Override
    public Object visitReturnStatement(NeoParser.ReturnStatementContext ctx) {
        Typespec typeOfCurrentFunction = currentFunction.getReturnType();
        if (typeOfCurrentFunction.getForm() == Typespec.Form.SCALAR) {
            if (ctx.expression().matrixExpression().size() > 0) {   // return type is matrix expression
                error.flag(INVALID_RETURN_TYPE, ctx);
            }
        }
        else {      // matrix
            if (ctx.expression().realExpression().size() > 0) {     // return type is real expression
                error.flag(INVALID_RETURN_TYPE, ctx);
                return null;
            }

            // check that size matches
            int declaredSize = typeOfCurrentFunction.getSize();
            int returnSize = (int) visitExpression(ctx.expression());
            if (declaredSize != returnSize) error.flag(MATRIX_SIZE_MISMATCH, ctx);
        }
        return null;
    }

    @Override
    public Object visitRealFunctionDefinition(NeoParser.RealFunctionDefinitionContext ctx){
        String name = ctx.realFunctionName().getText();
        Typespec declaredReturnType = new Typespec(Typespec.Form.SCALAR);

        localVarSymtab = new Symtab(1);
        ArrayList<Typespec> declaredParameterTypes = new ArrayList<Typespec>();
        for (NeoParser.VariableContext vCtx: ctx.variableList().variable()){
            Typespec t = new Typespec(vCtx.realVariable() != null ? Typespec.Form.MATRIX : Typespec.Form.SCALAR);
            declaredParameterTypes.add(t);
            localVarSymtab.enter(vCtx.getText(), 0);
        }

        visitVariableList(ctx.variableDeclarationList().variableList());

        currentFunction = new FunctionSymtabEntry(name, declaredReturnType, declaredParameterTypes, functionSymtab);
        functionSymtab.put(name, currentFunction);

        visitCompoundStatement(ctx.compoundStatement());


        return null;
    }

    @Override
    public Object visitMatrixFunctionDefinition(NeoParser.MatrixFunctionDefinitionContext ctx) {

        //another way to do it? ==> ctx.matrixFunctionName().IDENTIFIER().getText()
        String name = ctx.matrixFunctionName().getText();
        int size = Integer.valueOf(ctx.matrixFunctionName().INTEGER().getText());
        Typespec declaredReturnType = new Typespec(Typespec.Form.MATRIX, size); // PR
        ArrayList<Typespec> declaredParameterTypes = new ArrayList<Typespec>();
        localVarSymtab = new Symtab(1);
        for (NeoParser.VariableContext vCtx: ctx.variableList().variable()){
            Typespec t = new Typespec(vCtx.realVariable() != null ? Typespec.Form.MATRIX : Typespec.Form.SCALAR);
            declaredParameterTypes.add(t);
            localVarSymtab.enter(vCtx.getText(), 0);
        }

        visitVariableList(ctx.variableDeclarationList().variableList());

        currentFunction = new FunctionSymtabEntry(name, declaredReturnType, declaredParameterTypes, functionSymtab);
        functionSymtab.put(name, currentFunction);

        visitCompoundStatement(ctx.compoundStatement());

        return size;
    }


    @Override
    public Object visitVariableList(NeoParser.VariableListContext ctx){
        //ArrayList<SymtabEntry> entryArr = new ArrayList<SymtabEntry>();
        for (NeoParser.VariableContext vCtx: ctx.variable()){
            localVarSymtab.enter(vCtx.getText());
        }
        return null;
    }


    @Override // Returns int object casted (size), the caller can handle from there
    public Object visitMatrixExpression(NeoParser.MatrixExpressionContext ctx){
        List<NeoParser.MatrixTermContext> l = ctx.matrixTerm();
        int size = (int) visitMatrixTerm(l.get(0));
        for(int i = 1; i < l.size(); i++){
            if (size != (int) visitMatrixTerm(l.get(i))){
                error.flag(MATRIX_SIZE_MISMATCH, ctx);
            }
        }
        return size;
    }

    @Override // Returns int object casted (size), the caller can handle from there
    public Object visitMatrixTerm(NeoParser.MatrixTermContext ctx){
        List<NeoParser.MatrixFactorContext> l = ctx.matrixFactor();
        int size = (int) visitMatrixFactor(l.get(0));
        for (int i = 1; i < l.size(); i++){
            if (size != (int) visitMatrixFactor(l.get(i))){
                error.flag(MATRIX_SIZE_MISMATCH, ctx);
            }
        }
        return size;
    }

    @Override // Returns int object casted (size), the caller can handle from there
    public Object visitMatrixFactor(NeoParser.MatrixFactorContext ctx) {
        if (ctx.matrixVariable() != null) {
            visitMatrixVariable(ctx.matrixVariable());
            return Integer.valueOf(ctx.matrixVariable().INTEGER().getText());
        } else if (ctx.matrixFunctionCall() != null) {
            visitMatrixFunctionCall(ctx.matrixFunctionCall());
            return Integer.valueOf(ctx.matrixFunctionCall().matrixFunctionName().INTEGER().getText());
        } else if (ctx.invTerm() != null) {
            visitMatrixVariable(ctx.invTerm().matrixVariable());
            return Integer.valueOf(ctx.invTerm().matrixVariable().INTEGER().getText());
        } else {
            return visitMatrixExpression(ctx.matrixExpression());
        }
    }

    @Override
    public Object visitRealFunctionCall(NeoParser.RealFunctionCallContext ctx) {
        FunctionSymtabEntry funcSymTabEntry = (FunctionSymtabEntry) functionSymtab.lookup(ctx.realFunctionName().getText());

        if(funcSymTabEntry == null)  {
            error.flag(NAME_MUST_BE_FUNCTION, ctx);
            return null;
        }

        List<NeoParser.ArgumentContext> aCtx = ctx.argumentList().argument();
        List<Typespec > pCtx = funcSymTabEntry.getParameterTypes();

        if(pCtx.size() != aCtx.size()) {
            error.flag(ARGUMENT_COUNT_MISMATCH, ctx);
            return null;
        }

        for (int i = 0; i < ctx.argumentList().argument().size(); i ++){
            int size = (int) visitExpression(aCtx.get(i).expression());
            if (size == 0 ^ pCtx.get(i).getSize() == 0){        // size == 0 means real
                error.flag(TYPE_MISMATCH, ctx);
                return null;
            }
            else {
                error.flag(MATRIX_SIZE_MISMATCH, ctx);
                return null;
            }
        }
        return null;
    }

    @Override
    public Object visitMatrixFunctionCall(NeoParser.MatrixFunctionCallContext ctx) {
        FunctionSymtabEntry funcSymTabEntry = (FunctionSymtabEntry) functionSymtab.lookup(ctx.matrixFunctionName().getText());

        if(funcSymTabEntry == null)  {
            error.flag(NAME_MUST_BE_FUNCTION, ctx); return null;
        }

        List<NeoParser.ArgumentContext> aCtx = ctx.argumentList().argument();
        List<Typespec > pCtx = funcSymTabEntry.getParameterTypes();

        if(pCtx.size() != aCtx.size()) {
            error.flag(ARGUMENT_COUNT_MISMATCH, ctx);
            return null;
        }

        for (int i = 0; i < ctx.argumentList().argument().size(); i ++){
            int size = (int) visitExpression(aCtx.get(i).expression());
            if (size == 0 ^ pCtx.get(i).getSize() == 0){
                error.flag(TYPE_MISMATCH, ctx);
                return null;
            }
            else {
                error.flag(MATRIX_SIZE_MISMATCH, ctx);
                return null;
            }
        }
        return null;
    }

    @Override
    public Object visitRealVariable(NeoParser.RealVariableContext ctx) {
        String identifier = ctx.getText();
        if (localVarSymtab.lookup(identifier) == null) error.flag(UNDECLARED_IDENTIFIER, ctx);
        return null;
    }

    @Override
    public Object visitMatrixVariable(NeoParser.MatrixVariableContext ctx) {
        String identifier = ctx.getText();
        if (localVarSymtab.lookup(identifier) == null) error.flag(UNDECLARED_IDENTIFIER, ctx);
        return null;
    }

    @Override
    public Object visitMatrixEntry(NeoParser.MatrixEntryContext ctx) {
        String identifier = ctx.getText();
        if (localVarSymtab.lookup(identifier) == null) error.flag(UNDECLARED_IDENTIFIER, ctx);
        return null;
    }
}

