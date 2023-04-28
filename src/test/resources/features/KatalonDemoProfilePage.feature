Feature: Create an appointment feature file
  Background:
    Given user opened "Login" page
    And user logged with Login "John Doe" and Password "ThisIsNotAPassword"
    And user should be redirected to "Appointment" page

    Scenario: Check profile page
      When user opens "Profile" page
      Then text "Under construction." should be visible