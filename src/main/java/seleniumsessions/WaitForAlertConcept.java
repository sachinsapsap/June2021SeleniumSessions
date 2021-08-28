package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

class WaitForAlertConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
//		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		driver.findElement(By.linkText("Register")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 5);
		if(wait.until(ExpectedConditions.urlContains("/register"))) {
			System.out.println(driver.getCurrentUrl());
		}
		
//		driver.findElement(By.name("proceed")).click();
		
//		driver.switchTo().alert();//No Alert Present Exception if alert not present or loaded
		
//		WebDriverWait wait=new WebDriverWait(driver, 10);
//		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
//		Alert alert=waitForAlert(10);
//		System.out.println(alert.getText());
//		alert.accept();
//		System.out.println(getAlertText(5));
//		acceptAlert(5);
		
		
//		Title using Wait:
//		WebDriverWait wait=new WebDriverWait(driver, 10);
//		Boolean flag=wait.until(ExpectedConditions.titleContains("Account"));
//		if(flag) {
//			System.out.println(driver.getTitle());
//		}
		
//		System.out.println(waitForTitleContains("Rediff", 10));
		

	}

	public static Alert waitForAlert(int timeout) {
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	
	public static String getAlertText(int timeout) {
		return waitForAlert(timeout).getText();
	}
	
	public static void acceptAlert(int timeout) {
		waitForAlert(timeout).accept();
	}
	
	public static void dismissAlert(int timeout) {
		waitForAlert(timeout).dismiss();
	}
	
	public static void sendKeysOnAler(int timeout, String value) {
		waitForAlert(timeout).sendKeys(value);
	}
	
	
	public static String waitForTitleContains(String titleValue,int timeout) {
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		if(wait.until(ExpectedConditions.titleContains(titleValue))) {
			return driver.getTitle();
		}
		else {
			return null;
		}
	}
	
	
	public static String waitForTitleIs(String fullTitleValue,int timeout) {
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		if(wait.until(ExpectedConditions.titleIs(fullTitleValue))) {
			return driver.getTitle();
		}
		else {
			return null;
		}
	}
	
	

	public static String waitForUrlContains(String urlFraction,int timeout) {
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		if(wait.until(ExpectedConditions.urlContains(urlFraction))) {
			return driver.getCurrentUrl();
		}
		else {
			return null;
		}
	}
	
	public static String waitForUrlToBe(String url,int timeout) {
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		if(wait.until(ExpectedConditions.urlToBe(url))) {
			return driver.getCurrentUrl();
		}
		else {
			return null;
		}
	}
	
}
