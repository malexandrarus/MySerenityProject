package com.fasttrackit.features.search;

import com.fasttrackit.model.BillingInformation;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutAsGuestTest() {
        checkoutSteps.navigateToHomepage();
        searchSteps.doSearch("necklace");
        productSteps.selectProductFromList("Silver Desert Necklace");
        checkoutSteps.clickAddToCart();
        checkoutSteps.estimateShippingMethod("România", "Cluj", "Cluj-Napoca", "400495");
        checkoutSteps.checkoutAsGuest();
        checkoutSteps.setBillingInformation(buildBillingInformation());
        checkoutSteps.clickBillingShipToThisAddress();
        checkoutSteps.clickBillingContinueButton();
        wait(8000);
        checkoutSteps.clickShippingMethod();
        checkoutSteps.clickShippingContinueButton();
        checkoutSteps.clickPaymentContinueButton();
        checkoutSteps.clickPlaceOrderButton();
        checkoutSteps.verifySuccessMessageOrderHasBeenPlaced();

    }

    private BillingInformation buildBillingInformation() {
        BillingInformation billingInformation = new BillingInformation();
        billingInformation.setBillingFirstName("Alexandra");
        billingInformation.setBillingLastName("Rus");
        String email = RandomStringUtils.randomAlphabetic(10) + "@email.com";
        billingInformation.setBillingEmail(email);
        billingInformation.setBillingAddress("Buna Ziua");
        billingInformation.setBillingCity("Cluj-Napoca");
        billingInformation.setBillingCountryDropdown("România");
        billingInformation.setBillingRegionDropdown("Cluj");
        billingInformation.setBillingPostCode("400495");
        long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        billingInformation.setBillingPhoneNumber(String.valueOf(number));

        return billingInformation;
    }
}
