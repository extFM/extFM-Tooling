SYNTAXDEF rbactext // role based access control for feature models
FOR <http://www.tudresden.de/rbac>
START RbacModel

OPTIONS {
	additionalDependencies = "org.js.model.feature";
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
	overrideLaunchConfigurationDelegate = "false";
    overrideBuilder = "false";
    overridePluginXML = "false";

 	srcFolder = "src/main/java";
	srcGenFolder = "src/gen/java";
	
	uiSrcFolder = "src/main/java";
	uiSrcGenFolder = "src/gen/java";
}

TOKENS{
	DEFINE IDENTIFIER $('A'..'Z'|'a'..'z'|'_'|'0'..'9')+('A'..'Z'|'a'..'z'|'_'|'-'|'0'..'9')*$;
}

TOKENSTYLES {
	"$" COLOR #000000, BOLD;
	"#" COLOR #000000, BOLD;
	"+f" COLOR #800055, BOLD;
	"-f" COLOR #800055, BOLD;
}	
	
	RULES {
	// syntax definition for class 'StartMetaClass'
	RbacModel   ::= "rbac" #1 
									"references" #1 (featureModels['<','>'])+ !0
									//("configuration operations" #1 !0 configurationOperations*)? !0
									(roles*)? !0 
									(roleOwners*)? !0; 
	
	
	Role ::= "role" #1 name['"','"'] #1 id['<','>'] !0 
			("allows" "{" allowedConfigurationOperations* "}")+ ;

	// syntax definition for configuration operations
	SelectFeature ::= #4 "+f" #0 feature['(',')'] !0;
	DeselectFeature ::= "-f" #0 feature['(',')'] !0;
	ConfigureAttribute ::= #4 ("$" feature[IDENTIFIER] "#" attribute[IDENTIFIER] ) ;

	Stakeholder ::= "stakeholder" #1 name['"','"'] #1 id['<','>'] !0 
			("has" "{" roles[IDENTIFIER]+ "}")?;

	StakeholderGroup ::= "group" #1 name['"','"'] #1 id['<','>'] !0 
			("has" "{" roles[IDENTIFIER]+ "}")?
			("contains" "{" stakeholders[IDENTIFIER]+ "}")+;

}
