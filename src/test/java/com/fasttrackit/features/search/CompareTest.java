package com.fasttrackit.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

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
        loginSteps.doLogin("drh_monica@yahoo.com", "Mai@2022");
        searchSteps.doSearch("EARRINGS");
        compareSteps.addProductToCompare("EARRINGS");
        compareSteps.addToCompareSuccessMessage("Swing Time Earrings");
    }
}
