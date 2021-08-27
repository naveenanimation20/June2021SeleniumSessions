package testngsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest {

	WebDriver driver;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
	}

	
	
	@Test
	public void loginTest() {
		Assert.assertTrue(doLogin("naveenanimation20@gmail.com", "Selenium12345"));
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		return new Object[][] {
									{"naveen@gmail.com", "naveen123"},
									{"naveenanimation20@gmail.com", "naveen23"},
									{"    ", "     "},
									{"naveen@gmail.com", "    "},
									{"    ", "test123"}
								};
	}
	
	
	@Test(dataProvider = "getLoginData")
	public void login_NegativeTest(String un, String pwd) {
		Assert.assertTrue(doLogin(un, pwd), "....accepting incorrect credentials....");
	}

	public boolean doLogin(String un, String pwd) {
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(un);
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		return driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).isDisplayed();
	}

	@AfterTest
	public void tearDown() {
		//driver.quit();
	}

}
