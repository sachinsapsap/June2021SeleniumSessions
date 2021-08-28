package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRMAppTest {

	public static void main(String[] args) {

		String browser = "chrome";

		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.launchBrowser(browser);
		brUtil.launchUrl("https://www.orangehrm.com/orangehrm-30-day-trial");
		System.out.println(brUtil.getPageTitle());

		By firstName = By.id("Form_submitForm_FirstName");
		By lastName = By.id("Form_submitForm_LastName");
		By email=By.id("Form_submitForm_Email");
		By jobTitle=By.id("Form_submitForm_JobTitle");
		By company=By.id("Form_submitForm_CompanyName");
		By phoneNumber=By.id("Form_submitForm_Contact");

		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(firstName, "Sachin");
		eleUtil.doSendKeys(lastName, "Srivastava");
		eleUtil.doSendKeys(email, "sachinsapsap@gmail.com");
		eleUtil.doSendKeys(jobTitle, "Lead Engineer");
		eleUtil.doSendKeys(company, "FIS Global");
		eleUtil.doSendKeys(phoneNumber, "8587037859");

		brUtil.closeBrowser();

	}

}
