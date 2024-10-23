package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import Pages.RegistrationPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static StepDefinitions.Hooks.driver;

public class RegistrationStepDefinitions {


    LoginPage loginPage;
    HomePage homePage;
    RegistrationPage registrationPage;
    WebDriverWait wait;


    public RegistrationStepDefinitions() {

        registrationPage = new RegistrationPage(Hooks.driver);
        loginPage = new LoginPage(Hooks.driver);
        homePage = new HomePage(Hooks.driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Registration Methods
    @Given("user open browser and navigates to register page")
    public void user_is_on_registration_page() {
        registrationPage.NavigateToRegistrationPage();


    }


    @And("User accepts terms and conditions")
    public void user_accepts_terms() {
        registrationPage.acceptTerms();
    }

    @And("User submits the registration form")
    public void user_submits_registration_form() {
        registrationPage.submit();
    }

    @Then("User should see the registration success message")
    public void user_should_see_success_message() {
        boolean isDisplayed = driver.findElement(By.xpath("//div[contains(text(),'Your Account Has Been Created!')]")).isDisplayed();
        assert isDisplayed : "Registration was not successful!";
    }

    // User enters a pre-existing email or username.
    @When("User enters valid details")
    public void userEntersValidDetails() {
        registrationPage.EnterCredentials_Registration("Ahmed", "Mawardy", "ahmedmawrdy20@gmail.com", "sqCdD5Tj@8CE6i5", "sqCdD5Tj@8CE6i5", "+201006799386");

    }

    // User enters valid details
    @When("User enters valid Registration details")
    public void userEntersValidRegistrationDetails() {
        registrationPage.EnterCredentials_Registration("Ahmed322", "Mawardy322", "ahmedmawrdy20322@gmail.com", "+201006799386", "sqCdD5Tj@8C2E6i52", "sqCdD5Tj@8C2E6i52");
    }

    // User enters invalid details
    @When("User enters invalid details {string} and {string} and {string} and {string} and {string} and {string}")
    public void userEntersInvalidDetails(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {
        registrationPage.EnterCredentials_Registration(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    @Then("User should see a success message")
    public void userShouldSeeASuccessMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/h1")));
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
        String expectedMessage = "Your Account Has Been Created!";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Then("User should see an error message")
    public void user_should_see_error_message() {
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://awesomeqa.com/ui/index.php?route=account/register");
    }

    // User register with a pre-existing email or username.
    @Then("User should see an appropriate error message")
    public void userShouldSeeAnAppropriateErrorMessage() {
        registrationPage.UserShouldSeeAppropriateErrorMessage();

    }


}