package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandleWithSet {
	
//	Set cannot take any duplicate values whereas List can take duplicate values.
//	Set will not maintain any indexing.Array List maintains index.

	public static void main(String[] args) {
		
		//browser window pop up or new tab window or new browser window
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");//parent page
		
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();//will open the child window
		
//		if there are 2 windows use below logic:
		Set<String> handles=driver.getWindowHandles();
		
		Iterator<String> it=handles.iterator();
		
//		storing window id's:
		String parentWindow=it.next();
		String childWindow=it.next();
		
		System.out.println(parentWindow);
		System.out.println(childWindow);
		
		
		System.out.println(driver.getTitle());
		
//		switching windows:
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());
		driver.close();

	}

}
