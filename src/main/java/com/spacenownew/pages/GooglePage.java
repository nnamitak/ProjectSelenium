package com.spacenownew.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GooglePage  extends BasePage{
	
	public GooglePage(WebDriver driver) {
		super(driver);
	}
	
	public void googleDetails(){
		waitForLoad(driver);
		
		//Asserting the screen
		String actualTitle = driver.getTitle();
		String expectedTitle = "Sign in – Google accounts";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
}