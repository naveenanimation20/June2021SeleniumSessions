package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementIsDisplayed {

static WebDriver driver;
	
	public static void main(String[] args) {

		// webelement + isDisplayed() ---> boolean (true/false)

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/register");

//		boolean flag = driver.findElement(By.name("search")).isDisplayed();
//		
//		System.out.println(flag);
		
		By searchField = By.name("search");
		By searchButton = By.xpath("//*[@id=\"search\"]/span/button");
		
		if(doIsDisplayed(searchField)) {
			doSendKeys(searchField, "Macbook");
			doClick(searchButton);
		}
		
		driver.findElement(By.name("search")).isEnabled();
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	} 
	
	public static boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	
	
	
	

}
