/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;

public class MtextResource extends org.eclipse.emf.ecore.resource.impl.ResourceImpl implements org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextResource {
	
	public class ElementBasedTextDiagnostic implements org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextDiagnostic {
		
		private final org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextLocationMap locationMap;
		private final org.eclipse.emf.common.util.URI uri;
		private final org.eclipse.emf.ecore.EObject element;
		private final org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextProblem problem;
		
		public ElementBasedTextDiagnostic(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextLocationMap locationMap, org.eclipse.emf.common.util.URI uri, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextProblem problem, org.eclipse.emf.ecore.EObject element) {
			super();
			this.uri = uri;
			this.locationMap = locationMap;
			this.element = element;
			this.problem = problem;
		}
		
		public String getMessage() {
			return problem.getMessage();
		}
		
		public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextProblem getProblem() {
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
	
	public class PositionBasedTextDiagnostic implements org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextDiagnostic {
		
		private final org.eclipse.emf.common.util.URI uri;
		
		private int column;
		private int line;
		private int charStart;
		private int charEnd;
		private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextProblem problem;
		
		public PositionBasedTextDiagnostic(org.eclipse.emf.common.util.URI uri, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextProblem problem, int column, int line, int charStart, int charEnd) {
			
			super();
			this.uri = uri;
			this.column = column;
			this.line = line;
			this.charStart = charStart;
			this.charEnd = charEnd;
			this.problem = problem;
		}
		
		public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextProblem getProblem() {
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
	
	private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolverSwitch resolverSwitch;
	private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextLocationMap locationMap;
	private int proxyCounter = 0;
	private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextParser parser;
	private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextLayoutUtil layoutUtil = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextLayoutUtil();
	private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextMarkerHelper markerHelper;
	private java.util.Map<String, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject>> internalURIFragmentMap = new java.util.LinkedHashMap<String, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject>>();
	private java.util.Map<String, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextQuickFix> quickFixMap = new java.util.LinkedHashMap<String, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextQuickFix>();
	private java.util.Map<?, ?> loadOptions;
	
	/**
	 * If a post-processor is currently running, this field holds a reference to it.
	 * This reference is used to terminate post-processing if needed.
	 */
	private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextResourcePostProcessor runningPostProcessor;
	
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
	private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextInterruptibleEcoreResolver interruptibleResolver;
	
	protected org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextMetaInformation metaInformation = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextMetaInformation();
	
	public MtextResource() {
		super();
		resetLocationMap();
	}
	
	public MtextResource(org.eclipse.emf.common.util.URI uri) {
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
				inputStreamPreProcessorProvider = options.get(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER);
			}
			if (inputStreamPreProcessorProvider != null) {
				if (inputStreamPreProcessorProvider instanceof org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextInputStreamProcessorProvider) {
					org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextInputStreamProcessorProvider provider = (org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextInputStreamProcessorProvider) inputStreamPreProcessorProvider;
					org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextInputStreamProcessor processor = provider.getInputStreamProcessor(inputStream);
					actualInputStream = processor;
				}
			}
			
			parser = getMetaInformation().createParser(actualInputStream, encoding);
			parser.setOptions(options);
			org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
			referenceResolverSwitch.setOptions(options);
			org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextParseResult result = parser.parse();
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
				java.util.Collection<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextCommand<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextResource>> commands = result.getPostParseCommands();
				if (commands != null) {
					for (org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextCommand<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextResource>  command : commands) {
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
			} catch (org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextTerminateParsingException tpe) {
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
		org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextParser parserCopy = parser;
		if (parserCopy != null) {
			parserCopy.terminate();
		}
		// Cancel post processor(s)
		org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextResourcePostProcessor runningPostProcessorCopy = runningPostProcessor;
		if (runningPostProcessorCopy != null) {
			runningPostProcessorCopy.terminate();
		}
		// Cancel reference resolving
		org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextInterruptibleEcoreResolver interruptibleResolverCopy = interruptibleResolver;
		if (interruptibleResolverCopy != null) {
			interruptibleResolverCopy.terminate();
		}
	}
	
	protected void doSave(java.io.OutputStream outputStream, java.util.Map<?,?> options) throws java.io.IOException {
		org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextPrinter printer = getMetaInformation().createPrinter(outputStream, this);
		org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolverSwitch referenceResolverSwitch = getReferenceResolverSwitch();
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
		return "mtext";
	}
	
	public String getEncoding(java.util.Map<?, ?> options) {
		String encoding = null;
		if (new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextRuntimeUtil().isEclipsePlatformAvailable()) {
			encoding = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextEclipseProxy().getPlatformResourceEncoding(uri);
		}
		if (options != null) {
			Object encodingOption = options.get(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextOptions.OPTION_ENCODING);
			if (encodingOption != null) {
				encoding = encodingOption.toString();
			}
		}
		return encoding;
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolverSwitch getReferenceResolverSwitch() {
		if (resolverSwitch == null) {
			resolverSwitch = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextReferenceResolverSwitch();
		}
		return resolverSwitch;
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextMetaInformation getMetaInformation() {
		return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextMetaInformation();
	}
	
	/**
	 * Clears the location map by replacing it with a new instance.
	 */
	protected void resetLocationMap() {
		if (isLocationMapEnabled()) {
			locationMap = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextLocationMap();
		} else {
			locationMap = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextDevNullLocationMap();
		}
	}
	
	public void addURIFragment(String internalURIFragment, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment) {
		internalURIFragmentMap.put(internalURIFragment, uriFragment);
	}
	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> void registerContextDependentProxy(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory, ContainerType container, org.eclipse.emf.ecore.EReference reference, String id, org.eclipse.emf.ecore.EObject proxyElement, int position) {
		org.eclipse.emf.ecore.InternalEObject proxy = (org.eclipse.emf.ecore.InternalEObject) proxyElement;
		String internalURIFragment = org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX + (proxyCounter++) + "_" + id;
		org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextContextDependentURIFragment<?> uriFragment = factory.create(id, container, reference, position, proxy);
		proxy.eSetProxyURI(getURI().appendFragment(internalURIFragment));
		addURIFragment(internalURIFragment, uriFragment);
	}
	
	public org.eclipse.emf.ecore.EObject getEObject(String id) {
		if (internalURIFragmentMap.containsKey(id)) {
			org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment = internalURIFragmentMap.get(id);
			boolean wasResolvedBefore = uriFragment.isResolved();
			org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolveResult<? extends org.eclipse.emf.ecore.EObject> result = null;
			// catch and report all Exceptions that occur during proxy resolving
			try {
				result = uriFragment.resolve();
			} catch (Exception e) {
				String message = "An expection occured while resolving the proxy for: "+ id + ". (" + e.toString() + ")";
				addProblem(new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextProblem(message, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemType.UNRESOLVED_REFERENCE, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemSeverity.ERROR), uriFragment.getProxy());
				new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextRuntimeUtil().logError(message, e);
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
				org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping = result.getMappings().iterator().next();
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
			if (adapter instanceof org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextLayoutInformationAdapter) {
				org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextLayoutInformationAdapter layoutInformationAdapter = (org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextLayoutInformationAdapter) adapter;
				layoutInformationAdapter.replaceProxy(proxy, target);
			}
		}
	}
	
	protected org.eclipse.emf.ecore.EObject getResultElement(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextContextDependentURIFragment<? extends org.eclipse.emf.ecore.EObject> uriFragment, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping, org.eclipse.emf.ecore.EObject proxy, final String errorMessage) {
		if (mapping instanceof org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextURIMapping<?>) {
			org.eclipse.emf.common.util.URI uri = ((org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextURIMapping<? extends org.eclipse.emf.ecore.EObject>)mapping).getTargetIdentifier();
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
						addProblem(new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextProblem(errorMessage, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemType.UNRESOLVED_REFERENCE, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemSeverity.ERROR), proxy);
					}
				}
				return result;
			}
			return null;
		} else if (mapping instanceof org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextElementMapping<?>) {
			org.eclipse.emf.ecore.EObject element = ((org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextElementMapping<? extends org.eclipse.emf.ecore.EObject>)mapping).getTargetElement();
			org.eclipse.emf.ecore.EReference reference = uriFragment.getReference();
			org.eclipse.emf.ecore.EReference oppositeReference = uriFragment.getReference().getEOpposite();
			if (!uriFragment.getReference().isContainment() && oppositeReference != null) {
				if (reference.isMany()) {
					org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList.ManyInverse<org.eclipse.emf.ecore.EObject> list = org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextCastUtil.cast(element.eGet(oppositeReference, false));										// avoids duplicate entries in the reference caused by adding to the
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
			if (errorCand instanceof org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextDiagnostic) {
				if (((org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextDiagnostic) errorCand).wasCausedBy(cause)) {
					diagnostics.remove(errorCand);
					unmark(cause);
				}
			}
		}
	}
	
	protected void attachResolveError(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolveResult<?> result, org.eclipse.emf.ecore.EObject proxy) {
		// attach errors to this resource
		assert result != null;
		final String errorMessage = result.getErrorMessage();
		if (errorMessage == null) {
			assert(false);
		} else {
			addProblem(new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextProblem(errorMessage, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemType.UNRESOLVED_REFERENCE, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemSeverity.ERROR, result.getQuickFixes()), proxy);
		}
	}
	
	protected void attachResolveWarnings(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolveResult<? extends org.eclipse.emf.ecore.EObject> result, org.eclipse.emf.ecore.EObject proxy) {
		assert result != null;
		assert result.wasResolved();
		if (result.wasResolved()) {
			for (org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceMapping<? extends org.eclipse.emf.ecore.EObject> mapping : result.getMappings()) {
				final String warningMessage = mapping.getWarning();
				if (warningMessage == null) {
					continue;
				}
				addProblem(new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextProblem(warningMessage, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemType.UNRESOLVED_REFERENCE, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemSeverity.WARNING), proxy);
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
		unmark(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemType.ANALYSIS_PROBLEM);
		if (processTerminationRequested()) {
			return false;
		}
		// first, run the generated post processor
		runPostProcessor(new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextResourcePostProcessor());
		if (loadOptions == null) {
			return true;
		}
		// then, run post processors that are registered via the load options extension
		// point
		Object resourcePostProcessorProvider = loadOptions.get(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextOptions.RESOURCE_POSTPROCESSOR_PROVIDER);
		if (resourcePostProcessorProvider != null) {
			if (resourcePostProcessorProvider instanceof org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextResourcePostProcessorProvider) {
				runPostProcessor(((org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextResourcePostProcessorProvider) resourcePostProcessorProvider).getResourcePostProcessor());
			} else if (resourcePostProcessorProvider instanceof java.util.Collection<?>) {
				java.util.Collection<?> resourcePostProcessorProviderCollection = (java.util.Collection<?>) resourcePostProcessorProvider;
				for (Object processorProvider : resourcePostProcessorProviderCollection) {
					if (processTerminationRequested()) {
						return false;
					}
					if (processorProvider instanceof org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextResourcePostProcessorProvider) {
						org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextResourcePostProcessorProvider csProcessorProvider = (org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextResourcePostProcessorProvider) processorProvider;
						org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextResourcePostProcessor postProcessor = csProcessorProvider.getResourcePostProcessor();
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
	protected void runPostProcessor(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextResourcePostProcessor postProcessor) {
		try {
			this.runningPostProcessor = postProcessor;
			postProcessor.process(this);
		} catch (Exception e) {
			new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextRuntimeUtil().logError("Exception while running a post-processor.", e);
		}
		this.runningPostProcessor = null;
	}
	
	public void load(java.util.Map<?, ?> options) throws java.io.IOException {
		java.util.Map<Object, Object> loadOptions = addDefaultLoadOptions(options);
		super.load(loadOptions);
		resolveAfterParsing();
	}
	
	protected void resolveAfterParsing() {
		interruptibleResolver = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextInterruptibleEcoreResolver();
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
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextLocationMap getLocationMap() {
		return locationMap;
	}
	
	public void addProblem(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextProblem problem, org.eclipse.emf.ecore.EObject element) {
		ElementBasedTextDiagnostic diagnostic = new ElementBasedTextDiagnostic(locationMap, getURI(), problem, element);
		getDiagnostics(problem.getSeverity()).add(diagnostic);
		mark(diagnostic);
		addQuickFixesToQuickFixMap(problem);
	}
	
	public void addProblem(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextProblem problem, int column, int line, int charStart, int charEnd) {
		PositionBasedTextDiagnostic diagnostic = new PositionBasedTextDiagnostic(getURI(), problem, column, line, charStart, charEnd);
		getDiagnostics(problem.getSeverity()).add(diagnostic);
		mark(diagnostic);
		addQuickFixesToQuickFixMap(problem);
	}
	
	protected void addQuickFixesToQuickFixMap(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextProblem problem) {
		java.util.Collection<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextQuickFix> quickFixes = problem.getQuickFixes();
		if (quickFixes != null) {
			for (org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextQuickFix quickFix : quickFixes) {
				if (quickFix != null) {
					quickFixMap.put(quickFix.getContextAsString(), quickFix);
				}
			}
		}
	}
	
	@Deprecated	
	public void addError(String message, org.eclipse.emf.ecore.EObject cause) {
		addError(message, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemType.UNKNOWN, cause);
	}
	
	public void addError(String message, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemType type, org.eclipse.emf.ecore.EObject cause) {
		addProblem(new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextProblem(message, type, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemSeverity.ERROR), cause);
	}
	
	@Deprecated	
	public void addWarning(String message, org.eclipse.emf.ecore.EObject cause) {
		addWarning(message, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemType.UNKNOWN, cause);
	}
	
	public void addWarning(String message, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemType type, org.eclipse.emf.ecore.EObject cause) {
		addProblem(new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextProblem(message, type, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemSeverity.WARNING), cause);
	}
	
	protected java.util.List<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getDiagnostics(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemSeverity severity) {
		if (severity == org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemSeverity.ERROR) {
			return getErrors();
		} else {
			return getWarnings();
		}
	}
	
	protected java.util.Map<Object, Object> addDefaultLoadOptions(java.util.Map<?, ?> loadOptions) {
		java.util.Map<Object, Object> loadOptionsCopy = org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextMapUtil.copySafelyToObjectToObjectMap(loadOptions);
		// first add static option provider
		loadOptionsCopy.putAll(new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextOptionProvider().getOptions());
		
		// second, add dynamic option providers that are registered via extension
		if (new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextRuntimeUtil().isEclipsePlatformAvailable()) {
			new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextEclipseProxy().getDefaultLoadOptionProviderExtensions(loadOptionsCopy);
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
		unmark(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemType.UNKNOWN);
		unmark(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemType.SYNTAX_ERROR);
		unmark(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemType.UNRESOLVED_REFERENCE);
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
		return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextCopiedEObjectInternalEList((org.eclipse.emf.ecore.util.InternalEList<org.eclipse.emf.ecore.EObject>) super.getContents());
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
		return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextCopiedEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(super.getWarnings());
	}
	
	/**
	 * Returns all errors that are associated with this resource.
	 */
	public org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.resource.Resource.Diagnostic> getErrors() {
		if (terminateReload) {
			// the contents' state is currently unclear
			return new org.eclipse.emf.common.util.BasicEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>();
		}
		return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextCopiedEList<org.eclipse.emf.ecore.resource.Resource.Diagnostic>(super.getErrors());
	}
	
	protected void runValidators(org.eclipse.emf.ecore.EObject root) {
		// checking constraints provided by EMF validator classes was disabled by option
		// 'disableEValidators'.
		
		if (new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextRuntimeUtil().isEclipsePlatformAvailable()) {
			new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextEclipseProxy().checkEMFValidationConstraints(this, root);
		}
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextQuickFix getQuickFix(String quickFixContext) {
		return quickFixMap.get(quickFixContext);
	}
	
	protected void mark(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextDiagnostic diagnostic) {
		org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextMarkerHelper markerHelper = getMarkerHelper();
		if (markerHelper != null) {
			markerHelper.mark(this, diagnostic);
		}
	}
	
	protected void unmark(org.eclipse.emf.ecore.EObject cause) {
		org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextMarkerHelper markerHelper = getMarkerHelper();
		if (markerHelper != null) {
			markerHelper.unmark(this, cause);
		}
	}
	
	protected void unmark(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemType analysisProblem) {
		org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextMarkerHelper markerHelper = getMarkerHelper();
		if (markerHelper != null) {
			markerHelper.unmark(this, analysisProblem);
		}
	}
	
	protected org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextMarkerHelper getMarkerHelper() {
		if (isMarkerCreationEnabled() && new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextRuntimeUtil().isEclipsePlatformAvailable()) {
			if (markerHelper == null) {
				markerHelper = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextMarkerHelper();
			}
			return markerHelper;
		}
		return null;
	}
	
	public boolean isMarkerCreationEnabled() {
		if (loadOptions == null) {
			return true;
		}
		return !loadOptions.containsKey(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextOptions.DISABLE_CREATING_MARKERS_FOR_PROBLEMS);
	}
	
	protected boolean isLocationMapEnabled() {
		if (loadOptions == null) {
			return true;
		}
		return !loadOptions.containsKey(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextOptions.DISABLE_LOCATION_MAP);
	}
	
	protected boolean isLayoutInformationRecordingEnabled() {
		if (loadOptions == null) {
			return true;
		}
		return !loadOptions.containsKey(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextOptions.DISABLE_LAYOUT_INFORMATION_RECORDING);
	}
	
}
