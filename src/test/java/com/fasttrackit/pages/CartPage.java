package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class CartPage extends PageObject {

    @FindBy(css = "#shopping-cart-table tbody tr")
    private List<WebElementFacade> listOfProductsAddedToCart;
    @FindBy(css = ".success-msg span")
    private WebElementFacade successMessage;

    public void verifySuccessMessage(String productName) {
        successMessage.shouldContainOnlyText(productName + " was added to your shopping cart.");
    }

    public boolean addQuantityToProduct(int quantity, String productName) {
        for (WebElementFacade element : listOfProductsAddedToCart) {
            if (productName.equalsIgnoreCase(element.findElement(By.cssSelector(".product-name a")).getText())) {
                element.findElement(By.cssSelector("[title='Qty']")).clear();
                element.findElement(By.cssSelector("[title='Qty']")).sendKeys(quantity + "");
                element.findElement(By.cssSelector("[title='Update']")).click();
                return true;
            }
        }
        return false;
    }

    public void deleteItemFromCart(String productName) {
        for (WebElementFacade element : listOfProductsAddedToCart) {
            if (element.findElement(By.cssSelector(".product-name a")).getText().equalsIgnoreCase(productName)) {
                element.findElement(By.cssSelector(".a-center [title='Remove Item']")).click();
            }
        }
    }
}
