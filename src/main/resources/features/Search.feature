Feature: Logged users could search for any product
  @RegressionTest
    # scenario 1
  #TC_4 (Logged users could search for any product)
  Scenario: User search for (existing) product
    Given  user login
    When user enters Item in search text
    And User clicks on search button
    Then product should be displayed in search results

   # scenario 2
    #TC_13 (Logged users could search for non-existing product)
  Scenario: User search for non-existing product
    Given  user login
    When user enters non-existing Item in search text
    And User clicks on search button
    Then Ensure the message (No items match the search criteria) is displayed

     # scenario 3
  Scenario:Verify that empty search fields provide a proper message
    Given  user login
    When user enters empty search text
    And User clicks on search button
    Then Ensure that appropriate message is displayed







