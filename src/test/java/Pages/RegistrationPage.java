package Pages;

import StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RegistrationPage {

    // (web driver instance)
    public WebDriver driver;
    WebDriverWait wait;
    HomePage homepage;

    // (Constructor)
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        // Initialize elements with FindBy annotations
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homepage = new HomePage(Hooks.driver);

    }

    // Locators for registration page
    @FindBy(id = "input-firstname")
    private WebElement firstName;

    @FindBy(id = "input-lastname")
    private WebElement lastName;

    @FindBy(id = "input-email")
    private WebElement email;

    @FindBy(id = "input-telephone")
    private WebElement Telephone;


    @FindBy(id = "input-password")
    private WebElement password;

    @FindBy(id = "input-confirm")
    private WebElement passwordConfirm;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement termsCheckbox;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
    private WebElement submitButton;


    // (Methods)
    // Enter Credentials
    public void EnterCredentials_Registration(String fname, String lname, String emailAddr
            , String phone, String pwd, String pwdConfirm) {
        firstName.clear();
        firstName.sendKeys(fname);
        lastName.clear();
        lastName.sendKeys(lname);
        email.clear();
        email.sendKeys(emailAddr);
        Telephone.clear();
        Telephone.sendKeys(phone);
        password.clear();
        password.sendKeys(pwd);
        passwordConfirm.clear();
        passwordConfirm.sendKeys(pwdConfirm);
    }

    public void enterLastName(String lname) {
        lastName.sendKeys(lname);
    }

    public void enterEmail(String emailAddr) {
        email.sendKeys(emailAddr);
    }

    public void enterTelephone(String phone) {
        Telephone.sendKeys(phone);
    }
//
//    public void enterPassword(String pwd, String pwdConfirm) {
//        password.clear();
//        password.sendKeys(pwd);
//        passwordConfirm.clear();
//        passwordConfirm.sendKeys(pwdConfirm);
//    }

//    public void passwordConfirm (String pwdConfirm) {
//        passwordConf.sendKeys(pwdConfirm);
//    }

    public void acceptTerms() {
        termsCheckbox.click();
    }

    public void submit() {
        submitButton.click();
    }

    public void NavigateToRegistrationPage() {
        homepage.navigateToHomePage();
        homepage.click_MyAccount();
        homepage.click_Register();
    }

    public void UserShouldSeeAppropriateErrorMessage() {
       String errorMessage = "Warning: E-Mail Address is already registered!";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"account-register\"]/div[1]")));
        String actualError = driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).getText();
        Assert.assertEquals(actualError, errorMessage);
    }
}