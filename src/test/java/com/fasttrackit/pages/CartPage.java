package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartPage extends PageObject {

    @FindBy(css = "#shopping-cart-table tbody tr")
    private List<WebElementFacade> listOfProductsAddedToCart;
    @FindBy(css = ".success-msg span")
    private WebElementFacade successMessage;
    @FindBy(css = ".product-cart-price .price")
    private List<WebElementFacade> priceList;
    @FindBy(css = "strong .price")
    private WebElementFacade totalGrandPrice;
    @FindBy(id = "empty_cart_button")
    private WebElementFacade emptyCartButton;
    @FindBy(css = ".page-title h1")
    private  WebElementFacade cartEmptyMessage;
    @FindBy(css = ".cart-empty a")
    private WebElementFacade clickHereHyperlinkEmptyCart;
    @FindBy(css = ".large")
    private WebElementFacade homePageLogo;

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

    public double allProductPrices() {
        int totalPrice = 0;
        for (WebElementFacade element : priceList) {
            totalPrice += getPriceFromProductCart(element);
        }
        return totalPrice;
    }

    private double getPriceFromProductCart(WebElementFacade elementFacade) {
        return Double.parseDouble(elementFacade.getText().replace(" RON", "").replaceAll(",", ""));
    }

    public double getTotalGrandPrice() {
        return getPriceFromProductCart(totalGrandPrice);
    }

    public boolean verifyIfGrandTotalPriceIsCorrectlyCalculated() {
        return (allProductPrices() == getTotalGrandPrice());
    }

    public void emptyCart() {
        if (emptyCartButton.isCurrentlyVisible()) {
            emptyCartButton.click();
            assertEquals("SHOPPING CART IS EMPTY", cartEmptyMessage);
        }else {
            clickOn(clickHereHyperlinkEmptyCart);
            assertTrue(homePageLogo.isDisplayed());
        }
    }
}
