package com.gui.pages;

import org.openqa.selenium.By;

import com.utilities.WebDriverHelper;

public class ProductsPage {

	/****************************************************************************
	*  >>	Variables
	*****************************************************************************/
	WebDriverHelper driver;
	private static String itemPrice;
	
	/****************************************************************************
	*  >>	Constructor
	*****************************************************************************/
	public ProductsPage (WebDriverHelper  driver)
	{
		this.driver =driver;
	}
	
	/****************************************************************************
	*  >>	Locators
	*****************************************************************************/
	private static By selectProduct(int index)
	{
		return By.xpath("(//*[@class='productCard__container'])["+ index +"]");
	}
	
	private static By ProductPrice(int index)
	{
		return By.xpath("(//*[@class='productPrices__specialPrice'])["+ index +"] //span");
	}
	
	private static By ProductUrl(int index)
	{
		return By.xpath("(//*[@class='productCard__container'])["+ index +"] //a");
	}
	
	/****************************************************************************
	*  >>	Keywords
	*****************************************************************************/
	public String getProductPrice() {
		
		return itemPrice ;
	}
	
	public ProductDetailsPage selectItem(int productIndex) {
		driver.hover(By.id("HEADER_MAIN_LOGO"));
		itemPrice = driver.getElementText(ProductPrice(productIndex));
		driver.hoverAndClick(selectProduct(productIndex));

		return new ProductDetailsPage(driver);
	}
	
	
}
