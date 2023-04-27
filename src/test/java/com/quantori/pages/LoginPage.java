package com.quantori.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement userNameInput = $("#txt-username");
    private SelenideElement userPasswordInput = $("#txt-password");
    private SelenideElement loginButton = $("#btn-login");
    public SelenideElement loginErrorMessage = $(".text-danger");
    public void enterUserName(String name) {
        userNameInput.setValue(name);
    }

    public void enterUserPassword(String password) {
        userPasswordInput.setValue(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void checkLoginErrorMessage() {
        loginErrorMessage.shouldBe(Condition.visible);
    }
}
