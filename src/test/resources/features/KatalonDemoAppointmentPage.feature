Feature: Create an appointment

  Background:
    Given user opened "Login" page
    And user logged with Login "John Doe" and Password "ThisIsNotAPassword"
    And user should be redirected to "Appointment" page

  Scenario: 1.1 Redirect to Confirmation page
    When user selects "Seoul CURA Healthcare Center" from Facility dropdown
    And user selects "Medicaid" radiobutton
    And user selected a visit date - "current date + 1 day"
    And user clicks Book button
    Then user should be redirected to "AppointmentConfirmation" page
    And text "Please be informed that your appointment has been booked as following:" should be visible

  Scenario: 1.2 Confirmation page contains appropriate data
    When user selects "Seoul CURA Healthcare Center" from Facility dropdown
    And user selects "Medicaid" radiobutton
    And user selected a visit date - "current date + 1 month"
    And user clicks Book button
    Then user should be redirected to "AppointmentConfirmation" page
    And appointment detail should be equal to the following data:
      | Facility                     | Program  | Date                   | Comment | Readmission |
      | Seoul CURA Healthcare Center | Medicaid | current date + 1 month |         | No          |

  Scenario: 1.2 Visit date field is mandatory
    When user selects "Seoul CURA Healthcare Center" from Facility dropdown
    And user selects "Medicaid" radiobutton
    And user clicks Book button
    Then user should stay on "Appointment" page
