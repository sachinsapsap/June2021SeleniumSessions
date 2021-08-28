package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsSendKeysAndClick {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");

		By emailID = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@type='submit' and @value='Login']");

//		Actions act = new Actions(driver);
//		act.sendKeys(driver.findElement(emailID), "naveenanimation20@gmail.com").perform();
//		act.sendKeys(driver.findElement(password), "Selenium12345").perform();
//		act.click(driver.findElement(loginBtn)).perform();
		
		doActionSendKeys(emailID, "naveenanimation20@gmail.com");
		doActionSendKeys(password, "Selenium12345");
		doActionClick(loginBtn);

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doActionSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();

	}
	
	public static void doActionClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();

	}

}
