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
	usePredefinedTokens = "false";
	disableTokenSorting = "true";
	
 	srcFolder = "src/main/java";
	srcGenFolder = "src/gen/java";
	
	uiSrcFolder = "src/main/java";
	uiSrcGenFolder = "src/gen/java";
	
}

TOKENS {
 	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))* $ ;
 	DEFINE TEXT $('A'..'Z'|'a'..'z'|'0'..'9'|'_')+ $;
 	DEFINE LINEBREAK $ ('\r\n'|'\r'|'\n')+ $;
    DEFINE WHITESPACE $ (' '|'\t'|'\f')+ $ ;
}

TOKENSTYLES {
	"COMMENT" COLOR #AAAAAA;
}	
	
	RULES {
	// syntax definition for container class 'AccessControlModel'
	@SuppressWarnings(explicitSyntaxChoice) 
	AccessControlModel   ::= "access control" #1 
									("on" #1 featureModels['<','>'] ("," featureModels['<','>'])*) !0
									("references" #1 accessControlModels['<','>'] ("," accessControlModels['<','>'])* )? !0
									("permissions" #1 "{" !0 permissions ( ","!0 permissions)* "}")* !0
									(roles | groups | subjects)* ; 
	
	// syntax definition for roles
	@SuppressWarnings(nonContainmentOpposite) 
	@SuppressWarnings(explicitSyntaxChoice) 
	Role ::= "role" #1 name['"','"']? #1 id['<','>'] ("extends" (parentRoles[]) ("," parentRoles[])*)? !0 
			(("{" (permissions['"','"'] | tasks)  ("," (permissions['"','"'] | tasks) )* "}") )? ;

	// syntax definition for feature configuration operations
	SelectFeature ::= #4 "select" #1 feature[];
	DeselectFeature ::= #4 "deselect" #1 feature[];
	
	// syntax definition for attribute configuration operations
	SetAttribute ::= #4 "set" feature[] #0 "." #0 attribute[]
						(#1 "{" #1 attributeDecisions ("," #1 attributeDecisions)* "}")* ;

	SelectDomainValue ::= "+"#0 value[];
	DeselectDomainValue ::= "-"#0 value[];
	
	
	// syntax definition for subjects
	@SuppressWarnings(nonContainmentOpposite) 
	Subject ::= "subject" #1 name['"','"']? #1 id['<','>'] !0 
			("{" roles[] ("," roles[])* "}")?;
	
	// syntax definition for groups
	Group ::= "group" #1 name['"','"']? #1 id['<','>'] "of" represents[] !0 
			"contains" #1 ("{" contains[] ("," contains[])* "}")?;

	// syntax definition for feature information model elements
	Task ::= "task" name['"','"']? #1 id['<','>'];

	ViewElement ::= "view" #1 resourceId[]; 
	ModifyElement ::= "modify" #1 resourceId[];
}
