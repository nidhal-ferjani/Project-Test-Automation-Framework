package com.selenium.taf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase {

	public ProductReviewPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	
	public void addProductReview(String reviewTitle, String reviewText) {
		setTextElementText(reviewTitleTxt, reviewTitle);
		setTextElementText(productReviewTxt, reviewText);
		clickButton(productRatingRadioBtn);
		clickButton(submitReviewBtn);
	}
	
	public String getTextReviewNotification() {
		return reviewNotification.getText();
	}

	@FindBy(id="AddProductReview_Title")
	private WebElement reviewTitleTxt;
	
	@FindBy(id="AddProductReview_ReviewText")
	private WebElement productReviewTxt;
	
	@FindBy(id="addproductrating_1")
	private WebElement productRatingRadioBtn;
	
	@FindBy(name="add-review")
	private WebElement submitReviewBtn;
	
	@FindBy(className="result")
    private WebElement reviewNotification; 
}
