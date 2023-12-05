package backend;

import intermediate.symtab.Predefined;
import intermediate.symtab.Symtab;
import intermediate.symtab.SymtabEntry;
import antlr4.*;
import intermediate.type.Typespec;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static backend.Directive.*;
import static backend.Instruction.*;


public class ProgramGenerator extends CodeGenerator {
    private SymtabEntry programId;   // symbol table entry of the program name
    private int programLocalsCount;  // count of program local variables


    /**
     * Constructor.
     * @param parent generator.
     * @param compiler the compiler to use.
     */
    public ProgramGenerator(CodeGenerator parent, Compiler compiler)
    {
        super(parent, compiler);

        localStack = new LocalStack();
        programLocalsCount = 5;  // +1 because _elapsed is long

    }

    /**
     * Emit code for a program.
     * @param ctx the ProgramContext.
     */
    public void emitProgram(NeoParser.ProgramContext ctx)
    {
        programId = ctx.programHeader().programIdentifier().entry;
        // Symtab programSymtab = programId.getRoutineSymtab();

        localVariables = new LocalVariables(programLocalsCount);

        // emitRecords(programSymtab);

        emitDirective(CLASS_PUBLIC, programName);
        emitDirective(SUPER, "java/lang/Object");

        emitProgramVariables();
        emitInputScanner();
        emitConstructor();
        // emitSubroutines(ctx.block().declarations().routinesPart());

        compiler.visitFunctionDefinitionList(ctx.functionDefinitionList());

        emitMainMethod(ctx);
    }

    /**
     * Emit field directives for the program variables.
     */
    private void emitProgramVariables()
    {
        // Runtime timer and standard in.

        // Symtab symtab = programId.getRoutineSymtab();
        // ArrayList<SymtabEntry> ids = symtab.sortedEntries();

        emitLine();
        emitDirective(FIELD_PRIVATE_STATIC, "_sysin", "Ljava/util/Scanner;");

//        // Loop over all the program's identifiers and
//        // emit a .field directive for each variable.
//        for (SymtabEntry id : ids)
//        {
//            if (id.getKind() == VARIABLE)
//            {
//                emitDirective(FIELD_PRIVATE_STATIC, id.getName(),
//                        typeDescriptor(id));
//            }
//        }
    }

    /**
     * Emit code for the runtime input scanner.
     */
    private void emitInputScanner()
    {
        emitLine();
        emitComment("Runtime input scanner");
        emitDirective(METHOD_STATIC, "<clinit>()V");
        emitLine();

        emit(NEW, "java/util/Scanner");
        emit(DUP);
        emit(GETSTATIC, "java/lang/System/in Ljava/io/InputStream;");
        emit(INVOKESPECIAL, "java/util/Scanner/<init>(Ljava/io/InputStream;)V");
        emit(PUTSTATIC, programName + "/_sysin Ljava/util/Scanner;");
        emit(RETURN);

        emitLine();
        emitDirective(LIMIT_LOCALS, 0);
        emitDirective(LIMIT_STACK,  3);
        emitDirective(END_METHOD);

        localStack.reset();
    }

    /**
     * Emit code for the main program constructor.
     */
    private void emitConstructor()
    {
        emitLine();
        emitComment("Main class constructor");
        emitDirective(METHOD_PUBLIC, "<init>()V");
        emitDirective(VAR, "0 is this L" + programName + ";");
        emitLine();

        emit(ALOAD_0);
        emit(INVOKESPECIAL, "java/lang/Object/<init>()V");
        emit(RETURN);

        emitLine();
        emitDirective(LIMIT_LOCALS, 1);
        emitDirective(LIMIT_STACK,  1);
        emitDirective(END_METHOD);

        localStack.reset();
    }

    /**
     * Emit code for the program body as the main method.
     * @param ctx the ProgramContext.
     */
    private void emitMainMethod(NeoParser.ProgramContext ctx)
    {
        // make new currentLocalVariables symtab
        CodeGenerator.currentLocalVariables = new Symtab(1);

        emitLine();
        emitComment("MAIN");
        emitDirective(METHOD_PUBLIC_STATIC,
                "main([Ljava/lang/String;)V");

        emitDirective(VAR, "0 is args [Ljava/lang/String;");
        emitDirective(VAR, "1 is _start Ljava/time/Instant;");
        emitDirective(VAR, "2 is _end Ljava/time/Instant;");
        emitDirective(VAR, "3 is _elapsed J");
        // handle the variable declaration list
        List<NeoParser.VariableContext> varCtxList = ctx.variableDeclarationList().variableList().variable();
        for (int i = 0; i < varCtxList.size(); i++) {
            if (varCtxList.get(i).realVariable() != null) {     // if real var
                CodeGenerator.currentLocalVariables.enter((varCtxList.get(i).realVariable().getText()), i+4);
            }
            else {
                CodeGenerator.currentLocalVariables.enter((varCtxList.get(i).matrixVariable().getText()), i+4);
            }
        }
        // emit a .var directive for each variable
        for (int slotNumber = 4; slotNumber < varCtxList.size() + 4; slotNumber++) {    // start at 4 because already emitted 4 vars in emitMainPrologue
            String varName = varCtxList.get(slotNumber - 4).getText();
            emitDirective(VAR, slotNumber + " is " + varName, typeDescriptor(varName));
        }


        emitMainPrologue(programId);

        // initialize variables to default values
        List<NeoParser.VariableContext> declaredVariableList = ctx.variableDeclarationList().variableList().variable();
        for (int i = 0; i < declaredVariableList.size(); i++) {
            NeoParser.VariableContext varCtx = declaredVariableList.get(i);
            int slotNumber = i + 4;   // because 4 things placed automatically in front in main method
            if (varCtx.realVariable() != null) {    // if real var
                // set to 0
                emit(LDC, 0.0f);
                emit(FSTORE, slotNumber);
            }
            else if (varCtx.matrixVariable() != null) {
                int matrixSize = Integer.parseInt(varCtx.matrixVariable().INTEGER().getText());
                emit(NEW, "library/Matrix");
                emit(DUP);
                emit(LDC, matrixSize);
                emit(INVOKESPECIAL, "library/Matrix/<init>(I)V");
                emit(ASTORE, slotNumber);
                emit(ALOAD, slotNumber);
            }
        }



        // Emit code to allocate any arrays, records, and strings.
        // StructuredDataGenerator structureCode =
        //         new StructuredDataGenerator(this, compiler);
        // structureCode.emitData(programId);

        // Emit code for the compound statement.
        emitLine();
        compiler.visit(ctx.compoundStatement());    // TODO: not sure if right

        emitMainEpilogue();
    }

    /**
     * Emit the main method prologue.
     * @parm programId the symbol table entry for the program name.
     */
    private void emitMainPrologue(SymtabEntry programId)
    {
//        emitDirective(VAR, "0 is args [Ljava/lang/String;");
//        emitDirective(VAR, "1 is _start Ljava/time/Instant;");
//        emitDirective(VAR, "2 is _end Ljava/time/Instant;");
//        emitDirective(VAR, "3 is _elapsed J");

        // Runtime timer.
        emitLine();
        emit(INVOKESTATIC, "java/time/Instant/now()Ljava/time/Instant;");
        localStack.increase(1);
        emit(ASTORE_1);
    }

    /**
     * Emit the main method epilogue.
     */
    private void emitMainEpilogue()
    {
        // Print the execution time.
        emitLine();
        emit(INVOKESTATIC, "java/time/Instant/now()Ljava/time/Instant;");
        localStack.increase(1);
        emit(ASTORE_2);
        emit(ALOAD_1);
        emit(ALOAD_2);
        emit(INVOKESTATIC, "java/time/Duration/between(Ljava/time/temporal/Temporal;" +
                "Ljava/time/temporal/Temporal;)Ljava/time/Duration;");
        localStack.decrease(1);
        emit(INVOKEVIRTUAL, "java/time/Duration/toMillis()J");
        localStack.increase(1);
        emit(LSTORE_3);
        emit(GETSTATIC, "java/lang/System/out Ljava/io/PrintStream;");
        emit(LDC, "\"\\n[%,d milliseconds execution time.]\\n\"");
        emit(ICONST_1);
        emit(ANEWARRAY, "java/lang/Object");
        emit(DUP);
        emit(ICONST_0);
        emit(LLOAD_3);
        emit(INVOKESTATIC, "java/lang/Long/valueOf(J)Ljava/lang/Long;");
        emit(AASTORE);
        emit(INVOKEVIRTUAL, "java/io/PrintStream/printf(Ljava/lang/String;" +
                "[Ljava/lang/Object;)Ljava/io/PrintStream;");
        localStack.decrease(2);
        emit(POP);

        emitLine();
        emit(RETURN);
        emitLine();

        emitDirective(LIMIT_LOCALS, localVariables.count() + 100);    // TODO: overkill +5 to get rid of an error. Maybe not the right way to do it.
        emitDirective(LIMIT_STACK,  localStack.capacity() + 10);     // TODO: Make sure this is where we should add 1
        emitDirective(END_METHOD);

        close();  // the object file
    }

    public void emitRealFunctionDefinition(NeoParser.RealFunctionDefinitionContext ctx) {
        // make new currentLocalVariables symtab
        CodeGenerator.currentLocalVariables = new Symtab(1);
        CodeGenerator.currentLocalVariables.enter(ctx.realFunctionName().getText(), 0);    // for sake of returning

        emitRealFunctionHeader(ctx);
        emitRealFunctionLocals(ctx);

        localVariables = new LocalVariables(  // argument is number of local variables we want: # parameters + # declared vars ? I think?
                ctx.variableList().variable().size() + ctx.variableDeclarationList().variableList().variable().size());

        compiler.visit(ctx.variableDeclarationList());

        // initialize variables to default values
        int numOfParameters = ctx.variableList().variable().size();
        List<NeoParser.VariableContext> declaredVariableList = ctx.variableDeclarationList().variableList().variable();
        for (int i = 0; i < declaredVariableList.size(); i++) {
            NeoParser.VariableContext varCtx = declaredVariableList.get(i);
            int slotNumber = i + numOfParameters;   // followed by parameters
            if (varCtx.realVariable() != null) {    // if real var
                // set to 0
                emit(LDC, 0.0f);
                emit(FSTORE, slotNumber);
            }
            else if (varCtx.matrixVariable() != null) {
                int matrixSize = Integer.parseInt(varCtx.matrixVariable().INTEGER().getText());
                emit(NEW, "library/Matrix");
                emit(DUP);
                emit(LDC, matrixSize);
                emit(INVOKESPECIAL, "library/Matrix/<init>(I)V");
                emit(ASTORE, slotNumber);
                emit(ALOAD, slotNumber);
            }
        }

        compiler.visit(ctx.compoundStatement());

        emitRealFunctionReturn(ctx);
        emitFunctionEpilogue();
    }

    public void emitRealFunctionHeader(NeoParser.RealFunctionDefinitionContext ctx) {
        String functionName = ctx.realFunctionName().getText();
        List<NeoParser.VariableContext> parmCtxs = ctx.variableList().variable();
        StringBuilder buffer = new StringBuilder();

        // function name.
        buffer.append(functionName);
        buffer.append("(");

        // Parameter and return type descriptors.
        if (parmCtxs != null)
        {
            for (NeoParser.VariableContext parmCtx : parmCtxs)
            {
                //            vvv   Made a custom typeDescriptor in CodeGenerator taking strings and looking at first character to deduce type
                buffer.append(typeDescriptor(parmCtx.getText()));
            }
        }
        buffer.append(")");
        buffer.append(typeDescriptor(functionName));

        emitLine();
        emitComment("FUNCTION " + functionName);

        emitDirective(METHOD_PRIVATE_STATIC, buffer.toString());
    }

    public void emitRealFunctionLocals(NeoParser.RealFunctionDefinitionContext ctx) {
        List<NeoParser.VariableContext> localVars =
            Stream.concat((ctx.variableList().variable()).stream(), (ctx.variableDeclarationList().variableList().variable()).stream()).toList();
                        //     ^^^  list of parameters concatenated with list of declared vars    ^^^


        // Am assuming we want the slot numbers to match to the order of the localVars list.


        emitLine();

        // emit a .var directive for each variable and formal parameter.
        for (int slotNumber = 0; slotNumber < localVars.size() ; slotNumber++) {
            String varName = localVars.get(slotNumber).getText();
            CodeGenerator.currentLocalVariables.enter(localVars.get(slotNumber).getText(), slotNumber);
            emitDirective(VAR, slotNumber + " is " + varName, typeDescriptor(varName));
        }
        String functionName = ctx.realFunctionName().getText();
        int functionSlotNumber = localVars.size();
        CodeGenerator.currentLocalVariables.enter(functionName, functionSlotNumber);
        emitDirective(VAR, functionSlotNumber + " is " + functionName, typeDescriptor(Predefined.realType));
    }

    public void emitRealFunctionReturn(NeoParser.RealFunctionDefinitionContext ctx) {
        emitLine();

        String varName = ctx.realFunctionName().getText();
        Typespec type = varName.charAt(0) == 'r' ? Predefined.realType : Predefined.matrixType;
//
//        NeoParser.FunctionDefinitionListContext fnDefLstCtx = (NeoParser.FunctionDefinitionListContext) ctx.getParent().getParent();
//        List<NeoParser.FunctionDefinitionContext> fnDefList = fnDefLstCtx.functionDefinition();

//        // search for our function's slot number, assuming we want slot numbers of functions to be the order that we define them in
//        int slotNumber = -1;
//        for (int index = 0; index < fnDefList.size(); index++) {
//            String name = "";
//            if (fnDefList.get(index).realFunctionDefinition() != null) {
//                name = fnDefList.get(index).realFunctionDefinition().realFunctionName().getText();
//            }
//            else {
//                name = fnDefList.get(index).matrixFunctionDefinition().matrixFunctionName().getText();
//            }
//            if (name.equals(varName)) {
//                slotNumber = index;
//                break;
//            }
//        }

        int functionSlotNumber = ctx.variableDeclarationList().variableList().variable().size() + ctx.variableList().variable().size();

        emitStoreLocal(Predefined.realType, functionSlotNumber);
        emitLoadLocal(Predefined.realType, functionSlotNumber);
        emitReturnValue(type);
    }

    private void emitFunctionEpilogue()
    {
        emitLine();
        emitDirective(LIMIT_LOCALS, localVariables.count());
        emitDirective(LIMIT_STACK,  localStack.capacity());
        emitDirective(END_METHOD);
    }


    public void emitMatrixFunctionDefinition(NeoParser.MatrixFunctionDefinitionContext ctx) {
        // make new currentLocalVariables symtab
        CodeGenerator.currentLocalVariables = new Symtab(1);
        CodeGenerator.currentLocalVariables.enter(ctx.matrixFunctionName().getText(), 0);    // for sake of returning

        emitMatrixFunctionHeader(ctx);
        emitMatrixFunctionLocals(ctx);

        localVariables = new LocalVariables(  // argument is number of local variables we want: # parameters + # declared vars ? I think?
                ctx.variableList().variable().size() + ctx.variableDeclarationList().variableList().variable().size());

        compiler.visit(ctx.variableDeclarationList());

        // initialize variables to default values
        int numOfParameters = ctx.variableList().variable().size();
        List<NeoParser.VariableContext> declaredVariableList = ctx.variableDeclarationList().variableList().variable();
        for (int i = 0; i < declaredVariableList.size(); i++) {
            NeoParser.VariableContext varCtx = declaredVariableList.get(i);
            int slotNumber = i + numOfParameters;   // followed by parameters
            if (varCtx.realVariable() != null) {    // if real var
                // set to 0
                emit(LDC, 0.0f);
                emit(FSTORE, slotNumber);
            }
            else if (varCtx.matrixVariable() != null) {
                int matrixSize = Integer.parseInt(varCtx.matrixVariable().INTEGER().getText());
                emit(NEW, "library/Matrix");
                emit(DUP);
                emit(LDC, matrixSize);
                emit(INVOKESPECIAL, "library/Matrix/<init>(I)V");
                emit(ASTORE, slotNumber);
                emit(ALOAD, slotNumber);
            }
        }

        compiler.visit(ctx.compoundStatement());

        emitMatrixFunctionReturn(ctx);
        emitFunctionEpilogue();
    }

    public void emitMatrixFunctionHeader(NeoParser.MatrixFunctionDefinitionContext ctx) {
        String functionName = ctx.matrixFunctionName().getText();
        List<NeoParser.VariableContext> parmCtxs = ctx.variableList().variable();
        StringBuilder buffer = new StringBuilder();

        // function name.
        buffer.append(functionName);
        buffer.append("(");
        // Parameter and return type descriptors.
        if (parmCtxs != null)
        {
            for (NeoParser.VariableContext parmCtx : parmCtxs)
            {
                //            vvv   Made a custom typeDescriptor in CodeGenerator taking strings and looking at first character to deduce type
                buffer.append(typeDescriptor(parmCtx.getText()));
            }
        }
        buffer.append(")");
        buffer.append(typeDescriptor(functionName));

        emitLine();
        emitComment("FUNCTION " + functionName);

        emitDirective(METHOD_PRIVATE_STATIC, buffer.toString());
    }

    public void emitMatrixFunctionLocals(NeoParser.MatrixFunctionDefinitionContext ctx) {
        List<NeoParser.VariableContext> localVars =
                Stream.concat((ctx.variableList().variable()).stream(), (ctx.variableDeclarationList().variableList().variable()).stream()).toList();
        //     ^^^  list of parameters concatenated with list of declared vars    ^^^


        // Am assuming we want the slot numbers to match to the order of the localVars list.

        emitLine();

        // emit a .var directive for each variable and formal parameter.
        for (int slotNumber = 0; slotNumber < localVars.size() ; slotNumber++) {
            String varName = localVars.get(slotNumber).getText();
            CodeGenerator.currentLocalVariables.enter(localVars.get(slotNumber).getText(), slotNumber);
            emitDirective(VAR, slotNumber + " is " + varName, typeDescriptor(varName));
        }
        String functionName = ctx.matrixFunctionName().getText();
        int functionSlotNumber = localVars.size();
        CodeGenerator.currentLocalVariables.enter(functionName, functionSlotNumber);
        emitDirective(VAR, functionSlotNumber + " is " + functionName, typeDescriptor(Predefined.matrixType));
    }

    public void emitMatrixFunctionReturn(NeoParser.MatrixFunctionDefinitionContext ctx) {
        emitLine();

        String varName = ctx.matrixFunctionName().getText();
        Typespec type = varName.charAt(0) == 'r' ? Predefined.realType : Predefined.matrixType;
//
//        NeoParser.FunctionDefinitionListContext fnDefLstCtx = (NeoParser.FunctionDefinitionListContext) ctx.getParent().getParent();
//        List<NeoParser.FunctionDefinitionContext> fnDefList = fnDefLstCtx.functionDefinition();

//        // search for our function's slot number, assuming we want slot numbers of functions to be the order that we define them in
//        int slotNumber = -1;
//        for (int index = 0; index < fnDefList.size(); index++) {
//            String name = "";
//            if (fnDefList.get(index).realFunctionDefinition() != null) {
//                name = fnDefList.get(index).realFunctionDefinition().realFunctionName().getText();
//            }
//            else {
//                name = fnDefList.get(index).matrixFunctionDefinition().matrixFunctionName().getText();
//            }
//            if (name.equals(varName)) {
//                slotNumber = index;
//                break;
//            }
//        }

        int functionSlotNumber = ctx.variableDeclarationList().variableList().variable().size() + ctx.variableList().variable().size();

        emitStoreLocal(Predefined.matrixType, functionSlotNumber);
        emitLoadLocal(Predefined.matrixType, functionSlotNumber);
        emitReturnValue(type);
    }


}
