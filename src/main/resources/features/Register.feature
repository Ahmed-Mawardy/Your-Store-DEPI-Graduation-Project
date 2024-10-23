@RegressionTest
Feature: test Registration Functionality

  # test scenario 1
  Scenario: Test registration with a pre-existing email or username.

    Given user open browser and navigates to register page
    When User enters valid details
    And User accepts terms and conditions
    And User submits the registration form
    Then User should see an appropriate error message

  # test scenario 2
  Scenario Outline: User register with invalid credentials

    Given user open browser and navigates to register page
    When User enters invalid details <first Name> and <last Name> and <Email> and <Phone> and <Password> and <Confirm Password>
    And User accepts terms and conditions
    And User submits the registration form
    Then User should see an error message
    Examples:
    | first Name | last Name | Email | Phone | Password | Confirm Password |
    | "h4zala1234" | "inva434lid" | "h4zala1234gmail" | "0502176585" | "inva434lid" | "inva434lid" |

    # test scenario 3 (new user registration)
  Scenario: User register with valid credentials

      Given user open browser and navigates to register page
      When User enters valid Registration details
      And User accepts terms and conditions
      And User submits the registration form
      Then User should see a success message



