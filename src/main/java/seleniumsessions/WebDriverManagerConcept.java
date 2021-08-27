package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerConcept {

	public static void main(String[] args) {

		//WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();

		WebDriver driver = new FirefoxDriver();

		driver.get("http://www.amazon.com");
		System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());

		driver.quit();

	}

}
