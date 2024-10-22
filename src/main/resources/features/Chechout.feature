Feature: checkout functionality
  # Scenario 1
  # This second time to create an order
  Scenario: Create an order with a successful payment (happy scenario)
    Given user login
    When user adds items to shipping cart
   And user clicks on checkout button
   # And user fill out the Billing Details form (# we need this step for the first time order)
  And user clicks on continue button for second time order
   Then order should be created successfully

  # Scenario 2
  Scenario:Test cart functionality with guest users
    Given user navigates to home page
    When user adds items to shipping cart
    And user clicks on checkout button
    And user select Guest Checkout and continue




