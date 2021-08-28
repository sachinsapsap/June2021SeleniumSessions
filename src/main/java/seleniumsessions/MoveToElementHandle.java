package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

//    Select class we have to pass WebElement in the constructor
//    Actions class we have to pass Driver in the constructor

public class MoveToElementHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://mrbool.com/");

//		WebElement contentMenu = driver.findElement(By.className("menulink"));
//
//		Actions act = new Actions(driver);
//
//		act.moveToElement(contentMenu).perform();
//
//		Thread.sleep(3000);
//		driver.findElement(By.linkText("ARTICLES")).click();

		By parentMenu = By.className("menulink");
		By childMenu = By.linkText("COURSES");
		twoLevelMenuHandle(parentMenu, childMenu);

//		Assignment:
//		driver.get("http://spicejet.com/");
//	
//		WebElement login=driver.findElement(By.id("ctl00_HyperLinkLogin"));
//		WebElement spice=driver.findElement(By.xpath("//li[@class='hide-mobile']/a[text()='SpiceClub Members']"));
//		
//		Actions act = new Actions(driver);
//		act.moveToElement(login).perform();
//		Thread.sleep(2000);
//		act.moveToElement(spice).perform();
//		Thread.sleep(2000);
//		driver.findElement(By.linkText("Sign up")).click();

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void twoLevelMenuHandle(By parentMenu, By childMenu) throws InterruptedException {

		Actions act = new Actions(driver);

		act.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(3000);
		getElement(childMenu).click();

	}

	public static void threeLevelMenuHandle(By parentMenu1, By parentMenu2, By childMenu) throws InterruptedException {

		Actions act = new Actions(driver);

		act.moveToElement(getElement(parentMenu1)).perform();
		Thread.sleep(3000);
		act.moveToElement(getElement(parentMenu2)).perform();
		Thread.sleep(3000);
		getElement(childMenu).click();

	}

}
