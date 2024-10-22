package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class SearchStepDefinitions {
    public WebDriver driver;
    // Initialize (pages)
    LoginPage loginPage;
    HomePage homePage;
    RegistrationPage registrationPage;
    WebDriverWait wait;

    String productName = "iMac";





    // Initialize (hooks)
    public SearchStepDefinitions() {
        loginPage = new LoginPage(Hooks.driver);
        homePage = new HomePage(Hooks.driver);
        registrationPage = new RegistrationPage(Hooks.driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }
    @When("user enters Item in search text")
    public void userEntersSearchText() {
        homePage.click_SearchBox();

        homePage.enterSearchText("iMac");
    }


    @And("User clicks on search button")
    public void userClicksOnSearchButton() {
        homePage.clickSearchButton();
    }

    @Then("product should be displayed in search results")
    public void productShouldBeDisplayedInSearchResults() {
//        WebElement product = driver.findElement(By.xpath("//a[normalize-space()='iMac']"));
//      String actualMessage = driver.findElement(By.xpath("//a[normalize-space()='iMac']")).getText();
//      String expectedMessage = "iMac";
//      Assert.assertEquals(actualMessage, expectedMessage, "Error message mismatch");

//        String ExpectedLinkText = "https://awesomeqa.com/ui/index.php?route=product/search&search=iMac";
//
//        String actualLinkText = driver.getCurrentUrl();
//        Assert.assertEquals(actualLinkText, ExpectedLinkText, "Error message mismatch");
    homePage.getFirstProductTitle();
    homePage.verifyProductAppearsCorrectlyAfterSearch();




    }

    @When("user enters non-existing Item in search text")
    public void userEntersNonExistingItemInSearchText() {
        homePage.click_SearchBox();
        homePage.enterSearchText("iphone x max");

    }


    @Then("Ensure the message \\(No items match the search criteria) is displayed")
    public void ensureTheMessageNoItemsMatchTheSearchCriteriaIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div:nth-child(5) > div:nth-child(2) > div:nth-child(1) > p:nth-child(7)")));
        String actualMessage = driver.findElement(By.cssSelector("body > div:nth-child(5) > div:nth-child(2) > div:nth-child(1) > p:nth-child(7)")).getText();
        String expectedMessage = "There is no product that matches the search criteria.";
        Assert.assertEquals(actualMessage, expectedMessage, "Error message mismatch.");
    }

    @When("user enters empty search text")
    public void userEntersEmptySearchText() {
        homePage.click_SearchBox();
        homePage.clickSearchButton();
    }

    @Then("Ensure that appropriate message is displayed")
    public void ensureThatAppropriateMessageIsDisplayed() {

    }
}
