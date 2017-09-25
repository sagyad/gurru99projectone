package pageObjects;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utility.Constant;

/**
 * Declare some common parameters for scripts
 * You can change them to adapt your environment
 *  21/09/2017 - added Constant class with all constant variables declared.
 *  22-09-2017 - added all Excel variables
 */
public class Gurru_Home {
	
	private static XSSFWorkbook excelWorkBook;
	private static XSSFSheet excelSheet;
	private static XSSFCell excelSheetCell;
	private static XSSFRow excelSheetRow;
	
	Constant con = new Constant();
	private static WebDriver driver;

	@FindBy(xpath = ".//input[@name='uid']")
	private WebElement userName;

	@FindBy(xpath = ".//input[@name='password']")
	private WebElement password;

	@FindBy(xpath = ".//input[@name='btnLogin']")
	private WebElement loginButton;

	public Gurru_Home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	
	//This method is to set the file path and to open excel file, pass excel path and sheetname as argument to this method
	public void setExcelFile(String path, String sheetName) throws Exception{
		try{
			//Open the excel file
			FileInputStream excelFile = new FileInputStream(path);
			
			//Access the required test data sheet
			excelWorkBook = new XSSFWorkbook(excelFile);
			excelSheet = excelWorkBook.getSheet(sheetName);
		}catch(Exception e){
			throw(e);
		}
	}
	
	
	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
	
	public String getCellData(int rowNum, int colNum){
		
		try{		
			excelSheetCell = excelSheet.getRow(rowNum).getCell(colNum);
			String cellData = excelSheetCell.getStringCellValue();
			return cellData;
			
			
		}catch(Exception e){
			return "";
		}
	}

	
	public void verifyGurru99BankHomePage() {
		driver.get(Constant.URL);
		System.out.println();
		String getTitle = driver.getTitle();
		if (getTitle.contains(Constant.HOME_PAGE_EXPECT_TITLE)) {
			System.out.println("Home page verified successfully. Login page dispalyed.");
		} else {
			// assertEquals(HOME_PAGE_EXPECT_TITLE, getTitle);
			System.out.println("We could not get page title, please check if your internet is on.");
		}

	}

	public void setUserNameAndPassword() throws Exception {
		setExcelFile(Constant.PATH_TESTDATA+Constant.FILE_TESTDATA, "UserData");
		String sUsername = getCellData(3, 2);
		String sPass = getCellData(1, 2);
		
		System.out.println("=========================");
		System.out.println(sUsername);
		System.out.println(sPass);
		
		userName.clear();
		userName.sendKeys(Constant.USERNAME);
		password.clear();
		password.sendKeys(Constant.PASSWORD);
		loginButton.click();

		String loginTitle = driver.getTitle();
		if (loginTitle.contains(Constant.AFTER_LOGIN_EXPECT_TITLE)) {
			System.out.println("User successfully logged in.");
		} else {
			System.out.println(
					"Cannot verify page title - " + driver.getTitle() + " - check your internet connect is working");
		}
	}

}
