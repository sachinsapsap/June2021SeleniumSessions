package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		
		By links=By.tagName("a");
		
		List<WebElement> linksList=getElements(links);

//		List<WebElement> linksList = driver.findElements(By.tagName("a"));

		System.out.println("Total links: " + linksList.size());

//		for (int i = 0; i < linksList.size(); i++) {
//			String text = linksList.get(i).getText();
//			if (!text.isEmpty()) {
//				System.out.println(i + " " + text);
//			}
//		}
		
		int i=0;
		for (WebElement e:linksList) {
			String text = e.getText();
			if (!text.isEmpty()) {
				System.out.println(i+" " + text);
			}
			i=i+1;
		}

	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

}
