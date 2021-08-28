package seleniumsessions;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		
		
//		Starting chrome browser:
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();//Top Casting
		
		
////		Starting Mozilla browser:
//		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
//		WebDriver driver=new FirefoxDriver();

		
		
		
		driver.get("https://www.google.co.in/");
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	
		
	
		
		if(driver.getTitle().equals("Google")) {
			System.out.println("Correct title");
		}
		else {
			System.out.println("Incorrect Title");
		}
		if(driver.getPageSource().contains("nonce")){
			System.out.println("Contains");
		}
		else {
			System.out.println("Does not contain");
		}
		
		driver.close();
		

	}

}
