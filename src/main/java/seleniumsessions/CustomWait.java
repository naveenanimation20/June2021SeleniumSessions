package seleniumsessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWait {

	static WebDriver driver;

	public static void main(String[] args) {

		// use only sleep();
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		By emailId = By.id("input-email11");
		
		retryingElement(emailId).sendKeys("test@gmail.com");

	}

	public static WebElement retryingElement(By locator) {
		WebElement element = null;
		int attempts = 0;
		while(attempts < 20) {
			try {
				element = driver.findElement(locator);
				break;
			}
			catch(NoSuchElementException e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println("element is not found in attempt : " + (attempts+1));
			}
			attempts++;
		}
		return element;
	}

}
