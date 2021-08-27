package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This utility is having different methods for differnt browser actions
 * @author naveenautomationlabs
 *
 */
public class BrowserUtil {

	public WebDriver driver;

	/**
	 * This method is used to initialize the driver on the basis of given browser name
	 * @param browserName
	 * @return this returns WebDriver reference
	 */
	public WebDriver launchBrowser(String browserName) {

		if (browserName.equals("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			//System.setProperty("webdriver.gecko.driver", "/Users/naveenautomationlabs/Downloads/geckodriver");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("please pass the correct browser....");
		}

		return driver;
	}

	
	/**
	 * 
	 * @param url
	 */
	public void launchUrl(String url) {
		if (url == null) {
			return;
		}
		if (url.isEmpty()) {
			return;
		}
		driver.get(url);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public String getCurrentPageSource() {
		return driver.getPageSource();
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}

}
