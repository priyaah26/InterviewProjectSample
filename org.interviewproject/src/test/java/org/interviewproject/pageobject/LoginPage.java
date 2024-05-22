package org.interviewproject.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[@id = 'nav-link-accountList-nav-line-1']")
	WebElement signinTab;
	
	@FindBy(xpath = "//input[@id='ap_email']")
	WebElement userMobileNum;

	@FindBy(xpath = "//input[@id='continue']")
	WebElement continueBtn;

	@FindBy(xpath = "//input[@id='ap_password']")
	WebElement userpassword;

	@FindBy(xpath = "//input[@id='signInSubmit']")
	WebElement signinBtn;
	
	public void signinPageNavigation() {
		signinTab.click();
	}

	public void username(String userId) {
		userMobileNum.sendKeys(userId);
	}

	public void continueButton() {
		continueBtn.click();
	}

	public void password(String userPassword) {
		userpassword.sendKeys(userPassword);
	}

	public void signinButton() {
		signinBtn.click();
	}


}
