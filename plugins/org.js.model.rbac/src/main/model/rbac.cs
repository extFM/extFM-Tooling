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
	"set" COLOR #147F87, BOLD; 
	"select" COLOR #009E0F, BOLD; 
	"deselect" COLOR #CE0000, BOLD; 
}	
	
	RULES {
	// syntax definition for container class 'AccessControlModel'
	@SuppressWarnings(explicitSyntaxChoice) 
	AccessControlModel   ::= "access control" #1 
									("on" #1 featureModel['<','>']) !0
									(roles | groups | subjects)* ; 
	
	// syntax definition for roles
	@SuppressWarnings(nonContainmentOpposite) 
	@SuppressWarnings(explicitSyntaxChoice) 
	Role ::= "role" #1 name['"','"']? #1 id['<','>'] #1 ("extends" #1 (parentRoles[]) (#1 "," #1 parentRoles[])*)? #1 
			(("{" !1 ( permissions | tasks) #1 (","  #1 ( permissions | tasks) )* #1 
			!0 "}") )? !0 ;

	// syntax definition for feature configuration operations
	FeatureOperation ::= #4 type[select : "select", deselect : "deselect"] #1 feature[TEXT] !0;
	
	// syntax definition for attribute configuration operations
	AttributeOperation ::= #4 "set" feature[] #0 "." #0 attribute[TEXT]
						(#1 "{" #1 valueOperations ("," #1 valueOperations)* "}")* ;

	DomainValueOperation ::= type[select : "select", deselect : "deselect"] #1 value[TEXT] !0;
	
	
	// syntax definition for subjects
	@SuppressWarnings(nonContainmentOpposite) 
	Subject ::= "subject" #1 name['"','"']? #1 id['<','>'] #1 "plays" #1 (roles[] ( #1 "," #1 roles[])* )? !0;
	
	// syntax definition for groups
	Group ::= "group" #1 name['"','"']? #1 id['<','>'] (#1 "of" #1 owner[])? !0 
			"has members" #1 (members[] (#1 "," #1 members[])*)?;

	// syntax definition for tasks used in feature information models
	Task ::= "task" #1 name['"','"']? #1 id['<','>'] !0;

	// syntax definition for restricting the visibility of feature information model elements
	VisibilityRestriction ::= visibility[modify : "modify", view : "view"] #1 resourceId[] !0; 
}
