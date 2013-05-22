@SuppressWarnings(tokenOverlapping)
SYNTAXDEF expressionText
FOR <http://www.tudresden.de/extexpression>
START FeatureModel2

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
	//DEFINE INTEGER $('0')|(('1'..'9')('0'..'9')*)$;
	//DEFINE DOT $('.')$;
	
	DEFINE QUALIFIED_ATTRIBUTE_NAME_LITERAL $($ + TEXT + $'#'$ + TEXT + $)$;
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))* $ ;

	//DEFINE EQUAL $('==')$;
	//DEFINE UNEQUAL $('!=')$; 
	//DEFINE GREATERTHAN $('>')$;         
	//DEFINE GREATERTHANOREQUAL $('>=')$; 
	//DEFINE LESSTHAN $'<'$;                
	//DEFINE LESSTHANOREQUAL $('<=')$;  
	
	DEFINE EQUAL $'equal'$;
	DEFINE UNEQUAL $'unequal'$; 
	DEFINE GREATERTHAN $'greaterThan'$;         
	//DEFINE GREATERTHANOREQUAL $'greaterThanOrEqual$;
	DEFINE GREATERTHANOREQUAL $('>=')$;
	DEFINE LESSTHAN $'lessThan'$;                
	DEFINE LESSTHANOREQUAL $'lessThanOrEqual'$;  
	       
	
	DEFINE REQUIRES $'requires'$;
	DEFINE EXCLUDES $'excludes'$ ;
}

TOKENSTYLES{
		"EQUAL" COLOR #800055, BOLD;
		"UNEQUAL" COLOR #800055, BOLD;
		"GREATERTHAN" COLOR #800055, BOLD;
		"GREATERTHANOREQUAL" COLOR #800055, BOLD;
		"LESSTHAN" COLOR #800055, BOLD;
		"LESSTHANOREQUAL" COLOR #800055, BOLD;

		"REQUIRES" COLOR #800055, BOLD;
		"EXCLUDES" COLOR #800055, BOLD;
}

RULES {
								//FEATURE MODEL
	FeatureModel2 ::= "feature" #1 "model" #1 name['"','"'] !0
					domains* !0 root !0 constraints* !0; 
	
	Feature2 ::= selected[selected : "selected", deselected : "deselected", unbound : ""] 
				"feature" #1 name['"','"']  #1 "<" id[TEXT] ">"  
				 ((!0 #4 (attributes))*)? 
				 ((!0 #4 (groups))*)?; 
	
	Group2 ::=  "group" #1 "<" id[TEXT] ">" #1 "(" minCardinality[TEXT] ".." maxCardinality[TEXT] ")" 
						#1 "{" !0 childFeatures+ !0 "}" !1;
						
	Attribute2 ::= "attribute" name[TEXT] #1 "[" #1 domain[] #1 "]"
					//(#1 "=" #1 (value[TEXT]))?;
					(#1 "selected value =" #1 (value[TEXT]))?
					(#1 "deselected values =" #1 "{" deselectedValues[TEXT] ("," deselectedValues[TEXT])* "}")?;
	
	DiscreteDomain2 ::= "domain"  #1 "<" id[TEXT] ">" "[" values[TEXT] ("," #1 values[TEXT])* "]";
	
	ContinuousDomain2 ::= "domain" #1 "<" id[TEXT] ">" "[" intervals ("," #1 intervals)* "]";
	
	Interval2 ::= lowerBound[TEXT] ".." upperBound[TEXT];		
	
								//CONSTRAINTS MODEL
	Constraint2 ::= "constraint" #1 "<" id[TEXT] ">" #1 expression ";" !0;

	@Operator(type="primitive", weight="4", superclass="Expression2")
	FeatureReference2 ::= feature[];

	@Operator(type="binary_left_associative", weight="3", superclass="Expression2")
	GreaterThan ::= operand1 #1 _[GREATERTHAN] #1 operand2;                   
	
	@Operator(type="binary_left_associative", weight="3", superclass="Expression2")
	GreaterThanOrEqual ::= operand1 #1 _[GREATERTHANOREQUAL] #1 operand2;     
	
	@Operator(type="binary_left_associative", weight="3", superclass="Expression2")
	LessThan ::= operand1 #1 _[LESSTHAN] #1 operand2;                         
				    
	@Operator(type="binary_left_associative", weight="3", superclass="Expression2")
	LessThanOrEqual ::= operand1 #1 _[LESSTHANOREQUAL] #1 operand2;	
	
	@Operator(type="binary_left_associative", weight="2", superclass="Expression2")
	Equal ::= operand1 #1 _[EQUAL] #1 operand2;
	
	@Operator(type="binary_left_associative", weight="2", superclass="Expression2")
	Unequal ::= operand1 #1 _[UNEQUAL] #1 operand2;

	@Operator(type="binary_left_associative", weight="1", superclass="Expression2")
	Requires::= operand1 #1 _[REQUIRES] #1 operand2;
	
	@Operator(type="binary_left_associative", weight="1", superclass="Expression2")
	Excludes ::= operand1 #1 _[EXCLUDES] #1 operand2;
	}
	
//-------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------
//	 ExpressionModel  ::= "Expression" #1 "Model" #1 name['"','"'] #1 !0  
	 					// "Feature" #1 "Model" #1 (featureModels['[',']'])+ !0
//	  				       expressions*;	       
	//--------------------------------------------------------------------------------	       
    //-------------------  Expressions from feature model  ---------------------------
//					@Operator(type="primitive", weight="9", superclass="Expression") 
//					NestedExpression ::= "(" operand ")";
	
//	@Operator(type="unary_prefix", weight="8", superclass="Expression") 
//	NotExpression ::= "!" operand;
							
//	@Operator(type="binary_left_associative", weight="3", superclass="Expression")
//	AndExpression ::= operand1 #1 "&&" #1 operand2;
	
//	@Operator(type="binary_left_associative", weight="2", superclass="Expression")
//	OrExpression ::= operand1 #1 "||" #1 operand2;
	

	//-------------------- feature model references------------------------------
					
					//feature.attribute		
				//	@Operator(type="primitive", weight="9", superclass="Expression")				  
				//	FeatureAttributeReference ::= feature[] _[DOT] attribute[];  		
	
					//feature.attribute := value
					//@Operator(type="primitive", weight="9", superclass="Expression") 				  
								//FeatureAttributeValue ::= feature[] _[DOT] attribute[]#1":="value[];  //original
					//FeatureAttributeValue ::= feature[] _[DOT] attribute[]#1":=" #1 value['"','"']; 
//}