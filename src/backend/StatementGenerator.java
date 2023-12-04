package backend;

import intermediate.symtab.Predefined;
import intermediate.type.Typespec;
import antlr4.*;

import java.beans.Expression;

import static backend.Instruction.*;
import static com.sun.org.apache.bcel.internal.classfile.Utility.convertString;
//import static intermediate.type.Typespec.Form.ENUMERATION;
//import static intermediate.type.Typespec.Form.SCALAR;

public class StatementGenerator extends CodeGenerator {
    /**
     * Constructor.
     * @param parent the parent generator.
     * @param compiler the compiler to use.
     */
    public StatementGenerator(CodeGenerator parent, Compiler compiler)
    {
        super(parent, compiler);
    }


    public void emitAssignment(NeoParser.AssignmentStatementContext ctx) {
        if (ctx.lhs().variable() != null && ctx.lhs().variable().realVariable() != null) {          // if lhs is real var
            compiler.visitExpression(ctx.rhs().expression());

            NeoParser.RealVariableContext realVarCtx = ctx.lhs().variable().realVariable();
            String varName = realVarCtx.getText();
            int slotNumber = CodeGenerator.currentLocalVariables.lookup(varName).getSlotNumber();

            emitStoreLocal(Predefined.realType, slotNumber);

        } else if (ctx.lhs().variable() != null && ctx.lhs().variable().matrixVariable() != null) {   // if lhs is matrix var
            compiler.visitExpression(ctx.rhs().expression());

            NeoParser.MatrixVariableContext matVarCtx = ctx.lhs().variable().matrixVariable();
            String varName = matVarCtx.getText();
            int slotNumber = CodeGenerator.currentLocalVariables.lookup(varName).getSlotNumber();

            emitStoreLocal(Predefined.matrixType, slotNumber);
        } else {      // lhs is matrix entry
            //Emit Matrix
            NeoParser.MatrixEntryContext matEntryCtx = ctx.lhs().matrixEntry();
            String varName = matEntryCtx.matrixVariable().getText();
            int slotNumber = CodeGenerator.currentLocalVariables.lookup(varName).getSlotNumber();
            emit(ALOAD, slotNumber);

            //Emit Row and Col
            compiler.expressionCode.emitRealExpression(matEntryCtx.realExpression(0));
            compiler.expressionCode.emitRealExpression(matEntryCtx.realExpression(1));
//            emit(FLOAD, matEntryCtx.realExpression(0).getText());
//            emit(FLOAD, matEntryCtx.realExpression(1).getText());

//            //Emit RHS
//            emitStoreLocal(Predefined.matrixType, slotNumber);

            compiler.visitExpression(ctx.rhs().expression());
            emit(INVOKESTATIC, "library/Matrix/setEntry(Llibrary/Matrix;FFF)V");
        }
    }

    public void emitIfStatement(NeoParser.IfStatementContext ctx) {
        Label thenLabel = new Label();
        Label falseLabel = new Label();
        Label nextLabel = new Label();

        compiler.visitExpression(ctx.expression());

        if (ctx.ELSE() == null) {       // has no ELSE block
            //emit(INVOKESTATIC, "java/lang/math/round(F)I");
            emit(INVOKESTATIC, "library/Matrix/floatToInt(F)I");
            emit(IFEQ, nextLabel);
            emitLabel(thenLabel);
            compiler.visit(ctx.compoundStatement(0));   // if true
            emitLabel(nextLabel);
        }
        else {                          // has an ELSE block
            //emit(INVOKESTATIC, "java/lang/math/round(F)I");
            emit(INVOKESTATIC, "library/Matrix/floatToInt(F)I");
            emit(IFEQ, falseLabel);
            emitLabel(thenLabel);
            compiler.visit(ctx.compoundStatement(0));   // if true
            emit(GOTO, nextLabel);
            emitLabel(falseLabel);
            compiler.visit(ctx.compoundStatement(1));   // if false
            emitLabel(nextLabel);
        }
    }

    public void emitWhileStatement(NeoParser.WhileStatementContext ctx) {
        Label loopLabel = new Label();
        Label loopExitLabel = new Label();
        emitLabel(loopLabel);
        compiler.visit(ctx.expression());
        emit(INVOKESTATIC, "library/Matrix/floatToInt(F)I");
        emit(IFEQ, loopExitLabel);

        compiler.visit(ctx.compoundStatement());
        emit(GOTO, loopLabel);
        emitLabel(loopExitLabel);
    }

    public void emitPrintStatement(NeoParser.PrintStatementContext argsCtx){
        if(argsCtx.variable().realVariable() == null){
            emitPrintMatrixVariable(argsCtx);
        }
        else{
            emitPrintRealVariable(argsCtx);
        }
    }

    public void emitPrintMatrixVariable(NeoParser.PrintStatementContext argsCtx){
//        emit(GETSTATIC, "library/Matrix");

        String matrixName = argsCtx.variable().matrixVariable().getText();
        int slotNumber = CodeGenerator.currentLocalVariables.lookup(matrixName).getSlotNumber();

        emit(ALOAD, slotNumber);

        emit(INVOKESTATIC, "library/Matrix/printMatrix(Llibrary/Matrix;)V");
    }

    public void emitPrintRealVariable(NeoParser.PrintStatementContext argsCtx)
    {
        boolean needLF = true;
        emit(GETSTATIC, "java/lang/System/out", "Ljava/io/PrintStream;");

        // WRITELN with no arguments.
        if (argsCtx == null)
        {
            emit(INVOKEVIRTUAL, "java/io/PrintStream.println()V");
            localStack.decrease(1);
        }

        // Generate code for the arguments.
        else
        {
            StringBuffer format = new StringBuffer();
            int exprCount = createWriteFormat(argsCtx, format, needLF);

            // Load the format string.
            emit(LDC, format.toString());

            // Emit the arguments array.
            if (exprCount > 0)
            {
                emitArgumentsArray(argsCtx, exprCount);

                emit(INVOKEVIRTUAL,
                        "java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)" +
                                "Ljava/io/PrintStream;");
                localStack.decrease(2);
                emit(POP);
            }
            else
            {
                emit(INVOKEVIRTUAL,
                        "java/io/PrintStream/print(Ljava/lang/String;)V");
                localStack.decrease(2);
            }
        }
    }

    /**
     * Create the printf format string.
     * @param ctx the WriteArgumentsContext.
     * @param format the format string to create.
     * @return the count of expression arguments.
     */
    public int createWriteFormat(NeoParser.PrintStatementContext ctx,
                                  StringBuffer format, boolean needLF)
    {
        int exprCount = 0;
        format.append("\"");

        // Loop over the write arguments.
//        for (NeoParser.PrintStatementContext argCtx : argsCtx.writeArgument())
//        {

        Typespec type = ctx.variable().matrixVariable() != null ? Predefined.matrixType: Predefined.realType;
        String argText = ctx.variable().getText();

        // Append any literal strings.
        if (argText.charAt(0) == '\'')
        {
            format.append(convertString(argText));
        }

        // For any other expressions, append a field specifier.
        else
        {
            exprCount++;
            format.append("%");

//            NeoParser.FieldWidthContext fwCtx = ctx.fieldWidth();
//            if (fwCtx != null)
//            {
//                String sign = (   (fwCtx.sign() != null)
//                        && (fwCtx.sign().getText().equals("-")))
//                        ? "-" : "";
//                format.append(sign)
//                        .append(fwCtx.integerConstant().getText());
//
//                PascalParser.DecimalPlacesContext dpCtx =
//                        fwCtx.decimalPlaces();
//                if (dpCtx != null)
//                {
//                    format.append(".")
//                            .append(dpCtx.integerConstant().getText());
//                }
//            }

//            String typeFlag = type == Predefined.realType ? "f"
//                    : type == Predefined.realType    ? "f"
//                    : type == Predefined.booleanType ? "b"
//                    : type == Predefined.charType    ? "c"
//                    :                                  "s";
            String typeFlag = "f";

            format.append(typeFlag);
        }
        //}

        format.append(needLF ? "\\n\"" : "\"");

        return exprCount;
    }

    /**
     * Emit the printf arguments array.
     * @param ctx
     * @param exprCount
     */
    public void emitArgumentsArray(NeoParser.PrintStatementContext ctx,
                                    int exprCount)
    {
        // Create the arguments array.
        emitLoadConstant(exprCount);
        emit(ANEWARRAY, "java/lang/Object");

        int index = 0;

        // Loop over the write arguments to fill the arguments array.
//        for (NeoParser.PrintStatementContext argCtx :
//                argsCtx.writeArgument())
//
        String argText = ctx.variable().getText();
//        PascalParser.ExpressionContext exprCtx = argCtx.expression();
//        Typespec type = exprCtx.type.baseType();
        Typespec type = ctx.variable().matrixVariable() != null ? Predefined.matrixType: Predefined.realType;

        // Skip string constants, which were made part of
        // the format string.
        if (argText.charAt(0) != '\'')
        {
            emit(DUP);
            emitLoadConstant(index++);

//            compiler.visit(ctx.variable());
            emit(FLOAD, CodeGenerator.currentLocalVariables.lookup(argText).getSlotNumber());

//            Typespec.Form form = type.getForm();
//            if (    ((type == SCALAR) || (type == ENUMERATION))
//                    && (type != Predefined.stringType))
//            {
//                emit(INVOKESTATIC, valueOfSignature(type));
//            }
            if(type == Predefined.realType){
                emit(INVOKESTATIC, valueOfSignature(type));
            }
            // Store the value into the array.
            emit(AASTORE);
        }

    }






//
//    /**
//     * Emit code for a call to WRITE or WRITELN.
//     * @param argsCtx the WriteArgumentsContext.
//     * @param needLF true if need a line feed.
//     */
//    public void emitPrintStatement(NeoParser.PrintStatementContext ctx)
//    {
//        boolean needLF = true;
//        emit(GETSTATIC, "java/lang/System/out", "Ljava/io/PrintStream;");
//
//        // WRITELN with no arguments.
//        if (ctx.variable() == null) //Todo
//        {
//            emit(INVOKEVIRTUAL, "java/io/PrintStream.println()V");
//            localStack.decrease(1);
//        }
//
//        // Generate code for the arguments.
//        else
//        {
//            StringBuffer format = new StringBuffer();
//            //int exprCount = createWriteFormat(ctx, format, needLF);
//            if(ctx.variable().realVariable() != null) {
////                format.append(ctx.variable().realVariable().getText());
//                format.append("%f\n");
//                emit(INVOKESTATIC, "java/lang/Float/valueOf(F)Ljava/lang/Float;");
//            }
//            else {
//                //Todo: if matrix
//            }
//            int slotNum = CodeGenerator.currentLocalVariables.lookup(ctx.variable().realVariable().getText()).getSlotNumber();
//            // Load the format string.
//            emit(FLOAD, slotNum);
//            emit(AASTORE);
//
//            // Emit the arguments array.
//            if (exprCount > 0)
//            {
//                emitArgumentsArray(ctx, exprCount);
//
//                emit(INVOKEVIRTUAL,
//                        "java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)" +
//                                "Ljava/io/PrintStream;");
//                localStack.decrease(2);
//                emit(POP);
//            }
//            else
//            {
//                emit(INVOKEVIRTUAL,
//                        "java/io/PrintStream/print(Ljava/lang/String;)V");
//                localStack.decrease(2);
//            }
//            emit(INVOKEVIRTUAL, "java/io/PrintStream/printf(Ljava/lang/String;[Ljava/lang/Object;)" +
//                                "Ljava/io/PrintStream;");
//            localStack.decrease(2);
//        }
//    }
//
//    /**
//     * Create the printf format string.
//     * @param argsCtx the WriteArgumentsContext.
//     * @param format the format string to create.
//     * @return the count of expression arguments.
//     */
//    private int createWriteFormat(NeoParser.PrintStatementContext ctx,
//                                  StringBuffer format, boolean needLF)
//    {
//        int exprCount = 0;
//        format.append("\"");
//
//        // Loop over the write arguments.
//        for (NeoParser.ExpressionContext argCtx : ctx.writeArgument())
//        {
//            Typespec type = argCtx.expression().type;
//            String argText = argCtx.getText();
//
//            // Append any literal strings.
//            if (argText.charAt(0) == '\'')
//            {
//                format.append(convertString(argText));
//            }
//
//            // For any other expressions, append a field specifier.
//            else
//            {
//                exprCount++;
//                format.append("%");
//
//                PascalParser.FieldWidthContext fwCtx = argCtx.fieldWidth();
//                if (fwCtx != null)
//                {
//                    String sign = (   (fwCtx.sign() != null)
//                            && (fwCtx.sign().getText().equals("-")))
//                            ? "-" : "";
//                    format.append(sign)
//                            .append(fwCtx.integerConstant().getText());
//
//                    PascalParser.DecimalPlacesContext dpCtx =
//                            fwCtx.decimalPlaces();
//                    if (dpCtx != null)
//                    {
//                        format.append(".")
//                                .append(dpCtx.integerConstant().getText());
//                    }
//                }
//
//                String typeFlag = type == Predefined.integerType ? "d"
//                        : type == Predefined.realType    ? "f"
//                        : type == Predefined.booleanType ? "b"
//                        : type == Predefined.charType    ? "c"
//                        :                                  "s";
//                format.append(typeFlag);
//            }
//        }
//
//        format.append(needLF ? "\\n\"" : "\"");
//
//        return exprCount;
//    }
//
//    /**
//     * Emit the printf arguments array.
//     * @param argsCtx
//     * @param exprCount
//     */
//    private void emitArgumentsArray(NeoParser.PrintStatementContext ctx,
//                                    int exprCount)
//    {
//        // Create the arguments array.
//        emitLoadConstant(exprCount);
//        emit(ANEWARRAY, "java/lang/Object");
//
//        int index = 0;
//
//        // Loop over the write arguments to fill the arguments array.
//        for (NeoParser.WriteArgumentContext argCtx :
//                ctx.writeArgument())
//        {
//            String argText = argCtx.getText();
//            PascalParser.ExpressionContext exprCtx = argCtx.expression();
//            Typespec type = exprCtx.type.baseType();
//
//            // Skip string constants, which were made part of
//            // the format string.
//            if (argText.charAt(0) != '\'')
//            {
//                emit(DUP);
//                emitLoadConstant(index++);
//
//                compiler.visit(exprCtx);
//
//                Typespec.Form form = type.getForm();
//                if (    ((form == SCALAR) || (form == ENUMERATION))
//                        && (type != Predefined.stringType))
//                {
//                    emit(INVOKESTATIC, valueOfSignature(type));
//                }
//
//                // Store the value into the array.
//                emit(AASTORE);
//            }
//        }
//    }









//        PascalParser.VariableContext   varCtx  = ctx.lhs().variable();
//        PascalParser.ExpressionContext exprCtx = ctx.rhs().expression();
//        SymtabEntry varId = varCtx.entry;
//        Typespec varType  = varCtx.type;
//        Typespec exprType = exprCtx.type;
//
//        // The last modifier, if any, is the variable's last subscript or field.
//        int modifierCount = varCtx.modifier().size();
//        PascalParser.ModifierContext lastModCtx = modifierCount == 0
//                ? null : varCtx.modifier().get(modifierCount - 1);
//
//        // The target variable has subscripts and/or fields.
//        if (modifierCount > 0)
//        {
//            lastModCtx = varCtx.modifier().get(modifierCount - 1);
//            compiler.visit(varCtx);
//        }
//
//        // Emit code to evaluate the expression.
//        compiler.visit(exprCtx);
//
//        // float variable := integer constant
//        if (   (varType == Predefined.realType)
//                && (exprType.baseType() == Predefined.integerType)) emit(I2F);
//
//        // Emit code to store the expression value into the target variable.
//        // The target variable has no subscripts or fields.
//        if (lastModCtx == null) emitStoreValue(varId, varId.getType());
//
//            // The target variable is a field.
//        else if (lastModCtx.field() != null)
//        {
//            emitStoreValue(lastModCtx.field().entry, lastModCtx.field().type);
//        }
//
//        // The target variable is an array element.
//        else
//        {
//            emitStoreValue(null, varType);
//        }
//    }

}
