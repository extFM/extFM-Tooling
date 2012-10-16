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

RULES {
	// syntax definition for class 'StartMetaClass'
	ExpressionModel   ::= "expressions" featureModel['<','>'] expressions*;
	
	// syntax definition for class 'AnotherMetaClass'
	Expression ::= "expression" ;
}