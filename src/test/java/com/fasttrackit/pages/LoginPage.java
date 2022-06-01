package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

public class LoginPage extends PageObject {

    @FindBy(id = "email")
    private WebElementFacade emailField;
    @FindBy(id = "pass")
    private WebElementFacade passwordField;
    @FindBy(id = "send2")
    private WebElementFacade loginButton;
    @FindBy(id = "advice-required-entry-email")
    private WebElementFacade emailMessage;
    @FindBy(id = "advice-required-entry-pass")
    private WebElementFacade passwordMessage;
    @FindBy(css = ".error-msg span")
    private WebElementFacade invalidEmailMessage;

    public void setEmailField(String email) {
        typeInto(emailField, email);
    }

    public void setPasswordField(String password) {
        typeInto(passwordField, password);
    }

    public void clickLoginButton() {
        clickOn(loginButton);
    }

    public void clickLoginWithEnterKey() {
        loginButton.sendKeys(Keys.ENTER);
    }

    public void verifyEmptyEmailMessage() {
        emailMessage.shouldContainOnlyText("This is a required field.");
    }

    public void verifyPasswordMessage() {
        passwordMessage.shouldContainOnlyText("This is a required field.");
    }

    public void verifyInvalidEmailMessage() {
        invalidEmailMessage.shouldContainOnlyText("Invalid login or password.");
    }
}
