package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ChechoutPage {
    public WebDriver driver;
    WebDriverWait wait;

    public ChechoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // locators for Chechout Page
    By Checkout_Button = By.xpath("//*[@id=\"top-links\"]/ul/li[5]/a/span");
    By firstNameField = By.id("input-payment-firstname");
    By lastNameField = By.id("input-payment-lastname");
    By company = By.id("input-payment-company");
    By Address1 = By.id("input-payment-address-1");
    By Address2 = By.id("input-payment-address-2");
    By cityField = By.id("input-payment-city");
    By postcodeField = By.id("input-payment-postcode");
    By continueButton = By.xpath("//*[@id=\"button-payment-address\"]");
    // Locator for country dropdown in billing details
    @FindBy(id = "input-payment-country")
    WebElement countryDropdown;

    // Locator for region/state dropdown in billing details
    @FindBy(id = "input-payment-zone")
    WebElement regionDropdown;

    By BillingDetailsContinueButton = By.id("button-payment-address"); // locators for Billing Details continue button
    By DeliveryDetailsContinueButton = By.id("button-shipping-address"); // locators for Delivery Details continue button
    By DeliveryMethodContinueButton = By.id("button-shipping-method"); // locators for Delivery Method continue button
    By PaymentMethodCheckBox = By.xpath("//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]"); // locators for Payment Method checkbox
    By PaymentMethodContinueButton = By.id("button-payment-method"); // locators for Payment Method continue button
    By ConfirmOrderButton = By.xpath("//*[@id=\"button-confirm\"]"); // locators for Confirm Order

    // methods for creating an order
    public void Click_Checkout_Button() {
        driver.findElement(Checkout_Button).click();
    }

    // fill billing details
    public void fillBillingDetails(String firstName, String lastName, String comp, String address1, String address2, String city, String postcode, String country, int region) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).clear();
        driver.findElement(firstNameField).sendKeys(firstName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).clear();
        driver.findElement(lastNameField).sendKeys(lastName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(company)).clear();
        driver.findElement(company).sendKeys(comp);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Address1)).clear();
        driver.findElement(Address1).sendKeys(address1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Address2)).clear();
        driver.findElement(Address2).sendKeys(address2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cityField)).clear();
        driver.findElement(cityField).sendKeys(city);
        wait.until(ExpectedConditions.visibilityOfElementLocated(postcodeField)).clear();
        driver.findElement(postcodeField).sendKeys(postcode);
        wait.until(ExpectedConditions.visibilityOf(countryDropdown));
        selectCountry(country);
        wait.until(ExpectedConditions.visibilityOf(regionDropdown));
        selectRegion(region);
    }

    // Method to select country from dropdown
    public void selectCountry(String countryName) {
        // Use Selenium's Select class to select country from dropdown
        wait.until(ExpectedConditions.elementToBeClickable(countryDropdown));
        new org.openqa.selenium.support.ui.Select(countryDropdown).selectByVisibleText(countryName);
    }

    // Method to select region/state from dropdown
    public void selectRegion(int index) {
        // Use Selenium's Select class to select region/state from dropdown
        wait.until(ExpectedConditions.elementToBeClickable(regionDropdown));
        regionDropdown.click();
        new org.openqa.selenium.support.ui.Select(regionDropdown).selectByIndex(index);
    }

    // click on continue button for second time order
    public void clickContinueforSecondTimeOreder() {
        wait.until(ExpectedConditions.elementToBeClickable(BillingDetailsContinueButton));
        driver.findElement(BillingDetailsContinueButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(DeliveryDetailsContinueButton));
        driver.findElement(DeliveryDetailsContinueButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(DeliveryMethodContinueButton));
        driver.findElement(DeliveryMethodContinueButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(PaymentMethodCheckBox));
        driver.findElement(PaymentMethodCheckBox).click();
        wait.until(ExpectedConditions.elementToBeClickable(PaymentMethodContinueButton));
        driver.findElement(PaymentMethodContinueButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(ConfirmOrderButton));
        driver.findElement(ConfirmOrderButton).click();


    }

    public void EnsureSuccessfulOrderAndPaymentProcessing() {
        // Wait for the success message to be visible first
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Your order has been placed!']")));
        String actualMessage = driver.findElement(By.xpath("//h1[normalize-space()='Your order has been placed!']")).getText();
        String expectedMessage = "Your order has been placed!";
        Assert.assertEquals(actualMessage, expectedMessage, "The success message is incorrect or not displayed.");
    }

    public void SelectGuestCheckoutAndContinue  () {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"collapse-checkout-option\"]/div/div/div[1]/div[1]/label/input")));
        driver.findElement(By.xpath("//*[@id=\"collapse-checkout-option\"]/div/div/div[1]/div[1]/label/input")).click();
        driver.findElement(By.xpath("//*[@id=\"button-account\"]")).click();
    }
}