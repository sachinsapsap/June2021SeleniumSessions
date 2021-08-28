package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NaukriResumeUploadTest {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		BrowserUtil br=new BrowserUtil();
		
		driver=br.launchBrowser("chrome");
		driver.manage().window().maximize();
		br.launchUrl("https://www.naukri.com/nlogin/login?URL=https://www.naukri.com/browse-jobs");
		
		
		
		ElementUtil el=new ElementUtil(driver);
		By emailID=By.id("usernameField");
		By passwordBy=By.id("passwordField");
		By loginBtn=By.xpath("//button[text()='Login']");
		
		String userName="sachinsapsap@gmail.com";
		String password="Jaihanuman1!";
		
		
		JavaScriptUtil jsUtil=new JavaScriptUtil(driver);
		
		jsUtil.flash(driver.findElement(emailID));
		el.doSendKeys(emailID, userName);
		
		jsUtil.flash(driver.findElement(passwordBy));
		el.doActionSendKeys(passwordBy, password);
		
		jsUtil.flash(driver.findElement(loginBtn));
		el.doClick(loginBtn);
		
		Thread.sleep(2000);
		
		
		By naukriHover=By.xpath("//div[text()='My Naukri']");
		By editProfile=By.linkText("Edit Profile");
		
		el.twoLevelMenuHandle(naukriHover, editProfile);
		
		Thread.sleep(2000);
		
		By update=By.linkText("UPDATE");
		
		jsUtil.drawBorder(el.getElement(update));
		el.doClick(update);
		
		By uploadBtn=By.id("attachCV");
		String path="C:\\Users\\91858\\Desktop\\Sachin Docs\\Resume_Sachin_22nd July.docx";
		
		el.doFileUpload(uploadBtn, path);
		
		Thread.sleep(3000);
		
		br.quitBrowser();
		
		
		
		
		

		
		

	}

}
