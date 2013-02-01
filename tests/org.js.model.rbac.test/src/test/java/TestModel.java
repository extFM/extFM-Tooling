import java.io.IOException;
import java.net.URL;
import java.util.Collections;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.resource.rbactext.mopp.RbactextResourceFactory;

public class TestModel {

   private AccessControlModel testModel;

   public TestModel() {
      loadTestModel();
   }

   private void loadTestModel() {
      ResourceSet resourceSet = new ResourceSetImpl();
      resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("rbactext", new RbactextResourceFactory());
      URL fileresource = TestModel.class.getResource("simpleAC.rbactext");
      String path = fileresource.getPath();
      URI uri = URI.createFileURI(path);
      Resource resource = resourceSet.getResource(uri, true);
      try {
         resource.load(Collections.EMPTY_MAP);
         System.out.println("Loaded " + uri);
         EList<EObject> contents = resource.getContents();
         if (contents != null && !contents.isEmpty()) {
            testModel = (AccessControlModel)contents.get(0);
         }
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   AccessControlModel getACTestModel() {
      return testModel;
   }

}
