package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementHandle {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("http://mrbool.com/how-to-create-menu-with-submenu-using-css-html/26146");
		
//		WebElement contentMenu = driver.findElement(By.className("menulink"));
//		
//		Actions act = new Actions(driver);
//		
//		act.moveToElement(contentMenu).perform();
//		
//		Thread.sleep(2000);
//		
//		driver.findElement(By.linkText("COURSES")).click();
		
		By parentMenu = By.className("menulink");
		By childMenu = By.linkText("COURSES");
		twoLevelMenuHandle(parentMenu, childMenu);

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void twoLevelMenuHandle(By parentMenu, By childMenu) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);
		getElement(childMenu).click();
	}
	
	public static void threeLevelMenuHandle(By parentMenu1, By parentMenu2, By childMenu) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu1)).perform();
		Thread.sleep(2000);
		act.moveToElement(getElement(parentMenu2)).perform();
		Thread.sleep(2000);
		getElement(childMenu).click();
	}
	
	
	
	

}
