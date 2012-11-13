@SuppressWarnings(tokenOverlapping)
SYNTAXDEF expressionText
FOR <http://www.tudresden.de/extexpression>
START ExpressionModel

OPTIONS {
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
	disableLaunchSupport = "true";
	disableNewProjectWizard = "true";
    overridePluginXML = "false";
	
	srcFolder = "src/main/java";
	srcGenFolder = "src/gen/java";
	
	uiSrcFolder = "src/main/java";
	uiSrcGenFolder = "src/gen/java";
	
}

TOKENS {
	DEFINE INTEGER $('0')|(('1'..'9')('0'..'9')*)$;
	DEFINE DOT $('.')$;
	
	DEFINE ADDITION $('+')$;
	DEFINE SUBTRACTION $('-')$;
	DEFINE MULTIPLICATION $('*')$;
	DEFINE DIVISION $('/')$;
	
	DEFINE EQUAL $('==')$;
	DEFINE UNEQUAL $('!=')$; 
	DEFINE GREATERTHAN $('>')$;         
	DEFINE GREATERTHANOREQUAL $('>=')$; 
	DEFINE LESSTHAN $'<'$;                
	DEFINE LESSTHANOREQUAL $('<=')$;         
	
	DEFINE REQUIRES $'requires'$;
	DEFINE EXCLUDES $'excludes'$ ;
}


TOKENSTYLES {
	//"+" COLOR #000000, BOLD;
	//"-" COLOR #000000, BOLD;
	//"*" COLOR #000000, BOLD;
	//"/" COLOR #000000, BOLD;
	
	//"==" COLOR #000000, BOLD;
	//"!=" COLOR #000000, BOLD;
	//"<" COLOR #000000, BOLD;
	//"<=" COLOR #000000, BOLD;
	//">" COLOR #000000, BOLD;
	//">=" COLOR #000000, BOLD;
}

RULES {

	 ExpressionModel  ::= "Expression" #1 "Model" #1 name['"','"'] #1 !0
	 					  "Feature" #1 "Model" #1 (featureModels['[',']'])+ !0
	  				       expressions*;
	
    //-------------------  Expressions from feature model  ---------------------------
	
					@Operator(type="primitive", weight="9", superclass="Expression") 
					NestedExpression ::= "(" operand ")";
	
					@Operator(type="primitive", weight="9", superclass="Expression")
					FeatureReference ::= feature[];
	
	@Operator(type="unary_prefix", weight="8", superclass="Expression") 
	NotExpression ::= "!" operand;
							
	@Operator(type="binary_left_associative", weight="3", superclass="Expression")
	AndExpression ::= operand1 #1 "&&" #1 operand2;
	
	@Operator(type="binary_left_associative", weight="2", superclass="Expression")
	OrExpression ::= operand1 #1 "||" #1 operand2;
	
	//-------------------- cross-tree-relationships ------------------------------
	
	@Operator(type="binary_left_associative", weight="1", superclass="Expression")
	Requires::= operand1 #1 _[REQUIRES] #1 operand2;
	
	@Operator(type="binary_left_associative", weight="1", superclass="Expression")
	Excludes ::= operand1 #1 _[EXCLUDES] #1 operand2;
	
	//-------------------- feature model references------------------------------
					
					//feature.attribute		
					@Operator(type="primitive", weight="9", superclass="Expression")				  
					FeatureAttributeReference ::= feature[] _[DOT] attribute[];  		
					
					//feature.attribute := value
					@Operator(type="primitive", weight="9", superclass="Expression") 				  
					FeatureAttributeValue ::= feature[] _[DOT] attribute[]#1":="value[]; 
	
					//attribute := value				  
					@Operator(type="primitive", weight="9", superclass="Expression")
					AttributeRef ::= attribute[] ":=" value[];
	
	// -------------------- mathematical expressions ------------------------------
	
	@Operator(type="binary_left_associative", weight="6", superclass="Expression")
	Addition ::= operand1 #1 _[ADDITION] #1 operand2;
	
	@Operator(type="binary_left_associative", weight="6", superclass="Expression")
	Subtraction ::= operand1 #1 _[SUBTRACTION] #1 operand2;
	
	@Operator(type="binary_left_associative", weight="7", superclass="Expression")
	Multiplication ::= operand1 #1 _[MULTIPLICATION] #1 operand2;
	
	@Operator(type="binary_left_associative", weight="7", superclass="Expression")
	Division ::= operand1 #1 _[DIVISION] #1 operand2;
	
	//-------------------  comparison expressions --------------------------------
				
	@Operator(type="binary_left_associative", weight="4", superclass="Expression")
	Equal ::= operand1 #1 _[EQUAL] #1 operand2;
	
	@Operator(type="binary_left_associative", weight="4", superclass="Expression")
	Unequal ::= operand1 #1 _[UNEQUAL] #1 operand2;

	@Operator(type="binary_left_associative", weight="5", superclass="Expression")
	GreaterThan ::= operand1 #1 _[GREATERTHAN] #1 operand2;                   //>
	
	@Operator(type="binary_left_associative", weight="5", superclass="Expression")
	GreaterThanOrEqual ::= operand1 #1 _[GREATERTHANOREQUAL] #1 operand2;     //>=
	
	@Operator(type="binary_left_associative", weight="5", superclass="Expression")
	LessThan ::= operand1 #1 _[LESSTHAN] #1 operand2;                         //<
				    
	@Operator(type="binary_left_associative", weight="5", superclass="Expression")
	LessThanOrEqual ::= operand1 #1 _[LESSTHANOREQUAL] #1 operand2;	          //<=
					
	//------------------------expressions ----------------------------------------
	
					@Operator(type="primitive", weight="9", superclass="Expression")
					Number ::= value[INTEGER] ;
	   
	//-----------------------------------------------------------------------------
}