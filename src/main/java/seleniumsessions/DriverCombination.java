package seleniumsessions;

//import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;


public class DriverCombination {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
//		ChromeDriver driver = new ChromeDriver();//only applicable for chrome. Cross Browser cannot be done

		WebDriver driver=new ChromeDriver();
		
//		RemoteWebDriver driver=new ChromeDriver();
		
//		SearchContext driver=new ChromeDriver();//only 2 methods findElement and findElements accessible
		
//		WebDriver d=new RemoteWebDriver(url, capabilities);//only to be used for remote execution
		
		
		
		driver.get("https://www.google.com");
		

	}

}
