package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BackAndForwardSimulation {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		driver.navigate().to("https://www.amazon.in/");
		
		System.out.println(driver.getTitle());

		driver.navigate().back();
		System.out.println(driver.getTitle());

		driver.navigate().forward();
		System.out.println(driver.getTitle());

		driver.navigate().back();
		System.out.println(driver.getTitle());

		
		
		
		
		
	}

}
