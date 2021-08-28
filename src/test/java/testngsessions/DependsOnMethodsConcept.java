package testngsessions;

import org.testng.annotations.Test;

public class DependsOnMethodsConcept {
	
//	Always a bad practice to have dependency on other tests.
//	Test methods should be independent
//	AAA rule for designing test methods.

	@Test(priority=3)
	public void loginTest() {
		System.out.println("Login Test");
		int i=9/2;
		System.out.println(i);
	}
	
	@Test(dependsOnMethods = "loginTest", priority=2)
	public void homePageTest() {	
		System.out.println("Home Page Test");
	}
	
	@Test(dependsOnMethods = {"loginTest","homePageTest"}, priority=1)
	public void searchTest() {
		System.out.println("Search Test");
	}
	
}
