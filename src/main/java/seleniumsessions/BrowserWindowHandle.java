package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandle {

	public static void main(String[] args) {

		//browser window pop up/new tab window/new browser window
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");//parent window

		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
		//child window -- twitter page
		
		Set<String> handles = driver.getWindowHandles();
		
		Iterator<String> it = handles.iterator();
		String parentWindowID = it.next();
		System.out.println("parent window id is : " + parentWindowID);
		
		String childWindowId = it.next();
		System.out.println("child window id is : " + childWindowId);
		
		//switching:
		driver.switchTo().window(childWindowId);
		System.out.println("child window url : " + driver.getCurrentUrl());
		
		driver.close();//close the child window
		
		driver.switchTo().window(parentWindowID);
		System.out.println("parent window url : " + driver.getCurrentUrl());

		
	}

}
