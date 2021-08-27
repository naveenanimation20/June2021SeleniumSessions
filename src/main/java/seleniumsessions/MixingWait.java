package seleniumsessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MixingWait {

	public static void main(String[] args) {

		//imp wait + exp wait
		//never use both the waits together
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		By emailId = By.id("input-email");

		//e1 e2 e3 e4 ...e10 --> 20 secs
		
		//e2 -- custom wait --> webdriver wait (Exp wait) --> 10 secs
		
		WebElement email = driver.findElement(emailId);//20
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, 10, 2000);//10
		wait.until(ExpectedConditions.presenceOfElementLocated(emailId)).sendKeys("test@gmail.com");

		
		
		
	}

}
