package org.js.model.feature;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.js.model.feature.Attribute;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureModel;

public class ReferenceResolverUtil {
	public static Feature findFeature(String identifier, FeatureModel featureModel) {
		Iterator<EObject> iterator = featureModel.eAllContents();
		
		while(iterator.hasNext()) {
			EObject object = iterator.next();
		
			if (object instanceof Feature) {
				Feature feature = (Feature) object;
				String featureId = feature.getId();
				
				if (featureId.equals(identifier)) {
					return feature;
				}
			}
		}
		
		return null;
	}
	
	public static Attribute findAttributeForFeature(String identifier, Feature feature) {
		List<Attribute> attributes = feature.getAttributes();
		
		for (Attribute attribute : attributes) {
			if (attribute.getName().equals(identifier)) {
				return attribute;
			}
		}
		
		return null;
	}
	
	
	public static String deresolveAttribute(Attribute attribute) {
		Feature feature = attribute.getFeature();
		return feature.getId() + "." + attribute.getName();
	}
}
