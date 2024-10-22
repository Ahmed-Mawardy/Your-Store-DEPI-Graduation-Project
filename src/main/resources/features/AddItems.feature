Feature: Add Items and Checkout Functionality
     # Scenario 1
    # TC_9,14 (Add Items To Wishlist then delete them)
  Scenario: Add Items To Wishlist then delete them
    Given user login
    When user adds items to wishlist
    And user should be able to see items in wishlist
    And user should be able to delete items from wishlist
    Then virify that items are deleted from wishlist

    # Scenario 2
    #TC10,15(Add Items To Compare List then delete them )
  Scenario: Add Items To Compare List then delete them
    Given user login
    When user adds items to compare list
    And user should be able to see items in compare list
    And user should be able to delete items from compare list
    Then virify that items are deleted from compare list

    # Scenario 3
  #TC11,16(Add Items To the shopping cart then delete them )
  Scenario: Add Items To the shopping cart then delete them
    Given user login
    When user adds items to shipping cart
    And user should be able to see items in shipping cart
    And user should be able to delete items from shipping cart
    Then virify that items are deleted from shipping cart

    # Scenario 4
  Scenario:Verify that the cart icon updates with the item count
    Given user login
    When user adds items to shipping cart
    And user should be able to see items in shipping cart
    And User updates the quantity count
     Then virify that the cart icon updates with the item count

    # Scenario 5
  Scenario:Verify that the cart is emptied after the order is placed
    Given user login
    When user adds items to shipping cart
    And user clicks on checkout button
   # And user fill out the Billing Details form (# we need this step for the firs time order)
    And user clicks on continue button for second time order
    Then the cart should be emptied

    # Scenario 6
  Scenario:Test the "Continue Shopping" button in the cart
    Given user login
    When user clicks on shopping cart button
    And user clicks on continue shopping button
    Then user should be navigated to home page








