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

public class AccountPage {
    public WebDriver driver;
    WebDriverWait wait;


    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }


    By changePasswordButton = By.xpath("/html/body/div[2]/div/aside/div/a[3]");
    @FindBy(xpath = "//*[@id=\"column-right\"]/div/a[10]")
    public WebElement returnProductsButton;
    @FindBy(xpath = "//*[@id=\"column-right\"]/div/a[2]")
    WebElement editAccountButton;


    //  Changing Password methods
    public void clickChangePasswordButton() {
        //changePasswordButton.click();
        driver.findElement(changePasswordButton).click();
    }

    public void EnterNewPassword(String password) {
        driver.findElement(By.id("input-password")).sendKeys(password);
    }

    public void EnterConfirmPassword(String password) {
        driver.findElement(By.id("input-confirm")).sendKeys(password);
    }

    public void clickContinueButton() {
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
    }

    public void PasswordChangedSuccessfully() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
        String actualMessage = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        String expectedMessage = "Success: You have modified your account information.";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    // Edit Account information methods
    public void editAccountInformation() {
        editAccountButton.click();
        driver.findElement(By.id("input-firstname")).clear(); // Clear the first name field
        driver.findElement(By.id("input-firstname")).sendKeys("Ahemed12");
        driver.findElement(By.id("input-lastname")).clear(); // Clear the last name field
        driver.findElement(By.id("input-lastname")).sendKeys("Tamer2");
        driver.findElement(By.id("input-email")).clear(); // Clear the email field
        driver.findElement(By.id("input-email")).sendKeys("ahmedmawardy20@gmail.com");
        driver.findElement(By.id("input-telephone")).clear(); // Clear the telephone field
        driver.findElement(By.id("input-telephone")).sendKeys("01021789000");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
    }

    public void InformationChangedSuccessfully() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"account-account\"]/div[1]")));
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"account-account\"]/div[1]")).getText();
        String expectedMessage = " Success: Your account has been successfully updated.";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    public void UserShouldSeesAnErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/h1")));
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/h1")).isDisplayed());
    }

    // Return items methods
    public void clickReturnProductsButton() {
        returnProductsButton.click();


    }

    public void clickViewButton() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/a")).click(); // click on view button
      // driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div/a")).click(); // click on 1st continue button
       // driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/a")).click(); // click on  2nd continue button
    }

    public void userSeesProductReturns(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[1]")));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[1]")).isDisplayed());
    }


}
