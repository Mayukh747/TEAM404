// Generated from /Users/mayukh/IdeaProjects/TEAM404/Neo.g4 by ANTLR 4.13.1

    package antlr4;
    import java.util.HashMap;
    import intermediate.symtab.SymtabEntry;
    import intermediate.type.Typespec;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NeoParser}.
 */
public interface NeoListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NeoParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(NeoParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(NeoParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#programHeader}.
	 * @param ctx the parse tree
	 */
	void enterProgramHeader(NeoParser.ProgramHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#programHeader}.
	 * @param ctx the parse tree
	 */
	void exitProgramHeader(NeoParser.ProgramHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#programIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterProgramIdentifier(NeoParser.ProgramIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#programIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitProgramIdentifier(NeoParser.ProgramIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(NeoParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(NeoParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStatement(NeoParser.CompoundStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStatement(NeoParser.CompoundStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#statementList}.
	 * @param ctx the parse tree
	 */
	void enterStatementList(NeoParser.StatementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#statementList}.
	 * @param ctx the parse tree
	 */
	void exitStatementList(NeoParser.StatementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(NeoParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(NeoParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#lhs}.
	 * @param ctx the parse tree
	 */
	void enterLhs(NeoParser.LhsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#lhs}.
	 * @param ctx the parse tree
	 */
	void exitLhs(NeoParser.LhsContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#rhs}.
	 * @param ctx the parse tree
	 */
	void enterRhs(NeoParser.RhsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#rhs}.
	 * @param ctx the parse tree
	 */
	void exitRhs(NeoParser.RhsContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(NeoParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(NeoParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(NeoParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(NeoParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#variableDeclarationList}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarationList(NeoParser.VariableDeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#variableDeclarationList}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarationList(NeoParser.VariableDeclarationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#variableList}.
	 * @param ctx the parse tree
	 */
	void enterVariableList(NeoParser.VariableListContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#variableList}.
	 * @param ctx the parse tree
	 */
	void exitVariableList(NeoParser.VariableListContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(NeoParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(NeoParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#functionDefinitionList}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinitionList(NeoParser.FunctionDefinitionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#functionDefinitionList}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinitionList(NeoParser.FunctionDefinitionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(NeoParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(NeoParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(NeoParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(NeoParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(NeoParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(NeoParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(NeoParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(NeoParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(NeoParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(NeoParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpression(NeoParser.BooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpression(NeoParser.BooleanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#booleanTerm}.
	 * @param ctx the parse tree
	 */
	void enterBooleanTerm(NeoParser.BooleanTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#booleanTerm}.
	 * @param ctx the parse tree
	 */
	void exitBooleanTerm(NeoParser.BooleanTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#booleanFactor}.
	 * @param ctx the parse tree
	 */
	void enterBooleanFactor(NeoParser.BooleanFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#booleanFactor}.
	 * @param ctx the parse tree
	 */
	void exitBooleanFactor(NeoParser.BooleanFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(NeoParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(NeoParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#realExpression}.
	 * @param ctx the parse tree
	 */
	void enterRealExpression(NeoParser.RealExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#realExpression}.
	 * @param ctx the parse tree
	 */
	void exitRealExpression(NeoParser.RealExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#realTerm}.
	 * @param ctx the parse tree
	 */
	void enterRealTerm(NeoParser.RealTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#realTerm}.
	 * @param ctx the parse tree
	 */
	void exitRealTerm(NeoParser.RealTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#realFactor}.
	 * @param ctx the parse tree
	 */
	void enterRealFactor(NeoParser.RealFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#realFactor}.
	 * @param ctx the parse tree
	 */
	void exitRealFactor(NeoParser.RealFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#realVariable}.
	 * @param ctx the parse tree
	 */
	void enterRealVariable(NeoParser.RealVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#realVariable}.
	 * @param ctx the parse tree
	 */
	void exitRealVariable(NeoParser.RealVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#realNumber}.
	 * @param ctx the parse tree
	 */
	void enterRealNumber(NeoParser.RealNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#realNumber}.
	 * @param ctx the parse tree
	 */
	void exitRealNumber(NeoParser.RealNumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(NeoParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(NeoParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#realFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterRealFunctionCall(NeoParser.RealFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#realFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitRealFunctionCall(NeoParser.RealFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#realFunctionName}.
	 * @param ctx the parse tree
	 */
	void enterRealFunctionName(NeoParser.RealFunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#realFunctionName}.
	 * @param ctx the parse tree
	 */
	void exitRealFunctionName(NeoParser.RealFunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#realFunctionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterRealFunctionDefinition(NeoParser.RealFunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#realFunctionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitRealFunctionDefinition(NeoParser.RealFunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#realRelOp}.
	 * @param ctx the parse tree
	 */
	void enterRealRelOp(NeoParser.RealRelOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#realRelOp}.
	 * @param ctx the parse tree
	 */
	void exitRealRelOp(NeoParser.RealRelOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#realAddOp}.
	 * @param ctx the parse tree
	 */
	void enterRealAddOp(NeoParser.RealAddOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#realAddOp}.
	 * @param ctx the parse tree
	 */
	void exitRealAddOp(NeoParser.RealAddOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#realMulOp}.
	 * @param ctx the parse tree
	 */
	void enterRealMulOp(NeoParser.RealMulOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#realMulOp}.
	 * @param ctx the parse tree
	 */
	void exitRealMulOp(NeoParser.RealMulOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#matrixExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatrixExpression(NeoParser.MatrixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#matrixExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatrixExpression(NeoParser.MatrixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#matrixTerm}.
	 * @param ctx the parse tree
	 */
	void enterMatrixTerm(NeoParser.MatrixTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#matrixTerm}.
	 * @param ctx the parse tree
	 */
	void exitMatrixTerm(NeoParser.MatrixTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#matrixFactor}.
	 * @param ctx the parse tree
	 */
	void enterMatrixFactor(NeoParser.MatrixFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#matrixFactor}.
	 * @param ctx the parse tree
	 */
	void exitMatrixFactor(NeoParser.MatrixFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#invTerm}.
	 * @param ctx the parse tree
	 */
	void enterInvTerm(NeoParser.InvTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#invTerm}.
	 * @param ctx the parse tree
	 */
	void exitInvTerm(NeoParser.InvTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#detTerm}.
	 * @param ctx the parse tree
	 */
	void enterDetTerm(NeoParser.DetTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#detTerm}.
	 * @param ctx the parse tree
	 */
	void exitDetTerm(NeoParser.DetTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#matrixVariable}.
	 * @param ctx the parse tree
	 */
	void enterMatrixVariable(NeoParser.MatrixVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#matrixVariable}.
	 * @param ctx the parse tree
	 */
	void exitMatrixVariable(NeoParser.MatrixVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#matrixEntry}.
	 * @param ctx the parse tree
	 */
	void enterMatrixEntry(NeoParser.MatrixEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#matrixEntry}.
	 * @param ctx the parse tree
	 */
	void exitMatrixEntry(NeoParser.MatrixEntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#matrixFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterMatrixFunctionCall(NeoParser.MatrixFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#matrixFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitMatrixFunctionCall(NeoParser.MatrixFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#matrixFunctionName}.
	 * @param ctx the parse tree
	 */
	void enterMatrixFunctionName(NeoParser.MatrixFunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#matrixFunctionName}.
	 * @param ctx the parse tree
	 */
	void exitMatrixFunctionName(NeoParser.MatrixFunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#matrixFunctionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterMatrixFunctionDefinition(NeoParser.MatrixFunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#matrixFunctionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitMatrixFunctionDefinition(NeoParser.MatrixFunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#matrixRelOp}.
	 * @param ctx the parse tree
	 */
	void enterMatrixRelOp(NeoParser.MatrixRelOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#matrixRelOp}.
	 * @param ctx the parse tree
	 */
	void exitMatrixRelOp(NeoParser.MatrixRelOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#matrixAddOp}.
	 * @param ctx the parse tree
	 */
	void enterMatrixAddOp(NeoParser.MatrixAddOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#matrixAddOp}.
	 * @param ctx the parse tree
	 */
	void exitMatrixAddOp(NeoParser.MatrixAddOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link NeoParser#matrixMulOp}.
	 * @param ctx the parse tree
	 */
	void enterMatrixMulOp(NeoParser.MatrixMulOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link NeoParser#matrixMulOp}.
	 * @param ctx the parse tree
	 */
	void exitMatrixMulOp(NeoParser.MatrixMulOpContext ctx);
}