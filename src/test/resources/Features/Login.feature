Feature: Login tests with account creation
  As Customer, First create the user and login it

  Background: Home page of magento.softwaretestingboard.com
    Given Open the URL

  Scenario: Create Account with dynamic email id
    Given Open the create account page
    When Fill all required details for account creation
    And Click on the Create Account button
    Then Validate user successfully inside his account

  Scenario: Login successfully in the account
    When Click on header Sign-In button
    And Fill user created username and password
    And Click on Sign-In button
    Then Validate user successfully inside his account
    And Close Window
