/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;

public class MtextPrinter implements org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextPrinter {
	
	protected org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolverFactory tokenResolverFactory = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextTokenResolverFactory();
	
	protected java.io.OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextResource resource;
	
	private java.util.Map<?, ?> options;
	private String encoding = System.getProperty("file.encoding");
	
	public MtextPrinter(java.io.OutputStream outputStream, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextResource resource) {
		super();
		this.outputStream = outputStream;
		this.resource = resource;
	}
	
	protected int matchCount(java.util.Map<String, Integer> featureCounter, java.util.Collection<String> needed) {
		int pos = 0;
		int neg = 0;
		
		for (String featureName : featureCounter.keySet()) {
			if (needed.contains(featureName)) {
				int value = featureCounter.get(featureName);
				if (value == 0) {
					neg += 1;
				} else {
					pos += 1;
				}
			}
		}
		return neg > 0 ? -neg : pos;
	}
	
	protected void doPrint(org.eclipse.emf.ecore.EObject element, java.io.PrintWriter out, String globaltab) {
		if (element == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write.");
		}
		if (out == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write on.");
		}
		
		if (element instanceof org.feature.multi.perspective.mapping.viewmapping.MappingModel) {
			print_org_feature_multi_perspective_mapping_viewmapping_MappingModel((org.feature.multi.perspective.mapping.viewmapping.MappingModel) element, globaltab, out);
			return;
		}
		if (element instanceof org.feature.multi.perspective.mapping.viewmapping.Mapping) {
			print_org_feature_multi_perspective_mapping_viewmapping_Mapping((org.feature.multi.perspective.mapping.viewmapping.Mapping) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextReferenceResolverSwitch getReferenceResolverSwitch() {
		return (org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextReferenceResolverSwitch) new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextProblem(errorMessage, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemType.PRINT_PROBLEM, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemSeverity.WARNING), cause);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public void setEncoding(String encoding) {
		if (encoding != null) {
			this.encoding = encoding;
		}
	}
	
	public String getEncoding() {
		return encoding;
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextResource getResource() {
		return resource;
	}
	
	/**
	 * Calls {@link #doPrint(EObject, PrintWriter, String)} and writes the result to
	 * the underlying output stream.
	 */
	public void print(org.eclipse.emf.ecore.EObject element) throws java.io.IOException {
		java.io.PrintWriter out = new java.io.PrintWriter(new java.io.OutputStreamWriter(new java.io.BufferedOutputStream(outputStream), encoding));
		doPrint(element, out, "");
		out.flush();
		out.close();
	}
	
	public void print_org_feature_multi_perspective_mapping_viewmapping_MappingModel(org.feature.multi.perspective.mapping.viewmapping.MappingModel element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING_MODEL__MAPPINGS));
		printCountingMap.put("mappings", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING_MODEL__FEATURE_MODEL));
		printCountingMap.put("featureModel", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING_MODEL__VIEW_MODEL));
		printCountingMap.put("viewModel", temp == null ? 0 : 1);
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("viewmapping");
		out.print(" ");
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print("   ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_feature_multi_perspective_mapping_viewmapping_MappingModel_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print("   ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_feature_multi_perspective_mapping_viewmapping_MappingModel_1(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_feature_multi_perspective_mapping_viewmapping_MappingModel_2(element, localtab, out, printCountingMap);
	}
	
	public void print_org_feature_multi_perspective_mapping_viewmapping_MappingModel_0(org.feature.multi.perspective.mapping.viewmapping.MappingModel element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("featuremodel");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("featureModel");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING_MODEL__FEATURE_MODEL));
			if (o != null) {
				org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getMappingModelFeatureModelReferenceResolver().deResolve((org.featuremapper.models.feature.FeatureModel) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING_MODEL__FEATURE_MODEL)), element.eClass().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING_MODEL__FEATURE_MODEL), element));
				out.print(" ");
			}
			printCountingMap.put("featureModel", count - 1);
		}
	}
	
	public void print_org_feature_multi_perspective_mapping_viewmapping_MappingModel_1(org.feature.multi.perspective.mapping.viewmapping.MappingModel element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("viewmodel");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("viewModel");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING_MODEL__VIEW_MODEL));
			if (o != null) {
				org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getMappingModelViewModelReferenceResolver().deResolve((org.feature.multi.perspective.model.viewmodel.GroupModel) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING_MODEL__VIEW_MODEL)), element.eClass().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING_MODEL__VIEW_MODEL), element));
				out.print(" ");
			}
			printCountingMap.put("viewModel", count - 1);
		}
	}
	
	public void print_org_feature_multi_perspective_mapping_viewmapping_MappingModel_2(org.feature.multi.perspective.mapping.viewmapping.MappingModel element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("mappings");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING_MODEL__MAPPINGS));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("mappings", 0);
		}
	}
	
	
	public void print_org_feature_multi_perspective_mapping_viewmapping_Mapping(org.feature.multi.perspective.mapping.viewmapping.Mapping element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING__FEATURES));
		printCountingMap.put("features", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING__VIEWGROUP));
		printCountingMap.put("viewgroup", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("view group");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("viewgroup");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING__VIEWGROUP));
			if (o != null) {
				org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getMappingViewgroupReferenceResolver().deResolve((org.feature.multi.perspective.model.viewmodel.AbstractGroup) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING__VIEWGROUP)), element.eClass().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING__VIEWGROUP), element));
			}
			printCountingMap.put("viewgroup", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("contains");
		out.print(" ");
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print("   ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_feature_multi_perspective_mapping_viewmapping_Mapping_0(element, localtab, out, printCountingMap);
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_org_feature_multi_perspective_mapping_viewmapping_Mapping_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
	}
	
	public void print_org_feature_multi_perspective_mapping_viewmapping_Mapping_0(org.feature.multi.perspective.mapping.viewmapping.Mapping element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("features");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING__FEATURES));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getMappingFeaturesReferenceResolver().deResolve((org.featuremapper.models.feature.Feature) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING__FEATURES)), element.eClass().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING__FEATURES), element));
			}
			printCountingMap.put("features", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
	}
	
	
}
