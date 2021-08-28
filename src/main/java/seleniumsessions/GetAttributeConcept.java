package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAttributeConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		By login = By.linkText("Login");
		String href = doGetAttribute(login, "href");
		System.out.println(href);

	}

	/**
	 * This method returns WebElement based on the locator provided.
	 * 
	 * @param locator Pass the locator to identify the WebElement
	 * @return This method returns the WebElement
	 */
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	/**
	 * This method is used to give the specific attribute value of a tag.
	 * 
	 * @param locator   Pass the locator to identify the WebElement
	 * @param attribute Pass the attribute whose value is to be fetched.
	 * @return This method returns the attribute value of the WebElement identified.
	 */
	public static String doGetAttribute(By locator, String attribute) {
		return getElement(locator).getAttribute(attribute);
	}

}
