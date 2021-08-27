package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementRefException {

	public static void main(String[] args) {

		
		//stale --> not fresh
		//click, refresh, navigating to another page
		//back and forward
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		
		List<WebElement> list = driver.findElements(By.xpath("(//ul[@class='footer-nav'])[1]//a"));
		
		for(int i=0; i<list.size(); i++) {
			list.get(i).click();
			list = driver.findElements(By.xpath("(//ul[@class='footer-nav'])[1]//a"));
		}
		
		
		
	}

}
