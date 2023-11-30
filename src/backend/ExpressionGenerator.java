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


    // TODO: some of these emit methods related to real expressions do not yet consider boolean operations

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
    }

    public void emitRealVariable(NeoParser.RealVariableContext ctx) {
        String varName = ctx.getText();
        int slotNumber = CodeGenerator.currentLocalVariables.lookup(varName).getSlotNumber();
        emit(Instruction.FLOAD, slotNumber);
    }
}
