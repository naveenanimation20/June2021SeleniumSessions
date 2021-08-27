package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthPopUpHandle {

	public static void main(String[] args) {
		
		//auth pop up ---not a JS alert
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		String username = "admin";
		String password = "admin";
		
		driver.get("https://"+username + ":"+password + "@"+"the-internet.herokuapp.com/basic_auth");
				
		//CDP - selenium 4
		//cypress uses CDP
		
	}

}
