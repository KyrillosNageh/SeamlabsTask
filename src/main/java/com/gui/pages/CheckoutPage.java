package com.gui.pages;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import com.utilities.WebDriverHelper;

public class CheckoutPage {
	
	/****************************************************************************
	*  >>	Variables
	*****************************************************************************/
	WebDriverHelper driver;
	SoftAssert softAssert;
	
	/****************************************************************************
	*  >>	Constructor
	*****************************************************************************/
	public CheckoutPage (WebDriverHelper  driver)
	{
		this.driver =driver;
	}
	
	/****************************************************************************
	*  >>	Locators
	*****************************************************************************/
	private static By total_price()
	{
		return By.xpath("//*[@class='summary__total'] //b");
	}
	

	/****************************************************************************
	*  >>	Keywords
	*****************************************************************************/
	public CheckoutPage assertTotoalprice(String expected) {
		String actualTotalPrice = driver.getElementText(total_price());
		
		softAssert = new SoftAssert();
		softAssert.assertTrue(actualTotalPrice.contains(expected),
				"Sucess message appeared successfully");
		
		return this;
	}

}
