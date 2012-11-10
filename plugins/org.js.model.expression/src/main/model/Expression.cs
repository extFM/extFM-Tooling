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
	DEFINE LESSTHAN $'<'$;                //symbol schizophrenia 
	DEFINE LESSTHANOREQUAL $('<=')$;      //symbol schizophrenia           
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
	//ExpressionModel ::= "expressions" featureModel['<','>'] expressions*;
	 ExpressionModel  ::= "Expression" #1 "Model" #1 name['"','"'] #1 !0
	 					  "Feature" #1 "Model" #1 (featureModels['<','>'])+ !0
	  				       expressions*;
		
					
	//Syntax - AttributeCalculation
	//@Operator(type="primitive", weight="6", superclass="Expression")  //weight="6"
	//AttributeCalculation ::= attribute1calculation
	//									 #1 operatorCalculation[//addition : "+", 
	   //                                                    subtraction : "-", 
	        //                                               multiplication : "*", 
	             //                                          division : "/"] 
	                //                                             #1  attribute2calculation;
		
	//AttributeValueLiteral ::= (value[INTEGER] | value[TEXT]);
	
	
	//Syntax - AttributeComparison
	//@Operator(type="primitive", weight="8", superclass="Expression")
	//AttributeComparison ::= attribute1comparison 
	//								#1 operatorComparison [equal : "==", 
	//								  								unequal : "!=", 
	//								 								greaterThan : ">", 
	//								  								greaterThanOrEqual : ">=", 
	//								  								lessThan : "<", 
	//								  								lessThanOrEqual : "<="]
	//								  					#1 attribute2comparison;
	
    //-------------------  Expressions from feature model  ---------------------------
	
	@Operator(type="primitive", weight="6", superclass="Expression") //test
	//@Operator(type="primitive", weight="5", superclass="Expression") //original
	NestedExpression ::= "(" operand ")";
	
	@Operator(type="primitive", weight="6", superclass="Expression") //test
	//@Operator(type="primitive", weight="5", superclass="Expression") //original
	FeatureReference ::= feature[];
	
	@Operator(type="unary_prefix", weight="5", superclass="Expression") //test
	//@Operator(type="unary_prefix", weight="4", superclass="Expression") //original 
	NotExpression ::= "!" operand;
							
	
	@Operator(type="binary_left_associative", weight="3", superclass="Expression")
	AndExpression ::= operand1 #1 "&&" #1 operand2;
	
	@Operator(type="binary_left_associative", weight="2", superclass="Expression")
	OrExpression ::= operand1 #1 "||" #1 operand2;
	
	@Operator(type="binary_left_associative", weight="1", superclass="Expression")
	ImpliesExpression ::= operand1 #1 "->" #1 operand2;
	
	@Operator(type="binary_left_associative", weight="1", superclass="Expression")
	ExcludesExpression ::= operand1 #1 "excludes" #1 operand2;
	
	//--------------------------------------------------------------------------------
	
	//-------------------- feature model references------------------------------
	//Syntax - feature.attribute			
	@Operator(type="primitive", weight="6", superclass="Expression") //test				  
	//@Operator(type="primitive", weight="5", superclass="Expression")
	FeatureAttributeReference ::= feature[] _[DOT] attribute[];
	
	//Syntax - 	feature.attribute := value
	@Operator(type="primitive", weight="6", superclass="Expression") //test					  
	//@Operator(type="primitive", weight="5", superclass="Expression")
	FeatureAttributeValue ::= feature[] _[DOT] attribute[]#1":="value[];
	
	//Syntax - 	attribute := value	
	@Operator(type="primitive", weight="6", superclass="Expression") //test				  
	//@Operator(type="primitive", weight="5", superclass="Expression")
	AttributeRef ::= attribute[] ":=" value[];
	
	// -------------------- mathematical expressions ------------------------------
	// + 
	@Operator(type="binary_left_associative", weight="3", superclass="Expression")
	Addition ::= operand1 #1 _[ADDITION] #1 operand2;
	
	// - 
	@Operator(type="binary_left_associative", weight="3", superclass="Expression")
	Subtraction ::= operand1 #1 _[SUBTRACTION] #1 operand2;
	
	// *
	@Operator(type="binary_left_associative", weight="3", superclass="Expression")
	Multiplication ::= operand1 #1 _[MULTIPLICATION] #1 operand2;
	
	// /
	@Operator(type="binary_left_associative", weight="3", superclass="Expression")
	Division ::= operand1 #1 _[DIVISION] #1 operand2;
	
	//------------------------expressions ----------------------------------------
	@Operator(type="primitive", weight="6", superclass="Expression")
	Number ::= number[];
	//problem with weight="5": conflict with FeatureReference (weight="5")
	
	//-------------------  comparison expressions --------------------------------
	// ==
	@Operator(type="binary_left_associative", weight="3", superclass="Expression")
	Equal ::= operand1 #1 _[EQUAL] #1 operand2;
	
	// !=
	@Operator(type="binary_left_associative", weight="4", superclass="Expression")
	Unequal ::= operand1 #1 _[UNEQUAL] #1 operand2;
	// problem with weight="3": conflict with FeatureReferenceAttributte (weight='5,6 ..')
					// PROBLEM = weight conflicts!!!!!
	
	// >
	@Operator(type="binary_left_associative", weight="3", superclass="Expression")
	GreaterThan ::= operand1 #1 _[GREATERTHAN] #1 operand2;
	
	// >=
	@Operator(type="binary_left_associative", weight="3", superclass="Expression")
	GreaterThanOrEqual ::= operand1 #1 _[GREATERTHANOREQUAL] #1 operand2;
	
	// <
	@Operator(type="binary_left_associative", weight="3", superclass="Expression")
	LessThan ::= operand1 #1 _[LESSTHAN] #1 operand2;
				    //PROBLEM = symbol schizophrenia
				    
	//<=
	@Operator(type="binary_left_associative", weight="3", superclass="Expression")
	LessThanOrEqual ::= operand1 #1 _[LESSTHANOREQUAL] #1 operand2;	
					//PROBLEM = symbol schizophrenia	    
	//-------------------------------------------------------------------------------
}