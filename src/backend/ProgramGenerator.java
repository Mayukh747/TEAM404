package backend;

import intermediate.symtab.Symtab;
import intermediate.symtab.SymtabEntry;
import antlr4.*;

import java.util.ArrayList;

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

        // emitProgramVariables();
        emitInputScanner();
        emitConstructor();
        // emitSubroutines(ctx.block().declarations().routinesPart());

        emitMainMethod(ctx);
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
        emitLine();
        emitComment("MAIN");
        emitDirective(METHOD_PUBLIC_STATIC,
                "main([Ljava/lang/String;)V");

        emitMainPrologue(programId);

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
        emitDirective(VAR, "0 is args [Ljava/lang/String;");
        emitDirective(VAR, "1 is _start Ljava/time/Instant;");
        emitDirective(VAR, "2 is _end Ljava/time/Instant;");
        emitDirective(VAR, "3 is _elapsed J");

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

        emitDirective(LIMIT_LOCALS, localVariables.count());
        emitDirective(LIMIT_STACK,  localStack.capacity() + 1);     // TODO: Make sure this is where we should add 1
        emitDirective(END_METHOD);

        close();  // the object file
    }
}
