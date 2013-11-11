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
    public static final int T__14=14;
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
            // Mtext.g:15:6: ( ',' )
            // Mtext.g:15:8: ','
            {
            match(','); 

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
            // Mtext.g:16:7: ( 'contains' )
            // Mtext.g:16:9: 'contains'
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
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Mtext.g:17:7: ( 'featuremodel' )
            // Mtext.g:17:9: 'featuremodel'
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
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Mtext.g:18:7: ( 'view group' )
            // Mtext.g:18:9: 'view group'
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
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Mtext.g:19:7: ( 'viewmapping' )
            // Mtext.g:19:9: 'viewmapping'
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
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Mtext.g:20:7: ( 'viewmodel' )
            // Mtext.g:20:9: 'viewmodel'
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
    // $ANTLR end "T__14"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Mtext.g:874:5: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ ) )
            // Mtext.g:875:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            {
            // Mtext.g:875:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // Mtext.g:875:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // Mtext.g:875:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
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
            // Mtext.g:878:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // Mtext.g:879:2: ( ( ' ' | '\\t' | '\\f' ) )
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
            // Mtext.g:882:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Mtext.g:883:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Mtext.g:883:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Mtext.g:883:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Mtext.g:883:3: ( '\\r\\n' | '\\r' | '\\n' )
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
                    // Mtext.g:883:4: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // Mtext.g:883:13: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Mtext.g:883:20: '\\n'
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
            // Mtext.g:886:13: ( ( ( '<' ) (~ ( '>' ) )* ( '>' ) ) )
            // Mtext.g:887:2: ( ( '<' ) (~ ( '>' ) )* ( '>' ) )
            {
            // Mtext.g:887:2: ( ( '<' ) (~ ( '>' ) )* ( '>' ) )
            // Mtext.g:887:3: ( '<' ) (~ ( '>' ) )* ( '>' )
            {
            // Mtext.g:887:3: ( '<' )
            // Mtext.g:887:4: '<'
            {
            match('<'); 

            }


            // Mtext.g:887:8: (~ ( '>' ) )*
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


            // Mtext.g:887:17: ( '>' )
            // Mtext.g:887:18: '>'
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
            // Mtext.g:889:13: ( ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) ) )
            // Mtext.g:890:2: ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) )
            {
            // Mtext.g:890:2: ( ( '\"' ) (~ ( '\"' ) )* ( '\"' ) )
            // Mtext.g:890:3: ( '\"' ) (~ ( '\"' ) )* ( '\"' )
            {
            // Mtext.g:890:3: ( '\"' )
            // Mtext.g:890:4: '\"'
            {
            match('\"'); 

            }


            // Mtext.g:890:8: (~ ( '\"' ) )*
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


            // Mtext.g:890:17: ( '\"' )
            // Mtext.g:890:18: '\"'
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
        // Mtext.g:1:8: ( T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | TEXT | WHITESPACE | LINEBREAK | QUOTED_60_62 | QUOTED_34_34 )
        int alt5=11;
        switch ( input.LA(1) ) {
        case ',':
            {
            alt5=1;
            }
            break;
        case 'c':
            {
            int LA5_2 = input.LA(2);

            if ( (LA5_2=='o') ) {
                int LA5_10 = input.LA(3);

                if ( (LA5_10=='n') ) {
                    int LA5_13 = input.LA(4);

                    if ( (LA5_13=='t') ) {
                        int LA5_16 = input.LA(5);

                        if ( (LA5_16=='a') ) {
                            int LA5_19 = input.LA(6);

                            if ( (LA5_19=='i') ) {
                                int LA5_23 = input.LA(7);

                                if ( (LA5_23=='n') ) {
                                    int LA5_27 = input.LA(8);

                                    if ( (LA5_27=='s') ) {
                                        int LA5_31 = input.LA(9);

                                        if ( (LA5_31=='-'||(LA5_31 >= '0' && LA5_31 <= '9')||(LA5_31 >= 'A' && LA5_31 <= 'Z')||LA5_31=='_'||(LA5_31 >= 'a' && LA5_31 <= 'z')) ) {
                                            alt5=7;
                                        }
                                        else {
                                            alt5=2;
                                        }
                                    }
                                    else {
                                        alt5=7;
                                    }
                                }
                                else {
                                    alt5=7;
                                }
                            }
                            else {
                                alt5=7;
                            }
                        }
                        else {
                            alt5=7;
                        }
                    }
                    else {
                        alt5=7;
                    }
                }
                else {
                    alt5=7;
                }
            }
            else {
                alt5=7;
            }
            }
            break;
        case 'f':
            {
            int LA5_3 = input.LA(2);

            if ( (LA5_3=='e') ) {
                int LA5_11 = input.LA(3);

                if ( (LA5_11=='a') ) {
                    int LA5_14 = input.LA(4);

                    if ( (LA5_14=='t') ) {
                        int LA5_17 = input.LA(5);

                        if ( (LA5_17=='u') ) {
                            int LA5_20 = input.LA(6);

                            if ( (LA5_20=='r') ) {
                                int LA5_24 = input.LA(7);

                                if ( (LA5_24=='e') ) {
                                    int LA5_28 = input.LA(8);

                                    if ( (LA5_28=='m') ) {
                                        int LA5_32 = input.LA(9);

                                        if ( (LA5_32=='o') ) {
                                            int LA5_36 = input.LA(10);

                                            if ( (LA5_36=='d') ) {
                                                int LA5_39 = input.LA(11);

                                                if ( (LA5_39=='e') ) {
                                                    int LA5_42 = input.LA(12);

                                                    if ( (LA5_42=='l') ) {
                                                        int LA5_44 = input.LA(13);

                                                        if ( (LA5_44=='-'||(LA5_44 >= '0' && LA5_44 <= '9')||(LA5_44 >= 'A' && LA5_44 <= 'Z')||LA5_44=='_'||(LA5_44 >= 'a' && LA5_44 <= 'z')) ) {
                                                            alt5=7;
                                                        }
                                                        else {
                                                            alt5=3;
                                                        }
                                                    }
                                                    else {
                                                        alt5=7;
                                                    }
                                                }
                                                else {
                                                    alt5=7;
                                                }
                                            }
                                            else {
                                                alt5=7;
                                            }
                                        }
                                        else {
                                            alt5=7;
                                        }
                                    }
                                    else {
                                        alt5=7;
                                    }
                                }
                                else {
                                    alt5=7;
                                }
                            }
                            else {
                                alt5=7;
                            }
                        }
                        else {
                            alt5=7;
                        }
                    }
                    else {
                        alt5=7;
                    }
                }
                else {
                    alt5=7;
                }
            }
            else {
                alt5=7;
            }
            }
            break;
        case 'v':
            {
            int LA5_4 = input.LA(2);

            if ( (LA5_4=='i') ) {
                int LA5_12 = input.LA(3);

                if ( (LA5_12=='e') ) {
                    int LA5_15 = input.LA(4);

                    if ( (LA5_15=='w') ) {
                        switch ( input.LA(5) ) {
                        case ' ':
                            {
                            alt5=4;
                            }
                            break;
                        case 'm':
                            {
                            switch ( input.LA(6) ) {
                            case 'a':
                                {
                                int LA5_25 = input.LA(7);

                                if ( (LA5_25=='p') ) {
                                    int LA5_29 = input.LA(8);

                                    if ( (LA5_29=='p') ) {
                                        int LA5_33 = input.LA(9);

                                        if ( (LA5_33=='i') ) {
                                            int LA5_37 = input.LA(10);

                                            if ( (LA5_37=='n') ) {
                                                int LA5_40 = input.LA(11);

                                                if ( (LA5_40=='g') ) {
                                                    int LA5_43 = input.LA(12);

                                                    if ( (LA5_43=='-'||(LA5_43 >= '0' && LA5_43 <= '9')||(LA5_43 >= 'A' && LA5_43 <= 'Z')||LA5_43=='_'||(LA5_43 >= 'a' && LA5_43 <= 'z')) ) {
                                                        alt5=7;
                                                    }
                                                    else {
                                                        alt5=5;
                                                    }
                                                }
                                                else {
                                                    alt5=7;
                                                }
                                            }
                                            else {
                                                alt5=7;
                                            }
                                        }
                                        else {
                                            alt5=7;
                                        }
                                    }
                                    else {
                                        alt5=7;
                                    }
                                }
                                else {
                                    alt5=7;
                                }
                                }
                                break;
                            case 'o':
                                {
                                int LA5_26 = input.LA(7);

                                if ( (LA5_26=='d') ) {
                                    int LA5_30 = input.LA(8);

                                    if ( (LA5_30=='e') ) {
                                        int LA5_34 = input.LA(9);

                                        if ( (LA5_34=='l') ) {
                                            int LA5_38 = input.LA(10);

                                            if ( (LA5_38=='-'||(LA5_38 >= '0' && LA5_38 <= '9')||(LA5_38 >= 'A' && LA5_38 <= 'Z')||LA5_38=='_'||(LA5_38 >= 'a' && LA5_38 <= 'z')) ) {
                                                alt5=7;
                                            }
                                            else {
                                                alt5=6;
                                            }
                                        }
                                        else {
                                            alt5=7;
                                        }
                                    }
                                    else {
                                        alt5=7;
                                    }
                                }
                                else {
                                    alt5=7;
                                }
                                }
                                break;
                            default:
                                alt5=7;
                            }

                            }
                            break;
                        default:
                            alt5=7;
                        }

                    }
                    else {
                        alt5=7;
                    }
                }
                else {
                    alt5=7;
                }
            }
            else {
                alt5=7;
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
            alt5=7;
            }
            break;
        case '\t':
        case '\f':
        case ' ':
            {
            alt5=8;
            }
            break;
        case '\n':
        case '\r':
            {
            alt5=9;
            }
            break;
        case '<':
            {
            alt5=10;
            }
            break;
        case '\"':
            {
            alt5=11;
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
                // Mtext.g:1:39: T__14
                {
                mT__14(); 


                }
                break;
            case 7 :
                // Mtext.g:1:45: TEXT
                {
                mTEXT(); 


                }
                break;
            case 8 :
                // Mtext.g:1:50: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 9 :
                // Mtext.g:1:61: LINEBREAK
                {
                mLINEBREAK(); 


                }
                break;
            case 10 :
                // Mtext.g:1:71: QUOTED_60_62
                {
                mQUOTED_60_62(); 


                }
                break;
            case 11 :
                // Mtext.g:1:84: QUOTED_34_34
                {
                mQUOTED_34_34(); 


                }
                break;

        }

    }


 

}