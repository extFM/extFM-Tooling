@SuppressWarnings(tokenOverlapping)
SYNTAXDEF eft //Extended Feature Text
FOR <http://www.tudresden.de/extfeature>
START FeatureModel

IMPORTS {
	org.eclipse.emf.ecore:<http://www.eclipse.org/emf/2002/Ecore>
}

OPTIONS {
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
	disableLaunchSupport = "true";
	disableNewProjectWizard = "true";
	
	srcFolder = "src/main/java";
	srcGenFolder = "src/gen/java";
	
	uiSrcFolder = "src/main/java";
	uiSrcGenFolder = "src/gen/java";


	//disableTokenSorting = "true";
	//overrideBracketSet = "false";
	//overrideChoice = "false";
	//overrideIExpectedElement = "false";
	//usePredefinedTokens = "false";
	//disableTokenSorting = "true";
}

TOKENS {
	DEFINE INTEGER $('0')|(('1'..'9')('0'..'9')*)$;
	
	//Careful: Using a dot (.) as qualifier character causes problems!
	DEFINE QUALIFIED_ATTRIBUTE_NAME_LITERAL $($ + TEXT + $'#'$ + TEXT + $)$;
}

TOKENSTYLES {
	"!" COLOR #800055, BOLD;
	"&&" COLOR #800055, BOLD;
	"||" COLOR #800055, BOLD;
	"->" COLOR #800055, BOLD;
	"excludes" COLOR #800055, BOLD;
	
	"==" COLOR #000000, BOLD;
	"!=" COLOR #000000, BOLD;
	"<" COLOR #000000, BOLD;
	"<=" COLOR #000000, BOLD;
	">" COLOR #000000, BOLD;
	">=" COLOR #000000, BOLD;
}

RULES {
	FeatureModel ::= "feature" #1 "model" #1 name['"','"'] !0!0
						domains* !0 root !0 constraints* !0; 
						
	Feature ::= selected[selected : "selected", deselected : "deselected", undetermined : ""] 
				"feature" #1 name['"','"'] #1 "<" id[TEXT] ">"
				//Order is mandatory for correct printing!
				((!0 #4 (attributes))*)? 
				((!0 #4 (groups))*)?; 
	
	Group ::= "group" #1 "<" id[TEXT] ">" #1 "(" minCardinality[INTEGER] ".." maxCardinality[INTEGER] ")" 
						#1 "{" !0 childFeatures+ !0 "}" !1;
	Attribute ::= "#" name[TEXT] #1 "[" #1 domain[] #1 "]" (#1 ":=" #1 (value[INTEGER] | value[TEXT]))?;

	ContinuousDomain ::= "domain" #1 "<" id[TEXT] ">" "[" intervals ("," #1 intervals)* "]";
	Interval ::= lowerBound[INTEGER] ".." upperBound[INTEGER];

	DiscreteDomain ::= "domain"  #1 "<" id[TEXT] ">" "[" values[TEXT] ("," #1 values[TEXT])* "]";

	Constraint ::= "constraint" #1 "<" id[TEXT] ">" #1 expression ";" !0;
	//Expression
	@Operator(type="primitive", weight="5", superclass="Expression")
	NestedExpression ::= "(" operand ")";
	
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
	
	@Operator(type="primitive", weight="5", superclass="Expression")
	AttributeComparisonExpression ::= attribute1 operator[equal : "==", unequal : "!=", greaterThan : ">", greaterThanOrEqual : ">=", lessThan : "<", lessThanOrEqual : "<="] attribute2;
		
	AttributeValueLiteral ::= (value[INTEGER] | value[TEXT]);
	AttributeReference ::= attribute[QUALIFIED_ATTRIBUTE_NAME_LITERAL];
}