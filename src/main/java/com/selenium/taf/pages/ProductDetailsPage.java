package com.selenium.taf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public String getTextBreadcrumb() {
		return breadcrumb.getText();
	}
	
	public void sendEmailFriendLink() {
		clickButton(emailFriendLink);
	}
	
	public String getTextProductPriceLabel() {
		return productPriceLabel.getText();
	}
	
	public void openAddReviewPage() {
		clickButton(addReviewLink);
	}
	
	public void addProductToWishList() {
		clickButton(addWishListBtn);
	}
	
	public void addToCompareList() {
		clickButton(addToCompareBtn);
		WebDriverWait wait = new WebDriverWait(webDriver, 2);
		wait.until(ExpectedConditions.visibilityOf(barNotificationSuccess));
		
	}
	
	public void addProductToCart() {
		clickButton(addToCartBtn);
		WebDriverWait wait = new WebDriverWait(webDriver, 7);
		wait.until(ExpectedConditions.invisibilityOf(barNotificationSuccess));
		 
	}

	@FindBy(css="strong.current-item")
	private WebElement breadcrumb;
	
	@FindBy(css="input.button-2.email-a-friend-button")
	private WebElement emailFriendLink;
	
	@FindBy(css="span.price-value-4")
	private WebElement productPriceLabel;
	
	@FindBy(linkText="Add your review")
	private WebElement addReviewLink;
	
	@FindBy(id="add-to-wishlist-button-4")
	private WebElement addWishListBtn;
	
	@FindBy(css="input.button-2.add-to-compare-list-button")
	private WebElement addToCompareBtn;
	
	@FindBy(id="bar-notification")
	private WebElement barNotificationSuccess;

	@FindBy(id="add-to-cart-button-4")
	private WebElement addToCartBtn;
}
