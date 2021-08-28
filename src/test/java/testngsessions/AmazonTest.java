package testngsessions;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Errors;

public class AmazonTest extends BaseTest {

//	testng method can never be static

	@Test(priority=1)
	public void pageTitleTest() {
		String title = driver.getTitle();
		System.out.println("Page Title is :" + title);
		Assert.assertEquals(title,
				"Amazon.com. Spend less. Smile more.11111",Errors.TITLE_MISMATCHED_MESSG);
	}

	@Test(priority=2, enabled = true)
	public void appPagUrlTest() {
		String url = driver.getCurrentUrl();
		System.out.println("Page URL :" + url);
		Assert.assertTrue(url.contains("amazon11"),Errors.URL_MISMATCHED_MESSG);
	}

	@Test(priority=3)
	public void searchBoxTest() {
		Assert.assertTrue(driver.findElement(By.id("twotabsearchtextbox")).isDisplayed());
	}

}
