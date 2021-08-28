package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Custom_Xpath_1 {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");

//      xpath-->address of the element in HTML DOM

//		1.absolute xpath:Complete address starting from html.  /html/body/div/div[3]/div[4]/ul/li[3]/a. Not recommended.
//		2.relative xpath: Relative address. Using htmltag and its attributes + functions+ xpath axes.

//		1.Single Attribute:
		// htmltag[@attr='value']
		// input[@id='input-email']
		// input[@name='email']

//		2.Multiple Attributes(AND OR):
		// htmltag[@attr1='value' and @attr2='value']
		// input[@name='email' and @type='text']
		//input[@type='text' or @type='email']

//		3.Indexing concept/ position function/last function:
//		()// htmltag[@attr='value'])[index]
//		(//input[@class='form-control'])[1]
//		(//input[@class='form-control'])[2]
		
//		()// htmltag[@attr='value'])[position()=indexvalue]
//		(//input[@class='form-control'])[position()=1]
		
//		()// htmltag[@attr='value'])[last()]
//		(//input[@class='form-control'])[last()]
		
//		(//input[@class='form-control'])[position()=last()]
		
//		4.text() function:
		// htmltag[text()='value']
        //a[text()='Login']
        //h3[text()='Marketing Campaigns']
		//span[text()=' sign up']
		
//		5.contains() function. Used when attribute values are dynamic but a portion of the attribute value is constant.
		//htmltag[contains(@attr,'value')]
		//input[contains(@id,'email')]
		
//		6.contains() with text():
		//htmltag[contains(text(),'value']
		//input[contains(text(),'email')]
		
//		7.contains with one attribute and second attribute without contains:
		//htmltag[contains(@attr1,'value') and @attr2='value']
		//input[contains(@id,'email') and @type='text']
		
//		8.contains with text() and attributes:
		//htmltag[contains(text(),'value') and @attr='value']
		//a[contains(text(),'Contact Sales') and @href='/Contact Sales/']
		
//		9.contains with text() and contains with attributes:
		//htmltag[contains(text(),'value') and contains(@attr,'value')]
		//a[contains(text(),'Contact Sales') and contains(@class,'btn-orange')]
		
//		10.starts-with() function:
		//htmltag[starts-with(@attr,'value')]
		//htmltag[starts-with(text(),'value']
		//input[starts-with(@id,'firstname_')]
		
//		11. No ends-with function now
		
//		12.//*[@attr='value'].Here * means check all html tags having attr value equal to value. This slows performance.
		

//		String xpath1 = "//input[@name=\"email\"]";
		String xpath2 = "//input[@name='email']";
		
		String loginLink="Login";

//		By emailLocator=getByLocator("xpath", xpath2);
//		getElement(emailLocator).sendKeys("naveen");

		getElement("xpath", xpath2).sendKeys("naveen");
		getElement("linkText", loginLink).click();

	}

	public static By getByLocator(String locatorType, String locatorValue) {
		By locator = null;
		switch (locatorType) {
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "className":
			locator = By.className(locatorValue);
			break;
		case "linkText":
			locator = By.linkText(locatorValue);
			break;
		case "partialLinkText":
			locator = By.partialLinkText(locatorValue);
			break;
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
		case "cssSelector":
			locator = By.cssSelector(locatorValue);
			break;
		case "tagName":
			locator = By.tagName(locatorValue);
			break;
		default:
			System.out.println("Enter correct Locator Type");
			break;
		}
		return locator;
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static WebElement getElement(String locatorType, String locatorValue) {
		return driver.findElement(getByLocator(locatorType, locatorValue));
	}
}
