package seleniumsessions;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {
	static WebDriver driver;

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		//get the count of all links
		//print the text of each link (ignore the blank text)
		
		//links--> <a>
		
		By links = By.tagName("a");
		//List<WebElement> linksList = driver.findElements(By.tagName("a"));
		
		List<WebElement> linksList = getElements(links);
		
		System.out.println("total links: " + linksList.size());
		
//		for(int i=0; i<linksList.size(); i++) {
//			String text = linksList.get(i).getText();
//			
//				if(!text.isEmpty()) {
//					System.out.println(i+ ":="+ text);
//				}
//			
//		}
		
		//for each:
		int i = 1;
		for(WebElement e : linksList) {
			String text = e.getText();
			if(!text.isEmpty()) {
				System.out.println(i+":"+text);
			}
			i++;
		}
		

	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	
	
	

}
