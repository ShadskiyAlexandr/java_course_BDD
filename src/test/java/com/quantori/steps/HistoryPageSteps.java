package com.quantori.steps;

import com.quantori.dto.HistoryCard;
import com.quantori.pages.HistoryPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class HistoryPageSteps {

    private final HistoryPage historyPage;

    public HistoryPageSteps(HistoryPage historyPage) {
        this.historyPage = historyPage;
    }

    @Then("history card should be with following data:$")
    public void checkHistoryData(DataTable table) {
        HistoryCard actualCard = historyPage.buildCard();

        List<Map<String,String>> data = table.asMaps(String.class, String.class);

        HistoryCard expectedCard = historyPage.buildCard(data.get(0));

        assertEquals(expectedCard, actualCard);
    }
}
