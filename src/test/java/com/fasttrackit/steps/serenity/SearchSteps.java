package com.fasttrackit.steps.serenity;


import com.fasttrackit.pages.HomePage;
import com.fasttrackit.pages.SearchResultsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class SearchSteps extends ScenarioSteps {

    private HomePage homePage;
    private SearchResultsPage searchResultsPage;

    @Step
    public void doSearch(String keyword) {
        homePage.open();
        homePage.setSearchField(keyword);
        homePage.clickSearchIcon();
    }

    @Step
    public void verifyProductInResults(String productName) {
        Assert.assertTrue(searchResultsPage.checkListForProduct(productName));
    }

    @Step
    public void openSearchedProduct(String product) {
        searchResultsPage.openSearchedElement(product);
    }

    @Step
    public void checkProductIsNotInList(String product) {
        searchResultsPage.checkProductIsNotInList(product);
    }

    @Step
    public void addProductToWishlist() {
        searchResultsPage.addProductToWishlist();
    }

    @Step
    public void verifyAddToWishlistMessage(String product) {
        searchResultsPage.verifyAddToWishListMessage(product);
    }

}
