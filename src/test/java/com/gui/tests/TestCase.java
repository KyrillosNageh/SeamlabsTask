package com.gui.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gui.pages.HomePage;
import com.gui.pages.ProductsPage;
import com.utilities.BrowserConfiguration;
import com.utilities.WebDriverHelper;

public class TestCase {

	 private WebDriver driver;
	 private WebDriverHelper waitHelper;

	    @BeforeTest
	    public void setUp() throws Exception {
	        // Configure the browser using BrowserConfiguration class
	        driver = BrowserConfiguration.configureBrowser();
	        waitHelper = new WebDriverHelper(driver);
	    }

	    @AfterTest
	    public void tearDown() {
	        // Close the browser after the test
	        driver.quit();
	    }

	    @Test
	    public void testExample() throws Exception {
	    	
	    	new HomePage(waitHelper)
	    	.selectMenuItemsDropDown("Furniture")
	    	.selectSubMenuItemsDropDown("Outdoors")
	    	.clickOnSubMenuItemsDropDown("Outdoors")
	    	.selectItem(2)
	    	.addItemToCart()
	    	.verifyAlertMessage("This item is added to cart")
	    	.ClickOnCheckOut()
	    	.assertTotoalprice(new ProductsPage(waitHelper).getProductPrice());
	    	
	    	
//	    	By searchBoxLocator = By.name("q");
//	    	Thread.sleep(10000);
//	    	waitHelper.sendKeysWhenReady(searchBoxLocator, "Shaft_Engine");
////	    	waitHelper.sendKeysWhenReady(searchBoxLocator, "Shaft_Engine");
//	    	Thread.sleep(10000);

	        // Navigate to the example page
//	        driver.navigate().to("https://www.google.com.eg/");

//	        // Verify that the page title contains "Example Domain"
//	        String pageTitle = driver.getTitle();
//	        assertTrue(pageTitle.contains("Example Domain"));
//
//	        // Verify that the page heading contains "Example Domain"
//	        String pageHeading = driver.findElement(By.tagName("h1")).getText();
//	        assertTrue(pageHeading.contains("Example Domain"));
	    }
	}
