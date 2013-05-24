package org.js.model.workflow.ui;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
//import swing2swt.layout.FlowLayout;
import org.eclipse.swt.widgets.Button;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.Group;
import org.js.model.rbac.Role;
import org.js.model.workflow.util.StakeholderInput;
import org.js.model.workflow.util.WorkflowUtil;
import org.eclipse.swt.layout.RowLayout;

/**
 * UI for the stakeholder input.
 * @author Xi
 *
 */
public class StakeholderUIShell extends Shell {
	private Text stakeholderName;
	private Combo stakeholderTypeCombo;
	private Combo stakeholderGroupCombo;
	private AccessControlModel accessControlModel;
	private EList<Role> stakeholerTypes;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	// public static void main(String args[]) {
	// try {
	// Display display = Display.getDefault();
	// StakeholderUIShell shell = new StakeholderUIShell(display);
	// shell.open();
	// shell.layout();
	// while (!shell.isDisposed()) {
	// if (!display.readAndDispatch()) {
	// display.sleep();
	// }
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public StakeholderUIShell(Display display, AccessControlModel acm,
			EList<Role> shTypes) {
		super(display, SWT.SHELL_TRIM);

		accessControlModel = acm;
		stakeholerTypes = shTypes;

		setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));

		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblNewLabel.setText("Name");

		stakeholderName = new Text(composite, SWT.BORDER);
		stakeholderName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblNewLabel_1.setText("StakeholderType");

		stakeholderTypeCombo = new Combo(composite, SWT.READ_ONLY);
		stakeholderTypeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1));

		Label StakeholerGroupCombo = new Label(composite, SWT.NONE);
		StakeholerGroupCombo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));
		StakeholerGroupCombo.setText("Group");

		stakeholderGroupCombo = new Combo(composite, SWT.READ_ONLY);
		stakeholderGroupCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1));
		new Label(composite, SWT.NONE);

		Composite composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setLayout(new RowLayout(SWT.HORIZONTAL));
		composite_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
//		composite_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		Button btnOk = new Button(composite_1, SWT.NONE);
		btnOk.setText("Ok");

		Button btnCancel = new Button(composite_1, SWT.NONE);
		btnCancel.setText("Cancel");

		createContents();

		// actions for buttons and combos
		if (stakeholerTypes != null && stakeholerTypes.size() != 0) {
			for (Role stakeholder : stakeholerTypes) {
				stakeholderTypeCombo.add(stakeholder.getId());
			}
		} else {
			for (Role stakeholder : acm.getRoles()) {
				stakeholderTypeCombo.add(stakeholder.getId());
			}
		}
		for (Group group : acm.getGroups()) {
			Role leader = group.getRepresents();
			if (stakeholerTypes != null) {
				if (!stakeholerTypes.contains(leader)) {
					stakeholderGroupCombo.add(leader.getId());
				}
			} else {
				stakeholderGroupCombo.add(leader.getId());
			}
		}

		stakeholderTypeCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// int index = stakeholderTypeCombo.getSelectionIndex();
				// String typeName = stakeholderTypeCombo.getItem(index);
				String typeName = stakeholderTypeCombo.getText();
				Role stakeholderType = null;
				for (Role role : stakeholerTypes) {
					if (role.getId().equals(typeName)) {
						stakeholderType = role;
						break;
					}
				}

				stakeholderGroupCombo.removeAll();
				for (Role leader : accessControlModel.getRoles()) {
					if (leader.getParentRoles().contains(stakeholderType)) {
						stakeholderGroupCombo.add(leader.getId());
					}
				}
			}
		});

		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				if (stakeholderName.getText().equals("")
						|| stakeholderTypeCombo.getSelectionIndex() == -1
						|| (stakeholderGroupCombo.getItemCount() != 0 && stakeholderGroupCombo
								.getSelectionIndex() == -1)) {
					String message = "Please fill the required information.";
					MessageDialog.openInformation(
							stakeholderTypeCombo.getShell(), "Warning", message);
				} else {
					WorkflowUtil.SHTempStore=WorkflowUtil.analyzeShInput(stakeholderName.getText(),
							stakeholderTypeCombo.getText(),
							stakeholderGroupCombo.getText(), accessControlModel, stakeholerTypes);
					
					dispose();
				}
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
		setText("Stakeholder Info");
		setSize(356, 167);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public Text getStakeholderName() {
		return stakeholderName;
	}

	public Combo getStakeholderTypeCombo() {
		return stakeholderTypeCombo;
	}

	public Combo getStakeholderGroupCombo() {
		return stakeholderGroupCombo;
	}
}
