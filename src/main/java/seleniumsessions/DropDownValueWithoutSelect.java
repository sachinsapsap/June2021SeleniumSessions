package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownValueWithoutSelect {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		By industry = By.xpath("//select[@id='Form_submitForm_Industry']/option");
		
		clickDropDownValue(industry, "Education");
		
//		List<WebElement> indusList=driver.findElements(industry);
//		
//		System.out.println(indusList.size());
//		
//		for (WebElement e : indusList) {
//			String text = e.getText();
//			if(text.equals("Education")) {
//				e.click();
//				break;
//			}
//		}
	}
	
	public static void clickDropDownValue(By locator,String value) {
    List<WebElement> optionsList=driver.findElements(locator);
		
		System.out.println(optionsList.size());
		
		for (WebElement e : optionsList) {
			String text = e.getText();
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}

}
