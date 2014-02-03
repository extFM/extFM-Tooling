package org.js.model.workflow.test.rewrite;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jwt.meta.model.processes.ActivityEdge;
import org.eclipse.jwt.meta.model.processes.ActivityNode;
import org.eclipse.jwt.meta.model.processes.ProcessesFactory;
import org.js.model.workflow.util.WorkflowModelUtil;
import org.junit.Assert;
import org.junit.Test;


public class RewriteUtilTest {

   public static ProcessesFactory processFactory = ProcessesFactory.eINSTANCE;
   
   private ActivityNode nodeO,nodeM,nodeF,nodeG,nodeD,nodeB,nodeE,nodeC,nodeH,nodeA;

   private ActivityEdge edge8,edge7,edge5,edge3,edge1,edge6,edge4,edge9,edge2;
   
   /**
    * A dummy model of a directed path. 
    * Capital letters represent nodes while numbers represent edges
    * 
    * G--7-       H--9-
    *      \           \
    * O--8--F--5--D--3--B--1--M
    *                  /      |
    *       E--6--C--4-   A--2-
    * 
    * 
    */
   private void createDummyModel(){
      nodeO = createNode("O");
      nodeM = createNode("M");
      nodeF = createNode("F");
      nodeG = createNode("G");
      nodeD = createNode("D");
      nodeB = createNode("B");
      nodeE = createNode("E");
      nodeC = createNode("C");
      nodeH = createNode("H");
      nodeA = createNode("A");
      
      edge8 = createEdge(nodeO, nodeF);
      edge7 = createEdge(nodeG, nodeF);
      edge5 = createEdge(nodeF, nodeD);
      edge3 = createEdge(nodeD, nodeB);
      edge1 = createEdge(nodeB, nodeM);
      
      edge6 = createEdge(nodeE, nodeC);
      edge4 = createEdge(nodeC, nodeB);
      edge9 = createEdge(nodeH, nodeB);
      edge2 = createEdge(nodeA, nodeM);
      
      
   }
   
   private ActivityNode createNode(String name){
      ActivityNode node = processFactory.createActivityNode();
      node.setName(name);
      return node;
   }
   
   private ActivityEdge createEdge(ActivityNode source, ActivityNode target){
      ActivityEdge actEdge = processFactory.createActivityEdge();
      actEdge.setSource(source);
      actEdge.setTarget(target);
      return actEdge;
   }
   
   @Test
   public void testFindPath1(){
      createDummyModel();
      Set<EObject> path = new HashSet<EObject>();
      Set<EObject> result = WorkflowModelUtil.findPath(nodeO, nodeM, path);
      Assert.assertTrue(result != null);
      Assert.assertTrue(result.size()== 7);
      Assert.assertTrue(result.contains(edge8));
      Assert.assertTrue(result.contains(edge5));
      Assert.assertTrue(result.contains(edge3));
      Assert.assertTrue(result.contains(edge1));
      Assert.assertTrue(result.contains(nodeF));
      Assert.assertTrue(result.contains(nodeD));
      Assert.assertTrue(result.contains(nodeB));
   }
   
   @Test
   public void testFindPath2(){
      createDummyModel();
      Set<EObject> path = new HashSet<EObject>();
      Set<EObject> result = WorkflowModelUtil.findPath(nodeE, nodeB, path);
      Assert.assertTrue(result != null);
      Assert.assertTrue(result.size()== 3);
      Assert.assertTrue(result.contains(edge6));
      Assert.assertTrue(result.contains(edge4));
      Assert.assertTrue(result.contains(nodeC));
   }

   @Test
   public void testFindPath3(){
      createDummyModel();
      Set<EObject> path = new HashSet<EObject>();
      Set<EObject> result = WorkflowModelUtil.findPath(nodeG, nodeF, path);
      Assert.assertTrue(result != null);
      Assert.assertTrue(result.size()== 1);
      Assert.assertTrue(result.contains(edge7));
   }

   @Test
   public void testFindPath4(){
      createDummyModel();
      Set<EObject> path = new HashSet<EObject>();
      Set<EObject> result = WorkflowModelUtil.findPath(nodeG, nodeO, path);
      Assert.assertTrue(result != null);
      Assert.assertTrue(result.size()== 0);
   }
   
   @Test
   public void testFindPath5(){
      createDummyModel();
      Set<EObject> path = new HashSet<EObject>();
      Set<EObject> result = WorkflowModelUtil.findPath(nodeD, nodeC, path);
      Assert.assertTrue(result != null);
      Assert.assertTrue(result.size()== 0);
   }
   
}
