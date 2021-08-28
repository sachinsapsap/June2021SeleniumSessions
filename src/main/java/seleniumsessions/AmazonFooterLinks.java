package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonFooterLinks {

	static WebDriver driver;

	public static void main(String[] args) {

		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchUrl("https://www.amazon.in");

		By footerLinks = By.xpath("//div[@class='navFooterVerticalRow navAccessibility']//a");
		
		List<String> footerList=getLinksTextList(footerLinks);
		
		
//		Validation checks
		if(footerList.size()==22) {
			System.out.println("footer list count is correct");
		}
		
		if(footerList.contains("About Us")) {
			System.out.println("About Us is present");
		}

//		ElementUtil eleUtil = new ElementUtil(driver);
//		List<WebElement> footerList = eleUtil.getElements(footerLinks);
//		System.out.println(footerList.size());
//
//		for (WebElement e : footerList) {
//			System.out.println(e.getText());
//		}

	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static List<String> getLinksTextList(By locator) {
		List<String> eleTextList = new ArrayList<>();
		List<WebElement> eleList = getElements(locator);
		System.out.println("Element count: " + eleList.size());
		for (WebElement e : eleList) {
			String text=e.getText();
			if(!text.isEmpty()) {
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}

}
