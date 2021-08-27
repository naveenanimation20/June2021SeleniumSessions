package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/india-tour-of-sri-lanka-2021-1262739/sri-lanka-vs-india-2nd-odi-1262756/full-scorecard");

		//a[text()='Avishka Fernando']//parent::td//following-sibling::td/span
		//a[text()='Avishka Fernando']//parent::td//following-sibling::td
		
		System.out.println(getWicketTakerName("Avishka Fernando"));
		System.out.println(getWicketTakerName("Bhanuka Rajapaksa"));

		System.out.println(getScoreList("Avishka Fernando"));
		System.out.println(getScoreList("Bhanuka Rajapaksa"));
		System.out.println(getScoreList("Charith Asalanka"));
	}
	
	public static List<String> getScoreList(String playerName) {
		String scoreXapth = "//a[text()='"+playerName+"']//parent::td//following-sibling::td";
		List<WebElement> scoreList = driver.findElements(By.xpath(scoreXapth));
		
		List<String> scoreValList = new ArrayList<String>();
		for(int i=1; i<scoreList.size(); i++) {
			String text = scoreList.get(i).getText();
			scoreValList.add(text);
		}
		return scoreValList;
	}
	
	public static String getWicketTakerName(String playerName) {
		String wicketTaker = "//a[text()='"+playerName+"']//parent::td//following-sibling::td/span";
		return driver.findElement(By.xpath(wicketTaker)).getText();
	}
	
	
	
	
	

}
