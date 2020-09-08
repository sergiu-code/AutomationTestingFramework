@LogIn
Feature: LogIn functionality

  @userCanLogIn
  Scenario: User can login with an existing email and password
    Given user navigates to 'http://automationpractice.com/index.php' page
    And user is on the 'Authentication' page
    When user clicks to 'Login' button
    And user is on the 'Authentication' page
    And 'Login Form' is displayed
    And user types a registered email into 'Email' field
    And user types a registered password into 'Password' field
    When user clicks to 'Sign in' button
    Then user is on the 'My Account' page
    And 'Full Name' of user is displayed
