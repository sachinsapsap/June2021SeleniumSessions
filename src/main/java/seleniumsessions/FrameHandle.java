package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//         driver.switchTo().frame is a class example of Method Overloading inside selenium.
//         We have 3 methods frame for parameters int index, String frame Name or ID and WebElement 

public class FrameHandle {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		
		By frame=By.tagName("frame");
		List<WebElement> listFrames=driver.findElements(frame);
		System.out.println(listFrames.size());//count number of frames inside DOM
		
//		driver.switchTo().frame(2);
		
//		driver.switchTo().frame("main");
		
		driver.switchTo().frame(driver.findElement(By.name("main")));
		
		
		String header=driver.findElement(By.xpath("/html/body/h2")).getText();//No such element exception
		System.out.println(header);
		
		driver.switchTo().defaultContent();
		
		
		
		
		

	}

}
