package seleniumsessions;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverCombination {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");

//		ChromeDriver driver = new ChromeDriver();
//		
//		
		RemoteWebDriver driver = null;
		driver.get("http://www.google.com");
		String browser = "chrome";

		// cross browser testing:
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/naveenautomationlabs/Downloads/geckodriver");
			driver = new FirefoxDriver();
		} else if (browser.equals("safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("please pass the correct browser....");
		}
		
		//top casting: searchContext > CD
		//SearchContext dr = new ChromeDriver();
		
		//top casting: Webdriver > RWD
		//WebDriver d = new RemoteWebDriver(remoteAddress, capabilities)
		
		
		
	}

}
