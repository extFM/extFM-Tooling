// $ANTLR 3.4

	package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class MtextLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int LINEBREAK=4;
    public static final int QUOTED_34_34=5;
    public static final int QUOTED_60_62=6;
    public static final int TEXT=7;
    public static final int WHITESPACE=8;

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

    public MtextLexer() {} 
    public MtextLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public MtextLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Mtext.g"; }

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Mtext.g:15:6: ( 'contains' )
            // Mtext.g:15:8: 'contains'
            {
            match("contains"); 



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
            // Mtext.g:16:7: ( 'featuremodel' )
            // Mtext.g:16:9: 'featuremodel'
            {
            match("featuremodel"); 



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
            // Mtext.g:17:7: ( 'view group' )
            // Mtext.g:17:9: 'view group'
            {
            match("view group"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Mtext.g:18:7: ( 'viewmapping' )
            // Mtext.g:18:9: 'viewmapping'
            {
            match("viewmapping"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Mtext.g:19:7: ( 'viewmodel' )
            // Mtext.g:19:9: 'viewmodel'
            {
            match("viewmodel"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Mtext.g:819:5: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ ) )
            // Mtext.g:820:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            {
            // Mtext.g:820:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // Mtext.g:820:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // Mtext.g:820:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
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
            	    // Mtext.g:
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


             _channel = 99; 

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
            // Mtext.g:823:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // Mtext.g:824:2: ( ( ' ' | '\\t' | '\\f' ) )
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
            // Mtext.g:827:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Mtext.g:828:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Mtext.g:828:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Mtext.g:828:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Mtext.g:828:3: ( '\\r\\n' | '\\r' | '\\n' )
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
                    // Mtext.g:828:4: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // Mtext.g:828:13: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Mtext.g:828:20: '\\n'
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

    // $ANTLR start "QUOTED_60_62"
    public final void mQUOTED_60_62() throws RecognitionException {
        try {
            int _type = QUOTED_60_62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Mtext.g:831:13: ( ( ( '<' ) (~ ( '>' ) )* ( '>' ) ) )
            // Mtext.g:832:2: ( ( '<' ) (~ ( '>' ) )* ( '>' ) )
            {
            // Mtext.g:832:2: ( ( '<' ) (~ ( '>' ) )* ( '>' ) )
            // Mtext.g:832:3: ( '<' ) (~ ( '>' ) )* ( '>' )
            {
            // Mtext.g:832:3: ( '<' )
            // Mtext.g:832:4: '<'
            {
            match('<'); 

            }


            // Mtext.g:832:8: (~ ( '>' ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '\u0000' && LA3_0 <= '=')||(LA3_0 >= '?' && LA3_0 <= '\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Mtext.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '=')||(input.LA(1) >= '?' && input.LA(1) <= '\uFFFF') ) {
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
            	    break loop3;
                }
            } while (true);


            // Mtext.g:832:17: ( '>' )
            // Mtext.g:832:18: '>'
            {
            match('>'); 

            }


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUOTED_60_62"

    // $ANTLR start "QUOTED_34_34"
    public final void mQUOTED_34_34() throws RecognitionException {
        try {
            int _type = QUOTED_34_34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Mtext.g:834:13: ( ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) ) )
            // Mtext.g:835:2: ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) )
            {
            // Mtext.g:835:2: ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) )
            // Mtext.g:835:3: ( '\"' ) (~ ( '\"' ) )* ( '\"' )
            {
            // Mtext.g:835:3: ( '\"' )
            // Mtext.g:835:4: '\"'
            {
            match('\"'); 

            }


            // Mtext.g:835:8: (~ ( '\"' ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '\u0000' && LA4_0 <= '!')||(LA4_0 >= '#' && LA4_0 <= '\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Mtext.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
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
            	    break loop4;
                }
            } while (true);


            // Mtext.g:835:17: ( '\"' )
            // Mtext.g:835:18: '\"'
            {
            match('\"'); 

            }


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUOTED_34_34"

    public void mTokens() throws RecognitionException {
        // Mtext.g:1:8: ( T__9 | T__10 | T__11 | T__12 | T__13 | TEXT | WHITESPACE | LINEBREAK | QUOTED_60_62 | QUOTED_34_34 )
        int alt5=10;
        switch ( input.LA(1) ) {
        case 'c':
            {
            int LA5_1 = input.LA(2);

            if ( (LA5_1=='o') ) {
                int LA5_9 = input.LA(3);

                if ( (LA5_9=='n') ) {
                    int LA5_12 = input.LA(4);

                    if ( (LA5_12=='t') ) {
                        int LA5_15 = input.LA(5);

                        if ( (LA5_15=='a') ) {
                            int LA5_18 = input.LA(6);

                            if ( (LA5_18=='i') ) {
                                int LA5_22 = input.LA(7);

                                if ( (LA5_22=='n') ) {
                                    int LA5_26 = input.LA(8);

                                    if ( (LA5_26=='s') ) {
                                        int LA5_30 = input.LA(9);

                                        if ( (LA5_30=='-'||(LA5_30 >= '0' && LA5_30 <= '9')||(LA5_30 >= 'A' && LA5_30 <= 'Z')||LA5_30=='_'||(LA5_30 >= 'a' && LA5_30 <= 'z')) ) {
                                            alt5=6;
                                        }
                                        else {
                                            alt5=1;
                                        }
                                    }
                                    else {
                                        alt5=6;
                                    }
                                }
                                else {
                                    alt5=6;
                                }
                            }
                            else {
                                alt5=6;
                            }
                        }
                        else {
                            alt5=6;
                        }
                    }
                    else {
                        alt5=6;
                    }
                }
                else {
                    alt5=6;
                }
            }
            else {
                alt5=6;
            }
            }
            break;
        case 'f':
            {
            int LA5_2 = input.LA(2);

            if ( (LA5_2=='e') ) {
                int LA5_10 = input.LA(3);

                if ( (LA5_10=='a') ) {
                    int LA5_13 = input.LA(4);

                    if ( (LA5_13=='t') ) {
                        int LA5_16 = input.LA(5);

                        if ( (LA5_16=='u') ) {
                            int LA5_19 = input.LA(6);

                            if ( (LA5_19=='r') ) {
                                int LA5_23 = input.LA(7);

                                if ( (LA5_23=='e') ) {
                                    int LA5_27 = input.LA(8);

                                    if ( (LA5_27=='m') ) {
                                        int LA5_31 = input.LA(9);

                                        if ( (LA5_31=='o') ) {
                                            int LA5_35 = input.LA(10);

                                            if ( (LA5_35=='d') ) {
                                                int LA5_38 = input.LA(11);

                                                if ( (LA5_38=='e') ) {
                                                    int LA5_41 = input.LA(12);

                                                    if ( (LA5_41=='l') ) {
                                                        int LA5_43 = input.LA(13);

                                                        if ( (LA5_43=='-'||(LA5_43 >= '0' && LA5_43 <= '9')||(LA5_43 >= 'A' && LA5_43 <= 'Z')||LA5_43=='_'||(LA5_43 >= 'a' && LA5_43 <= 'z')) ) {
                                                            alt5=6;
                                                        }
                                                        else {
                                                            alt5=2;
                                                        }
                                                    }
                                                    else {
                                                        alt5=6;
                                                    }
                                                }
                                                else {
                                                    alt5=6;
                                                }
                                            }
                                            else {
                                                alt5=6;
                                            }
                                        }
                                        else {
                                            alt5=6;
                                        }
                                    }
                                    else {
                                        alt5=6;
                                    }
                                }
                                else {
                                    alt5=6;
                                }
                            }
                            else {
                                alt5=6;
                            }
                        }
                        else {
                            alt5=6;
                        }
                    }
                    else {
                        alt5=6;
                    }
                }
                else {
                    alt5=6;
                }
            }
            else {
                alt5=6;
            }
            }
            break;
        case 'v':
            {
            int LA5_3 = input.LA(2);

            if ( (LA5_3=='i') ) {
                int LA5_11 = input.LA(3);

                if ( (LA5_11=='e') ) {
                    int LA5_14 = input.LA(4);

                    if ( (LA5_14=='w') ) {
                        switch ( input.LA(5) ) {
                        case ' ':
                            {
                            alt5=3;
                            }
                            break;
                        case 'm':
                            {
                            switch ( input.LA(6) ) {
                            case 'a':
                                {
                                int LA5_24 = input.LA(7);

                                if ( (LA5_24=='p') ) {
                                    int LA5_28 = input.LA(8);

                                    if ( (LA5_28=='p') ) {
                                        int LA5_32 = input.LA(9);

                                        if ( (LA5_32=='i') ) {
                                            int LA5_36 = input.LA(10);

                                            if ( (LA5_36=='n') ) {
                                                int LA5_39 = input.LA(11);

                                                if ( (LA5_39=='g') ) {
                                                    int LA5_42 = input.LA(12);

                                                    if ( (LA5_42=='-'||(LA5_42 >= '0' && LA5_42 <= '9')||(LA5_42 >= 'A' && LA5_42 <= 'Z')||LA5_42=='_'||(LA5_42 >= 'a' && LA5_42 <= 'z')) ) {
                                                        alt5=6;
                                                    }
                                                    else {
                                                        alt5=4;
                                                    }
                                                }
                                                else {
                                                    alt5=6;
                                                }
                                            }
                                            else {
                                                alt5=6;
                                            }
                                        }
                                        else {
                                            alt5=6;
                                        }
                                    }
                                    else {
                                        alt5=6;
                                    }
                                }
                                else {
                                    alt5=6;
                                }
                                }
                                break;
                            case 'o':
                                {
                                int LA5_25 = input.LA(7);

                                if ( (LA5_25=='d') ) {
                                    int LA5_29 = input.LA(8);

                                    if ( (LA5_29=='e') ) {
                                        int LA5_33 = input.LA(9);

                                        if ( (LA5_33=='l') ) {
                                            int LA5_37 = input.LA(10);

                                            if ( (LA5_37=='-'||(LA5_37 >= '0' && LA5_37 <= '9')||(LA5_37 >= 'A' && LA5_37 <= 'Z')||LA5_37=='_'||(LA5_37 >= 'a' && LA5_37 <= 'z')) ) {
                                                alt5=6;
                                            }
                                            else {
                                                alt5=5;
                                            }
                                        }
                                        else {
                                            alt5=6;
                                        }
                                    }
                                    else {
                                        alt5=6;
                                    }
                                }
                                else {
                                    alt5=6;
                                }
                                }
                                break;
                            default:
                                alt5=6;
                            }

                            }
                            break;
                        default:
                            alt5=6;
                        }

                    }
                    else {
                        alt5=6;
                    }
                }
                else {
                    alt5=6;
                }
            }
            else {
                alt5=6;
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
        case 'a':
        case 'b':
        case 'd':
        case 'e':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt5=6;
            }
            break;
        case '\t':
        case '\f':
        case ' ':
            {
            alt5=7;
            }
            break;
        case '\n':
        case '\r':
            {
            alt5=8;
            }
            break;
        case '<':
            {
            alt5=9;
            }
            break;
        case '\"':
            {
            alt5=10;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 5, 0, input);

            throw nvae;

        }

        switch (alt5) {
            case 1 :
                // Mtext.g:1:10: T__9
                {
                mT__9(); 


                }
                break;
            case 2 :
                // Mtext.g:1:15: T__10
                {
                mT__10(); 


                }
                break;
            case 3 :
                // Mtext.g:1:21: T__11
                {
                mT__11(); 


                }
                break;
            case 4 :
                // Mtext.g:1:27: T__12
                {
                mT__12(); 


                }
                break;
            case 5 :
                // Mtext.g:1:33: T__13
                {
                mT__13(); 


                }
                break;
            case 6 :
                // Mtext.g:1:39: TEXT
                {
                mTEXT(); 


                }
                break;
            case 7 :
                // Mtext.g:1:44: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 8 :
                // Mtext.g:1:55: LINEBREAK
                {
                mLINEBREAK(); 


                }
                break;
            case 9 :
                // Mtext.g:1:65: QUOTED_60_62
                {
                mQUOTED_60_62(); 


                }
                break;
            case 10 :
                // Mtext.g:1:78: QUOTED_34_34
                {
                mQUOTED_34_34(); 


                }
                break;

        }

    }


 

}