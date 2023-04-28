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
    public void enterUserName(String userName) {
        loginPage.enterUserName(userName);
    }

    @When("user enters password {string}")
    public void enterPassword(String password) {
        loginPage.enterUserPassword(password);
    }

    @When("user clicks Login button")
    public void clicksLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("login error message is displayed")
    public void checkLoginErrorMessage() {
        loginPage.checkLoginErrorMessage();
    }

    @Then("user logged with Login {string} and Password {string}")
    public void loginToTheSite(String login, String password) {
        open();
        enterUserName(login);
        enterPassword(password);
        clicksLoginButton();
    }
}
