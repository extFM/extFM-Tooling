/**
 * 
 */
package org.feature.multi.perspective.model.editor.editors;

import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.feature.model.utilities.FeatureMappingUtil;
import org.feature.model.utilities.ResourceUtil;
import org.feature.multi.perspective.mapping.viewmapping.MappingModel;
import org.feature.multi.perspective.model.viewmodel.GroupModel;

/**
 * This filter displays only featuremappings that have a given viewmodel model
 * set as a solutionspace model.
 * 
 * @author <a href=mailto:info@juliaschroeter.de>Julia Schroeter</a>
 * 
 */
public class ViewmodelMappingFilter extends ViewerFilter {

	private final ResourceSet resourceSet;
	private final IFile groupmodelFile;
	private List<String> extensions;

	public ViewmodelMappingFilter(List<String> extensions, GroupModel groupmodel) {
		this.extensions = extensions;
		this.resourceSet = groupmodel.eResource().getResourceSet();
		this.groupmodelFile = ResourceUtil.getFile(groupmodel.eResource());
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		boolean result = false;
		if (element instanceof IContainer){
			result = true;
		}
		
		if (element instanceof IFile) {
			IFile file = (IFile) element;
			boolean select = hasCorrectExtension(file);
			if (select) {
				IFile groupModelFileFromMapping = getGroupModelFileFromMapping(file);
				if (groupmodelFile != null && groupModelFileFromMapping != null) {
					result = groupmodelFile.equals(groupModelFileFromMapping);
				}
			}
		}
		return result;
	}

	private IFile getGroupModelFileFromMapping(IFile mappingFile) {
		IFile groupModelFileFromMapping = null;
		GroupModel groupModel = getGroupModelFromFile(mappingFile);
		if (groupModel != null) {
			groupModelFileFromMapping = ResourceUtil.getFile(groupModel
					.eResource());
		}
		return groupModelFileFromMapping;
	}

	private GroupModel getGroupModelFromFile(IFile file) {
		GroupModel groupModel = null;
		MappingModel mapping = FeatureMappingUtil.getFeatureMapping(file,
				resourceSet);
		if (mapping != null) {
			groupModel = mapping.getViewModel();
		}
		return groupModel;
	}

	private boolean hasCorrectExtension(IFile element) {
		boolean result = false;
		String fileExtension = element.getFileExtension();
		result = extensions.contains(fileExtension);
		return result;
	}

}
