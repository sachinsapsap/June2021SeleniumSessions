package testngsessions;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {
	
	String name="testng";

	@Test(expectedExceptions = {ArithmeticException.class,NullPointerException.class})
	public void homePageTest() {
		System.out.println("Home Page Test");
		int i=9/0;
		System.out.println(i);
//		ExpectedExceptionConcept obj=null;
//		System.out.println(obj.name);
	}

}
