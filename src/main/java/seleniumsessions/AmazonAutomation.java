package seleniumsessions;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;


public class AmazonAutomation {

	public static void main(String[] args) {

		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.launchBrowser("chrome");
		br.launchUrl("https://www.amazon.in/");
		driver.manage().window().maximize();

		JavaScriptUtil js = new JavaScriptUtil(driver);
		js.scrollPageDown();;
		
		TimeUtil.smallWait();
		
		js.clickElementByJS(driver.findElement(By.cssSelector("div#navFooter div.navFooterBackToTop")));
		
		
		

	}

}
