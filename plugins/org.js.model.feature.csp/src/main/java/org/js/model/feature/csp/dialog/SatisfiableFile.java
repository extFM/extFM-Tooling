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
	 
	  public SatisfiableFile(String fileName, boolean isSatisfiable) {
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
	
}
