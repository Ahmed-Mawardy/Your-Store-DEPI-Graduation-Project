@RegressionTest
Feature: Verify Categories Functionality

    # Scenario 1
    # TC_6 (Select Main and Sub Categories Randomly )
    Scenario: Select Main and Sub Categories Randomly
        Given user login with valid credentials
        When user navigates to home page
        And user selects random main category
        And user selects random subcategory
        Then user should navigate to subcategory page

    # Scenario 2
    # TC_7 (Hover Main and Sub Categories Randomly)
    Scenario: Hover Main and Sub Categories Randomly
        Given user login with valid credentials
        When user navigates to home page
        And user hovers on random main category
        And user hovers on random subcategory
        Then The hover actions should be successful

