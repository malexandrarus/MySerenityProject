package com.fasttrackit.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.fasttrackit.utils.Constants.USER_EMAIL;
import static com.fasttrackit.utils.Constants.USER_PASSWORD;

@RunWith(SerenityRunner.class)
public class CompareTest extends BaseTest {

    @Test
    public void addProductToCompareTest() {
        searchSteps.doSearch("EARRINGS");
        compareSteps.clickOnCompareButton();
        compareSteps.addToCompareSuccessMessage("Swing Time Earrings");
    }

    @Test
    public void addProductToCompareTestWithLogin() {
        loginSteps.doLogin(USER_EMAIL, USER_PASSWORD);
        searchSteps.doSearch("EARRINGS");
        compareSteps.addProductToCompare("EARRINGS");
        compareSteps.addToCompareSuccessMessage("Swing Time Earrings");
    }
}
