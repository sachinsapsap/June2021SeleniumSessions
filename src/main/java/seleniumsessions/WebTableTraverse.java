package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableTraverse {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

//		Look for a pattern in Absolute xpath and use the pattern
//		//table[@id="customers"]/tbody/tr[2]/td[1]
//		//table[@id="customers"]/tbody/tr[3]/td[1]
//		//table[@id="customers"]/tbody/tr[4]/td[1]
//		//table[@id="customers"]/tbody/tr[5]/td[1]

		for (int i = 2; i < 8; i++) {
			System.out.println(driver.findElement(By.xpath("//table[@id=\"customers\"]/tbody/tr[" + i + "]/td[1]"))
					.getText() + "           "
					+ driver.findElement(By.xpath("//table[@id=\"customers\"]/tbody/tr[" + i + "]/td[2]")).getText()+"                "
					+driver.findElement(By.xpath("//table[@id=\"customers\"]/tbody/tr["+i+"]/td[3]")).getText());
		}

	}

}
