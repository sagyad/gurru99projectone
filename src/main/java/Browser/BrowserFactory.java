package Browser;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	private static WebDriver driver;
	
	public static WebDriver getBrowser(String browser){
		if(driver!=null)return driver;
		
		if(browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "src"+File.separator+"BrowserDriver"+File.separator+"chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("FireFox")){
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("InternetExplorer")){
			System.setProperty("webdriver.ie.driver", "src"+File.separator+"BrowserDriver"+File.separator+"MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}

}
