package StepDefinitions;

import Pages.AddItemsAndCheckout;
import Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

import static StepDefinitions.Hooks.driver;

public class AddItemsAndCheckoutStepDef {
    AddItemsAndCheckout addItemsAndCheckout;
    HomePage homePage;

    public AddItemsAndCheckoutStepDef() {
        addItemsAndCheckout = new AddItemsAndCheckout(Hooks.driver);
        homePage = new HomePage(Hooks.driver);
    }
    // TC_9,14  Methods to add items to wish list then delete them
    @When("user adds items to wishlist")
    public void user_adds_items_to_wishlist() {
        addItemsAndCheckout.clickMobileCategory();
        addItemsAndCheckout.clickMobile1();
     // addItemsAndCheckout.clickMobile2();
        addItemsAndCheckout.clickWishListButton();
    }

    @And("user should be able to see items in wishlist")
    public void userShouldBeAbleToSeeItemsInWishlist() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr[1]/td[2]/a")).isDisplayed());
       //Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr[2]/td[2]/a")).isDisplayed());

    }

    @And("user should be able to delete items from wishlist")
    public void userShouldBeAbleToDeleteItemsFromWishlist() {
        addItemsAndCheckout.deleteItemsFromWishList();


    }

    @Then("virify that items are deleted from wishlist")
    public void virifyThatItemsAreDeletedFromWishlist() {
        addItemsAndCheckout.verifyThatItemsAreDeletedFromWishList();

    }
    //TC10,15(Add Items To Compare List then delete them )
    @When("user adds items to compare list")
    public void userAddsItemsToCompareList() {
        addItemsAndCheckout.addItemsToCompareList();

    }

    @And("user should be able to see items in compare list")
    public void userShouldBeAbleToSeeItemsInCompareList() {
        addItemsAndCheckout.userShouldBeAbleToSeeItemsInCompareList();
        
    }

    @And("user should be able to delete items from compare list")
    public void userShouldBeAbleToDeleteItemsFromCompareList() {
        addItemsAndCheckout.deleteItemsFromCompareList();
        
    }

    @Then("virify that items are deleted from compare list")
    public void virifyThatItemsAreDeletedFromCompareList() {
        addItemsAndCheckout.verifyThatItemsAreDeletedFromCompareList();
    }
    // TC11,16(Add Items To the shopping cart then delete them )
//    @When("user adds items to shipping cart")
//    public void UserAddsItemsToShippingCart() {
//       // addItemsAndCheckout.addItemsToShoppingCart();
//
//    }

    @And("user should be able to see items in shipping cart")
    public void userShouldBeAbleToSeeItemsInShippingCart() {
        addItemsAndCheckout.userShouldBeAbleToSeeItemsInShoppingCart();
        
    }

    @And("user should be able to delete items from shipping cart")
    public void userShouldBeAbleToDeleteItemsFromShippingCart() {
        addItemsAndCheckout.deleteItemsFromShoppingCart();
        
    }

    @Then("virify that items are deleted from shipping cart")
    public void virifyThatItemsAreDeletedFromShippingCart() {
        addItemsAndCheckout.verifyThatItemsAreDeletedFromShoppingCart();
    }

    @And("User updates the quantity count")
    public void userUpdatesTheQuantityCount() {
        addItemsAndCheckout.UserUpdateQuantity();

    }

    @Then("the cart should be emptied")
    public void theCartShouldBeEmptied() {
        addItemsAndCheckout.verifyTheCartIsEmpty();

    }

    @And("user clicks on continue shopping button")
    public void userClicksOnContinueShoppingButton() {

        addItemsAndCheckout.clickContinueShoppingButton();
    }

    @Then("user should be navigated to home page")
    public void userShouldBeNavigatedToHomePage() {


    }

    @When("user clicks on shopping cart button")
    public void userClicksOnShoppingCartButton() {

        addItemsAndCheckout.clickShoppingCartButton();
    }

    @Then("virify that the cart icon updates with the item count")
    public void virifyThatTheCartIconUpdatesWithTheItemCount() {
        addItemsAndCheckout.verifyQuantity();


    }

//    @And("User clicks on checkout button")
//    public void userClicksOnCheckoutButton() {
//        addItemsAndCheckout.clickCheckoutButton();
//
//
//
//
//    }

//    @And("User clicks on shopping cart button")
//    public void userClicksOnShoppingCartButton() {
//
//        addItemsAndCheckout.clickShoppingCartButton();
//
//    }
}



