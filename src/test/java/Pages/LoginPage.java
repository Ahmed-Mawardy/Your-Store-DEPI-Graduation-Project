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



public class LoginPage {
    public WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    //  Locators (WebElement)
    //  login page
    @FindBy(id = "input-email")
    WebElement emailField;

    @FindBy(id = "input-password")
     WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
    WebElement MyAccountButton;

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement LogoutButton;


    // forget password page
    By forgetPassword = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/div[2]/a");
    By EmailAddressBox = By.id("input-email"); // Email Address
    By ContinueButton = By.className("btn-primary");




    public void EnterUsernameAndPassword(String usernameValue, String passwordValue) {

        emailField.clear();
        emailField.sendKeys(usernameValue);
        passwordField.clear();
        passwordField.sendKeys(passwordValue);

    }
    public void EnterUsername(String usernameValue) {
        emailField.clear();
        emailField.sendKeys(usernameValue);
    }
    public void EnterPassword(String passwordValue) {
        passwordField.clear();
        passwordField.sendKeys(passwordValue);

    }
    public void clickLogin() {
        loginButton.click();
    }

    public void UserShouldSeesAnErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"account-login\"]/div[1]")));
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText();
        String expectedMessage = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(actualMessage, expectedMessage, "Error message mismatch");

    }



    // forget password methods
    public void clickForgetPassword() {
        driver.findElement(forgetPassword).click();

    }

    public void enterEmail(String emailAddr) {
        driver.findElement(EmailAddressBox).sendKeys(emailAddr);
    }
    public void clickContinue() {
        driver.findElement(ContinueButton).click();
    }
    public void UserShouldSeesAConfirmationMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success alert-dismissible']")));
        String actualMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
        String expectedMessage = "An email with a confirmation link has been sent your email address.";
        Assert.assertEquals(actualMessage, expectedMessage, "Error message mismatch");
    }


    public void UserShouldSeesLoggedOutMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/h1")));
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
        String expectedMessage = "Account Logout";
        Assert.assertEquals(actualMessage, expectedMessage, "Error message mismatch");
    }

    public void clickLogout() {
        wait.until(ExpectedConditions.visibilityOf(MyAccountButton));
        MyAccountButton.click();
        LogoutButton.click();

    }
}