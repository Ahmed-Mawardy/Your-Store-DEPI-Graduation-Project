@RegressionTest
Feature: Home Page features functionality
  # Scenario 1
  # TC_5 (Logged users could switch between currencies(US-Euro))
  Scenario:Logged users could switch between currencies(US-Euro)
    Given user navigates to home page
    When user selects dollar currency
    And user selects euro currency
    Then currency should be changed