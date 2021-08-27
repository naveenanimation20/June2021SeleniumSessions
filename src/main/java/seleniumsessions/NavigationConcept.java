package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationConcept {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.google.com");
		
		driver.navigate().to("http://www.amazon.com");
		
		//driver.get("http://www.amazon.com");
		
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
	}

}
