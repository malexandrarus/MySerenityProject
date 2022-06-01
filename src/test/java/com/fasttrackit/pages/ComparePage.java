package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class ComparePage extends PageObject {

    @FindBy(css = ".products-grid li.item")
    private List<WebElementFacade> productList;
    @FindBy(css = ".link-compare")
    private WebElementFacade clickOnCompareButton;
    @FindBy(css = ".success-msg span")
    private WebElementFacade compareSuccessMessage;


    public boolean addProductToCompare(String productName) {
        for (WebElementFacade elementFacade : productList) {
            if (elementFacade.findElement(By.cssSelector(".product-name a")).getText().equalsIgnoreCase(productName)) {
                elementFacade.findElement(By.cssSelector(".link-compare")).click();
                return true;
            }
        }
        return false;
    }

    public void clickOnCompareButton() {
        clickOn(clickOnCompareButton);
    }

    public void compareSuccessMessage(String product) {
        compareSuccessMessage.shouldContainOnlyText("The product " + product + " has been added to comparison list.");
    }
}
