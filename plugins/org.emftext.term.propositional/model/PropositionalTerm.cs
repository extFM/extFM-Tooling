SYNTAXDEF expression
FOR <http://www.tu-dresden.de/expression>
START Constraint

OPTIONS {
    additionalDependencies = "org.js.model.feature";
	overridePluginXML = "false";
	overrideManifest = "false";
	reloadGeneratorModel = "true";
	overrideTextResource = "false";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
    //resourcePluginID = "org.emftext.term.propositional";
	//avoid removal of featurevalidator binding
	//overridePluginXML = "false";	
	//overrideManifest = "false";
}


TOKENS {
}
			
			
			

RULES {

	Constraint ::= term; 

	@Operator(type="binary_left_associative", weight="1", superclass="Term")
	Or ::= operand1 "or" operand2;
	
	@Operator(type="binary_left_associative", weight="2", superclass="Term")
	And ::= operand1 "and" operand2;
	
	@Operator(type="unary_prefix", weight="3", superclass="Term")
	Not ::= "not" operand;
	
	@Operator(type="primitive", weight="4", superclass="Term")
	Nested ::= "(" operand ")";

	@Operator(type="primitive", weight="4", superclass="Term")
	FeatureRef ::= feature[];
}