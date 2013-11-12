package org.feature.multi.perspective.generator;

import org.feature.multi.perspective.generator.viewmodel.AbstractGenerator;


public class GenerateProperties {

   private boolean generateViewmodel = AbstractGenerator.generateViewmodel;
   private boolean generateConsistentMapping = AbstractGenerator.generateConsistentMapping;
   private boolean reuseMapping = AbstractGenerator.reuseMapping;
   
   /**
    * default Constructor
    */
   public GenerateProperties(){}

   public boolean isGenerateViewmodel() {
      return generateViewmodel;
   }

   public void setGenerateViewmodel(boolean generateViewmodel) {
      this.generateViewmodel = generateViewmodel;
   }

   public boolean isGenerateConsistentMapping() {
      return generateConsistentMapping;
   }

   public void setGenerateConsistentMapping(boolean generateConsistentMapping) {
      this.generateConsistentMapping = generateConsistentMapping;
   }

   public boolean isReuseMapping() {
      return reuseMapping;
   }

   public void setReuseMapping(boolean reuseMapping) {
      this.reuseMapping = reuseMapping;
   };
   
   
}
