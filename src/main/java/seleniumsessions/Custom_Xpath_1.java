package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Custom_Xpath_1 {
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");

		//xpath - > address of the element in HTML DOM
		
		//1. absolute xpath: /html/body/div/div[3]/div[4]/ul/li[3]/a
		//2. relative xpath(custom): by using htmltag and attributes + functions + xpath axes
		
		//htmltag[@attr = 'value']
		//input[@id='input-email']
		//input[@name='email']
		
		//a --> FEs(xpath) -- total links
		
		//htmltag[@attr1 = 'value' and @attr2 = 'value']
		//input[@name='email' and @type='text']
		//input[@value='Login' and @type='submit']
		
		//index:
		// (//input[@class='form-control'])[1]
		// (//input[@class='form-control'])[position()=1]
		
		//or:
		//input[@type='text' or @type='email']
		
		//last():
		// (//input[@class='text'])[last()]
		// (//div[@class='navFooterVerticalRow navAccessibility']//a)[last()]
		// (//div[@class='navFooterVerticalRow navAccessibility']//a)[position()=last()]
		
		//xpath with text():
		//htmtag[text()='value']
		//a[text()='Login']
		//h2[text()='Refreshing business software that your teams will love']
		//h3[text()='Marketing Campaigns']
		//span[text()=' sign up']
		
		//contains():
		//htmltag[contains(@attr,'value')]
		//input[contains(@id,'email')]
		
		//dynamic elements with dynamic attributes
//		<input id = "firstname_123">
//		<input id = "firstname_234">
//		<input id = "firstname_456">

		//input[contains(@id,'firstname_')]
		
		//contains() with text():
		//htmltag[contains(text(),'value')]
		//a[contains(text(),'Order')]
		//h2[contains(text(),'business software')]
		
		//contains with one attr and second attrr without contains:
		//htmltag[contains(@attr1,'value') and @attr2='value']
		//input[contains(@id,'email') and @type='text']
		//input[contains(@id,'email') and @type='text' and contains(@name,'email')]
		
		//contains() with text() and attributes:
		//htmltag[contains(text(),'value') and @attr='value']
		//a[contains(text(),'Contact Sales') and @href='/contact-sales/']
		
		//contains() with text() and contains with attributes:
		//a[contains(text(),'Contact Sales') and contains(@class,'btn-orange')]
		
		//starts-with:
		//h2[starts-with(text(),'Refreshing')]
		//dynamic elements with dynamic attributes
//		<input id = "firstname_123">
//		<input id = "firstname_234">
//		<input id = "firstname_456">
		//input[starts-with(@id,'firstname_')]

		
		//*[@type='text'] -- 3
		//input[@type='text'] -- 3
		
		//with className method - can not use multiple classes together...
		By b1 = By.className("form-control private-form__control login-email"); //wrong
		
		By b2 = By.xpath("//input[@class='form-control private-form__control login-email']");//correct
		By b3 = By.cssSelector(".form-control.private-form__control.login-email");//correct
		By b4 = By.className("login-email"); //correct
		
		
		String xpath1 = "//input[@name=\"email\"]";
		String xpath2 = "//input[@name='email']";
		
		String loginLink = "Login";
		
		
		
		

		
//		By email = getBy("xpath", xpath1);
//		getElement(email).sendKeys("naveen");
		
		getElement("xpath", xpath1).sendKeys("naveen");
		getElement("linkText", loginLink).click();
		getElement("hi", "naveen").click();
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static WebElement getElement(String locatorType, String locatorValue) {
		return driver.findElement(getBy(locatorType, locatorValue));
	}
	
	
	public static By getBy(String locatorType, String locatorValue) {
		
		By locator = null;
		switch (locatorType) {
		case "id":
			locator = By.id(locatorValue);
			break;
		
		case "name":
			locator = By.name(locatorValue);
			break;
			
		case "className":
			locator = By.className(locatorValue);
			break;
			
		case "linkText":
			locator = By.linkText(locatorValue);
			break;
			
		case "partialLinkText":
			locator = By.partialLinkText(locatorValue);
			break;
			
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
			
		case "cssSelector":
			locator = By.cssSelector(locatorValue);
			break;
			
		case "tagName":
			locator = By.tagName(locatorValue);
			break;

		default:
			System.out.println("Please pass the correct locator " + locatorType);
			break;
		}
		
		return locator;
	}

}
