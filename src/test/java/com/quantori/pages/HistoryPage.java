package com.quantori.pages;

import com.codeborne.selenide.SelenideElement;
import com.quantori.dto.HistoryCard;
import com.quantori.helpers.DateParser;
import com.quantori.pages.components.HistoryTable;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HistoryPage {

    private final String tableSelector = "//div[@class='panel panel-info']";

    private HistoryCard card;

    public HistoryCard buildCard () {
        HistoryTable historyTable = new HistoryTable($(By.xpath(tableSelector)).shouldBe(visible));
        List<SelenideElement> cells = historyTable.getCells();

        String facility = returnNullOrValue(cells.get(0).getText());
        String hospitalReadmission = returnNullOrValue(cells.get(1).getText());
        String healthcareProgram = returnNullOrValue(cells.get(2).getText());
        String comment = returnNullOrValue(cells.get(3).getText());

        card = HistoryCard.builder()
                .visitDate(historyTable.heading().getText())
                .facility(facility)
                .hospitalReadmission(hospitalReadmission)
                .healthcareProgram(healthcareProgram)
                .comment(comment)
                .build();

        return card;
    }

    public HistoryCard buildCard (Map<String,String> data) {
        HistoryTable historyTable = new HistoryTable($(By.xpath(tableSelector)).shouldBe(visible));

        DateParser parser = new DateParser();

        String visitDate = parser.getDate(data.get("Date"));
        String facility = data.get("Facility");
        String hospitalReadmission = data.get("Readmission");
        String healthcareProgram = data.get("Program");
        String comment = data.get("Comment");

        card = HistoryCard.builder()
                .visitDate(visitDate)
                .facility(facility)
                .hospitalReadmission(hospitalReadmission)
                .healthcareProgram(healthcareProgram)
                .comment(comment)
                .build();

        return card;
    }

    public String returnNullOrValue (String value) {
        return value.equals("") ? null : value;
    }
}
