/**
 * 
 */
package org.js.model.feature.ptnet.sedaj.impl;

import hub.top.editor.ptnetLoLA.ArcToPlace;
import hub.top.editor.ptnetLoLA.ArcToTransition;
import hub.top.editor.ptnetLoLA.Place;
import hub.top.editor.ptnetLoLA.PtNet;
import hub.top.editor.ptnetLoLA.Transition;
import hub.top.editor.ptnetLoLA.impl.PtnetLoLAFactoryImpl;

import org.eclipse.emf.common.util.EList;
import org.js.model.feature.Constraint;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureModel;
import org.js.model.feature.Group;
import org.js.model.feature.ptnet.sedaj.FMtoPtNet;
import org.js.model.feature.ptnet.sedaj.util.FMUtil;
import org.js.model.feature.ptnet.sedaj.util.GroupDefinition;

/**
 * Implementation of the interface {@link FMtoPtNet}. Transforms a {@link FeatureModel} to a {@link PtNet}. Also
 * provides a method to check the soundness.
 * 
 * @author Tim Winkelmann
 * 
 */
public class FmtoPtNetImpl implements FMtoPtNet {

   /*
    * (non-Javadoc)
    * 
    * @see sedaj.FMtoPtNet#createPtNet(org.js.model.feature.FeatureModel)
    */
   @Override
   public PtNet createPtNet(FeatureModel fm) {
      PtNet net = createBasePetriNet(fm);
      traverseFM(net, fm.getRoot().getGroups());
      addConstraints(net, fm);
      return net;
   }

   /**
    * Traverse the {@link Group} and its children and transforms it into {@link PtNet}.
    * 
    * @param net the {@link PtNet} which the {@link FeatureModel} will be transformed into
    * @param groups the {@link Group} which will be transformed
    */
   private void traverseFM(PtNet net, EList<Group> groups) {
      for (Group group : groups) {
         GroupDefinition gd = FMUtil.getGroupDefinition(group);
         EList<Feature> features = group.getChildFeatures();
         for (Feature feature : features) {
            traverseFM(net, feature.getGroups());
            addFeatureToPtNet(net, feature);
         }
         switch (gd) {
            case mandatory:
               createMandatoryRelation(net, group);
               break;
            case optional:
               createOptionalRelation(net, group);
               break;
            case alternativ:
               createAlternativRelation(net, group);
               break;
            case inclusivOr:
               createInclusivOrRelation(net, group);
               break;
            case exclusivOptional:
               createExclusivOptRelation(net, group);
               break;
            default:// general
               createGeneralRelation(net, group);
               break;
         }
      }
   }

   /**
    * Transforms the general {@link Feature} {@link Group} relation into the {@link PtNet}.
    * 
    * @param net the {@link PtNet}
    * @param group the {@link Group} of {@link Feature}
    */
   private void createGeneralRelation(PtNet net, Group group) {
      // TODO Auto-generated method stub

   }

   /**
    * Transforms the exclusive optional {@link Feature} {@link Group} relation into the {@link PtNet}.
    * 
    * @param net the {@link PtNet}
    * @param group the {@link Group} of {@link Feature}
    */
   private void createExclusivOptRelation(PtNet net, Group group) {
      // TODO Auto-generated method stub

   }

   /**
    * Transforms the inclusive or {@link Feature} {@link Group} relation into the {@link PtNet}.
    * 
    * @param net the {@link PtNet}
    * @param group the {@link Group} of {@link Feature}
    */
   private void createInclusivOrRelation(PtNet net, Group group) {
      // TODO Auto-generated method stub

   }

   /**
    * Transforms the alternative {@link Feature} {@link Group} relation into the {@link PtNet}.
    * 
    * @param net the {@link PtNet}
    * @param group the {@link Group} of {@link Feature}
    */
   private void createAlternativRelation(PtNet net, Group group) {
      // TODO Auto-generated method stub

   }

   /**
    * Transforms the optional {@link Feature} {@link Group} relation into the {@link PtNet}.
    * 
    * @param net the {@link PtNet}
    * @param group the {@link Group} of {@link Feature}
    */
   private void createOptionalRelation(PtNet net, Group group) {
      // TODO Auto-generated method stub

   }

   /**
    * Transforms the mandatory {@link Feature} {@link Group} relation into the {@link PtNet}.
    * 
    * @param net the {@link PtNet}
    * @param group the {@link Group} of {@link Feature}
    */
   private void createMandatoryRelation(PtNet net, Group group) {

   }

   /**
    * Adds the {@link Feature} to the {@link PtNet}.
    * 
    * @param net the {@link PtNet}
    * @param feature the {@link Feature} which will be added
    */
   private void addFeatureToPtNet(PtNet net, Feature feature) {
      Place i = PtnetLoLAFactoryImpl.eINSTANCE.createPlace();
      i.setName("i:" + feature.getId());
      net.getPlaces().add(i);
      Place o = PtnetLoLAFactoryImpl.eINSTANCE.createPlace();
      o.setName("o:" + feature.getId());
      net.getPlaces().add(o);
      Transition add = PtnetLoLAFactoryImpl.eINSTANCE.createTransition();
      add.setName("add:" + feature.getId());
      net.getTransitions().add(add);
      Transition rem = PtnetLoLAFactoryImpl.eINSTANCE.createTransition();
      rem.setName("rem:" + feature.getId());
      net.getTransitions().add(rem);
      ArcToTransition toTransition = PtnetLoLAFactoryImpl.eINSTANCE.createArcToTransition();
      toTransition.setSource(i);
      toTransition.setTarget(add);
      net.getArcs().add(toTransition);
      toTransition = PtnetLoLAFactoryImpl.eINSTANCE.createArcToTransition();
      toTransition.setSource(i);
      toTransition.setTarget(rem);
      net.getArcs().add(toTransition);
      ArcToPlace toPlace = PtnetLoLAFactoryImpl.eINSTANCE.createArcToPlace();
      toPlace.setSource(add);
      toPlace.setTarget(o);
      net.getArcs().add(toPlace);
      toPlace = PtnetLoLAFactoryImpl.eINSTANCE.createArcToPlace();
      toPlace.setSource(rem);
      toPlace.setTarget(o);
      net.getArcs().add(toPlace);
   }

   /**
    * Transforms the {@link Constraint} of the {@link FeatureModel} into the {@link PtNet}.
    * 
    * @param net the {@link PtNet}
    * @param fm the {@link FeatureModel} with the {@link Constraint}
    */
   private void addConstraints(PtNet net, FeatureModel fm) {
      EList<Constraint> constraints = fm.getConstraints();
      for (Constraint constraint : constraints) {
         // TODO constraint transformation
      }
   }

   /**
    * Creates a {@link PtNet} with a start and end {@link Place}. Adds a {@link Transition} for the root {@link Feature}
    * .
    * 
    * @param featureModel contains the {@link Feature} and relations between them.
    * @return a {@link PtNet} with a start and end {@link Place}.
    */
   private PtNet createBasePetriNet(FeatureModel featureModel) {
      PtNet net = PtnetLoLAFactoryImpl.eINSTANCE.createPtNet();
      Place place = PtnetLoLAFactoryImpl.eINSTANCE.createPlace();
      place.setName("i");
      net.getPlaces().add(place);
      if (featureModel.getRoot() != null) {
         Transition transition = PtnetLoLAFactoryImpl.eINSTANCE.createTransition();
         transition.setName("+" + featureModel.getRoot().getName());
         net.getTransitions().add(transition);
         ArcToTransition arcToTransition = PtnetLoLAFactoryImpl.eINSTANCE.createArcToTransition();
         arcToTransition.setSource(place);
         arcToTransition.setTarget(transition);// Default weight == 1
      }

      place = PtnetLoLAFactoryImpl.eINSTANCE.createPlace();
      place.setName("o");
      net.getPlaces().add(place);
      return net;
   }

   /*
    * (non-Javadoc)
    * 
    * @see sedaj.FMtoPtNet#checkPtNet(hub.top.editor.ptnetLoLA.PtNet)
    */
   @Override
   public void checkPtNet(PtNet net) {
      // TODO Auto-generated method stub

   }

}
