@SuppressWarnings(tokenOverlapping)
SYNTAXDEF rbactext // role based access control for feature models
FOR <http://www.tudresden.de/rbac>
START AccessControlModel

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
	DEFINE S_DESELECT $'deselect'$;
	DEFINE S_SELECT $'select'$;
	DEFINE COMMA $(','|';')$;
	DEFINE DOT $('.')$;
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))* $ ;
}

TOKENSTYLES {
	"COMMENT" COLOR #AAAAAA;
}	
	
	RULES {
	// syntax definition for class 'StartMetaClass'
	AccessControlModel   ::= "access control" #1 
									("on" #1 featureModels['<','>'] (_[COMMA] featureModels['<','>'])*)+ !0
									("references" #1 accessControlModels['<','>'] (_[COMMA] accessControlModels['<','>'])* )? !0
									roles* groups* subjects* ; 
	
	//Stage ::= type[Declaration : "declaration", Integration : "integration", Specialization : "specialization", Separation : "separation"] 
	//		#1 "stage" ("roles" "{" roles[IDENTIFIER]+ "}")?;
	@SuppressWarnings(nonContainmentOpposite) 
	@SuppressWarnings(explicitSyntaxChoice) 
	Role ::= "role" #1 name['"','"']? #1 id['<','>'] ("extends" (parentRoles[]) (_[COMMA] parentRoles[])*)? !0 
			(("{" (permissions | tasks)+ "}") )? ;



	// syntax definition for configuration operations
	SelectFeature ::= #4 allowed["" : "not"] "select feature" feature[];
	DeselectFeature ::= #4 allowed["" : "not"] "deselect feature" feature[];
	
	SetAttribute ::= #4 allowed["" : "not"] "set" feature[] #0 _[DOT] #0 attribute[] 
						("(" domainValueOperations+ ")")* ;

	SelectDomainValue ::= allowed["" : "not"] #4 "select value" value[];
	DeselectDomainValue ::= allowed["" : "not"] #4 "deselect value" value[];
	
	@SuppressWarnings(nonContainmentOpposite) 
	Subject ::= "subject" #1 name['"','"']? #1 id['<','>'] !0 
			("{" roles[] "}")?;
	
	Group ::= "group" #1 name['"','"']? #1 id['<','>'] role[] !0 
			("{" contains[]+ "}")?;

	Task ::= "task" name['"','"']? #1 id['<','>'];
}
