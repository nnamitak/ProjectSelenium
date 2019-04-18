package com.spacenownew.tests;


import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.spacenownew.pages.SpaceNowMasterPage;
import org.testng.annotations.Test;

public class SpaceNowTests extends BaseTest {

	@Test
	public void SpaceNowLogin() throws InterruptedException, IOException {

		SpaceNowMasterPage initialPage= new SpaceNowMasterPage(driver);

		// Step 1: Navigate to the following URL: https://www.spacenow.com/
		initialPage.navigateToSpaceNow();

/*		//Step 2: Click LOGIN
		initialPage.clickLoginBtn();

		//Step 3: Click Login with Google Account
		initialPage.clickGoogleBtn();	
		driver.navigate().back();

		//Step 4: Click Login with FaceBook Account
		initialPage.clickFaceBookBtn();	
		driver.navigate().back();

	*/	//Step 5: Click LOGIN and Enter Email and Password to Login 
		initialPage.clickLoginBtn();
		initialPage.userNameDetails();

	}

}