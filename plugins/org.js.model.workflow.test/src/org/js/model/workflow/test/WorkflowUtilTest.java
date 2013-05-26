package org.js.model.workflow.test;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.lang.ArithmeticException;

import static org.junit.Assert.*;
//import static org.junit.Assert.assertEquals;  
//import static org.junit.Assert.assertTrue;  
//import static org.junit.Assert.assertFalse;  
//import static org.junit.Assert.*;  

public class WorkflowUtilTest {
	@Before
	public void before() {
		System.out.println("before is executed once.");
	}

	@Test
	public void test1() {
		System.out.println("test1 is executed.");
		// assert x==10:"x==10 success";
		// assertTrue("Result true ",b);
		// assertFalse("Result false ", b);
		// Object obj = null;
		// assertNull(obj);
		// assertNull("obj is not null ", obj);
		// assertNotNull("obj is null", obj);
		// String str1 = "str1";
		// String str2 = new String("str1");
		// assertSame("Traget  result  ", str1, str2);
	}

	@Test
	public void test2() {
		System.out.println("test2 is executed.");
	}
}
