@Register
Feature: Register functionality

  @userCanRegister
  Scenario: User can create an account
    Given user navigates to 'http://automationpractice.com/index.php' page
    And user is on the 'Home' page
    When user clicks to 'Login' button
    And user is on the 'Authentication' page
    And user types new email into 'Email Address' field
    When user clicks to 'Create an Account' button
    Then user is on the 'Account Creation' page
    And user selects the Mr. 'Gender'
    And user types first name into 'Customer First Name' field
    And user types last name into 'Customer Last Name' field
    And email is displayed into 'Email' field
    And user types new password into 'Password' field
    And user select the 'Days', 'Months' and 'Years'
    And user types a first name for address into 'First Name' field
    And user types a last name for address into 'Last Name' field
    And user types an address into 'Address' field
    And user types a city into 'City' field
    And user selects a state into the 'State' field
    And user types a postal code into 'Post Code' field
    And user types a phone number into 'Phone Mobile' field
    When user clicks to 'Register' button
    Then user is on the 'My Account' page





