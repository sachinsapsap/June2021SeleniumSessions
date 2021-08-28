package testngsessions;

import org.testng.annotations.Test;

public class InvocationCountConcept {

	@Test(invocationCount = 2)
	public void homePageTest() {
		System.out.println("Home Page Test");
	}
	
}
