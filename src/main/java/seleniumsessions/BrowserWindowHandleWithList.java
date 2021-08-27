package seleniumsessions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandleWithList {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");// parent window

		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
		// child window -- twitter page

		Set<String> handles = driver.getWindowHandles();

		List<String> handlesList = new ArrayList<String>(handles);

		String parentWindowID = handlesList.get(0);
		String childWidnowID = handlesList.get(1);

		driver.switchTo().window(childWidnowID);
		System.out.println("child window url : " + driver.getCurrentUrl());

		driver.close();// close the child window

		driver.switchTo().window(parentWindowID);
		System.out.println("parent window url : " + driver.getCurrentUrl());

	}

}
