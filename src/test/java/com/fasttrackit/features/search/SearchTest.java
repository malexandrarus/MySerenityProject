package com.fasttrackit.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.fasttrackit.utils.Constants.USER_EMAIL;
import static com.fasttrackit.utils.Constants.USER_PASSWORD;

@RunWith(SerenityRunner.class)
public class SearchTest extends BaseTest {

    @Test
    public void searchProductTest() {
        loginSteps.doLogin(USER_EMAIL, USER_PASSWORD);
        searchSteps.doSearch("Necklace");
        searchSteps.verifyProductInResults("SILVER DESERT NECKLACE");
    }

    @Test
    public void openSearchedProductTest() {
        loginSteps.doLogin(USER_EMAIL, USER_PASSWORD);
        searchSteps.doSearch("Necklace");
        searchSteps.openSearchedProduct("SILVER DESERT NECKLACE");
    }

    @Test
    public void checkProductIsNotInListTest() {
        loginSteps.doLogin(USER_EMAIL, USER_PASSWORD);
        searchSteps.doSearch("dog");
        searchSteps.checkProductIsNotInList("dog");
    }

    @Test
    public void verifyAddProductToWishlistTest() {
        loginSteps.doLogin(USER_EMAIL, USER_PASSWORD);
        searchSteps.doSearch("NECKLACE");
        searchSteps.addProductToWishlist();
        searchSteps.verifyAddToWishlistMessage("Silver Desert Necklace");
    }

    @Test
    public void verifySortByPrice(){
        loginSteps.doLogin(USER_EMAIL, USER_PASSWORD);
        searchSteps.doSearch("LUDLOW");
        searchSteps.verifySortByPriceAscending();
    }
}
