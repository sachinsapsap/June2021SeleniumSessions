package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadPopUp {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		
//		type=file is must for file upload solution taught in this class.
		
		driver.findElement(By.name("upfile")).sendKeys("C:\\Users\\91858\\Desktop\\selenium.png");
		
		driver.findElement(By.xpath("//input[@value='Press']")).click();

	}

}
