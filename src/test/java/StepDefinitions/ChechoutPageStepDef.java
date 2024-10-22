package StepDefinitions;

import Pages.AddItemsAndCheckout;
import Pages.ChechoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class ChechoutPageStepDef {

    ChechoutPage chechoutPage;
    AddItemsAndCheckout addItemsAndCheckout;

    public ChechoutPageStepDef() {
        chechoutPage = new ChechoutPage(Hooks.driver);
        addItemsAndCheckout = new AddItemsAndCheckout(Hooks.driver);
    }


    @And("user clicks on checkout button")
    public void userClicksOnCheckoutButton()   {
        chechoutPage.Click_Checkout_Button();
    }

    @And("user fill out the Billing Details form")
    public void userFillOutTheBillingDetailsForm()   {
        chechoutPage.fillBillingDetails("Ahmed", "Mawardy", "weq", "Al-Khayariyah Village"
                , "wqeee", "Mansoura", "35812", "Egypt", 4);

    }
    // click on continue button for second time order
    @And("user clicks on continue button for second time order")
    public void userClicksOnContinueButton() {
        chechoutPage.clickContinueforSecondTimeOreder();


    }

    @Then("order should be created successfully")
    public void orderShouldBeCreatedSuccessfully() {
        chechoutPage.EnsureSuccessfulOrderAndPaymentProcessing();
    }

    @When("user adds items to shipping cart")
    public void userAddsItemsToShippingCart() {

        addItemsAndCheckout.addItemsToShoppingCart();
    }


    @And("user select Guest Checkout and continue")
    public void userSelectGuestCheckoutAndContinue() {

        chechoutPage.SelectGuestCheckoutAndContinue();
    }
}