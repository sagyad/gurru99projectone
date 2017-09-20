package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import Browser.BrowserFactory;
import PageObjects.Gurru_Home;

/**
 * @author = Sagar Yadav
 *          Test Script 02
 *          **************
 *          1) Go to http://www.demo.guru99.com/v4
 *          2) Enter valid username
 *          3) Enter valid password
 *          4) Click on Login
 *          5) Verify the Page Title after login
 */

public class loginTest {
	WebDriver driver;
	Gurru_Home gurru_Home;

	@BeforeTest
	public void setUp(){
		driver =  BrowserFactory.getBrowser("Firefox");
	}

	@Test
	public void loginToGurruBank(){
		gurru_Home = new Gurru_Home(driver);
		gurru_Home.verifyGurru99BankHomePage();
		gurru_Home.setUserNameAndPassword();
	}
	
	@Test (enabled=false)
	public void ingore(){
		
	}
}
