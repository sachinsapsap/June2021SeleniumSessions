package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoOpenCartTest {

	public static void main(String[] args) {


		String browser = "chrome";

		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.launchBrowser(browser);
		brUtil.launchUrl("https://demo.opencart.com/index.php?route=account/register");
		System.out.println(brUtil.getPageTitle());

		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");
		By email=By.id("input-email");
		By telephone=By.id("input-telephone");
		By password=By.id("input-password");
		By passwordConfirm=By.id("input-confirm");
		

		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(firstName, "Sachin");
		eleUtil.doSendKeys(lastName, "Srivastava");
		eleUtil.doSendKeys(email, "sachinsapsap@gmail.com");
		eleUtil.doSendKeys(telephone, "8587037859");
		eleUtil.doSendKeys(password, "password");
		eleUtil.doSendKeys(passwordConfirm, "password");
		

		brUtil.closeBrowser();


	}

}
