/**
 * 
 */
package org.feature.multi.perspective.measure.performance;

import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.feature.model.utilities.WorkbenchUtil;
import org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage;

/**
 * @author <a href=mailto:julia.schroeter@tu-dresden.de>Julia Schroeter</a>
 * 
 */
public abstract class AbstractCheckHandler extends AbstractHandler {

   protected Job job;

   private static String[] genProjects = new String[] { "graph"
   // "vp100nc_cnf10000", "vp100nc_cnf10000", "vp100nc_cnf10000",
   // "vp100nc_cnf2000","vp100nc_cnf2000","vp100nc_cnf2000"
      };

   protected static String generatedProject = "generatedProject";
   protected static String mappingFolder = ViewmappingPackage.eNS_PREFIX;
   //protected static String classificationFolder = ClassificationPackage.eNS_PREFIX;

   abstract String getMeasureName();

   @Override
   public Object execute(ExecutionEvent event) throws ExecutionException {
      createJob();
      return null;
   }

   private void createJob() {

      final Job job = new Job(getMeasureName()) {

         protected IStatus run(IProgressMonitor monitor) {
            try {
               measure();
               printPerformanceMeasure();
               if (monitor.isCanceled()) return Status.CANCEL_STATUS;
               return Status.OK_STATUS;
            }
            finally {
               // schedule(60000); // start again in an hour
            }
         }
      };

      job.addJobChangeListener(new JobChangeAdapter() {

         public void done(IJobChangeEvent event) {
            if (event.getResult().isOK())
               postMessage("Performance Measurement completed successfully");
            else
               postError("Performance Measurement did not complete successfully");
         }

         private void postError(String msg) {
            Shell shell = WorkbenchUtil.getShell();
            if (shell != null) {
               MessageBox msgBox = new MessageBox(shell, SWT.OK | SWT.ICON_ERROR);
               msgBox.setMessage(msg);
               msgBox.open();
            }
         }

         private void postMessage(String msg) {
            Shell shell = WorkbenchUtil.getShell();
            if (shell != null) {
               MessageBox msgBox = new MessageBox(shell, SWT.OK | SWT.ICON_INFORMATION);
               msgBox.setMessage(msg);
               msgBox.open();
            }
         }
      });
      job.setSystem(true);
      job.schedule(); // start as soon as possible
   }

   private void measure() {
      clearLists();
      for (int i = 0; i < genProjects.length; i++) {
         String projectPart = genProjects[i];
         String projectName = generatedProject + "_" + projectPart;
         measurePerformance(projectName);
      }
   }

   abstract void clearLists();

   abstract Logger getLogger();

   abstract void measurePerformance(String projectName);

   abstract void printPerformanceMeasure();

   protected void checkModelsInProject(String projectName, String modelFolder) throws CoreException {
      IWorkspace workspace = ResourcesPlugin.getWorkspace();
      IProject project = workspace.getRoot().getProject(projectName);
      if (project.exists()) {
         IFolder projectFolder = project.getFolder(modelFolder);
         if (projectFolder.exists()) {
            IResource[] members;
            members = projectFolder.members();
            for (IResource iResource : members) {
               if (iResource instanceof IFile) {
                  IFile file = (IFile) iResource;
                  check(file);
               }
            }
         }
      }
   }

   abstract void check(IFile file);

   @Override
   public void dispose() {
      if (job != null) {
         job.cancel();
      }
      super.dispose();
   }

   protected StringBuffer initStringBuffer(String description) {
      StringBuffer s = new StringBuffer();
      s.append(description);
      s.append("{");
      return s;
   }

   protected void finalizeStringBuffer(StringBuffer s) {
      s.append("}");
      getLogger().debug(s);
   }

   protected void printDoubleCollection(String description, List<Double> bruteForceConsistentVPRatio2) {
      StringBuffer s = initStringBuffer(description);
      for (Double ratio : bruteForceConsistentVPRatio2) {
         // DecimalFormat df = new DecimalFormat("0.00");
         // String ratioStr = df.format(ratio);
         s.append(ratio);
         s.append(", ");
      }
      finalizeStringBuffer(s);
   }

   protected void printStringCollection(String description, List<String> list) {
      StringBuffer s = initStringBuffer(description);
      for (String l : list) {
         s.append(l);
         s.append(", ");
      }
      finalizeStringBuffer(s);
   }

   protected void printCollection(String description, Collection<Integer> list) {
      StringBuffer s = initStringBuffer(description);
      for (Integer l : list) {
         s.append(l);
         s.append(", ");
      }
      finalizeStringBuffer(s);
   }

   protected void printCollection(String description, List<Long> list) {
      StringBuffer s = initStringBuffer(description);
      for (Long l : list) {
         s.append(l);
         s.append(", ");
      }
      finalizeStringBuffer(s);
   }

}
