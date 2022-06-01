package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CheckoutPage extends PageObject {

    @FindBy(id = "country")
    private WebElementFacade estimateShippingCountryDropdown;
    @FindBy(id = "region_id")
    private WebElementFacade estimateShippingRegionDropdown;
    @FindBy(id = "city")
    private WebElementFacade estimateShippingCityTab;
    @FindBy(id = "postcode")
    private WebElementFacade estimateShippingPostCode;
    @FindBy(css = ".method-checkout-cart-methods-onepage-bottom [title='Proceed to Checkout'")
    private WebElementFacade proceedToCheckoutButton;
    @FindBy(id = "login:guest")
    private WebElementFacade loginAsGuestRadioButton;
    @FindBy(id = "onepage-guest-register-button")
    private WebElementFacade continueButton;
    @FindBy(id = "billing:firstname")
    private WebElementFacade billingFirstName;
    @FindBy(id = "billing:lastname")
    private WebElementFacade billingLastName;
    @FindBy(id = "billing:email")
    private WebElementFacade billingEmail;
    @FindBy(id = "billing:street1")
    private WebElementFacade billingAddress;
    @FindBy(id = "billing:city")
    private WebElementFacade billingCity;
    @FindBy(name = "billing[country_id]")
    private WebElementFacade billingCountryDropdown;
    @FindBy(name = "billing[region_id]")
    private WebElementFacade billingRegionDropdown;
    @FindBy(id = "billing:postcode")
    private WebElementFacade billingPostCode;
    @FindBy(id = "billing:telephone")
    private WebElementFacade billingPhoneNumber;
    @FindBy(id = "billing:use_for_shipping_yes")
    private WebElementFacade billingShipToThisAddress;
    @FindBy(css = "#billing-buttons-container [title='Continue']")
    private WebElementFacade billingContinueButton;
    @FindBy(id = "s_method_freeshipping_freeshipping")
    private WebElementFacade shippingMethod;
    @FindBy(css = "#shipping-method-buttons-container .button")
    private WebElementFacade shippingContinueButton;
    @FindBy(css = "#payment-buttons-container .button")
    private WebElementFacade paymentContinueButton;
    @FindBy(css = "#review-buttons-container .button")
    private WebElementFacade placeOrderButton;
    @FindBy(css = ".sub-title")
    private WebElementFacade successMessageOrderPlaced;


    public void selectEstimateShippingCountryDropdown(String countryValue) {
        selectFromDropdown(estimateShippingCountryDropdown, countryValue);
    }

    public void selectEstimateShippingRegionDropdown(String regionValue) {
        selectFromDropdown(estimateShippingRegionDropdown, regionValue);
    }

    public void setEstimateShippingCityTab(String cityValue) {
        typeInto(estimateShippingCityTab, cityValue);
    }

    public void setEstimateShippingPostCode(String postcodeValue) {
        typeInto(estimateShippingPostCode, postcodeValue);
    }

    public void clickProceedToCheckout() {
        proceedToCheckoutButton.click();
    }

    public void clickLoginAsGuestRadioButton() {
        loginAsGuestRadioButton.click();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void setBillingFirstName(String firstNameValue) {
        typeInto(billingFirstName, firstNameValue);
    }

    public void setBillingLastName(String lastNameValue) {
        typeInto(billingLastName, lastNameValue);
    }

    public void setBillingEmail(String billingEmailValue) {
        typeInto(billingEmail, billingEmailValue);
    }

    public void setBillingAddress(String billingAddressValue) {
        typeInto(billingAddress, billingAddressValue);
    }

    public void setBillingCity(String billingCityValue) {
        typeInto(billingCity, billingCityValue);
    }

    public void setBillingCountryDropdown(String billingCountryValue) {
        selectFromDropdown(billingCountryDropdown, billingCountryValue);
    }

    public void setBillingRegionDropdown(String billingRegionValue) {
        selectFromDropdown(billingRegionDropdown, billingRegionValue);
    }

    public void setBillingPostCode(String billingPostCodeValue) {
        typeInto(billingPostCode, billingPostCodeValue);
    }

    public void setBillingPhoneNumber(String billingPhoneNumberValue) {
        typeInto(billingPhoneNumber, billingPhoneNumberValue);
    }

    public void clickBillingShipToThisAddress() {
        clickOn(billingShipToThisAddress);
    }

    public void clickBillingContinueButton() {
        clickOn(billingContinueButton);
    }

    public void clickShippingMethod() {
        clickOn(shippingMethod);
    }

    public void clickShippingContinueButton() {
        clickOn(shippingContinueButton);
    }

    public void clickPaymentContinueButton() {
        clickOn(paymentContinueButton);
    }

    public void clickPlaceOrderButton() {
        clickOn(placeOrderButton);
    }

    public void verifySuccessMessageOrderHasBeenPlaced() {
        successMessageOrderPlaced.shouldContainOnlyText("THANK YOU FOR YOUR PURCHASE!");
    }
}
