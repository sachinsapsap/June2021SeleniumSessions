package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadLessBrowser {

	public static void main(String[] args) {
		
//		headless-no browser
//		testing is happening behind the scenes.
//		Comparatively faster.
//		not sure where driver is.
//		doesn't work for some pop-ups, alerts etc.
//		Recommended for sanity and smoke tests.
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions co=new ChromeOptions();
//		co.addArguments("--headless");
		co.addArguments("--incognito");
		WebDriver driver=new ChromeDriver(co);
		
//		WebDriverManager.firefoxdriver().setup();
//		FirefoxOptions fo=new FirefoxOptions();
//		fo.addArguments("--incognito");
//		WebDriver driver=new FirefoxDriver(fo);
		
		driver.get("http://www.amazon.com");
		
		System.out.println(driver.getTitle());

		driver.quit();
	}

}
