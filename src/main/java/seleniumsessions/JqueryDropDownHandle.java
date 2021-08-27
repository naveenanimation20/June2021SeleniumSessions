package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownHandle {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

		driver.findElement(By.id("justAnInputBox")).click();
		Thread.sleep(2000);

		By choices = By.cssSelector(".comboTreeItemTitle");

		// TC_01: Single Selection:
		// selectChoice(choices, "choice 2");

		// TC_02: Multi Selection:
		// selectChoice(choices, "choice 1", "choice 2", "choice 4");

		// TC_03: All Selection
		selectChoice(choices, "select_all");
		selectChoice(choices, "select_all");//de-selction


	}

	/**
	 * 
	 * @param locator
	 * @param value
	 */
	public static void selectChoice(By locator, String... value) {
		List<WebElement> choiceList = driver.findElements(locator);// 45

		if (!value[0].equalsIgnoreCase("select_all")) {

			for (WebElement e : choiceList) {
				String text = e.getText();
				System.out.println(text);

				for (int j = 0; j < value.length; j++) {
					if (text.equals(value[j])) {
						e.click();
						break;
					}
				}

			}
		} else {
			// all selection logic:
			try {
				for (WebElement e : choiceList) {
					e.click();
				}
			} catch (Exception e) {

			}
		}

	}

}
