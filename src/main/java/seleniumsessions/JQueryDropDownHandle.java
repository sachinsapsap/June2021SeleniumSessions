package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQueryDropDownHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

		driver.findElement(By.id("justAnInputBox")).click();
		Thread.sleep(2000);
		
		By choices = By.cssSelector(".comboTreeItemTitle");

//		1.Single Selection:
		selectChoice(choices, "choice 1");

//		2.Multiple Selection:
//		selectChoice(choices,"choice 1","choice 2","choice 4");

//		3.All selection:
//		selectChoice(choices, "all");
//		selectChoice(choices, "all");//de-select
	}

	/**
	 * This method is used for single,multiple and all values selection of dropdown.
	 * @param locator Pass the locator to identify the dropdown WebElements.
	 * @param value Pass the values to be selected. Pass "all" to select all values.
	 */
	public static void selectChoice(By locator, String... value) {// ... is equivalent to array.String... represents
																	// String[]
		List<WebElement> choiceList = driver.findElements(locator);

		if (!value[0].equalsIgnoreCase("all")) {

			for (WebElement e : choiceList) {
				String text = e.getText();
				for (int i = 0; i < value.length; i++) {
					if (text.equals(value[i])) {
						e.click();
						break;
					}
				}

			}
		}
		
		else {
			try {
			for(WebElement e:choiceList) {
				e.click();
			}
		}
			catch(Exception e) {
				
			}
	}

}
}
