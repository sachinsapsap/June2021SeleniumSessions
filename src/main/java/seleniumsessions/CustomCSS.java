package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomCSS {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
//		driver.get("https://app.hubspot.com/login");
		
//		CSS:Cascaded Style Sheet
//      cssSelector:is a locator but not an attribute
		
//		id:
//		#{id}--->#txtUsername
//		tagName#id-->input#txtUsername
		
//		class:
//		.{class}--->.login-email
//		tagName.class-->input.login-email
//		.c1.c2.c3.c4...cn---->.form-control.private-form__control.login-email
//		tagName.c1.c2.c3.c4...cn--->input.form-control.private-form__control.login-email
		
		
//		By.cssSelector("input.login-email");
//		By.cssSelector(".form-control.private-form__control.login-email");
		
//		id and class:
//		#id.class----->#username.login-email---->#input-email.form-control
//		.class#id------>.login-email#username----->.form-control#input-email
//		tagName#id.class--->input#username.login-email
//		tagName.class#id--->input.login-email#username
//		tagName.c1.c2.c3...cn#id------>input.form-control.private-form__control.login-email#username
//		tagName#id.c1.c2.c3...cn------>input#username.form-control.private-form__control.login-email
		
//		other attributes: This is generally used when id and class is not used.
//		tagName[attribute='value']----->input[id='input-email']
//		tagName[attribute1='value'][attribute2='value']----->input[id='input-email'][type='text']
		
		
//		contains in CSS:
//		tagName[attribute*='value']--->input[id*='FirstName']
//		input[id*='FirstName'][name='FirstName']
		
//		starts with in CSS:
//		tagName[attribute^='value']----->input[name^='First']
//		input[name^='First'][id*='FirstName']
		
//		ends with in CSS:
//		tagName[attribute$='value]----->input[id$='FirstName']
		
		
//		parent to child:
//		form#hs-login>div--->8 This is direct child of the parent
//		form#hs-login div--->20 This is direct + indirect child of the parent
//		div.navFooterVerticalRow.navAccessibility a---22 links in footer of Amazon
//		ul.footer-nav a----Total footer links
//		select#Form_submitForm_Industry>option---All dropdown values
		
		List<WebElement> dropdownOptionsELeList=driver.findElements(By.cssSelector("select#Form_submitForm_Industry>option"));
		
		for(WebElement e: dropdownOptionsELeList) {
			System.out.println(e.getText());
		}
		
		
//		child to parent:
//		no backward traversing in CSS. Hence we cannot web table scenarios.
		
//		not in CSS:
//		:not
//		input.form-control.private-form__control:not(.login-email)
//		input.form-control.private-form__control:not(#username)
//		input.text:not(#Form_submitForm_JobTitle)
//		input.text:not(#Form_submitForm_JobTitle,[name='FirstName'])----to exclude Multiple elements
		
//		comma in CSS:
//		input#username,input#password,button#loginBtn,a[href*='signup']
		
		
		
//		List<WebElement> mandatoryEle=driver.findElements(By.cssSelector("input#username,input#password,button#loginBtn,a[href*='signup']"));
//		
//		if(mandatoryEle.size()==4) {
//			System.out.println("All mandatory elements present");
//		}
//		
		
//		nth-of-type---for Indexing using CSS:
//		.footer-nav li:nth-of-type(1)
//		select#Form_submitForm_Industry > option:nth-of-type(5)
//		select#Form_submitForm_Industry > option:nth-of-type(n)------>it will give all elements
		
		
//		following sibling in CSS:Used through + sign
//		div.private-form__input-wrapper + div

		
		
//		preceding-sibling in CSS:NA
		
//		xpath vs css:
//		Backward traversing not allowed in CSS.
//		no text() function in CSS.
//		comma operator and not operator extra in CSS.
//		Performance:1000 elements ----xpath--1hr
//		css---55 mins
		
//		WebTable---xpath
//		id-----By.id
//		dynamic id----css contains or xpath conatins
//		multiple elements------css comma operator
//		backward traversing-----xpath
//		text()------xpath
		
	}

}
