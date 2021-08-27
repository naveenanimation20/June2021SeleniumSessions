package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableTraverse {

	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		//table[@id="customers"]/tbody/tr[2]/td[1]
		//table[@id="customers"]/tbody/tr[3]/td[1]
		//table[@id="customers"]/tbody/tr[4]/td[1]
		//table[@id="customers"]/tbody/tr[5]/td[1]
		//table[@id="customers"]/tbody/tr[6]/td[1]
		//table[@id="customers"]/tbody/tr[7]/td[1]
		
		String before_xpath = "//table[@id=\"customers\"]/tbody/tr[";
		String after_xpath = "]/td[1]";
		
		int rowCount = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")).size();
		
		for(int i=2; i<=rowCount; i++) {
			String compXpath = before_xpath+i+after_xpath;
			//System.out.println(compXpath);
			String compVal = driver.findElement(By.xpath(compXpath)).getText();
			System.out.println(compVal);
		}
		
		//table[@id="customers"]/tbody/tr[2]/td[2]
		//table[@id="customers"]/tbody/tr[3]/td[2]
		//table[@id="customers"]/tbody/tr[7]/td[2]

		
		
	}

}
