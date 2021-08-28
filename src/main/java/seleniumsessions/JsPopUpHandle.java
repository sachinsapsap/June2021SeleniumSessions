package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JsPopUpHandle {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		driver.findElement(By.name("proceed")).click();

		Alert alert=driver.switchTo().alert();
		
		String text=alert.getText();//get text in the alert
		System.out.println(text);
		alert.accept();//accept the alert
//		alert.dismiss();//dismiss the alert.Equivalent to cancel the alert
//		alert.sendKeys("Test");//Recently added to input text on any input field in an alert
		
		driver.switchTo().defaultContent();

	}

}
