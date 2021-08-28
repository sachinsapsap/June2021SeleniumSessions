package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementIsDisplayed {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		
		By search=By.name("search");
		WebElement searchbox=driver.findElement(search);
		System.out.println(searchbox.isDisplayed());

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
	 * This method is used to find out if WebElement is displayed or not.
	 * @param locator Pass the locator to identify the WebElement
	 * @return This method returns true if element is present and false if not.
	 */
	public static boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

}
