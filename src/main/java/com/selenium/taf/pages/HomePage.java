package com.selenium.taf.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver webDriver) {
		super(webDriver);
		jsExec = (JavascriptExecutor)webDriver;
		action = new Actions(webDriver);
	}
    
	public void openRegistrationPage() {
	  clickButton(registerLink);
	}
	
	public void openLoginPage() {
		clickButton(loginLink);
	}
	
	public void openContactLinkPage() {
		scrollToBottom();
		clickButton(contactLink);
	}
	
	public void changeCurrency() {
		dropDownSelectByVisibileText(currencyDropDownList, "Euro");
	}
	
	public void selectNotebooksMenu() {
		action
		      .moveToElement(computerMenu)
		      .moveToElement(notebooksMenu)
		      .click()
		      .build()
		      .perform();
	}
	
	public void selectCartMenu() {
		clickButton(cartMenu);
	}
	
	public void openWishListLink() {
		clickButton(wishListLink);
	}
	
	@FindBy(linkText="Register")	
	private WebElement registerLink;	
	
	@FindBy(linkText="Log in")
	private WebElement loginLink;
	
	@FindBy(xpath="//a[@href='/contactus']")
	private WebElement contactLink;
	
	@FindBy(id="customerCurrency")
	private WebElement currencyDropDownList;
	
	@FindBy(linkText="Computers")
	private WebElement computerMenu;
	
	@FindBy(linkText="Notebooks")
	private WebElement notebooksMenu;	
	
	@FindBy(css="span.wishlist-label")
	private WebElement wishListLink;
	
	@FindBy(css="a.ico-cart")
	private WebElement cartMenu;
	
	
}
