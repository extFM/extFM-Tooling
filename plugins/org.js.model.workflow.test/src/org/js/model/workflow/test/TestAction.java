package org.js.model.workflow.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jwt.meta.model.organisations.Role;
import org.eclipse.jwt.meta.model.processes.Action;
import org.eclipse.jwt.meta.model.processes.ActivityEdge;
import org.eclipse.jwt.meta.model.processes.ActivityNode;
import org.eclipse.jwt.meta.model.processes.FinalNode;
import org.eclipse.jwt.meta.model.processes.InitialNode;
import org.eclipse.jwt.we.conf.model.Aspect;
import org.eclipse.jwt.we.conf.model.AspectInstance;
import org.eclipse.jwt.we.conf.model.aspects.AspectManager;
import org.eclipse.jwt.we.model.view.LayoutData;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.RBACService;
import org.js.model.rbac.impl.RbacFactoryImpl;
import org.js.model.workflow.ACMConnector;
import org.js.model.workflow.Log;
import org.js.model.workflow.RoleConnector;
import org.js.model.workflow.State;
import org.js.model.workflow.StateEnum;
import org.js.model.workflow.actions.ImportModelAction;
import org.js.model.workflow.actions.MyAction;
import org.js.model.workflow.util.ChangePrimitive;
import org.js.model.workflow.util.WorkflowConfUtil;
import org.js.model.workflow.util.WorkflowModelUtil;
import org.js.model.workflow.util.WorkflowViewUtil;

public class TestAction extends MyAction {

	String testrole1 = "role1";
	String testrole2 = "role2";
	String testaction1 = "action1";
	String testaction2 = "action2";
	String testevent = "event1";
	String testInitial = "initialNode";
	String testFinal = "finalNode";

	public TestAction() {
	}

	@Override
	public ImageDescriptor getImage() {
		return null;
	}

	@Override
	public void run() {

		initialRes();
		// clean();
//		 addWorkflowELement();
//		 testWorkflowElement();
		 testConfElement();
//		testChangePrimitive();
//		 initial();
		// simpleInitial();
//		 complexInitial();
//		 test();
		save();
		refresh();
		//
		// printAll();
	}

	public void test() {
//		System.out.println(AspectManager.INSTANCE
//				.getActivatedProfiles(workflowModel));
//		
		InitialNode root = processFactory.createInitialNode();
		Action action = processFactory.createAction();
		FinalNode finalNode = processFactory.createFinalNode();
		ActivityEdge actEdge1 =processFactory.createActivityEdge();
		actEdge1.setSource(root);
		actEdge1.setTarget(action);
		ActivityEdge actEdge2 =processFactory.createActivityEdge();
		actEdge2.setSource(action);
		actEdge2.setTarget(finalNode);
	}

	public void complexInitial() {

	}

	public void simpleInitial() {
	}

	/**
	 * initial the workflow.
	 */
	public void initial() {
		// InitialNode iniNode = addInitialNode(100, 200);
		// Action action1 = addAction(activity, diagram, null, 200, 200);
		// addEdge(iniNode, action1);
		// ForkNode forkNode1 = addForkNode(300, 200);
		// addEdge(action1, forkNode1);
		// Action action2 = WorkflowModelUtil.addAction(activity, testaction1);
		// addEdge(forkNode1, action2);
		// Action action3 = WorkflowModelUtil.addAction(400, 400, null);
		// addEdge(forkNode1, action3);
		// addRole(null, 200, 50, action2, null);
		// addRole(null, 400, 50, action3, null);
		// Action action4 = WorkflowModelUtil.addAction(500, 200, null);
		// Action action5 = WorkflowModelUtil.addAction(500, 400, null);
		// addEdge(action2, action4);
		// addEdge(action3, action5);
		// JoinNode joinNode1 = addJoinNode(600, 200);
		// addEdge(action4, joinNode1);
		// addEdge(action5, joinNode1);
		// Event event1 = addEvent(700, 200, null);
		// addEdge(joinNode1, event1);
		// FinalNode finalNode = addFinalNode(800, 200);
		// addEdge(event1, finalNode);
	}

	/**
	 * add the element and related layout data
	 */
	public void addWorkflowELement() {
		 ActivityNode tempAct=null;
		 // add action
		 WorkflowModelUtil.addAction(activity, testaction1);
		 tempAct= WorkflowModelUtil.getActivityNode(activity, testaction1);
		 WorkflowViewUtil.setNodeLayout(diagram, tempAct, 100, 100);
		 WorkflowModelUtil.addAction(activity, testaction2);
		 tempAct= WorkflowModelUtil.getActivityNode(activity, testaction2);
		 WorkflowViewUtil.setNodeLayout(diagram, tempAct, 200, 200);
		 // add event
		 WorkflowModelUtil.addEvent(activity, testevent);
		 tempAct= WorkflowModelUtil.getActivityNode(activity, testevent);
		 WorkflowViewUtil.setNodeLayout(diagram, tempAct, 200, 200);
		 // add initial node
//		 WorkflowModelUtil.addInitialNode(activity);
//		 tempAct= WorkflowModelUtil.getActivityNode(activity,
//		 WorkflowModelUtil.INITIAL_NODE_NAME);
//		 WorkflowViewUtil.setNodeLayout(diagram, tempAct, 200, 200);
//		 // add final node
//		 WorkflowModelUtil.addFinalNode(activity);
//		 tempAct= WorkflowModelUtil.getActivityNode(activity,
//		 WorkflowModelUtil.FINAL_NODE_NAME);
//		 WorkflowViewUtil.setNodeLayout(diagram, tempAct, 200, 200);
		 // add join node
		 tempAct=WorkflowModelUtil.addJoinNode(activity);
		 WorkflowViewUtil.setNodeLayout(diagram, tempAct, 200, 200);
		 // add fork node
		 tempAct=WorkflowModelUtil.addForkNode(activity);
		 WorkflowViewUtil.setNodeLayout(diagram, tempAct, 200, 200);
		 // add edge between action 1 and event1
		 WorkflowModelUtil.addEdge(activity,
		 WorkflowModelUtil.getActivityNode(activity, testaction1),
		 WorkflowModelUtil.getActivityNode(activity, testevent));
		 // add role
		 WorkflowModelUtil.addRole(workflowModel, testrole1);
		 WorkflowViewUtil.setRoleLayout(diagram, activity,
		 WorkflowModelUtil.getRole(workflowModel, testrole1), 50, 50);
		 // add reference edge between role and action
//		 WorkflowViewUtil.setReferenceEdge(diagram, activity,
//		 (Action) WorkflowModelUtil.getActivityNode(activity, testaction1),
//		 WorkflowModelUtil.getRole(workflowModel, testrole1));
//		 WorkflowViewUtil.setReferenceEdge(diagram, activity,
//		 (Action) WorkflowModelUtil.getActivityNode(activity, testaction2),
//		 WorkflowModelUtil.getRole(workflowModel, testrole1));
	}

	/**
	 * 1. if we do not add layout data for workflow element, jwt will
	 * automatically create a layout data for the element.
	 * 
	 * 2 if we need to delete a workflow element, first remove element, then
	 * layout. Because jwt editor will automatically generate layout data if
	 * element is not removed
	 */
	public void testWorkflowElement() {
		ActivityNode aciNode = null;

		// add action
		WorkflowModelUtil.addAction(activity, testaction1);
		aciNode = WorkflowModelUtil.getActivityNode(activity, testaction1);
		WorkflowViewUtil.setNodeLayout(diagram, aciNode, 100, 100);
		WorkflowModelUtil.addAction(activity, testaction2);
		aciNode = WorkflowModelUtil.getActivityNode(activity, testaction2);
		WorkflowViewUtil.setNodeLayout(diagram, aciNode, 200, 200);

		// remove action
		aciNode = WorkflowModelUtil.removeActivityNode(activity, testaction1);
		WorkflowViewUtil.removeNodeLayout(diagram, aciNode);
		aciNode = WorkflowModelUtil.removeActivityNode(activity, testaction2);
		WorkflowViewUtil.removeNodeLayout(diagram, aciNode);

		// add event
		WorkflowModelUtil.addEvent(activity, testevent);
		aciNode = WorkflowModelUtil.getActivityNode(activity, testevent);
		WorkflowViewUtil.setNodeLayout(diagram, aciNode, 200, 200);

		// remove event
		WorkflowModelUtil.addEvent(activity, testevent);
		aciNode = WorkflowModelUtil.removeActivityNode(activity, testevent);
		WorkflowViewUtil.removeNodeLayout(diagram, aciNode);

		// add initial node
		WorkflowModelUtil.addInitialNode(activity, "initial");
		aciNode = WorkflowModelUtil.getActivityNode(activity, "initial");
		WorkflowViewUtil.setNodeLayout(diagram, aciNode, 200, 200);

		// remove initial node
		WorkflowModelUtil.addInitialNode(activity, "initial");
		aciNode = WorkflowModelUtil.removeActivityNode(activity, "initial");
		WorkflowViewUtil.removeNodeLayout(diagram, aciNode);

		// add final node
		WorkflowModelUtil.addFinalNode(activity, "final");
		aciNode = WorkflowModelUtil.getActivityNode(activity, "final");
		WorkflowViewUtil.setNodeLayout(diagram, aciNode, 200, 200);

		// remove final node
		WorkflowModelUtil.addFinalNode(activity, "final");
		aciNode = WorkflowModelUtil.removeActivityNode(activity, "final");
		WorkflowViewUtil.removeNodeLayout(diagram, aciNode);

		// TODO: remove join/fork node
		// add join node
		aciNode = WorkflowModelUtil.addJoinNode(activity);
		WorkflowViewUtil.setNodeLayout(diagram, aciNode, 200, 200);
		// add fork node
		aciNode = WorkflowModelUtil.addForkNode(activity);
		WorkflowViewUtil.setNodeLayout(diagram, aciNode, 200, 200);

		// add edge between action 1 and event1
		WorkflowModelUtil.addAction(activity, testaction1);
		WorkflowModelUtil.addEvent(activity, testevent);
		WorkflowModelUtil.addEdge(activity,
				WorkflowModelUtil.getActivityNode(activity, testaction1),
				WorkflowModelUtil.getActivityNode(activity, testevent));

		// remove edge
		WorkflowModelUtil.removeEdge(activity,
				WorkflowModelUtil.getActivityNode(activity, testaction1),
				WorkflowModelUtil.getActivityNode(activity, testevent));
		aciNode = WorkflowModelUtil.removeActivityNode(activity, testaction1);
		WorkflowViewUtil.removeNodeLayout(diagram, aciNode);
		aciNode = WorkflowModelUtil.removeActivityNode(activity, testevent);
		WorkflowViewUtil.removeNodeLayout(diagram, aciNode);

		// add role
		WorkflowModelUtil.addRole(workflowModel, testrole1);
		WorkflowModelUtil.addRole(workflowModel, testrole2);
		WorkflowViewUtil.setRoleLayout(diagram, activity,
				WorkflowModelUtil.getRole(workflowModel, testrole1), 50, 50);
		WorkflowViewUtil.setRoleLayout(diagram, activity,
				WorkflowModelUtil.getRole(workflowModel, testrole2), 100, 100);

		// remove role
		WorkflowViewUtil.removeRoleLayout(diagram,
				WorkflowModelUtil.getRole(workflowModel, testrole1));
		WorkflowViewUtil.removeRoleLayout(diagram,
				WorkflowModelUtil.getRole(workflowModel, testrole2));
		WorkflowModelUtil.removeRole(workflowModel, testrole1);
		WorkflowModelUtil.removeRole(workflowModel, testrole2);

		// add reference edge between role and action
		WorkflowModelUtil.addAction(activity, testaction1);
		WorkflowModelUtil.addRole(workflowModel, testrole1);
		WorkflowModelUtil.addAction(activity, testaction2);
		WorkflowModelUtil.addRole(workflowModel, testrole2);
		WorkflowViewUtil.setRoleLayout(diagram, activity,
				WorkflowModelUtil.getRole(workflowModel, testrole1), 50, 50);
		WorkflowViewUtil.setRoleLayout(diagram, activity,
				WorkflowModelUtil.getRole(workflowModel, testrole2), 100, 100);
		WorkflowViewUtil.setReferenceEdge(diagram, activity,
				WorkflowModelUtil.getRole(workflowModel, testrole1),
				(Action) WorkflowModelUtil.getActivityNode(activity, testaction1));
		WorkflowViewUtil.setReferenceEdge(diagram, activity,
				WorkflowModelUtil.getRole(workflowModel, testrole1),
				(Action) WorkflowModelUtil.getActivityNode(activity, testaction2));

		// remove role reference edge
		WorkflowViewUtil.removeReferenceEdge(diagram,
				WorkflowModelUtil.getRole(workflowModel, testrole1),
				(Action) WorkflowModelUtil.getActivityNode(activity, testaction1));
		WorkflowViewUtil.removeReferenceEdge(diagram,
				WorkflowModelUtil.getRole(workflowModel, testrole1),
				(Action) WorkflowModelUtil.getActivityNode(activity, testaction2));
	}

	public void testConfElement() {
		// initial
		ActivityNode aciNode = null;
		Role tempRole = null;
		RBACService rbacService = new RBACService();

		// load the rbac model
		AccessControlModel acm = loadRbacModel();

		// add action
		WorkflowModelUtil.addAction(activity, testaction1);
		aciNode = WorkflowModelUtil.getActivityNode(activity, testaction1);
		WorkflowViewUtil.setNodeLayout(diagram, aciNode, 100, 100);

		// add role
		WorkflowModelUtil.addRole(workflowModel, testrole1);
		WorkflowViewUtil.setRoleLayout(diagram, activity,
				WorkflowModelUtil.getRole(workflowModel, testrole1), 200, 200);

		// add role aspect
		tempRole = WorkflowModelUtil.getRole(workflowModel, testrole1);
		WorkflowConfUtil.addAspectInstance(tempRole,
				WorkflowConfUtil.ROLE_ASPECT);
		RoleConnector roleConnector = (RoleConnector) WorkflowConfUtil
				.getAspectInstance(tempRole, WorkflowConfUtil.ROLE_ASPECT);
		org.js.model.rbac.Role result = RbacFactoryImpl.eINSTANCE.createRole();
		result.setId(testrole1);
		result.setName(testrole1);
		acm.getRoles().add(result);
		try {
			acm.eResource().save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		WorkflowConfUtil.setRoleRef(roleConnector, result);

		// remove role aspect
//		tempRole = WorkflowModelUtil.getRole(workflowModel, testrole1);
//		WorkflowConfUtil.removeAspectInstance(tempRole,
//				WorkflowConfUtil.ROLE_ASPECT);

		// add log aspect
		aciNode = WorkflowModelUtil.getActivityNode(activity, testaction1);
		WorkflowConfUtil
				.addAspectInstance(aciNode, WorkflowConfUtil.LOG_ASPECT);
		Log log = (Log) WorkflowConfUtil.getAspectInstance(aciNode,
				WorkflowConfUtil.LOG_ASPECT);
		WorkflowConfUtil.addPermission(log,
				rbacService.getAllModelPermissions(acm).get(0));

		// remove log aspect
//		aciNode = WorkflowModelUtil.getActivityNode(activity, testaction1);
//		WorkflowConfUtil.removeAspectInstance(aciNode,
//				WorkflowConfUtil.LOG_ASPECT);

		// add state aspect
		aciNode = WorkflowModelUtil.getActivityNode(activity, testaction1);
		WorkflowConfUtil.addAspectInstance(aciNode,
				WorkflowConfUtil.STATE_ASPECT);
		State state = (State) WorkflowConfUtil.getAspectInstance(aciNode,
				WorkflowConfUtil.STATE_ASPECT);
		WorkflowConfUtil.setState(state, StateEnum.RUNNING);

		// remove state aspect
		aciNode = WorkflowModelUtil.getActivityNode(activity, testaction1);
//		WorkflowConfUtil.removeAspectInstance(aciNode,
//				WorkflowConfUtil.STATE_ASPECT);
		WorkflowConfUtil.removeAspectInstances(aciNode);
		
		// remove role
		// WorkflowViewUtil.removeRoleLayout(diagram,
		// WorkflowModelUtil.getRole(workflowModel, testrole1));
		// WorkflowModelUtil.removeRole(workflowModel, testrole1);
	}

	public void testChangePrimitive() {
		// load a rbac model
		AccessControlModel acm = loadRbacModel();

		InitialNode initialNode = ChangePrimitive.addInitialNode(activity,
				diagram, testInitial, 100, 100);
		ChangePrimitive.addRole(workflowModel, activity, diagram,
				acm.getRoles().get(0), testrole1, 100, 200);
		ChangePrimitive.addEdge(activity, initialNode,
				WorkflowModelUtil.getActivityNode(activity, testrole1));
//		
//		 GraphOperation.removeRole(workflowModel, activity, diagram,
//		 testrole1);
//		 GraphOperation.removeEdge(activity, source, target);
//		 GraphOperation.addFinalNode(activity, diagram, testFinal, 50, 100);
//		GraphOperation
//				.addFinalFlowNode(activity, diagram, testFinal, 100, 100);
//		GraphOperation.addForkNode(activity, diagram, 150, 100);
//		GraphOperation.addJoinNode(activity, diagram, 200, 100);
	}

	public void testSimpleInitial() {
		// Action action = processFactory.createAction();
		// action.setName("action1");
		// activity.getNodes().add(action);
		// test add layout

		// InitialNode iniNode = addInitialNode(100, 200);
		// Action action1 = addAction(activity, diagram, "task1", 200, 200);
		// addEdge(iniNode, action1);
		// Action action2 = addAction(300, 200, null);
		// addEdge(action1, action2);
		// FinalNode finalNode = addFinalNode(400, 200);
		// addEdge(action2, finalNode);

		// addRole(null, 200, 50, action1, "provider1");
		// addRole(null, 300, 50, action2, "provider2");
	}

	/**
	 * save the workflow.
	 */
	public void save() {
		Map<String, String> options = new HashMap<String, String>();
		options.put(XMLResource.OPTION_ENCODING, "UTF-8");
		try {
			workflowModel.eResource().save(options);
			// workflowModel.eResource().save(null);
			diagram.eResource().save(options);
			// confModel.eResource().save(options);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void testConf() {
		// Action action = addAction(100, 200, "test");
		// Role role = addRole(null,100, 100, action, "test");

		// System.out.println(activity.getNodes().get(0));

		// EObject eob
		// =EcoreUtil.create(confModel.getProfiles().get(0).getAspects().get(0).getAspectInstanceEType().get);

		/**
		 * this is the code for generating class instance of conf model
		 */

		// System.out.println(confModel.getProfiles().get(0).getAspects().get(0)
		// .getAspectInstanceEType().getEPackage());
		// EPackage epack = confModel.getProfiles().get(0).getAspects().get(0)
		// .getAspectInstanceEType().getEPackage();
		// String name = confModel.getProfiles().get(0).getAspects().get(0)
		// .getAspectInstanceEType().getInstanceClassName();
		// System.out.println(name);
		// SampleStaticAspect ssa = (SampleStaticAspect) EcoreUtil
		// .create(toEClass(name));
		// System.out.println(EcoreUtil.create(toEClass(name)));
		// ((SampleStaticAspect) confModel.getAspectInstances().get(0))
		// .setSampleactionref((Action) activity.getNodes().get(1));
		// workflowEditor.getEmfEditingDomain().loadResource(
		// confModel.eResource().getURI().path());

		AspectInstance aspectIns = AspectManager.INSTANCE.getAspectInstance(
				activity.getNodes().get(0), confModel.getProfiles().get(0)
						.getAspects().get(0));
		// AspectManager.INSTANCE.
		System.out.println("config: "
				+ AspectManager.INSTANCE.getConfModel(activity.getNodes()
						.get(0)));
		System.out.println("orig: " + confModel);

		System.out.println("confmodel: " + aspectIns);
		// System.out.println("orig: "+confModel.getAspectInstances().get(0));
		// System.out.println(AspectManager.INSTANCE.getAspectInstances(activity.getNodes().get(0)));

		EObject modelEle = activity.getNodes().get(0);

		Aspect aspect = AspectManager.INSTANCE.getAspect(modelEle,
				"jwt.conf.extension.logaspect");
		System.out.println(aspect);
		AspectInstance ai = AspectManager.INSTANCE.createAndAddAspectInstance(
				aspect, activity.getNodes().get(0));
		System.out.println(ai);
		// AspectManager.INSTANCE.getAspectInstances(activity.getNodes().get(0)).get(0);
		// ai.setSampleintprop(3);
		// ai.setSampleactionref((Action)modelEle);
		// AspectManager.INSTANCE.getConfModel(activity.getNodes().get(0));
		// ConfModelResourceManager.INSTANCE.
		// EClass targetEClass = (EClass) epack.getEClassifier(name);
		// System.out.println(targetEClass);
		// EcoreUtil.create(targetEClass);
		// System.out.println(toEClass("staticaspect:SampleStaticAspect"));

		// Iterator it = confModel.eAllContents();
		// AspectInstance aspectIns = null;
		// while (it.hasNext()) {
		// EObject object = (EObject) it.next();
		// if (object instanceof AspectInstance) {
		// aspectIns = (AspectInstance) object;
		// System.out.println("aspectIns: "+aspectIns);
		// System.out.println("getTargetModelElement: "+aspectIns.getTargetModelElement());
		// }
		// }
		// System.out.println("confModel.getProfiles(): "+confModel.getProfiles());
		// System.out.println(confModel.getProfiles().get(0).getAspects());
		// System.out.println(confModel.getProfiles().get(0).getAspects().get(0).getTargetModelElements());
		// System.out.println(confModel.getAspectInstances().get(2).getTargetModelElement());
		// System.out.println(confModel.getAspectInstances().get(1).getTargetModelElement());
		// EStructuralFeature
		// eref=aspectIns.getTargetModelElement().eContainingFeature();
		// System.out.println(aspectIns);
		// System.out.println(workflowModel);
		// System.out.println(workflowModel.getNodes().indexOf(confModel.getAspectInstances().get(0).getTargetModelElement()));
	}

	/**
	 * 
	 * @param modelElementEType
	 * @return
	 */
	public EClass toEClass(String modelElementEType) {
		int packageEndIndex = Math.max(modelElementEType.lastIndexOf('.'),
				modelElementEType.lastIndexOf('/'));
		String targetEPackageName = modelElementEType.substring(0,
				packageEndIndex);
		String targetEClassName = modelElementEType
				.substring(packageEndIndex + 1);
		EPackage targetEPackage = Registry.INSTANCE
				.getEPackage(targetEPackageName);
		if (targetEPackage == null) {
			return null;
		}
		EClass targetEClass = (EClass) targetEPackage
				.getEClassifier(targetEClassName);
		if (targetEClass == null) {
			return null;
		}
		return targetEClass;
	}

	public void printAll() {
		System.out.println(workflowModel.getElements());
		Iterator<LayoutData> it = diagram.getLayoutData().iterator();
		while (it.hasNext()) {
			LayoutData layoutdata = (LayoutData) it.next();
			// System.out.println(layoutdata.getDescribesElement());
			// System.out.println(((Reference)layoutdata.getDescribesElement()).getContainedIn());
			// System.out.println(((Reference)layoutdata.getDescribesElement()).getReference());
		}
		// System.out.println(workflowModel.getEdges());
		// System.out.println(viewModel.getLayoutData());
		// System.out.println(viewModel.getReferenceEdges());
		// System.out.println(viewModel.getReferences());
		// System.out.println(confModel.getAspectInstances());
		// System.out.println(confModel.getEnrichedModel());
		// System.out.println(((Profile) confModel.eContents().get(0))
		// .getAspects().get(0).getAspectInstanceEType());
	}

	public AccessControlModel loadRbacModel() {
		ImportModelAction ima = new ImportModelAction();
		ima.run();

		ACMConnector acmconnector = (ACMConnector) WorkflowConfUtil
				.getAspectInstance(workflowModel, WorkflowConfUtil.ACM_ASPECT);
		return (AccessControlModel) acmconnector.getAcmref();
	}

	// TODO: set the layout for the workflow after changes
	public void layout() {

	}

}
