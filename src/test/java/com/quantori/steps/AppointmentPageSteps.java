package com.quantori.steps;

import com.quantori.pages.AppointmentPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class AppointmentPageSteps {

    private final AppointmentPage appointmentPage;

    public AppointmentPageSteps(AppointmentPage appointmentPage) {
        this.appointmentPage = appointmentPage;
    }

    @When("user selects {string} from Facility dropdown")
    @Given("user selected {string} from Facility dropdown")
    public void selectValueFromFacilityDropdown(String value) {
        appointmentPage.selectValueFromFacilityDropdown(value);
    }

    @When("user selects {string} radiobutton")
    @Given("user selected {string} radiobutton")
    public void selectRadioButton(String value) {
        appointmentPage.selectRadioButton(value);
    }


    @When("user clicks Book button")
    @Given("user clicked Book button")
    public void userClicksBookButton() {
        appointmentPage.clickBookAppointment();
    }

    @When("user selects a visit date - {string}")
    @Given("user selected a visit date - {string}")
    public void userSelectsAVisitDate(String dateReq) {
        appointmentPage.setVisitDate(dateReq);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
