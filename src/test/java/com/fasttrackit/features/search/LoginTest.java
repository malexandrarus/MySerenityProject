package com.fasttrackit.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidCredentialsTest() {
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.setCredentials("drh_monica@yahoo.com", "Mai@2022");
        loginSteps.clickLogin();
        loginSteps.verifyUsernameMessage("Alexandra Monica Rus");
    }

    @Test
    public void loginWithValidCredentialsFollowedByEnterKey() {
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.setCredentials("drh_monica@yahoo.com", "Mai@2022");
        loginSteps.clickLoginWithEnterKey();
        loginSteps.verifyUsernameMessage("Alexandra Monica Rus");
    }

    @Test
    public void loginWithoutMandatoryFields() {
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.setCredentials("", "");
        loginSteps.clickLogin();
        loginSteps.verifyEmailMessage();
        loginSteps.verifyPasswordMessage();
    }

    @Test
    public void loginWithInvalidCredentials() {
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        String email = RandomStringUtils.randomAlphabetic(10) + "@email.com";
        loginSteps.setCredentials(email, "Mai@2022");
        loginSteps.clickLogin();
        loginSteps.verifyInvalidEmailMessage();
    }

    @Test
    public void loginWithEmptyFields() {
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        loginSteps.clickLogin();
        loginSteps.verifyEmailMessage();
        loginSteps.verifyPasswordMessage();
    }

    @Test
    public void forgotPasswordTest() {
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        forgotPasswordSteps.verifyForgotPassword();
        forgotPasswordSteps.emailRetrievePassword("drh_monica@yahoo.com");
        forgotPasswordSteps.retrievePassSubmitButton();
        forgotPasswordSteps.verifyForgotPassMessage("drh_monica@yahoo.com");
    }

    @Test
    public void forgotPassBackToLoginButton() {
        loginSteps.navigateToHomepage();
        loginSteps.navigateToLogin();
        forgotPasswordSteps.verifyForgotPassword();
        forgotPasswordSteps.backToLoginButton();
    }
}
