package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsSendKeysAndClick {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@value='Login']");
		
//		Actions act = new Actions(driver);
//		
//		act.sendKeys(driver.findElement(emailId), "naveenanimation20@gmail.com").perform();
//		act.sendKeys(driver.findElement(password), "Selenium12345").perform();
//		act.click(driver.findElement(loginBtn)).perform();
		
		doActionsSendKeys(emailId, "naveenanimation20@gmail.com");
		doActionsSendKeys(password, "Selenium12345");
		doActionsClick(loginBtn);

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}
	
	public static void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}
	
	
	
	
	

}
