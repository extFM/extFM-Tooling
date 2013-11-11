package org.js.model.feature;

import org.js.model.feature.csp.FeatureModelAnalyzer;
import org.junit.Assert;
import org.junit.Test;


public class UnsatFeatureCSPTest extends FeatureModelTest {

   FeatureModelAnalyzer analyzer;
   
   public UnsatFeatureCSPTest(){
      super();
      analyzer = new FeatureModelAnalyzer(getUnsatFeatureModel());
   }
   
   @Test
   public void testFeatureModelSatisfiability(){
      boolean sat = analyzer.isSatisfiable();
      Assert.assertFalse(sat);
   }
}
