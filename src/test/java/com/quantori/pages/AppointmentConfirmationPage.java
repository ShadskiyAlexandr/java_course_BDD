package com.quantori.pages;

import com.codeborne.selenide.SelenideElement;
import com.google.common.base.Strings;
import com.quantori.dto.AppointmentCard;
import com.quantori.helpers.DateParser;

import static com.codeborne.selenide.Selenide.$;

public class AppointmentConfirmationPage {

    private SelenideElement facilityValue = $("#facility");
    private SelenideElement readmissionValue = $("#hospital_readmission");
    private SelenideElement programValue = $("#program");
    private SelenideElement visitDateValue = $("#visit_date");
    private SelenideElement commentValue = $("#comment");
    private SelenideElement goToHomeButton = $("[class='btn btn-default']");
    public AppointmentCard buildCard() {
        DateParser parser = new DateParser();

        return AppointmentCard.builder()
                .visitDate(Strings.emptyToNull(visitDateValue.getText()))
                .facility(Strings.emptyToNull(facilityValue.getText()))
                .hospitalReadmission(Strings.emptyToNull(readmissionValue.getText()))
                .healthcareProgram(Strings.emptyToNull(programValue.getText()))
                .comment(Strings.emptyToNull(commentValue.getText()))
                .build();
    }
}
