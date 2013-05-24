package org.js.model.workflow.ui;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.js.model.rbac.DeselectFeature;
import org.js.model.rbac.Permission;
import org.js.model.rbac.RBACService;
import org.js.model.rbac.Role;
import org.js.model.rbac.SelectFeature;
import org.js.model.rbac.SetAttribute;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.GridData;

public class StakeholderConfigUIShell extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
//	public static void main(String args[]) {
//		try {
//			Display display = Display.getDefault();
//			StakeholderConfigUIShell shell = new StakeholderConfigUIShell(
//					display);
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
	public StakeholderConfigUIShell(Display display, Role role) {
		super(display, SWT.SHELL_TRIM);
		setLayout(new FillLayout(SWT.VERTICAL));
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		
		Composite composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setLayout(new GridLayout(1, false));
		GridData gd_composite_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_composite_1.heightHint = 160;
		gd_composite_1.widthHint = 354;
		composite_1.setLayoutData(gd_composite_1);
		
		Composite composite_2 = new Composite(composite, SWT.NONE);
		composite_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		composite_2.setLayout(new RowLayout(SWT.HORIZONTAL));
		
		Button button = new Button(composite_2, SWT.NONE);
		button.setText("Ok");
		
		Button button_1 = new Button(composite_2, SWT.NONE);
		button_1.setText("Cancel");
		
		// config ui
		
		RBACService rbacService = new RBACService();
		Set<Permission> permissions=rbacService.getAllRolePermissions(role);
		Iterator<Permission> it = permissions.iterator();
		while(it.hasNext()){
			Permission permission= it.next();
			Button btnCheckButton = new Button(composite_1, SWT.CHECK);
//			System.out.println(permission.getClass());
			if(permission instanceof SelectFeature){
				btnCheckButton.setText("select feature "+((SelectFeature)permission).getFeature().getId());
			}else if(permission instanceof DeselectFeature){
				btnCheckButton.setText("deselect feature "+((DeselectFeature)permission).getFeature().getId());
			}else if(permission instanceof SetAttribute){
				btnCheckButton.setText("set attribute "+((SetAttribute)permission).getAttribute().getName());
			}
		}
		
		
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(380, 241);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
