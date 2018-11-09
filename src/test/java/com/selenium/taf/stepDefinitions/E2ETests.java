package com.selenium.taf.stepDefinitions;

import org.junit.Assert;

import com.selenium.taf.pages.CheckOutPage;
import com.selenium.taf.pages.HomePage;
import com.selenium.taf.pages.OrderDetailsPage;
import com.selenium.taf.pages.ProductDetailsPage;
import com.selenium.taf.pages.SearchPage;
import com.selenium.taf.pages.ShoppingCartPage;
import com.selenium.taf.tests.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class E2ETests extends TestBase{

	@Given("^User is on Home page$")
	public void user_is_on_Home_page() throws Throwable {
	  Assert.assertTrue(webDriver.getCurrentUrl().contains("https://demo.nopcommerce.com/"));
	}

	@When("^He search for \"([^\"]*)\"$")
	public void he_search_for(String ProductName) throws Throwable {
		productName = ProductName;
		productDetailsPage = new ProductDetailsPage(webDriver);
		searchPage = new SearchPage(webDriver);
		searchPage.SearchProductUsingAutoSuggest("MacB");
		Assert.assertEquals(productDetailsPage.getTextBreadcrumb(), productName); 
	}

	@When("^Choose to buy two items$")
	public void choose_to_buy_two_items() throws Throwable {
		productDetailsPage.addProductToCart();
		homePage = new HomePage(webDriver);
		
		homePage.selectCartMenu();
		
		shoppingCartPage = new ShoppingCartPage(webDriver);
		Assert.assertTrue(shoppingCartPage.cartListContainsProduct(productName));
	}

	@When("^Moves to checkout cart and enter personal details on checkout page and place the order$")
	public void moves_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_the_order() throws Throwable {
		checkOutPage = new CheckOutPage(webDriver);
		
		shoppingCartPage.openCheckOutPage();
	    checkOutPage.checkOutAsGuset();
		checkOutPage.registredUserCheckOutProduct(firstName,lastName,email,country, city, addressTxt, codePostal, phoneNumber);
		
		Assert.assertTrue(checkOutPage.getTextProductName().contains(productName));
		
		checkOutPage.confirmOrder();
	    Thread.sleep(2000);
		Assert.assertTrue(checkOutPage.getTextSuccessMessageLabel()
				          .contains("Your order has been successfully processed!"));   
	}

	@Then("^He can view the order and download the novice$")
	public void he_can_view_the_order_and_download_the_novice() throws Throwable {
		orderDetailsPage = new OrderDetailsPage(webDriver);
		checkOutPage.viewOrderDetails();
		
		Assert.assertTrue(webDriver.getCurrentUrl().contains("orderdetails"));
		
		orderDetailsPage.downloadPDFInvoice();
		orderDetailsPage.printOrderDetails();
	}

	
	private HomePage homePage;
	private ProductDetailsPage productDetailsPage;
	private SearchPage searchPage;
	private ShoppingCartPage shoppingCartPage;
	private CheckOutPage checkOutPage;
	private String country = "Tunisia";
	private String city = "City ElNour Essaida";
	private String addressTxt = "15 rue liberte Manouba";
	private String codePostal = "1001578";
	private String phoneNumber = "10109124";
	private String lastName = "aouini";
	private String firstName = "Ahmed";
	private String email = "nidh111245780@gmail.com";
	private OrderDetailsPage orderDetailsPage;
	private String productName;
}
