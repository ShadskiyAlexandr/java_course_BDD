Feature: History page

  Background:
    Given user opened "Login" page
    And user logged with Login "John Doe" and Password "ThisIsNotAPassword"
    And user should be redirected to "Appointment" page
    And user selected "Seoul CURA Healthcare Center" from Facility dropdown
    And user selected "Medicaid" radiobutton
    And user selected a visit date - "current date + 1 day"
    And user clicked Book button
    And user should be redirected to "AppointmentConfirmation" page

  Scenario: Check data in the history
    When user opens "History" page
    Then history card should be with following data:
      | Facility                     | Program  | Date                 | Comment | Readmission |
      | Seoul CURA Healthcare Center | Medicaid | current date + 1 day |         | No          |