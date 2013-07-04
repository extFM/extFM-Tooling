@SuppressWarnings(tokenOverlapping)
SYNTAXDEF eft //Extended Featuremodel Text
FOR <http://www.tudresden.de/extfeature>
START FeatureModel

IMPORTS {
	org.eclipse.emf.ecore:<http://www.eclipse.org/emf/2002/Ecore>
}

OPTIONS {
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
	//DEFINE INTEGER $('0')|(('1'..'9')('0'..'9')*)$;
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))* $ ;
}


TOKENSTYLES {
	"COMMENT" COLOR #AAAAAA;
	"->" COLOR #000000, BOLD;
	"<->" COLOR #000000, BOLD;
	"==" COLOR #000000, BOLD;
	"!=" COLOR #000000, BOLD;
	"<" COLOR #000000, BOLD;
	"<=" COLOR #000000, BOLD;
	">" COLOR #000000, BOLD;
	">=" COLOR #000000, BOLD;
}

RULES {
	FeatureModel ::= "featuremodel" #1 name['"','"'] !0!0
						domains* !0 root !0 constraints* ; 
						
	@SuppressWarnings(explicitSyntaxChoice) 					
	Feature ::= selected[selected : "selected", deselected : "deselected", unbound : ""] "feature" #1 name['"','"'] #1 "<" id[TEXT] ">"
				(!1 (attributes | groups) )*; 
	
	Group ::= "group" #1 "<" id[TEXT] ">" #1 "(" minCardinality[TEXT] ".." maxCardinality[TEXT] ")" 
						#1 "{" (!1 childFeatures)+ "}" !0;
	Attribute ::= name[TEXT] #1 "["  domain[] "]" ("\\" "{" deselectedDomainValues[TEXT] ("," #1 deselectedDomainValues[TEXT])* "}")? 
	(#1 ":=" #1 (value[TEXT]))? ;

	NumericalDomain ::= "domain" #1 "<" id[TEXT] ">" #1 "[" intervals ("," #1 intervals)* "]" !0;
	Interval ::= lowerBound[TEXT] ".." upperBound[TEXT];

	DiscreteDomain ::= "domain"  #1 "<" id[TEXT] ">" #1 "[" values ("," #1 values)* "]" !0;

	DomainValue ::= (name[] "=")? #0 int[];
	Imply ::= "constraint" #1 "<" id[TEXT] ">" #1 leftOperand[TEXT] #1 "->" #1 rightOperand[TEXT] !0;
	
	Exclude ::= "constraint" #1 "<" id[TEXT] ">" #1 leftOperand[TEXT] #1 "<->" #1 rightOperand[TEXT] !0;
	
	AttributeConstraint ::= "constraint" #1 "<" id[TEXT] ">" #1 
			attribute1 #1 
			operator[equal : "==", unequal : "!=", greaterThan : ">", greaterThanOrEqual : ">=", lessThan : "<", lessThanOrEqual : "<="] #1 
			attribute2 !0;

	AttributeReference ::= feature[] "." attribute[];
	
	@SuppressWarnings		
	AttributeValue ::= (name['"','"'] | int[]);	
}