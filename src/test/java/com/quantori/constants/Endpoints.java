package com.quantori.constants;

public enum Endpoints {

    Login("profile.php#login"),
    Appointment("#appointment");

    private String urlPage;

    Endpoints(String urlPage) {
        this.urlPage = urlPage;
    }

    public String getUrlPage() {
        return urlPage;
    }
}
