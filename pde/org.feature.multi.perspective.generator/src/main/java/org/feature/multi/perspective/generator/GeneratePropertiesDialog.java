package org.feature.multi.perspective.generator;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class GeneratePropertiesDialog extends MessageDialog {

   private GenerateProperties properties;
   private Button generateConsistentMappingButtonTrue;
   private Button generateViewmodelButtonTrue;
   private Button reuseMappingButtonTrue;

   public GeneratePropertiesDialog(GenerateProperties properties, Shell parentShell, String dialogTitle, Image dialogTitleImage,
         String dialogMessage, int dialogImageType, String[] dialogButtonLabels, int defaultIndex) {
      super(parentShell, dialogTitle, dialogTitleImage, dialogMessage, dialogImageType, dialogButtonLabels, defaultIndex);
      this.properties = properties;
   }

   @Override
   protected Control createCustomArea(Composite parent) {
            
      Composite composite1 = new Composite(parent, SWT.NULL);
      composite1.setLayout(new RowLayout());
      Label consistentLabel = new Label(composite1, SWT.NULL);
      consistentLabel.setText("Generate only mappings, where all viewpoints are consistent?");
      generateConsistentMappingButtonTrue = new Button(composite1, SWT.RADIO);
      generateConsistentMappingButtonTrue.setText("Yes");
      Button generateConsistentMappingButtonFalse = new Button(composite1, SWT.RADIO);
      generateConsistentMappingButtonFalse.setText("No.");

      Composite composite2 = new Composite(parent, SWT.NULL);
      composite2.setLayout(new RowLayout());
      Label generateViewmodelLabel = new Label(composite2, SWT.NULL);
      generateViewmodelLabel.setText("Generate view model?");
      generateViewmodelButtonTrue = new Button(composite2, SWT.RADIO);
      generateViewmodelButtonTrue.setText("Yes");
      Button generateViewmodelButtonFalse = new Button(composite2, SWT.RADIO);
      generateViewmodelButtonFalse.setText("No.");

      Composite composite3 = new Composite(parent, SWT.NULL);
      composite3.setLayout(new RowLayout());
      Label reuseMappingLabel = new Label(composite3, SWT.NULL);
      reuseMappingLabel.setText("Reuse mapping?");
      reuseMappingButtonTrue = new Button(composite3, SWT.RADIO);
      reuseMappingButtonTrue.setText("Yes");
      Button reuseMappingButtonFalse = new Button(composite3, SWT.RADIO);
      reuseMappingButtonFalse.setText("No.");

      // set Buttons selected
      boolean generateConsistentMapping = properties.isGenerateConsistentMapping();
      generateConsistentMappingButtonTrue.setSelection(generateConsistentMapping);
      generateConsistentMappingButtonFalse.setSelection(!generateConsistentMapping);

      boolean generateViewmodel = properties.isGenerateViewmodel();
      generateViewmodelButtonTrue.setSelection(generateViewmodel);
      generateViewmodelButtonFalse.setSelection(!generateViewmodel);

      boolean reuseMapping = properties.isReuseMapping();
      reuseMappingButtonTrue.setSelection(reuseMapping);
      reuseMappingButtonFalse.setSelection(!reuseMapping);

      return parent;
   }

   @Override
   protected void buttonPressed(int buttonId) {
      refreshProperties();
      super.buttonPressed(buttonId);
   }


   private void refreshProperties() {
      properties.setGenerateConsistentMapping(generateConsistentMappingButtonTrue.getSelection());
      properties.setGenerateViewmodel(generateViewmodelButtonTrue.getSelection());
      properties.setReuseMapping(reuseMappingButtonTrue.getSelection());
   }

}
