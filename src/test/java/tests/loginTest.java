package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import Browser.BrowserFactory;
import PageObjects.Gurru_Home;

public class loginTest {
	WebDriver driver;
	Gurru_Home gurru_Home = new Gurru_Home(driver);

	@BeforeTest
	public void setUp(){
		driver =  BrowserFactory.getBrowser("Chrome");
		driver.get("http://www.demo.guru99.com/V4/");
	}

	@Test
	public void loginToGurruBank(){
		gurru_Home.verifyGurru99BankHomePage("Gurru99 Bank Home Page");
		gurru_Home.setUserNameAndPassword("mngr97845", "buqusus");
	}
}
