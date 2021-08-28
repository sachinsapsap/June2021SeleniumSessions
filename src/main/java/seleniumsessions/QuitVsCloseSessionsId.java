package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Session ID will be null after driver.quit(); NoSuchSessionException :Session ID is null will be given.
//Session ID will be invalid after driver.close();NoSuchSessionException: invalid session id will be given.
//Quit will close the session.Session ID will become null.
//Close will not close the session. Session ID will be there but it will be expired.


public class QuitVsCloseSessionsId {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
//		driver.quit();
//		System.out.println(driver.getTitle());//NoSuchSessionException.Session id is null
		
		driver.close();
		driver=new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());//NoSuchSessionException: invalid session id

	}

}
