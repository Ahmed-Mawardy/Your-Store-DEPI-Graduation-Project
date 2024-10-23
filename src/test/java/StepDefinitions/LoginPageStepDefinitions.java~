package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;



import static StepDefinitions.Hooks.driver;

public class LoginPageStepDefinitions {
   // public WebDriver driver;
   LoginPage loginPage;
    HomePage homePage;


    public LoginPageStepDefinitions() {
        this.loginPage = new LoginPage(Hooks.driver);
        this.homePage = new HomePage(Hooks.driver);
    }


    // login scenario methods
    @Given("user navigates to login page")
    public void navigateToLoginPage() {
      homePage.navigate("https://awesomeqa.com/ui/index.php?route=common/home");
        homePage.click_MyAccount();
        homePage.click_Login();
    }
    // login with valid credentials
    @When("User enters a valid email and password")
    public void user_enters_valid_email_And_password() {
        loginPage.EnterUsernameAndPassword("abdo20@gmail.com", "Hanzalah6585");
    }
    // login with invalid credentials
    @When("User enters an invalid email and password {string} and {string}")
    public void userEntersAnInvalidEmailAndPasswordAnd(String arg0, String arg1) {
        loginPage.EnterUsername(arg0);
        loginPage.EnterPassword(arg1);
    }



    @And("User clicks on login button")
    public void user_clicks_login_button() {
        loginPage.clickLogin();
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        String expectedUrl = "https://awesomeqa.com/ui/index.php?route=account/account";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Login was unsuccessful!");
    }

    @Then("User should see an error Message")
    public void user_should_see_an_error_message() {
    loginPage.UserShouldSeesAnErrorMessage();

    }

    // forgot password scenario methods
    @When("User clicks on forgot password")
    public void userClicksOnForgotPassword() {
        loginPage.clickForgetPassword();
    }

    @And("User should be navigated to forgot password page")
    public void userShouldBeNavigatedToForgotPasswordPage() {

    }

    @And("User enters a valid email")
    public void userEntersAValidEmail() {
        loginPage.enterEmail("hanzalah6585@gmail.com");
    }

    @And("User clicks on continue button")
    public void userClicksOnContinueButton() {
        loginPage.clickContinue();

    }

    @Then("User should see a confirmation message")
    public void userShouldSeeAConfirmationMessage() {

    }

    @Given("user login")
    public void userLogin() {
        navigateToLoginPage();
        user_enters_valid_email_And_password();
        user_clicks_login_button();
        user_should_be_logged_in_successfully();

    }

    @Then("user should be logged out")
    public void userShouldBeLoggedOut() {
        loginPage.UserShouldSeesLoggedOutMessage();
    }

    @When("user clicks on logout button")
    public void userClicksOnLogoutButton() {
        loginPage.clickLogout();

    }
}