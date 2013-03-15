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
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))* $ ;
}

TOKENSTYLES {
	"COMMENT" COLOR #AAAAAA;
}	
	
	RULES {
	// syntax definition for class 'StartMetaClass'
	@SuppressWarnings(explicitSyntaxChoice) 
	AccessControlModel   ::= "access control" #1 
									("on" #1 featureModels['<','>'] ("," featureModels['<','>'])*)+ !0
									("references" #1 accessControlModels['<','>'] ("," accessControlModels['<','>'])* )? !0
									("permissions" #1 "{" !0 permissions ( ","!0 permissions)+ "}")* !0
									(roles | groups | subjects)* ; 
	
	//Stage ::= type[Declaration : "declaration", Integration : "integration", Specialization : "specialization", Separation : "separation"] 
	//		#1 "stage" ("roles" "{" roles[IDENTIFIER]+ "}")?;
	@SuppressWarnings(nonContainmentOpposite) 
	@SuppressWarnings(explicitSyntaxChoice) 
	Role ::= "role" #1 name['"','"']? #1 id['<','>'] ("extends" (parentRoles[]) ("," parentRoles[])*)? !0 
			(("{" (permissions['"','"'] | tasks)  ("," (permissions['"','"'] | tasks) )* "}") )? ;



	// syntax definition for configuration operations
	SelectFeature ::= #4 "select" #1 feature[];
	DeselectFeature ::= #4 "deselect" #1 feature[];
	
	SetAttribute ::= #4 "set" feature[] #0 "." #0 attribute[] 
						("{" domainValueOperations ("," domainValueOperations)* "}")* ;

	SelectDomainValue ::= #4 "select" value[];
	DeselectDomainValue ::= #4 "deselect" value[];
	
	@SuppressWarnings(nonContainmentOpposite) 
	Subject ::= "subject" #1 name['"','"']? #1 id['<','>'] !0 
			("{" roles[] ("," roles[])* "}")?;
	
	Group ::= "group" #1 name['"','"']? #1 id['<','>'] role[] !0 
			("{" contains[] ("," contains[])* "}")?;

	Task ::= "task" name['"','"']? #1 id['<','>'];
}
