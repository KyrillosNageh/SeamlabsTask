package steps;

import org.openqa.selenium.WebDriver;
import com.gui.pages.CheckoutPage;
import com.gui.pages.HomePage;
import com.gui.pages.ProductDetailsPage;
import com.gui.pages.ProductsPage;
import com.utilities.BrowserConfiguration;
import com.utilities.WebDriverHelper;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSteps {
	 private WebDriver driver;
	 private WebDriverHelper waitHelper;
	 @Before
    public void setUp() throws Exception {
	     driver = BrowserConfiguration.configureBrowser();
	     waitHelper = new WebDriverHelper(driver);
	    }

	  @After
	  public void tearDown() {
		  driver.quit();
	    }	 
	 
	@Given("The user in the home page")
	public void the_user_in_the_home_page() {

	}
	@When("I hover to Furniture Menu")
	public void i_hover_to_Furniture() {
		new HomePage(waitHelper)
		.selectMenuItemsDropDown("Furniture");
	}
	@When("I hover and clicks on Outdoors sub menu")
	public void i_hover_and_clicks_on_outdoors_sub_menu() {
		new HomePage(waitHelper)
		.selectSubMenuItemsDropDown("Outdoors")
		.clickOnSubMenuItemsDropDown("Outdoors");
	}
	@When("I adds the second item to my cart")
	public void i_adds_the_second_item_to_my_cart() {
		new ProductsPage(waitHelper)
		.selectItem(2)
		.addItemToCart()
		.verifyAlertMessage("This item is added to cart");
		
	}
	@When("I clicks on checkout")
	public void i_clicks_on_checkout() {
		new ProductDetailsPage(waitHelper)
		.ClickOnCheckOut();
	}
	@Then("validate the total price is equal to the item price")
	public void validate_the_total_price_is_equal_to_the_item_price() {
		new CheckoutPage(waitHelper)
		.assertTotoalprice(new ProductsPage(waitHelper).getProductPrice());
	}
}
