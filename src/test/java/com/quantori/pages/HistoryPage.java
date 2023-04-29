package com.quantori.pages;

import com.codeborne.selenide.SelenideElement;
import com.google.common.base.Strings;
import com.quantori.dto.AppointmentCard;
import com.quantori.helpers.DateParser;
import com.quantori.pages.components.HistoryTable;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HistoryPage {

    private final String tableSelector = "//div[@class='panel panel-info']";

    public AppointmentCard buildCard () {
        HistoryTable historyTable = new HistoryTable($(By.xpath(tableSelector)).shouldBe(visible));
        List<SelenideElement> cells = historyTable.getCells();

        String facility = Strings.emptyToNull(cells.get(0).getText());
        String hospitalReadmission = Strings.emptyToNull(cells.get(1).getText());
        String healthcareProgram = Strings.emptyToNull(cells.get(2).getText());
        String comment = Strings.emptyToNull(cells.get(3).getText());

        return AppointmentCard.builder()
                .visitDate(historyTable.heading().getText())
                .facility(facility)
                .hospitalReadmission(hospitalReadmission)
                .healthcareProgram(healthcareProgram)
                .comment(comment)
                .build();
    }
}
