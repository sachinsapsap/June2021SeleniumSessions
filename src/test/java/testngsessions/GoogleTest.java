package testngsessions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

	@Test(priority=1)
	public void pageTitleTest() {
		String title = driver.getTitle();
		System.out.println("Page Title is :" + title);
		Assert.assertEquals(title, "Google");
	}

	@Test(priority=2)
	public void appPagUrlTest() {
		String url = driver.getCurrentUrl();
		System.out.println("Page URL :" + url);
		Assert.assertTrue(url.contains("google"));
	}

}
