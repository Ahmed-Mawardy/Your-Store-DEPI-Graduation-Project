@RegressionTest
Feature: test Login Functionality
  # Scenario 1
  # TC_1 Scenario_1 User logs in with valid credentials
  Scenario: User logs in with valid credentials

    Given user navigates to login page
    When User enters a valid email and password
    And User clicks on login button
    Then User should be logged in successfully

  # Scenario 2
  # TC_1 Scenario_2 User logs in with invalid credentials
  Scenario Outline: User logs in with invalid credentials
    Given user navigates to login page
    When User enters an invalid email and password "<User Name>" and "<Password>"
    And User clicks on login button
    Then User should see an error Message
    Examples:
    | User Name | Password |
    |h4zala1234 | inva434lid|
    | 1234 | inva434lid|
    |@44@GG.COM | 222#|



    # Scenario 3
    #Tc_3 forgot password scenario
    Scenario: User forgot password
      Given user navigates to login page
      When User clicks on forgot password
     And User should be navigated to forgot password page
      And User enters a valid email
      And User clicks on continue button
      Then User should see a confirmation message

    # Scenario 4
    Scenario:Test the "Logout" functionality
      Given user login with valid credentials
      When user clicks on logout button
      Then user should be logged out




