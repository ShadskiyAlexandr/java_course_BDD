Feature: Create an appointment feature file

  Background:
    Given user opened "Login" page
    And user logged with Login "John Doe" and Password "ThisIsNotAPassword"
    And user should be redirected to "Appointment" page

  Scenario: 1.1 Create an appointment
    When user selects "Seoul CURA Healthcare Center" from Facility dropdown
    And user selects "Medicaid" radiobutton
    And user selected a visit date - "current date + 1 day"
    And user clicks Book button
    Then user should be redirected to "AppointmentConfirmation" page
