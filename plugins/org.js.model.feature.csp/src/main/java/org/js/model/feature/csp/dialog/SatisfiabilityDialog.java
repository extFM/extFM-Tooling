/**
 * 
 */
package org.js.model.feature.csp.dialog;

import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.js.model.feature.csp.CSPPlugin;

/**
 * @author Julia
 *
 */
public class SatisfiabilityDialog extends MessageDialog{

	private TableViewer viewer;
	private List<SatisfiableFile> fileList;
	
	 private static final Image SATISFIABLE = CSPPlugin.getImage("icons/obj16/satisfiable.gif");
	 private static final Image UNSATISFIABLE = CSPPlugin.getImage("icons/obj16/unsatisfiable.gif");
	
	public SatisfiabilityDialog(Shell parentShell, String dialogTitle,
			Image dialogTitleImage, String dialogMessage, int dialogImageType,
			String[] dialogButtonLabels, int defaultIndex) {
		super(parentShell, dialogTitle, dialogTitleImage, dialogMessage,
				dialogImageType, dialogButtonLabels, defaultIndex);
	}
	
	@Override
	protected Control createCustomArea(Composite parent) {
	    viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
	        | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
	    createColumns(parent, viewer);
	    final Table table = viewer.getTable();
	    table.setHeaderVisible(true);
	    table.setLinesVisible(true);

	    viewer.setContentProvider(new ArrayContentProvider());
	    // Get the content for the viewer, setInput will call getElements in the
	    // contentProvider
	    viewer.setInput(getFileList());

	    // Layout the viewer
	    GridData gridData = new GridData();
	    gridData.verticalAlignment = GridData.FILL;
	    gridData.horizontalSpan = 2;
	    gridData.grabExcessHorizontalSpace = true;
	    gridData.grabExcessVerticalSpace = true;
	    gridData.horizontalAlignment = GridData.FILL;
	    viewer.getControl().setLayoutData(gridData);
	    return viewer.getControl();
	  }

	  public TableViewer getViewer() {
	    return viewer;
	  }

	  // This will create the columns for the table
	  private void createColumns(final Composite parent, final TableViewer viewer) {
	    String[] titles = { "Satisfiability", "File" };
	    int[] bounds = { 100, 300};

	    // First column is for satisifiability
	    TableViewerColumn col = createTableViewerColumn(titles[0], bounds[0], 0);
	    col.setLabelProvider(new ColumnLabelProvider() {
	    	@Override
	    	public String getText(Object element) {
	    		return null;
	    	}
	    	
	    	@Override
	    	public Image getImage(Object element) {
	    		if (((SatisfiableFile) element).isSatisfiable()) {
	    			return SATISFIABLE;
	    		} else {
	    			return UNSATISFIABLE;
	    		}
	    	}
	    });

	    // Second column is for filename
	    col = createTableViewerColumn(titles[1], bounds[1], 1);
	    col.setLabelProvider(new CellLabelProvider() {
	      @Override
	      public void update(ViewerCell cell) {
	        cell.setText(((SatisfiableFile) cell.getElement()).getFileName());
	      }
	    });


	  }

	  private TableViewerColumn createTableViewerColumn(String title, int bound,
	      final int colNumber) {
	    final TableViewerColumn viewerColumn = new TableViewerColumn(viewer,
	        SWT.NONE);
	    final TableColumn column = viewerColumn.getColumn();
	    column.setText(title);
	    column.setWidth(bound);
	    column.setResizable(true);
	    column.setMoveable(true);
	    return viewerColumn;
	  }


	  
	/**
	   * Passing the focus request to the viewer's control.
	   */

	  public void setFocus() {
	    viewer.getControl().setFocus();
	  }

	public List<SatisfiableFile> getFileList() {
		return fileList;
	}

	public void setFileList(List<SatisfiableFile> fileList) {
		this.fileList = fileList;
	}

	
}
