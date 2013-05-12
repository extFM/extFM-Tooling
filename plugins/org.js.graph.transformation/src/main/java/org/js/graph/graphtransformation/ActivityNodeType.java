/**
 */
package org.js.graph.graphtransformation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Activity Node Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.js.graph.graphtransformation.GraphtransformationPackage#getActivityNodeType()
 * @model
 * @generated
 */
public enum ActivityNodeType implements Enumerator {
	/**
	 * The '<em><b>Initial Nodel</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INITIAL_NODEL_VALUE
	 * @generated
	 * @ordered
	 */
	INITIAL_NODEL(0, "InitialNodel", "InitialNodel"),

	/**
	 * The '<em><b>Fork Node</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FORK_NODE_VALUE
	 * @generated
	 * @ordered
	 */
	FORK_NODE(1, "ForkNode", "ForkNode"),

	/**
	 * The '<em><b>Specialization Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPECIALIZATION_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	SPECIALIZATION_ACTION(2, "SpecializationAction", "SpecializationAction"),

	/**
	 * The '<em><b>Idle Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IDLE_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	IDLE_ACTION(3, "IdleAction", "IdleAction"),

	/**
	 * The '<em><b>Activity Final Node</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACTIVITY_FINAL_NODE_VALUE
	 * @generated
	 * @ordered
	 */
	ACTIVITY_FINAL_NODE(4, "ActivityFinalNode", "ActivityFinalNode"),

	/**
	 * The '<em><b>Flow Final Node</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLOW_FINAL_NODE_VALUE
	 * @generated
	 * @ordered
	 */
	FLOW_FINAL_NODE(5, "FlowFinalNode", "FlowFinalNode");

	/**
	 * The '<em><b>Initial Nodel</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Initial Nodel</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INITIAL_NODEL
	 * @model name="InitialNodel"
	 * @generated
	 * @ordered
	 */
	public static final int INITIAL_NODEL_VALUE = 0;

	/**
	 * The '<em><b>Fork Node</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Fork Node</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FORK_NODE
	 * @model name="ForkNode"
	 * @generated
	 * @ordered
	 */
	public static final int FORK_NODE_VALUE = 1;

	/**
	 * The '<em><b>Specialization Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Specialization Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SPECIALIZATION_ACTION
	 * @model name="SpecializationAction"
	 * @generated
	 * @ordered
	 */
	public static final int SPECIALIZATION_ACTION_VALUE = 2;

	/**
	 * The '<em><b>Idle Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Idle Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IDLE_ACTION
	 * @model name="IdleAction"
	 * @generated
	 * @ordered
	 */
	public static final int IDLE_ACTION_VALUE = 3;

	/**
	 * The '<em><b>Activity Final Node</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Activity Final Node</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACTIVITY_FINAL_NODE
	 * @model name="ActivityFinalNode"
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVITY_FINAL_NODE_VALUE = 4;

	/**
	 * The '<em><b>Flow Final Node</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Flow Final Node</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FLOW_FINAL_NODE
	 * @model name="FlowFinalNode"
	 * @generated
	 * @ordered
	 */
	public static final int FLOW_FINAL_NODE_VALUE = 5;

	/**
	 * An array of all the '<em><b>Activity Node Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ActivityNodeType[] VALUES_ARRAY =
		new ActivityNodeType[] {
			INITIAL_NODEL,
			FORK_NODE,
			SPECIALIZATION_ACTION,
			IDLE_ACTION,
			ACTIVITY_FINAL_NODE,
			FLOW_FINAL_NODE,
		};

	/**
	 * A public read-only list of all the '<em><b>Activity Node Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ActivityNodeType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Activity Node Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ActivityNodeType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ActivityNodeType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Activity Node Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ActivityNodeType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ActivityNodeType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Activity Node Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ActivityNodeType get(int value) {
		switch (value) {
			case INITIAL_NODEL_VALUE: return INITIAL_NODEL;
			case FORK_NODE_VALUE: return FORK_NODE;
			case SPECIALIZATION_ACTION_VALUE: return SPECIALIZATION_ACTION;
			case IDLE_ACTION_VALUE: return IDLE_ACTION;
			case ACTIVITY_FINAL_NODE_VALUE: return ACTIVITY_FINAL_NODE;
			case FLOW_FINAL_NODE_VALUE: return FLOW_FINAL_NODE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ActivityNodeType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ActivityNodeType
