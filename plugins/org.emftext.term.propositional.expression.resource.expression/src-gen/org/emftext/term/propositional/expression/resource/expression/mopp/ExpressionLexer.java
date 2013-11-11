// $ANTLR 3.4

	package org.emftext.term.propositional.expression.resource.expression.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class ExpressionLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__7=7;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int LINEBREAK=4;
    public static final int TEXT=5;
    public static final int WHITESPACE=6;

    	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
    	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
    	
    	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
    		lexerExceptions.add(e);
    		lexerExceptionsPosition.add(((org.antlr.runtime3_4_0.ANTLRStringStream) input).index());
    	}


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public ExpressionLexer() {} 
    public ExpressionLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public ExpressionLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Expression.g"; }

    // $ANTLR start "T__7"
    public final void mT__7() throws RecognitionException {
        try {
            int _type = T__7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Expression.g:15:6: ( '(' )
            // Expression.g:15:8: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__7"

    // $ANTLR start "T__8"
    public final void mT__8() throws RecognitionException {
        try {
            int _type = T__8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Expression.g:16:6: ( ')' )
            // Expression.g:16:8: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__8"

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Expression.g:17:6: ( 'and' )
            // Expression.g:17:8: 'and'
            {
            match("and"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Expression.g:18:7: ( 'not' )
            // Expression.g:18:9: 'not'
            {
            match("not"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Expression.g:19:7: ( 'or' )
            // Expression.g:19:9: 'or'
            {
            match("or"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Expression.g:852:5: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ ) )
            // Expression.g:853:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            {
            // Expression.g:853:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // Expression.g:853:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // Expression.g:853:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='-'||(LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Expression.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TEXT"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Expression.g:855:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // Expression.g:856:2: ( ( ' ' | '\\t' | '\\f' ) )
            {
            if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "LINEBREAK"
    public final void mLINEBREAK() throws RecognitionException {
        try {
            int _type = LINEBREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Expression.g:859:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Expression.g:860:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Expression.g:860:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Expression.g:860:2: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Expression.g:860:2: ( '\\r\\n' | '\\r' | '\\n' )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1=='\n') ) {
                    alt2=1;
                }
                else {
                    alt2=2;
                }
            }
            else if ( (LA2_0=='\n') ) {
                alt2=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // Expression.g:860:3: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // Expression.g:860:12: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Expression.g:860:19: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }


            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LINEBREAK"

    public void mTokens() throws RecognitionException {
        // Expression.g:1:8: ( T__7 | T__8 | T__9 | T__10 | T__11 | TEXT | WHITESPACE | LINEBREAK )
        int alt3=8;
        switch ( input.LA(1) ) {
        case '(':
            {
            alt3=1;
            }
            break;
        case ')':
            {
            alt3=2;
            }
            break;
        case 'a':
            {
            int LA3_3 = input.LA(2);

            if ( (LA3_3=='n') ) {
                int LA3_9 = input.LA(3);

                if ( (LA3_9=='d') ) {
                    int LA3_12 = input.LA(4);

                    if ( (LA3_12=='-'||(LA3_12 >= '0' && LA3_12 <= '9')||(LA3_12 >= 'A' && LA3_12 <= 'Z')||LA3_12=='_'||(LA3_12 >= 'a' && LA3_12 <= 'z')) ) {
                        alt3=6;
                    }
                    else {
                        alt3=3;
                    }
                }
                else {
                    alt3=6;
                }
            }
            else {
                alt3=6;
            }
            }
            break;
        case 'n':
            {
            int LA3_4 = input.LA(2);

            if ( (LA3_4=='o') ) {
                int LA3_10 = input.LA(3);

                if ( (LA3_10=='t') ) {
                    int LA3_13 = input.LA(4);

                    if ( (LA3_13=='-'||(LA3_13 >= '0' && LA3_13 <= '9')||(LA3_13 >= 'A' && LA3_13 <= 'Z')||LA3_13=='_'||(LA3_13 >= 'a' && LA3_13 <= 'z')) ) {
                        alt3=6;
                    }
                    else {
                        alt3=4;
                    }
                }
                else {
                    alt3=6;
                }
            }
            else {
                alt3=6;
            }
            }
            break;
        case 'o':
            {
            int LA3_5 = input.LA(2);

            if ( (LA3_5=='r') ) {
                int LA3_11 = input.LA(3);

                if ( (LA3_11=='-'||(LA3_11 >= '0' && LA3_11 <= '9')||(LA3_11 >= 'A' && LA3_11 <= 'Z')||LA3_11=='_'||(LA3_11 >= 'a' && LA3_11 <= 'z')) ) {
                    alt3=6;
                }
                else {
                    alt3=5;
                }
            }
            else {
                alt3=6;
            }
            }
            break;
        case '-':
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case '_':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt3=6;
            }
            break;
        case '\t':
        case '\f':
        case ' ':
            {
            alt3=7;
            }
            break;
        case '\n':
        case '\r':
            {
            alt3=8;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 3, 0, input);

            throw nvae;

        }

        switch (alt3) {
            case 1 :
                // Expression.g:1:10: T__7
                {
                mT__7(); 


                }
                break;
            case 2 :
                // Expression.g:1:15: T__8
                {
                mT__8(); 


                }
                break;
            case 3 :
                // Expression.g:1:20: T__9
                {
                mT__9(); 


                }
                break;
            case 4 :
                // Expression.g:1:25: T__10
                {
                mT__10(); 


                }
                break;
            case 5 :
                // Expression.g:1:31: T__11
                {
                mT__11(); 


                }
                break;
            case 6 :
                // Expression.g:1:37: TEXT
                {
                mTEXT(); 


                }
                break;
            case 7 :
                // Expression.g:1:42: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 8 :
                // Expression.g:1:53: LINEBREAK
                {
                mLINEBREAK(); 


                }
                break;

        }

    }


 

}