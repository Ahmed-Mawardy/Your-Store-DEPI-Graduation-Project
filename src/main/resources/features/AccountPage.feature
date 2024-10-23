@RegressionTest
Feature: Account page functionality

    # Scenario 1
    # TC_1 (Logged users could change their password)
  Scenario: Logged user could change his password
    Given user login with valid credentials
    When user changes password and clicks continue
    Then Password should be changed successfully

      # Scenario 2
  Scenario: change his account information with existing Email
    Given user login with valid credentials
    When user changes account information with existing Email
    Then Ensure that appropriate error message is displayed

    # Scenario 3
  Scenario: verify that the user could Sees items in Product Returns
    Given user login with valid credentials
    When user navigates to account page and clicks on return
    And User clicks view items and continue
   Then User should see items in product returns


