package com.quantori.pages;

import com.codeborne.selenide.SelenideElement;
import com.quantori.helpers.DateParser;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import static com.codeborne.selenide.Selenide.$;

public class AppointmentPage {

    private SelenideElement facilityDropdown = $("#combo_facility");
    private SelenideElement bookButtons = $("#btn-book-appointment");
    private SelenideElement datePickerInput = $("#txt_visit_date");

    public void selectValueFromFacilityDropdown(String value) {
        facilityDropdown.selectOptionByValue(value);
    }
    public void selectRadioButton(String value) {
        String selector = String.format("//input[@value='%s']", value);
        $(By.xpath(selector)).click();
    }

    public void clickBookAppointment() {
        bookButtons.click();
    }

    public void setVisitDate(String req) {

        DateParser parser = new DateParser();

        datePickerInput.setValue(parser.getDate(req));
    }
}
