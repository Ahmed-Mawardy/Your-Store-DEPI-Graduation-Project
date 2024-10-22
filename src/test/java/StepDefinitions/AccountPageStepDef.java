package StepDefinitions;




import Pages.AccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AccountPageStepDef {
    AccountPage accountPage;

    public AccountPageStepDef() {
        accountPage = new AccountPage(Hooks.driver);
    }

    // change password methods
//    @When("user changes password and clicks continue")
//    public void UserChangePasswordAndClickContinue() {
//
//        accountPage.clickChangePasswordButton();
//        accountPage.EnterNewPassword("0502178090A");
//        accountPage.EnterConfirmPassword("0502178090A");
//        accountPage.clickContinueButton();
//    }

//    @Then("Password should be changed successfully")
//    public void passwordShouldBeChangedSuccessfully() {
//        accountPage.PasswordChangedSuccessfully();
//
//    }



    @Then("Password should be changed successfully")

    public void passwordShouldBeChangedSuccessfully() {
        accountPage.PasswordChangedSuccessfully();

    }

    @When("user changes password and clicks continu")
    public void userChangesPasswordAndClicksContinu() {
        accountPage.clickChangePasswordButton();
        accountPage.EnterNewPassword("0502178090A");
        accountPage.EnterConfirmPassword("0502178090A");
        accountPage.clickContinueButton();

    }

    @When("user changes password and clicks continue")
    public void userChangesPasswordAndClicksContinue() {

    }

    // Edit Account information methods

    @When("user changes account information with existing Email")
    public void userChangesAccountInformationWithExistingEmail() {
        accountPage.editAccountInformation();

    }

    @Then("Ensure that appropriate error message is displayed")
    public void ensureThatAppropriateErrorMessageIsDisplayed() {
        accountPage.UserShouldSeesAnErrorMessage();

    }
    // return item methods
    @When("user navigates to account page and clicks on return")
    public void userNavigatesToAccountPageAndClicksOnReturn() {

        accountPage.clickReturnProductsButton();

    }

    @And("User clicks view items and continue")
    public void userClicksViewItemsAndContinue() {
        accountPage.clickViewButton();
    }

    @Then("User should see items in product returns")
    public void userShouldSeeItemsInProductReturns() {

        accountPage.userSeesProductReturns();
    }
}


