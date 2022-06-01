package com.fasttrackit.steps.serenity;

import com.fasttrackit.pages.SearchResultsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ProductSteps extends ScenarioSteps {

    private SearchResultsPage searchResultsPage;

    @Step
    public void selectProductFromList(String product) {
        searchResultsPage.selectProductFromList(product);
    }

}
