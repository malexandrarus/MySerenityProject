package com.fasttrackit.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class SearchTest extends BaseTest {

    @Test
    public void searchProductTest() {
        loginSteps.doLogin("drh_monica@yahoo.com", "Mai@2022");
        searchSteps.doSearch("Necklace");
        searchSteps.verifyProductInResults("SILVER DESERT NECKLACE");
    }

    @Test
    public void openSearchedProductTest() {
        loginSteps.doLogin("drh_monica@yahoo.com", "Mai@2022");
        searchSteps.doSearch("Necklace");
        searchSteps.openSearchedProduct("SILVER DESERT NECKLACE");
    }

    @Test
    public void checkProductIsNotInListTest() {
        loginSteps.doLogin("drh_monica@yahoo.com", "Mai@2022");
        searchSteps.doSearch("dog");
        searchSteps.checkProductIsNotInList("dog");
    }

    @Test
    public void verifyAddProductToWishlistTest() {
        loginSteps.doLogin("drh_monica@yahoo.com", "Mai@2022");
        searchSteps.doSearch("NECKLACE");
        searchSteps.addProductToWishlist();
        searchSteps.verifyAddToWishlistMessage("Silver Desert Necklace");
    }
}
