package StepDefinitions;

import Pages.Categories;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static StepDefinitions.Hooks.driver;
import static org.testng.Assert.assertTrue;


public class CategoriesStepDefinitions {


    LoginPage loginPage;
    HomePage homePage;
    RegistrationPage registrationPage;
    Categories categories;

    public CategoriesStepDefinitions() {
        loginPage = new LoginPage(Hooks.driver);
        homePage = new HomePage(Hooks.driver);
        registrationPage = new RegistrationPage(Hooks.driver);
        categories = new Categories(Hooks.driver);
    }
    // TC_6 (Select Main and Sub Categories Randomly )
    @And("user selects random main category")
    public void user_selects_random_main_category() {
        categories.selectRandomMainCategory();
    }
    @And("user selects random subcategory")
    public void user_selects_random_subcategory() {
        categories.selectRandomSubCategory();
    }
    @Then("user should navigate to subcategory page")
    public void user_should_navigate_to_subcategory_page() {
        // Verification logic to check if the user is on the subcategory page
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.contains("category") : "Navigation to subcategory page failed!";
    }


    @And("user hovers on random main category")
    public void userHoversOnRandomMainCategory() {
        categories.hoverRandomMainCategory();
    }

    @And("user hovers on random subcategory")
    public void userHoversOnRandomSubcategory() {
        categories.hoverRandomSubCategory();
    }

    @Then("The hover actions should be successful")
    public void theHoverActionsShouldBeSuccessful() {
        categories.verifyHoverActionsAreSuccessful();

    }

    @Then("The product grid should be displayed")
    public void theProductGridShouldBeDisplayed() {
        assertTrue(categories.isProductGridDisplayed(), "Product grid is displayed");

    }
}

