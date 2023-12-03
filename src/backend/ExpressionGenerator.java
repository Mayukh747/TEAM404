package backend;

import antlr4.*;
import backend.Instruction.*;
import frontend.SemanticErrorHandler;

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


    // TODO: some of these emit methods related to real expressions do not yet consider boolean operations and function calls

    public void emitRealExpression(NeoParser.RealExpressionContext ctx) {
        int numberOfTerms = ctx.realTerm().size();
        for (int i = 0; i < numberOfTerms; i++) {
            emitRealTerm(ctx.realTerm(i));
            if (i != 0) {
                if (ctx.realAddOp(i-1).getText().equals("+")) {
                    emit(Instruction.FADD);
                }
                if (ctx.realAddOp(i-1).getText().equals("-")) {
                    emit(Instruction.FSUB);
                }
            }
        }
    }

    public void emitRealTerm(NeoParser.RealTermContext ctx) {
        int numberOfFactors = ctx.realFactor().size();
        for (int i = 0; i < numberOfFactors; i++) {
            emitRealFactor(ctx.realFactor(i));
            if (i != 0) {
                if (ctx.realMulOp(i-1).getText().equals("*")) {
                    emit(Instruction.FMUL);
                }
                if (ctx.realMulOp(i-1).getText().equals("/")) {
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
        // TODO other cases
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

    }

    // TODO: for now ignoring subtraction and division for matrices. Maybe we will just remove that from the grammar.

    public void emitMatrixExpression(NeoParser.MatrixExpressionContext ctx) {
        int numberOfTerms = ctx.matrixTerm().size();
        for (int i = 0; i < numberOfTerms; i++) {
            emitMatrixTerm(ctx.matrixTerm(i));
            if (i != 0) {
                emit(Instruction.INVOKESTATIC, "library/Matrix/add(Llibrary/Matrix;Llibrary/Matrix;)Llibrary/Matrix;");
            }
        }
    }

    public void emitMatrixTerm(NeoParser.MatrixTermContext ctx) {
        int numberOfFactors = ctx.matrixFactor().size();
        for (int i = 0; i < numberOfFactors; i++) {
            emitMatrixFactor(ctx.matrixFactor(i));
            if (i != 0) {
                emit(Instruction.INVOKESTATIC, "library/Matrix/mult(Llibrary/Matrix;Llibrary/Matrix;)Llibrary/Matrix;");
            }
        }
    }

    public void emitMatrixFactor(NeoParser.MatrixFactorContext ctx) {
        if (ctx.matrixVariable() != null) {     // if is matrix variable
            emitMatrixVariable(ctx.matrixVariable());
        }
        // TODO other cases
    }

    public void emitMatrixVariable(NeoParser.MatrixVariableContext ctx) {
        int slotNumber = CodeGenerator.currentLocalVariables.lookup(ctx.getText()).getSlotNumber();
        emit(Instruction.ALOAD, slotNumber);
    }
}
