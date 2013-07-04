/**
 */
package org.js.graph.transformation.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.js.graph.transformation.ActivityFinal;
import org.js.graph.transformation.AddEdges;
import org.js.graph.transformation.AddNodes;
import org.js.graph.transformation.ApplicationConditions;
import org.js.graph.transformation.ArrivingRole;
import org.js.graph.transformation.BelongsTo;
import org.js.graph.transformation.Condition;
import org.js.graph.transformation.Edge;
import org.js.graph.transformation.ExistingRole;
import org.js.graph.transformation.FlowFinal;
import org.js.graph.transformation.Fork;
import org.js.graph.transformation.GraphOperation;
import org.js.graph.transformation.GraphTransformation;
import org.js.graph.transformation.IdleAction;
import org.js.graph.transformation.InheritsFrom;
import org.js.graph.transformation.Initial;
import org.js.graph.transformation.LeftSide;
import org.js.graph.transformation.Nameable;
import org.js.graph.transformation.Node;
import org.js.graph.transformation.Operations;
import org.js.graph.transformation.RemoveEdges;
import org.js.graph.transformation.RemoveNodes;
import org.js.graph.transformation.Roles;
import org.js.graph.transformation.Rule;
import org.js.graph.transformation.SpecializationAction;
import org.js.graph.transformation.TransformationFactory;
import org.js.graph.transformation.TransformationPackage;
import org.js.graph.transformation.VariableRole;

import org.js.model.rbac.RbacPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TransformationPackageImpl extends EPackageImpl implements TransformationPackage {
	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass graphTransformationEClass = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass ruleEClass = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass leftSideEClass = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass rolesEClass = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass applicationConditionsEClass = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass operationsEClass = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass nodeEClass = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass edgeEClass = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass existingRoleEClass = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass arrivingRoleEClass = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass conditionEClass = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass graphOperationEClass = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass initialEClass = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass activityFinalEClass = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass flowFinalEClass = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass forkEClass = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass specializationActionEClass = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass idleActionEClass = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass variableRoleEClass = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass inheritsFromEClass = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass belongsToEClass = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass removeNodesEClass = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass removeEdgesEClass = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass addEdgesEClass = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass addNodesEClass = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass nameableEClass = null;

	/**
    * Creates an instance of the model <b>Package</b>, registered with
    * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
    * package URI value.
    * <p>Note: the correct way to create the package is via the static
    * factory method {@link #init init()}, which also performs
    * initialization of the package, or returns the registered package,
    * if one already exists.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @see org.eclipse.emf.ecore.EPackage.Registry
    * @see org.js.graph.transformation.TransformationPackage#eNS_URI
    * @see #init()
    * @generated
    */
	private TransformationPackageImpl() {
      super(eNS_URI, TransformationFactory.eINSTANCE);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private static boolean isInited = false;

	/**
    * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
    * 
    * <p>This method is used to initialize {@link TransformationPackage#eINSTANCE} when that field is accessed.
    * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @see #eNS_URI
    * @see #createPackageContents()
    * @see #initializePackageContents()
    * @generated
    */
	public static TransformationPackage init() {
      if (isInited) return (TransformationPackage)EPackage.Registry.INSTANCE.getEPackage(TransformationPackage.eNS_URI);

      // Obtain or create and register package
      TransformationPackageImpl theTransformationPackage = (TransformationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TransformationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TransformationPackageImpl());

      isInited = true;

      // Initialize simple dependencies
      RbacPackage.eINSTANCE.eClass();

      // Create package meta-data objects
      theTransformationPackage.createPackageContents();

      // Initialize created meta-data
      theTransformationPackage.initializePackageContents();

      // Mark meta-data to indicate it can't be changed
      theTransformationPackage.freeze();

  
      // Update the registry and return the package
      EPackage.Registry.INSTANCE.put(TransformationPackage.eNS_URI, theTransformationPackage);
      return theTransformationPackage;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getGraphTransformation() {
      return graphTransformationEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getGraphTransformation_Rules() {
      return (EReference)graphTransformationEClass.getEStructuralFeatures().get(0);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getRule() {
      return ruleEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getRule_Leftside() {
      return (EReference)ruleEClass.getEStructuralFeatures().get(0);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getRule_Roles() {
      return (EReference)ruleEClass.getEStructuralFeatures().get(1);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getRule_ApplicationConditions() {
      return (EReference)ruleEClass.getEStructuralFeatures().get(2);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getRule_Operations() {
      return (EReference)ruleEClass.getEStructuralFeatures().get(3);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getLeftSide() {
      return leftSideEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getLeftSide_Nodes() {
      return (EReference)leftSideEClass.getEStructuralFeatures().get(0);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getLeftSide_Edges() {
      return (EReference)leftSideEClass.getEStructuralFeatures().get(1);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getRoles() {
      return rolesEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getRoles_ExistingRoles() {
      return (EReference)rolesEClass.getEStructuralFeatures().get(0);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getRoles_ArrivingRole() {
      return (EReference)rolesEClass.getEStructuralFeatures().get(1);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getApplicationConditions() {
      return applicationConditionsEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getApplicationConditions_Conditions() {
      return (EReference)applicationConditionsEClass.getEStructuralFeatures().get(0);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getOperations() {
      return operationsEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getOperations_RemoveEdges() {
      return (EReference)operationsEClass.getEStructuralFeatures().get(0);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getOperations_RemoveNodes() {
      return (EReference)operationsEClass.getEStructuralFeatures().get(1);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getOperations_AddNodes() {
      return (EReference)operationsEClass.getEStructuralFeatures().get(2);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getOperations_AddEdges() {
      return (EReference)operationsEClass.getEStructuralFeatures().get(3);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getNode() {
      return nodeEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getNode_In() {
      return (EReference)nodeEClass.getEStructuralFeatures().get(0);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getNode_Out() {
      return (EReference)nodeEClass.getEStructuralFeatures().get(1);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getEdge() {
      return edgeEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getEdge_Source() {
      return (EReference)edgeEClass.getEStructuralFeatures().get(0);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getEdge_Target() {
      return (EReference)edgeEClass.getEStructuralFeatures().get(1);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getExistingRole() {
      return existingRoleEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getArrivingRole() {
      return arrivingRoleEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getCondition() {
      return conditionEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getGraphOperation() {
      return graphOperationEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getInitial() {
      return initialEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getActivityFinal() {
      return activityFinalEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getFlowFinal() {
      return flowFinalEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getFork() {
      return forkEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getSpecializationAction() {
      return specializationActionEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getSpecializationAction_VariableRole() {
      return (EReference)specializationActionEClass.getEStructuralFeatures().get(0);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getIdleAction() {
      return idleActionEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getVariableRole() {
      return variableRoleEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getVariableRole_Action() {
      return (EReference)variableRoleEClass.getEStructuralFeatures().get(0);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getInheritsFrom() {
      return inheritsFromEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getInheritsFrom_Parent() {
      return (EReference)inheritsFromEClass.getEStructuralFeatures().get(0);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getInheritsFrom_Child() {
      return (EReference)inheritsFromEClass.getEStructuralFeatures().get(1);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getBelongsTo() {
      return belongsToEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getBelongsTo_Leader() {
      return (EReference)belongsToEClass.getEStructuralFeatures().get(0);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getBelongsTo_Member() {
      return (EReference)belongsToEClass.getEStructuralFeatures().get(1);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getRemoveNodes() {
      return removeNodesEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getRemoveNodes_Node() {
      return (EReference)removeNodesEClass.getEStructuralFeatures().get(0);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getRemoveEdges() {
      return removeEdgesEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getRemoveEdges_Edge() {
      return (EReference)removeEdgesEClass.getEStructuralFeatures().get(0);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getAddEdges() {
      return addEdgesEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getAddEdges_Edge() {
      return (EReference)addEdgesEClass.getEStructuralFeatures().get(0);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getAddNodes() {
      return addNodesEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getAddNodes_Node() {
      return (EReference)addNodesEClass.getEStructuralFeatures().get(0);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getNameable() {
      return nameableEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EAttribute getNameable_Name() {
      return (EAttribute)nameableEClass.getEStructuralFeatures().get(0);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public TransformationFactory getTransformationFactory() {
      return (TransformationFactory)getEFactoryInstance();
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private boolean isCreated = false;

	/**
    * Creates the meta-model objects for the package.  This method is
    * guarded to have no affect on any invocation but its first.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public void createPackageContents() {
      if (isCreated) return;
      isCreated = true;

      // Create classes and their features
      graphTransformationEClass = createEClass(GRAPH_TRANSFORMATION);
      createEReference(graphTransformationEClass, GRAPH_TRANSFORMATION__RULES);

      ruleEClass = createEClass(RULE);
      createEReference(ruleEClass, RULE__LEFTSIDE);
      createEReference(ruleEClass, RULE__ROLES);
      createEReference(ruleEClass, RULE__APPLICATION_CONDITIONS);
      createEReference(ruleEClass, RULE__OPERATIONS);

      leftSideEClass = createEClass(LEFT_SIDE);
      createEReference(leftSideEClass, LEFT_SIDE__NODES);
      createEReference(leftSideEClass, LEFT_SIDE__EDGES);

      rolesEClass = createEClass(ROLES);
      createEReference(rolesEClass, ROLES__EXISTING_ROLES);
      createEReference(rolesEClass, ROLES__ARRIVING_ROLE);

      applicationConditionsEClass = createEClass(APPLICATION_CONDITIONS);
      createEReference(applicationConditionsEClass, APPLICATION_CONDITIONS__CONDITIONS);

      operationsEClass = createEClass(OPERATIONS);
      createEReference(operationsEClass, OPERATIONS__REMOVE_EDGES);
      createEReference(operationsEClass, OPERATIONS__REMOVE_NODES);
      createEReference(operationsEClass, OPERATIONS__ADD_NODES);
      createEReference(operationsEClass, OPERATIONS__ADD_EDGES);

      nodeEClass = createEClass(NODE);
      createEReference(nodeEClass, NODE__IN);
      createEReference(nodeEClass, NODE__OUT);

      edgeEClass = createEClass(EDGE);
      createEReference(edgeEClass, EDGE__SOURCE);
      createEReference(edgeEClass, EDGE__TARGET);

      existingRoleEClass = createEClass(EXISTING_ROLE);

      arrivingRoleEClass = createEClass(ARRIVING_ROLE);

      conditionEClass = createEClass(CONDITION);

      graphOperationEClass = createEClass(GRAPH_OPERATION);

      initialEClass = createEClass(INITIAL);

      activityFinalEClass = createEClass(ACTIVITY_FINAL);

      flowFinalEClass = createEClass(FLOW_FINAL);

      forkEClass = createEClass(FORK);

      specializationActionEClass = createEClass(SPECIALIZATION_ACTION);
      createEReference(specializationActionEClass, SPECIALIZATION_ACTION__VARIABLE_ROLE);

      idleActionEClass = createEClass(IDLE_ACTION);

      variableRoleEClass = createEClass(VARIABLE_ROLE);
      createEReference(variableRoleEClass, VARIABLE_ROLE__ACTION);

      inheritsFromEClass = createEClass(INHERITS_FROM);
      createEReference(inheritsFromEClass, INHERITS_FROM__PARENT);
      createEReference(inheritsFromEClass, INHERITS_FROM__CHILD);

      belongsToEClass = createEClass(BELONGS_TO);
      createEReference(belongsToEClass, BELONGS_TO__LEADER);
      createEReference(belongsToEClass, BELONGS_TO__MEMBER);

      removeNodesEClass = createEClass(REMOVE_NODES);
      createEReference(removeNodesEClass, REMOVE_NODES__NODE);

      removeEdgesEClass = createEClass(REMOVE_EDGES);
      createEReference(removeEdgesEClass, REMOVE_EDGES__EDGE);

      addEdgesEClass = createEClass(ADD_EDGES);
      createEReference(addEdgesEClass, ADD_EDGES__EDGE);

      addNodesEClass = createEClass(ADD_NODES);
      createEReference(addNodesEClass, ADD_NODES__NODE);

      nameableEClass = createEClass(NAMEABLE);
      createEAttribute(nameableEClass, NAMEABLE__NAME);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private boolean isInitialized = false;

	/**
    * Complete the initialization of the package and its meta-model.  This
    * method is guarded to have no affect on any invocation but its first.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public void initializePackageContents() {
      if (isInitialized) return;
      isInitialized = true;

      // Initialize package
      setName(eNAME);
      setNsPrefix(eNS_PREFIX);
      setNsURI(eNS_URI);

      // Obtain other dependent packages
      RbacPackage theRbacPackage = (RbacPackage)EPackage.Registry.INSTANCE.getEPackage(RbacPackage.eNS_URI);

      // Create type parameters

      // Set bounds for type parameters

      // Add supertypes to classes
      ruleEClass.getESuperTypes().add(this.getNameable());
      nodeEClass.getESuperTypes().add(this.getNameable());
      edgeEClass.getESuperTypes().add(this.getNameable());
      existingRoleEClass.getESuperTypes().add(this.getVariableRole());
      arrivingRoleEClass.getESuperTypes().add(this.getVariableRole());
      conditionEClass.getESuperTypes().add(this.getNameable());
      graphOperationEClass.getESuperTypes().add(this.getNameable());
      initialEClass.getESuperTypes().add(this.getNode());
      activityFinalEClass.getESuperTypes().add(this.getNode());
      flowFinalEClass.getESuperTypes().add(this.getNode());
      forkEClass.getESuperTypes().add(this.getNode());
      specializationActionEClass.getESuperTypes().add(this.getNode());
      idleActionEClass.getESuperTypes().add(this.getNode());
      variableRoleEClass.getESuperTypes().add(this.getNameable());
      inheritsFromEClass.getESuperTypes().add(this.getCondition());
      belongsToEClass.getESuperTypes().add(this.getCondition());
      removeNodesEClass.getESuperTypes().add(this.getGraphOperation());
      removeEdgesEClass.getESuperTypes().add(this.getGraphOperation());
      addEdgesEClass.getESuperTypes().add(this.getGraphOperation());
      addNodesEClass.getESuperTypes().add(this.getGraphOperation());

      // Initialize classes, features, and operations; add parameters
      initEClass(graphTransformationEClass, GraphTransformation.class, "GraphTransformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getGraphTransformation_Rules(), this.getRule(), null, "rules", null, 0, -1, GraphTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(ruleEClass, Rule.class, "Rule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getRule_Leftside(), this.getLeftSide(), null, "leftside", null, 1, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getRule_Roles(), this.getRoles(), null, "roles", null, 1, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getRule_ApplicationConditions(), this.getApplicationConditions(), null, "applicationConditions", null, 1, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getRule_Operations(), this.getOperations(), null, "operations", null, 1, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(leftSideEClass, LeftSide.class, "LeftSide", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getLeftSide_Nodes(), this.getNode(), null, "nodes", null, 0, -1, LeftSide.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getLeftSide_Edges(), this.getEdge(), null, "edges", null, 0, -1, LeftSide.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(rolesEClass, Roles.class, "Roles", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getRoles_ExistingRoles(), this.getExistingRole(), null, "existingRoles", null, 0, -1, Roles.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getRoles_ArrivingRole(), this.getArrivingRole(), null, "arrivingRole", null, 1, 1, Roles.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(applicationConditionsEClass, ApplicationConditions.class, "ApplicationConditions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getApplicationConditions_Conditions(), this.getCondition(), null, "conditions", null, 0, -1, ApplicationConditions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(operationsEClass, Operations.class, "Operations", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getOperations_RemoveEdges(), this.getRemoveEdges(), null, "removeEdges", null, 1, 1, Operations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getOperations_RemoveNodes(), this.getRemoveNodes(), null, "removeNodes", null, 1, 1, Operations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getOperations_AddNodes(), this.getAddNodes(), null, "addNodes", null, 1, 1, Operations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getOperations_AddEdges(), this.getAddEdges(), null, "addEdges", null, 1, 1, Operations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(nodeEClass, Node.class, "Node", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getNode_In(), this.getEdge(), this.getEdge_Target(), "in", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getNode_Out(), this.getEdge(), this.getEdge_Source(), "out", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(edgeEClass, Edge.class, "Edge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getEdge_Source(), this.getNode(), this.getNode_Out(), "source", null, 1, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getEdge_Target(), this.getNode(), this.getNode_In(), "target", null, 1, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(existingRoleEClass, ExistingRole.class, "ExistingRole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

      initEClass(arrivingRoleEClass, ArrivingRole.class, "ArrivingRole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

      initEClass(conditionEClass, Condition.class, "Condition", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

      initEClass(graphOperationEClass, GraphOperation.class, "GraphOperation", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

      initEClass(initialEClass, Initial.class, "Initial", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

      initEClass(activityFinalEClass, ActivityFinal.class, "ActivityFinal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

      initEClass(flowFinalEClass, FlowFinal.class, "FlowFinal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

      initEClass(forkEClass, Fork.class, "Fork", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

      initEClass(specializationActionEClass, SpecializationAction.class, "SpecializationAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getSpecializationAction_VariableRole(), this.getVariableRole(), this.getVariableRole_Action(), "variableRole", null, 1, 1, SpecializationAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(idleActionEClass, IdleAction.class, "IdleAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

      initEClass(variableRoleEClass, VariableRole.class, "VariableRole", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getVariableRole_Action(), this.getSpecializationAction(), this.getSpecializationAction_VariableRole(), "action", null, 1, 1, VariableRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(inheritsFromEClass, InheritsFrom.class, "InheritsFrom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getInheritsFrom_Parent(), theRbacPackage.getRole(), null, "parent", null, 1, 1, InheritsFrom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getInheritsFrom_Child(), this.getVariableRole(), null, "child", null, 1, 1, InheritsFrom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(belongsToEClass, BelongsTo.class, "BelongsTo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getBelongsTo_Leader(), this.getVariableRole(), null, "leader", null, 1, 1, BelongsTo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getBelongsTo_Member(), this.getVariableRole(), null, "member", null, 1, 1, BelongsTo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(removeNodesEClass, RemoveNodes.class, "RemoveNodes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getRemoveNodes_Node(), this.getNode(), null, "node", null, 0, -1, RemoveNodes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(removeEdgesEClass, RemoveEdges.class, "RemoveEdges", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getRemoveEdges_Edge(), this.getEdge(), null, "edge", null, 0, -1, RemoveEdges.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(addEdgesEClass, AddEdges.class, "AddEdges", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getAddEdges_Edge(), this.getEdge(), null, "edge", null, 0, -1, AddEdges.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(addNodesEClass, AddNodes.class, "AddNodes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getAddNodes_Node(), this.getNode(), null, "node", null, 0, -1, AddNodes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(nameableEClass, Nameable.class, "Nameable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getNameable_Name(), ecorePackage.getEString(), "name", "", 0, 1, Nameable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      // Create resource
      createResource(eNS_URI);
   }

} //TransformationPackageImpl
