package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementWait {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		TimeUtil.smallWait();
		
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@value='Login']");
		
		By navigationLinks = By.cssSelector("aside#column-right a");
		By terms = By.linkText("Terms & Conditions");
		
		
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		WebElement email_ele = wait.until(ExpectedConditions.visibilityOfElementLocated(emailId));
		
//		email_ele.sendKeys("test@gmail.com");
		
//		waitForElementVisibleUsingBy(loginBtn, 5);
//		driver.findElement(password).sendKeys("test123");
//		driver.findElement(loginBtn).click();
		
//		List<WebElement> navLinks = waitForElementsToBeVisible(navigationLinks, 10);
//		for(WebElement e : navLinks) {
//			System.out.println(e.getText());
//		}
		
		if(getElementsTextList(navigationLinks, 10).contains("Register")) {
			System.out.println("Register -- PASS");
		}
		
		clickWhenReady(terms, 5);
		
	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	/**
	 * An expectation for checking an element is visible and enabled such that you can click it.
	 * @param locator
	 * @param timeOut
	 */
	public static WebElement waitForElementToBeClickable(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static void clickWhenReady(By locator, int timeOut) {
		waitForElementToBeClickable(locator, timeOut).click();
	}
	
	
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible. 
	 * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement waitForElementVisibleUsingBy(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static WebElement waitForElementVisibleUsingWebElement(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
	}
	
	
	public static List<WebElement> waitForElementsToBeVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public static List<String> getElementsTextList(By locator, int timeOut) {
		List<WebElement> eleList = waitForElementsToBeVisible(locator, timeOut);
		List<String> eleTextList = new ArrayList<String>();
		for(WebElement e : eleList) {
			eleTextList.add(e.getText());
		}
		return eleTextList;
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

}
