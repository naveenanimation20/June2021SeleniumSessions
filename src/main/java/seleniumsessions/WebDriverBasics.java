package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBasics {

	public static void main(String[] args) {

		//win;
		//System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");
		
		//mac:
		System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");
		//System.setProperty("webdriver.gecko.driver", "/Users/naveenautomationlabs/Downloads/geckodriver");

		//Automation Steps:
		//top casting: 
		WebDriver driver = new ChromeDriver();//launch browser
		
		//WebDriver driver = new FirefoxDriver();
		
		//enter the url:
		driver.get("https://www.google.com");
		
		//get the title:
		String title = driver.getTitle();
		System.out.println("page title is: " + title);
		
		//validation point/checkpoint/act vs exp result
		if(title.equals("Google")) {
			System.out.println("correct title");
		}
		else {
			System.out.println("incorrect title");
		}
		
		
		System.out.println(driver.getCurrentUrl());
		
		System.out.println(driver.getPageSource().contains("Copyright The Closure Library"));
		
		
		//automation steps + validation point--> automation testing
		
		//driver.quit();//close the browser
		
	}

}
