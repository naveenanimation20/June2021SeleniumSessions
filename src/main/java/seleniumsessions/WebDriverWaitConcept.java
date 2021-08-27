package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitConcept {
	static WebDriver driver;

	public static void main(String[] args) {

		// 2. dynmaic wait --> 10 secs --> if ele is found within 4 secs (rest of the 6
		// secs will be ignored)
		// a. implicityly wait
		// b. explict wait --> WebDriverWait (c) --> FluentWait (c) --> Wait (I)

		// custom wait -> you can define your own wait for a specific element
		// not a global wait
		// can be applied for web elements and non webelements (alert, pop up, title,
		// url)

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		By emailId = By.id("input-email11");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@value='Login']");

//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.presenceOfElementLocated(emailId)).sendKeys("naveen@gmail.com");
		
		waitForElementPresence(emailId, 10, 2000).sendKeys("naveen@gmail.com");
		driver.findElement(password).sendKeys("test123");
		driver.findElement(loginBtn).click();
		
	}
	
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page. 
	 * This does not necessarily mean that the element is visible.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static WebElement waitForElementPresence(By locator, int timeOut, int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut, intervalTime);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	
	
	

}
