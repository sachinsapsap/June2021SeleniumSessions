package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleLanguageLinks {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in");

		By langlinks = By.xpath("//div[@id=\"SIvCob\"]/a");

		clickOnElement(langlinks, "मराठी");
		
//		List<WebElement> langList = driver.findElements(langlinks);

//		System.out.println(langList.size());
//
//		for (WebElement e : langList) {
//			System.out.println(e.getText());
//			if (e.getText().equals("मराठी")) {
//				e.click();
//				break;
//			}
//		}

	}
	
	public static List<WebElement> getElements(By locator){
		return driver.findElements(locator);
	}
	
	public static void clickOnElement(By locator, String value) {
		List<WebElement> eleList=getElements(locator);
		for(WebElement e: eleList) {
			if(e.getText().equals(value)) {
				e.click();
			}
		}
	}

}
