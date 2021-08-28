package testngsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgBasics {
	
	//Preconditions-----@Before
	//Test Case--->Test Steps + Assertion (Act vs Exp)----@Test
	//Post conditions----@After
	
//	Tests are run based on alphabetical order.
//	If 2 tests have same name but in different cases like sachin and sacHin then sacHin will be executed first. Capital executed first.
	
	
	@BeforeSuite
	public void dBConnection() {
		System.out.println("BS------DBConnection");
	}
	
	@BeforeTest
	public void createUser() {
		System.out.println("BT------create user");
	}
	
	@BeforeClass
	public void launchBrowser() {
		System.out.println("BC-------launch browser");
	}
	
	@BeforeMethod
	public void login() {
		System.out.println("BM------login");
	}
	
	@Test
	public void homePageTest() {
		System.out.println("Home Page Test");
	}
	
	@Test
	public void homEPageTest() {
		System.out.println("Home Page Test");
	}
	
	@Test
	public void addToCartPageTest() {
		System.out.println("addToCart Page Test");
	}
	
	@Test
	public void paymentPageTest() {
		System.out.println("payment Page Test");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("AM------login");
	}
	
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("AC------Close Browser");
	}
	
	@AfterTest
	public void deleteUser() {
		System.out.println("AT-------Delete User");
	}
	
	@AfterSuite
	public void disconnectDB() {
		System.out.println("AS-------disconnect DB");
	}
	
	
	

}
