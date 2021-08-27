package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserTest {
	static WebDriver driver;

	public static void main(String[] args) {

		String browser = "chrome";

		//cross browser testing:
		if (browser.equals("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			//System.setProperty("webdriver.gecko.driver", "/Users/naveenautomationlabs/Downloads/geckodriver");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("please pass the correct browser....");
		}

		//test script:
		driver.get("https://www.google.com");

		// get the title:
		String title = driver.getTitle();
		System.out.println("page title is: " + title);

		// validation point/checkpoint/act vs exp result
		if (title.equals("Google")) {
			System.out.println("correct title");
		} else {
			System.out.println("incorrect title");
		}

		System.out.println(driver.getCurrentUrl());

		System.out.println(driver.getPageSource().contains("Copyright The Closure Library"));

	}

}
