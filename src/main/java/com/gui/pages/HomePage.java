package com.gui.pages;

import org.openqa.selenium.By;

import com.utilities.WebDriverHelper;

public class HomePage {
	
	/****************************************************************************
	*  >>	Variables
	*****************************************************************************/
	WebDriverHelper driver;
	
	/****************************************************************************
	*  >>	Constructor
	*****************************************************************************/
	public HomePage (WebDriverHelper  driver)
	{
		this.driver =driver;
	}
	
	/****************************************************************************
	*  >>	Locators
	*****************************************************************************/
	private static By menuItems(String item)
	{
		return By.xpath("//*[@class='siteMenu__item' and text()='"+ item +"']");
	}
	
	private static By menuLinkHead(String item)
	{
		return By.xpath("//*[contains(@class,'siteMenu__menuLinkHead') and text()='"+ item +"']");
	}
	
	/****************************************************************************
	*  >>	Keywords
	*****************************************************************************/
	
	public HomePage selectMenuItemsDropDown(String item) {
		driver.hover(menuItems(item));
		return this;
	}
	
	public HomePage selectSubMenuItemsDropDown(String item) {
		driver.hover(menuLinkHead(item));
		return this;
	}
	
	public ProductsPage clickOnSubMenuItemsDropDown(String item) {
		String url =driver.getElementLinkUrl(menuLinkHead(item));
		driver.hoverAndClick(menuLinkHead(item));
		driver.waitUntilRedirectTo(url);

		return new ProductsPage(driver);
	}
	
	
	
	
	
}
