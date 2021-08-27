package testngsessions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RediffMailTest extends BaseTest {

	@Test(priority = 1)
	public void pageTitleTest() {
		String title = driver.getTitle();
		System.out.println("page title is : " + title);
		Assert.assertEquals(title, "Rediffmail");
	}

	@Test(priority = 2)
	public void appPageUrlTest() {
		String url = driver.getCurrentUrl();
		System.out.println("page url: " + url);
		Assert.assertTrue(url.contains("rediff"));
	}

}
