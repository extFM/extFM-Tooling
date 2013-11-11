package org.feature.multi.perspective.model.editor.editors;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.ui.MarkerHelper;
import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.emf.common.ui.editor.ProblemEditorPart;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.UnwrappingSelectionProvider;
import org.eclipse.emf.edit.ui.util.EditUIMarkerHelper;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.eclipse.zest.core.viewers.ZoomContributionViewItem;
import org.feature.model.utilities.GroupModelUtil;
import org.feature.multi.perspective.model.viewmodel.GroupModel;
import org.feature.multi.perspective.model.viewmodel.ViewPoint;
import org.feature.multi.perspective.model.viewmodel.ViewPointContainer;
import org.feature.multi.perspective.model.viewmodel.presentation.ViewmodelEditorPlugin;
import org.feature.multi.perspective.model.viewmodel.provider.ViewmodelItemProviderAdapterFactory;
import org.feature.multi.perspective.model.editor.editors.listeners.ChooseFMSelectionListener;
import org.feature.multi.perspective.model.editor.editors.listeners.ReloadMappingButtonListener;
import org.feature.multi.perspective.model.editor.editors.listeners.ViewPointComboSelectionListener;
import org.feature.multi.perspective.model.editor.zest.model.Node;
import org.feature.multi.perspective.model.editor.zest.model.NodeModelContentProvider;
import org.feature.multi.perspective.model.editor.zest.view.ZestView;

/**
 * MultiPage editor for a viewmodel and the mapping to a feature model
 * <ul>
 * <li>page 0 contains the TreeView for the groups
 * <li>page 1 contains a view for a specific {@link ViewPoint}
 * <li>page 2 shows the dependencies between the groups and the features by a specific featuremapping
 * </ul>
 * 
 * @author Tim Winkelmann
 */
public class ViewmodelMultiPageEditor extends MultiPageEditorPart implements IEditingDomainProvider, IMenuListener, ISelectionProvider {

   /**
    * This keeps track of the editing domain that is used to track all changes to the model. <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @generated
    */
   protected AdapterFactoryEditingDomain editingDomain;

   /**
    * This is the property sheet page. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected PropertySheetPage propertySheetPage;
   /**
    * This keeps track of the selection of the editor as a whole. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected ISelection editorSelection = StructuredSelection.EMPTY;
   /**
    * This is the one adapter factory used for providing views of the model. <!-- begin-user-doc --> <!-- end-user-doc
    * -->
    * 
    * @generated
    */
   protected ComposedAdapterFactory adapterFactory;
   /**
    * This keeps track of the active viewer pane, in the book. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected ViewerPane currentViewerPane;

   /**
    * This keeps track of the active content viewer, which may be either one of the viewers in the pages or the content
    * outline viewer. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected Viewer currentViewer;
   /**
    * This is the viewer that shadows the selection in the content outline. The parent relation must be correctly
    * defined for this to work. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected TreeViewer groupViewer;
   /**
    * This is the viewer that shadows the selection in the content outline. The parent relation must be correctly
    * defined for this to work. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected TreeViewer viewPointViewer;

   /**
    * This listens to which ever viewer is active. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected ISelectionChangedListener selectionChangedListener;

   /**
    * This keeps track of all the {@link org.eclipse.jface.viewers.ISelectionChangedListener}s that are listening to
    * this editor. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected Collection<ISelectionChangedListener> selectionChangedListeners = new ArrayList<ISelectionChangedListener>();

   /**
    * The MarkerHelper is responsible for creating workspace resource markers presented in Eclipse's Problems View. <!--
    * begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected MarkerHelper markerHelper = new EditUIMarkerHelper();
   /**
    * Map to store the diagnostic associated with a resource. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();

   /**
    * Controls whether the problem indication should be updated. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected boolean updateProblemIndication = true;

   /**
    * Resources that have been removed since last activation. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected Collection<Resource> removedResources = new ArrayList<Resource>();

   /**
    * Resources that have been changed since last activation. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected Collection<Resource> changedResources = new ArrayList<Resource>();
   /**
    * {@link ViewPoint} view composite for the tree
    */
   private Composite mainComposite = null;

   /**
    * model for the Zest view.
    */
   NodeModelContentProvider nodeModelContentProvider;
   /**
    * Resources that have been saved. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected Collection<Resource> savedResources = new ArrayList<Resource>();
   /**
    * This listens for workspace changes. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected IResourceChangeListener resourceChangeListener = new IResourceChangeListener() {

      public void resourceChanged(IResourceChangeEvent event) {
         IResourceDelta delta = event.getDelta();
         try {
            class ResourceDeltaVisitor implements IResourceDeltaVisitor {

               protected ResourceSet resourceSet = editingDomain.getResourceSet();
               protected Collection<Resource> changedResources = new ArrayList<Resource>();
               protected Collection<Resource> removedResources = new ArrayList<Resource>();

               public boolean visit(IResourceDelta delta) {
                  if (delta.getResource().getType() == IResource.FILE) {
                     if (delta.getKind() == IResourceDelta.REMOVED || delta.getKind() == IResourceDelta.CHANGED
                         && delta.getFlags() != IResourceDelta.MARKERS) {
                        Resource resource =
                           resourceSet.getResource(URI.createPlatformResourceURI(delta.getFullPath().toString(), true), false);
                        if (resource != null) {
                           if (delta.getKind() == IResourceDelta.REMOVED) {
                              removedResources.add(resource);
                           } else if (!savedResources.remove(resource)) {
                              changedResources.add(resource);
                           }
                        }
                     }
                  }

                  return true;
               }

               public Collection<Resource> getChangedResources() {
                  return changedResources;
               }

               public Collection<Resource> getRemovedResources() {
                  return removedResources;
               }
            }

            final ResourceDeltaVisitor visitor = new ResourceDeltaVisitor();
            delta.accept(visitor);

            if (!visitor.getRemovedResources().isEmpty()) {
               getSite().getShell().getDisplay().asyncExec(new Runnable() {

                  public void run() {
                     removedResources.addAll(visitor.getRemovedResources());
                     if (!isDirty()) {
                        getSite().getPage().closeEditor(ViewmodelMultiPageEditor.this, false);
                     }
                  }
               });
            }

            if (!visitor.getChangedResources().isEmpty()) {
               getSite().getShell().getDisplay().asyncExec(new Runnable() {

                  public void run() {
                     changedResources.addAll(visitor.getChangedResources());
                     if (getSite().getPage().getActiveEditor() == ViewmodelMultiPageEditor.this) {
                        handleActivate();
                     }
                  }
               });
            }
         } catch (CoreException exception) {
            MultiPageEditorPlugin.INSTANCE.log(exception);
         }
      }
   };
   /**
    * This listens for when the outline becomes active <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected IPartListener partListener = new IPartListener() {

      public void partActivated(IWorkbenchPart p) {
         if (p instanceof PropertySheet) {
            if (((PropertySheet) p).getCurrentPage() == propertySheetPage) {
               getActionBarContributor().setActiveEditor(ViewmodelMultiPageEditor.this);
               handleActivate();
            }
         } else if (p == ViewmodelMultiPageEditor.this) {
            handleActivate();
         }
      }

      public void partBroughtToTop(IWorkbenchPart p) {
         // Ignore.
      }

      public void partClosed(IWorkbenchPart p) {
         // Ignore.
      }

      public void partDeactivated(IWorkbenchPart p) {
         // Ignore.
      }

      public void partOpened(IWorkbenchPart p) {
         // Ignore.
      }
   };
   /**
    * Adapter used to update the problem indication when resources are demanded loaded. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @generated
    */
   protected EContentAdapter problemIndicationAdapter = new EContentAdapter() {

      @Override
      public void notifyChanged(Notification notification) {
         if (notification.getNotifier() instanceof Resource) {
            switch (notification.getFeatureID(Resource.class)) {
               case Resource.RESOURCE__IS_LOADED:
               case Resource.RESOURCE__ERRORS:
               case Resource.RESOURCE__WARNINGS: {
                  Resource resource = (Resource) notification.getNotifier();
                  Diagnostic diagnostic = analyzeResourceProblems(resource, null);
                  if (diagnostic.getSeverity() != Diagnostic.OK) {
                     resourceToDiagnosticMap.put(resource, diagnostic);
                  } else {
                     resourceToDiagnosticMap.remove(resource);
                  }

                  if (updateProblemIndication) {
                     getSite().getShell().getDisplay().asyncExec(new Runnable() {

                        public void run() {
                           updateProblemIndication();
                        }
                     });
                  }
                  break;
               }
            }
         } else {
            super.notifyChanged(notification);
         }
      }

      @Override
      protected void setTarget(Resource target) {
         basicSetTarget(target);
      }

      @Override
      protected void unsetTarget(Resource target) {
         basicUnsetTarget(target);
      }
   };

   private ViewPointContentProvider ViewPointContentProvider;

   private ZestView zestView;

   private Button refresh;

   private URI mappingResourcePath;
   private static Logger log = Logger.getLogger(ViewmodelMultiPageEditor.class);

   /**
    * Creates a multi-page editor example.
    */
   public ViewmodelMultiPageEditor() {
      super();
      initializeEditingDomain();
   }

   /**
    * This sets up the editing domain for the model editor. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected void initializeEditingDomain() {
      // Create an adapter factory that yields item providers.
      //
      adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

      adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
      adapterFactory.addAdapterFactory(new ViewmodelItemProviderAdapterFactory());
      adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

      // Create the command stack that will notify this editor as commands are executed.
      //
      BasicCommandStack commandStack = new BasicCommandStack();

      // Add a listener to set the most recent command's affected objects to be the selection of the viewer with focus.
      //
      commandStack.addCommandStackListener(new CommandStackListener() {

         public void commandStackChanged(final EventObject event) {
            getContainer().getDisplay().asyncExec(new Runnable() {

               public void run() {
                  firePropertyChange(IEditorPart.PROP_DIRTY);

                  // Try to select the affected objects.
                  //
                  Command mostRecentCommand = ((CommandStack) event.getSource()).getMostRecentCommand();
                  if (mostRecentCommand != null) {
                     setSelectionToViewer(mostRecentCommand.getAffectedObjects());
                  }
                  if (propertySheetPage != null && !propertySheetPage.getControl().isDisposed()) {
                     propertySheetPage.refresh();
                  }
               }
            });
         }
      });

      // Create the editing domain with a special command stack.
      //
      editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new HashMap<Resource, Boolean>());
   }

   /**
    * This accesses a cached version of the property sheet. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public IPropertySheetPage getPropertySheetPage() {
      if (propertySheetPage == null) {
         propertySheetPage = new ExtendedPropertySheetPage(editingDomain) {

            @Override
            public void setSelectionToViewer(List< ? > selection) {
               ViewmodelMultiPageEditor.this.setSelectionToViewer(selection);
               ViewmodelMultiPageEditor.this.setFocus();
            }

            @Override
            public void setActionBars(IActionBars actionBars) {
               super.setActionBars(actionBars);
               getActionBarContributor().shareGlobalActions(this, actionBars);
            }
         };
         propertySheetPage.setPropertySourceProvider(new AdapterFactoryContentProvider(adapterFactory));
      }

      return propertySheetPage;
   }

   /**
    * Handles activation of the editor or it's associated views. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected void handleActivate() {
      // Recompute the read only state.
      //
      if (editingDomain.getResourceToReadOnlyMap() != null) {
         editingDomain.getResourceToReadOnlyMap().clear();

         // Refresh any actions that may become enabled or disabled.
         //
         setSelection(getSelection());
      }

      if (!removedResources.isEmpty()) {
         if (handleDirtyConflict()) {
            getSite().getPage().closeEditor(ViewmodelMultiPageEditor.this, false);
         } else {
            removedResources.clear();
            changedResources.clear();
            savedResources.clear();
         }
      } else if (!changedResources.isEmpty()) {
         changedResources.removeAll(savedResources);
         handleChangedResources();
         changedResources.clear();
         savedResources.clear();
      }
   }

   /**
    * Handles what to do with changed resources on activation. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected void handleChangedResources() {
      if (!changedResources.isEmpty() && (!isDirty() || handleDirtyConflict())) {
         if (isDirty()) {
            changedResources.addAll(editingDomain.getResourceSet().getResources());
         }
         editingDomain.getCommandStack().flush();

         updateProblemIndication = false;
         for (Resource resource : changedResources) {
            if (resource.isLoaded()) {
               resource.unload();
               try {
                  resource.load(Collections.EMPTY_MAP);
               } catch (IOException exception) {
                  if (!resourceToDiagnosticMap.containsKey(resource)) {
                     resourceToDiagnosticMap.put(resource, analyzeResourceProblems(resource, exception));
                  }
               }
            }
         }

         if (AdapterFactoryEditingDomain.isStale(editorSelection)) {
            setSelection(StructuredSelection.EMPTY);
         }

         updateProblemIndication = true;
         updateProblemIndication();
      }
   }

   /**
    * This is for implementing {@link IEditorPart} and simply tests the command stack. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @generated
    */
   @Override
   public boolean isDirty() {
      return ((BasicCommandStack) editingDomain.getCommandStack()).isSaveNeeded();
   }

   /**
    * Shows a dialog that asks if conflicting changes should be discarded. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected boolean handleDirtyConflict() {
      return MessageDialog.openQuestion(getSite().getShell(), getString("_UI_FileConflict_label"), getString("_WARN_FileConflict"));
   }

   /**
    * This sets the selection into whichever viewer is active. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setSelectionToViewer(Collection< ? > collection) {
      final Collection< ? > theSelection = collection;
      // Make sure it's okay.
      //
      if (theSelection != null && !theSelection.isEmpty()) {
         Runnable runnable = new Runnable() {

            public void run() {
               // Try to select the items in the current content viewer of the editor.
               //
               if (currentViewer != null) {
                  currentViewer.setSelection(new StructuredSelection(theSelection.toArray()), true);
               }
            }
         };
         getSite().getShell().getDisplay().asyncExec(runnable);
      }
   }

   /**
    * Creates page 1 of the multi-page editor, which allows you to change the font used in page 2.
    */
   void createViewPointView() {
      Composite composite = new Composite(getContainer(), SWT.NONE);
      GridLayout bodyGridLayout = new GridLayout(1, false);
      composite.setLayout(bodyGridLayout);
      Composite topComposite = new Composite(composite, SWT.NONE);
      RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
      rowLayout.wrap = true;
      rowLayout.fill = false;
      rowLayout.pack = true;
      rowLayout.justify = false;
      topComposite.setLayout(rowLayout);
      Combo viewPointCombo = new Combo(topComposite, SWT.READ_ONLY);
      viewPointCombo.setItems(getViewPoints());
      viewPointCombo.addSelectionListener(new ViewPointComboSelectionListener(this));
      mainComposite = new Composite(composite, SWT.NONE);
      mainComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
      FillLayout layout = new FillLayout();
      mainComposite.setLayout(layout);
      ViewerPane viewerPane = new ViewerPane(getSite().getPage(), ViewmodelMultiPageEditor.this) {

         @Override
         public Viewer createViewer(Composite composite) {
            Tree tree = new Tree(composite, SWT.MULTI);
            TreeViewer newTreeViewer = new TreeViewer(tree);
            return newTreeViewer;
         }

         @Override
         public void requestActivation() {
            super.requestActivation();
            setCurrentViewerPane(this);
         }
      };
      viewerPane.createControl(mainComposite);

      viewPointViewer = (TreeViewer) viewerPane.getViewer();
      ViewPointContentProvider = new ViewPointContentProvider();
      viewPointViewer.setContentProvider(ViewPointContentProvider);
      viewPointViewer.setLabelProvider(new AdapterFactoryLabelProvider.FontProvider(adapterFactory, viewPointViewer));

      new AdapterFactoryTreeEditor(viewPointViewer.getTree(), adapterFactory);
      createContextMenuFor(viewPointViewer);
      int index = addPage(composite);
      setPageText(index, "ViewPoint View");
   }

   /**
    * This is how the framework determines which interfaces we implement. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   @SuppressWarnings("rawtypes")
   @Override
   public Object getAdapter(Class key) {
      if (key.equals(IPropertySheetPage.class)) {
         return getPropertySheetPage();
      } else {
         return super.getAdapter(key);
      }
   }

   /**
    * get the group model associated with this editor.
    * 
    * @return
    */
   public GroupModel getGroupModel() {
      GroupModel groupModel = null;
      EList<Resource> resources = editingDomain.getResourceSet().getResources();
      for (Resource resource : resources) {
         groupModel = GroupModelUtil.getGroupModel(resource);
         break;
      }
      return groupModel;
   }

   /**
    * returns the different names of the {@link ViewPoint} from the {@link GroupModel}.
    * 
    * @return the different names of the {@link ViewPoint} from the {@link GroupModel}.
    */
   private String[] getViewPoints() {
      List<String> viewPointNames = new LinkedList<String>();
      GroupModel model = getGroupModel();
      if (model != null){
      ViewPointContainer viewpointContainer = model.getViewPointContainer();
      if (viewpointContainer != null) {
         EList<ViewPoint> viewPoints = viewpointContainer.getViewPoints();
         for (ViewPoint viewPoint : viewPoints) {
            viewPointNames.add(viewPoint.getName());
         }
      }
      }
      String[] viewPointNamesArray = new String[viewPointNames.size()];
      int i = 0;
      for (Iterator<String> iterator = viewPointNames.iterator(); iterator.hasNext();) {
         String string = iterator.next();
         viewPointNamesArray[i] = string;
         i++;
      }
      return viewPointNamesArray;
   }

   /**
    * set the selected {@link ViewPoint} from the combo from the {@link ViewPoint} view.
    * 
    * @param viewPointName the name of a {@link ViewPoint}.
    */
   public void setSelectedViewPoint(String viewPointName) {
      TreeIterator<Notifier> allContents = editingDomain.getResourceSet().getAllContents();
      ViewPoint viewPoint = null;
      while (allContents.hasNext()) {
         Notifier notifier = allContents.next();
         if (notifier instanceof ViewPoint) {
            viewPoint = (ViewPoint) notifier;
            if (viewPointName.equals(viewPoint.getName())) {
               break;
            }
         }
      }
      setViewPoint(viewPoint);
   }

   /**
    * update the {@link ViewPoint} view.
    * 
    * @param viewPoint
    */
   public void setViewPoint(ViewPoint viewPoint) {
      if (viewPoint != null) {
         // build tree
         viewPointViewer.setInput(viewPoint);
         viewPointViewer.setSelection(new StructuredSelection(viewPoint), true);
      }
   }

   /**
    * Creates page 2 of the multi-page editor, which shows the sorted text.
    */
   void createViewmodelView() {
      Composite composite = new Composite(getContainer(), SWT.NONE);
      GridLayout bodyGridLayout = new GridLayout(1, false);
      composite.setLayout(bodyGridLayout);
      Composite topComposite = new Composite(composite, SWT.NONE);
      RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
      rowLayout.wrap = true;
      rowLayout.fill = false;
      rowLayout.pack = true;
      rowLayout.justify = false;
      topComposite.setLayout(rowLayout);
      Button chooseFM = new Button(topComposite, SWT.PUSH);
      chooseFM.setText("choose FeatureMapping");
      chooseFM.addSelectionListener(new ChooseFMSelectionListener(topComposite, this));
      refresh = new Button(topComposite, SWT.PUSH);
      refresh.setText("Reload");
      refresh.addSelectionListener(new ReloadMappingButtonListener(this));
      refresh.setEnabled(false);
      mainComposite = new Composite(composite, SWT.NONE);
      mainComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
      FillLayout layout = new FillLayout();
      mainComposite.setLayout(layout);

      zestView = new ZestView(getSite().getPage(), ViewmodelMultiPageEditor.this, mainComposite, this);
      zestView.createControl(mainComposite);
      fillToolBar();
      int index = addPage(composite);
      setPageText(index, "Multi-Perspective View");
   }

   /**
	 * 
	 */
   private void fillToolBar() {
      ZoomContributionViewItem toolbarZoomContributionViewItem = new ZoomContributionViewItem(zestView);
      IActionBars bars = getActionBars();
      bars.getMenuManager().add(toolbarZoomContributionViewItem);
   }

   /**
    * This looks up a string in plugin.properties, making a substitution. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   private static String getString(String key, Object s1) {
      return MultiPageEditorPlugin.INSTANCE.getString(key, new Object[] { s1 });
   }

   /**
    * Returns a diagnostic describing the errors and warnings listed in the resource and the specified exception (if
    * any). <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public Diagnostic analyzeResourceProblems(Resource resource, Exception exception) {
      if (!resource.getErrors().isEmpty() || !resource.getWarnings().isEmpty()) {
         BasicDiagnostic basicDiagnostic =
            new BasicDiagnostic(Diagnostic.ERROR, "org.feature.multi.perspective.model.editor", 0,
                                getString("_UI_CreateModelError_message", resource.getURI()), new Object[] { exception == null
                                      ? (Object) resource : exception });
         basicDiagnostic.merge(EcoreUtil.computeDiagnostic(resource, true));
         return basicDiagnostic;
      } else if (exception != null) {
         return new BasicDiagnostic(Diagnostic.ERROR, "org.feature.multi.perspective.model.editor", 0,
                                    getString("_UI_CreateModelError_message", resource.getURI()), new Object[] { exception });
      } else {
         return Diagnostic.OK_INSTANCE;
      }
   }

   /**
    * This is the method called to load a resource into the editing domain's resource set based on the editor's input.
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void createModel() {
      URI resourceURI = EditUIUtil.getURI(getEditorInput());
      Exception exception = null;
      Resource resource = null;
      try {
         // Load the resource through the editing domain.
         //
         resource = editingDomain.getResourceSet().getResource(resourceURI, true);
      } catch (Exception e) {
         exception = e;
         resource = editingDomain.getResourceSet().getResource(resourceURI, false);
      }

      Diagnostic diagnostic = analyzeResourceProblems(resource, exception);
      if (diagnostic.getSeverity() != Diagnostic.OK) {
         resourceToDiagnosticMap.put(resource, analyzeResourceProblems(resource, exception));
      }
      editingDomain.getResourceSet().eAdapters().add(problemIndicationAdapter);
   }

   /**
    * Creates the pages of the multi-page editor.
    */
   protected void createPages() {
      // Creates the model from the editor input
      createModel();
      // Only creates the other pages if there is something that can be edited
      if (!getEditingDomain().getResourceSet().getResources().isEmpty()) {
         createGroupView();
         createViewPointView();
         createViewmodelView();
      }
   }

   /**
    * creates the view for the group view
    */
   private void createGroupView() {
      ViewerPane viewerPane = new ViewerPane(getSite().getPage(), ViewmodelMultiPageEditor.this) {

         @Override
         public Viewer createViewer(Composite composite) {
            Tree tree = new Tree(composite, SWT.MULTI);
            TreeViewer newTreeViewer = new TreeViewer(tree);
            return newTreeViewer;
         }

         @Override
         public void requestActivation() {
            super.requestActivation();
            setCurrentViewerPane(this);
         }
      };
      viewerPane.createControl(getContainer());

      groupViewer = (TreeViewer) viewerPane.getViewer();
      groupViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));

      groupViewer.setLabelProvider(new AdapterFactoryLabelProvider.FontProvider(adapterFactory, groupViewer));
      GroupModel groupModel = getGroupModel();
      if (groupModel != null){
         groupViewer.setInput(groupModel.eResource());
      }
      //groupViewer.setInput(editingDomain.getResourceSet());
      groupViewer.setSelection(new StructuredSelection(editingDomain.getResourceSet().getResources().get(0)), true);

      new AdapterFactoryTreeEditor(groupViewer.getTree(), adapterFactory);

      createContextMenuFor(groupViewer);
      int pageIndex = addPage(viewerPane.getControl());
      setPageText(pageIndex, "Group View");
   }

   /**
    * This creates a context menu for the viewer and adds a listener as well registering the menu for extension. <!--
    * begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected void createContextMenuFor(StructuredViewer viewer) {
      MenuManager contextMenu = new MenuManager("#PopUp");
      contextMenu.add(new Separator("additions"));
      contextMenu.setRemoveAllWhenShown(true);
      contextMenu.addMenuListener(this);
      Menu menu = contextMenu.createContextMenu(viewer.getControl());
      viewer.getControl().setMenu(menu);
      getSite().registerContextMenu(contextMenu, new UnwrappingSelectionProvider(viewer));

      int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
      Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };
      viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(viewer));
      viewer.addDropSupport(dndOperations, transfers, new EditingDomainViewerDropAdapter(editingDomain, viewer));
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setCurrentViewerPane(ViewerPane viewerPane) {
      if (currentViewerPane != viewerPane) {
         if (currentViewerPane != null) {
            currentViewerPane.showFocus(false);
         }
         currentViewerPane = viewerPane;
      }
      setCurrentViewer(currentViewerPane.getViewer());
   }

   /**
    * This makes sure that one content viewer, either for the current page or the outline view, if it has focus, is the
    * current one. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setCurrentViewer(Viewer viewer) {
      // If it is changing...
      //
      if (currentViewer != viewer) {
         if (selectionChangedListener == null) {
            // Create the listener on demand.
            //
            selectionChangedListener = new ISelectionChangedListener() {

               // This just notifies those things that are affected by the section.
               //
               public void selectionChanged(SelectionChangedEvent selectionChangedEvent) {
                  setSelection(selectionChangedEvent.getSelection());
                  getEditorSite().getSelectionProvider().setSelection(selectionChangedEvent.getSelection());
               }
            };
         }

         // Stop listening to the old one.
         //
         if (currentViewer != null) {
            currentViewer.removeSelectionChangedListener(selectionChangedListener);
         }

         // Start listening to the new one.
         //
         if (viewer != null) {
            viewer.addSelectionChangedListener(selectionChangedListener);
         }

         // Remember it.
         //
         currentViewer = viewer;

         // Set the editors selection based on the current viewer's selection.
         //
         setSelection(currentViewer == null ? StructuredSelection.EMPTY : currentViewer.getSelection());
      }
   }

   /**
    * The <code>MultiPageEditorPart</code> implementation of this <code>IWorkbenchPart</code> method disposes all nested
    * editors. Subclasses may extend.
    */
   public void dispose() {
      // ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
      super.dispose();
   }

   /**
    * This is for implementing {@link IEditorPart} and simply saves the model file. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @generated
    */
   @Override
   public void doSave(IProgressMonitor progressMonitor) {
      // //
      // // Validate Model
      // Group[] groups = getAllGroups();
      // for (Group group : groups) {
      // GroupImpl.validateObject(group);
      // }

      // Save only resources that have actually changed.
      //
      final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
      saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);

      // Do the work within an operation because this is a long running activity that modifies the workbench.
      //
      WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {

         // This is the method that gets invoked when the operation runs.
         //
         @Override
         public void execute(IProgressMonitor monitor) {
            // Save the resources to the file system.
            //
            boolean first = true;
            for (Resource resource : editingDomain.getResourceSet().getResources()) {
               if ((first || !resource.getContents().isEmpty() || isPersisted(resource)) && !editingDomain.isReadOnly(resource)) {
                  try {
                     long timeStamp = resource.getTimeStamp();
                     resource.save(saveOptions);
                     if (resource.getTimeStamp() != timeStamp) {
                        savedResources.add(resource);
                     }
                  } catch (Exception exception) {
                     resourceToDiagnosticMap.put(resource, analyzeResourceProblems(resource, exception));
                  }
                  first = false;
               }
            }
         }
      };

      updateProblemIndication = false;
      try {
         // This runs the options, and shows progress.
         //
         new ProgressMonitorDialog(getSite().getShell()).run(true, false, operation);

         // Refresh the necessary state.
         //
         ((BasicCommandStack) editingDomain.getCommandStack()).saveIsDone();
         firePropertyChange(IEditorPart.PROP_DIRTY);
      } catch (Exception exception) {
         // Something went wrong that shouldn't.
         //
         ViewmodelEditorPlugin.INSTANCE.log(exception);
      }
      updateProblemIndication = true;
      updateProblemIndication();
   }

   /**
    * This returns whether something has been persisted to the URI of the specified resource. The implementation uses
    * the URI converter from the editor's resource set to try to open an input stream. <!-- begin-user-doc --> <!--
    * end-user-doc -->
    * 
    * @generated
    */
   protected boolean isPersisted(Resource resource) {
      boolean result = false;
      try {
         InputStream stream = editingDomain.getResourceSet().getURIConverter().createInputStream(resource.getURI());
         if (stream != null) {
            result = true;
            stream.close();
         }
      } catch (IOException e) {
         // Ignore
      }
      return result;
   }

   /**
    * This also changes the editor's input. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   @Override
   public void doSaveAs() {
      SaveAsDialog saveAsDialog = new SaveAsDialog(getSite().getShell());
      saveAsDialog.open();
      IPath path = saveAsDialog.getResult();
      if (path != null) {
         IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
         if (file != null) {
            doSaveAs(URI.createPlatformResourceURI(file.getFullPath().toString(), true), new FileEditorInput(file));
         }
      }
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected void doSaveAs(URI uri, IEditorInput editorInput) {
      (editingDomain.getResourceSet().getResources().get(0)).setURI(uri);
      setInputWithNotify(editorInput);
      setPartName(editorInput.getName());
      IProgressMonitor progressMonitor =
         getActionBars().getStatusLineManager() != null ? getActionBars().getStatusLineManager().getProgressMonitor()
               : new NullProgressMonitor();
      doSave(progressMonitor);
   }

   /*
    * (non-Javadoc) Method declared on IEditorPart
    */
   public void gotoMarker(IMarker marker) {
      setActivePage(0);
      IDE.gotoMarker(getEditor(0), marker);
   }

   /**
    * The <code>MultiPageEditorExample</code> implementation of this method checks that the input is an instance of
    * <code>IFileEditorInput</code>.
    */
   public void init(IEditorSite site, IEditorInput editorInput) throws PartInitException {
      setSite(site);
      setInputWithNotify(editorInput);
      setPartName(editorInput.getName());
      site.setSelectionProvider(this);
      site.getPage().addPartListener(partListener);
      ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener, IResourceChangeEvent.POST_CHANGE);
   }

   /*
    * (non-Javadoc) Method declared on IEditorPart.
    */
   public boolean isSaveAsAllowed() {
      return true;
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setStatusLineManager(ISelection selection) {
      IStatusLineManager statusLineManager = getActionBars().getStatusLineManager();

      if (statusLineManager != null) {
         if (selection instanceof IStructuredSelection) {
            Collection< ? > collection = ((IStructuredSelection) selection).toList();
            switch (collection.size()) {
               case 0: {
                  statusLineManager.setMessage(getString("_UI_NoObjectSelected"));
                  break;
               }
               case 1: {
                  String text = new AdapterFactoryItemDelegator(adapterFactory).getText(collection.iterator().next());
                  statusLineManager.setMessage(getString("_UI_SingleObjectSelected", text));
                  break;
               }
               default: {
                  statusLineManager.setMessage(getString("_UI_MultiObjectSelected", Integer.toString(collection.size())));
                  break;
               }
            }
         } else {
            statusLineManager.setMessage("");
         }
      }
   }

   /**
    * Updates the problems indication with the information described in the specified diagnostic. <!-- begin-user-doc
    * --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected void updateProblemIndication() {
      if (updateProblemIndication) {
         BasicDiagnostic diagnostic =
            new BasicDiagnostic(Diagnostic.OK, "org.feature.multi.perspective.model.editor", 0, null,
                                new Object[] { editingDomain.getResourceSet() });
         for (Diagnostic childDiagnostic : resourceToDiagnosticMap.values()) {
            if (childDiagnostic.getSeverity() != Diagnostic.OK) {
               diagnostic.add(childDiagnostic);
            }
         }

         int lastEditorPage = getPageCount() - 1;
         if (lastEditorPage >= 0 && getEditor(lastEditorPage) instanceof ProblemEditorPart) {
            ((ProblemEditorPart) getEditor(lastEditorPage)).setDiagnostic(diagnostic);
            if (diagnostic.getSeverity() != Diagnostic.OK) {
               setActivePage(lastEditorPage);
            }
         } else if (diagnostic.getSeverity() != Diagnostic.OK) {
            ProblemEditorPart problemEditorPart = new ProblemEditorPart();
            problemEditorPart.setDiagnostic(diagnostic);
            problemEditorPart.setMarkerHelper(markerHelper);
            try {
               addPage(++lastEditorPage, problemEditorPart, getEditorInput());
               setPageText(lastEditorPage, problemEditorPart.getPartName());
               setActivePage(lastEditorPage);
               showTabs();
            } catch (PartInitException exception) {
               MultiPageEditorPlugin.INSTANCE.log(exception);
            }
         }

         if (markerHelper.hasMarkers(editingDomain.getResourceSet())) {
            markerHelper.deleteMarkers(editingDomain.getResourceSet());
            if (diagnostic.getSeverity() != Diagnostic.OK) {
               try {
                  markerHelper.createMarkers(diagnostic);
               } catch (CoreException exception) {
                  MultiPageEditorPlugin.INSTANCE.log(exception);
               }
            }
         }
      }
   }

   /**
    * If there is more than one page in the multi-page editor part, this shows the tabs at the bottom. <!--
    * begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   protected void showTabs() {
      if (getPageCount() > 1) {
         setPageText(0, getString("_UI_SelectionPage_label"));
         if (getContainer() instanceof CTabFolder) {
            ((CTabFolder) getContainer()).setTabHeight(SWT.DEFAULT);
            Point point = getContainer().getSize();
            getContainer().setSize(point.x, point.y - 6);
         }
      }
   }

   /**
    * This looks up a string in the plugin's plugin.properties file. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   private static String getString(String key) {
      return MultiPageEditorPlugin.INSTANCE.getString(key);
   }

   /**
    * This returns the editing domain as required by the {@link IEditingDomainProvider} interface. This is important for
    * implementing the static methods of {@link AdapterFactoryEditingDomain} and for supporting
    * {@link org.eclipse.emf.edit.ui.action.CommandAction}. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EditingDomain getEditingDomain() {
      return editingDomain;
   }

   /**
    * This implements {@link org.eclipse.jface.viewers.ISelectionProvider} to set this editor's overall selection.
    * Calling this result will notify the listeners. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void setSelection(ISelection selection) {
      editorSelection = selection;

      for (ISelectionChangedListener listener : selectionChangedListeners) {
         listener.selectionChanged(new SelectionChangedEvent(this, selection));
      }
      setStatusLineManager(selection);
   }

   /**
    * This implements {@link org.eclipse.jface.action.IMenuListener} to help fill the context menus with contributions
    * from the Edit menu. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public void menuAboutToShow(IMenuManager menuManager) {
      ((IMenuListener) getEditorSite().getActionBarContributor()).menuAboutToShow(menuManager);
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public IActionBars getActionBars() {
      return getActionBarContributor().getActionBars();
   }

   /**
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public EditingDomainActionBarContributor getActionBarContributor() {
      return (EditingDomainActionBarContributor) getEditorSite().getActionBarContributor();
   }

   /**
    * This implements {@link org.eclipse.jface.viewers.ISelectionProvider}. <!-- begin-user-doc --> <!-- end-user-doc
    * -->
    * 
    * @generated
    */
   public void addSelectionChangedListener(ISelectionChangedListener listener) {
      selectionChangedListeners.add(listener);
   }

   /**
    * This implements {@link org.eclipse.jface.viewers.ISelectionProvider} to return this editor's overall selection.
    * <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated
    */
   public ISelection getSelection() {
      return editorSelection;
   }

   /**
    * This implements {@link org.eclipse.jface.viewers.ISelectionProvider}. <!-- begin-user-doc --> <!-- end-user-doc
    * -->
    * 
    * @generated
    */
   public void removeSelectionChangedListener(ISelectionChangedListener listener) {
      selectionChangedListeners.remove(listener);
   }

   private long mappingTimeStamp = -1;
   private URI mappingURI;
   private Resource mappingResource;

   /**
    * loads the mapping, build the graph and displays it.
    * 
    * @param mapping the mapping
    */
   public void setFeatureMapping(URI mapping) {
      if (mapping != null) {

         if (mappingResourcePath == null) {
            refresh.setEnabled(true);
         }
         mappingResourcePath = mapping;
         ResourceSet rst = getEditingDomain().getResourceSet();
         mappingResource = rst.getResource(mappingResourcePath, true);
         long timeStamp = mappingResource.getTimeStamp(); // compare timeStamp && URI with the one before
         if (mappingTimeStamp == -1) {
            mappingURI = mappingResourcePath;
            mappingTimeStamp = timeStamp;
            zestView.init(mappingResource);
         } else if (mappingResourcePath.equals(mappingURI) && mappingTimeStamp == timeStamp) {
            return;
         }
         mappingURI = mappingResourcePath;
         mappingTimeStamp = timeStamp;
         zestView.init(mappingResource);
      }
   }

   /**
    * highlight the nodes and connections.
    * 
    * @param nodesForHighlighting
    * @param connectionsForHighting
    */
   public void highlightNodes(List<Node> nodesForHighlighting) {
      zestView.highlightNodes(nodesForHighlighting);
   }

   /**
	 * 
	 */
   public void clearHighlighting() {
      zestView.clearHighlighting();
   }

   /**
    * creates a filteres feature model
    * 
    * @param viewPoint
    */
   public void createFilteredFeatureModel(ViewPoint viewPoint) {
      new FilteredFeatureModel(mappingResource, viewPoint, this);
   }

   /**
    * @return the mappingResource
    */
   public Resource getMappingResource() {
      return mappingResource;
   }

   /**
    * @return the mappingResourcePath
    */
   public URI getMappingResourcePath() {
      return mappingResourcePath;
   }
}
