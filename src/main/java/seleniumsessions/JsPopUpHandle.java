package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JsPopUpHandle {

	public static void main(String[] args) {

		//js - alert -- alert() method - JS pop up
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.name("proceed")).click();
		
		Alert alert = driver.switchTo().alert();
		
		String text = alert.getText();
		System.out.println(text);
		
		alert.accept(); //accept the alert
		
		//alert.dismiss();//dismiss the alert
		
		//alert.sendKeys("testing");
		
		driver.switchTo().defaultContent();
	}

}
