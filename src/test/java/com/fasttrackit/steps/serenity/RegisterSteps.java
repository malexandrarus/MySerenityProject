package com.fasttrackit.steps.serenity;

import com.fasttrackit.pages.AccountPage;
import com.fasttrackit.pages.HomePage;
import com.fasttrackit.pages.RegisterPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class RegisterSteps extends ScenarioSteps {

    private HomePage homePage;
    private AccountPage accountPage;
    private RegisterPage registerPage;

    @Step
    public void navigateToHomepage() {
        homePage.open();
    }

    @Step
    public void navigateToRegister() {
        homePage.clickAccountLink();
        homePage.clickRegisterLink();
    }

    @Step
    public void setData(String firstName, String middleName, String lastName, String emailAddress, String password, String confirmationPass) {
        registerPage.setFirstNameRegisterPage(firstName);
        registerPage.setMiddleNameRegisterPage(middleName);
        registerPage.setLastNameRegisterPage(lastName);
        registerPage.setEmailAddress(emailAddress);
        registerPage.setRegisterPassword(password);
        registerPage.setRegisterConfirmationPassword(confirmationPass);
    }

    @Step
    public void checkNewsletterButton() {
        registerPage.newsletterRegisterCheckbox();
    }

    @Step
    public void clickRegister() {
        registerPage.registerSubmitButton();
    }

    @Step
    public void verifySuccessRegister() {
        registerPage.verifySuccessRegisterMessage();
    }

    @Step
    public void validateEmailAddress() {
        registerPage.validateEmailAddress();
    }

    @Step
    public void firstNameFieldMessageValidation() {
        registerPage.firstNameFieldMessageValidation();
    }

    @Step
    public void lastNameFieldMessageValidation() {
        registerPage.lastNameFieldMessageValidation();
    }

    @Step
    public void emailAddressValidationMessage() {
        registerPage.emailAddressMessageValidation();
    }

    @Step
    public void passwordMessageValidation() {
        registerPage.passwordMessageValidation();
    }

    @Step
    public void confirmationPasswordMessageValidation() {
        registerPage.passwordConfirmationMessageValidation();
    }

    @Step
    public void passwordMessageAdviceValidation() {
        registerPage.passwordAdviceMessageValidation();
    }

    @Step
    public void passwordMatchValidationMessage() {
        registerPage.passwordMatchValidationMessage();
    }
}
