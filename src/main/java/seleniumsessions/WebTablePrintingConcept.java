package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablePrintingConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://classic.freecrm.com");
		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("mainpanel");
		
		driver.findElement(By.linkText("CONTACTS")).click();
		
		
		//form[@id="vContactsForm"]/table/tbody/tr[10]/td[2]/a
		
		List<WebElement> noOFContactsList=driver.findElements(By.xpath("//form[@id='vContactsForm']/table/tbody/tr"));
		int length=noOFContactsList.size();
		System.out.println(length);
		
		for(int i=4;i<length-1;i++) {
			System.out.println(driver.findElement(By.xpath("//form[@id='vContactsForm']/table/tbody/tr["+i+"]/td[2]/a")).getText());
		}
		

	}

}
