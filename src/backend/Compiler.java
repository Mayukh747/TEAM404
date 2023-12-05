package backend;

import antlr4.*;
import intermediate.symtab.Symtab;
import intermediate.symtab.SymtabEntry;

public class Compiler extends NeoBaseVisitor<Object>{
    public SymtabEntry programId;  // symbol table entry of the program name
    private String programName;     // the program name

    public CodeGenerator       code;             // base code generator
    private ProgramGenerator    programCode;     // program code generator
    private StatementGenerator  statementCode;   // statement code generator
    ExpressionGenerator expressionCode;  // expression code generator

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

    @Override
    public Object visitRealFunctionDefinition(NeoParser.RealFunctionDefinitionContext ctx) {
        programCode.emitRealFunctionDefinition(ctx);
        return null;
    }

    @Override
    public Object visitMatrixFunctionDefinition(NeoParser.MatrixFunctionDefinitionContext ctx){
        programCode.emitMatrixFunctionDefinition(ctx);
        return null;
    }


    @Override
    public Object visitAssignmentStatement(NeoParser.AssignmentStatementContext ctx) {
        statementCode.emitAssignment(ctx);
        return null;
    }

    @Override
    public Object visitExpression(NeoParser.ExpressionContext ctx) {
        if (ctx.realExpression().size() > 0) {     // real expression
            if (ctx.realRelOp() == null) {
                visitRealExpression(ctx.realExpression(0));
            }
            else if (ctx.realRelOp().getText().equals("=")) {
                visitRealExpression(ctx.realExpression(0));
                visitRealExpression(ctx.realExpression(1));
                code.emit(Instruction.INVOKESTATIC, "library/Matrix/realEquals(FF)F");
            }
            else if (ctx.realRelOp().getText().equals("!=")) {
                visitRealExpression(ctx.realExpression(0));
                visitRealExpression(ctx.realExpression(1));
                code.emit(Instruction.INVOKESTATIC, "library/Matrix/realEquals(FF)F");
                code.emit(Instruction.INVOKESTATIC, "library/Matrix/booleanNot(F)F");
            }
            else if (ctx.realRelOp().getText().equals("<=")) {
                visitRealExpression(ctx.realExpression(0));
                visitRealExpression(ctx.realExpression(1));
                code.emit(Instruction.INVOKESTATIC, "library/Matrix/realLessEq(FF)F");
            }
        }
        else {          // matrix expression
            if (ctx.matrixRelOp() == null) {
                visitMatrixExpression(ctx.matrixExpression(0));
            }
            else if (ctx.matrixRelOp().getText().equals("=")) {
                visitMatrixExpression(ctx.matrixExpression(0));
                visitMatrixExpression(ctx.matrixExpression(1));
                code.emit(Instruction.INVOKESTATIC, "library/Matrix/matrixEquals(Llibrary/Matrix;Llibrary/Matrix;)F");
            }
            else if (ctx.matrixRelOp().getText().equals("!=")) {
                visitMatrixExpression(ctx.matrixExpression(0));
                visitMatrixExpression(ctx.matrixExpression(1));
                code.emit(Instruction.INVOKESTATIC, "library/Matrix/matrixEquals(Llibrary/Matrix;Llibrary/Matrix;)F");
                code.emit(Instruction.INVOKESTATIC, "library/Matrix/booleanNot(F)F");
            }
        }

        return null;
    }

    @Override
    public Object visitRealExpression(NeoParser.RealExpressionContext ctx) {
        expressionCode.emitRealExpression(ctx);

        return null;    // temporary return value ?
    }

    @Override
    public Object visitMatrixExpression(NeoParser.MatrixExpressionContext ctx) {
        expressionCode.emitMatrixExpression(ctx);

        return null;    // temporary return value?
    }

    @Override
    public Object visitPrintStatement(NeoParser.PrintStatementContext ctx) {
        statementCode.emitPrintStatement(ctx);
        return null;
    }

    @Override
    public Object visitIfStatement(NeoParser.IfStatementContext ctx) {
        statementCode.emitIfStatement(ctx);
        return null;
    }

    @Override
    public Object visitWhileStatement(NeoParser.WhileStatementContext ctx) {
        statementCode.emitWhileStatement(ctx);
        return null;
    }
}
