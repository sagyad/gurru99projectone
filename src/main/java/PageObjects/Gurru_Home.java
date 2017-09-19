package PageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Gurru_Home {
	
	private WebDriver driver;
	
	@FindBy(xpath=".//input[@name='uid']")
	private WebElement userName;
	
	@FindBy(xpath=".//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath=".//input[@name='btnLogin']")
	private WebElement loginButton;
	
	public Gurru_Home(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyGurru99BankHomePage(String title){
		String getTitle = driver.getTitle();
		assertEquals(title, getTitle);
		System.out.println("We have verified home page.");
	}
	
	public void setUserNameAndPassword(String uName, String pwd){
		userName.sendKeys(uName);
		password.sendKeys(pwd);
		loginButton.click();
		
		System.out.println("set username and pasword method");
	}

}
