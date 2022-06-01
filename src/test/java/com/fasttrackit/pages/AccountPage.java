package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class AccountPage extends PageObject {

    @FindBy(css = "p.hello strong")
    private WebElementFacade welcomeText;

    public void verifyWelcomeMessage(String userName) {
        welcomeText.shouldContainOnlyText("Hello, " + userName + "!");
    }
}
