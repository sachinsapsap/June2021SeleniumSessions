package seleniumsessions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandleWithList {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");//parent page
		
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']")).click();
		
		//for handling multiple windows:
		Set<String> handles=driver.getWindowHandles();
		
		List<String> handlesList=new ArrayList<String>(handles);
		
		
		System.out.println(driver.switchTo().window(handlesList.get(0)).getTitle());
		System.out.println(driver.switchTo().window(handlesList.get(1)).getTitle());
		System.out.println(driver.switchTo().window(handlesList.get(2)).getTitle());
		
		driver.quit();
		

	}

}
