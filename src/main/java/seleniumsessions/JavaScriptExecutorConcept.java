package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorConcept {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		driver.get("https://www.amazon.in/");
		
		JavaScriptUtil jsUtil=new JavaScriptUtil(driver);
		String title=jsUtil.getTitleByJS();
		System.out.println(title);
		
//		jsUtil.refreshBrowserByJS();
		
//		String text=jsUtil.getPageInnerText();
//		if(text.contains("Contact Management")) {
//			System.out.println("PASS");
//		}
		
//		jsUtil.generateAlert("Hi, This is Sachin");//can be used for demo purposes and debugging.
//		driver.switchTo().alert().accept();
//		driver.switchTo().defaultContent();
		
//		jsUtil.flash(driver.findElement(By.xpath("//input[@value='Login']")));
//		
//		WebElement emailID=driver.findElement(By.id("input-email"));
//		WebElement password=driver.findElement(By.id("input-password"));
//		WebElement loginBtn=driver.findElement(By.xpath("//input[@value='Login']"));
//		
//		jsUtil.flash(emailID);
//		emailID.sendKeys("naveen");
//		jsUtil.flash(password);
//		password.sendKeys("test123");
//		jsUtil.flash(loginBtn);
//		loginBtn.click();
		
//		jsUtil.clickElementByJS(loginBtn);
		
//		jsUtil.scrollPageDown();
//		Thread.sleep(2000);
//		jsUtil.scrollPageUp();
//		Thread.sleep(2000);
//		jsUtil.scrollPageDown("1000");
		
		
		
		WebElement ele=driver.findElement(By.id("twotabsearchtextbox"));
//		jsUtil.scrollIntoView(ele);
//		
		jsUtil.drawBorder(ele);
		
		
		

	}

}
