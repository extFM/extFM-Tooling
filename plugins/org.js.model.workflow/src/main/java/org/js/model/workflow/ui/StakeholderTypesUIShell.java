package org.js.model.workflow.ui;

import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.Role;

import org.eclipse.swt.layout.RowLayout;
/**
 * UI for the stakeholder types.
 * @author Xi
 *
 */
public class StakeholderTypesUIShell extends Shell {

	private List stakeholderTypesList;
	private EList<Role> stakeholdersTypes;
	private AccessControlModel accessControlModel;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	 public static void main(String args[]) {
	 try {
	 Display display = Display.getDefault();
	 StakeholderTypesUIShell shell = new StakeholderTypesUIShell(display,null,null);
	 shell.open();
	 shell.layout();
	 while (!shell.isDisposed()) {
	 if (!display.readAndDispatch()) {
	 display.sleep();
	 }
	 }
	 } catch (Exception e) {
	 e.printStackTrace();
	 }
	 }

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public StakeholderTypesUIShell(Display display, AccessControlModel acm,
			EList<Role> types) {
		super(display, SWT.SHELL_TRIM);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		//TODO: import the editor shell as the input parameter
		stakeholdersTypes=types;
		accessControlModel=acm;

		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));

		stakeholderTypesList = new List(composite, SWT.BORDER | SWT.V_SCROLL
				| SWT.MULTI);
		GridData gd_stakeholderTypesList = new GridData(SWT.FILL, SWT.FILL,
				true, true, 1, 1);
		gd_stakeholderTypesList.widthHint = 124;
		stakeholderTypesList.setLayoutData(gd_stakeholderTypesList);

		Composite composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setLayout(new RowLayout(SWT.HORIZONTAL));
		composite_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		Button btnOk = new Button(composite_1, SWT.NONE);
		btnOk.setText("Ok");

		Button btnCancel = new Button(composite_1, SWT.NONE);
		btnCancel.setText("Cancel");
		createContents();

		// actions for buttons and list
		stakeholderTypesList.removeAll();
		for (Role stakeholder : acm.getRoles()) {
			stakeholderTypesList.add(stakeholder.getId());
			if (stakeholdersTypes.contains(stakeholder)) {
				int index = stakeholderTypesList.indexOf(stakeholder.getId());
				stakeholderTypesList.select(index);
			}
		}

		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				stakeholdersTypes.clear();
				for (String stakeholder : stakeholderTypesList.getSelection()) {
					for(Role role:accessControlModel.getRoles()){
						if(role.getId().equals(stakeholder)){
							stakeholdersTypes.add(role);
							break;
						}
					}
				}
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
		setText("SWT Application");
		setSize(450, 300);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
