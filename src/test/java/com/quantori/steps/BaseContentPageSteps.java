package com.quantori.steps;

import com.quantori.constants.Endpoints;
import com.quantori.pages.BaseContentPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Selenide.open;

public class BaseContentPageSteps {

    private final BaseContentPage baseContentPage;

    public BaseContentPageSteps(BaseContentPage baseContentPage) {
        this.baseContentPage = baseContentPage;
    }

    @Given("user opened {string} page")
    public void userOpenedBrowser(String pageName) {
        open(Endpoints.valueOf(pageName).getUrlPage());
    }

    @Then("user should be redirected to {string} page")
    public void checkUserRedirect(String pageName) {
    }
}
