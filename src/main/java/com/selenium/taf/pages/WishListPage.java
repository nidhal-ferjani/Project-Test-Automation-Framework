package com.selenium.taf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase {

	public WishListPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	
	public void removeProductFromWishList() {
		clickButton(removeFromCartCkeckbox);
		clickButton(updateCartBtn);
	}
	
	public String getTextEmptyListLabel() {
		return emptyListLabel.getText();
	}
	
	public String getTextProductCellule() {
		
		return productCellule.getText();
	}
	
	public boolean isVisibleTitle() {
		return wishListTitle.isDisplayed();
	}

	@FindBy(name="removefromcart")
	private WebElement removeFromCartCkeckbox;
	
	@FindBy(name="updatecart")
	private WebElement updateCartBtn;
	
	@FindBy(css="td.product")
	private WebElement productCellule;
	
	@FindBy(tagName="h1")
	private WebElement wishListTitle;
	
	@FindBy(css="div.no-data")
	private WebElement emptyListLabel;
		
}
