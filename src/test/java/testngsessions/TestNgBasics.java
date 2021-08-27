package testngsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgBasics {

	// Pre conditions --@Before
	// Test Case --> Test Steps + Assertion (Act vs Exp) -- @Test
	// Post Steps -- @After

	/*
	 * BS -- DBConnection BT -- create user BC -- launchBrowser
	 * 
	 * BM -- login addToCartPageTest AM -- logout
	 * 
	 * BM -- login homePageTest AM -- logout
	 * 
	 * BM -- login paymentPageTest AM -- logout
	 * 
	 * AC -- close browser AT -- delete user AS -- disconnectDB
	 */

	@BeforeSuite
	public void DBConnection() {
		System.out.println("BS -- DBConnection");
	}

	@BeforeTest
	public void createUser() {
		System.out.println("BT -- create user");
	}

	@BeforeClass
	public void launchBrowser() {
		System.out.println("BC -- launchBrowser");
	}

	@BeforeMethod
	public void login() {
		System.out.println("BM -- login");
	}

	@Test
	public void homePageTest() {
		System.out.println("homePageTest");
	}

	@Test
	public void addToCartPageTest() {
		System.out.println("addToCartPageTest");
	}

	@Test
	public void paymentPageTest() {
		System.out.println("paymentPageTest");
	}

	@AfterMethod
	public void logout() {
		System.out.println("AM -- logout");
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("AC -- close browser");
	}

	@AfterTest
	public void deleteUser() {
		System.out.println("AT -- delete user");
	}

	@AfterSuite
	public void disconnectDB() {
		System.out.println("AS -- disconnectDB");
	}

}
