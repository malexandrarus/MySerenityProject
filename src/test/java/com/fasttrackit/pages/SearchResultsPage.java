package com.fasttrackit.pages;

import io.cucumber.messages.internal.com.google.common.primitives.Doubles;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class SearchResultsPage extends PageObject {

    @FindBy(css = ".products-grid li.item")
    private List<WebElementFacade> productList;
    @FindBy(css = ".btn-cart")
    private WebElementFacade addToCartButton;
    @FindBy(css = ".link-wishlist")
    private WebElementFacade addToWishListButton;
    @FindBy(css = ".note-msg")
    private WebElementFacade notFoundProductMessage;
    @FindBy(css = ".product-info .add-to-links a:nth-child(1)")
    private List<WebElementFacade> productAddToWishlistList;
    @FindBy(css = ".my-wishlist .success-msg")
    private WebElementFacade addToWishListMessage;
    @FindBy(css = ".category-products > .toolbar select[title='Sort By']")
    private WebElementFacade sortBySelection;

    public boolean checkListForProduct(String productName) {
        for (WebElementFacade element : productList) {
            if (element.findElement(By.cssSelector(".product-name a")).getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public boolean selectProductFromList(String product) {
        for (WebElementFacade element : productList) {
            if (element.findElement(By.cssSelector(".product-name a")).getText().equalsIgnoreCase(product)) {
                element.findElement(By.cssSelector("a.product-image")).click();
                break;
            }
        }
        return false;
    }

    public void openSearchedElement(String productName) {
        for (WebElementFacade element : productList) {
            if (element.findElement(By.cssSelector("a.product-image")).getText().equalsIgnoreCase(productName)) {
                element.findElement(By.cssSelector(".product-image img")).click();
                break;
            }
        }

    }

    public void checkProductIsNotInList(String productName) {
        notFoundProductMessage.shouldContainOnlyText("Your search returns no results.");

    }

    public void addProductToWishlist() {
        if (!productAddToWishlistList.isEmpty()) {
            WebElementFacade firstProduct = productAddToWishlistList.get(0);
            firstProduct.click();
        }
    }

    public void verifyAddToWishListMessage(String product) {
        addToWishListMessage.shouldContainOnlyText(product + " has been added to your wishlist. Click here to continue shopping.");
    }

    public void setSortByDropdown(String value) {
        sortBySelection.selectByVisibleText(value);
    }

    private double priceFromProduct(WebElementFacade element) {
        String priceString = element.find(By.cssSelector(".price")).getText();
        String priceStringWithPoint = priceString.replace(",", ".");
        String priceStringWithoutRon = priceStringWithPoint.replace("RON", "");

        return Double.parseDouble(priceStringWithoutRon);
    }

    public boolean isSortByPriceAscending() {
        double firstPrice = priceFromProduct(productList.get(0));
        double lastPrice = priceFromProduct(productList.get(productList.size() - 1));

        return Doubles.compare(firstPrice, lastPrice) < 0;
    }
}