package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagination {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://classic.freecrm.com/");

		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Thread.sleep(2000);
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.linkText("CONTACTS")).click();
		
		By pageList=By.xpath("(//div[@class='pagination'])[1]//a");
		pagination(pageList, "Veeresh Gadag");

//		List<WebElement> pageList = driver.findElements(By.xpath("(//div[@class='pagination'])[1]//a"));
//
//		int i = 0;
//		while (true) {
//			if (driver.findElements(By.linkText("Sania Mirza")).size() > 0) {
//				selectContact("Sania Mirza");
//				break;
//			} else {
//				pageList.get(i).click();
//				pageList = driver.findElements(By.xpath("(//div[@class='pagination'])[1]//a"));
//			}
//			i++;
//		}

	}

	public static void selectContact(String name) {
		String checkbox = "//a[text()='" + name + "']//parent::td//preceding-sibling::td/input";
		driver.findElement(By.xpath(checkbox)).click();
	}
	
	public static void pagination(By locator, String name) {
		List<WebElement> pageList = driver.findElements(locator);

		int i = 0;
		while (true) {
			if (driver.findElements(By.linkText(name)).size() > 0) {
				selectContact(name);
				break;
			} else {
				try {
					pageList.get(i).click();
				} catch (Exception e) {//handle array out of bound exception
					System.out.println("Pagination is over...Contact not found");
					break;
				}
				pageList = driver.findElements(locator);//to handle Stale Element Reference Exception, assigning List again after page reload.
			}
			i++;
		}
	}
}


