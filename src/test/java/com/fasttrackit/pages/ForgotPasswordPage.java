package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ForgotPasswordPage extends PageObject {
    @FindBy(css = "#login-form li:nth-child(3) > a")
    private WebElementFacade forgotPassword;
    @FindBy(id = "email_address")
    private WebElementFacade emailRetrievePassword;
    @FindBy(css = "[title~=Submit]")
    private WebElementFacade retrievePassSubmitButton;
    @FindBy(css = ".success-msg span")
    private WebElementFacade verifyForgotPassMessage;
    @FindBy(css = ".back-link a[href^='http']")
    private WebElementFacade backToLoginButton;

    public void forgotPassword() {
        clickOn(forgotPassword);
    }

    public void emailRetrievePassword(String email) {
        typeInto(emailRetrievePassword, email);
    }

    public void retrievePassSubmitButton() {
        clickOn(retrievePassSubmitButton);
    }

    public void verifyForgotPassMessage(String emailAddress) {
        verifyForgotPassMessage.shouldContainOnlyText("If there is an account associated with " + emailAddress + " you will receive an email with a link to reset your password.");
    }

    public void backToLoginButton() {
        if (backToLoginButton.isSelected()) {
            clickOn(backToLoginButton);
            WebElementFacade elementAfterBackToLoginButtonIsClicked = element(By.cssSelector(".page-title h1"));
            Assert.assertEquals("LOGIN OR CREATE AN ACCOUNT", elementAfterBackToLoginButtonIsClicked.getText());
        }
    }
}
