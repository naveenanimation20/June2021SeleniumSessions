package testngsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTestBM {
	
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
	}

	@Test
	public void pageTitleTest() {
		String title = driver.getTitle();
		System.out.println("page title is : " + title);
		Assert.assertEquals(title,
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}

	@Test
	public void appPageUrlTest() {
		String url = driver.getCurrentUrl();
		System.out.println("page url: " + url);
		Assert.assertTrue(url.contains("amazon"));
	}

	@Test
	public void seachBoxTest() {
		Assert.assertTrue(driver.findElement(By.id("twotabsearchtextbox")).isDisplayed());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
