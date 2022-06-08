package com.fasttrackit.steps.serenity;

import com.fasttrackit.pages.CartPage;
import com.fasttrackit.pages.HomePage;
import com.fasttrackit.pages.ProductPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class CartSteps extends ScenarioSteps {

    private HomePage homePage;
    private ProductPage productPage;
    private CartPage cartPage;

    @Step
    public void clickAddToCart() {
        productPage.clickAddToCartButton();
    }

    @Step
    public void verifySuccessMessage(String productName) {
        cartPage.verifySuccessMessage(productName);
    }

    @Step
    public void modifyQuantityForProductAddedToCart(int quantity, String product) {
        cartPage.addQuantityToProduct(quantity, product);
    }

    @Step
    public void deleteProductFromCart(String product) {
        cartPage.deleteItemFromCart(product);
    }

    @Step
    public void verifyProductPricesIsCorrectlyCalculatedInCart() {
        Assert.assertTrue(cartPage.verifyIfGrandTotalPriceIsCorrectlyCalculated());
    }

    @Step
    public void emptyCart() {
        homePage.clickAccountLink();
        homePage.clickMyCart();
        cartPage.emptyCart();
    }
}
