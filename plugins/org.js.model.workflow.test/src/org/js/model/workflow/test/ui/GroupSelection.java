package org.js.model.workflow.test.ui;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jwt.meta.model.core.Model;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.Role;
import org.js.model.workflow.util.WorkflowUtil;

public class GroupSelection extends Shell {

	public String groupLeaderName = null;
	Combo groupCombo=null;
	/**
	 * Launch the application.
	 * @param args
	 */
//	public static void main(String args[]) {
//		try {
//			Display display = Display.getDefault();
//			GroupSelection shell = new GroupSelection(display);
//			shell.open();
//			shell.layout();
//			while (!shell.isDisposed()) {
//				if (!display.readAndDispatch()) {
//					display.sleep();
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public GroupSelection(Display display,AccessControlModel acm
			) {
		super(display, SWT.SHELL_TRIM);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.VERTICAL));
		
		groupCombo = new Combo(composite, SWT.READ_ONLY);
		
		Composite composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setLayout(new RowLayout(SWT.HORIZONTAL));
		Button btnOk = new Button(composite_1, SWT.NONE);
		btnOk.setText("Ok");
		
		Button btnCancel = new Button(composite_1, SWT.NONE);
		btnCancel.setText("Cancel");
		createContents();
		
		// add listeners
		for(Role role:acm.getRoles()){
			for(Role parent:role.getParentRoles()){
				if(parent.getId().equals("Tenant")){
					groupCombo.add(role.getId());
				}
			}
		}
		
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				int index =groupCombo.getSelectionIndex();
				groupLeaderName=groupCombo.getItem(index);
					dispose();
			}
			
		});
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				dispose();
			}
		});
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Group Selection");
		setSize(433, 109);

	}
	
	public String getGroupLeaderName(){
		return groupLeaderName; 
	}
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
