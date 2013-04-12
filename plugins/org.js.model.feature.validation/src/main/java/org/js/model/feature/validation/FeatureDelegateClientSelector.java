/************************************************************
 * Copyright (c) 2010 paperlocator.org - all rights reserved.
 * 
 * $Id$ 
 * $Revision$ 
 * $Author$
 ***********************************************************/
package org.js.model.feature.validation;

import org.eclipse.emf.validation.model.IClientSelector;
import org.js.model.feature.Attribute;
import org.js.model.feature.Constraint;
import org.js.model.feature.Feature;
import org.js.model.feature.Group;

/**
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public class FeatureDelegateClientSelector implements IClientSelector {

   @Override
   public boolean selects(Object object) {
      return (object instanceof Feature || object instanceof Group || object instanceof Constraint || object instanceof Attribute);
   }

}
