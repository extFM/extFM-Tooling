/**
 * 
 */
package org.js.model.feature.csp.dialog;

/**
 * @author Julia
 * 
 */
public class SatisfiableFile {

	private boolean isSatisfiable;
	private String fileName;
	private String featureModelName;

	public SatisfiableFile(String fileName, boolean isSatisfiable,
			String featureModelName) {
		this.setFeatureModelName(featureModelName);
		this.setFileName(fileName);
		this.setSatisfiable(isSatisfiable);
	}

	public boolean isSatisfiable() {
		return isSatisfiable;
	}

	public void setSatisfiable(boolean isSatisfiable) {
		this.isSatisfiable = isSatisfiable;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFeatureModelName() {
		return featureModelName;
	}

	public void setFeatureModelName(String featureModelName) {
		this.featureModelName = featureModelName;
	}

}
