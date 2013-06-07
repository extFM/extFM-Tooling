package org.js.model.workflow.ui;

import java.util.ArrayList;

import org.eclipse.jwt.meta.model.processes.Action;
import org.eclipse.jwt.meta.model.processes.Activity;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.GridData;
import org.js.model.workflow.State;
import org.js.model.workflow.StateEnum;
import org.js.model.workflow.util.WorkflowModelUtil;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class IdleUI extends Shell {

	protected Activity activity;
	protected State state;
	
	/**
	 * Launch the application.
	 * @param args
	 */
//	public static void main(String args[]) {
//		try {
//			Display display = Display.getDefault();
//			IdleUI shell = new IdleUI(display);
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
	public IdleUI(Display display, Activity tempActivity, State tempState) {
		super(display, SWT.TITLE);
		activity=tempActivity;
		state=tempState;
		
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setText("Do you want to terminate the configuration workflow?");
		
		Composite composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		composite_1.setLayout(new RowLayout(SWT.HORIZONTAL));
		
		Button btnOkButton = new Button(composite_1, SWT.NONE);
		btnOkButton.setText("Ok");
		Button btnCancelButton = new Button(composite_1, SWT.NONE);
		btnCancelButton.setText("Cancel");
		createContents();
		
		// add listners
		btnOkButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ArrayList<Action> actionList = WorkflowModelUtil
						.getActionList(activity);
				for (Action action : actionList) {
					WorkflowModelUtil.setActionState(action, StateEnum.COMPLETED);
				}
				state.setState(StateEnum.COMPLETED);
				dispose();
			}
		});
		btnCancelButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				state.setState(StateEnum.ENABLED);
				dispose();
			}
		});
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Termination");
		setSize(340, 101);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	public State getState(){
		return this.state;
	}
}
