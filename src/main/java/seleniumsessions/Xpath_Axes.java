package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpath_Axes {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/");
		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.linkText("CONTACTS")).click();
		
		List<WebElement> ls = 
				driver.findElements(By.xpath("//a[text()='Aliss Jeyhun']/parent::td/following-sibling::td"));
		int count=0;
		for(WebElement e : ls) {
			if(count==5) {
				break;
			}
			System.out.println(e.getText());
			count++;
		}

		//parent to child:
		
		//direct child: / --> 8
		//indirect + direct child: // -- 20
		//div[@class='private-form__input-wrapper']//child::input[@id='username']
		//select[@id='Form_submitForm_Industry']//option
		
		//child to parent: backward traversing
		//input[@id='username']/../../../../../../../../../..
		//input[@id='username']//parent::div
		//input[@id='input-email']//parent::div --> immediate parent -- 1
		//input[@id='input-email']//ancestor::div -- all parents --> 20
		
		//sibling traversing:
		//preceding-sibling
		//following-sibling
		
		//a[text()='Aastha Grover']//parent::td//preceding-sibling::td/input[@type='checkbox']
		//a[text()='AB Devilliers']//parent::td//preceding-sibling::td/input[@type='checkbox']
		//a[text()='Akshay patil']//parent::td//preceding-sibling::td/input[@type='checkbox']
//		selectContact("Aastha Grover");
//		selectContact("Akshay patil");
//		
//		//a[text()='Aastha Grover']//parent::td//following-sibling::td/a[@context='company']
//		System.out.println(getCompName("Aastha Grover"));
	}
	
	public static void selectContact(String name) {
		String checkBox = "//a[text()='"+name+"']//parent::td//preceding-sibling::td/input[@type='checkbox']";
		driver.findElement(By.xpath(checkBox)).click();
	}
	
	public static String getCompName(String name) {
		String compName = "//a[text()='"+name+"']//parent::td//following-sibling::td/a[@context='company']";
		return driver.findElement(By.xpath(compName)).getText();
	}

}
