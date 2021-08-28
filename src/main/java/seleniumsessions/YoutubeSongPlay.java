package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YoutubeSongPlay {
	
	static WebDriver driver;
	

	public static void main(String[] args) throws InterruptedException {


		BrowserUtil br=new BrowserUtil();
		driver=br.launchBrowser("chrome");
		driver.manage().window().maximize();
		br.launchUrl("https://www.youtube.com/");
		
		ElementUtil el=new ElementUtil(driver);
		
		By searchInputLocator=By.id("search");
		By searchBtnLocator=By.id("search-icon-legacy");
		
		el.doSendKeys(searchInputLocator, "Dholna");
		
		Thread.sleep(1000);
		
		el.doClick(searchBtnLocator);
		
		Thread.sleep(2000);
		
		By songLocator=By.xpath("//a[@title='B Praak | Crossblade Live | Gurnazar | Dholna | Robby Singh| Latest Punjabi Songs 2019']");
		 el.doClick(songLocator);
		

	}

}
