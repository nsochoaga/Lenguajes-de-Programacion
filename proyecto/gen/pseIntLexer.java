// Generated from C:/Users/juand/OneDrive/Documentos/Interprete/AnalizadorSemantico/grammar\pseInt.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class pseIntLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, CM=2, CADENA=3, CARACTER=4, ENTERO=5, LOGICO=6, NUMERICO=7, NUMERO=8, 
		REAL=9, TEXTO=10, VERDADERO=11, FALSO=12, PROCESO=13, ALGORITMO=14, FINPROCESO=15, 
		FINALGORITMO=16, SUBPROCESO=17, FUNCION=18, FINSUBPROCESO=19, FINFUNCION=20, 
		DEFINIR=21, COMO=22, LEER=23, ESCRIBIR=24, DIMENSION=25, SI=26, ENTONCES=27, 
		FINSI=28, SINO=29, PARA=30, HASTA=31, HACER=32, FINPARA=33, CON=34, PASO=35, 
		MIENTRAS=36, FINMIENTRAS=37, REPETIR=38, QUE=39, SEGUN=40, FINSEGUN=41, 
		CASO=42, DE=43, OTRO=44, MODO=45, ESPERAR=46, TECLA=47, SEGUNDOS=48, SEGUNDO=49, 
		MILISEGUNDOS=50, PANTALLA=51, BORRAR=52, LIMPIAR=53, TOKEN_PAR_IZQ=54, 
		TOKEN_PAR_DER=55, TOKEN_ENTERO=56, TOKEN_REAL=57, TOKEN_IGUAL=58, TOKEN_MAYOR_IGUAL=59, 
		TOKEN_MENOR_IGUAL=60, TOKEN_DIF=61, TOKEN_MAYOR=62, TOKEN_MENOR=63, TOKEN_O=64, 
		TOKEN_Y=65, TOKEN_NO=66, TOKEN_MOD=67, TOKEN_MAS=68, TOKEN_MENOS=69, TOKEN_MUL=70, 
		TOKEN_DIV=71, TOKEN_POT=72, TOKEN_PYC=73, TOKEN_COMA=74, TOKEN_COR_DER=75, 
		TOKEN_COR_IZQ=76, TOKEN_DOSP=77, TOKEN_ASIG=78, TOKEN_CADENA=79, ID=80;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS", "CM", "CADENA", "CARACTER", "ENTERO", "LOGICO", "NUMERICO", "NUMERO", 
			"REAL", "TEXTO", "VERDADERO", "FALSO", "PROCESO", "ALGORITMO", "FINPROCESO", 
			"FINALGORITMO", "SUBPROCESO", "FUNCION", "FINSUBPROCESO", "FINFUNCION", 
			"DEFINIR", "COMO", "LEER", "ESCRIBIR", "DIMENSION", "SI", "ENTONCES", 
			"FINSI", "SINO", "PARA", "HASTA", "HACER", "FINPARA", "CON", "PASO", 
			"MIENTRAS", "FINMIENTRAS", "REPETIR", "QUE", "SEGUN", "FINSEGUN", "CASO", 
			"DE", "OTRO", "MODO", "ESPERAR", "TECLA", "SEGUNDOS", "SEGUNDO", "MILISEGUNDOS", 
			"PANTALLA", "BORRAR", "LIMPIAR", "TOKEN_PAR_IZQ", "TOKEN_PAR_DER", "TOKEN_ENTERO", 
			"TOKEN_REAL", "TOKEN_IGUAL", "TOKEN_MAYOR_IGUAL", "TOKEN_MENOR_IGUAL", 
			"TOKEN_DIF", "TOKEN_MAYOR", "TOKEN_MENOR", "TOKEN_O", "TOKEN_Y", "TOKEN_NO", 
			"TOKEN_MOD", "TOKEN_MAS", "TOKEN_MENOS", "TOKEN_MUL", "TOKEN_DIV", "TOKEN_POT", 
			"TOKEN_PYC", "TOKEN_COMA", "TOKEN_COR_DER", "TOKEN_COR_IZQ", "TOKEN_DOSP", 
			"TOKEN_ASIG", "TOKEN_CADENA", "ID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "'('", "')'", null, null, "'='", 
			"'>='", "'<='", "'<>'", "'>'", "'<'", null, null, null, null, "'+'", 
			"'-'", "'*'", "'/'", "'^'", "';'", "','", "']'", "'['", "':'", "'<-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "CM", "CADENA", "CARACTER", "ENTERO", "LOGICO", "NUMERICO", 
			"NUMERO", "REAL", "TEXTO", "VERDADERO", "FALSO", "PROCESO", "ALGORITMO", 
			"FINPROCESO", "FINALGORITMO", "SUBPROCESO", "FUNCION", "FINSUBPROCESO", 
			"FINFUNCION", "DEFINIR", "COMO", "LEER", "ESCRIBIR", "DIMENSION", "SI", 
			"ENTONCES", "FINSI", "SINO", "PARA", "HASTA", "HACER", "FINPARA", "CON", 
			"PASO", "MIENTRAS", "FINMIENTRAS", "REPETIR", "QUE", "SEGUN", "FINSEGUN", 
			"CASO", "DE", "OTRO", "MODO", "ESPERAR", "TECLA", "SEGUNDOS", "SEGUNDO", 
			"MILISEGUNDOS", "PANTALLA", "BORRAR", "LIMPIAR", "TOKEN_PAR_IZQ", "TOKEN_PAR_DER", 
			"TOKEN_ENTERO", "TOKEN_REAL", "TOKEN_IGUAL", "TOKEN_MAYOR_IGUAL", "TOKEN_MENOR_IGUAL", 
			"TOKEN_DIF", "TOKEN_MAYOR", "TOKEN_MENOR", "TOKEN_O", "TOKEN_Y", "TOKEN_NO", 
			"TOKEN_MOD", "TOKEN_MAS", "TOKEN_MENOS", "TOKEN_MUL", "TOKEN_DIV", "TOKEN_POT", 
			"TOKEN_PYC", "TOKEN_COMA", "TOKEN_COR_DER", "TOKEN_COR_IZQ", "TOKEN_DOSP", 
			"TOKEN_ASIG", "TOKEN_CADENA", "ID"
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


	public pseIntLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "pseInt.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2R\u0291\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\3\2\6\2\u00a5\n\2"+
		"\r\2\16\2\u00a6\3\2\3\2\3\3\3\3\3\3\3\3\7\3\u00af\n\3\f\3\16\3\u00b2\13"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3"+
		"\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3"+
		"(\3(\3(\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3"+
		",\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3\60\3\60"+
		"\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66"+
		"\3\66\3\66\3\67\3\67\38\38\39\69\u023e\n9\r9\169\u023f\3:\6:\u0243\n:"+
		"\r:\16:\u0244\3:\3:\6:\u0249\n:\r:\16:\u024a\3;\3;\3<\3<\3<\3=\3=\3=\3"+
		">\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3C\5C\u0263\nC\3D\3D\3D\3D\5D\u0269"+
		"\nD\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O"+
		"\3O\3P\3P\7P\u0284\nP\fP\16P\u0287\13P\3P\3P\3Q\3Q\7Q\u028d\nQ\fQ\16Q"+
		"\u0290\13Q\2\2R\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64"+
		"g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\u0089"+
		"F\u008bG\u008dH\u008fI\u0091J\u0093K\u0095L\u0097M\u0099N\u009bO\u009d"+
		"P\u009fQ\u00a1R\3\2\36\5\2\13\f\17\17\"\"\4\2\f\f\17\17\4\2EEee\4\2CC"+
		"cc\4\2FFff\4\2GGgg\4\2PPpp\4\2TTtt\4\2VVvv\4\2QQqq\4\2NNnn\4\2IIii\4\2"+
		"KKkk\4\2WWww\4\2OOoo\4\2ZZzz\4\2XXxx\4\2HHhh\4\2UUuu\4\2RRrr\4\2DDdd\4"+
		"\2JJjj\4\2SSss\4\2qq~~\4\2(({{\4\2$$))\4\2C\\c|\6\2\62;C\\aac|\2\u0299"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2"+
		"\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2"+
		"{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085"+
		"\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2"+
		"\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097"+
		"\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2"+
		"\2\2\u00a1\3\2\2\2\3\u00a4\3\2\2\2\5\u00aa\3\2\2\2\7\u00b5\3\2\2\2\t\u00bc"+
		"\3\2\2\2\13\u00c5\3\2\2\2\r\u00cc\3\2\2\2\17\u00d3\3\2\2\2\21\u00dc\3"+
		"\2\2\2\23\u00e3\3\2\2\2\25\u00e8\3\2\2\2\27\u00ee\3\2\2\2\31\u00f8\3\2"+
		"\2\2\33\u00fe\3\2\2\2\35\u0106\3\2\2\2\37\u0110\3\2\2\2!\u011b\3\2\2\2"+
		"#\u0128\3\2\2\2%\u0133\3\2\2\2\'\u013b\3\2\2\2)\u0149\3\2\2\2+\u0154\3"+
		"\2\2\2-\u015c\3\2\2\2/\u0161\3\2\2\2\61\u0166\3\2\2\2\63\u016f\3\2\2\2"+
		"\65\u0179\3\2\2\2\67\u017c\3\2\2\29\u0185\3\2\2\2;\u018b\3\2\2\2=\u0190"+
		"\3\2\2\2?\u0195\3\2\2\2A\u019b\3\2\2\2C\u01a1\3\2\2\2E\u01a9\3\2\2\2G"+
		"\u01ad\3\2\2\2I\u01b2\3\2\2\2K\u01bb\3\2\2\2M\u01c7\3\2\2\2O\u01cf\3\2"+
		"\2\2Q\u01d3\3\2\2\2S\u01d9\3\2\2\2U\u01e2\3\2\2\2W\u01e7\3\2\2\2Y\u01ea"+
		"\3\2\2\2[\u01ef\3\2\2\2]\u01f4\3\2\2\2_\u01fc\3\2\2\2a\u0202\3\2\2\2c"+
		"\u020b\3\2\2\2e\u0213\3\2\2\2g\u0220\3\2\2\2i\u0229\3\2\2\2k\u0230\3\2"+
		"\2\2m\u0238\3\2\2\2o\u023a\3\2\2\2q\u023d\3\2\2\2s\u0242\3\2\2\2u\u024c"+
		"\3\2\2\2w\u024e\3\2\2\2y\u0251\3\2\2\2{\u0254\3\2\2\2}\u0257\3\2\2\2\177"+
		"\u0259\3\2\2\2\u0081\u025b\3\2\2\2\u0083\u025d\3\2\2\2\u0085\u0262\3\2"+
		"\2\2\u0087\u0268\3\2\2\2\u0089\u026a\3\2\2\2\u008b\u026c\3\2\2\2\u008d"+
		"\u026e\3\2\2\2\u008f\u0270\3\2\2\2\u0091\u0272\3\2\2\2\u0093\u0274\3\2"+
		"\2\2\u0095\u0276\3\2\2\2\u0097\u0278\3\2\2\2\u0099\u027a\3\2\2\2\u009b"+
		"\u027c\3\2\2\2\u009d\u027e\3\2\2\2\u009f\u0281\3\2\2\2\u00a1\u028a\3\2"+
		"\2\2\u00a3\u00a5\t\2\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6"+
		"\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\b\2"+
		"\2\2\u00a9\4\3\2\2\2\u00aa\u00ab\7\61\2\2\u00ab\u00ac\7\61\2\2\u00ac\u00b0"+
		"\3\2\2\2\u00ad\u00af\n\3\2\2\u00ae\u00ad\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0"+
		"\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00b0\3\2"+
		"\2\2\u00b3\u00b4\b\3\2\2\u00b4\6\3\2\2\2\u00b5\u00b6\t\4\2\2\u00b6\u00b7"+
		"\t\5\2\2\u00b7\u00b8\t\6\2\2\u00b8\u00b9\t\7\2\2\u00b9\u00ba\t\b\2\2\u00ba"+
		"\u00bb\t\5\2\2\u00bb\b\3\2\2\2\u00bc\u00bd\t\4\2\2\u00bd\u00be\t\5\2\2"+
		"\u00be\u00bf\t\t\2\2\u00bf\u00c0\t\5\2\2\u00c0\u00c1\t\4\2\2\u00c1\u00c2"+
		"\t\n\2\2\u00c2\u00c3\t\7\2\2\u00c3\u00c4\t\t\2\2\u00c4\n\3\2\2\2\u00c5"+
		"\u00c6\t\7\2\2\u00c6\u00c7\t\b\2\2\u00c7\u00c8\t\n\2\2\u00c8\u00c9\t\7"+
		"\2\2\u00c9\u00ca\t\t\2\2\u00ca\u00cb\t\13\2\2\u00cb\f\3\2\2\2\u00cc\u00cd"+
		"\t\f\2\2\u00cd\u00ce\t\13\2\2\u00ce\u00cf\t\r\2\2\u00cf\u00d0\t\16\2\2"+
		"\u00d0\u00d1\t\4\2\2\u00d1\u00d2\t\13\2\2\u00d2\16\3\2\2\2\u00d3\u00d4"+
		"\t\b\2\2\u00d4\u00d5\t\17\2\2\u00d5\u00d6\t\20\2\2\u00d6\u00d7\t\7\2\2"+
		"\u00d7\u00d8\t\t\2\2\u00d8\u00d9\t\16\2\2\u00d9\u00da\t\4\2\2\u00da\u00db"+
		"\t\13\2\2\u00db\20\3\2\2\2\u00dc\u00dd\t\b\2\2\u00dd\u00de\t\17\2\2\u00de"+
		"\u00df\t\20\2\2\u00df\u00e0\t\7\2\2\u00e0\u00e1\t\t\2\2\u00e1\u00e2\t"+
		"\13\2\2\u00e2\22\3\2\2\2\u00e3\u00e4\t\t\2\2\u00e4\u00e5\t\7\2\2\u00e5"+
		"\u00e6\t\5\2\2\u00e6\u00e7\t\f\2\2\u00e7\24\3\2\2\2\u00e8\u00e9\t\n\2"+
		"\2\u00e9\u00ea\t\7\2\2\u00ea\u00eb\t\21\2\2\u00eb\u00ec\t\n\2\2\u00ec"+
		"\u00ed\t\13\2\2\u00ed\26\3\2\2\2\u00ee\u00ef\t\22\2\2\u00ef\u00f0\t\7"+
		"\2\2\u00f0\u00f1\t\t\2\2\u00f1\u00f2\t\6\2\2\u00f2\u00f3\t\5\2\2\u00f3"+
		"\u00f4\t\6\2\2\u00f4\u00f5\t\7\2\2\u00f5\u00f6\t\t\2\2\u00f6\u00f7\t\13"+
		"\2\2\u00f7\30\3\2\2\2\u00f8\u00f9\t\23\2\2\u00f9\u00fa\t\5\2\2\u00fa\u00fb"+
		"\t\f\2\2\u00fb\u00fc\t\24\2\2\u00fc\u00fd\t\13\2\2\u00fd\32\3\2\2\2\u00fe"+
		"\u00ff\t\25\2\2\u00ff\u0100\t\t\2\2\u0100\u0101\t\13\2\2\u0101\u0102\t"+
		"\4\2\2\u0102\u0103\t\7\2\2\u0103\u0104\t\24\2\2\u0104\u0105\t\13\2\2\u0105"+
		"\34\3\2\2\2\u0106\u0107\t\5\2\2\u0107\u0108\t\f\2\2\u0108\u0109\t\r\2"+
		"\2\u0109\u010a\t\13\2\2\u010a\u010b\t\t\2\2\u010b\u010c\t\16\2\2\u010c"+
		"\u010d\t\n\2\2\u010d\u010e\t\20\2\2\u010e\u010f\t\13\2\2\u010f\36\3\2"+
		"\2\2\u0110\u0111\t\23\2\2\u0111\u0112\t\16\2\2\u0112\u0113\t\b\2\2\u0113"+
		"\u0114\t\25\2\2\u0114\u0115\t\t\2\2\u0115\u0116\t\13\2\2\u0116\u0117\t"+
		"\4\2\2\u0117\u0118\t\7\2\2\u0118\u0119\t\24\2\2\u0119\u011a\t\13\2\2\u011a"+
		" \3\2\2\2\u011b\u011c\t\23\2\2\u011c\u011d\t\16\2\2\u011d\u011e\t\b\2"+
		"\2\u011e\u011f\t\5\2\2\u011f\u0120\t\f\2\2\u0120\u0121\t\r\2\2\u0121\u0122"+
		"\t\13\2\2\u0122\u0123\t\t\2\2\u0123\u0124\t\16\2\2\u0124\u0125\t\n\2\2"+
		"\u0125\u0126\t\20\2\2\u0126\u0127\t\13\2\2\u0127\"\3\2\2\2\u0128\u0129"+
		"\t\24\2\2\u0129\u012a\t\17\2\2\u012a\u012b\t\26\2\2\u012b\u012c\t\25\2"+
		"\2\u012c\u012d\t\t\2\2\u012d\u012e\t\13\2\2\u012e\u012f\t\4\2\2\u012f"+
		"\u0130\t\7\2\2\u0130\u0131\t\24\2\2\u0131\u0132\t\13\2\2\u0132$\3\2\2"+
		"\2\u0133\u0134\t\23\2\2\u0134\u0135\t\17\2\2\u0135\u0136\t\b\2\2\u0136"+
		"\u0137\t\4\2\2\u0137\u0138\t\16\2\2\u0138\u0139\t\13\2\2\u0139\u013a\t"+
		"\b\2\2\u013a&\3\2\2\2\u013b\u013c\t\23\2\2\u013c\u013d\t\16\2\2\u013d"+
		"\u013e\t\b\2\2\u013e\u013f\t\24\2\2\u013f\u0140\t\17\2\2\u0140\u0141\t"+
		"\26\2\2\u0141\u0142\t\25\2\2\u0142\u0143\t\t\2\2\u0143\u0144\t\13\2\2"+
		"\u0144\u0145\t\4\2\2\u0145\u0146\t\7\2\2\u0146\u0147\t\24\2\2\u0147\u0148"+
		"\t\13\2\2\u0148(\3\2\2\2\u0149\u014a\t\23\2\2\u014a\u014b\t\16\2\2\u014b"+
		"\u014c\t\b\2\2\u014c\u014d\t\23\2\2\u014d\u014e\t\17\2\2\u014e\u014f\t"+
		"\b\2\2\u014f\u0150\t\4\2\2\u0150\u0151\t\16\2\2\u0151\u0152\t\13\2\2\u0152"+
		"\u0153\t\b\2\2\u0153*\3\2\2\2\u0154\u0155\t\6\2\2\u0155\u0156\t\7\2\2"+
		"\u0156\u0157\t\23\2\2\u0157\u0158\t\16\2\2\u0158\u0159\t\b\2\2\u0159\u015a"+
		"\t\16\2\2\u015a\u015b\t\t\2\2\u015b,\3\2\2\2\u015c\u015d\t\4\2\2\u015d"+
		"\u015e\t\13\2\2\u015e\u015f\t\20\2\2\u015f\u0160\t\13\2\2\u0160.\3\2\2"+
		"\2\u0161\u0162\t\f\2\2\u0162\u0163\t\7\2\2\u0163\u0164\t\7\2\2\u0164\u0165"+
		"\t\t\2\2\u0165\60\3\2\2\2\u0166\u0167\t\7\2\2\u0167\u0168\t\24\2\2\u0168"+
		"\u0169\t\4\2\2\u0169\u016a\t\t\2\2\u016a\u016b\t\16\2\2\u016b\u016c\t"+
		"\26\2\2\u016c\u016d\t\16\2\2\u016d\u016e\t\t\2\2\u016e\62\3\2\2\2\u016f"+
		"\u0170\t\6\2\2\u0170\u0171\t\16\2\2\u0171\u0172\t\20\2\2\u0172\u0173\t"+
		"\7\2\2\u0173\u0174\t\b\2\2\u0174\u0175\t\24\2\2\u0175\u0176\t\16\2\2\u0176"+
		"\u0177\t\13\2\2\u0177\u0178\t\b\2\2\u0178\64\3\2\2\2\u0179\u017a\t\24"+
		"\2\2\u017a\u017b\t\16\2\2\u017b\66\3\2\2\2\u017c\u017d\t\7\2\2\u017d\u017e"+
		"\t\b\2\2\u017e\u017f\t\n\2\2\u017f\u0180\t\13\2\2\u0180\u0181\t\b\2\2"+
		"\u0181\u0182\t\4\2\2\u0182\u0183\t\7\2\2\u0183\u0184\t\24\2\2\u01848\3"+
		"\2\2\2\u0185\u0186\t\23\2\2\u0186\u0187\t\16\2\2\u0187\u0188\t\b\2\2\u0188"+
		"\u0189\t\24\2\2\u0189\u018a\t\16\2\2\u018a:\3\2\2\2\u018b\u018c\t\24\2"+
		"\2\u018c\u018d\t\16\2\2\u018d\u018e\t\b\2\2\u018e\u018f\t\13\2\2\u018f"+
		"<\3\2\2\2\u0190\u0191\t\25\2\2\u0191\u0192\t\5\2\2\u0192\u0193\t\t\2\2"+
		"\u0193\u0194\t\5\2\2\u0194>\3\2\2\2\u0195\u0196\t\27\2\2\u0196\u0197\t"+
		"\5\2\2\u0197\u0198\t\24\2\2\u0198\u0199\t\n\2\2\u0199\u019a\t\5\2\2\u019a"+
		"@\3\2\2\2\u019b\u019c\t\27\2\2\u019c\u019d\t\5\2\2\u019d\u019e\t\4\2\2"+
		"\u019e\u019f\t\7\2\2\u019f\u01a0\t\t\2\2\u01a0B\3\2\2\2\u01a1\u01a2\t"+
		"\23\2\2\u01a2\u01a3\t\16\2\2\u01a3\u01a4\t\b\2\2\u01a4\u01a5\t\25\2\2"+
		"\u01a5\u01a6\t\5\2\2\u01a6\u01a7\t\t\2\2\u01a7\u01a8\t\5\2\2\u01a8D\3"+
		"\2\2\2\u01a9\u01aa\t\4\2\2\u01aa\u01ab\t\13\2\2\u01ab\u01ac\t\b\2\2\u01ac"+
		"F\3\2\2\2\u01ad\u01ae\t\25\2\2\u01ae\u01af\t\5\2\2\u01af\u01b0\t\24\2"+
		"\2\u01b0\u01b1\t\13\2\2\u01b1H\3\2\2\2\u01b2\u01b3\t\20\2\2\u01b3\u01b4"+
		"\t\16\2\2\u01b4\u01b5\t\7\2\2\u01b5\u01b6\t\b\2\2\u01b6\u01b7\t\n\2\2"+
		"\u01b7\u01b8\t\t\2\2\u01b8\u01b9\t\5\2\2\u01b9\u01ba\t\24\2\2\u01baJ\3"+
		"\2\2\2\u01bb\u01bc\t\23\2\2\u01bc\u01bd\t\16\2\2\u01bd\u01be\t\b\2\2\u01be"+
		"\u01bf\t\20\2\2\u01bf\u01c0\t\16\2\2\u01c0\u01c1\t\7\2\2\u01c1\u01c2\t"+
		"\b\2\2\u01c2\u01c3\t\n\2\2\u01c3\u01c4\t\t\2\2\u01c4\u01c5\t\5\2\2\u01c5"+
		"\u01c6\t\24\2\2\u01c6L\3\2\2\2\u01c7\u01c8\t\t\2\2\u01c8\u01c9\t\7\2\2"+
		"\u01c9\u01ca\t\25\2\2\u01ca\u01cb\t\7\2\2\u01cb\u01cc\t\n\2\2\u01cc\u01cd"+
		"\t\16\2\2\u01cd\u01ce\t\t\2\2\u01ceN\3\2\2\2\u01cf\u01d0\t\30\2\2\u01d0"+
		"\u01d1\t\17\2\2\u01d1\u01d2\t\7\2\2\u01d2P\3\2\2\2\u01d3\u01d4\t\24\2"+
		"\2\u01d4\u01d5\t\7\2\2\u01d5\u01d6\t\r\2\2\u01d6\u01d7\t\17\2\2\u01d7"+
		"\u01d8\t\b\2\2\u01d8R\3\2\2\2\u01d9\u01da\t\23\2\2\u01da\u01db\t\16\2"+
		"\2\u01db\u01dc\t\b\2\2\u01dc\u01dd\t\24\2\2\u01dd\u01de\t\7\2\2\u01de"+
		"\u01df\t\r\2\2\u01df\u01e0\t\17\2\2\u01e0\u01e1\t\b\2\2\u01e1T\3\2\2\2"+
		"\u01e2\u01e3\t\4\2\2\u01e3\u01e4\t\5\2\2\u01e4\u01e5\t\24\2\2\u01e5\u01e6"+
		"\t\13\2\2\u01e6V\3\2\2\2\u01e7\u01e8\t\6\2\2\u01e8\u01e9\t\7\2\2\u01e9"+
		"X\3\2\2\2\u01ea\u01eb\t\13\2\2\u01eb\u01ec\t\n\2\2\u01ec\u01ed\t\t\2\2"+
		"\u01ed\u01ee\t\13\2\2\u01eeZ\3\2\2\2\u01ef\u01f0\t\20\2\2\u01f0\u01f1"+
		"\t\13\2\2\u01f1\u01f2\t\6\2\2\u01f2\u01f3\t\13\2\2\u01f3\\\3\2\2\2\u01f4"+
		"\u01f5\t\7\2\2\u01f5\u01f6\t\24\2\2\u01f6\u01f7\t\25\2\2\u01f7\u01f8\t"+
		"\7\2\2\u01f8\u01f9\t\t\2\2\u01f9\u01fa\t\5\2\2\u01fa\u01fb\t\t\2\2\u01fb"+
		"^\3\2\2\2\u01fc\u01fd\t\n\2\2\u01fd\u01fe\t\7\2\2\u01fe\u01ff\t\4\2\2"+
		"\u01ff\u0200\t\f\2\2\u0200\u0201\t\5\2\2\u0201`\3\2\2\2\u0202\u0203\t"+
		"\24\2\2\u0203\u0204\t\7\2\2\u0204\u0205\t\r\2\2\u0205\u0206\t\17\2\2\u0206"+
		"\u0207\t\b\2\2\u0207\u0208\t\6\2\2\u0208\u0209\t\13\2\2\u0209\u020a\t"+
		"\24\2\2\u020ab\3\2\2\2\u020b\u020c\t\24\2\2\u020c\u020d\t\7\2\2\u020d"+
		"\u020e\t\r\2\2\u020e\u020f\t\17\2\2\u020f\u0210\t\b\2\2\u0210\u0211\t"+
		"\6\2\2\u0211\u0212\t\13\2\2\u0212d\3\2\2\2\u0213\u0214\t\20\2\2\u0214"+
		"\u0215\t\16\2\2\u0215\u0216\t\f\2\2\u0216\u0217\t\16\2\2\u0217\u0218\t"+
		"\24\2\2\u0218\u0219\t\7\2\2\u0219\u021a\t\r\2\2\u021a\u021b\t\17\2\2\u021b"+
		"\u021c\t\b\2\2\u021c\u021d\t\6\2\2\u021d\u021e\t\13\2\2\u021e\u021f\t"+
		"\24\2\2\u021ff\3\2\2\2\u0220\u0221\t\25\2\2\u0221\u0222\t\5\2\2\u0222"+
		"\u0223\t\b\2\2\u0223\u0224\t\n\2\2\u0224\u0225\t\5\2\2\u0225\u0226\t\f"+
		"\2\2\u0226\u0227\t\f\2\2\u0227\u0228\t\5\2\2\u0228h\3\2\2\2\u0229\u022a"+
		"\t\26\2\2\u022a\u022b\t\13\2\2\u022b\u022c\t\t\2\2\u022c\u022d\t\t\2\2"+
		"\u022d\u022e\t\5\2\2\u022e\u022f\t\t\2\2\u022fj\3\2\2\2\u0230\u0231\t"+
		"\f\2\2\u0231\u0232\t\16\2\2\u0232\u0233\t\20\2\2\u0233\u0234\t\25\2\2"+
		"\u0234\u0235\t\16\2\2\u0235\u0236\t\5\2\2\u0236\u0237\t\t\2\2\u0237l\3"+
		"\2\2\2\u0238\u0239\7*\2\2\u0239n\3\2\2\2\u023a\u023b\7+\2\2\u023bp\3\2"+
		"\2\2\u023c\u023e\4\62;\2\u023d\u023c\3\2\2\2\u023e\u023f\3\2\2\2\u023f"+
		"\u023d\3\2\2\2\u023f\u0240\3\2\2\2\u0240r\3\2\2\2\u0241\u0243\4\62;\2"+
		"\u0242\u0241\3\2\2\2\u0243\u0244\3\2\2\2\u0244\u0242\3\2\2\2\u0244\u0245"+
		"\3\2\2\2\u0245\u0246\3\2\2\2\u0246\u0248\7\60\2\2\u0247\u0249\4\62;\2"+
		"\u0248\u0247\3\2\2\2\u0249\u024a\3\2\2\2\u024a\u0248\3\2\2\2\u024a\u024b"+
		"\3\2\2\2\u024bt\3\2\2\2\u024c\u024d\7?\2\2\u024dv\3\2\2\2\u024e\u024f"+
		"\7@\2\2\u024f\u0250\7?\2\2\u0250x\3\2\2\2\u0251\u0252\7>\2\2\u0252\u0253"+
		"\7?\2\2\u0253z\3\2\2\2\u0254\u0255\7>\2\2\u0255\u0256\7@\2\2\u0256|\3"+
		"\2\2\2\u0257\u0258\7@\2\2\u0258~\3\2\2\2\u0259\u025a\7>\2\2\u025a\u0080"+
		"\3\2\2\2\u025b\u025c\t\31\2\2\u025c\u0082\3\2\2\2\u025d\u025e\t\32\2\2"+
		"\u025e\u0084\3\2\2\2\u025f\u0260\7p\2\2\u0260\u0263\7q\2\2\u0261\u0263"+
		"\7\u0080\2\2\u0262\u025f\3\2\2\2\u0262\u0261\3\2\2\2\u0263\u0086\3\2\2"+
		"\2\u0264\u0265\7o\2\2\u0265\u0266\7q\2\2\u0266\u0269\7f\2\2\u0267\u0269"+
		"\7\'\2\2\u0268\u0264\3\2\2\2\u0268\u0267\3\2\2\2\u0269\u0088\3\2\2\2\u026a"+
		"\u026b\7-\2\2\u026b\u008a\3\2\2\2\u026c\u026d\7/\2\2\u026d\u008c\3\2\2"+
		"\2\u026e\u026f\7,\2\2\u026f\u008e\3\2\2\2\u0270\u0271\7\61\2\2\u0271\u0090"+
		"\3\2\2\2\u0272\u0273\7`\2\2\u0273\u0092\3\2\2\2\u0274\u0275\7=\2\2\u0275"+
		"\u0094\3\2\2\2\u0276\u0277\7.\2\2\u0277\u0096\3\2\2\2\u0278\u0279\7_\2"+
		"\2\u0279\u0098\3\2\2\2\u027a\u027b\7]\2\2\u027b\u009a\3\2\2\2\u027c\u027d"+
		"\7<\2\2\u027d\u009c\3\2\2\2\u027e\u027f\7>\2\2\u027f\u0280\7/\2\2\u0280"+
		"\u009e\3\2\2\2\u0281\u0285\t\33\2\2\u0282\u0284\n\3\2\2\u0283\u0282\3"+
		"\2\2\2\u0284\u0287\3\2\2\2\u0285\u0283\3\2\2\2\u0285\u0286\3\2\2\2\u0286"+
		"\u0288\3\2\2\2\u0287\u0285\3\2\2\2\u0288\u0289\t\33\2\2\u0289\u00a0\3"+
		"\2\2\2\u028a\u028e\t\34\2\2\u028b\u028d\t\35\2\2\u028c\u028b\3\2\2\2\u028d"+
		"\u0290\3\2\2\2\u028e\u028c\3\2\2\2\u028e\u028f\3\2\2\2\u028f\u00a2\3\2"+
		"\2\2\u0290\u028e\3\2\2\2\f\2\u00a6\u00b0\u023f\u0244\u024a\u0262\u0268"+
		"\u0285\u028e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}