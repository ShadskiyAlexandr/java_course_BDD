package com.quantori.constants;

public enum Endpoints {

    Login("profile.php#login"),
    Appointment("#appointment"),
    AppointmentConfirmation("appointment.php#summary"),
    Profile("profile.php#profile"),
    History("history.php#history");

    private String urlPage;

    Endpoints(String urlPage) {
        this.urlPage = urlPage;
    }

    public String getUrlPage() {
        return urlPage;
    }
}
