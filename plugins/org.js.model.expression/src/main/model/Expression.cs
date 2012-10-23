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
}

RULES {
	//Syntax definition for class 'StartMetaClass'
	//ExpressionModel   ::= "expressions" featureModel['<','>'] expressions*;
	  ExpressionModel  ::= "Expression" #1 "Model" #1 name['"','"'] #1 
	  						expressions* calculations* comparisons*;
	
	//Syntax - Expression
	Expression ::= "Expression";
	
	//Syntax - AttributeCalculation
	@Operator(type="primitive", weight="5", superclass="AtomicExpression")
	AttributeCalculation ::= "attribute" #1 attribute1calculation
										"operator" #1 operatorCalculation[addition : "+", 
	                                                       subtraction : "-", 
	                                                       multiplication : "*", 
	                                                       division : "/"] 
	                                    "attribute" #1  attribute2calculation;
		
	AttributeValueLiteral ::= (value[INTEGER] | value[TEXT]);
	AttributeReference ::= attribute[QUALIFIED_ATTRIBUTE_NAME_LITERAL];
	
	//Syntax - AttributeComparison
	@Operator(type="primitive", weight="6", superclass="AtomicExpression")
	AttributeComparison ::= "attribute" #1 attribute1comparison 
									  "operator" #1 operatorComparison [equal : "==", 
									  								unequal : "!=", 
									 								greaterThan : ">", 
									  								greaterThanOrEqual : ">=", 
									  								lessThan : "<", 
									  								lessThanOrEqual : "<="]
									  "attribute" #1 attribute2comparison;							   
}