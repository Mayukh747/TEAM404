package frontend;

import intermediate.symtab.*;
import antlr4.*;

public class Semantics extends NeoBaseVisitor<Object> {
    private SymtabStack symtabStack;
    private SymtabEntry programId;
    private SemanticErrorHandler error;

    public Semantics()
    {
        // Create and initialize the symbol table stack.
        //this.symtabStack = new SymtabStack();
        //Predefined.initialize(symtabStack);
        this.symtabStack = new SymtabStack();
        this.error = new SemanticErrorHandler();
    }

    public SymtabEntry getProgramId() {
        return programId;
    }
    public int getErrorCount() { return error.getCount(); };

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
}
