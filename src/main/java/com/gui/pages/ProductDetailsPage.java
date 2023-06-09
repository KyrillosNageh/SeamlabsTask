package com.gui.pages;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import com.utilities.WebDriverHelper;

public class ProductDetailsPage {
	
	/****************************************************************************
	*  >>	Variables
	*****************************************************************************/
	WebDriverHelper driver;
	SoftAssert softAssert;
	
	/****************************************************************************
	*  >>	Constructor
	*****************************************************************************/
	public ProductDetailsPage (WebDriverHelper  driver)
	{
		this.driver =driver;
	}
	
	/****************************************************************************
	*  >>	Locators
	*****************************************************************************/
	private static By addToCart_btn()
	{
		return By.xpath("//*[@class='button-with-icon second-bg sm']");
	}
	
	private static By alertMsg_txt(String message)
	{
		return By.xpath("//*[@aria-live='polite' and text()='"+ message +"']");
	}
	
	private static By Cart_Btn()
	{				  
		return By.id("HEADER_CART_BRIEF_ICON");
	}
	
	private static By goToCart_Btn()
	{				  
		return By.id("HEADER_CART_BRIEF_GO_TO_CART_BUTTON");
	}
	
	private static By CartHeader_title()
	{
		return By.xpath("//*[@class='cart__headerTitle']");
	}
	
	/****************************************************************************
	*  >>	Keywords
	*****************************************************************************/
	public ProductDetailsPage addItemToCart() {
		driver.hoverAndClick(addToCart_btn());
		return this;
	}
	
	public ProductDetailsPage verifyAlertMessage(String message) {

		softAssert = new SoftAssert();
		softAssert.assertTrue(driver.isElementDisplayed(alertMsg_txt(message)),
				"Sucess message appeared successfully");
		
		return this;
	}
	
	public CheckoutPage ClickOnCheckOut() {
		driver.hoverAndClick(Cart_Btn());
		driver.hover(CartHeader_title());
		driver.hoverAndClick(goToCart_Btn());
		
		return new CheckoutPage(driver);
	}
	
}
