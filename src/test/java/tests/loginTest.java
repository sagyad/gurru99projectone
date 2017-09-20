package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import Browser.BrowserFactory;
import PageObjects.Gurru_Home;

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
		gurru_Home.verifyGurru99BankHomePage("Gurru99 Bank Home Page");
		gurru_Home.setUserNameAndPassword("mngr97845", "buqusus");
	}
	
	@Test (enabled=false)
	public void ingore(){
		
	}
}
