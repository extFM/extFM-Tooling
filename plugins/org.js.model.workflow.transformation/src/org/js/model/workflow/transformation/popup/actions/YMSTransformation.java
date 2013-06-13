package org.js.model.workflow.transformation.popup.actions;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.js.model.feature.Attribute;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureFactory;
import org.js.model.feature.FeatureModel;
import org.js.model.workflow.util.WorkflowUtil;

import com.sap.research.cocktail.model.Context;
import com.sap.research.cocktail.model.variability.BindingTime;
import com.sap.research.cocktail.model.variability.ResolutionElement;
import com.sap.research.cocktail.model.variability.VariabilityResolution;

public class YMSTransformation implements IObjectActionDelegate {

	private Shell shell;
	private IFile oldFile = null;
	private FeatureFactory ff = FeatureFactory.eINSTANCE;
	private String ddsModelReference = "\\com.sap.ym.services.dds\\com.sap.ym.services.dds.var";
	private String jockeyModelReference = "\\com.sap.ym.services.jockey\\com.sap.ym.services.jockey.var";

	/**
	 * Constructor for Action1.
	 */
	public YMSTransformation() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		URI oldFMUri = URI.createFileURI(oldFile.getFullPath().toOSString());
		FeatureModel featureModel = WorkflowUtil.getFeatureModel(oldFMUri);
		String oldFilePath = oldFile.getLocation().toOSString();
		String oldFileName = oldFMUri.lastSegment();
		String newDDSFilePath = oldFilePath.replace(oldFileName, "dds.res");
		String newJockeyFilePath = oldFilePath.replace(oldFileName,
				"joecky.res");
		writeResolution(featureModel, newDDSFilePath, ddsModelReference);
		writeResolution(featureModel, newJockeyFilePath, jockeyModelReference);
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		oldFile = (IFile) ((IStructuredSelection) selection).getFirstElement();
	}

	public void writeResolution(FeatureModel featureModel, String filePath,
			String modelReference) {
		VariabilityResolution resolution = new VariabilityResolution();
		Properties prop = new Properties();
		try {
			// load a properties file
			prop.load(this.getClass().getClassLoader().getResourceAsStream("yms.properties"));
//			prop.load(new FileInputStream("yms.properties"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		// map features onto resolution elements of YMS resolution model
		for (Feature feature : WorkflowUtil.getFeatures(featureModel)) {
			ResolutionElement e = new ResolutionElement();
			String variant = prop.getProperty(feature.getId());
			if (variant != null) {
				e.setResolves(variant);
				String value = "false";
				if (feature.getSelected().getValue() == 1) {
					value = "true";
				}
				e.setValue(value);
				e.setBindingTime(BindingTime.RUN_TIME);
				resolution.getResolutionElements().add(e);
			}
		}
		// map attributes onto resolution elements of YMS resolution model
		for (Attribute attribute : WorkflowUtil.getAttributes(featureModel)) {
			ResolutionElement e = new ResolutionElement();
			String variant = prop.getProperty(attribute.getName());
			if (variant != null) {
				e.setResolves(variant);
				e.setValue(attribute.getValue());
				e.setBindingTime(BindingTime.RUN_TIME);
				resolution.getResolutionElements().add(e);
			}
		}

		resolution.setModelReference(modelReference);

		// write the YMS configuration file
		IPath path = new Path(filePath);
		File file = path.toFile();
		if (!file.exists()) {
			try {
				// if file doesnt exists, then create it
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		writeFile(file, resolution);
	}

	public void writeFile(File file, final Object object) {
		FileOutputStream fop = null;
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {
			fop = new FileOutputStream(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		Marshaller m;
		try {
			m = Context.getInstance().getJAXBContext().createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
			m.marshal(object, out);
			fop.write(out.toByteArray());
			fop.flush();
			fop.close();
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
		// get the content in bytes
		System.out.println("Done");
	}
}
