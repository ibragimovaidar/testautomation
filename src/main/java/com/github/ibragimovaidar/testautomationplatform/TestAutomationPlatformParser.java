// Generated from com.github.ibragimovaidar/TestAutomationPlatform.g4 by ANTLR 4.7.1
package com.github.ibragimovaidar.testautomationplatform;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TestAutomationPlatformParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		HTTP=10, DB=11, ASSERT=12, WS=13, CRLF=14, StringLiteral=15;
	public static final int
		RULE_prog = 0, RULE_commands = 1, RULE_http_command = 2, RULE_http_method = 3, 
		RULE_http_url = 4;
	public static final String[] ruleNames = {
		"prog", "commands", "http_command", "http_method", "http_url"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'http '", "' '", "';'", "'GET'", "'POST'", "'PUT'", "'DELETE'", 
		"'PATCH'", "'OPTIONS'", "'http'", "'db'", "'assert'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "HTTP", "DB", 
		"ASSERT", "WS", "CRLF", "StringLiteral"
	};
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
	public String getGrammarFileName() { return "TestAutomationPlatform.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TestAutomationPlatformParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public CommandsContext commands() {
			return getRuleContext(CommandsContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestAutomationPlatformListener) ((TestAutomationPlatformListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestAutomationPlatformListener) ((TestAutomationPlatformListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			commands();
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

	public static class CommandsContext extends ParserRuleContext {
		public List<Http_commandContext> http_command() {
			return getRuleContexts(Http_commandContext.class);
		}
		public Http_commandContext http_command(int i) {
			return getRuleContext(Http_commandContext.class,i);
		}
		public CommandsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commands; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestAutomationPlatformListener) ((TestAutomationPlatformListener)listener).enterCommands(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestAutomationPlatformListener) ((TestAutomationPlatformListener)listener).exitCommands(this);
		}
	}

	public final CommandsContext commands() throws RecognitionException {
		CommandsContext _localctx = new CommandsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_commands);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(12);
				http_command();
				}
				}
				setState(15); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
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

	public static class Http_commandContext extends ParserRuleContext {
		public Http_methodContext http_method() {
			return getRuleContext(Http_methodContext.class,0);
		}
		public Http_urlContext http_url() {
			return getRuleContext(Http_urlContext.class,0);
		}
		public Http_commandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_http_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestAutomationPlatformListener) ((TestAutomationPlatformListener)listener).enterHttp_command(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestAutomationPlatformListener) ((TestAutomationPlatformListener)listener).exitHttp_command(this);
		}
	}

	public final Http_commandContext http_command() throws RecognitionException {
		Http_commandContext _localctx = new Http_commandContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_http_command);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			match(T__0);
			setState(18);
			http_method();
			setState(19);
			match(T__1);
			setState(20);
			http_url();
			setState(21);
			match(T__2);
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

	public static class Http_methodContext extends ParserRuleContext {
		public Http_methodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_http_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestAutomationPlatformListener) ((TestAutomationPlatformListener)listener).enterHttp_method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestAutomationPlatformListener) ((TestAutomationPlatformListener)listener).exitHttp_method(this);
		}
	}

	public final Http_methodContext http_method() throws RecognitionException {
		Http_methodContext _localctx = new Http_methodContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_http_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8))) != 0)) ) {
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

	public static class Http_urlContext extends ParserRuleContext {
		public TerminalNode StringLiteral() { return getToken(TestAutomationPlatformParser.StringLiteral, 0); }
		public Http_urlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_http_url; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TestAutomationPlatformListener) ((TestAutomationPlatformListener)listener).enterHttp_url(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TestAutomationPlatformListener) ((TestAutomationPlatformListener)listener).exitHttp_url(this);
		}
	}

	public final Http_urlContext http_url() throws RecognitionException {
		Http_urlContext _localctx = new Http_urlContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_http_url);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			match(StringLiteral);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\21\36\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\3\6\3\20\n\3\r\3\16\3\21\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\2\2\7\2\4\6\b\n\2\3\3\2\6\13\2"+
		"\31\2\f\3\2\2\2\4\17\3\2\2\2\6\23\3\2\2\2\b\31\3\2\2\2\n\33\3\2\2\2\f"+
		"\r\5\4\3\2\r\3\3\2\2\2\16\20\5\6\4\2\17\16\3\2\2\2\20\21\3\2\2\2\21\17"+
		"\3\2\2\2\21\22\3\2\2\2\22\5\3\2\2\2\23\24\7\3\2\2\24\25\5\b\5\2\25\26"+
		"\7\4\2\2\26\27\5\n\6\2\27\30\7\5\2\2\30\7\3\2\2\2\31\32\t\2\2\2\32\t\3"+
		"\2\2\2\33\34\7\21\2\2\34\13\3\2\2\2\3\21";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}