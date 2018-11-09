package com.selenium.taf.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {

	public ShoppingCartPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public void removeProductFromCart() {
		clickButton(removeFromCartCheckBox);
		clickButton(updateCartBtn);
	}
	
	public void updateProductQuantityInCart(String quantity) {
              
		clearText(itemQuantityTxt);
		setTextElementText(itemQuantityTxt, quantity);
		clickButton(updateCartBtn);
	}
	
	public boolean cartListContainsProduct(String productName) {
		for (WebElement row : allRowsCart) {
			if(row.getText().contains(productName)) {
				return true;
			}
		}
		return false;
	}
	
	public String getTextProductPriceLabel() {
		return productPriceLabel.getText();
	}
	
	public String getTextSubTotalLabel() {
		return subTotalLabel.getText();
	}
	
	public String getTextNoDataLabel() {
		return noDataLabel.getText();
	}
	
	public void openCheckOutPage() {
		clickButton(termsOfServiceCheckBox);
		clickButton(checkOutBtn);
	}
	
	@FindBy(css="td.remove-from-cart input")
	private WebElement removeFromCartCheckBox;
	
	@FindBy(css="td.quantity input")
	private WebElement itemQuantityTxt;
	
	@FindBy(name="updatecart")
	private WebElement updateCartBtn;
	
	@FindBy(css="span.product-subtotal")
	private WebElement subTotalLabel;
	
	@FindBy(css="table.cart tr")
	private List<WebElement>  allRowsCart;
	
	@FindBy(css="span.product-unit-price")
	private WebElement productPriceLabel;
	
	@FindBy(css="div.no-data")
	private WebElement noDataLabel;
	
	@FindBy(css="table.cart")
	private WebElement tableCart;
	
	@FindBy(id="termsofservice")
	private WebElement termsOfServiceCheckBox;
	
	@FindBy(id="checkout")
	private WebElement checkOutBtn;

}
