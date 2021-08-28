package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		driver.get("https://demo.opencart.com/index.php?route=account/register");

//		create a webelement + perform action(click,sendkeys,getText,isDisplayed)
//		locators:

//-------------------------ID Locator------------------------------------------------------------		

//		1.id locator:Always unique.Use if present on first priority

//		1st approach:
//		driver.findElement(By.id("Form_submitForm_FirstName")).sendKeys("naveen");
//		driver.findElement(By.id("Form_submitForm_LastName")).sendKeys("automation");

//		2nd approach: Mostly unique but could be duplicate.
//		WebElement firstName = driver.findElement(By.id("Form_submitForm_FirstName"));
//		WebElement secondName = driver.findElement(By.id("Form_submitForm_LastName"));
//		firstName.sendKeys("naveen");
//		secondName.sendKeys("automation");

//		3rd approach:
//		By firstName=By.id("Form_submitForm_FirstName");
//		By secondName= By.id("Form_submitForm_LastName");
//		
//		WebElement fn_ele=driver.findElement(firstName);
//		WebElement ln_ele=driver.findElement(secondName);
//		
//		fn_ele.sendKeys("naveen");
//		ln_ele.sendKeys("automation");

//		4th approach:
//		By firstName=By.id("Form_submitForm_FirstName");
//		By secondName= By.id("Form_submitForm_LastName");
//		getElement(firstName).sendKeys("naveen");
//		getElement(secondName).sendKeys("automation");

//		5th approach:
//		By firstName=By.id("Form_submitForm_FirstName");
//		By secondName= By.id("Form_submitForm_LastName");
//		doSendKeys(firstName, "naveen");
//		doSendKeys(secondName, "automation");

//		6th approach:create a new ElementUtil class with generic functions

//		By firstName=By.id("Form_submitForm_FirstName");
//		By secondName= By.id("Form_submitForm_LastName");
//		
		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doSendKeys(firstName, "naveen");
//		eleUtil.doSendKeys(secondName, "automation");

//--------------------------------Name locator----------------------------------		

//		2.Name locator:ID preferred over name
//		By fN=By.name("FirstName");
//		eleUtil.doSendKeys(fN, "naveen");

//		By agrreCheckBox=By.name("agree");
//		eleUtil.doClick(agrreCheckBox);

//-------------------------------Class Name locator----------------------------

//		3.Class Name:Can be duplicate for multiple elements.Should be used only when unique.Will perform action on first WebElement with the same className.Should have 
//		single class name and not multiple class names spearated by space.
//		By fN=By.className("form-control");
//		eleUtil.doSendKeys(fN, "naveen");

//-----------------------------Link Text Locator-------------------------------

//		4.Link Text:Only for links.a tag represents links
//		By login = By.linkText("Login");
//		eleUtil.doClick(login);

//---------------------------Partial Link Text Locator--------------------------

//		5.Partial Link Text:Only for links.(Not recommended)
//		By forgotPwd=By.partialLinkText("Forgotten");
//		eleUtil.doClick(forgotPwd);

//--------------------------Xpath Locator---------------------------------------

//		6.Xpath:Address of element inside DOM.Not an attribute like id,name and class name.Used for complex addresses.
//		By fN= By.xpath("//*[@id=\"input-firstname\"]");
//		eleUtil.doSendKeys(fN, "naveen");

//------------------------CSS Locator--------------------------------------------

//		7.CSS Locator: Not an attribute like Xpath.Slight better performance over xpath.
//		By lN=By.cssSelector("#input-lastname");
//		eleUtil.doSendKeys(lN, "automation");

//-------------------------Tag Name Locator-----------------------------------

//		8.tag Name:html tag
//		By header=By.tagName("h2");
//		System.out.println(doGetText(header));

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
	 * This method inputs provided value on the WebElement based on the locator
	 * provided.
	 * 
	 * @param locator Pass the locator to identify the WebElement
	 * @param value   Pass the string to be input
	 */
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	/**
	 * This method is used to click the WebElement
	 * 
	 * @param locator Pass the locator to identify the WebElement
	 */
	public static void doClick(By locator) {
		getElement(locator).click();
	}

	/**
	 * This method returns text of the WebElement.
	 * 
	 * @param locator Pass the locator to identify the WebElement
	 * @return This method returns the text of the WebElement.
	 */
	public static String doGetText(By locator) {
		return getElement(locator).getText();
	}
}
