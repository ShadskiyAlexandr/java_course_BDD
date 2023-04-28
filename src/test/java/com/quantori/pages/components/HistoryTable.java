package com.quantori.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class HistoryTable {

    private final SelenideElement table;

    public ElementsCollection getCells() {
        return table.$$(By.xpath(".//div[contains(@class,'col-sm-10')]"));
    }

    public SelenideElement heading() {
        return table.$(By.xpath(".//div[@class='panel-heading']"));
    }

    public HistoryTable(SelenideElement table) {
        this.table = table;
    }
}
