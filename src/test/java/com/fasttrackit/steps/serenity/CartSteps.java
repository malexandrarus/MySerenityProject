package com.fasttrackit.steps.serenity;

import com.fasttrackit.pages.CartPage;
import com.fasttrackit.pages.ProductPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CartSteps extends ScenarioSteps {

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
}
