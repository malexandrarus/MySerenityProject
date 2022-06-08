package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;


@DefaultUrl("http://testfasttrackit.info/selenium-test/")
public class HomePage extends PageObject {

    @FindBy(css = ".skip-account .label")
    private WebElementFacade accountLink;
    @FindBy(css = "[title='Log In']")
    private WebElementFacade loginLink;
    @FindBy(css = "#header-account :nth-child(5) >a")
    private WebElementFacade registerLink;
    @FindBy(id = "search")
    private WebElementFacade searchField;
    @FindBy(css = "[title='Search']")
    private WebElementFacade searchIcon;
    @FindBy(css = ".top-link-cart")
    private WebElementFacade myCartLink;

    public void clickAccountLink() {
        clickOn(accountLink);
    }

    public void clickLoginLink() {
        clickOn(loginLink);
    }

    public void clickMyCart() {
        clickOn(myCartLink);
    }

    public void clickRegisterLink() {
        clickOn(registerLink);
    }

    public void setSearchField(String keyword) {
        typeInto(searchField, keyword);
    }

    public void clickSearchIcon() {
        clickOn(searchIcon);
    }
}
