package org.interview.testcases;

import org.interview.testbase.BaseClass;
import org.interviewproject.pageobject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass{
	
	LoginPage loginPageObj;
	
	@Test (priority = 1)
	public void validLogin() throws InterruptedException {
		
		loginPageObj = new LoginPage(driver);
		loginPageObj.signinPageNavigation();
		loginPageObj.username("7010697346");
		loginPageObj.continueButton();
		loginPageObj.password("Naini@2018");
		loginPageObj.signinButton();
		
		Thread.sleep(5000);
		String actualTitle = driver.getTitle();
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	
	
	@Test (priority = 2)
	public void invalidPasswordWrong() {
		
		loginPageObj = new LoginPage(driver);
		loginPageObj.signinPageNavigation();
		loginPageObj.username("7010697346");
		loginPageObj.continueButton();
		loginPageObj.password("Naini@20");
		loginPageObj.signinButton();
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Amazon Sign In";
		Assert.assertEquals(actualTitle, expectedTitle, "UnsuccessfulLogin");
		
		
	}
	
	@Test (priority = 3)
	public void invalidUsernameWrong() {
		
		loginPageObj = new LoginPage(driver);
		loginPageObj.signinPageNavigation();
		loginPageObj.username("70106973");
		loginPageObj.continueButton();
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Amazon Sign In";
		Assert.assertEquals(actualTitle, expectedTitle, "UnsuccessfulLogin");
		
		
	} 

}
