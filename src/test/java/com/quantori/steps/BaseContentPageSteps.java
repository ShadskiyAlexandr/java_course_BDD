package com.quantori.steps;

import com.codeborne.selenide.Condition;
import com.quantori.constants.Endpoints;
import com.quantori.pages.BaseContentPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseContentPageSteps {

    private final BaseContentPage baseContentPage;

    public BaseContentPageSteps(BaseContentPage baseContentPage) {
        this.baseContentPage = baseContentPage;
    }

    @Given("user opened {string} page")
    @When("user opens {string} page")
    public void userOpenedBrowser(String pageName) {
        open(Endpoints.valueOf(pageName).getUrlPage());
    }

    @Then("user should be redirected to {string} page")
    @Then("user should stay on {string} page")
    public void checkUserRedirect(String pageName) {
        baseContentPage.checkUserRedirect(pageName);
    }

    @Then("text {string} should be visible")
    public void textShouldBeVisible(String text) {
        $(byText(text)).shouldBe(Condition.visible);
    }
}
