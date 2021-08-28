package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthPopUpHandle {

	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		String username="admin";
		String password="admin";
		
		driver.get("https://"+username+":" +password+ "@" + "the-internet.herokuapp.com/basic_auth");
		
//		This scenario can be handled by Chrome Dev Tools protocols(CDP).Will be taught later as part of selenium 4.
//		CDP-selenium 4
//		cypress uses CDP

	}

}
