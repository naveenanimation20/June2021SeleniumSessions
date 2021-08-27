package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		
		String title = jsUtil.getTitleByJS();
		System.out.println(title);
		
		//jsUtil.refreshBrowserByJS();
		
//		String text = jsUtil.getPageInnerText();
//		System.out.println(text);
//		
//		if(text.contains("Contact Management")) {
//			System.out.println("PASS");
//		}
		
//		jsUtil.generateAlert("hi this is my alert");
//		driver.switchTo().alert().dismiss();
		
		//WebElement ele = driver.findElement(By.xpath("//input[@value='Login']"));
		
//		WebElement emaiid = driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
//		WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
		
//		jsUtil.flash(emaiid);
//		emaiid.sendKeys("naveen");
//		jsUtil.flash(password);
//		password.sendKeys("test123");
//		jsUtil.flash(loginBtn);
//		loginBtn.click();
		
		//jsUtil.clickElementByJS(loginBtn);
		
//		jsUtil.scrollPageDown();
//		jsUtil.scrollPageUp();
//		jsUtil.scrollPageDown("200");
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
//		WebElement ele = driver.findElement(By.xpath("//h2[text()='Top deals with exchange offers']"));
//		jsUtil.scrollIntoView(ele);
//		jsUtil.drawBorder(ele);
		jsUtil.drawBorder(search);

	}

}
