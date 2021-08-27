package seleniumsessions;

import org.openqa.selenium.WebDriver;

public class AmazonTest {

	public static void main(String[] args) {

		BrowserUtil br = new BrowserUtil();
		
		WebDriver driver = br.launchBrowser("chrome");
		
		br.launchUrl("http://www.amazon.com");
		
		String title = br.getPageTitle();
		System.out.println("page title : " + title);
		if(title.contains("Amazon")) {
			System.out.println("title is correct");
		}
		else {
			System.out.println("title is incorrect");
		}
				
		String url = br.getPageUrl();
		System.out.println(url);

		br.closeBrowser();
		
		
	}

}
