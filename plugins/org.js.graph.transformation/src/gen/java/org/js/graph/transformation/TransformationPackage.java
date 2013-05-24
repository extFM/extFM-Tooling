/**
 */
package org.js.graph.transformation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.js.graph.transformation.TransformationFactory
 * @model kind="package"
 * @generated
 */
public interface TransformationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "transformation";

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
	String eNS_PREFIX = "transformation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TransformationPackage eINSTANCE = org.js.graph.transformation.impl.TransformationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.js.graph.transformation.impl.GraphTransformationImpl <em>Graph Transformation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.transformation.impl.GraphTransformationImpl
	 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getGraphTransformation()
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
	 * The number of operations of the '<em>Graph Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_TRANSFORMATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.js.graph.transformation.Nameable <em>Nameable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.transformation.Nameable
	 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getNameable()
	 * @generated
	 */
	int NAMEABLE = 25;

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
	 * The number of operations of the '<em>Nameable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMEABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.js.graph.transformation.impl.RuleImpl <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.transformation.impl.RuleImpl
	 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getRule()
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
	 * The number of operations of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_OPERATION_COUNT = NAMEABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.js.graph.transformation.impl.LeftSideImpl <em>Left Side</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.transformation.impl.LeftSideImpl
	 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getLeftSide()
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
	 * The number of operations of the '<em>Left Side</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEFT_SIDE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.js.graph.transformation.impl.RolesImpl <em>Roles</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.transformation.impl.RolesImpl
	 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getRoles()
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
	 * The number of operations of the '<em>Roles</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLES_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.js.graph.transformation.impl.ApplicationConditionsImpl <em>Application Conditions</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.transformation.impl.ApplicationConditionsImpl
	 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getApplicationConditions()
	 * @generated
	 */
	int APPLICATION_CONDITIONS = 4;

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
	 * The number of operations of the '<em>Application Conditions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_CONDITIONS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.js.graph.transformation.impl.OperationsImpl <em>Operations</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.transformation.impl.OperationsImpl
	 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getOperations()
	 * @generated
	 */
	int OPERATIONS = 5;

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
	 * The number of operations of the '<em>Operations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATIONS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.js.graph.transformation.Node <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.transformation.Node
	 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = NAMEABLE__NAME;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__IN = NAMEABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Out</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__OUT = NAMEABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = NAMEABLE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = NAMEABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.js.graph.transformation.impl.EdgeImpl <em>Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.transformation.impl.EdgeImpl
	 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getEdge()
	 * @generated
	 */
	int EDGE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__NAME = NAMEABLE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__SOURCE = NAMEABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__TARGET = NAMEABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_FEATURE_COUNT = NAMEABLE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_OPERATION_COUNT = NAMEABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.js.graph.transformation.VariableRole <em>Variable Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.transformation.VariableRole
	 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getVariableRole()
	 * @generated
	 */
	int VARIABLE_ROLE = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ROLE__NAME = NAMEABLE__NAME;

	/**
	 * The feature id for the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ROLE__ACTION = NAMEABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ROLE_FEATURE_COUNT = NAMEABLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Variable Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ROLE_OPERATION_COUNT = NAMEABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.js.graph.transformation.impl.ExistingRoleImpl <em>Existing Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.transformation.impl.ExistingRoleImpl
	 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getExistingRole()
	 * @generated
	 */
	int EXISTING_ROLE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTING_ROLE__NAME = VARIABLE_ROLE__NAME;

	/**
	 * The feature id for the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTING_ROLE__ACTION = VARIABLE_ROLE__ACTION;

	/**
	 * The number of structural features of the '<em>Existing Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTING_ROLE_FEATURE_COUNT = VARIABLE_ROLE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Existing Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTING_ROLE_OPERATION_COUNT = VARIABLE_ROLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.js.graph.transformation.impl.ArrivingRoleImpl <em>Arriving Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.transformation.impl.ArrivingRoleImpl
	 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getArrivingRole()
	 * @generated
	 */
	int ARRIVING_ROLE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRIVING_ROLE__NAME = VARIABLE_ROLE__NAME;

	/**
	 * The feature id for the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRIVING_ROLE__ACTION = VARIABLE_ROLE__ACTION;

	/**
	 * The number of structural features of the '<em>Arriving Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRIVING_ROLE_FEATURE_COUNT = VARIABLE_ROLE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Arriving Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRIVING_ROLE_OPERATION_COUNT = VARIABLE_ROLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.js.graph.transformation.Condition <em>Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.transformation.Condition
	 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getCondition()
	 * @generated
	 */
	int CONDITION = 10;

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
	 * The number of operations of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_OPERATION_COUNT = NAMEABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.js.graph.transformation.ChangePrimitive <em>Change Primitive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.transformation.ChangePrimitive
	 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getChangePrimitive()
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
	 * The number of operations of the '<em>Change Primitive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_PRIMITIVE_OPERATION_COUNT = NAMEABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.js.graph.transformation.impl.InitialImpl <em>Initial</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.transformation.impl.InitialImpl
	 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getInitial()
	 * @generated
	 */
	int INITIAL = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL__IN = NODE__IN;

	/**
	 * The feature id for the '<em><b>Out</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL__OUT = NODE__OUT;

	/**
	 * The number of structural features of the '<em>Initial</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Initial</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIAL_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.js.graph.transformation.impl.ActivityFinalImpl <em>Activity Final</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.transformation.impl.ActivityFinalImpl
	 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getActivityFinal()
	 * @generated
	 */
	int ACTIVITY_FINAL = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_FINAL__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_FINAL__IN = NODE__IN;

	/**
	 * The feature id for the '<em><b>Out</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_FINAL__OUT = NODE__OUT;

	/**
	 * The number of structural features of the '<em>Activity Final</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_FINAL_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Activity Final</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_FINAL_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.js.graph.transformation.impl.FlowFinalImpl <em>Flow Final</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.transformation.impl.FlowFinalImpl
	 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getFlowFinal()
	 * @generated
	 */
	int FLOW_FINAL = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_FINAL__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_FINAL__IN = NODE__IN;

	/**
	 * The feature id for the '<em><b>Out</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_FINAL__OUT = NODE__OUT;

	/**
	 * The number of structural features of the '<em>Flow Final</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_FINAL_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Flow Final</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_FINAL_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.js.graph.transformation.impl.ForkImpl <em>Fork</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.transformation.impl.ForkImpl
	 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getFork()
	 * @generated
	 */
	int FORK = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK__IN = NODE__IN;

	/**
	 * The feature id for the '<em><b>Out</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK__OUT = NODE__OUT;

	/**
	 * The number of structural features of the '<em>Fork</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Fork</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.js.graph.transformation.impl.SpecializationActionImpl <em>Specialization Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.transformation.impl.SpecializationActionImpl
	 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getSpecializationAction()
	 * @generated
	 */
	int SPECIALIZATION_ACTION = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_ACTION__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_ACTION__IN = NODE__IN;

	/**
	 * The feature id for the '<em><b>Out</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_ACTION__OUT = NODE__OUT;

	/**
	 * The feature id for the '<em><b>Variable Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_ACTION__VARIABLE_ROLE = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Specialization Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_ACTION_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Specialization Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_ACTION_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.js.graph.transformation.impl.IdleActionImpl <em>Idle Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.transformation.impl.IdleActionImpl
	 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getIdleAction()
	 * @generated
	 */
	int IDLE_ACTION = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDLE_ACTION__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDLE_ACTION__IN = NODE__IN;

	/**
	 * The feature id for the '<em><b>Out</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDLE_ACTION__OUT = NODE__OUT;

	/**
	 * The number of structural features of the '<em>Idle Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDLE_ACTION_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Idle Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDLE_ACTION_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.js.graph.transformation.impl.InheritsFromImpl <em>Inherits From</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.transformation.impl.InheritsFromImpl
	 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getInheritsFrom()
	 * @generated
	 */
	int INHERITS_FROM = 19;

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
	 * The number of operations of the '<em>Inherits From</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INHERITS_FROM_OPERATION_COUNT = CONDITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.js.graph.transformation.impl.BelongsToImpl <em>Belongs To</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.transformation.impl.BelongsToImpl
	 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getBelongsTo()
	 * @generated
	 */
	int BELONGS_TO = 20;

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
	 * The number of operations of the '<em>Belongs To</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BELONGS_TO_OPERATION_COUNT = CONDITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.js.graph.transformation.impl.RemoveNodeImpl <em>Remove Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.transformation.impl.RemoveNodeImpl
	 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getRemoveNode()
	 * @generated
	 */
	int REMOVE_NODE = 21;

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
	 * The number of operations of the '<em>Remove Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_NODE_OPERATION_COUNT = CHANGE_PRIMITIVE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.js.graph.transformation.impl.RemoveEdgeImpl <em>Remove Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.transformation.impl.RemoveEdgeImpl
	 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getRemoveEdge()
	 * @generated
	 */
	int REMOVE_EDGE = 22;

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
	 * The number of operations of the '<em>Remove Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_EDGE_OPERATION_COUNT = CHANGE_PRIMITIVE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.js.graph.transformation.impl.AddEdgeImpl <em>Add Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.transformation.impl.AddEdgeImpl
	 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getAddEdge()
	 * @generated
	 */
	int ADD_EDGE = 23;

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
	 * The number of operations of the '<em>Add Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_EDGE_OPERATION_COUNT = CHANGE_PRIMITIVE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.js.graph.transformation.impl.AddNodeImpl <em>Add Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.graph.transformation.impl.AddNodeImpl
	 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getAddNode()
	 * @generated
	 */
	int ADD_NODE = 24;

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
	 * The number of operations of the '<em>Add Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_NODE_OPERATION_COUNT = CHANGE_PRIMITIVE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.js.graph.transformation.GraphTransformation <em>Graph Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph Transformation</em>'.
	 * @see org.js.graph.transformation.GraphTransformation
	 * @generated
	 */
	EClass getGraphTransformation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.js.graph.transformation.GraphTransformation#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see org.js.graph.transformation.GraphTransformation#getRules()
	 * @see #getGraphTransformation()
	 * @generated
	 */
	EReference getGraphTransformation_Rules();

	/**
	 * Returns the meta object for class '{@link org.js.graph.transformation.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule</em>'.
	 * @see org.js.graph.transformation.Rule
	 * @generated
	 */
	EClass getRule();

	/**
	 * Returns the meta object for the containment reference '{@link org.js.graph.transformation.Rule#getLeftside <em>Leftside</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Leftside</em>'.
	 * @see org.js.graph.transformation.Rule#getLeftside()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Leftside();

	/**
	 * Returns the meta object for the containment reference '{@link org.js.graph.transformation.Rule#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Roles</em>'.
	 * @see org.js.graph.transformation.Rule#getRoles()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Roles();

	/**
	 * Returns the meta object for the containment reference '{@link org.js.graph.transformation.Rule#getApplicationConditions <em>Application Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Application Conditions</em>'.
	 * @see org.js.graph.transformation.Rule#getApplicationConditions()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_ApplicationConditions();

	/**
	 * Returns the meta object for the containment reference '{@link org.js.graph.transformation.Rule#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operations</em>'.
	 * @see org.js.graph.transformation.Rule#getOperations()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Operations();

	/**
	 * Returns the meta object for class '{@link org.js.graph.transformation.LeftSide <em>Left Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Left Side</em>'.
	 * @see org.js.graph.transformation.LeftSide
	 * @generated
	 */
	EClass getLeftSide();

	/**
	 * Returns the meta object for the containment reference list '{@link org.js.graph.transformation.LeftSide#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.js.graph.transformation.LeftSide#getNodes()
	 * @see #getLeftSide()
	 * @generated
	 */
	EReference getLeftSide_Nodes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.js.graph.transformation.LeftSide#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Edges</em>'.
	 * @see org.js.graph.transformation.LeftSide#getEdges()
	 * @see #getLeftSide()
	 * @generated
	 */
	EReference getLeftSide_Edges();

	/**
	 * Returns the meta object for class '{@link org.js.graph.transformation.Roles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Roles</em>'.
	 * @see org.js.graph.transformation.Roles
	 * @generated
	 */
	EClass getRoles();

	/**
	 * Returns the meta object for the containment reference list '{@link org.js.graph.transformation.Roles#getExistingRoles <em>Existing Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Existing Roles</em>'.
	 * @see org.js.graph.transformation.Roles#getExistingRoles()
	 * @see #getRoles()
	 * @generated
	 */
	EReference getRoles_ExistingRoles();

	/**
	 * Returns the meta object for the containment reference '{@link org.js.graph.transformation.Roles#getArrivingRole <em>Arriving Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Arriving Role</em>'.
	 * @see org.js.graph.transformation.Roles#getArrivingRole()
	 * @see #getRoles()
	 * @generated
	 */
	EReference getRoles_ArrivingRole();

	/**
	 * Returns the meta object for class '{@link org.js.graph.transformation.ApplicationConditions <em>Application Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application Conditions</em>'.
	 * @see org.js.graph.transformation.ApplicationConditions
	 * @generated
	 */
	EClass getApplicationConditions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.js.graph.transformation.ApplicationConditions#getConditions <em>Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conditions</em>'.
	 * @see org.js.graph.transformation.ApplicationConditions#getConditions()
	 * @see #getApplicationConditions()
	 * @generated
	 */
	EReference getApplicationConditions_Conditions();

	/**
	 * Returns the meta object for class '{@link org.js.graph.transformation.Operations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operations</em>'.
	 * @see org.js.graph.transformation.Operations
	 * @generated
	 */
	EClass getOperations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.js.graph.transformation.Operations#getChangePrimitives <em>Change Primitives</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Change Primitives</em>'.
	 * @see org.js.graph.transformation.Operations#getChangePrimitives()
	 * @see #getOperations()
	 * @generated
	 */
	EReference getOperations_ChangePrimitives();

	/**
	 * Returns the meta object for class '{@link org.js.graph.transformation.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.js.graph.transformation.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the reference list '{@link org.js.graph.transformation.Node#getIn <em>In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In</em>'.
	 * @see org.js.graph.transformation.Node#getIn()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_In();

	/**
	 * Returns the meta object for the reference list '{@link org.js.graph.transformation.Node#getOut <em>Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Out</em>'.
	 * @see org.js.graph.transformation.Node#getOut()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Out();

	/**
	 * Returns the meta object for class '{@link org.js.graph.transformation.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge</em>'.
	 * @see org.js.graph.transformation.Edge
	 * @generated
	 */
	EClass getEdge();

	/**
	 * Returns the meta object for the reference '{@link org.js.graph.transformation.Edge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.js.graph.transformation.Edge#getSource()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Source();

	/**
	 * Returns the meta object for the reference '{@link org.js.graph.transformation.Edge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.js.graph.transformation.Edge#getTarget()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Target();

	/**
	 * Returns the meta object for class '{@link org.js.graph.transformation.ExistingRole <em>Existing Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Existing Role</em>'.
	 * @see org.js.graph.transformation.ExistingRole
	 * @generated
	 */
	EClass getExistingRole();

	/**
	 * Returns the meta object for class '{@link org.js.graph.transformation.ArrivingRole <em>Arriving Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arriving Role</em>'.
	 * @see org.js.graph.transformation.ArrivingRole
	 * @generated
	 */
	EClass getArrivingRole();

	/**
	 * Returns the meta object for class '{@link org.js.graph.transformation.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition</em>'.
	 * @see org.js.graph.transformation.Condition
	 * @generated
	 */
	EClass getCondition();

	/**
	 * Returns the meta object for class '{@link org.js.graph.transformation.ChangePrimitive <em>Change Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Change Primitive</em>'.
	 * @see org.js.graph.transformation.ChangePrimitive
	 * @generated
	 */
	EClass getChangePrimitive();

	/**
	 * Returns the meta object for class '{@link org.js.graph.transformation.Initial <em>Initial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Initial</em>'.
	 * @see org.js.graph.transformation.Initial
	 * @generated
	 */
	EClass getInitial();

	/**
	 * Returns the meta object for class '{@link org.js.graph.transformation.ActivityFinal <em>Activity Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activity Final</em>'.
	 * @see org.js.graph.transformation.ActivityFinal
	 * @generated
	 */
	EClass getActivityFinal();

	/**
	 * Returns the meta object for class '{@link org.js.graph.transformation.FlowFinal <em>Flow Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flow Final</em>'.
	 * @see org.js.graph.transformation.FlowFinal
	 * @generated
	 */
	EClass getFlowFinal();

	/**
	 * Returns the meta object for class '{@link org.js.graph.transformation.Fork <em>Fork</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fork</em>'.
	 * @see org.js.graph.transformation.Fork
	 * @generated
	 */
	EClass getFork();

	/**
	 * Returns the meta object for class '{@link org.js.graph.transformation.SpecializationAction <em>Specialization Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specialization Action</em>'.
	 * @see org.js.graph.transformation.SpecializationAction
	 * @generated
	 */
	EClass getSpecializationAction();

	/**
	 * Returns the meta object for the reference '{@link org.js.graph.transformation.SpecializationAction#getVariableRole <em>Variable Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable Role</em>'.
	 * @see org.js.graph.transformation.SpecializationAction#getVariableRole()
	 * @see #getSpecializationAction()
	 * @generated
	 */
	EReference getSpecializationAction_VariableRole();

	/**
	 * Returns the meta object for class '{@link org.js.graph.transformation.IdleAction <em>Idle Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Idle Action</em>'.
	 * @see org.js.graph.transformation.IdleAction
	 * @generated
	 */
	EClass getIdleAction();

	/**
	 * Returns the meta object for class '{@link org.js.graph.transformation.VariableRole <em>Variable Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Role</em>'.
	 * @see org.js.graph.transformation.VariableRole
	 * @generated
	 */
	EClass getVariableRole();

	/**
	 * Returns the meta object for the reference '{@link org.js.graph.transformation.VariableRole#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Action</em>'.
	 * @see org.js.graph.transformation.VariableRole#getAction()
	 * @see #getVariableRole()
	 * @generated
	 */
	EReference getVariableRole_Action();

	/**
	 * Returns the meta object for class '{@link org.js.graph.transformation.InheritsFrom <em>Inherits From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inherits From</em>'.
	 * @see org.js.graph.transformation.InheritsFrom
	 * @generated
	 */
	EClass getInheritsFrom();

	/**
	 * Returns the meta object for the reference '{@link org.js.graph.transformation.InheritsFrom#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.js.graph.transformation.InheritsFrom#getParent()
	 * @see #getInheritsFrom()
	 * @generated
	 */
	EReference getInheritsFrom_Parent();

	/**
	 * Returns the meta object for the reference '{@link org.js.graph.transformation.InheritsFrom#getChild <em>Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Child</em>'.
	 * @see org.js.graph.transformation.InheritsFrom#getChild()
	 * @see #getInheritsFrom()
	 * @generated
	 */
	EReference getInheritsFrom_Child();

	/**
	 * Returns the meta object for class '{@link org.js.graph.transformation.BelongsTo <em>Belongs To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Belongs To</em>'.
	 * @see org.js.graph.transformation.BelongsTo
	 * @generated
	 */
	EClass getBelongsTo();

	/**
	 * Returns the meta object for the reference '{@link org.js.graph.transformation.BelongsTo#getLeader <em>Leader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Leader</em>'.
	 * @see org.js.graph.transformation.BelongsTo#getLeader()
	 * @see #getBelongsTo()
	 * @generated
	 */
	EReference getBelongsTo_Leader();

	/**
	 * Returns the meta object for the reference '{@link org.js.graph.transformation.BelongsTo#getMember <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Member</em>'.
	 * @see org.js.graph.transformation.BelongsTo#getMember()
	 * @see #getBelongsTo()
	 * @generated
	 */
	EReference getBelongsTo_Member();

	/**
	 * Returns the meta object for class '{@link org.js.graph.transformation.RemoveNode <em>Remove Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remove Node</em>'.
	 * @see org.js.graph.transformation.RemoveNode
	 * @generated
	 */
	EClass getRemoveNode();

	/**
	 * Returns the meta object for the reference list '{@link org.js.graph.transformation.RemoveNode#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Node</em>'.
	 * @see org.js.graph.transformation.RemoveNode#getNode()
	 * @see #getRemoveNode()
	 * @generated
	 */
	EReference getRemoveNode_Node();

	/**
	 * Returns the meta object for class '{@link org.js.graph.transformation.RemoveEdge <em>Remove Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remove Edge</em>'.
	 * @see org.js.graph.transformation.RemoveEdge
	 * @generated
	 */
	EClass getRemoveEdge();

	/**
	 * Returns the meta object for the reference list '{@link org.js.graph.transformation.RemoveEdge#getEdge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Edge</em>'.
	 * @see org.js.graph.transformation.RemoveEdge#getEdge()
	 * @see #getRemoveEdge()
	 * @generated
	 */
	EReference getRemoveEdge_Edge();

	/**
	 * Returns the meta object for class '{@link org.js.graph.transformation.AddEdge <em>Add Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Edge</em>'.
	 * @see org.js.graph.transformation.AddEdge
	 * @generated
	 */
	EClass getAddEdge();

	/**
	 * Returns the meta object for the containment reference list '{@link org.js.graph.transformation.AddEdge#getEdge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Edge</em>'.
	 * @see org.js.graph.transformation.AddEdge#getEdge()
	 * @see #getAddEdge()
	 * @generated
	 */
	EReference getAddEdge_Edge();

	/**
	 * Returns the meta object for class '{@link org.js.graph.transformation.AddNode <em>Add Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Node</em>'.
	 * @see org.js.graph.transformation.AddNode
	 * @generated
	 */
	EClass getAddNode();

	/**
	 * Returns the meta object for the containment reference list '{@link org.js.graph.transformation.AddNode#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Node</em>'.
	 * @see org.js.graph.transformation.AddNode#getNode()
	 * @see #getAddNode()
	 * @generated
	 */
	EReference getAddNode_Node();

	/**
	 * Returns the meta object for class '{@link org.js.graph.transformation.Nameable <em>Nameable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nameable</em>'.
	 * @see org.js.graph.transformation.Nameable
	 * @generated
	 */
	EClass getNameable();

	/**
	 * Returns the meta object for the attribute '{@link org.js.graph.transformation.Nameable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.js.graph.transformation.Nameable#getName()
	 * @see #getNameable()
	 * @generated
	 */
	EAttribute getNameable_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TransformationFactory getTransformationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.js.graph.transformation.impl.GraphTransformationImpl <em>Graph Transformation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.transformation.impl.GraphTransformationImpl
		 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getGraphTransformation()
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
		 * The meta object literal for the '{@link org.js.graph.transformation.impl.RuleImpl <em>Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.transformation.impl.RuleImpl
		 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getRule()
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
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__OPERATIONS = eINSTANCE.getRule_Operations();

		/**
		 * The meta object literal for the '{@link org.js.graph.transformation.impl.LeftSideImpl <em>Left Side</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.transformation.impl.LeftSideImpl
		 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getLeftSide()
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
		 * The meta object literal for the '{@link org.js.graph.transformation.impl.RolesImpl <em>Roles</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.transformation.impl.RolesImpl
		 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getRoles()
		 * @generated
		 */
		EClass ROLES = eINSTANCE.getRoles();

		/**
		 * The meta object literal for the '<em><b>Existing Roles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLES__EXISTING_ROLES = eINSTANCE.getRoles_ExistingRoles();

		/**
		 * The meta object literal for the '<em><b>Arriving Role</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLES__ARRIVING_ROLE = eINSTANCE.getRoles_ArrivingRole();

		/**
		 * The meta object literal for the '{@link org.js.graph.transformation.impl.ApplicationConditionsImpl <em>Application Conditions</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.transformation.impl.ApplicationConditionsImpl
		 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getApplicationConditions()
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
		 * The meta object literal for the '{@link org.js.graph.transformation.impl.OperationsImpl <em>Operations</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.transformation.impl.OperationsImpl
		 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getOperations()
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
		 * The meta object literal for the '{@link org.js.graph.transformation.Node <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.transformation.Node
		 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>In</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__IN = eINSTANCE.getNode_In();

		/**
		 * The meta object literal for the '<em><b>Out</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__OUT = eINSTANCE.getNode_Out();

		/**
		 * The meta object literal for the '{@link org.js.graph.transformation.impl.EdgeImpl <em>Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.transformation.impl.EdgeImpl
		 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getEdge()
		 * @generated
		 */
		EClass EDGE = eINSTANCE.getEdge();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__SOURCE = eINSTANCE.getEdge_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__TARGET = eINSTANCE.getEdge_Target();

		/**
		 * The meta object literal for the '{@link org.js.graph.transformation.impl.ExistingRoleImpl <em>Existing Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.transformation.impl.ExistingRoleImpl
		 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getExistingRole()
		 * @generated
		 */
		EClass EXISTING_ROLE = eINSTANCE.getExistingRole();

		/**
		 * The meta object literal for the '{@link org.js.graph.transformation.impl.ArrivingRoleImpl <em>Arriving Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.transformation.impl.ArrivingRoleImpl
		 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getArrivingRole()
		 * @generated
		 */
		EClass ARRIVING_ROLE = eINSTANCE.getArrivingRole();

		/**
		 * The meta object literal for the '{@link org.js.graph.transformation.Condition <em>Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.transformation.Condition
		 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getCondition()
		 * @generated
		 */
		EClass CONDITION = eINSTANCE.getCondition();

		/**
		 * The meta object literal for the '{@link org.js.graph.transformation.ChangePrimitive <em>Change Primitive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.transformation.ChangePrimitive
		 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getChangePrimitive()
		 * @generated
		 */
		EClass CHANGE_PRIMITIVE = eINSTANCE.getChangePrimitive();

		/**
		 * The meta object literal for the '{@link org.js.graph.transformation.impl.InitialImpl <em>Initial</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.transformation.impl.InitialImpl
		 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getInitial()
		 * @generated
		 */
		EClass INITIAL = eINSTANCE.getInitial();

		/**
		 * The meta object literal for the '{@link org.js.graph.transformation.impl.ActivityFinalImpl <em>Activity Final</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.transformation.impl.ActivityFinalImpl
		 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getActivityFinal()
		 * @generated
		 */
		EClass ACTIVITY_FINAL = eINSTANCE.getActivityFinal();

		/**
		 * The meta object literal for the '{@link org.js.graph.transformation.impl.FlowFinalImpl <em>Flow Final</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.transformation.impl.FlowFinalImpl
		 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getFlowFinal()
		 * @generated
		 */
		EClass FLOW_FINAL = eINSTANCE.getFlowFinal();

		/**
		 * The meta object literal for the '{@link org.js.graph.transformation.impl.ForkImpl <em>Fork</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.transformation.impl.ForkImpl
		 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getFork()
		 * @generated
		 */
		EClass FORK = eINSTANCE.getFork();

		/**
		 * The meta object literal for the '{@link org.js.graph.transformation.impl.SpecializationActionImpl <em>Specialization Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.transformation.impl.SpecializationActionImpl
		 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getSpecializationAction()
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
		 * The meta object literal for the '{@link org.js.graph.transformation.impl.IdleActionImpl <em>Idle Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.transformation.impl.IdleActionImpl
		 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getIdleAction()
		 * @generated
		 */
		EClass IDLE_ACTION = eINSTANCE.getIdleAction();

		/**
		 * The meta object literal for the '{@link org.js.graph.transformation.VariableRole <em>Variable Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.transformation.VariableRole
		 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getVariableRole()
		 * @generated
		 */
		EClass VARIABLE_ROLE = eINSTANCE.getVariableRole();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_ROLE__ACTION = eINSTANCE.getVariableRole_Action();

		/**
		 * The meta object literal for the '{@link org.js.graph.transformation.impl.InheritsFromImpl <em>Inherits From</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.transformation.impl.InheritsFromImpl
		 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getInheritsFrom()
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
		 * The meta object literal for the '{@link org.js.graph.transformation.impl.BelongsToImpl <em>Belongs To</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.transformation.impl.BelongsToImpl
		 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getBelongsTo()
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
		 * The meta object literal for the '{@link org.js.graph.transformation.impl.RemoveNodeImpl <em>Remove Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.transformation.impl.RemoveNodeImpl
		 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getRemoveNode()
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
		 * The meta object literal for the '{@link org.js.graph.transformation.impl.RemoveEdgeImpl <em>Remove Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.transformation.impl.RemoveEdgeImpl
		 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getRemoveEdge()
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
		 * The meta object literal for the '{@link org.js.graph.transformation.impl.AddEdgeImpl <em>Add Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.transformation.impl.AddEdgeImpl
		 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getAddEdge()
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
		 * The meta object literal for the '{@link org.js.graph.transformation.impl.AddNodeImpl <em>Add Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.transformation.impl.AddNodeImpl
		 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getAddNode()
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

		/**
		 * The meta object literal for the '{@link org.js.graph.transformation.Nameable <em>Nameable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.graph.transformation.Nameable
		 * @see org.js.graph.transformation.impl.TransformationPackageImpl#getNameable()
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

	}

} //TransformationPackage
