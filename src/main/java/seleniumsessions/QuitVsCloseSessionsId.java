package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsCloseSessionsId {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();// launch browser

		driver.get("https://www.google.com");

		String title = driver.getTitle();
		System.out.println("page title is: " + title);//Google

		System.out.println(driver.getCurrentUrl());

		driver.quit();
		//driver.close(); //close browser
		
		//reopen the browser:
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());

	}

}
