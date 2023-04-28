Feature: Login feature file

  Scenario: 1.1 Login with valid login and password
    Given user opened "Login" page
    When user enters user name "John Doe"
    And user enters password "ThisIsNotAPassword"
    And user clicks Login button
    Then user should be redirected to "Appointment" page

  Scenario: 1.2 Login with wrong password
    Given user opened "Login" page
    When user enters user name "John Doe"
    And user enters password "WrongPassword"
    And user clicks Login button
    Then user should stay on "Login" page
    And login error message is displayed

  Scenario: 1.3 Login with wrong user name
    Given user opened "Login" page
    When user enters user name "WrongName"
    And user enters password "ThisIsNotAPassword"
    And user clicks Login button
    Then user should stay on "Login" page
    And login error message is displayed