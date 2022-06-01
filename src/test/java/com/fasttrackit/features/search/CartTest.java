package com.fasttrackit.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class CartTest extends BaseTest {

    @Test
    public void addProductToCartTest() {
        loginSteps.doLogin("drh_monica@yahoo.com", "Mai@2022");
        searchSteps.doSearch("necklace");
        productSteps.selectProductFromList("Silver Desert Necklace");
        cartSteps.clickAddToCart();
        cartSteps.verifySuccessMessage("Silver Desert Necklace");
    }

    @Test
    public void addQuantityToProductAddedToCartTest() {
        loginSteps.doLogin("drh_monica@yahoo.com", "Mai@2022");
        searchSteps.doSearch("necklace");
        productSteps.selectProductFromList("Silver Desert Necklace");
        cartSteps.clickAddToCart();
        cartSteps.modifyQuantityForProductAddedToCart(3, "SILVER DESERT NECKLACE");
    }

    @Test
    public void deleteProductFromCartTest() {
        loginSteps.doLogin("drh_monica@yahoo.com", "Mai@2022");
        searchSteps.doSearch("necklace");
        productSteps.selectProductFromList("Silver Desert Necklace");
        cartSteps.clickAddToCart();
        cartSteps.deleteProductFromCart("SILVER DESERT NECKLACE");
    }
}
