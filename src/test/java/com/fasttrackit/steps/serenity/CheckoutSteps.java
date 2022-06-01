package com.fasttrackit.steps.serenity;

import com.fasttrackit.model.BillingInformation;
import com.fasttrackit.pages.CartPage;
import com.fasttrackit.pages.CheckoutPage;
import com.fasttrackit.pages.HomePage;
import com.fasttrackit.pages.ProductPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CheckoutSteps extends ScenarioSteps {

    private HomePage homePage;
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;


    @Step
    public void navigateToHomepage() {
        homePage.open();
    }

    @Step
    public void clickAddToCart() {
        productPage.clickAddToCartButton();
    }

    @Step
    public void estimateShippingMethod(String countryValue, String regionValue, String cityValue, String postcodeValue) {
        checkoutPage.selectEstimateShippingCountryDropdown(countryValue);
        checkoutPage.selectEstimateShippingRegionDropdown(regionValue);
        checkoutPage.setEstimateShippingCityTab(cityValue);
        checkoutPage.setEstimateShippingPostCode(postcodeValue);
        checkoutPage.clickProceedToCheckout();
    }

    @Step
    public void checkoutAsGuest() {
        checkoutPage.clickLoginAsGuestRadioButton();
        checkoutPage.clickContinueButton();
    }

    @Step
    public void setBillingInformation(BillingInformation billingInformation) {
        checkoutPage.setBillingFirstName(billingInformation.getBillingFirstName());
        checkoutPage.setBillingLastName(billingInformation.getBillingLastName());
        checkoutPage.setBillingEmail(billingInformation.getBillingEmail());
        checkoutPage.setBillingAddress(billingInformation.getBillingAddress());
        checkoutPage.setBillingCity(billingInformation.getBillingCity());
        checkoutPage.setBillingCountryDropdown(billingInformation.getBillingCountryDropdown());
        checkoutPage.setBillingRegionDropdown(billingInformation.getBillingRegionDropdown());
        checkoutPage.setBillingPostCode(billingInformation.getBillingPostCode());
        checkoutPage.setBillingPhoneNumber(billingInformation.getBillingPhoneNumber());
    }

    @Step
    public void clickBillingShipToThisAddress() {
        checkoutPage.clickBillingShipToThisAddress();
    }

    @Step
    public void clickBillingContinueButton() {
        checkoutPage.clickBillingContinueButton();
    }

    @Step
    public void clickShippingMethod() {
        checkoutPage.clickShippingMethod();
    }

    @Step
    public void clickShippingContinueButton() {
        checkoutPage.clickShippingContinueButton();
    }

    @Step
    public void clickPaymentContinueButton() {
        checkoutPage.clickPaymentContinueButton();
    }

    @Step
    public void clickPlaceOrderButton() {
        checkoutPage.clickPlaceOrderButton();
    }

    @Step
    public void verifySuccessMessageOrderHasBeenPlaced() {
        checkoutPage.verifySuccessMessageOrderHasBeenPlaced();
    }
}
