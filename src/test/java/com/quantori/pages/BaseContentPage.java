package com.quantori.pages;

import com.codeborne.selenide.WebDriverRunner;
import com.quantori.constants.Endpoints;
import com.quantori.utils.config.Config;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BaseContentPage {

    public void checkUserRedirect(String pageName) {
        String currentUrl = WebDriverRunner.url();

        String expectedUrl = Config.getServiceConfig().baseUrl() + Endpoints.valueOf(pageName).getUrlPage();


        System.out.println(currentUrl);
        System.out.println(expectedUrl);
        assertEquals(String.format("Current URL is %s, but should %s", currentUrl, expectedUrl),currentUrl, expectedUrl);
    }
}
