package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForAlertConcept {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");

//		driver.findElement(By.name("proceed")).click();
//
//		String text = getAlertText(5);
//		System.out.println(text);
		
		//titles:
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		if(wait.until(ExpectedConditions.titleContains("Login"))) {
//			System.out.println(driver.getTitle());
//		}

//		String title = waitForTitleContains("Login", 5);
//		System.out.println(title);
		
		driver.findElement(By.linkText("Register")).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		if(wait.until(ExpectedConditions.urlContains("/register"))) {
			System.out.println(driver.getCurrentUrl());
		}
		
		
		
	}
	
	public static String waitForUrlContains(String urlFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		if(wait.until(ExpectedConditions.urlContains(urlFraction))) {
			return driver.getCurrentUrl();
		}
		return null;
	}
	
	public static String waitForFullUrl(String urlValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		if(wait.until(ExpectedConditions.urlToBe(urlValue))) {
			return driver.getCurrentUrl();
		}
		return null;
	}
	
	
	
	
	public static String waitForTitleContains(String titleValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		if(wait.until(ExpectedConditions.titleContains(titleValue))) {
			return driver.getTitle();
		}
		return null;
	}
	
	public static String waitForTitleIs(String fullTitle, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		if(wait.until(ExpectedConditions.titleIs(fullTitle))) {
			return driver.getTitle();
		}
		return null;
	}
	
	
	

	public static Alert waitForAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public static String getAlertText(int timeOut) {
		String text = waitForAlert(timeOut).getText();
		acceptAlert(timeOut);
		return text;
	}

	public static void acceptAlert(int timeOut) {
		waitForAlert(timeOut).accept();
	}

	public static void dismissAlert(int timeOut) {
		waitForAlert(timeOut).dismiss();
	}

	public static void sendKeysOnAlert(int timeOut, String value) {
		waitForAlert(timeOut).sendKeys(value);
	}

}
