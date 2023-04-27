Feature: 1 Login feature

  Scenario: 1.1 Login with valid login and password
    Given user opened "Login" page
    When user enters user name "John Doe"
    And user enters password "ThisIsNotAPassword"
    And user clicks button

  Scenario: 1.2 Login with wrong password
    Given user opened "Login" page
    When user enters user name "John Doe"
    And user enters password "WrongPassword"
    And user clicks button

  Scenario: 1.3 Login with wrong user name
    Given user opened "Login" page
    When user enters user name "WrongName"
    And user enters password "ThisIsNotAPassword"
    And user clicks button