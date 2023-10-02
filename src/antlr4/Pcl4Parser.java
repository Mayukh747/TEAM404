// Generated from /Users/mayukhdas/IntelliJ-Workspace/TEAM404/Pcl4.g4 by ANTLR 4.13.1

    package antlr4;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class Pcl4Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		PROGRAM=18, CONST=19, TYPE=20, ARRAY=21, OF=22, RECORD=23, VAR=24, BEGIN=25, 
		END=26, DIV=27, MOD=28, AND=29, OR=30, NOT=31, IF=32, THEN=33, ELSE=34, 
		CASE=35, REPEAT=36, UNTIL=37, WHILE=38, DO=39, FOR=40, TO=41, DOWNTO=42, 
		WRITE=43, WRITELN=44, READ=45, READLN=46, PROCEDURE=47, FUNCTION=48, IDENTIFIER=49, 
		INTEGER=50, REAL=51, NEWLINE=52, WS=53, QUOTE=54, CHARACTER=55, STRING=56;
	public static final int
		RULE_program = 0, RULE_programHeader = 1, RULE_programParameters = 2, 
		RULE_block = 3, RULE_declarations = 4, RULE_statement = 5, RULE_compoundStatement = 6, 
		RULE_emptyStatement = 7, RULE_statementList = 8, RULE_assignmentStatement = 9, 
		RULE_repeatStatement = 10, RULE_whileStatement = 11, RULE_forStatement = 12, 
		RULE_ifStatement = 13, RULE_caseStatement = 14, RULE_lhs = 15, RULE_rhs = 16, 
		RULE_writeStatement = 17, RULE_writelnStatement = 18, RULE_expression = 19, 
		RULE_simpleExpression = 20, RULE_term = 21, RULE_factor = 22, RULE_variable = 23, 
		RULE_number = 24, RULE_unsignedNumber = 25, RULE_integerConstant = 26, 
		RULE_realConstant = 27, RULE_characterConstant = 28, RULE_stringConstant = 29, 
		RULE_sign = 30, RULE_relOp = 31, RULE_addOp = 32, RULE_mulOp = 33, RULE_writeArgumentsOn = 34, 
		RULE_writeArgumentListOn = 35, RULE_writeArgumentsLn = 36, RULE_writeArgumentListLn = 37, 
		RULE_writeArgumentList = 38, RULE_writeArgument = 39, RULE_fieldWidth = 40, 
		RULE_decimalPlaces = 41;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "programHeader", "programParameters", "block", "declarations", 
			"statement", "compoundStatement", "emptyStatement", "statementList", 
			"assignmentStatement", "repeatStatement", "whileStatement", "forStatement", 
			"ifStatement", "caseStatement", "lhs", "rhs", "writeStatement", "writelnStatement", 
			"expression", "simpleExpression", "term", "factor", "variable", "number", 
			"unsignedNumber", "integerConstant", "realConstant", "characterConstant", 
			"stringConstant", "sign", "relOp", "addOp", "mulOp", "writeArgumentsOn", 
			"writeArgumentListOn", "writeArgumentsLn", "writeArgumentListLn", "writeArgumentList", 
			"writeArgument", "fieldWidth", "decimalPlaces"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "';'", "'('", "','", "')'", "':='", "':'", "'-'", "'+'", 
			"'='", "'<>'", "'<'", "'<='", "'>'", "'>='", "'*'", "'/'", null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "'''"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "PROGRAM", "CONST", "TYPE", "ARRAY", 
			"OF", "RECORD", "VAR", "BEGIN", "END", "DIV", "MOD", "AND", "OR", "NOT", 
			"IF", "THEN", "ELSE", "CASE", "REPEAT", "UNTIL", "WHILE", "DO", "FOR", 
			"TO", "DOWNTO", "WRITE", "WRITELN", "READ", "READLN", "PROCEDURE", "FUNCTION", 
			"IDENTIFIER", "INTEGER", "REAL", "NEWLINE", "WS", "QUOTE", "CHARACTER", 
			"STRING"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Pcl4.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Pcl4Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public ProgramHeaderContext programHeader() {
			return getRuleContext(ProgramHeaderContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			programHeader();
			setState(85);
			block();
			setState(86);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramHeaderContext extends ParserRuleContext {
		public TerminalNode PROGRAM() { return getToken(Pcl4Parser.PROGRAM, 0); }
		public TerminalNode IDENTIFIER() { return getToken(Pcl4Parser.IDENTIFIER, 0); }
		public ProgramParametersContext programParameters() {
			return getRuleContext(ProgramParametersContext.class,0);
		}
		public ProgramHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterProgramHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitProgramHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitProgramHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramHeaderContext programHeader() throws RecognitionException {
		ProgramHeaderContext _localctx = new ProgramHeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_programHeader);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(PROGRAM);
			setState(89);
			match(IDENTIFIER);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(90);
				programParameters();
				}
			}

			setState(93);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramParametersContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(Pcl4Parser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(Pcl4Parser.IDENTIFIER, i);
		}
		public ProgramParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterProgramParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitProgramParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitProgramParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramParametersContext programParameters() throws RecognitionException {
		ProgramParametersContext _localctx = new ProgramParametersContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_programParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(T__2);
			setState(96);
			match(IDENTIFIER);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(97);
				match(T__3);
				setState(98);
				match(IDENTIFIER);
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(104);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			declarations();
			setState(107);
			compoundStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationsContext extends ParserRuleContext {
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitDeclarations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declarations);
		try {
			enterOuterAlt(_localctx, 1);
			{
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public AssignmentStatementContext assignmentStatement() {
			return getRuleContext(AssignmentStatementContext.class,0);
		}
		public RepeatStatementContext repeatStatement() {
			return getRuleContext(RepeatStatementContext.class,0);
		}
		public WriteStatementContext writeStatement() {
			return getRuleContext(WriteStatementContext.class,0);
		}
		public WritelnStatementContext writelnStatement() {
			return getRuleContext(WritelnStatementContext.class,0);
		}
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public CaseStatementContext caseStatement() {
			return getRuleContext(CaseStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		try {
			setState(121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEGIN:
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				compoundStatement();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				assignmentStatement();
				}
				break;
			case REPEAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				repeatStatement();
				}
				break;
			case WRITE:
				enterOuterAlt(_localctx, 4);
				{
				setState(114);
				writeStatement();
				}
				break;
			case WRITELN:
				enterOuterAlt(_localctx, 5);
				{
				setState(115);
				writelnStatement();
				}
				break;
			case T__1:
			case END:
			case ELSE:
			case UNTIL:
				enterOuterAlt(_localctx, 6);
				{
				setState(116);
				emptyStatement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 7);
				{
				setState(117);
				whileStatement();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 8);
				{
				setState(118);
				forStatement();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 9);
				{
				setState(119);
				ifStatement();
				}
				break;
			case CASE:
				enterOuterAlt(_localctx, 10);
				{
				setState(120);
				caseStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompoundStatementContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(Pcl4Parser.BEGIN, 0); }
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public TerminalNode END() { return getToken(Pcl4Parser.END, 0); }
		public CompoundStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterCompoundStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitCompoundStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitCompoundStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoundStatementContext compoundStatement() throws RecognitionException {
		CompoundStatementContext _localctx = new CompoundStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_compoundStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(BEGIN);
			setState(124);
			statementList();
			setState(125);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EmptyStatementContext extends ParserRuleContext {
		public EmptyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterEmptyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitEmptyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitEmptyStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyStatementContext emptyStatement() throws RecognitionException {
		EmptyStatementContext _localctx = new EmptyStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_emptyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementListContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterStatementList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitStatementList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitStatementList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementListContext statementList() throws RecognitionException {
		StatementListContext _localctx = new StatementListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statementList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			statement();
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(130);
				match(T__1);
				setState(131);
				statement();
				}
				}
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentStatementContext extends ParserRuleContext {
		public LhsContext lhs() {
			return getRuleContext(LhsContext.class,0);
		}
		public RhsContext rhs() {
			return getRuleContext(RhsContext.class,0);
		}
		public AssignmentStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterAssignmentStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitAssignmentStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitAssignmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentStatementContext assignmentStatement() throws RecognitionException {
		AssignmentStatementContext _localctx = new AssignmentStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignmentStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			lhs();
			setState(138);
			match(T__5);
			setState(139);
			rhs();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RepeatStatementContext extends ParserRuleContext {
		public TerminalNode REPEAT() { return getToken(Pcl4Parser.REPEAT, 0); }
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public TerminalNode UNTIL() { return getToken(Pcl4Parser.UNTIL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RepeatStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterRepeatStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitRepeatStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitRepeatStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatStatementContext repeatStatement() throws RecognitionException {
		RepeatStatementContext _localctx = new RepeatStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_repeatStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(REPEAT);
			setState(142);
			statementList();
			setState(143);
			match(UNTIL);
			setState(144);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(Pcl4Parser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DO() { return getToken(Pcl4Parser.DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(WHILE);
			setState(147);
			expression();
			setState(148);
			match(DO);
			setState(149);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(Pcl4Parser.FOR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(Pcl4Parser.IDENTIFIER, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DO() { return getToken(Pcl4Parser.DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode TO() { return getToken(Pcl4Parser.TO, 0); }
		public TerminalNode DOWNTO() { return getToken(Pcl4Parser.DOWNTO, 0); }
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(FOR);
			setState(152);
			match(IDENTIFIER);
			setState(153);
			match(T__5);
			setState(154);
			expression();
			setState(155);
			_la = _input.LA(1);
			if ( !(_la==TO || _la==DOWNTO) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(156);
			expression();
			setState(157);
			match(DO);
			setState(158);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(Pcl4Parser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(Pcl4Parser.THEN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(Pcl4Parser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(IF);
			setState(161);
			expression();
			setState(162);
			match(THEN);
			setState(163);
			statement();
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(164);
				match(ELSE);
				setState(165);
				statement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CaseStatementContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(Pcl4Parser.CASE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode OF() { return getToken(Pcl4Parser.OF, 0); }
		public TerminalNode END() { return getToken(Pcl4Parser.END, 0); }
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public CaseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterCaseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitCaseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitCaseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseStatementContext caseStatement() throws RecognitionException {
		CaseStatementContext _localctx = new CaseStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_caseStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(CASE);
			setState(169);
			expression();
			setState(170);
			match(OF);
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3377699720528640L) != 0)) {
				{
				setState(171);
				number();
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(172);
					match(T__3);
					setState(173);
					number();
					}
					}
					setState(178);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(179);
				match(T__6);
				setState(180);
				statement();
				setState(195);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(181);
						match(T__1);
						setState(182);
						number();
						setState(187);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__3) {
							{
							{
							setState(183);
							match(T__3);
							setState(184);
							number();
							}
							}
							setState(189);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(190);
						match(T__6);
						setState(191);
						statement();
						}
						} 
					}
					setState(197);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				}
				}
			}

			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(200);
				match(T__1);
				}
			}

			setState(203);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LhsContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public LhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lhs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterLhs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitLhs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitLhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LhsContext lhs() throws RecognitionException {
		LhsContext _localctx = new LhsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_lhs);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			variable();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RhsContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rhs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterRhs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitRhs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitRhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RhsContext rhs() throws RecognitionException {
		RhsContext _localctx = new RhsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_rhs);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WriteStatementContext extends ParserRuleContext {
		public TerminalNode WRITE() { return getToken(Pcl4Parser.WRITE, 0); }
		public WriteArgumentsOnContext writeArgumentsOn() {
			return getRuleContext(WriteArgumentsOnContext.class,0);
		}
		public WriteStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterWriteStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitWriteStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitWriteStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteStatementContext writeStatement() throws RecognitionException {
		WriteStatementContext _localctx = new WriteStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_writeStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(WRITE);
			setState(210);
			writeArgumentsOn();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WritelnStatementContext extends ParserRuleContext {
		public TerminalNode WRITELN() { return getToken(Pcl4Parser.WRITELN, 0); }
		public WriteArgumentsLnContext writeArgumentsLn() {
			return getRuleContext(WriteArgumentsLnContext.class,0);
		}
		public WritelnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writelnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterWritelnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitWritelnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitWritelnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WritelnStatementContext writelnStatement() throws RecognitionException {
		WritelnStatementContext _localctx = new WritelnStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_writelnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(WRITELN);
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(213);
				writeArgumentsLn();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public List<SimpleExpressionContext> simpleExpression() {
			return getRuleContexts(SimpleExpressionContext.class);
		}
		public SimpleExpressionContext simpleExpression(int i) {
			return getRuleContext(SimpleExpressionContext.class,i);
		}
		public RelOpContext relOp() {
			return getRuleContext(RelOpContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			simpleExpression();
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 64512L) != 0)) {
				{
				setState(217);
				relOp();
				setState(218);
				simpleExpression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleExpressionContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public List<AddOpContext> addOp() {
			return getRuleContexts(AddOpContext.class);
		}
		public AddOpContext addOp(int i) {
			return getRuleContext(AddOpContext.class,i);
		}
		public SimpleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterSimpleExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitSimpleExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitSimpleExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleExpressionContext simpleExpression() throws RecognitionException {
		SimpleExpressionContext _localctx = new SimpleExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_simpleExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(222);
				sign();
				}
				break;
			}
			setState(225);
			term();
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1073742592L) != 0)) {
				{
				{
				setState(226);
				addOp();
				setState(227);
				term();
				}
				}
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<MulOpContext> mulOp() {
			return getRuleContexts(MulOpContext.class);
		}
		public MulOpContext mulOp(int i) {
			return getRuleContext(MulOpContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			factor();
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 939720704L) != 0)) {
				{
				{
				setState(235);
				mulOp();
				setState(236);
				factor();
				}
				}
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	 
		public FactorContext() { }
		public void copyFrom(FactorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringFactorContext extends FactorContext {
		public StringConstantContext stringConstant() {
			return getRuleContext(StringConstantContext.class,0);
		}
		public StringFactorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterStringFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitStringFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitStringFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CharacterFactorContext extends FactorContext {
		public CharacterConstantContext characterConstant() {
			return getRuleContext(CharacterConstantContext.class,0);
		}
		public CharacterFactorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterCharacterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitCharacterFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitCharacterFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesizedExpressionContext extends FactorContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenthesizedExpressionContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterParenthesizedExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitParenthesizedExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitParenthesizedExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberExpressionContext extends FactorContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public NumberExpressionContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterNumberExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitNumberExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitNumberExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotFactorContext extends FactorContext {
		public TerminalNode NOT() { return getToken(Pcl4Parser.NOT, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public NotFactorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterNotFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitNotFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitNotFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableExpressionContext extends FactorContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public VariableExpressionContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterVariableExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitVariableExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitVariableExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_factor);
		try {
			setState(253);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new VariableExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(243);
				variable();
				}
				break;
			case T__7:
			case T__8:
			case INTEGER:
			case REAL:
				_localctx = new NumberExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				number();
				}
				break;
			case CHARACTER:
				_localctx = new CharacterFactorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(245);
				characterConstant();
				}
				break;
			case STRING:
				_localctx = new StringFactorContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(246);
				stringConstant();
				}
				break;
			case NOT:
				_localctx = new NotFactorContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(247);
				match(NOT);
				setState(248);
				factor();
				}
				break;
			case T__2:
				_localctx = new ParenthesizedExpressionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(249);
				match(T__2);
				setState(250);
				expression();
				setState(251);
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(Pcl4Parser.IDENTIFIER, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumberContext extends ParserRuleContext {
		public UnsignedNumberContext unsignedNumber() {
			return getRuleContext(UnsignedNumberContext.class,0);
		}
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7 || _la==T__8) {
				{
				setState(257);
				sign();
				}
			}

			setState(260);
			unsignedNumber();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnsignedNumberContext extends ParserRuleContext {
		public IntegerConstantContext integerConstant() {
			return getRuleContext(IntegerConstantContext.class,0);
		}
		public RealConstantContext realConstant() {
			return getRuleContext(RealConstantContext.class,0);
		}
		public UnsignedNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsignedNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterUnsignedNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitUnsignedNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitUnsignedNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnsignedNumberContext unsignedNumber() throws RecognitionException {
		UnsignedNumberContext _localctx = new UnsignedNumberContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_unsignedNumber);
		try {
			setState(264);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(262);
				integerConstant();
				}
				break;
			case REAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(263);
				realConstant();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IntegerConstantContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(Pcl4Parser.INTEGER, 0); }
		public IntegerConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterIntegerConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitIntegerConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitIntegerConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerConstantContext integerConstant() throws RecognitionException {
		IntegerConstantContext _localctx = new IntegerConstantContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_integerConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RealConstantContext extends ParserRuleContext {
		public TerminalNode REAL() { return getToken(Pcl4Parser.REAL, 0); }
		public RealConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_realConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterRealConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitRealConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitRealConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RealConstantContext realConstant() throws RecognitionException {
		RealConstantContext _localctx = new RealConstantContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_realConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(REAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CharacterConstantContext extends ParserRuleContext {
		public TerminalNode CHARACTER() { return getToken(Pcl4Parser.CHARACTER, 0); }
		public CharacterConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_characterConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterCharacterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitCharacterConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitCharacterConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CharacterConstantContext characterConstant() throws RecognitionException {
		CharacterConstantContext _localctx = new CharacterConstantContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_characterConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(CHARACTER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringConstantContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(Pcl4Parser.STRING, 0); }
		public StringConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterStringConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitStringConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitStringConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringConstantContext stringConstant() throws RecognitionException {
		StringConstantContext _localctx = new StringConstantContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_stringConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SignContext extends ParserRuleContext {
		public SignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterSign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitSign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitSign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignContext sign() throws RecognitionException {
		SignContext _localctx = new SignContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			_la = _input.LA(1);
			if ( !(_la==T__7 || _la==T__8) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RelOpContext extends ParserRuleContext {
		public RelOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterRelOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitRelOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitRelOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelOpContext relOp() throws RecognitionException {
		RelOpContext _localctx = new RelOpContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_relOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 64512L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AddOpContext extends ParserRuleContext {
		public TerminalNode OR() { return getToken(Pcl4Parser.OR, 0); }
		public AddOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterAddOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitAddOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitAddOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddOpContext addOp() throws RecognitionException {
		AddOpContext _localctx = new AddOpContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_addOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1073742592L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MulOpContext extends ParserRuleContext {
		public TerminalNode DIV() { return getToken(Pcl4Parser.DIV, 0); }
		public TerminalNode MOD() { return getToken(Pcl4Parser.MOD, 0); }
		public TerminalNode AND() { return getToken(Pcl4Parser.AND, 0); }
		public MulOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterMulOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitMulOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitMulOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulOpContext mulOp() throws RecognitionException {
		MulOpContext _localctx = new MulOpContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_mulOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 939720704L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WriteArgumentsOnContext extends ParserRuleContext {
		public WriteArgumentListOnContext writeArgumentListOn() {
			return getRuleContext(WriteArgumentListOnContext.class,0);
		}
		public WriteArgumentsOnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeArgumentsOn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterWriteArgumentsOn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitWriteArgumentsOn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitWriteArgumentsOn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteArgumentsOnContext writeArgumentsOn() throws RecognitionException {
		WriteArgumentsOnContext _localctx = new WriteArgumentsOnContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_writeArgumentsOn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			match(T__2);
			setState(283);
			writeArgumentListOn();
			setState(284);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WriteArgumentListOnContext extends ParserRuleContext {
		public WriteArgumentListContext writeArgumentList() {
			return getRuleContext(WriteArgumentListContext.class,0);
		}
		public WriteArgumentListOnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeArgumentListOn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterWriteArgumentListOn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitWriteArgumentListOn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitWriteArgumentListOn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteArgumentListOnContext writeArgumentListOn() throws RecognitionException {
		WriteArgumentListOnContext _localctx = new WriteArgumentListOnContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_writeArgumentListOn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			writeArgumentList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WriteArgumentsLnContext extends ParserRuleContext {
		public WriteArgumentListLnContext writeArgumentListLn() {
			return getRuleContext(WriteArgumentListLnContext.class,0);
		}
		public WriteArgumentsLnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeArgumentsLn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterWriteArgumentsLn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitWriteArgumentsLn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitWriteArgumentsLn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteArgumentsLnContext writeArgumentsLn() throws RecognitionException {
		WriteArgumentsLnContext _localctx = new WriteArgumentsLnContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_writeArgumentsLn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(T__2);
			setState(289);
			writeArgumentListLn();
			setState(290);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WriteArgumentListLnContext extends ParserRuleContext {
		public WriteArgumentListContext writeArgumentList() {
			return getRuleContext(WriteArgumentListContext.class,0);
		}
		public WriteArgumentListLnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeArgumentListLn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterWriteArgumentListLn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitWriteArgumentListLn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitWriteArgumentListLn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteArgumentListLnContext writeArgumentListLn() throws RecognitionException {
		WriteArgumentListLnContext _localctx = new WriteArgumentListLnContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_writeArgumentListLn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			writeArgumentList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WriteArgumentListContext extends ParserRuleContext {
		public List<WriteArgumentContext> writeArgument() {
			return getRuleContexts(WriteArgumentContext.class);
		}
		public WriteArgumentContext writeArgument(int i) {
			return getRuleContext(WriteArgumentContext.class,i);
		}
		public WriteArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeArgumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterWriteArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitWriteArgumentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitWriteArgumentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteArgumentListContext writeArgumentList() throws RecognitionException {
		WriteArgumentListContext _localctx = new WriteArgumentListContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_writeArgumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			writeArgument();
			setState(299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(295);
				match(T__3);
				setState(296);
				writeArgument();
				}
				}
				setState(301);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WriteArgumentContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FieldWidthContext fieldWidth() {
			return getRuleContext(FieldWidthContext.class,0);
		}
		public WriteArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterWriteArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitWriteArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitWriteArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteArgumentContext writeArgument() throws RecognitionException {
		WriteArgumentContext _localctx = new WriteArgumentContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_writeArgument);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			expression();
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(303);
				match(T__6);
				setState(304);
				fieldWidth();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldWidthContext extends ParserRuleContext {
		public IntegerConstantContext integerConstant() {
			return getRuleContext(IntegerConstantContext.class,0);
		}
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public DecimalPlacesContext decimalPlaces() {
			return getRuleContext(DecimalPlacesContext.class,0);
		}
		public FieldWidthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldWidth; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterFieldWidth(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitFieldWidth(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitFieldWidth(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldWidthContext fieldWidth() throws RecognitionException {
		FieldWidthContext _localctx = new FieldWidthContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_fieldWidth);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7 || _la==T__8) {
				{
				setState(307);
				sign();
				}
			}

			setState(310);
			integerConstant();
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(311);
				match(T__6);
				setState(312);
				decimalPlaces();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DecimalPlacesContext extends ParserRuleContext {
		public IntegerConstantContext integerConstant() {
			return getRuleContext(IntegerConstantContext.class,0);
		}
		public DecimalPlacesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimalPlaces; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).enterDecimalPlaces(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Pcl4Listener ) ((Pcl4Listener)listener).exitDecimalPlaces(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Pcl4Visitor ) return ((Pcl4Visitor<? extends T>)visitor).visitDecimalPlaces(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecimalPlacesContext decimalPlaces() throws RecognitionException {
		DecimalPlacesContext _localctx = new DecimalPlacesContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_decimalPlaces);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			integerConstant();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u00018\u013e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\\\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"d\b\u0002\n\u0002\f\u0002g\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005z\b\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0005\b\u0085\b\b\n\b\f\b\u0088\t\b\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0003\r\u00a7\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00af\b\u000e\n\u000e\f\u000e"+
		"\u00b2\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0005\u000e\u00ba\b\u000e\n\u000e\f\u000e\u00bd\t\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00c2\b\u000e\n\u000e\f\u000e"+
		"\u00c5\t\u000e\u0003\u000e\u00c7\b\u000e\u0001\u000e\u0003\u000e\u00ca"+
		"\b\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0003"+
		"\u0012\u00d7\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003"+
		"\u0013\u00dd\b\u0013\u0001\u0014\u0003\u0014\u00e0\b\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u00e6\b\u0014\n\u0014"+
		"\f\u0014\u00e9\t\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0005\u0015\u00ef\b\u0015\n\u0015\f\u0015\u00f2\t\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u00fe\b\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0018\u0003\u0018\u0103\b\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0019\u0001\u0019\u0003\u0019\u0109\b\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001"+
		"\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001!\u0001"+
		"!\u0001\"\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0001$\u0001$\u0001$\u0001"+
		"$\u0001%\u0001%\u0001&\u0001&\u0001&\u0005&\u012a\b&\n&\f&\u012d\t&\u0001"+
		"\'\u0001\'\u0001\'\u0003\'\u0132\b\'\u0001(\u0003(\u0135\b(\u0001(\u0001"+
		"(\u0001(\u0003(\u013a\b(\u0001)\u0001)\u0001)\u0000\u0000*\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468:<>@BDFHJLNPR\u0000\u0005\u0001\u0000)*\u0001\u0000\b\t"+
		"\u0001\u0000\n\u000f\u0002\u0000\b\t\u001e\u001e\u0002\u0000\u0010\u0011"+
		"\u001b\u001d\u0135\u0000T\u0001\u0000\u0000\u0000\u0002X\u0001\u0000\u0000"+
		"\u0000\u0004_\u0001\u0000\u0000\u0000\u0006j\u0001\u0000\u0000\u0000\b"+
		"m\u0001\u0000\u0000\u0000\ny\u0001\u0000\u0000\u0000\f{\u0001\u0000\u0000"+
		"\u0000\u000e\u007f\u0001\u0000\u0000\u0000\u0010\u0081\u0001\u0000\u0000"+
		"\u0000\u0012\u0089\u0001\u0000\u0000\u0000\u0014\u008d\u0001\u0000\u0000"+
		"\u0000\u0016\u0092\u0001\u0000\u0000\u0000\u0018\u0097\u0001\u0000\u0000"+
		"\u0000\u001a\u00a0\u0001\u0000\u0000\u0000\u001c\u00a8\u0001\u0000\u0000"+
		"\u0000\u001e\u00cd\u0001\u0000\u0000\u0000 \u00cf\u0001\u0000\u0000\u0000"+
		"\"\u00d1\u0001\u0000\u0000\u0000$\u00d4\u0001\u0000\u0000\u0000&\u00d8"+
		"\u0001\u0000\u0000\u0000(\u00df\u0001\u0000\u0000\u0000*\u00ea\u0001\u0000"+
		"\u0000\u0000,\u00fd\u0001\u0000\u0000\u0000.\u00ff\u0001\u0000\u0000\u0000"+
		"0\u0102\u0001\u0000\u0000\u00002\u0108\u0001\u0000\u0000\u00004\u010a"+
		"\u0001\u0000\u0000\u00006\u010c\u0001\u0000\u0000\u00008\u010e\u0001\u0000"+
		"\u0000\u0000:\u0110\u0001\u0000\u0000\u0000<\u0112\u0001\u0000\u0000\u0000"+
		">\u0114\u0001\u0000\u0000\u0000@\u0116\u0001\u0000\u0000\u0000B\u0118"+
		"\u0001\u0000\u0000\u0000D\u011a\u0001\u0000\u0000\u0000F\u011e\u0001\u0000"+
		"\u0000\u0000H\u0120\u0001\u0000\u0000\u0000J\u0124\u0001\u0000\u0000\u0000"+
		"L\u0126\u0001\u0000\u0000\u0000N\u012e\u0001\u0000\u0000\u0000P\u0134"+
		"\u0001\u0000\u0000\u0000R\u013b\u0001\u0000\u0000\u0000TU\u0003\u0002"+
		"\u0001\u0000UV\u0003\u0006\u0003\u0000VW\u0005\u0001\u0000\u0000W\u0001"+
		"\u0001\u0000\u0000\u0000XY\u0005\u0012\u0000\u0000Y[\u00051\u0000\u0000"+
		"Z\\\u0003\u0004\u0002\u0000[Z\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000"+
		"\u0000\\]\u0001\u0000\u0000\u0000]^\u0005\u0002\u0000\u0000^\u0003\u0001"+
		"\u0000\u0000\u0000_`\u0005\u0003\u0000\u0000`e\u00051\u0000\u0000ab\u0005"+
		"\u0004\u0000\u0000bd\u00051\u0000\u0000ca\u0001\u0000\u0000\u0000dg\u0001"+
		"\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000"+
		"fh\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000hi\u0005\u0005\u0000"+
		"\u0000i\u0005\u0001\u0000\u0000\u0000jk\u0003\b\u0004\u0000kl\u0003\f"+
		"\u0006\u0000l\u0007\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000"+
		"n\t\u0001\u0000\u0000\u0000oz\u0003\f\u0006\u0000pz\u0003\u0012\t\u0000"+
		"qz\u0003\u0014\n\u0000rz\u0003\"\u0011\u0000sz\u0003$\u0012\u0000tz\u0003"+
		"\u000e\u0007\u0000uz\u0003\u0016\u000b\u0000vz\u0003\u0018\f\u0000wz\u0003"+
		"\u001a\r\u0000xz\u0003\u001c\u000e\u0000yo\u0001\u0000\u0000\u0000yp\u0001"+
		"\u0000\u0000\u0000yq\u0001\u0000\u0000\u0000yr\u0001\u0000\u0000\u0000"+
		"ys\u0001\u0000\u0000\u0000yt\u0001\u0000\u0000\u0000yu\u0001\u0000\u0000"+
		"\u0000yv\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000yx\u0001\u0000"+
		"\u0000\u0000z\u000b\u0001\u0000\u0000\u0000{|\u0005\u0019\u0000\u0000"+
		"|}\u0003\u0010\b\u0000}~\u0005\u001a\u0000\u0000~\r\u0001\u0000\u0000"+
		"\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u000f\u0001\u0000\u0000"+
		"\u0000\u0081\u0086\u0003\n\u0005\u0000\u0082\u0083\u0005\u0002\u0000\u0000"+
		"\u0083\u0085\u0003\n\u0005\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0085"+
		"\u0088\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0086"+
		"\u0087\u0001\u0000\u0000\u0000\u0087\u0011\u0001\u0000\u0000\u0000\u0088"+
		"\u0086\u0001\u0000\u0000\u0000\u0089\u008a\u0003\u001e\u000f\u0000\u008a"+
		"\u008b\u0005\u0006\u0000\u0000\u008b\u008c\u0003 \u0010\u0000\u008c\u0013"+
		"\u0001\u0000\u0000\u0000\u008d\u008e\u0005$\u0000\u0000\u008e\u008f\u0003"+
		"\u0010\b\u0000\u008f\u0090\u0005%\u0000\u0000\u0090\u0091\u0003&\u0013"+
		"\u0000\u0091\u0015\u0001\u0000\u0000\u0000\u0092\u0093\u0005&\u0000\u0000"+
		"\u0093\u0094\u0003&\u0013\u0000\u0094\u0095\u0005\'\u0000\u0000\u0095"+
		"\u0096\u0003\n\u0005\u0000\u0096\u0017\u0001\u0000\u0000\u0000\u0097\u0098"+
		"\u0005(\u0000\u0000\u0098\u0099\u00051\u0000\u0000\u0099\u009a\u0005\u0006"+
		"\u0000\u0000\u009a\u009b\u0003&\u0013\u0000\u009b\u009c\u0007\u0000\u0000"+
		"\u0000\u009c\u009d\u0003&\u0013\u0000\u009d\u009e\u0005\'\u0000\u0000"+
		"\u009e\u009f\u0003\n\u0005\u0000\u009f\u0019\u0001\u0000\u0000\u0000\u00a0"+
		"\u00a1\u0005 \u0000\u0000\u00a1\u00a2\u0003&\u0013\u0000\u00a2\u00a3\u0005"+
		"!\u0000\u0000\u00a3\u00a6\u0003\n\u0005\u0000\u00a4\u00a5\u0005\"\u0000"+
		"\u0000\u00a5\u00a7\u0003\n\u0005\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u001b\u0001\u0000\u0000\u0000"+
		"\u00a8\u00a9\u0005#\u0000\u0000\u00a9\u00aa\u0003&\u0013\u0000\u00aa\u00c6"+
		"\u0005\u0016\u0000\u0000\u00ab\u00b0\u00030\u0018\u0000\u00ac\u00ad\u0005"+
		"\u0004\u0000\u0000\u00ad\u00af\u00030\u0018\u0000\u00ae\u00ac\u0001\u0000"+
		"\u0000\u0000\u00af\u00b2\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000"+
		"\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u00b3\u0001\u0000"+
		"\u0000\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005\u0007"+
		"\u0000\u0000\u00b4\u00c3\u0003\n\u0005\u0000\u00b5\u00b6\u0005\u0002\u0000"+
		"\u0000\u00b6\u00bb\u00030\u0018\u0000\u00b7\u00b8\u0005\u0004\u0000\u0000"+
		"\u00b8\u00ba\u00030\u0018\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00ba"+
		"\u00bd\u0001\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bb"+
		"\u00bc\u0001\u0000\u0000\u0000\u00bc\u00be\u0001\u0000\u0000\u0000\u00bd"+
		"\u00bb\u0001\u0000\u0000\u0000\u00be\u00bf\u0005\u0007\u0000\u0000\u00bf"+
		"\u00c0\u0003\n\u0005\u0000\u00c0\u00c2\u0001\u0000\u0000\u0000\u00c1\u00b5"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c5\u0001\u0000\u0000\u0000\u00c3\u00c1"+
		"\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4\u00c7"+
		"\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c6\u00ab"+
		"\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7\u00c9"+
		"\u0001\u0000\u0000\u0000\u00c8\u00ca\u0005\u0002\u0000\u0000\u00c9\u00c8"+
		"\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca\u00cb"+
		"\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005\u001a\u0000\u0000\u00cc\u001d"+
		"\u0001\u0000\u0000\u0000\u00cd\u00ce\u0003.\u0017\u0000\u00ce\u001f\u0001"+
		"\u0000\u0000\u0000\u00cf\u00d0\u0003&\u0013\u0000\u00d0!\u0001\u0000\u0000"+
		"\u0000\u00d1\u00d2\u0005+\u0000\u0000\u00d2\u00d3\u0003D\"\u0000\u00d3"+
		"#\u0001\u0000\u0000\u0000\u00d4\u00d6\u0005,\u0000\u0000\u00d5\u00d7\u0003"+
		"H$\u0000\u00d6\u00d5\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000"+
		"\u0000\u00d7%\u0001\u0000\u0000\u0000\u00d8\u00dc\u0003(\u0014\u0000\u00d9"+
		"\u00da\u0003>\u001f\u0000\u00da\u00db\u0003(\u0014\u0000\u00db\u00dd\u0001"+
		"\u0000\u0000\u0000\u00dc\u00d9\u0001\u0000\u0000\u0000\u00dc\u00dd\u0001"+
		"\u0000\u0000\u0000\u00dd\'\u0001\u0000\u0000\u0000\u00de\u00e0\u0003<"+
		"\u001e\u0000\u00df\u00de\u0001\u0000\u0000\u0000\u00df\u00e0\u0001\u0000"+
		"\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1\u00e7\u0003*\u0015"+
		"\u0000\u00e2\u00e3\u0003@ \u0000\u00e3\u00e4\u0003*\u0015\u0000\u00e4"+
		"\u00e6\u0001\u0000\u0000\u0000\u00e5\u00e2\u0001\u0000\u0000\u0000\u00e6"+
		"\u00e9\u0001\u0000\u0000\u0000\u00e7\u00e5\u0001\u0000\u0000\u0000\u00e7"+
		"\u00e8\u0001\u0000\u0000\u0000\u00e8)\u0001\u0000\u0000\u0000\u00e9\u00e7"+
		"\u0001\u0000\u0000\u0000\u00ea\u00f0\u0003,\u0016\u0000\u00eb\u00ec\u0003"+
		"B!\u0000\u00ec\u00ed\u0003,\u0016\u0000\u00ed\u00ef\u0001\u0000\u0000"+
		"\u0000\u00ee\u00eb\u0001\u0000\u0000\u0000\u00ef\u00f2\u0001\u0000\u0000"+
		"\u0000\u00f0\u00ee\u0001\u0000\u0000\u0000\u00f0\u00f1\u0001\u0000\u0000"+
		"\u0000\u00f1+\u0001\u0000\u0000\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000"+
		"\u00f3\u00fe\u0003.\u0017\u0000\u00f4\u00fe\u00030\u0018\u0000\u00f5\u00fe"+
		"\u00038\u001c\u0000\u00f6\u00fe\u0003:\u001d\u0000\u00f7\u00f8\u0005\u001f"+
		"\u0000\u0000\u00f8\u00fe\u0003,\u0016\u0000\u00f9\u00fa\u0005\u0003\u0000"+
		"\u0000\u00fa\u00fb\u0003&\u0013\u0000\u00fb\u00fc\u0005\u0005\u0000\u0000"+
		"\u00fc\u00fe\u0001\u0000\u0000\u0000\u00fd\u00f3\u0001\u0000\u0000\u0000"+
		"\u00fd\u00f4\u0001\u0000\u0000\u0000\u00fd\u00f5\u0001\u0000\u0000\u0000"+
		"\u00fd\u00f6\u0001\u0000\u0000\u0000\u00fd\u00f7\u0001\u0000\u0000\u0000"+
		"\u00fd\u00f9\u0001\u0000\u0000\u0000\u00fe-\u0001\u0000\u0000\u0000\u00ff"+
		"\u0100\u00051\u0000\u0000\u0100/\u0001\u0000\u0000\u0000\u0101\u0103\u0003"+
		"<\u001e\u0000\u0102\u0101\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000"+
		"\u0000\u0000\u0103\u0104\u0001\u0000\u0000\u0000\u0104\u0105\u00032\u0019"+
		"\u0000\u01051\u0001\u0000\u0000\u0000\u0106\u0109\u00034\u001a\u0000\u0107"+
		"\u0109\u00036\u001b\u0000\u0108\u0106\u0001\u0000\u0000\u0000\u0108\u0107"+
		"\u0001\u0000\u0000\u0000\u01093\u0001\u0000\u0000\u0000\u010a\u010b\u0005"+
		"2\u0000\u0000\u010b5\u0001\u0000\u0000\u0000\u010c\u010d\u00053\u0000"+
		"\u0000\u010d7\u0001\u0000\u0000\u0000\u010e\u010f\u00057\u0000\u0000\u010f"+
		"9\u0001\u0000\u0000\u0000\u0110\u0111\u00058\u0000\u0000\u0111;\u0001"+
		"\u0000\u0000\u0000\u0112\u0113\u0007\u0001\u0000\u0000\u0113=\u0001\u0000"+
		"\u0000\u0000\u0114\u0115\u0007\u0002\u0000\u0000\u0115?\u0001\u0000\u0000"+
		"\u0000\u0116\u0117\u0007\u0003\u0000\u0000\u0117A\u0001\u0000\u0000\u0000"+
		"\u0118\u0119\u0007\u0004\u0000\u0000\u0119C\u0001\u0000\u0000\u0000\u011a"+
		"\u011b\u0005\u0003\u0000\u0000\u011b\u011c\u0003F#\u0000\u011c\u011d\u0005"+
		"\u0005\u0000\u0000\u011dE\u0001\u0000\u0000\u0000\u011e\u011f\u0003L&"+
		"\u0000\u011fG\u0001\u0000\u0000\u0000\u0120\u0121\u0005\u0003\u0000\u0000"+
		"\u0121\u0122\u0003J%\u0000\u0122\u0123\u0005\u0005\u0000\u0000\u0123I"+
		"\u0001\u0000\u0000\u0000\u0124\u0125\u0003L&\u0000\u0125K\u0001\u0000"+
		"\u0000\u0000\u0126\u012b\u0003N\'\u0000\u0127\u0128\u0005\u0004\u0000"+
		"\u0000\u0128\u012a\u0003N\'\u0000\u0129\u0127\u0001\u0000\u0000\u0000"+
		"\u012a\u012d\u0001\u0000\u0000\u0000\u012b\u0129\u0001\u0000\u0000\u0000"+
		"\u012b\u012c\u0001\u0000\u0000\u0000\u012cM\u0001\u0000\u0000\u0000\u012d"+
		"\u012b\u0001\u0000\u0000\u0000\u012e\u0131\u0003&\u0013\u0000\u012f\u0130"+
		"\u0005\u0007\u0000\u0000\u0130\u0132\u0003P(\u0000\u0131\u012f\u0001\u0000"+
		"\u0000\u0000\u0131\u0132\u0001\u0000\u0000\u0000\u0132O\u0001\u0000\u0000"+
		"\u0000\u0133\u0135\u0003<\u001e\u0000\u0134\u0133\u0001\u0000\u0000\u0000"+
		"\u0134\u0135\u0001\u0000\u0000\u0000\u0135\u0136\u0001\u0000\u0000\u0000"+
		"\u0136\u0139\u00034\u001a\u0000\u0137\u0138\u0005\u0007\u0000\u0000\u0138"+
		"\u013a\u0003R)\u0000\u0139\u0137\u0001\u0000\u0000\u0000\u0139\u013a\u0001"+
		"\u0000\u0000\u0000\u013aQ\u0001\u0000\u0000\u0000\u013b\u013c\u00034\u001a"+
		"\u0000\u013cS\u0001\u0000\u0000\u0000\u0016[ey\u0086\u00a6\u00b0\u00bb"+
		"\u00c3\u00c6\u00c9\u00d6\u00dc\u00df\u00e7\u00f0\u00fd\u0102\u0108\u012b"+
		"\u0131\u0134\u0139";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}