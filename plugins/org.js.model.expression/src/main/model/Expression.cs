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
	DEFINE QUALIFIED_ATTRIBUTE_NAME_LITERAL $($ + TEXT + $'#'$ + TEXT + $)$;
}


TOKENSTYLES {
	"+" COLOR #000000, BOLD;
	"-" COLOR #000000, BOLD;
	"*" COLOR #000000, BOLD;
	"/" COLOR #000000, BOLD;
	
	"==" COLOR #000000, BOLD;
	"!=" COLOR #000000, BOLD;
	"<" COLOR #000000, BOLD;
	"<=" COLOR #000000, BOLD;
	">" COLOR #000000, BOLD;
	">=" COLOR #000000, BOLD;
}

RULES {
	//ExpressionModel ::= "expressions" featureModel['<','>'] expressions*;
	 ExpressionModel  ::= "Expression" #1 "Model" #1 name['"','"'] #1 !0
	 					  "Feature" #1 "Model" #1 (featureModels['<','>'])+ !0
	  				       expressions*;
		
					
	//Syntax - AttributeCalculation
	@Operator(type="primitive", weight="5", superclass="Expression")
	AttributeCalculation ::= attribute1calculation
										 #1 operatorCalculation[//addition : "+", 
	                                                       subtraction : "-", 
	                                                       multiplication : "*", 
	                                                       division : "/"] 
	                                                             #1  attribute2calculation;
		
	AttributeValueLiteral ::= (value[INTEGER] | value[TEXT]);
	AttributeReference ::= attribute[QUALIFIED_ATTRIBUTE_NAME_LITERAL];
	
	//Syntax - AttributeComparison
	@Operator(type="primitive", weight="5", superclass="Expression")
	AttributeComparison ::= attribute1comparison 
									#1 operatorComparison [equal : "==", 
									  								unequal : "!=", 
									 								greaterThan : ">", 
									  								greaterThanOrEqual : ">=", 
									  								lessThan : "<", 
									  								lessThanOrEqual : "<="]
									  					#1 attribute2comparison;	
	
	//Syntax - feature.attribute							  
	@Operator(type="primitive", weight="5", superclass="Expression")
	FeatureAttributeReference ::= feature[]"."attribute[];
	
	//Syntax - 	feature.attribute := value					  
	@Operator(type="primitive", weight="5", superclass="Expression")
	FeatureAttributeValue ::= feature[]"."attribute[]#1":="value[];
	
	//Syntax - 	attribute := value					  
	@Operator(type="primitive", weight="5", superclass="Expression")
	AttributeRef ::= attribute[] ":=" value[];
	

	//Syntax - Expression <= Expression 
	//@Operator(type="binary_left_associative", weight="3", superclass="Expression")
	//LessThanOrEqual ::= operand1 #1 "LessThanOrEqual" #1 operand2;
	//problem: reserved symbols <, >, <= ,>
	
	
	@Operator(type="primitive", weight="5", superclass="Expression")
	//@Operator(type="binary_left_associative", weight="1", superclass="Expression")
	Add ::= number1[] operator [addition : "+"] number2[];
	
	
	//-------------------  Expressions from Feature Model  ---------------------------
	
	//@Operator(type="primitive", weight="5", superclass="Expression") //test
	@Operator(type="primitive", weight="5", superclass="Expression")
	NestedExpression ::= "(" operand ")";
	
	//@Operator(type="primitive", weight="5", superclass="Expression") //test
	@Operator(type="primitive", weight="5", superclass="Expression")
	FeatureReference ::= feature[];
	
	@Operator(type="unary_prefix", weight="4", superclass="Expression")
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
}