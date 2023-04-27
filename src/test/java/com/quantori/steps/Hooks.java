package com.quantori.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.quantori.utils.config.Config;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {


    @Before
    public void setBrowser() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = Config.getServiceConfig().baseUrl();
    }

    @After
    public void close() {
        Selenide.closeWebDriver();
    }
}
