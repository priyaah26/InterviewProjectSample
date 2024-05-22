package org.interview.testcases;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.interview.testbase.BaseClass;
import org.interviewproject.pageobject.LoginPage;
import org.interviewproject.pageobject.SearchProductPage;
import org.testng.annotations.Test;

public class SearchProductPageTest extends BaseClass {
	
	LoginPage signInPageObj;
	
	SearchProductPage SearchProductPageObj;
	
	@Test 
	public void searchProduct() throws InterruptedException {
		signInPageObj = new LoginPage(driver);
		signInPageObj.signinPageNavigation();
		signInPageObj.username("7010697346");
		signInPageObj.continueButton();
		signInPageObj.password("Naini@2018");
		signInPageObj.signinButton();
		
		SearchProductPageObj = new SearchProductPage(driver);
		SearchProductPageObj.searchProductbox("iphone");
		SearchProductPageObj.submitBtn();
		SearchProductPageObj.clickOnProduct();
		
		Set<String> windowIDs=driver.getWindowHandles();
		List <String> windowidsList = new ArrayList(windowIDs); 
		
		String parentWindowID = windowidsList.get(0);
		String childWindowID = windowidsList.get(1);
		
		driver.switchTo().window(parentWindowID);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String productName = SearchProductPageObj.getProductName();
		System.out.println("Name of the product: " + productName);
		String price = SearchProductPageObj.getProductPrice();
		System.out.println("Price of the product: " + price);
	}
	
	
	
	

}
