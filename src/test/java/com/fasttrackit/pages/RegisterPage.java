package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.javascript.JavascriptExecutorFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class RegisterPage extends PageObject {

    @FindBy(id = "firstname")
    private WebElementFacade firstName;
    @FindBy(id = "middlename")
    private WebElementFacade middleName;
    @FindBy(id = "lastname")
    private WebElementFacade lastName;
    @FindBy(id = "email_address")
    private WebElementFacade emailAddress;
    @FindBy(id = "password")
    private WebElementFacade registerPassword;
    @FindBy(id = "confirmation")
    private WebElementFacade registerConfirmationPassword;
    @FindBy(css = ".checkbox")
    private WebElementFacade newsletterCheckbox;
    @FindBy(css = ".buttons-set span span")
    private WebElementFacade registerSubmitButton;
    @FindBy(css = ".success-msg span")
    private WebElementFacade successRegistrationMessage;
    @FindBy(id = "advice-validate-email-email_address")
    private WebElementFacade validateEmailAddress;
    @FindBy(id = "advice-required-entry-firstname")
    private WebElementFacade firstNameFieldMessage;
    @FindBy(id = "advice-required-entry-lastname")
    private WebElementFacade lastNameFieldMessage;
    @FindBy(id = "advice-required-entry-email_address")
    private WebElementFacade emailAddressMessage;
    @FindBy(id = "advice-required-entry-password")
    private WebElementFacade passwordMessage;
    @FindBy(id = "advice-required-entry-confirmation")
    private WebElementFacade passwordConfirmationMessage;
    @FindBy(id = "advice-validate-password-password")
    private WebElementFacade passwordAdviceMessage;
    public WebDriver driver;
    @FindBy(id = "advice-validate-cpassword-confirmation")
    private WebElementFacade passwordMatchValidationMessage;

    public void setFirstNameRegisterPage(String firName) {
        typeInto(firstName, firName);
    }

    public void setMiddleNameRegisterPage(String midName) {
        typeInto(middleName, midName);
    }

    public void setLastNameRegisterPage(String lasName) {
        typeInto(lastName, lasName);
    }

    public void setEmailAddress(String email) {
        typeInto(emailAddress, email);
    }

    public void setRegisterPassword(String pass) {
        typeInto(registerPassword, pass);
    }

    public void setRegisterConfirmationPassword(String confPass) {
        typeInto(registerConfirmationPassword, confPass);
    }

    public void newsletterRegisterCheckbox() {
        clickOn(newsletterCheckbox);
    }

    public void registerSubmitButton() {
        clickOn(registerSubmitButton);
    }

    public void verifySuccessRegisterMessage() {
        successRegistrationMessage.shouldContainOnlyText("Thank you for registering with Madison Island.");
    }

    public void validateEmailAddress() {
        validateEmailAddress.shouldContainOnlyText("Please enter a valid email address. For example johndoe@domain.com.");
    }

    public void firstNameFieldMessageValidation() {
        firstNameFieldMessage.shouldContainOnlyText("This is a required field.");
    }

    public void lastNameFieldMessageValidation() {
        lastNameFieldMessage.shouldContainOnlyText("This is a required field.");
    }

    public void emailAddressMessageValidation() {
        emailAddressMessage.shouldContainOnlyText("This is a required field.");
    }

    public void passwordMessageValidation() {
        passwordMessage.shouldContainOnlyText("This is a required field.");
    }

    public void passwordConfirmationMessageValidation() {
        passwordConfirmationMessage.shouldContainOnlyText("This is a required field.");
    }

    public void passwordAdviceMessageValidation() {
        passwordAdviceMessage.shouldContainOnlyText("Please enter 6 or more characters without leading or trailing spaces.");
    }

    public void passwordMatchValidationMessage() {
        passwordMatchValidationMessage.shouldContainOnlyText("Please make sure your passwords match.");
    }
}
