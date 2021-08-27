package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyElement {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");

		By forgotPwd = By.linkText("Forgotten Password111");
		if(isElementExist(forgotPwd)) {
			System.out.println("PASS");
		}

	}

	public static boolean isElementExist(By locator) {
		List<WebElement> listEle = driver.findElements(locator);
		if (listEle.size() > 0) {
			System.out.println("element is present");
			return true;
		}
		System.out.println("element is not present");
		return false;
	}

}
