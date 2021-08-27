package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickMenuHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		//right click -- context menu click
		WebElement rightClickEle = driver.findElement(By.xpath("//span[text()='right click me']"));

		Actions act = new Actions(driver);
		
		act.contextClick(rightClickEle).perform();
		
		List<WebElement> itemList = 
				driver.findElements(By.xpath("//li[contains(@class,'context-menu-item context-menu-icon')]/span"));
		
		System.out.println(itemList.size());
		
		for(WebElement e : itemList) {
			String text = e.getText();
			System.out.println(text);
				if(text.equals("Copy")) {
					e.click();
					break;
				}
			
		}
	}
	
	//create a util function -- assignment

}
