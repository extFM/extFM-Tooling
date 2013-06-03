package org.js.model.workflow.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jwt.meta.model.processes.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.js.model.feature.Feature;
import org.js.model.rbac.AttributeDecision;
import org.js.model.rbac.ConfigurationDecision;
import org.js.model.rbac.DeselectDomainValue;
import org.js.model.rbac.DeselectFeature;
import org.js.model.rbac.FeatureDecision;
import org.js.model.rbac.Permission;
import org.js.model.rbac.RBACService;
import org.js.model.rbac.Role;
import org.js.model.rbac.SelectDomainValue;
import org.js.model.rbac.SelectFeature;
import org.js.model.rbac.SetAttribute;
import org.js.model.workflow.Log;
import org.js.model.workflow.util.WorkflowConfUtil;
import org.js.model.workflow.util.WorkflowModelUtil;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.RowData;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import swing2swt.layout.FlowLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class StakeholderConfigUIShell extends Shell {

	ArrayList<Group> configGroups = new ArrayList<Group>();
	HashMap<Button, ConfigurationDecision> decisionMap = new HashMap<Button, ConfigurationDecision>();
	Action selectedAction = null;
	Role selectedRole = null;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	// public static void main(String args[]) {
	// try {
	// Display display = Display.getDefault();
	// StakeholderConfigUIShell shell = new StakeholderConfigUIShell(
	// display);
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
	public StakeholderConfigUIShell(Display display, Role role, Action action) {
		super(display, SWT.SHELL_TRIM);
		selectedAction = action;
		selectedRole = role;
		setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));

		Composite composite_config = new Composite(composite, SWT.NONE);
		RowLayout rl_composite_config = new RowLayout(SWT.VERTICAL);
		rl_composite_config.fill = true;
		composite_config.setLayout(rl_composite_config);
		composite_config.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));

		Composite composite_buttons = new Composite(composite, SWT.NONE);
		composite_buttons.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));
		composite_buttons.setLayout(new RowLayout(SWT.HORIZONTAL));

		Button button_ok = new Button(composite_buttons, SWT.NONE);
		button_ok.setText("Ok");

		Button button_cancel = new Button(composite_buttons, SWT.NONE);
		button_cancel.setText("Cancel");

		// configuration groups
		EList<Permission> permissions = role.getPermissions();
		// RBACService rbacService = new RBACService();
		// Set<Permission> permissions =
		// rbacService.getAllRolePermissions(role);
		Iterator<Permission> it = permissions.iterator();

		while (it.hasNext()) {
			Permission permission = it.next();
			// get the configuration group
			if (permission instanceof FeatureDecision) {
				Feature feature = ((FeatureDecision) permission).getFeature();
				Group configGroup = null;
				for (Group group : configGroups) {
					if (group.getText().equals(feature.getId())) {
						configGroup = group;
						break;
					}
				}
				if (configGroup == null) {
					configGroup = new Group(composite_config, SWT.NONE);
					configGroup.setText(feature.getId());
					configGroup.setLayout(new FillLayout(SWT.HORIZONTAL));
					configGroups.add(configGroup);
				}
				Button radioButton = new Button(configGroup, SWT.RADIO);
				if (permission instanceof SelectFeature) {
					radioButton.setText("select feature");
				} else if (permission instanceof DeselectFeature) {
					radioButton.setText("deselect feature");
				}
			} else if (permission instanceof SetAttribute) {
				String featureName = ((SetAttribute) permission).getFeature()
						.getId();
				String attributeName = ((SetAttribute) permission)
						.getAttribute().getName();
				String groupName = featureName + ": " + attributeName;

				Group configGroup = null;
				for (Group group : configGroups) {
					if (group.getText().equals(groupName)) {
						configGroup = group;
						break;
					}
				}
				if (configGroup == null) {
					configGroup = new Group(composite_config, SWT.NONE);
					configGroup.setText(groupName);
					configGroup.setLayout(new FillLayout(SWT.HORIZONTAL));
					configGroups.add(configGroup);
				}
				for (AttributeDecision attributeDec : ((SetAttribute) permission)
						.getAttributeDecisions()) {
					Button radioButton = new Button(configGroup, SWT.RADIO);
					if (attributeDec instanceof SelectDomainValue) {
						radioButton
								.setText("select " + attributeDec.getValue());
					} else if (attributeDec instanceof DeselectDomainValue) {
						radioButton.setText("deselect "
								+ attributeDec.getValue());
					}
				}

			}
		}

		// add listeners
		button_ok.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// check whether all decisions are completed
				String info = "Please finish the selection: ";
				String temp = "";
				boolean allSelection = true;
				for (Group group : configGroups) {
					boolean groupSelected = false;
					for (Control control : group.getChildren()) {
						if (control instanceof Button) {
							groupSelected = ((Button) control).getSelection()
									|| groupSelected;
						}
					}
					if (!groupSelected) {
						temp += group.getText() + ", ";
					}
					allSelection = groupSelected && allSelection;
				}
				if (!allSelection) {
					info += temp;
					MessageDialog.openInformation(getShell(), "Warning", info);
				} else {
					saveConfigLog(configGroups, selectedRole, selectedAction);
					dispose();
				}

			}
		});

		button_cancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
			}
		});
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Configuration");
		int length = configGroups.size() * 40 + 100;
		int width = 0;
		for (Group group : configGroups) {
			int tempLength = group.getChildren().length;
			if (width < tempLength) {
				width = tempLength;
			}
		}
		width = width * 140;
		setSize(width, length);
	}

	public void saveConfigLog(ArrayList<Group> configGroup, Role role,
			Action action) {
		Log log = (Log) WorkflowConfUtil.getAspectInstance(action,
				WorkflowConfUtil.LOG_ASPECT);
		for (Group group : configGroup) {
			for (Control control : group.getChildren()) {
				if (((Button) control).getSelection()) {
					if (((Button) control).getText().contains("")) {

					}
				}
			}
		}
		log.getPermissions();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
