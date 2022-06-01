package com.fasttrackit.steps.serenity;

import com.fasttrackit.pages.ForgotPasswordPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ForgotPasswordSteps extends ScenarioSteps {
    private ForgotPasswordPage forgotPasswordPage;

    @Step
    public void verifyForgotPassword() {
        forgotPasswordPage.forgotPassword();
    }

    @Step
    public void emailRetrievePassword(String emailAddress) {
        forgotPasswordPage.emailRetrievePassword(emailAddress);
    }

    @Step
    public void retrievePassSubmitButton() {
        forgotPasswordPage.retrievePassSubmitButton();
    }

    @Step
    public void verifyForgotPassMessage(String emailAddress) {
        forgotPasswordPage.verifyForgotPassMessage(emailAddress);
    }

    @Step
    public void backToLoginButton() {
        forgotPasswordPage.backToLoginButton();
    }
}
