package seleniumsessions;

import org.openqa.selenium.WebDriver;

public class AmazonTest {

	public static void main(String[] args) {
		
		BrowserUtil br=new BrowserUtil();
		
		WebDriver driver=br.launchBrowser("chrome");
		
		br.launchUrl("https://www.amazon.com");
		
		System.out.println(br.getPageTitle());
		System.out.println(br.getPageUrl());
		
		br.closeBrowser();
		
		
		

	}

}
