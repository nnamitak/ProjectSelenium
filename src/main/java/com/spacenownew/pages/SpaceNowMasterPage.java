package com.spacenownew.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.spacenownew.pages.BasePage;

public class SpaceNowMasterPage extends BasePage{

	private String  url = "https://www.spacenow.com";
	GooglePage gPage = new GooglePage(driver);
	FaceBookPage fbPage = new FaceBookPage(driver);

	By loginbtn = By.xpath("//div[@class='location navbar-collapse collapse']/div/ul/li[4]/a/span");
	By googlebth = By.xpath("//div[@class='_2Lgor loginModal modal-dialog']/div/div[2]/div/div/div[2]/div/div/div");
	By facebookbth = By.xpath("//div[@class='_2Lgor loginModal modal-dialog']/div/div[2]/div/div/div[2]/div/div[2]");
	By loginButton = By.xpath("//html/body/div[2]/div/div[2]/div/div/div[2]/div/div/div[2]/form/div[3]/div[2]/button");

	@FindBy(name="email")
	private WebElement userEmail;

	@FindBy(name="password")
	private WebElement userPass;


	//private String excelPath;

	//Initialization of web-elements
	public SpaceNowMasterPage(WebDriver driver) {
		super(driver);
	}

	//Utilization of web-elements
	public void navigateToSpaceNow()
	{
		navigateToPage(url);		
		Reporter.log("https://www.spacenow.com/",true);
	}

	//Clock on Login 
	public void clickLoginBtn(){
		Reporter.log("Entering clickLoginBtn ... ",true);
		waitForLoad(driver);
		find(loginbtn).click();
		waitForLoad(driver);

		//Asserting the screen
		String actualTitle = driver.getTitle();
		String expectedTitle = "Spacenow";
		Assert.assertEquals(actualTitle, expectedTitle);			
	}

	public void clickGoogleBtn() {
		Reporter.log("Entering  clickGoogleBtn .... ",true);
		waitForLoad(driver);
		find(googlebth).click();
		waitForLoad(driver);
		gPage.googleDetails();

	}

	public void clickFaceBookBtn() {
		Reporter.log("Entering  clickFaceBookBtn .... ",true);
		waitForLoad(driver);
		find(loginbtn).click();
		find(facebookbth).click();
		waitForLoad(driver);
		fbPage.faceBookDetails();
	}

	public void userNameDetails() throws IOException{
		waitForLoad(driver);  
		FileInputStream fis = new FileInputStream(new File("./data/SpaceNow.xlsx"));
		Reporter.log("File Opened .... ",true);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		Reporter.log("File Opened  1 .... ",true);
		XSSFSheet sheet = workbook.getSheetAt(0);

		String h1 = sheet.getRow(0).getCell(0).getStringCellValue();

		Reporter.log("File Opened 2.... ",true);

		String uName1 = sheet.getRow(1).getCell(0).getStringCellValue();
		String pass1 = sheet.getRow(1).getCell(1).getStringCellValue();
		Reporter.log("File Opened 3.... ",true);
		waitForLoad(driver);
		userEmail.sendKeys(uName1);

		waitForLoad(driver);
		userPass.sendKeys(pass1);

		waitForLoad(driver);
		find(loginButton).click();
		Reporter.log("Closing the browser.... ",true);
	}
}