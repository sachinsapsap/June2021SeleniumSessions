package seleniumsessions;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpath_Axes {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://classic.freecrm.com");
		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("mainpanel");
		
		driver.findElement(By.linkText("CONTACTS")).click();
		
//		selectContact("Aastha Grover");
//		selectContact("Akshay patil");
		
//		select all checboxes:
		selectAllContact();
		
		
		
		System.out.println(getCompanyName("Aastha Grover"));
		
		List<String> contactDetailsList=getContactDetails("Aastha Grover");
		System.out.println(contactDetailsList);
		
//		parent to child traverse:
//		direct child:/
//		indirect child + direct child://
		
		//div[@class='private-form__input-wrapper']//child::input[@id='username']
		
//		child to parent traverse(backward traversing):
		
//		Immediate parent(Always 1):
		//input[@id='username']/../../../../..
//		            OR
		//input[@id='username']//parent::div
		//input[@id='input-email']//parent::div
		
//		All the parents or grandparents:
		//input[@id='input-email']//ancestor::div
		
		
//		sibling traversing:
//		preceding sibling
		//a[text()='Aastha Grover']//parent::td//preceding-sibling::td/input
		//a[text()='AB DEvilliers']//parent::td//preceding-sibling::td/input
		
		
//		following sibling
		//a[text()='Aastha Grover']//parent::td//following-sibling::td/a[@context='company']
		
		
		
		

	}
	
	public static void selectContact(String name) {
		String checkbox="//a[text()='"+name+"']//parent::td//preceding-sibling::td/input";
		driver.findElement(By.xpath(checkbox)).click();
	}
	

	public static void selectAllContact() {
		String checkbox="//input[@type='checkbox' and @name='contact_id']";
		List<WebElement> checkBoxList=driver.findElements(By.xpath(checkbox));
		for(int i=1;i<checkBoxList.size();i++) {
			checkBoxList.get(i).click();
		}
	}
	
	public static String getCompanyName(String name) {
		String companyName="//a[text()='"+name+"']//parent::td//following-sibling::td/a[@context='company']";
		return driver.findElement(By.xpath(companyName)).getText();
	}
	
	public static List<String> getContactDetails(String name) {
		List<String> contactDetailsList = new ArrayList<>();
		String contact="//a[text()='"+name+"']//parent::td//following-sibling::td";
		List<WebElement> contactDetailsEle=driver.findElements(By.xpath(contact));
		
		for(int i=1;i<contactDetailsEle.size()-1;i++) {
			contactDetailsList.add(contactDetailsEle.get(i).getText());
		}
		return contactDetailsList;
		
	}

}
