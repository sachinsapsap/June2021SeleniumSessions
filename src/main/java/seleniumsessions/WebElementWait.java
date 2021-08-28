package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementWait {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");

		By emailID = By.id("input-email");
//		By password = By.id("input-password");
//		By loginBtn = By.xpath("//input[@value='Login']");

//		WebDriverWait wait=new WebDriverWait(driver, 5);
//		WebElement email_ele=wait.until(ExpectedConditions.visibilityOfElementLocated(emailID));

		waitForElementVisible(emailID, 5).sendKeys("test@gmail.com");
		
		By terms=By.linkText("Terms & Conditions");
		clickWhenReady(terms, 10);

	}

	public static WebElement waitForElementPresence(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public static WebElement waitForElementVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static List<WebElement> waitForElementsVisible(By locator,int timeout)
	{
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public static List<String> getElementsTextList(By locator,int timeout)
	{
		List<WebElement> ele=waitForElementsVisible(locator, timeout);
		List<String> eleTextList=new ArrayList<String>();
		for(WebElement e: ele) {
			eleTextList.add(e.getText());
		}
		return eleTextList;
	}
	
	public static WebElement waitForElementToBeClickable(By locator, int timeout) {
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static void clickWhenReady(By locator, int timeout) {
		waitForElementPresence(locator, timeout).click();
	}

}
