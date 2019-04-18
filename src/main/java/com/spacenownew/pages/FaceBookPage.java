package com.spacenownew.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FaceBookPage extends BasePage{
	
	public FaceBookPage(WebDriver driver) {
		super(driver);
	}
	
	public void faceBookDetails(){
		waitForLoad(driver);
		
		//Asserting the screen
		String actualTitle = driver.getTitle();
		String expectedTitle = "Log in to Facebook | Facebook";
		Assert.assertEquals(actualTitle, expectedTitle);
		waitForLoad(driver);
		
	}

}