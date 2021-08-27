package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CRMProFrame {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://classic.crmpro.com/");
		
		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("mainpanel");
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.linkText("CONTACTS"))).perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("New Contact")).click();
		driver.findElement(By.id("first_name")).sendKeys("naveen");

		
		
		
	}

}
