package seleniumsessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitlyWaitConcept {

	public static void main(String[] args) {
		
		//wait in selenium : Synchorization
		//can be applied for webelements and non webelemements (url, title, alert, pop up)
		//two types:
		//1. static wait --> Thread.sleep(10000) -- will pause the script for the 10 secs
		//2. dynmaic wait --> 10 secs --> if ele is found within 4 secs (rest of the 6 secs will be ignored)
			//a. implicityly wait
			//b. explict wait --> WebDriverWait (c) --> FluentWait (c) --> Wait (I)

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//implicityly wait: dynamic wait
		//its only applicable for web elements
		//its a global wait --> applied with driver -- will be applicable for all the upcoming webelements
		
		//e1 --> 5 secs to visible on the page 
		//imp wait -- driver --> time out = 10 secs
		//e1 -- 5 secs--> rest of the 5 secs will be ignored
		//if after 10 secs alsom, e1 is not visible --> then selenium will throw the nosuchelementexception
		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		//login page: 10 secs
		
		WebElement emailId = driver.findElement(By.id("input-email11"));//10 - 3 secs --> 7 secs
		WebElement password = driver.findElement(By.id("input-password"));//10 -- 0 sec
		WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));//10

		emailId.sendKeys("naveenanimation20@gmail.com");
		password.sendKeys("naveenanimation20@gmail.com");
		loginBtn.click();
		
		//home page: 5 secs
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//e4
		//e5
		//e6
		
		//logout:
		//login page: 10 secs
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//register page: 15 secs
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		//forgot pwd page: 0 secs --nullify of imp wait
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		//e7 -- 0 sec
		//e8 -- 0 sec
		
		
		//js confirmation pop up (alert)-- 5 secs
		
		
		
		
		
		
		
	}

}
