/**
 */
package org.js.graph.transformation.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.js.graph.transformation.util.TransformationAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TransformationItemProviderAdapterFactory extends TransformationAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
    * This keeps track of the root adapter factory that delegates to this adapter factory.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
    * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
    * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
    * This constructs an instance.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public TransformationItemProviderAdapterFactory() {
      supportedTypes.add(IEditingDomainItemProvider.class);
      supportedTypes.add(IStructuredItemContentProvider.class);
      supportedTypes.add(ITreeItemContentProvider.class);
      supportedTypes.add(IItemLabelProvider.class);
      supportedTypes.add(IItemPropertySource.class);
   }

	/**
    * This keeps track of the one adapter used for all {@link org.js.graph.transformation.GraphTransformation} instances.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected GraphTransformationItemProvider graphTransformationItemProvider;

	/**
    * This creates an adapter for a {@link org.js.graph.transformation.GraphTransformation}.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Adapter createGraphTransformationAdapter() {
      if (graphTransformationItemProvider == null) {
         graphTransformationItemProvider = new GraphTransformationItemProvider(this);
      }

      return graphTransformationItemProvider;
   }

	/**
    * This keeps track of the one adapter used for all {@link org.js.graph.transformation.Rule} instances.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected RuleItemProvider ruleItemProvider;

	/**
    * This creates an adapter for a {@link org.js.graph.transformation.Rule}.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Adapter createRuleAdapter() {
      if (ruleItemProvider == null) {
         ruleItemProvider = new RuleItemProvider(this);
      }

      return ruleItemProvider;
   }

	/**
    * This keeps track of the one adapter used for all {@link org.js.graph.transformation.LeftSide} instances.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected LeftSideItemProvider leftSideItemProvider;

	/**
    * This creates an adapter for a {@link org.js.graph.transformation.LeftSide}.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Adapter createLeftSideAdapter() {
      if (leftSideItemProvider == null) {
         leftSideItemProvider = new LeftSideItemProvider(this);
      }

      return leftSideItemProvider;
   }

	/**
    * This keeps track of the one adapter used for all {@link org.js.graph.transformation.Roles} instances.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected RolesItemProvider rolesItemProvider;

	/**
    * This creates an adapter for a {@link org.js.graph.transformation.Roles}.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Adapter createRolesAdapter() {
      if (rolesItemProvider == null) {
         rolesItemProvider = new RolesItemProvider(this);
      }

      return rolesItemProvider;
   }

	/**
    * This keeps track of the one adapter used for all {@link org.js.graph.transformation.ApplicationConditions} instances.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected ApplicationConditionsItemProvider applicationConditionsItemProvider;

	/**
    * This creates an adapter for a {@link org.js.graph.transformation.ApplicationConditions}.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Adapter createApplicationConditionsAdapter() {
      if (applicationConditionsItemProvider == null) {
         applicationConditionsItemProvider = new ApplicationConditionsItemProvider(this);
      }

      return applicationConditionsItemProvider;
   }

	/**
    * This keeps track of the one adapter used for all {@link org.js.graph.transformation.Operations} instances.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected OperationsItemProvider operationsItemProvider;

	/**
    * This creates an adapter for a {@link org.js.graph.transformation.Operations}.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Adapter createOperationsAdapter() {
      if (operationsItemProvider == null) {
         operationsItemProvider = new OperationsItemProvider(this);
      }

      return operationsItemProvider;
   }

	/**
    * This keeps track of the one adapter used for all {@link org.js.graph.transformation.Edge} instances.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected EdgeItemProvider edgeItemProvider;

	/**
    * This creates an adapter for a {@link org.js.graph.transformation.Edge}.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Adapter createEdgeAdapter() {
      if (edgeItemProvider == null) {
         edgeItemProvider = new EdgeItemProvider(this);
      }

      return edgeItemProvider;
   }

	/**
    * This keeps track of the one adapter used for all {@link org.js.graph.transformation.ExistingRole} instances.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected ExistingRoleItemProvider existingRoleItemProvider;

	/**
    * This creates an adapter for a {@link org.js.graph.transformation.ExistingRole}.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Adapter createExistingRoleAdapter() {
      if (existingRoleItemProvider == null) {
         existingRoleItemProvider = new ExistingRoleItemProvider(this);
      }

      return existingRoleItemProvider;
   }

	/**
    * This keeps track of the one adapter used for all {@link org.js.graph.transformation.ArrivingRole} instances.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected ArrivingRoleItemProvider arrivingRoleItemProvider;

	/**
    * This creates an adapter for a {@link org.js.graph.transformation.ArrivingRole}.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Adapter createArrivingRoleAdapter() {
      if (arrivingRoleItemProvider == null) {
         arrivingRoleItemProvider = new ArrivingRoleItemProvider(this);
      }

      return arrivingRoleItemProvider;
   }

	/**
    * This keeps track of the one adapter used for all {@link org.js.graph.transformation.Initial} instances.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected InitialItemProvider initialItemProvider;

	/**
    * This creates an adapter for a {@link org.js.graph.transformation.Initial}.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Adapter createInitialAdapter() {
      if (initialItemProvider == null) {
         initialItemProvider = new InitialItemProvider(this);
      }

      return initialItemProvider;
   }

	/**
    * This keeps track of the one adapter used for all {@link org.js.graph.transformation.ActivityFinal} instances.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected ActivityFinalItemProvider activityFinalItemProvider;

	/**
    * This creates an adapter for a {@link org.js.graph.transformation.ActivityFinal}.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Adapter createActivityFinalAdapter() {
      if (activityFinalItemProvider == null) {
         activityFinalItemProvider = new ActivityFinalItemProvider(this);
      }

      return activityFinalItemProvider;
   }

	/**
    * This keeps track of the one adapter used for all {@link org.js.graph.transformation.FlowFinal} instances.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected FlowFinalItemProvider flowFinalItemProvider;

	/**
    * This creates an adapter for a {@link org.js.graph.transformation.FlowFinal}.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Adapter createFlowFinalAdapter() {
      if (flowFinalItemProvider == null) {
         flowFinalItemProvider = new FlowFinalItemProvider(this);
      }

      return flowFinalItemProvider;
   }

	/**
    * This keeps track of the one adapter used for all {@link org.js.graph.transformation.Fork} instances.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected ForkItemProvider forkItemProvider;

	/**
    * This creates an adapter for a {@link org.js.graph.transformation.Fork}.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Adapter createForkAdapter() {
      if (forkItemProvider == null) {
         forkItemProvider = new ForkItemProvider(this);
      }

      return forkItemProvider;
   }

	/**
    * This keeps track of the one adapter used for all {@link org.js.graph.transformation.SpecializationAction} instances.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected SpecializationActionItemProvider specializationActionItemProvider;

	/**
    * This creates an adapter for a {@link org.js.graph.transformation.SpecializationAction}.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Adapter createSpecializationActionAdapter() {
      if (specializationActionItemProvider == null) {
         specializationActionItemProvider = new SpecializationActionItemProvider(this);
      }

      return specializationActionItemProvider;
   }

	/**
    * This keeps track of the one adapter used for all {@link org.js.graph.transformation.IdleAction} instances.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected IdleActionItemProvider idleActionItemProvider;

	/**
    * This creates an adapter for a {@link org.js.graph.transformation.IdleAction}.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Adapter createIdleActionAdapter() {
      if (idleActionItemProvider == null) {
         idleActionItemProvider = new IdleActionItemProvider(this);
      }

      return idleActionItemProvider;
   }

	/**
    * This keeps track of the one adapter used for all {@link org.js.graph.transformation.InheritsFrom} instances.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected InheritsFromItemProvider inheritsFromItemProvider;

	/**
    * This creates an adapter for a {@link org.js.graph.transformation.InheritsFrom}.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Adapter createInheritsFromAdapter() {
      if (inheritsFromItemProvider == null) {
         inheritsFromItemProvider = new InheritsFromItemProvider(this);
      }

      return inheritsFromItemProvider;
   }

	/**
    * This keeps track of the one adapter used for all {@link org.js.graph.transformation.BelongsTo} instances.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected BelongsToItemProvider belongsToItemProvider;

	/**
    * This creates an adapter for a {@link org.js.graph.transformation.BelongsTo}.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Adapter createBelongsToAdapter() {
      if (belongsToItemProvider == null) {
         belongsToItemProvider = new BelongsToItemProvider(this);
      }

      return belongsToItemProvider;
   }

	/**
    * This keeps track of the one adapter used for all {@link org.js.graph.transformation.RemoveNodes} instances.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected RemoveNodesItemProvider removeNodesItemProvider;

	/**
    * This creates an adapter for a {@link org.js.graph.transformation.RemoveNodes}.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Adapter createRemoveNodesAdapter() {
      if (removeNodesItemProvider == null) {
         removeNodesItemProvider = new RemoveNodesItemProvider(this);
      }

      return removeNodesItemProvider;
   }

	/**
    * This keeps track of the one adapter used for all {@link org.js.graph.transformation.RemoveEdges} instances.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected RemoveEdgesItemProvider removeEdgesItemProvider;

	/**
    * This creates an adapter for a {@link org.js.graph.transformation.RemoveEdges}.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Adapter createRemoveEdgesAdapter() {
      if (removeEdgesItemProvider == null) {
         removeEdgesItemProvider = new RemoveEdgesItemProvider(this);
      }

      return removeEdgesItemProvider;
   }

	/**
    * This keeps track of the one adapter used for all {@link org.js.graph.transformation.AddEdges} instances.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected AddEdgesItemProvider addEdgesItemProvider;

	/**
    * This creates an adapter for a {@link org.js.graph.transformation.AddEdges}.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Adapter createAddEdgesAdapter() {
      if (addEdgesItemProvider == null) {
         addEdgesItemProvider = new AddEdgesItemProvider(this);
      }

      return addEdgesItemProvider;
   }

	/**
    * This keeps track of the one adapter used for all {@link org.js.graph.transformation.AddNodes} instances.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected AddNodesItemProvider addNodesItemProvider;

	/**
    * This creates an adapter for a {@link org.js.graph.transformation.AddNodes}.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Adapter createAddNodesAdapter() {
      if (addNodesItemProvider == null) {
         addNodesItemProvider = new AddNodesItemProvider(this);
      }

      return addNodesItemProvider;
   }

	/**
    * This returns the root adapter factory that contains this factory.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public ComposeableAdapterFactory getRootAdapterFactory() {
      return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
   }

	/**
    * This sets the composed adapter factory that contains this factory.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
      this.parentAdapterFactory = parentAdapterFactory;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public boolean isFactoryForType(Object type) {
      return supportedTypes.contains(type) || super.isFactoryForType(type);
   }

	/**
    * This implementation substitutes the factory itself as the key for the adapter.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
      return super.adapt(notifier, this);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Object adapt(Object object, Object type) {
      if (isFactoryForType(type)) {
         Object adapter = super.adapt(object, type);
         if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
            return adapter;
         }
      }

      return null;
   }

	/**
    * This adds a listener.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public void addListener(INotifyChangedListener notifyChangedListener) {
      changeNotifier.addListener(notifyChangedListener);
   }

	/**
    * This removes a listener.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
      changeNotifier.removeListener(notifyChangedListener);
   }

	/**
    * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public void fireNotifyChanged(Notification notification) {
      changeNotifier.fireNotifyChanged(notification);

      if (parentAdapterFactory != null) {
         parentAdapterFactory.fireNotifyChanged(notification);
      }
   }

	/**
    * This disposes all of the item providers created by this factory. 
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public void dispose() {
      if (graphTransformationItemProvider != null) graphTransformationItemProvider.dispose();
      if (ruleItemProvider != null) ruleItemProvider.dispose();
      if (leftSideItemProvider != null) leftSideItemProvider.dispose();
      if (rolesItemProvider != null) rolesItemProvider.dispose();
      if (applicationConditionsItemProvider != null) applicationConditionsItemProvider.dispose();
      if (operationsItemProvider != null) operationsItemProvider.dispose();
      if (edgeItemProvider != null) edgeItemProvider.dispose();
      if (existingRoleItemProvider != null) existingRoleItemProvider.dispose();
      if (arrivingRoleItemProvider != null) arrivingRoleItemProvider.dispose();
      if (initialItemProvider != null) initialItemProvider.dispose();
      if (activityFinalItemProvider != null) activityFinalItemProvider.dispose();
      if (flowFinalItemProvider != null) flowFinalItemProvider.dispose();
      if (forkItemProvider != null) forkItemProvider.dispose();
      if (specializationActionItemProvider != null) specializationActionItemProvider.dispose();
      if (idleActionItemProvider != null) idleActionItemProvider.dispose();
      if (inheritsFromItemProvider != null) inheritsFromItemProvider.dispose();
      if (belongsToItemProvider != null) belongsToItemProvider.dispose();
      if (removeNodesItemProvider != null) removeNodesItemProvider.dispose();
      if (removeEdgesItemProvider != null) removeEdgesItemProvider.dispose();
      if (addEdgesItemProvider != null) addEdgesItemProvider.dispose();
      if (addNodesItemProvider != null) addNodesItemProvider.dispose();
   }

}
