/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.mopp;

public class ExpressionResource extends org.eclipse.emf.ecore.resource.impl.ResourceImpl implements org.emftext.term.propositional.expression.resource.expression.IExpressionTextResource {
	
	public class ElementBasedTextDiagnostic implements org.emftext.term.propositional.expression.resource.expression.IExpressionTextDiagnostic {
		
		private final org.emftext.term.propositional.expression.resource.expression.IExpressionLocationMap locationMap;
		private final org.eclipse.emf.common.util.URI uri;
		private final org.eclipse.emf.ecore.EObject element;
		private final org.emftext.term.propositional.expression.resource.expression.IExpressionProblem problem;
		
		public ElementBasedTextDiagnostic(org.emftext.term.propositional.expression.resource.expression.IExpressionLocationMap locationMap, org.eclipse.emf.common.util.URI uri, org.emftext.term.propositional.expression.resource.expression.IExpressionProblem problem, org.eclipse.emf.ecore.EObject element) {
			super();
			this.uri = uri;
			this.locationMap = locationMap;
			this.element = element;
			this.problem = problem;
		}
		
		public String getMessage() {
			return problem.getMessage();
		}
		
		public org.emftext.term.propositional.expression.resource.expression.IExpressionProblem getProblem() {
			return problem;
		}
		
		public String getLocation() {
			return uri.toString();
		}
		
		public int getCharStart() {
			return Math.max(0, locationMap.getCharStart(element));
		}
		
		public int getCharEnd() {
			return Math.max(0, locationMap.getCharEnd(element));
		}
		
		public int getColumn() {
			return Math.max(0, locationMap.getColumn(element));
		}
		
		public int getLine() {
			return Math.max(0, locationMap.getLine(element));
		}
		
		public org.eclipse.emf.ecore.EObject getElement() {
			return element;
		}
		
		public boolean wasCausedBy(org.eclipse.emf.ecore.EObject element) {
			if (this.element == null) {
				return false;
			}
			return this.element.equals(element);
		}
		
		public String toString() {
			return getMessage() + " at " + getLocation() + " line " + getLine() + ", column " + getColumn();
		}
	}
	
	public class PositionBasedTextDiagnostic implements org.emftext.term.propositional.expression.resource.expression.IExpressionTextDiagnostic {
		
		private final org.eclipse.emf.common.util.URI uri;
		
		private int column;
		private int line;
		private int charStart;
		private int charEnd;
		private org.emftext.term.propositional.expression.resource.expression.IExpressionProblem problem;
		
		public PositionBasedTextDiagnostic(org.eclipse.emf.common.util.URI uri, org.emftext.term.propositional.expression.resource.expression.IExpressionProblem problem, int column, int line, int charStart, int charEnd) {
			
			super();
			this.uri = uri;
			this.column = column;
			this.line = line;
			this.charStart = charStart;
			this.charEnd = charEnd;
			this.problem = problem;
		}
		
		public org.emftext.term.propositional.expression.resource.expression.IExpressionProblem getProblem() {
			return problem;
		}
		
		public int getCharStart() {
			return charStart;
		}
		
		public int getCharEnd() {
			return charEnd;
		}
		
		public int getColumn() {
			return column;
		}
		
		public int getLine() {
			return line;
		}
		
		public String getLocation() {
			return uri.toString();
		}
		
		public String getMessage() {
			return problem.getMessage();
		}
		
		public boolean wasCausedBy(org.eclipse.emf.ecore.EObject element) {
			return false;
		}
		
		public String toString() {
			return getMessage() + " at " + getLocation() + " line " + getLine() + ", column " + getColumn();
		}
	}
	
	private org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolverSwitch resolverSwitch;
	private org.emftext.term.propositional.expression.resource.expression.IExpressionLocationMap locationMap;
	private int proxyCounter = 0;
	private org.emftext.term.propositional.expression.resource.expression.IExpressionTextParser parser;
	private org.emftext.term.propositional.expression.resource.expression.util.ExpressionLayoutUtil layoutUtil = new org.emftext.term.propositional.expression.resource.expression.util.ExpressionLayoutUtil();
	private org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionMarkerHelper markerHelper;
	private java.util.Map<String, org.emftext.term.propositional.expression.resource.expression.IExpressionContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject>> internalURIFragmentMap = new java.util.LinkedHashMap<String, org.emftext.term.propositional.expression.resource.expression.IExpressionContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject>>();
	private java.util.Map<String, org.emftext.term.propositional.expression.resource.expression.IExpressionQuickFix> quickFixMap = new java.util.LinkedHashMap<String, org.emftext.term.propositional.expression.resource.expression.IExpressionQuickFix>();
	private java.util.Map<?, ?> loadOptions;
	
	/**
	 * If a post-processor is currently running, this field holds a reference to it.
	 * This reference is used to terminate post-processing if needed.
	 */
	private org.emftext.term.propositional.expression.resource.expression.IExpressionResourcePostProcessor runningPostProcessor;
	
	/**
	 * A flag (and lock) to indicate whether reloading of the resource shall be
	 * cancelled.
	 */
	private Boolean terminateReload = false;
	private Object terminateReloadLock = new Object();
	private Object loadingLock = new Object();
	private boolean delayNotifications = false;
	private java.util.List<org.eclipse.emf.common.notify.Notification> delayedNotifications = new java.util.ArrayList<org.eclipse.emf.common.notify.Notification>();
	private java.io.InputStream latestReloadInputStream = null;
	private java.util.Map<?, ?> latestReloadOptions = null;
	private org.emftext.term.propositional.expression.resource.expression.util.ExpressionInterruptibleEcoreResolver interruptibleResolver;
	
	protected org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionMetaInformation metaInformation = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionMetaInformation();
	
	public ExpressionResource() {
		super();
		resetLocationMap();
	}
	
	public ExpressionResource(org.eclipse.emf.common.util.URI uri) {
		super(uri);
		resetLocationMap();
	}
	
	protected void doLoad(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {
		synchronized (loadingLock) {
			if (processTerminationRequested()) {
				return;
			}
			this.loadOptions = options;
			delayNotifications = true;
			resetLocationMap();
			String encoding = getEncoding(options);
			java.io.InputStream actualInputStream = inputStream;
			Object inputStreamPreProcessorProvider = null;
			if (options != null) {
				inputStreamPreProcessorProvider = options.get(org.emftext.term.propositional.expression.resource.expression.IExpressionOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER);
			}
			if (inputStreamPreProcessorProvider != null) {
				if (inputStreamPreProcessorProvider instanceof org.emftext.term.propositional.expression.resource.expression.IExpressionInputStreamProcessorProvider) {
					org.emftext.term.propositional.expression.resource.expression.IExpressionInputStreamProcessorProvider provider = (org.emftext.term.propositional.expression.resource.expression.IExpressionInputStreamProcessorProvider) inputStreamPreProcessorProvider;
					org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionInputStreamProcessor processor = provider.getInputStreamProcessor(inputStream);
					actualInputStream = processor;
				}
			}
			
			parser = getMetaInformation().createParser(actualInputStream, encoding);
			parser.setOptions(options);
			org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
			referenceResolverSwitch.setOptions(options);
			org.emftext.term.propositional.expression.resource.expression.IExpressionParseResult result = parser.parse();
			// dispose parser, we don't need it anymore
			parser = null;
			
			if (processTerminationRequested()) {
				// do nothing if reload was already restarted
				return;
			}
			
			clearState();
			getContentsInternal().clear();
			org.eclipse.emf.ecore.EObject root = null;
			if (result != null) {
				root = result.getRoot();
				if (root != null) {
					if (isLayoutInformationRecordingEnabled()) {
						layoutUtil.transferAllLayoutInformationToModel(root);
					}
					if (processTerminationRequested()) {
						// the next reload will add new content
						return;
					}
					getContentsInternal().add(root);
				}
				java.util.Collection<org.emftext.term.propositional.expression.resource.expression.IExpressionCommand<org.emftext.term.propositional.expression.resource.expression.IExpressionTextResource>> commands = result.getPostParseCommands();
				if (commands != null) {
					for (org.emftext.term.propositional.expression.resource.expression.IExpressionCommand<org.emftext.term.propositional.expression.resource.expression.IExpressionTextResource>  command : commands) {
						command.execute(this);
					}
				}
			}
			getReferenceResolverSwitch().setOptions(options);
			if (getErrors().isEmpty()) {
				if (!runPostProcessors(options)) {
					return;
				}
				if (root != null) {
					runValidators(root);
				}
			}
			notifyDelayed();
		}
	}
	
	protected boolean processTerminationRequested() {
		if (terminateReload) {
			delayNotifications = false;
			delayedNotifications.clear();
			return true;
		}
		return false;
	}
	protected void notifyDelayed() {
		delayNotifications = false;
		for (org.eclipse.emf.common.notify.Notification delayedNotification : delayedNotifications) {
			super.eNotify(delayedNotification);
		}
		delayedNotifications.clear();
	}
	public void eNotify(org.eclipse.emf.common.notify.Notification notification) {
		if (delayNotifications) {
			delayedNotifications.add(notification);
		} else {
			super.eNotify(notification);
		}
	}
	/**
	 * Reloads the contents of this resource from the given stream.
	 */
	public void reload(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {
		synchronized (terminateReloadLock) {
			latestReloadInputStream = inputStream;
			latestReloadOptions = options;
			if (terminateReload == true) {
				// //reload already requested
			}
			terminateReload = true;
		}
		cancelReload();
		synchronized (loadingLock) {
			synchronized (terminateReloadLock) {
				terminateReload = false;
			}
			isLoaded = false;
			java.util.Map<Object, Object> loadOptions = addDefaultLoadOptions(latestReloadOptions);
			try {
				doLoad(latestReloadInputStream, loadOptions);
			} catch (org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionTerminateParsingException tpe) {
				// do nothing - the resource is left unchanged if this exception is thrown
			}
			resolveAfterParsing();
			isLoaded = true;
		}
	}
	
	/**
	 * Cancels reloading this resource. The running parser and post processors are
	 * terminated.
	 */
	protected void cancelReload() {
		// Cancel parser
		org.emftext.term.propositional.expression.resource.expression.IExpressionTextParser parserCopy = parser;
		if (parserCopy != null) {
			parserCopy.terminate();
		}
		// Cancel post processor(s)
		org.emftext.term.propositional.expression.resource.expression.IExpressionResourcePostProcessor runningPostProcessorCopy = runningPostProcessor;
		if (runningPostProcessorCopy != null) {
			runningPostProcessorCopy.terminate();
		}
		// Cancel reference resolving
		org.emftext.term.propositional.expression.resource.expression.util.ExpressionInterruptibleEcoreResolver interruptibleResolverCopy = interruptibleResolver;
		if (interruptibleResolverCopy != null) {
			interruptibleResolverCopy.terminate();
		}
	}
	
	protected void doSave(java.io.OutputStream outputStream, java.util.Map<?,?> options) throws java.io.IOException {
		org.emftext.term.propositional.expression.resource.expression.IExpressionTextPrinter printer = getMetaInformation().createPrinter(outputStream, this);
		org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
		printer.setEncoding(getEncoding(options));
		referenceResolverSwitch.setOptions(options);
		for (org.eclipse.emf.ecore.EObject root : getContentsInternal()) {
			if (isLayoutInformationRecordingEnabled()) {
				layoutUtil.transferAllLayoutInformationFromModel(root);
			}
			printer.print(root);
			if (isLayoutInformationRecordingEnabled()) {
				layoutUtil.transferAllLayoutInformationToModel(root);
			}
		}
	}
	
	protected String getSyntaxName() {
		return "expression";
	}
	
	public String getEncoding(java.util.Map<?, ?> options) {
		String encoding = null;
		if (new org.emftext.term.propositional.expression.resource.expression.util.ExpressionRuntimeUtil().isEclipsePlatformAvailable()) {
			encoding = new org.emftext.term.propositional.expression.resource.expression.util.ExpressionEclipseProxy().getPlatformResourceEncoding(uri);
		}
		if (options != null) {
			Object encodingOption = options.get(org.emftext.term.propositional.expression.resource.expression.IExpressionOptions.OPTION_ENCODING);
			if (encodingOption != null) {
				encoding = encodingOption.toString();
			}
		}
		return encoding;
	}
	
	public org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolverSwitch getReferenceResolverSwitch() {
		if (resolverSwitch == null) {
			resolverSwitch = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionReferenceResolverSwitch();
		}
		return resolverSwitch;
	}
	
	public org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionMetaInformation getMetaInformation() {
		return new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionMetaInformation();
	}
	
	/**
	 * Clears the location map by replacing it with a new instance.
	 */
	protected void resetLocationMap() {
		if (isLocationMapEnabled()) {
			locationMap = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLocationMap();
		} else {
			locationMap = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionDevNullLocationMap();
		}
	}
	
	public void addURIFragment(String internalURIFragment, org.emftext.term.propositional.expression.resource.expression.IExpressionContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment) {
		internalURIFragmentMap.put(internalURIFragment, uriFragment);
	}
	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> void registerContextDependentProxy(org.emftext.term.propositional.expression.resource.expression.IExpressionContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory, ContainerType container, org.eclipse.emf.ecore.EReference reference, String id, org.eclipse.emf.ecore.EObject proxyElement, int position) {
		org.eclipse.emf.ecore.InternalEObject proxy = (org.eclipse.emf.ecore.InternalEObject) proxyElement;
		String internalURIFragment = org.emftext.term.propositional.expression.resource.expression.IExpressionContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX + (proxyCounter++) + "_" + id;
		org.emftext.term.propositional.expression.resource.expression.IExpressionContextDependentURIFragment<?> uriFragment = factory.create(id, container, reference, position, proxy);
		proxy.eSetProxyURI(getURI().appendFragment(internalURIFragment));
		addURIFragment(internalURIFragment, uriFragment);
	}
	
	public org.eclipse.emf.ecore.EObject getEObject(String id) {
		if (internalURIFragmentMap.containsKey(id)) {
			org.emftext.term.propositional.expression.resource.expression.IExpressionContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment = internalURIFragmentMap.get(id);
			boolean wasResolvedBefore = uriFragment.isResolved();
			org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolveResult<? extends org.eclipse.emf.ecore.EObject> result = null;
			// catch and report all Exceptions that occur during proxy resolving
			try {
				result = uriFragment.resolve();
			} catch (Exception e) {
				String message = "An expection occured while resolving the proxy for: "+ id + ". (" + e.toString() + ")";
				addProblem(new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionProblem(message, org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemType.UNRESOLVED_REFERENCE, org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemSeverity.ERROR), uriFragment.getProxy());
				new org.emftext.term.propositional.expression.resource.expression.util.ExpressionRuntimeUtil().logError(message, e);
			}
			if (result == null) {
				// the resolving did call itself
				return null;
			}
			if (!wasResolvedBefore && !result.wasResolved()) {
				attachResolveError(result, uriFragment.getProxy());
				return null;
			} else if (!result.wasResolved()) {
				return null;
			} else {
				org.eclipse.emf.ecore.EObject proxy = uriFragment.getProxy();
				// remove an error that might have been added by an earlier attempt
				removeDiagnostics(proxy, getErrors());
				// remove old warnings and attach new
				removeDiagnostics(proxy, getWarnings());
				attachResolveWarnings(result, proxy);
				org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping = result.getMappings().iterator().next();
				org.eclipse.emf.ecore.EObject resultElement = getResultElement(uriFragment, mapping, proxy, result.getErrorMessage());
				org.eclipse.emf.ecore.EObject container = uriFragment.getContainer();
				replaceProxyInLayoutAdapters(container, proxy, resultElement);
				return resultElement;
			}
		} else {
			return super.getEObject(id);
		}
	}
	
	protected void replaceProxyInLayoutAdapters(org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EObject proxy, org.eclipse.emf.ecore.EObject target) {
		for (org.eclipse.emf.common.notify.Adapter adapter : container.eAdapters()) {
			if (adapter instanceof org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformationAdapter) {
				org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformationAdapter layoutInformationAdapter = (org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformationAdapter) adapter;
				layoutInformationAdapter.replaceProxy(proxy, target);
			}
		}
	}
	
	protected org.eclipse.emf.ecore.EObject getResultElement(org.emftext.term.propositional.expression.resource.expression.IExpressionContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment, org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping, org.eclipse.emf.ecore.EObject proxy, final String errorMessage) {
		if (mapping instanceof org.emftext.term.propositional.expression.resource.expression.IExpressionURIMapping<?>) {
			org.eclipse.emf.common.util.URI uri = ((org.emftext.term.propositional.expression.resource.expression.IExpressionURIMapping<? extends org.eclipse.emf.ecore.EObject>)mapping).getTargetIdentifier();
			if (uri != null) {
				org.eclipse.emf.ecore.EObject result = null;
				try {
					result = this.getResourceSet().getEObject(uri, true);
				} catch (Exception e) {
					// we can catch exceptions here, because EMF will try to resolve again and handle
					// the exception
				}
				if (result == null || result.eIsProxy()) {
					// unable to resolve: attach error
					if (errorMessage == null) {
						assert(false);
					} else {
						addProblem(new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionProblem(errorMessage, org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemType.UNRESOLVED_REFERENCE, org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemSeverity.ERROR), proxy);
					}
				}
				return result;
			}
			return null;
		} else if (mapping instanceof org.emftext.term.propositional.expression.resource.expression.IExpressionElementMapping<?>) {
			org.eclipse.emf.ecore.EObject element = ((org.emftext.term.propositional.expression.resource.expression.IExpressionElementMapping<? extends org.eclipse.emf.ecore.EObject>)mapping).getTargetElement();
			org.eclipse.emf.ecore.EReference reference = uriFragment.getReference();
			org.eclipse.emf.ecore.EReference oppositeReference = uriFragment.getReference().getEOpposite();
			if (!uriFragment.getReference().isContainment() && oppositeReference != null) {
				if (reference.isMany()) {
					org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList.ManyInverse<org.eclipse.emf.ecore.EObject> list = org.emftext.term.propositional.expression.resource.expression.util.ExpressionCastUtil.cast(element.eGet(oppositeReference, false));										// avoids duplicate entries in the reference caused by adding to the
					// oppositeReference
					list.basicAdd(uriFragment.getContainer(),null);
				} else {
					uriFragment.getContainer().eSet(uriFragment.getReference(), element);
				}
			}
			return element;
		} else {
			assert(false);
			return null;
		}
	}
	
	protected void removeDiagnostics(org.eclipse.emf.ecore.EObject cause, java.util.List<org.eclipse.emf.ecore.resource.Resource.Diagnostic> diagnostics) {
		// remove all errors/warnings from this resource
		for (org.eclipse.emf.ecore.resource.Resource.Diagnostic errorCand : new org.eclipse.emf.common.util.BasicEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(diagnostics)) {
			if (errorCand instanceof org.emftext.term.propositional.expression.resource.expression.IExpressionTextDiagnostic) {
				if (((org.emftext.term.propositional.expression.resource.expression.IExpressionTextDiagnostic) errorCand).wasCausedBy(cause)) {
					diagnostics.remove(errorCand);
					unmark(cause);
				}
			}
		}
	}
	
	protected void attachResolveError(org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolveResult<?> result, org.eclipse.emf.ecore.EObject proxy) {
		// attach errors to this resource
		assert result != null;
		final String errorMessage = result.getErrorMessage();
		if (errorMessage == null) {
			assert(false);
		} else {
			addProblem(new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionProblem(errorMessage, org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemType.UNRESOLVED_REFERENCE, org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemSeverity.ERROR, result.getQuickFixes()), proxy);
		}
	}
	
	protected void attachResolveWarnings(org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolveResult<? extends org.eclipse.emf.ecore.EObject> result, org.eclipse.emf.ecore.EObject proxy) {
		assert result != null;
		assert result.wasResolved();
		if (result.wasResolved()) {
			for (org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping : result.getMappings()) {
				final String warningMessage = mapping.getWarning();
				if (warningMessage == null) {
					continue;
				}
				addProblem(new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionProblem(warningMessage, org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemType.UNRESOLVED_REFERENCE, org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemSeverity.WARNING), proxy);
			}
		}
	}
	
	/**
	 * Extends the super implementation by clearing all information about element
	 * positions.
	 */
	protected void doUnload() {
		super.doUnload();
		clearState();
		loadOptions = null;
	}
	
	/**
	 * Runs all post processors to process this resource.
	 */
	protected boolean runPostProcessors(java.util.Map<?, ?> loadOptions) {
		unmark(org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemType.ANALYSIS_PROBLEM);
		if (processTerminationRequested()) {
			return false;
		}
		// first, run the generated post processor
		runPostProcessor(new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionResourcePostProcessor());
		if (loadOptions == null) {
			return true;
		}
		// then, run post processors that are registered via the load options extension
		// point
		Object resourcePostProcessorProvider = loadOptions.get(org.emftext.term.propositional.expression.resource.expression.IExpressionOptions.RESOURCE_POSTPROCESSOR_PROVIDER);
		if (resourcePostProcessorProvider != null) {
			if (resourcePostProcessorProvider instanceof org.emftext.term.propositional.expression.resource.expression.IExpressionResourcePostProcessorProvider) {
				runPostProcessor(((org.emftext.term.propositional.expression.resource.expression.IExpressionResourcePostProcessorProvider) resourcePostProcessorProvider).getResourcePostProcessor());
			} else if (resourcePostProcessorProvider instanceof java.util.Collection<?>) {
				java.util.Collection<?> resourcePostProcessorProviderCollection = (java.util.Collection<?>) resourcePostProcessorProvider;
				for (Object processorProvider : resourcePostProcessorProviderCollection) {
					if (processTerminationRequested()) {
						return false;
					}
					if (processorProvider instanceof org.emftext.term.propositional.expression.resource.expression.IExpressionResourcePostProcessorProvider) {
						org.emftext.term.propositional.expression.resource.expression.IExpressionResourcePostProcessorProvider csProcessorProvider = (org.emftext.term.propositional.expression.resource.expression.IExpressionResourcePostProcessorProvider) processorProvider;
						org.emftext.term.propositional.expression.resource.expression.IExpressionResourcePostProcessor postProcessor = csProcessorProvider.getResourcePostProcessor();
						runPostProcessor(postProcessor);
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * Runs the given post processor to process this resource.
	 */
	protected void runPostProcessor(org.emftext.term.propositional.expression.resource.expression.IExpressionResourcePostProcessor postProcessor) {
		try {
			this.runningPostProcessor = postProcessor;
			postProcessor.process(this);
		} catch (Exception e) {
			new org.emftext.term.propositional.expression.resource.expression.util.ExpressionRuntimeUtil().logError("Exception while running a post-processor.", e);
		}
		this.runningPostProcessor = null;
	}
	
	public void load(java.util.Map<?, ?> options) throws java.io.IOException {
		java.util.Map<Object, Object> loadOptions = addDefaultLoadOptions(options);
		super.load(loadOptions);
		resolveAfterParsing();
	}
	
	protected void resolveAfterParsing() {
		interruptibleResolver = new org.emftext.term.propositional.expression.resource.expression.util.ExpressionInterruptibleEcoreResolver();
		interruptibleResolver.resolveAll(this);
		interruptibleResolver = null;
	}
	
	public void setURI(org.eclipse.emf.common.util.URI uri) {
		// because of the context dependent proxy resolving it is essential to resolve all
		// proxies before the URI is changed which can cause loss of object identities
		org.eclipse.emf.ecore.util.EcoreUtil.resolveAll(this);
		super.setURI(uri);
	}
	
	/**
	 * Returns the location map that contains information about the position of the
	 * contents of this resource in the original textual representation.
	 */
	public org.emftext.term.propositional.expression.resource.expression.IExpressionLocationMap getLocationMap() {
		return locationMap;
	}
	
	public void addProblem(org.emftext.term.propositional.expression.resource.expression.IExpressionProblem problem, org.eclipse.emf.ecore.EObject element) {
		ElementBasedTextDiagnostic diagnostic = new ElementBasedTextDiagnostic(locationMap, getURI(), problem, element);
		getDiagnostics(problem.getSeverity()).add(diagnostic);
		mark(diagnostic);
		addQuickFixesToQuickFixMap(problem);
	}
	
	public void addProblem(org.emftext.term.propositional.expression.resource.expression.IExpressionProblem problem, int column, int line, int charStart, int charEnd) {
		PositionBasedTextDiagnostic diagnostic = new PositionBasedTextDiagnostic(getURI(), problem, column, line, charStart, charEnd);
		getDiagnostics(problem.getSeverity()).add(diagnostic);
		mark(diagnostic);
		addQuickFixesToQuickFixMap(problem);
	}
	
	protected void addQuickFixesToQuickFixMap(org.emftext.term.propositional.expression.resource.expression.IExpressionProblem problem) {
		java.util.Collection<org.emftext.term.propositional.expression.resource.expression.IExpressionQuickFix> quickFixes = problem.getQuickFixes();
		if (quickFixes != null) {
			for (org.emftext.term.propositional.expression.resource.expression.IExpressionQuickFix quickFix : quickFixes) {
				if (quickFix != null) {
					quickFixMap.put(quickFix.getContextAsString(), quickFix);
				}
			}
		}
	}
	
	@Deprecated	
	public void addError(String message, org.eclipse.emf.ecore.EObject cause) {
		addError(message, org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemType.UNKNOWN, cause);
	}
	
	public void addError(String message, org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemType type, org.eclipse.emf.ecore.EObject cause) {
		addProblem(new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionProblem(message, type, org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemSeverity.ERROR), cause);
	}
	
	@Deprecated	
	public void addWarning(String message, org.eclipse.emf.ecore.EObject cause) {
		addWarning(message, org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemType.UNKNOWN, cause);
	}
	
	public void addWarning(String message, org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemType type, org.eclipse.emf.ecore.EObject cause) {
		addProblem(new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionProblem(message, type, org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemSeverity.WARNING), cause);
	}
	
	protected java.util.List<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getDiagnostics(org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemSeverity severity) {
		if (severity == org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemSeverity.ERROR) {
			return getErrors();
		} else {
			return getWarnings();
		}
	}
	
	protected java.util.Map<Object, Object> addDefaultLoadOptions(java.util.Map<?, ?> loadOptions) {
		java.util.Map<Object, Object> loadOptionsCopy = org.emftext.term.propositional.expression.resource.expression.util.ExpressionMapUtil.copySafelyToObjectToObjectMap(loadOptions);
		// first add static option provider
		loadOptionsCopy.putAll(new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionOptionProvider().getOptions());
		
		// second, add dynamic option providers that are registered via extension
		if (new org.emftext.term.propositional.expression.resource.expression.util.ExpressionRuntimeUtil().isEclipsePlatformAvailable()) {
			new org.emftext.term.propositional.expression.resource.expression.util.ExpressionEclipseProxy().getDefaultLoadOptionProviderExtensions(loadOptionsCopy);
		}
		return loadOptionsCopy;
	}
	
	/**
	 * Extends the super implementation by clearing all information about element
	 * positions.
	 */
	protected void clearState() {
		// clear concrete syntax information
		resetLocationMap();
		internalURIFragmentMap.clear();
		getErrors().clear();
		getWarnings().clear();
		unmark(org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemType.UNKNOWN);
		unmark(org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemType.SYNTAX_ERROR);
		unmark(org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemType.UNRESOLVED_REFERENCE);
		proxyCounter = 0;
		resolverSwitch = null;
	}
	
	/**
	 * Returns a copy of the contents of this resource wrapped in a list that
	 * propagates changes to the original resource list. Wrapping is required to make
	 * sure that clients which obtain a reference to the list of contents do not
	 * interfere when changing the list.
	 */
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.EObject> getContents() {
		if (terminateReload) {
			// the contents' state is currently unclear
			return new org.eclipse.emf.common.util.BasicEList<org.eclipse.emf.ecore.EObject>();
		}
		return new org.emftext.term.propositional.expression.resource.expression.util.ExpressionCopiedEObjectInternalEList((org.eclipse.emf.ecore.util.InternalEList<org.eclipse.emf.ecore.EObject>) super.getContents());
	}
	
	/**
	 * Returns the raw contents of this resource. In contrast to getContents(), this
	 * methods does not return a copy of the content list, but the original list.
	 */
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.EObject> getContentsInternal() {
		if (terminateReload) {
			// the contents' state is currently unclear
			return new org.eclipse.emf.common.util.BasicEList<org.eclipse.emf.ecore.EObject>();
		}
		return super.getContents();
	}
	
	/**
	 * Returns all warnings that are associated with this resource.
	 */
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getWarnings() {
		if (terminateReload) {
			// the contents' state is currently unclear
			return new org.eclipse.emf.common.util.BasicEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>();
		}
		return new org.emftext.term.propositional.expression.resource.expression.util.ExpressionCopiedEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(super.getWarnings());
	}
	
	/**
	 * Returns all errors that are associated with this resource.
	 */
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getErrors() {
		if (terminateReload) {
			// the contents' state is currently unclear
			return new org.eclipse.emf.common.util.BasicEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>();
		}
		return new org.emftext.term.propositional.expression.resource.expression.util.ExpressionCopiedEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(super.getErrors());
	}
	
	protected void runValidators(org.eclipse.emf.ecore.EObject root) {
		// checking constraints provided by EMF validator classes was disabled by option
		// 'disableEValidators'.
		
		if (new org.emftext.term.propositional.expression.resource.expression.util.ExpressionRuntimeUtil().isEclipsePlatformAvailable()) {
			new org.emftext.term.propositional.expression.resource.expression.util.ExpressionEclipseProxy().checkEMFValidationConstraints(this, root);
		}
	}
	
	public org.emftext.term.propositional.expression.resource.expression.IExpressionQuickFix getQuickFix(String quickFixContext) {
		return quickFixMap.get(quickFixContext);
	}
	
	protected void mark(org.emftext.term.propositional.expression.resource.expression.IExpressionTextDiagnostic diagnostic) {
		org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionMarkerHelper markerHelper = getMarkerHelper();
		if (markerHelper != null) {
			markerHelper.mark(this, diagnostic);
		}
	}
	
	protected void unmark(org.eclipse.emf.ecore.EObject cause) {
		org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionMarkerHelper markerHelper = getMarkerHelper();
		if (markerHelper != null) {
			markerHelper.unmark(this, cause);
		}
	}
	
	protected void unmark(org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemType analysisProblem) {
		org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionMarkerHelper markerHelper = getMarkerHelper();
		if (markerHelper != null) {
			markerHelper.unmark(this, analysisProblem);
		}
	}
	
	protected org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionMarkerHelper getMarkerHelper() {
		if (isMarkerCreationEnabled() && new org.emftext.term.propositional.expression.resource.expression.util.ExpressionRuntimeUtil().isEclipsePlatformAvailable()) {
			if (markerHelper == null) {
				markerHelper = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionMarkerHelper();
			}
			return markerHelper;
		}
		return null;
	}
	
	public boolean isMarkerCreationEnabled() {
		if (loadOptions == null) {
			return true;
		}
		return !loadOptions.containsKey(org.emftext.term.propositional.expression.resource.expression.IExpressionOptions.DISABLE_CREATING_MARKERS_FOR_PROBLEMS);
	}
	
	protected boolean isLocationMapEnabled() {
		if (loadOptions == null) {
			return true;
		}
		return !loadOptions.containsKey(org.emftext.term.propositional.expression.resource.expression.IExpressionOptions.DISABLE_LOCATION_MAP);
	}
	
	protected boolean isLayoutInformationRecordingEnabled() {
		if (loadOptions == null) {
			return true;
		}
		return !loadOptions.containsKey(org.emftext.term.propositional.expression.resource.expression.IExpressionOptions.DISABLE_LAYOUT_INFORMATION_RECORDING);
	}
	
}
