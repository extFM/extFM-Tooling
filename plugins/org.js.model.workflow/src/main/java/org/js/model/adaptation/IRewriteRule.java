package org.js.model.adaptation;


public interface IRewriteRule {

   public static int OK = 0;
   public static int Error = -1;
      
   
   /**
    * Execute the rewrite rule and return code. 
    * @return
    */
   public int execute();
   
}
