/**
 * 
 */
package org.feature.multi.perspective.generator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
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
import org.feature.multi.perspective.generator.viewmodel.AbstractGenerator;
import org.feature.multi.perspective.generator.viewmodel.FeatureMappingGenerator;
import org.feature.multi.perspective.generator.viewmodel.ViewModelGenerator;

/**
 * default command handler for generating the cluste rmodel.
 * 
 * @author <a href=mailto:info@juliaschroeter.de>Julia Schroeter</a>
 * 
 */
public class GeneratorCommandHandler extends AbstractHandler {

   private Job job;

   @Override
   public Object execute(ExecutionEvent event) throws ExecutionException {
      createJob();
      return null;
   }

   private void createJob() {

      job = new Job("Generating Multi-Perspective Models") {

         protected IStatus run(IProgressMonitor monitor) {
            try {
               generateMultiPerspectiveModel();
               if (monitor.isCanceled()) return Status.CANCEL_STATUS;
               return Status.OK_STATUS;
            }
            finally {}
         }
      };

      job.addJobChangeListener(new JobChangeAdapter() {

         public void done(IJobChangeEvent event) {
            if (event.getResult().isOK())
               postMessage("Generating Multi-Perspective Models completed successfully");
            else
               postError("Generating Multi-Perspective Models did not complete successfully");
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

   private void generateMultiPerspectiveModel() {
      boolean generateViewmodel = AbstractGenerator.generateViewmodel;
      boolean generateConsistentMapping = AbstractGenerator.generateConsistentMapping;
      boolean reuseMapping = AbstractGenerator.reuseMapping;

      //boolean generateClassification = true;
      
      if (generateViewmodel) {
         ViewModelGenerator generator = new ViewModelGenerator();
         generator.generateViewModel();
      }
      FeatureMappingGenerator fmGenerator = new FeatureMappingGenerator();
      fmGenerator.generateMapping(generateConsistentMapping, reuseMapping);
      
//      if (generateClassification){
//        ClassificationGenerator clGenerator = new ClassificationGenerator();
//        clGenerator.generateClassification();
//      }
   }

   @Override
   public void dispose() {
      if (job != null) {
         job.cancel();
      }
      super.dispose();
   }

}
