package com.fasttrackit.steps.serenity;

import com.fasttrackit.pages.AccountPage;
import com.fasttrackit.pages.ForgotPasswordPage;
import com.fasttrackit.pages.HomePage;
import com.fasttrackit.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;


public class LoginSteps extends ScenarioSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;

    @Step
    public void navigateToHomepage() {
        homePage.open();
    }

    @Step
    public void navigateToLogin() {
        homePage.clickAccountLink();
        homePage.clickLoginLink();
    }

    @Step
    public void setCredentials(String email, String pass) {
        loginPage.setEmailField(email);
        loginPage.setPasswordField(pass);
    }

    @Step
    public void clickLogin() {
        loginPage.clickLoginButton();
    }

    @Step
    public void clickLoginWithEnterKey() {
        loginPage.clickLoginWithEnterKey();

    }

    @Step
    public void verifyEmailMessage() {
        loginPage.verifyEmptyEmailMessage();
    }

    @Step
    public void verifyPasswordMessage() {
        loginPage.verifyPasswordMessage();
    }

    @Step
    public void verifyInvalidEmailMessage() {
        loginPage.verifyInvalidEmailMessage();
    }

    @Step
    public void verifyUsernameMessage(String userName) {
        accountPage.verifyWelcomeMessage(userName);
    }

    @Step
    public void doLogin(String email, String password) {
        navigateToHomepage();
        navigateToLogin();
        setCredentials(email, password);
        clickLogin();
    }
}
