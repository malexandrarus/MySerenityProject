package com.fasttrackit.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.fasttrackit.utils.Constants.USER_EMAIL;
import static com.fasttrackit.utils.Constants.USER_PASSWORD;

@RunWith(SerenityRunner.class)
public class CartTest extends BaseTest {

    @Test
    public void addProductToCartTest() {
        loginSteps.doLogin(USER_EMAIL, USER_PASSWORD);
        searchSteps.doSearch("necklace");
        productSteps.selectProductFromList("Silver Desert Necklace");
        cartSteps.clickAddToCart();
        cartSteps.verifySuccessMessage("Silver Desert Necklace");
    }

    @Test
    public void addQuantityToProductAddedToCartTest() {
        loginSteps.doLogin(USER_EMAIL, USER_PASSWORD);
        searchSteps.doSearch("necklace");
        productSteps.selectProductFromList("Silver Desert Necklace");
        cartSteps.clickAddToCart();
        cartSteps.modifyQuantityForProductAddedToCart(3, "SILVER DESERT NECKLACE");
    }

    @Test
    public void deleteProductFromCartTest() {
        loginSteps.doLogin(USER_EMAIL, USER_PASSWORD);
        searchSteps.doSearch("necklace");
        productSteps.selectProductFromList("Silver Desert Necklace");
        cartSteps.clickAddToCart();
        cartSteps.deleteProductFromCart("SILVER DESERT NECKLACE");
    }

    @Test
    public void emptyCartTest() {
        loginSteps.doLogin(USER_EMAIL, USER_PASSWORD);
        cartSteps.emptyCart();
    }

    @Test
    public void cartSummaryTotalPriceTest() {
        loginSteps.doLogin(USER_EMAIL, USER_PASSWORD);
        searchSteps.doSearch("necklace");
        productSteps.selectProductFromList("Silver Desert Necklace");
        cartSteps.clickAddToCart();
        searchSteps.doSearch("LEFTHANDED");
        productSteps.selectProductFromList("FALLING BY I AM NOT LEFTHANDED");
        cartSteps.clickAddToCart();
        searchSteps.doSearch("SWING");
        productSteps.selectProductFromList("SWING TIME EARRINGS");
        cartSteps.clickAddToCart();
        cartSteps.verifyProductPricesIsCorrectlyCalculatedInCart();
    }


}
