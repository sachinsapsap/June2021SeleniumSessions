package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickMenuHandle {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		By rightClickEle = By.xpath("//p/span[text()='right click me']");
		
		doRightClick(rightClickEle);
		
		
		
//
//		Actions act = new Actions(driver);
//		act.contextClick(rightClickEle).perform();

//		List<WebElement> itemList = driver
//				.findElements(By.xpath("//li[contains(@class,'context-menu-item context-menu-icon')]/span"));
//
//		System.out.println(itemList.size());
//
//		for (WebElement e : itemList) {
//			String text = e.getText();
//			if (text.equals("Copy")) {
//				e.click();
//				break;
//			}
//		}
		
		By rightCLickOptionEle=By.xpath("//li[contains(@class,'context-menu-item context-menu-icon')]/span");
		dorightClick(rightCLickOptionEle, "Copy");

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	
	public static void doRightClick(By locator) {
		Actions act = new Actions(driver);
		act.contextClick(getElement(locator)).perform();
	}
	
	public static void dorightClick(By locator, String value) {
		List<WebElement> rightClickOptionsList=getElements(locator);
		System.out.println(rightClickOptionsList.size());
		for(WebElement e: rightClickOptionsList) {
			String text=e.getText();
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}

}
