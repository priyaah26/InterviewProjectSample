package org.interviewproject.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProductPage extends BasePage {

	public SearchProductPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id = 'twotabsearchtextbox']")
	WebElement searchBox;

	@FindBy(xpath = "//input[@id = 'nav-search-submit-button']")
	WebElement goBtn;

	@FindBy(xpath = "//span[text()='Apple iPhone 15 (128 GB) - Black']")
	WebElement product;
	
	@FindBy(xpath = "//span[text()='Apple iPhone 15 (128 GB) - Black']")
	WebElement productName;
	
	@FindBy(xpath = "//span[text()='71,290'][1]")
	WebElement productPrice;

	public void searchProductbox(String productName) {
		searchBox.sendKeys(productName);
	}

	public void submitBtn() {
		goBtn.click();
	}

	public void clickOnProduct() {
		product.click();
	}
	
	public String getProductName() {
		String nameOfTheProduct = productName.getText();
		return nameOfTheProduct;

	}
	public String getProductPrice() {
		String priceOfTheProduct = productPrice.getText();
		return priceOfTheProduct;
		
	}

}
