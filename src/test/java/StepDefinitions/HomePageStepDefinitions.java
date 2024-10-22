package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepDefinitions {
    //public  WebDriver driver;
    // Initialize (pages)
    LoginPage loginPage;
    HomePage homePage;
    RegistrationPage registrationPage;

    public HomePageStepDefinitions() {
        loginPage = new LoginPage(Hooks.driver);
        homePage = new HomePage(Hooks.driver);
        registrationPage = new RegistrationPage(Hooks.driver);
    }



    @When("user navigates to home page")
    public void userNavigatesToHomePage() {
        homePage.navigate("https://awesomeqa.com/ui/index.php?route=common/home");

    }

    @When("user selects dollar currency")
    public void userSelectsCurrency() {
        homePage.clickCurrencies();
        homePage.clickDollar();
    }

    @And("user selects euro currency")
    public void selectEuroCurrency() {
        homePage.clickCurrencies();
        homePage.clickEuro();
    }


    @Then("currency should be changed")
    public void currencyShouldBeChangedToEuro() {
        homePage.currencyShouldBeChangedtoEuro();
    }
}
