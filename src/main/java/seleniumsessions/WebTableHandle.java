package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"https://www.espncricinfo.com/series/bangladesh-in-zimbabwe-2021-1267671/zimbabwe-vs-bangladesh-3rd-t20i-1267682/full-scorecard");

		System.out.println(getWicketTakerName("Tadiwanashe Marumani"));
		System.out.println(getWicketTakerName("Wessley Madhevere"));
		List<String> scoreList1=getScoreList("Tadiwanashe Marumani");
		List<String> scoreList2=getScoreList("Wessley Madhevere");
		
		System.out.println(scoreList1);
		System.out.println(scoreList2);
		

	}

	public static String getWicketTakerName(String playerName) {
		String wicketTaker = "//a[text()='" + playerName + "']//parent::td/following-sibling::td/span";
		return driver.findElement(By.xpath(wicketTaker)).getText();
	}
	
	public static List<String> getScoreList(String playerName) {
		List<String> scoreValueList=new ArrayList<String>();
		String scoreXpath="//a[text()='"+playerName+"']//parent::td/following-sibling::td";
		List<WebElement> scoreList=driver.findElements(By.xpath(scoreXpath));
		for(int i=1;i<scoreList.size();i++) {
			scoreValueList.add(scoreList.get(i).getText());
		}
		return scoreValueList;
	}

}
