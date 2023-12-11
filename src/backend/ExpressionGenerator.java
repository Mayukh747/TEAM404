package backend;

import antlr4.*;
import backend.Instruction.*;
import frontend.SemanticErrorHandler;
import intermediate.type.Typespec;

import static backend.Instruction.INVOKESTATIC;

public class ExpressionGenerator extends CodeGenerator {

    /**
     * Constructor.
     * @param parent the parent generator.
     * @param compiler the compiler to use.
     */
    public ExpressionGenerator(CodeGenerator parent, Compiler compiler)
    {
        super(parent, compiler);
    }


    public void emitRealExpression(NeoParser.RealExpressionContext ctx) {
        int numberOfTerms = ctx.realTerm().size();
        for (int i = 0; i < numberOfTerms; i++) {
            emitRealTerm(ctx.realTerm(i));
            if (i != 0) {
                if (ctx.realAddOp(i-1).getText().equals("+")) {
                    emit(Instruction.FADD);
                }
                else if (ctx.realAddOp(i-1).getText().equals("-")) {
                    emit(Instruction.FSUB);
                }
//                else if (ctx.realAddOp(i-1).getText().equals("||")) {
//                    emit(INVOKESTATIC, "library/Matrix/booleanOr(FF)F");
//                }
            }
        }
    }

    public void emitRealTerm(NeoParser.RealTermContext ctx) {
        int numberOfFactors = ctx.realFactor().size();
        for (int i = 0; i < numberOfFactors; i++) {
            emitRealFactor(ctx.realFactor(i));
            if (i != 0) {
                if (ctx.realMulOp(i-1).getText().equals("*") || ctx.realMulOp(i-1).getText().equals("&&")) {    // nice shortcut
                    emit(Instruction.FMUL);
                }
                else if (ctx.realMulOp(i-1).getText().equals("/")) {
                    emit(Instruction.FDIV);
                }
            }
        }
    }

    public void emitRealFactor(NeoParser.RealFactorContext ctx) {
        if (ctx.realVariable() != null) {   // is real var
            emitRealVariable(ctx.realVariable());
        }
        else if (ctx.realNumber() != null) {   // is real constant
            emitRealNumber(ctx.realNumber());
        }
        else if (ctx.matrixEntry() != null) {   // is matrix entry
            emitMatrixEntry(ctx.matrixEntry());
        }
        else if (ctx.realFunctionCall() != null) {  // is function call
            emitRealFunctionCall(ctx.realFunctionCall());
        }
        else if (ctx.detTerm() != null){
            emitMatrixVariable(ctx.detTerm().matrixVariable());
            emit(INVOKESTATIC, "library/Matrix/determinant(Llibrary/Matrix;)F");
        }
//        else if (ctx.realFactor() != null) {    // is a not statement
//            emitRealFactor(ctx.realFactor());
//            emit(INVOKESTATIC, "library/Matrix/booleanNot(F)F");
//        }
        else {                                  // is parenthesized realExpression
            emitRealExpression(ctx.realExpression());
        }
    }

    public void emitRealVariable(NeoParser.RealVariableContext ctx) {
        String varName = ctx.getText();
        int slotNumber = CodeGenerator.currentLocalVariables.lookup(varName).getSlotNumber();
        emit(Instruction.FLOAD, slotNumber);
    }

    public void emitRealNumber(NeoParser.RealNumberContext ctx) {
        boolean positive = true;
        if (ctx.getText().charAt(0) == '-') positive = false;
        int integerPart = Integer.parseInt(ctx.integer(0).getText());
        int nonIntegerPartTemp = Integer.parseInt(ctx.integer(1).getText());
        int lengthOfNonIntegerPart = ctx.integer(1).getText().length();
        int numberToDivideBy = (int) Math.pow(10,lengthOfNonIntegerPart);
        float nonIntegerPart = nonIntegerPartTemp / (float) numberToDivideBy;
        float realNumber = positive ? integerPart + nonIntegerPart : (-1)*(integerPart + nonIntegerPart);
        emit(Instruction.LDC, realNumber);
    }

    public void emitMatrixEntry(NeoParser.MatrixEntryContext ctx) {
        NeoParser.MatrixVariableContext matCtx = ctx.matrixVariable();
        String varName = matCtx.getText();
        int slotNumber = CodeGenerator.currentLocalVariables.lookup(varName).getSlotNumber();

        // emit matrix, then row, then col
        emit(Instruction.ALOAD, slotNumber);
        emitRealExpression(ctx.realExpression(0));
        emitRealExpression(ctx.realExpression((1)));

        emit(INVOKESTATIC, "library/Matrix/getEntry(Llibrary/Matrix;FF)F");
    }

    public void emitRealFunctionCall(NeoParser.RealFunctionCallContext ctx) {
        compiler.visitArgumentList(ctx.argumentList());
        String functionSignature = new String();
        functionSignature += "(";
        for(NeoParser.ArgumentContext argCtx: ctx.argumentList().argument()){
            if(argCtx.expression().realExpression().size() > 0){
                functionSignature += "F";
            }
            else{
                functionSignature += "Llibrary/Matrix;";
            }
        }
        functionSignature += ")F";
        emit(INVOKESTATIC, programName +  "/" + ctx.realFunctionName().getText() + functionSignature);
    }

    public void emitMatrixExpression(NeoParser.MatrixExpressionContext ctx) {
        int numberOfTerms = ctx.matrixTerm().size();
        for (int i = 0; i < numberOfTerms; i++) {
            emitMatrixTerm(ctx.matrixTerm(i));
            if (i != 0) {
                if (ctx.matrixAddOp(i-1).getText().equals("+")) {
                    emit(INVOKESTATIC, "library/Matrix/add(Llibrary/Matrix;Llibrary/Matrix;)Llibrary/Matrix;");
                }
                else if (ctx.matrixAddOp(i-1).getText().equals("-")) {
                    emit(INVOKESTATIC, "library/Matrix/sub(Llibrary/Matrix;Llibrary/Matrix;)Llibrary/Matrix;");
                }
                else if (ctx.matrixAddOp(i-1).getText().equals("||")) {
                    emit(INVOKESTATIC, "library/Matrix/booleanOr(FF)F");
                }
            }
        }
    }

    public void emitMatrixTerm(NeoParser.MatrixTermContext ctx) {
        int numberOfFactors = ctx.matrixFactor().size();
        for (int i = 0; i < numberOfFactors; i++) {
            emitMatrixFactor(ctx.matrixFactor(i));
            if (i != 0) {
                if (ctx.matrixMulOp(i-1).getText().equals("*")) {
                    emit(INVOKESTATIC, "library/Matrix/mult(Llibrary/Matrix;Llibrary/Matrix;)Llibrary/Matrix;");
                }
                else if (ctx.matrixMulOp(i-1).getText().equals("&&")) {
                    emit(Instruction.FMUL);
                }

            }
        }
    }

    public void emitMatrixFactor(NeoParser.MatrixFactorContext ctx) {
        if (ctx.matrixVariable() != null) {     // is matrix variable
            emitMatrixVariable(ctx.matrixVariable());
        }
        else if (ctx.matrixFunctionCall() != null) {     // is function call
            emitMatrixFunctionCall(ctx.matrixFunctionCall());
        }
        else if (ctx.invTerm() != null){
            emitMatrixVariable(ctx.invTerm().matrixVariable());
            emit(INVOKESTATIC, "library/Matrix/inverse(Llibrary/Matrix;)Llibrary/Matrix;");
        }
//        else if (ctx.matrixFactor() != null) {      // is not statement
//            emitMatrixFactor(ctx.matrixFactor());
//            emit(INVOKESTATIC, "library/Matrix/booleanNot(F)F");
//        }
        else if (ctx.matrixExpression() != null) {   // is parenthesized matrix expression
            emitMatrixExpression(ctx.matrixExpression());
        }
    }

    public void emitMatrixVariable(NeoParser.MatrixVariableContext ctx) {
        int slotNumber = CodeGenerator.currentLocalVariables.lookup(ctx.getText()).getSlotNumber();
        emit(Instruction.ALOAD, slotNumber);
    }

    public void emitMatrixFunctionCall(NeoParser.MatrixFunctionCallContext ctx) {
        compiler.visitArgumentList(ctx.argumentList());
        String functionSignature = new String();
        functionSignature += "(";
        for(NeoParser.ArgumentContext argCtx: ctx.argumentList().argument()){
            if(argCtx.expression().realExpression().size() > 0){
                functionSignature += "F";
            }
            else{
                functionSignature += "Llibrary/Matrix;";
            }
        }
        functionSignature += ")Llibrary/Matrix;";
        emit(INVOKESTATIC, programName +  "/" + ctx.matrixFunctionName().getText() + functionSignature);
    }

    public void emitBooleanExpression(NeoParser.BooleanExpressionContext ctx) {
        int numberOfTerms = ctx.booleanTerm().size();
        for (int i = 0; i < numberOfTerms; i++) {
            emitBooleanTerm(ctx.booleanTerm(i));
            if (i != 0) {
                emit(INVOKESTATIC, "library/Matrix/booleanOr(FF)F");
            }
        }
    }

    public void emitBooleanTerm(NeoParser.BooleanTermContext ctx) {
        int numberOfFactors = ctx.booleanFactor().size();
        for (int i = 0; i < numberOfFactors; i++) {
            emitBooleanFactor(ctx.booleanFactor(i));
            if (i != 0) {
                emit(Instruction.FMUL);
            }
        }
    }

    public void emitBooleanFactor(NeoParser.BooleanFactorContext ctx){
        compiler.visitExpression(ctx.expression());
        // logic to check !
        if(ctx.getText().charAt(0) == '!')
            emit(INVOKESTATIC, "library/Matrix/booleanNot(F)F");
    }
}
