@SuppressWarnings(tokenOverlapping)
SYNTAXDEF rbactext // role based access control for feature models
FOR <http://www.tudresden.de/rbac>
START RbacModel

OPTIONS {
	additionalDependencies = "org.js.model.feature";
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
	disableLaunchSupport = "true";
	disableNewProjectWizard = "true";

 	srcFolder = "src/main/java";
	srcGenFolder = "src/gen/java";
	
	uiSrcFolder = "src/main/java";
	uiSrcGenFolder = "src/gen/java";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))* $ ;
	DEFINE S_DESELECT $'deselect'$;
	DEFINE S_SELECT $'select'$;
	DEFINE COMMA $(','|';')$;
}

TOKENSTYLES {
	"#" COLOR #800055, BOLD;
	"COMMENT" COLOR #AAAAAA;
}	
	
	RULES {
	// syntax definition for class 'StartMetaClass'
	RbacModel   ::= "rbac" #1 
									"references" #1 (featureModels['<','>'])+ !0
									//("configuration operations" #1 !0 configurationOperations*)? !0
									(roles*)? !0 
									(individuals*)?; 
	
	//Stage ::= type[Declaration : "declaration", Integration : "integration", Specialization : "specialization", Separation : "separation"] 
	//		#1 "stage" ("roles" "{" roles[IDENTIFIER]+ "}")?;
	
	Role ::= "role" #1 name['"','"'] #1 id['<','>'] !0 
			("permissions" "{" allowedOperations* "}")+ ;

	// syntax definition for configuration operations
	FeatureConfiguration ::= #4 (feature[] ":" select[S_SELECT]? deselect[S_DESELECT]?) ;
	AttributeConfiguration ::= #4 (feature[] "#" attribute[] ("(" valueOperations+ ")"));

	ValueOperation ::=  (value['"','"'] ":" select[S_SELECT]? deselect[S_DESELECT]?) | (_[COMMA] value['"','"'] ":" select[S_SELECT]? deselect[S_DESELECT]?);


	Individual ::= "individual" #1 name['"','"'] #1 id['<','>'] !0 
			("roles" "{" roles[]+ "}")?;


}
