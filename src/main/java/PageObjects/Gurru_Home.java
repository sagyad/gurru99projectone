package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/*
 * Declare some common parameters for scripts
 * You can change them to adapt your enviroment
 */
public class Gurru_Home {
	
	private WebDriver driver ;
	public static final String BASE_URL = "http://www.demo.guru99.com/V4/";
	public static final String USER_NAME ="mngr97845";
	public static final String PASSWD ="buqusus";
	public static final String HOME_PAGE_EXPECT_TITLE ="Guru99 Bank Home Page";
	public static final String AFTER_LOGIN_EXPECT_TITLE ="Guru99 Bank Manager HomePage";

	
	@FindBy(xpath=".//input[@name='uid']")
	private WebElement userName;
	
	@FindBy(xpath=".//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath=".//input[@name='btnLogin']")
	private WebElement loginButton;
	
	public Gurru_Home(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void verifyGurru99BankHomePage(){
		driver.get(BASE_URL);
		String getTitle = driver.getTitle();
		if(getTitle.contains(HOME_PAGE_EXPECT_TITLE)){
			System.out.println("Home page verified successfully. Login page dispalyed.");
		}else {
//			assertEquals(HOME_PAGE_EXPECT_TITLE, getTitle);
			System.out.println("We could not get page title, please check if your internet is on.");
		}
		
	}
	
	public void setUserNameAndPassword(){
		userName.clear();
		userName.sendKeys(USER_NAME);
		password.clear();
		password.sendKeys(PASSWD);
		loginButton.click();
		
		String loginTitle = driver.getTitle();
		if(loginTitle.contains(AFTER_LOGIN_EXPECT_TITLE)){
			System.out.println("User successfully logged in.");
		}else{
			System.out.println("Cannot verify page title - "+driver.getTitle()+" - check your internet connect is working");
		}
		
		
	}

}
