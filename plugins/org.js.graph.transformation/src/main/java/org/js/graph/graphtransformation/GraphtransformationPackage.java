/**
 */
package org.js.graph.graphtransformation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.js.graph.graphtransformation.GraphtransformationFactory
 * @model kind="package"
 * @generated
 */
public interface GraphtransformationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "graphtransformation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://graphtransformation/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "graphtransformation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GraphtransformationPackage eINSTANCE = org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.js.graph.graphtransformation.impl.GraphTransformationImpl <em>Graph Transformation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.graphtransformation.impl.GraphTransformationImpl
	 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getGraphTransformation()
	 * @generated
	 */
	int GRAPH_TRANSFORMATION = 0;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_TRANSFORMATION__RULES = 0;

	/**
	 * The number of structural features of the '<em>Graph Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_TRANSFORMATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.js.graph.graphtransformation.Nameable <em>Nameable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.graphtransformation.Nameable
	 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getNameable()
	 * @generated
	 */
	int NAMEABLE = 26;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMEABLE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Nameable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMEABLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.js.graph.graphtransformation.impl.RuleImpl <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.graphtransformation.impl.RuleImpl
	 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getRule()
	 * @generated
	 */
	int RULE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__NAME = NAMEABLE__NAME;

	/**
	 * The feature id for the '<em><b>Leftside</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__LEFTSIDE = NAMEABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__ROLES = NAMEABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Application Conditions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__APPLICATION_CONDITIONS = NAMEABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__OPERATIONS = NAMEABLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FEATURE_COUNT = NAMEABLE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.js.graph.graphtransformation.impl.LeftSideImpl <em>Left Side</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.graphtransformation.impl.LeftSideImpl
	 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getLeftSide()
	 * @generated
	 */
	int LEFT_SIDE = 2;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEFT_SIDE__NODES = 0;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEFT_SIDE__EDGES = 1;

	/**
	 * The number of structural features of the '<em>Left Side</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEFT_SIDE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.js.graph.graphtransformation.Condition <em>Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.graphtransformation.Condition
	 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getCondition()
	 * @generated
	 */
	int CONDITION = 10;

	/**
	 * The meta object id for the '{@link org.js.graph.graphtransformation.impl.InheritsFromImpl <em>Inherits From</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.graphtransformation.impl.InheritsFromImpl
	 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getInheritsFrom()
	 * @generated
	 */
	int INHERITS_FROM = 20;

	/**
	 * The meta object id for the '{@link org.js.graph.graphtransformation.impl.BelongsToImpl <em>Belongs To</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.graphtransformation.impl.BelongsToImpl
	 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getBelongsTo()
	 * @generated
	 */
	int BELONGS_TO = 21;

	/**
	 * The meta object id for the '{@link org.js.graph.graphtransformation.impl.OperationsImpl <em>Operations</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.graphtransformation.impl.OperationsImpl
	 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getOperations()
	 * @generated
	 */
	int OPERATIONS = 5;

	/**
	 * The meta object id for the '{@link org.js.graph.graphtransformation.impl.ActivityEdgeImpl <em>Activity Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.graphtransformation.impl.ActivityEdgeImpl
	 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getActivityEdge()
	 * @generated
	 */
	int ACTIVITY_EDGE = 7;

	/**
	 * The meta object id for the '{@link org.js.graph.graphtransformation.ActivityNode <em>Activity Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.graphtransformation.ActivityNode
	 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getActivityNode()
	 * @generated
	 */
	int ACTIVITY_NODE = 6;

	/**
	 * The meta object id for the '{@link org.js.graph.graphtransformation.impl.InitialNodeImpl <em>Initial Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.graphtransformation.impl.InitialNodeImpl
	 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getInitialNode()
	 * @generated
	 */
	int INITIAL_NODE = 12;

	/**
	 * The meta object id for the '{@link org.js.graph.graphtransformation.impl.ActivityFinalNodeImpl <em>Activity Final Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.graphtransformation.impl.ActivityFinalNodeImpl
	 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getActivityFinalNode()
	 * @generated
	 */
	int ACTIVITY_FINAL_NODE = 13;

	/**
	 * The meta object id for the '{@link org.js.graph.graphtransformation.impl.FlowFinalNodeImpl <em>Flow Final Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.graphtransformation.impl.FlowFinalNodeImpl
	 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getFlowFinalNode()
	 * @generated
	 */
	int FLOW_FINAL_NODE = 14;

	/**
	 * The meta object id for the '{@link org.js.graph.graphtransformation.impl.ForkNodeImpl <em>Fork Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.graphtransformation.impl.ForkNodeImpl
	 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getForkNode()
	 * @generated
	 */
	int FORK_NODE = 15;

	/**
	 * The meta object id for the '{@link org.js.graph.graphtransformation.Action <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.graphtransformation.Action
	 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 16;

	/**
	 * The meta object id for the '{@link org.js.graph.graphtransformation.impl.SpecializationActionImpl <em>Specialization Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.graphtransformation.impl.SpecializationActionImpl
	 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getSpecializationAction()
	 * @generated
	 */
	int SPECIALIZATION_ACTION = 17;

	/**
	 * The meta object id for the '{@link org.js.graph.graphtransformation.impl.IdleActionImpl <em>Idle Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.graphtransformation.impl.IdleActionImpl
	 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getIdleAction()
	 * @generated
	 */
	int IDLE_ACTION = 18;

	/**
	 * The meta object id for the '{@link org.js.graph.graphtransformation.VariableRole <em>Variable Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.graphtransformation.VariableRole
	 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getVariableRole()
	 * @generated
	 */
	int VARIABLE_ROLE = 19;

	/**
	 * The meta object id for the '{@link org.js.graph.graphtransformation.impl.ExistingRoleImpl <em>Existing Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.graphtransformation.impl.ExistingRoleImpl
	 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getExistingRole()
	 * @generated
	 */
	int EXISTING_ROLE = 8;

	/**
	 * The meta object id for the '{@link org.js.graph.graphtransformation.impl.ArrivingRoleImpl <em>Arriving Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.graphtransformation.impl.ArrivingRoleImpl
	 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getArrivingRole()
	 * @generated
	 */
	int ARRIVING_ROLE = 9;

	/**
	 * The meta object id for the '{@link org.js.graph.graphtransformation.impl.ApplicationConditionsImpl <em>Application Conditions</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.graphtransformation.impl.ApplicationConditionsImpl
	 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getApplicationConditions()
	 * @generated
	 */
	int APPLICATION_CONDITIONS = 4;

	/**
	 * The meta object id for the '{@link org.js.graph.graphtransformation.impl.RolesImpl <em>Roles</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.graphtransformation.impl.RolesImpl
	 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getRoles()
	 * @generated
	 */
	int ROLES = 3;

	/**
	 * The feature id for the '<em><b>Existing Roles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLES__EXISTING_ROLES = 0;

	/**
	 * The feature id for the '<em><b>Arriving Role</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLES__ARRIVING_ROLE = 1;

	/**
	 * The number of structural features of the '<em>Roles</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLES_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITIONS__CONDITIONS = 0;

	/**
	 * The number of structural features of the '<em>Application Conditions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITIONS_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Change Primitives</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATIONS__CHANGE_PRIMITIVES = 0;

	/**
	 * The number of structural features of the '<em>Operations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATIONS_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_NODE__NAME = NAMEABLE__NAME;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_NODE__IN = NAMEABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Out</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_NODE__OUT = NAMEABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Activity Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_NODE_FEATURE_COUNT = NAMEABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_EDGE__NAME = NAMEABLE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_EDGE__SOURCE = NAMEABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_EDGE__TARGET = NAMEABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Activity Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_EDGE_FEATURE_COUNT = NAMEABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ROLE__NAME = NAMEABLE__NAME;

	/**
	 * The feature id for the '<em><b>Acion</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ROLE__ACION = NAMEABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ROLE_FEATURE_COUNT = NAMEABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTING_ROLE__NAME = VARIABLE_ROLE__NAME;

	/**
	 * The feature id for the '<em><b>Acion</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTING_ROLE__ACION = VARIABLE_ROLE__ACION;

	/**
	 * The number of structural features of the '<em>Existing Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTING_ROLE_FEATURE_COUNT = VARIABLE_ROLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRIVING_ROLE__NAME = VARIABLE_ROLE__NAME;

	/**
	 * The feature id for the '<em><b>Acion</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRIVING_ROLE__ACION = VARIABLE_ROLE__ACION;

	/**
	 * The number of structural features of the '<em>Arriving Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRIVING_ROLE_FEATURE_COUNT = VARIABLE_ROLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__NAME = NAMEABLE__NAME;

	/**
	 * The number of structural features of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_FEATURE_COUNT = NAMEABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.js.graph.graphtransformation.ChangePrimitive <em>Change Primitive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.graphtransformation.ChangePrimitive
	 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getChangePrimitive()
	 * @generated
	 */
	int CHANGE_PRIMITIVE = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_PRIMITIVE__NAME = NAMEABLE__NAME;

	/**
	 * The number of structural features of the '<em>Change Primitive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_PRIMITIVE_FEATURE_COUNT = NAMEABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_NODE__NAME = ACTIVITY_NODE__NAME;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_NODE__IN = ACTIVITY_NODE__IN;

	/**
	 * The feature id for the '<em><b>Out</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_NODE__OUT = ACTIVITY_NODE__OUT;

	/**
	 * The number of structural features of the '<em>Initial Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_NODE_FEATURE_COUNT = ACTIVITY_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_FINAL_NODE__NAME = ACTIVITY_NODE__NAME;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_FINAL_NODE__IN = ACTIVITY_NODE__IN;

	/**
	 * The feature id for the '<em><b>Out</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_FINAL_NODE__OUT = ACTIVITY_NODE__OUT;

	/**
	 * The number of structural features of the '<em>Activity Final Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_FINAL_NODE_FEATURE_COUNT = ACTIVITY_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_FINAL_NODE__NAME = ACTIVITY_NODE__NAME;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_FINAL_NODE__IN = ACTIVITY_NODE__IN;

	/**
	 * The feature id for the '<em><b>Out</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_FINAL_NODE__OUT = ACTIVITY_NODE__OUT;

	/**
	 * The number of structural features of the '<em>Flow Final Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_FINAL_NODE_FEATURE_COUNT = ACTIVITY_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_NODE__NAME = ACTIVITY_NODE__NAME;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_NODE__IN = ACTIVITY_NODE__IN;

	/**
	 * The feature id for the '<em><b>Out</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_NODE__OUT = ACTIVITY_NODE__OUT;

	/**
	 * The number of structural features of the '<em>Fork Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_NODE_FEATURE_COUNT = ACTIVITY_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__NAME = ACTIVITY_NODE__NAME;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__IN = ACTIVITY_NODE__IN;

	/**
	 * The feature id for the '<em><b>Out</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__OUT = ACTIVITY_NODE__OUT;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = ACTIVITY_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_ACTION__NAME = ACTION__NAME;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_ACTION__IN = ACTION__IN;

	/**
	 * The feature id for the '<em><b>Out</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_ACTION__OUT = ACTION__OUT;

	/**
	 * The feature id for the '<em><b>Variable Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_ACTION__VARIABLE_ROLE = ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Specialization Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_ACTION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDLE_ACTION__NAME = ACTION__NAME;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDLE_ACTION__IN = ACTION__IN;

	/**
	 * The feature id for the '<em><b>Out</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDLE_ACTION__OUT = ACTION__OUT;

	/**
	 * The number of structural features of the '<em>Idle Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDLE_ACTION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INHERITS_FROM__NAME = CONDITION__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INHERITS_FROM__PARENT = CONDITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Child</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INHERITS_FROM__CHILD = CONDITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Inherits From</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INHERITS_FROM_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BELONGS_TO__NAME = CONDITION__NAME;

	/**
	 * The feature id for the '<em><b>Leader</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BELONGS_TO__LEADER = CONDITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Member</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BELONGS_TO__MEMBER = CONDITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Belongs To</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BELONGS_TO_FEATURE_COUNT = CONDITION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.js.graph.graphtransformation.impl.RemoveNodeImpl <em>Remove Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.graphtransformation.impl.RemoveNodeImpl
	 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getRemoveNode()
	 * @generated
	 */
	int REMOVE_NODE = 22;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_NODE__NAME = CHANGE_PRIMITIVE__NAME;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_NODE__NODE = CHANGE_PRIMITIVE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Remove Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_NODE_FEATURE_COUNT = CHANGE_PRIMITIVE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.js.graph.graphtransformation.impl.RemoveEdgeImpl <em>Remove Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.graphtransformation.impl.RemoveEdgeImpl
	 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getRemoveEdge()
	 * @generated
	 */
	int REMOVE_EDGE = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_EDGE__NAME = CHANGE_PRIMITIVE__NAME;

	/**
	 * The feature id for the '<em><b>Edge</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_EDGE__EDGE = CHANGE_PRIMITIVE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Remove Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_EDGE_FEATURE_COUNT = CHANGE_PRIMITIVE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.js.graph.graphtransformation.impl.AddEdgeImpl <em>Add Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.graphtransformation.impl.AddEdgeImpl
	 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getAddEdge()
	 * @generated
	 */
	int ADD_EDGE = 24;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_EDGE__NAME = CHANGE_PRIMITIVE__NAME;

	/**
	 * The feature id for the '<em><b>Edge</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_EDGE__EDGE = CHANGE_PRIMITIVE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Add Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_EDGE_FEATURE_COUNT = CHANGE_PRIMITIVE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.js.graph.graphtransformation.impl.AddNodeImpl <em>Add Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.graphtransformation.impl.AddNodeImpl
	 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getAddNode()
	 * @generated
	 */
	int ADD_NODE = 25;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_NODE__NAME = CHANGE_PRIMITIVE__NAME;

	/**
	 * The feature id for the '<em><b>Node</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_NODE__NODE = CHANGE_PRIMITIVE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Add Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_NODE_FEATURE_COUNT = CHANGE_PRIMITIVE_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link org.js.graph.graphtransformation.GraphTransformation <em>Graph Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph Transformation</em>'.
	 * @see org.js.graph.graphtransformation.GraphTransformation
	 * @generated
	 */
	EClass getGraphTransformation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.js.graph.graphtransformation.GraphTransformation#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see org.js.graph.graphtransformation.GraphTransformation#getRules()
	 * @see #getGraphTransformation()
	 * @generated
	 */
	EReference getGraphTransformation_Rules();

	/**
	 * Returns the meta object for class '{@link org.js.graph.graphtransformation.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule</em>'.
	 * @see org.js.graph.graphtransformation.Rule
	 * @generated
	 */
	EClass getRule();

	/**
	 * Returns the meta object for the containment reference '{@link org.js.graph.graphtransformation.Rule#getLeftside <em>Leftside</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Leftside</em>'.
	 * @see org.js.graph.graphtransformation.Rule#getLeftside()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Leftside();

	/**
	 * Returns the meta object for the containment reference '{@link org.js.graph.graphtransformation.Rule#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operations</em>'.
	 * @see org.js.graph.graphtransformation.Rule#getOperations()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Operations();

	/**
	 * Returns the meta object for the containment reference '{@link org.js.graph.graphtransformation.Rule#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Roles</em>'.
	 * @see org.js.graph.graphtransformation.Rule#getRoles()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Roles();

	/**
	 * Returns the meta object for the containment reference '{@link org.js.graph.graphtransformation.Rule#getApplicationConditions <em>Application Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Application Conditions</em>'.
	 * @see org.js.graph.graphtransformation.Rule#getApplicationConditions()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_ApplicationConditions();

	/**
	 * Returns the meta object for class '{@link org.js.graph.graphtransformation.LeftSide <em>Left Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Left Side</em>'.
	 * @see org.js.graph.graphtransformation.LeftSide
	 * @generated
	 */
	EClass getLeftSide();

	/**
	 * Returns the meta object for the containment reference list '{@link org.js.graph.graphtransformation.LeftSide#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.js.graph.graphtransformation.LeftSide#getNodes()
	 * @see #getLeftSide()
	 * @generated
	 */
	EReference getLeftSide_Nodes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.js.graph.graphtransformation.LeftSide#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Edges</em>'.
	 * @see org.js.graph.graphtransformation.LeftSide#getEdges()
	 * @see #getLeftSide()
	 * @generated
	 */
	EReference getLeftSide_Edges();

	/**
	 * Returns the meta object for class '{@link org.js.graph.graphtransformation.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition</em>'.
	 * @see org.js.graph.graphtransformation.Condition
	 * @generated
	 */
	EClass getCondition();

	/**
	 * Returns the meta object for class '{@link org.js.graph.graphtransformation.InheritsFrom <em>Inherits From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inherits From</em>'.
	 * @see org.js.graph.graphtransformation.InheritsFrom
	 * @generated
	 */
	EClass getInheritsFrom();

	/**
	 * Returns the meta object for the reference '{@link org.js.graph.graphtransformation.InheritsFrom#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.js.graph.graphtransformation.InheritsFrom#getParent()
	 * @see #getInheritsFrom()
	 * @generated
	 */
	EReference getInheritsFrom_Parent();

	/**
	 * Returns the meta object for the reference '{@link org.js.graph.graphtransformation.InheritsFrom#getChild <em>Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Child</em>'.
	 * @see org.js.graph.graphtransformation.InheritsFrom#getChild()
	 * @see #getInheritsFrom()
	 * @generated
	 */
	EReference getInheritsFrom_Child();

	/**
	 * Returns the meta object for class '{@link org.js.graph.graphtransformation.BelongsTo <em>Belongs To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Belongs To</em>'.
	 * @see org.js.graph.graphtransformation.BelongsTo
	 * @generated
	 */
	EClass getBelongsTo();

	/**
	 * Returns the meta object for the reference '{@link org.js.graph.graphtransformation.BelongsTo#getLeader <em>Leader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Leader</em>'.
	 * @see org.js.graph.graphtransformation.BelongsTo#getLeader()
	 * @see #getBelongsTo()
	 * @generated
	 */
	EReference getBelongsTo_Leader();

	/**
	 * Returns the meta object for the reference '{@link org.js.graph.graphtransformation.BelongsTo#getMember <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Member</em>'.
	 * @see org.js.graph.graphtransformation.BelongsTo#getMember()
	 * @see #getBelongsTo()
	 * @generated
	 */
	EReference getBelongsTo_Member();

	/**
	 * Returns the meta object for class '{@link org.js.graph.graphtransformation.Operations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operations</em>'.
	 * @see org.js.graph.graphtransformation.Operations
	 * @generated
	 */
	EClass getOperations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.js.graph.graphtransformation.Operations#getChangePrimitives <em>Change Primitives</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Change Primitives</em>'.
	 * @see org.js.graph.graphtransformation.Operations#getChangePrimitives()
	 * @see #getOperations()
	 * @generated
	 */
	EReference getOperations_ChangePrimitives();

	/**
	 * Returns the meta object for class '{@link org.js.graph.graphtransformation.ActivityEdge <em>Activity Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activity Edge</em>'.
	 * @see org.js.graph.graphtransformation.ActivityEdge
	 * @generated
	 */
	EClass getActivityEdge();

	/**
	 * Returns the meta object for the reference '{@link org.js.graph.graphtransformation.ActivityEdge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.js.graph.graphtransformation.ActivityEdge#getSource()
	 * @see #getActivityEdge()
	 * @generated
	 */
	EReference getActivityEdge_Source();

	/**
	 * Returns the meta object for the reference '{@link org.js.graph.graphtransformation.ActivityEdge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.js.graph.graphtransformation.ActivityEdge#getTarget()
	 * @see #getActivityEdge()
	 * @generated
	 */
	EReference getActivityEdge_Target();

	/**
	 * Returns the meta object for class '{@link org.js.graph.graphtransformation.ActivityNode <em>Activity Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activity Node</em>'.
	 * @see org.js.graph.graphtransformation.ActivityNode
	 * @generated
	 */
	EClass getActivityNode();

	/**
	 * Returns the meta object for the reference list '{@link org.js.graph.graphtransformation.ActivityNode#getIn <em>In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In</em>'.
	 * @see org.js.graph.graphtransformation.ActivityNode#getIn()
	 * @see #getActivityNode()
	 * @generated
	 */
	EReference getActivityNode_In();

	/**
	 * Returns the meta object for the reference list '{@link org.js.graph.graphtransformation.ActivityNode#getOut <em>Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Out</em>'.
	 * @see org.js.graph.graphtransformation.ActivityNode#getOut()
	 * @see #getActivityNode()
	 * @generated
	 */
	EReference getActivityNode_Out();

	/**
	 * Returns the meta object for class '{@link org.js.graph.graphtransformation.InitialNode <em>Initial Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Initial Node</em>'.
	 * @see org.js.graph.graphtransformation.InitialNode
	 * @generated
	 */
	EClass getInitialNode();

	/**
	 * Returns the meta object for class '{@link org.js.graph.graphtransformation.ActivityFinalNode <em>Activity Final Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activity Final Node</em>'.
	 * @see org.js.graph.graphtransformation.ActivityFinalNode
	 * @generated
	 */
	EClass getActivityFinalNode();

	/**
	 * Returns the meta object for class '{@link org.js.graph.graphtransformation.FlowFinalNode <em>Flow Final Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flow Final Node</em>'.
	 * @see org.js.graph.graphtransformation.FlowFinalNode
	 * @generated
	 */
	EClass getFlowFinalNode();

	/**
	 * Returns the meta object for class '{@link org.js.graph.graphtransformation.ForkNode <em>Fork Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fork Node</em>'.
	 * @see org.js.graph.graphtransformation.ForkNode
	 * @generated
	 */
	EClass getForkNode();

	/**
	 * Returns the meta object for class '{@link org.js.graph.graphtransformation.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see org.js.graph.graphtransformation.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for class '{@link org.js.graph.graphtransformation.SpecializationAction <em>Specialization Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specialization Action</em>'.
	 * @see org.js.graph.graphtransformation.SpecializationAction
	 * @generated
	 */
	EClass getSpecializationAction();

	/**
	 * Returns the meta object for the reference '{@link org.js.graph.graphtransformation.SpecializationAction#getVariableRole <em>Variable Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable Role</em>'.
	 * @see org.js.graph.graphtransformation.SpecializationAction#getVariableRole()
	 * @see #getSpecializationAction()
	 * @generated
	 */
	EReference getSpecializationAction_VariableRole();

	/**
	 * Returns the meta object for class '{@link org.js.graph.graphtransformation.IdleAction <em>Idle Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Idle Action</em>'.
	 * @see org.js.graph.graphtransformation.IdleAction
	 * @generated
	 */
	EClass getIdleAction();

	/**
	 * Returns the meta object for class '{@link org.js.graph.graphtransformation.VariableRole <em>Variable Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Role</em>'.
	 * @see org.js.graph.graphtransformation.VariableRole
	 * @generated
	 */
	EClass getVariableRole();

	/**
	 * Returns the meta object for the reference '{@link org.js.graph.graphtransformation.VariableRole#getAcion <em>Acion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Acion</em>'.
	 * @see org.js.graph.graphtransformation.VariableRole#getAcion()
	 * @see #getVariableRole()
	 * @generated
	 */
	EReference getVariableRole_Acion();

	/**
	 * Returns the meta object for class '{@link org.js.graph.graphtransformation.Nameable <em>Nameable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nameable</em>'.
	 * @see org.js.graph.graphtransformation.Nameable
	 * @generated
	 */
	EClass getNameable();

	/**
	 * Returns the meta object for the attribute '{@link org.js.graph.graphtransformation.Nameable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.js.graph.graphtransformation.Nameable#getName()
	 * @see #getNameable()
	 * @generated
	 */
	EAttribute getNameable_Name();

	/**
	 * Returns the meta object for class '{@link org.js.graph.graphtransformation.ExistingRole <em>Existing Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Existing Role</em>'.
	 * @see org.js.graph.graphtransformation.ExistingRole
	 * @generated
	 */
	EClass getExistingRole();

	/**
	 * Returns the meta object for class '{@link org.js.graph.graphtransformation.ArrivingRole <em>Arriving Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arriving Role</em>'.
	 * @see org.js.graph.graphtransformation.ArrivingRole
	 * @generated
	 */
	EClass getArrivingRole();

	/**
	 * Returns the meta object for class '{@link org.js.graph.graphtransformation.ApplicationConditions <em>Application Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application Conditions</em>'.
	 * @see org.js.graph.graphtransformation.ApplicationConditions
	 * @generated
	 */
	EClass getApplicationConditions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.js.graph.graphtransformation.ApplicationConditions#getConditions <em>Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conditions</em>'.
	 * @see org.js.graph.graphtransformation.ApplicationConditions#getConditions()
	 * @see #getApplicationConditions()
	 * @generated
	 */
	EReference getApplicationConditions_Conditions();

	/**
	 * Returns the meta object for class '{@link org.js.graph.graphtransformation.Roles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Roles</em>'.
	 * @see org.js.graph.graphtransformation.Roles
	 * @generated
	 */
	EClass getRoles();

	/**
	 * Returns the meta object for the containment reference '{@link org.js.graph.graphtransformation.Roles#getArrivingRole <em>Arriving Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Arriving Role</em>'.
	 * @see org.js.graph.graphtransformation.Roles#getArrivingRole()
	 * @see #getRoles()
	 * @generated
	 */
	EReference getRoles_ArrivingRole();

	/**
	 * Returns the meta object for the containment reference list '{@link org.js.graph.graphtransformation.Roles#getExistingRoles <em>Existing Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Existing Roles</em>'.
	 * @see org.js.graph.graphtransformation.Roles#getExistingRoles()
	 * @see #getRoles()
	 * @generated
	 */
	EReference getRoles_ExistingRoles();

	/**
	 * Returns the meta object for class '{@link org.js.graph.graphtransformation.RemoveNode <em>Remove Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remove Node</em>'.
	 * @see org.js.graph.graphtransformation.RemoveNode
	 * @generated
	 */
	EClass getRemoveNode();

	/**
	 * Returns the meta object for the reference list '{@link org.js.graph.graphtransformation.RemoveNode#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Node</em>'.
	 * @see org.js.graph.graphtransformation.RemoveNode#getNode()
	 * @see #getRemoveNode()
	 * @generated
	 */
	EReference getRemoveNode_Node();

	/**
	 * Returns the meta object for class '{@link org.js.graph.graphtransformation.RemoveEdge <em>Remove Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remove Edge</em>'.
	 * @see org.js.graph.graphtransformation.RemoveEdge
	 * @generated
	 */
	EClass getRemoveEdge();

	/**
	 * Returns the meta object for the reference list '{@link org.js.graph.graphtransformation.RemoveEdge#getEdge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Edge</em>'.
	 * @see org.js.graph.graphtransformation.RemoveEdge#getEdge()
	 * @see #getRemoveEdge()
	 * @generated
	 */
	EReference getRemoveEdge_Edge();

	/**
	 * Returns the meta object for class '{@link org.js.graph.graphtransformation.ChangePrimitive <em>Change Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Change Primitive</em>'.
	 * @see org.js.graph.graphtransformation.ChangePrimitive
	 * @generated
	 */
	EClass getChangePrimitive();

	/**
	 * Returns the meta object for class '{@link org.js.graph.graphtransformation.AddEdge <em>Add Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Edge</em>'.
	 * @see org.js.graph.graphtransformation.AddEdge
	 * @generated
	 */
	EClass getAddEdge();

	/**
	 * Returns the meta object for the containment reference list '{@link org.js.graph.graphtransformation.AddEdge#getEdge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Edge</em>'.
	 * @see org.js.graph.graphtransformation.AddEdge#getEdge()
	 * @see #getAddEdge()
	 * @generated
	 */
	EReference getAddEdge_Edge();

	/**
	 * Returns the meta object for class '{@link org.js.graph.graphtransformation.AddNode <em>Add Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Node</em>'.
	 * @see org.js.graph.graphtransformation.AddNode
	 * @generated
	 */
	EClass getAddNode();

	/**
	 * Returns the meta object for the containment reference list '{@link org.js.graph.graphtransformation.AddNode#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Node</em>'.
	 * @see org.js.graph.graphtransformation.AddNode#getNode()
	 * @see #getAddNode()
	 * @generated
	 */
	EReference getAddNode_Node();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GraphtransformationFactory getGraphtransformationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.js.graph.graphtransformation.impl.GraphTransformationImpl <em>Graph Transformation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.graphtransformation.impl.GraphTransformationImpl
		 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getGraphTransformation()
		 * @generated
		 */
		EClass GRAPH_TRANSFORMATION = eINSTANCE.getGraphTransformation();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH_TRANSFORMATION__RULES = eINSTANCE.getGraphTransformation_Rules();

		/**
		 * The meta object literal for the '{@link org.js.graph.graphtransformation.impl.RuleImpl <em>Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.graphtransformation.impl.RuleImpl
		 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getRule()
		 * @generated
		 */
		EClass RULE = eINSTANCE.getRule();

		/**
		 * The meta object literal for the '<em><b>Leftside</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__LEFTSIDE = eINSTANCE.getRule_Leftside();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__OPERATIONS = eINSTANCE.getRule_Operations();

		/**
		 * The meta object literal for the '<em><b>Roles</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__ROLES = eINSTANCE.getRule_Roles();

		/**
		 * The meta object literal for the '<em><b>Application Conditions</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__APPLICATION_CONDITIONS = eINSTANCE.getRule_ApplicationConditions();

		/**
		 * The meta object literal for the '{@link org.js.graph.graphtransformation.impl.LeftSideImpl <em>Left Side</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.graphtransformation.impl.LeftSideImpl
		 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getLeftSide()
		 * @generated
		 */
		EClass LEFT_SIDE = eINSTANCE.getLeftSide();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LEFT_SIDE__NODES = eINSTANCE.getLeftSide_Nodes();

		/**
		 * The meta object literal for the '<em><b>Edges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LEFT_SIDE__EDGES = eINSTANCE.getLeftSide_Edges();

		/**
		 * The meta object literal for the '{@link org.js.graph.graphtransformation.Condition <em>Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.graphtransformation.Condition
		 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getCondition()
		 * @generated
		 */
		EClass CONDITION = eINSTANCE.getCondition();

		/**
		 * The meta object literal for the '{@link org.js.graph.graphtransformation.impl.InheritsFromImpl <em>Inherits From</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.graphtransformation.impl.InheritsFromImpl
		 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getInheritsFrom()
		 * @generated
		 */
		EClass INHERITS_FROM = eINSTANCE.getInheritsFrom();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INHERITS_FROM__PARENT = eINSTANCE.getInheritsFrom_Parent();

		/**
		 * The meta object literal for the '<em><b>Child</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INHERITS_FROM__CHILD = eINSTANCE.getInheritsFrom_Child();

		/**
		 * The meta object literal for the '{@link org.js.graph.graphtransformation.impl.BelongsToImpl <em>Belongs To</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.graphtransformation.impl.BelongsToImpl
		 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getBelongsTo()
		 * @generated
		 */
		EClass BELONGS_TO = eINSTANCE.getBelongsTo();

		/**
		 * The meta object literal for the '<em><b>Leader</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BELONGS_TO__LEADER = eINSTANCE.getBelongsTo_Leader();

		/**
		 * The meta object literal for the '<em><b>Member</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BELONGS_TO__MEMBER = eINSTANCE.getBelongsTo_Member();

		/**
		 * The meta object literal for the '{@link org.js.graph.graphtransformation.impl.OperationsImpl <em>Operations</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.graphtransformation.impl.OperationsImpl
		 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getOperations()
		 * @generated
		 */
		EClass OPERATIONS = eINSTANCE.getOperations();

		/**
		 * The meta object literal for the '<em><b>Change Primitives</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATIONS__CHANGE_PRIMITIVES = eINSTANCE.getOperations_ChangePrimitives();

		/**
		 * The meta object literal for the '{@link org.js.graph.graphtransformation.impl.ActivityEdgeImpl <em>Activity Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.graphtransformation.impl.ActivityEdgeImpl
		 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getActivityEdge()
		 * @generated
		 */
		EClass ACTIVITY_EDGE = eINSTANCE.getActivityEdge();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY_EDGE__SOURCE = eINSTANCE.getActivityEdge_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY_EDGE__TARGET = eINSTANCE.getActivityEdge_Target();

		/**
		 * The meta object literal for the '{@link org.js.graph.graphtransformation.ActivityNode <em>Activity Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.graphtransformation.ActivityNode
		 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getActivityNode()
		 * @generated
		 */
		EClass ACTIVITY_NODE = eINSTANCE.getActivityNode();

		/**
		 * The meta object literal for the '<em><b>In</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY_NODE__IN = eINSTANCE.getActivityNode_In();

		/**
		 * The meta object literal for the '<em><b>Out</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY_NODE__OUT = eINSTANCE.getActivityNode_Out();

		/**
		 * The meta object literal for the '{@link org.js.graph.graphtransformation.impl.InitialNodeImpl <em>Initial Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.graphtransformation.impl.InitialNodeImpl
		 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getInitialNode()
		 * @generated
		 */
		EClass INITIAL_NODE = eINSTANCE.getInitialNode();

		/**
		 * The meta object literal for the '{@link org.js.graph.graphtransformation.impl.ActivityFinalNodeImpl <em>Activity Final Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.graphtransformation.impl.ActivityFinalNodeImpl
		 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getActivityFinalNode()
		 * @generated
		 */
		EClass ACTIVITY_FINAL_NODE = eINSTANCE.getActivityFinalNode();

		/**
		 * The meta object literal for the '{@link org.js.graph.graphtransformation.impl.FlowFinalNodeImpl <em>Flow Final Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.graphtransformation.impl.FlowFinalNodeImpl
		 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getFlowFinalNode()
		 * @generated
		 */
		EClass FLOW_FINAL_NODE = eINSTANCE.getFlowFinalNode();

		/**
		 * The meta object literal for the '{@link org.js.graph.graphtransformation.impl.ForkNodeImpl <em>Fork Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.graphtransformation.impl.ForkNodeImpl
		 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getForkNode()
		 * @generated
		 */
		EClass FORK_NODE = eINSTANCE.getForkNode();

		/**
		 * The meta object literal for the '{@link org.js.graph.graphtransformation.Action <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.graphtransformation.Action
		 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '{@link org.js.graph.graphtransformation.impl.SpecializationActionImpl <em>Specialization Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.graphtransformation.impl.SpecializationActionImpl
		 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getSpecializationAction()
		 * @generated
		 */
		EClass SPECIALIZATION_ACTION = eINSTANCE.getSpecializationAction();

		/**
		 * The meta object literal for the '<em><b>Variable Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIALIZATION_ACTION__VARIABLE_ROLE = eINSTANCE.getSpecializationAction_VariableRole();

		/**
		 * The meta object literal for the '{@link org.js.graph.graphtransformation.impl.IdleActionImpl <em>Idle Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.graphtransformation.impl.IdleActionImpl
		 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getIdleAction()
		 * @generated
		 */
		EClass IDLE_ACTION = eINSTANCE.getIdleAction();

		/**
		 * The meta object literal for the '{@link org.js.graph.graphtransformation.VariableRole <em>Variable Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.graphtransformation.VariableRole
		 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getVariableRole()
		 * @generated
		 */
		EClass VARIABLE_ROLE = eINSTANCE.getVariableRole();

		/**
		 * The meta object literal for the '<em><b>Acion</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_ROLE__ACION = eINSTANCE.getVariableRole_Acion();

		/**
		 * The meta object literal for the '{@link org.js.graph.graphtransformation.Nameable <em>Nameable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.graphtransformation.Nameable
		 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getNameable()
		 * @generated
		 */
		EClass NAMEABLE = eINSTANCE.getNameable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMEABLE__NAME = eINSTANCE.getNameable_Name();

		/**
		 * The meta object literal for the '{@link org.js.graph.graphtransformation.impl.ExistingRoleImpl <em>Existing Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.graphtransformation.impl.ExistingRoleImpl
		 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getExistingRole()
		 * @generated
		 */
		EClass EXISTING_ROLE = eINSTANCE.getExistingRole();

		/**
		 * The meta object literal for the '{@link org.js.graph.graphtransformation.impl.ArrivingRoleImpl <em>Arriving Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.graphtransformation.impl.ArrivingRoleImpl
		 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getArrivingRole()
		 * @generated
		 */
		EClass ARRIVING_ROLE = eINSTANCE.getArrivingRole();

		/**
		 * The meta object literal for the '{@link org.js.graph.graphtransformation.impl.ApplicationConditionsImpl <em>Application Conditions</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.graphtransformation.impl.ApplicationConditionsImpl
		 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getApplicationConditions()
		 * @generated
		 */
		EClass APPLICATION_CONDITIONS = eINSTANCE.getApplicationConditions();

		/**
		 * The meta object literal for the '<em><b>Conditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_CONDITIONS__CONDITIONS = eINSTANCE.getApplicationConditions_Conditions();

		/**
		 * The meta object literal for the '{@link org.js.graph.graphtransformation.impl.RolesImpl <em>Roles</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.graphtransformation.impl.RolesImpl
		 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getRoles()
		 * @generated
		 */
		EClass ROLES = eINSTANCE.getRoles();

		/**
		 * The meta object literal for the '<em><b>Arriving Role</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLES__ARRIVING_ROLE = eINSTANCE.getRoles_ArrivingRole();

		/**
		 * The meta object literal for the '<em><b>Existing Roles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLES__EXISTING_ROLES = eINSTANCE.getRoles_ExistingRoles();

		/**
		 * The meta object literal for the '{@link org.js.graph.graphtransformation.impl.RemoveNodeImpl <em>Remove Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.graphtransformation.impl.RemoveNodeImpl
		 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getRemoveNode()
		 * @generated
		 */
		EClass REMOVE_NODE = eINSTANCE.getRemoveNode();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOVE_NODE__NODE = eINSTANCE.getRemoveNode_Node();

		/**
		 * The meta object literal for the '{@link org.js.graph.graphtransformation.impl.RemoveEdgeImpl <em>Remove Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.graphtransformation.impl.RemoveEdgeImpl
		 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getRemoveEdge()
		 * @generated
		 */
		EClass REMOVE_EDGE = eINSTANCE.getRemoveEdge();

		/**
		 * The meta object literal for the '<em><b>Edge</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOVE_EDGE__EDGE = eINSTANCE.getRemoveEdge_Edge();

		/**
		 * The meta object literal for the '{@link org.js.graph.graphtransformation.ChangePrimitive <em>Change Primitive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.graphtransformation.ChangePrimitive
		 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getChangePrimitive()
		 * @generated
		 */
		EClass CHANGE_PRIMITIVE = eINSTANCE.getChangePrimitive();

		/**
		 * The meta object literal for the '{@link org.js.graph.graphtransformation.impl.AddEdgeImpl <em>Add Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.graphtransformation.impl.AddEdgeImpl
		 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getAddEdge()
		 * @generated
		 */
		EClass ADD_EDGE = eINSTANCE.getAddEdge();

		/**
		 * The meta object literal for the '<em><b>Edge</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADD_EDGE__EDGE = eINSTANCE.getAddEdge_Edge();

		/**
		 * The meta object literal for the '{@link org.js.graph.graphtransformation.impl.AddNodeImpl <em>Add Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.graphtransformation.impl.AddNodeImpl
		 * @see org.js.graph.graphtransformation.impl.GraphtransformationPackageImpl#getAddNode()
		 * @generated
		 */
		EClass ADD_NODE = eINSTANCE.getAddNode();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADD_NODE__NODE = eINSTANCE.getAddNode_Node();

	}

} //GraphtransformationPackage
