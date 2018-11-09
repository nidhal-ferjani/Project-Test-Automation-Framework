package com.selenium.taf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage extends PageBase {

	public CheckOutPage(WebDriver webDriver) {
		super(webDriver);
	}

	public void selectAddressCountryFromList(String country) {
		dropDownSelectByVisibileText(billingNewAddressCountryList, country);
	}

	public void selectBbillingAddressFromList(String text) {
		dropDownSelectByVisibileText(billingAddressSelect, text);
	}

	public String getTextProductName() {

		return productName.getText();
	}

	public String getTextSuccessMessageLabel() throws InterruptedException {

		return successMessageLabel.getText();
	}

	public void confirmOrder() {
		clickButton(confirmOrderBtn);
	}

	public void completeOrderAndRedirctToHome() {
		clickButton(CompletedOrderBtn);
	}

	public void registredUserCheckOutProduct(String country, String city, String addressTxt, String codePostal,
			String phoneNumber) {

		WebDriverWait wait = new WebDriverWait(webDriver, 10);

		selectAddressCountryFromList(country);
		setTextElementText(BillingNewAddressCityTxt, city);
		setTextElementText(BillingNewAddressTxt, addressTxt);
		setTextElementText(zipPostalCodeTxt, codePostal);
		setTextElementText(phoneNumberTxt, phoneNumber);
		clickButton(nextStepAddressBtn);

		clickButton(nextDayAirRadioBtn);

		clickButton(nextStepShippingMethodBtn);
		clickButton(paymentMethodRadioBtn);
		clickButton(nextStepPaymentMethodBtn);
		wait.until(ExpectedConditions.visibilityOf(nextStepPaymentInfoBtn));
		clickButton(nextStepPaymentInfoBtn);
	}

	public void viewOrderDetails() {
		clickButton(detailsOrderLink);
	}

	public void registredUserCheckOutProduct(String firstName, String lastName, String email,String country, String city, String addressTxt, String codePostal,
			String phoneNumber) {

		setTextElementText(firstNameTxt, firstName);
		setTextElementText(lastNameTxt, lastName);
		setTextElementText(emailTxt, email);
		
		registredUserCheckOutProduct(country, city, addressTxt, codePostal, phoneNumber);
	}
	
	public void checkOutAsGuset() {
		clickButton(checkOutGuestBtn);
	}

	@FindBy(id = "billing-address-select")
	private WebElement billingAddressSelect;

	@FindBy(id = "BillingNewAddress_CountryId")
	private WebElement billingNewAddressCountryList;

	@FindBy(id = "BillingNewAddress_City")
	private WebElement BillingNewAddressCityTxt;

	@FindBy(id = "BillingNewAddress_Address1")
	private WebElement BillingNewAddressTxt;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	private WebElement zipPostalCodeTxt;

	@FindBy(id = "BillingNewAddress_PhoneNumber")
	private WebElement phoneNumberTxt;

	@FindBy(css = "div#billing-buttons-container input")
	private WebElement nextStepAddressBtn;

	@FindBy(id = "shippingoption_0")
	private WebElement nextDayAirRadioBtn;

	@FindBy(css = "input.button-1.shipping-method-next-step-button")
	private WebElement nextStepShippingMethodBtn;

	@FindBy(id = "paymentmethod_0")
	private WebElement paymentMethodRadioBtn;

	@FindBy(css = "input.button-1.payment-method-next-step-button")
	private WebElement nextStepPaymentMethodBtn;

	@FindBy(css = "input.button-1.payment-info-next-step-button")
	private WebElement nextStepPaymentInfoBtn;

	@FindBy(css = "input.button-1.confirm-order-next-step-button")
	private WebElement confirmOrderBtn;

	@FindBy(css = "div.details-link a")
	private WebElement detailsOrderLink;

	@FindBy(css = "input.button-1.order-completed-continue-button")
	private WebElement CompletedOrderBtn;

	@FindBy(css = "td.product a")
	private WebElement productName;

	@FindBy(xpath = "//div[@class='title']//strong[1]")
	private WebElement successMessageLabel;

	@FindBy(css = "input.button-1.checkout-as-guest-button")
	private WebElement checkOutGuestBtn;

	@FindBy(id = "BillingNewAddress_FirstName")
	private WebElement firstNameTxt;

	@FindBy(id = "BillingNewAddress_LastName")
	private WebElement lastNameTxt;

	@FindBy(id = "BillingNewAddress_Email")
	private WebElement emailTxt;
}
