package org.js.model.feature;

import org.js.model.feature.csp.FeatureModelAnalyzer;
import org.junit.Assert;
import org.junit.Test;


public class FeatureCSPTest extends FeatureModelTest {

   
   FeatureModelAnalyzer analyzer;
   
   public FeatureCSPTest(){
      super();
      analyzer = new FeatureModelAnalyzer(getSatFeatureModel());
   }
   
   @Test
   public void analyzeNumberOfFeatures(){
      int numberOfAllFeatures = analyzer.getNumberOfAllFeatures();
      Assert.assertTrue(numberOfAllFeatures == 9);
   }

   @Test
   public void analyzeCrossTreeFeatureCoverage(){
      int featureCTCR = analyzer.getFeatureConstraintCoverage();
      Assert.assertTrue(featureCTCR == 33);
   }
   

   @Test
   public void analyzeCrossTreeAttributeCoverage(){
      int attributeCTCR = analyzer.getAttributeConstraintCoverage();
      Assert.assertTrue(attributeCTCR == 100);
   }

   
   @Test
   public void analyzeNumberOfVariants(){
      int numberVariants = analyzer.getNumberOfDerivableVariants();
      Assert.assertTrue(numberVariants == 6);
   } 
   
   @Test
   public void analyzeNumberOfAttributes(){
      int numberOfAllAttributes = analyzer.getNumberOfAllAttributes();
      Assert.assertTrue(numberOfAllAttributes == 5);
   }
 
   @Test
   public void testFeatureModelSatisfiability(){
      boolean sat = analyzer.isSatisfiable();
      Assert.assertTrue(sat);
   }
   
}
