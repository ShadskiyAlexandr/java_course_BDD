package com.quantori.steps;

import com.quantori.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.open;

public class LoginPageSteps {
    private final LoginPage loginPage;

    public LoginPageSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @When("user enters user name {string}")
    public void userEntersUserName(String userName) {
        loginPage.enterUserName(userName);
    }

    @When("user enters password {string}")
    public void userEntersPassword(String password) {
        loginPage.enterUserPassword(password);
    }

    @When("user clicks Login button")
    public void userClicksButton() {
        loginPage.clickLoginButton();
    }

    @Then("login error message is displayed")
    public void checkLoginErrorMessage() {
        loginPage.checkLoginErrorMessage();
    }
}
