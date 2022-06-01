package com.fasttrackit.steps.serenity;

import com.fasttrackit.pages.ComparePage;
import com.fasttrackit.pages.HomePage;
import com.fasttrackit.pages.SearchResultsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CompareSteps extends ScenarioSteps {
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private ComparePage comparePage;

    @Step
    public void addProductToCompare(String product) {
        comparePage.addProductToCompare(product);
    }

    @Step
    public void clickOnCompareButton() {
        comparePage.clickOnCompareButton();
    }

    @Step
    public void addToCompareSuccessMessage(String product) {
        comparePage.compareSuccessMessage(product);
    }
}
