package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalImages {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in");

		By images = By.tagName("img");

		List<WebElement> imagesList = getElements(images);

//		List<WebElement> linksList = driver.findElements(By.tagName("a"));

		System.out.println("Total Images: " + imagesList.size());
		
//		for (int i = 0; i < imagesList.size(); i++) {
//			String altValue = imagesList.get(i).getAttribute("alt");
//			if (!altValue.isEmpty()) {
//				System.out.println(i + " " + altValue);
//			}
//		}
		
		int i=0;
		for (WebElement e:imagesList) {
			String altValue = e.getAttribute("alt");
			if (!altValue.isEmpty()) {
				System.out.println(i+" "+altValue);
			}
			i++;
		}

	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

}
