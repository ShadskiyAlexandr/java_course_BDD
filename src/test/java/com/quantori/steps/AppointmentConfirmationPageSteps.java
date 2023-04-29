package com.quantori.steps;

import com.quantori.dto.AppointmentCard;
import com.quantori.pages.AppointmentConfirmationPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class AppointmentConfirmationPageSteps {

    private final AppointmentConfirmationPage appointmentConfirmationPage;

    public AppointmentConfirmationPageSteps(AppointmentConfirmationPage appointmentConfirmationPage) {
        this.appointmentConfirmationPage = appointmentConfirmationPage;
    }

    @Then("appointment detail should be equal to the following data:$")
    public void checkAppointmentData(DataTable table) {
        AppointmentCard actualCard = appointmentConfirmationPage.buildCard();

        List<Map<String,String>> data = table.asMaps(String.class, String.class);

        AppointmentCard expectedCard = AppointmentCard.createCard(data.get(0));

        assertEquals(expectedCard, actualCard);
    }
}
