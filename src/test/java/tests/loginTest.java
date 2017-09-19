package tests;

import org.openqa.selenium.WebDriver;

import Browser.BrowserFactory;

public class loginTest {

	public static void main(String[] args) {
		WebDriver driver = null;

		driver =  BrowserFactory.getBrowser("Chrome");
		driver.get("http://www.bbc.co.uk");

	}

}
