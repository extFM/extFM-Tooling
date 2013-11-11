SYNTAXDEF mtext
FOR <http://www.tudresden.de/viewmapping> <optional/path/to/myLanguage.genmodel>
START MappingModel

OPTIONS {
	additionalDependencies = "org.js.model.feature, org.feature.multi.perspective.model, org.feature.model.utilities, org.js.model.feature.edit";
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
	overrideLaunchConfigurationDelegate = "false";
	
 	srcFolder = "src/main/java";
	srcGenFolder = "src/gen/java";
	
	uiSrcFolder = "src/main/java";
	uiSrcGenFolder = "src/gen/java";
}

RULES {
	// syntax definition for class 'MappingModel'
	MappingModel   ::= 	"viewmapping" !0
						#3 ("featuremodel" #1 featureModel['<','>']) !0
						#3 ("viewmodel" #1 viewModel['<','>']) !0!0
						(mappings*);
	
	// syntax definition for class 'Mapping'
	Mapping ::= "view group" #1 viewgroup['"','"'] #1 "contains" !0
				#3 features['"','"']  (#1 "," #1 features['"','"'] )* !0!0; 
	
	  
				
}