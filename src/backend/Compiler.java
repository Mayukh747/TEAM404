package backend;

import antlr4.*;
import intermediate.symtab.SymtabEntry;

public class Compiler extends NeoBaseVisitor<Object>{
    public SymtabEntry programId;  // symbol table entry of the program name
    private String programName;     // the program name

    private CodeGenerator       code;            // base code generator
    private ProgramGenerator    programCode;     // program code generator
    private StatementGenerator  statementCode;   // statement code generator
    private ExpressionGenerator expressionCode;  // expression code generator

    /**
     * Constructor for the base compiler.
     * @param programId the symtab entry for the program name.
     */
    public Compiler(SymtabEntry programId)
    {
        this.programId = programId;
        programName = programId.getName();

        code = new CodeGenerator(programName, "j", this);
    }

    /**
     * Constructor for child compilers of procedures and functions.
     * @param parent the parent compiler.
     */
    public Compiler(Compiler parent)
    {
        this.code        = parent.code;
        this.programCode = parent.programCode;
        this.programId   = parent.programId;
        this.programName = parent.programName;
    }

    /**
     * Get the name of the object (Jasmin) file.
     * @return the name.
     */
    public String getObjectFileName() { return code.getObjectFileName(); }

//    /**
//     * Constructor for child compilers of records.
//     * @param parent the parent compiler.
//     * @param recordId the symbol table entry of the name of the record to compile.
//     */
//    public Compiler(Compiler parent, SymtabEntry recordId)
//    {
//        String recordTypePath = recordId.getType().getRecordTypePath();
//        code = new CodeGenerator(recordTypePath, "j", this);
//        createNewGenerators(code);
//
//        programCode.emitRecord(recordId, recordTypePath);
//    }

    /**
     * Create new child code generators.
     * @param parentGenerator the parent code generator.
     */
    private void createNewGenerators(CodeGenerator parentGenerator)
    {
        programCode    = new ProgramGenerator(parentGenerator, this);
        statementCode  = new StatementGenerator(programCode, this);
        expressionCode = new ExpressionGenerator(programCode, this);
    }

    @Override
    public Object visitProgram(NeoParser.ProgramContext ctx)
    {
        createNewGenerators(code);
        programCode.emitProgram(ctx);
        return null;
    }
}
