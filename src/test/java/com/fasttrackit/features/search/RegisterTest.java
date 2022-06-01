package com.fasttrackit.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class RegisterTest extends BaseTest {

    @Test
    public void validRegisterTest() {
        registerSteps.navigateToHomepage();
        registerSteps.navigateToRegister();
        String email = RandomStringUtils.randomAlphabetic(10) + "@email.com";
        registerSteps.setData("Alexandra", "Monica", "Rus", email, "Mai@2023", "Mai@2023");
        registerSteps.checkNewsletterButton();
        registerSteps.clickRegister();
        registerSteps.verifySuccessRegister();
    }

    @Test
    public void registerWithEmailWithoutDotSignTest() {
        registerSteps.navigateToHomepage();
        registerSteps.navigateToRegister();
        String email = RandomStringUtils.randomAlphabetic(10) + "@emailcom";
        registerSteps.setData("Alexandra", "Monica", "Rus", email, "Mai@2023", "Mai@2023");
        registerSteps.checkNewsletterButton();
        registerSteps.clickRegister();
        registerSteps.validateEmailAddress();

    }

    @Test
    public void registerWithMandatoryFieldsWithoutFillingAnyDataAndClickOnRegisterTest() {
        registerSteps.navigateToHomepage();
        registerSteps.navigateToRegister();
        registerSteps.setData("", "", "", "", "", "");
        registerSteps.checkNewsletterButton();
        registerSteps.clickRegister();
        registerSteps.firstNameFieldMessageValidation();
        registerSteps.lastNameFieldMessageValidation();
        registerSteps.emailAddressValidationMessage();
        registerSteps.passwordMessageValidation();
        registerSteps.confirmationPasswordMessageValidation();
    }

    @Test
    public void registerWithMandatoryFieldsByFillingWithBlankSpacesAndClickOnRegisterTest() {
        registerSteps.navigateToHomepage();
        registerSteps.navigateToRegister();
        registerSteps.setData(" ", " ", " ", " ", " ", " ");
        registerSteps.checkNewsletterButton();
        registerSteps.clickRegister();
        registerSteps.firstNameFieldMessageValidation();
        registerSteps.lastNameFieldMessageValidation();
        registerSteps.emailAddressValidationMessage();
        registerSteps.passwordMessageValidation();
        registerSteps.confirmationPasswordMessageValidation();
    }

    @Test
    public void registerWithMinValueForPassword() {
        registerSteps.navigateToHomepage();
        registerSteps.navigateToRegister();
        String email = RandomStringUtils.randomAlphabetic(10) + "@emailcom";
        registerSteps.setData("Alexandra", "Monica", "Rus", email, "Mai2", "Mai2");
        registerSteps.checkNewsletterButton();
        registerSteps.clickRegister();
        registerSteps.passwordMessageAdviceValidation();
    }

    @Test
    public void passwordMatchRegistration() {
        registerSteps.navigateToHomepage();
        registerSteps.navigateToRegister();
        String email = RandomStringUtils.randomAlphabetic(10) + "@email.com";
        registerSteps.setData("Alexandra", "Monica", "Rus", email, "Mai@2023", "Mai");
        registerSteps.checkNewsletterButton();
        registerSteps.clickRegister();
        registerSteps.passwordMatchValidationMessage();
    }
}
