package backend;

import intermediate.symtab.Predefined;
import intermediate.symtab.SymtabEntry;
import intermediate.type.Type;
import intermediate.type.Typespec;
import antlr4.*;

import java.util.List;

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

            // for sake of debugging
            NeoParser.RealVariableContext varCtx = ctx.lhs().variable().realVariable();
            String varName = varCtx.getText();
            int slotNumber = CodeGenerator.currentLocalVariables.lookup(varName).getSlotNumber();

            emitStoreLocal(Predefined.realType, slotNumber);
            System.out.println("emitted store for " + varName + ", slot number " + slotNumber);

        } else if (ctx.lhs().variable() != null && ctx.lhs().variable().matrixVariable() != null) {   // if lhs is matrix var
            // TODO
        } else {      // lhs is matrix entry
            // TODO
        }

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
    }

}
