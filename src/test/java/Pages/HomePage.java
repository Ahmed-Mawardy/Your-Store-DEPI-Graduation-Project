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

public class HomePage {

    // Web driver
    public WebDriver driver;
    WebDriverWait wait;


    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // locators
    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
    WebElement MyAccountButton;

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement LogoutButton;

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
    WebElement LoginButton;

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
    WebElement RegisterButton;




    // Search locators
    By SearchBox = By.xpath("//*[@id=\"search\"]/input");

    By SearchButton = By.xpath("/html/body/header/div/div/div[2]/div/span/button");


    // Currencies
    By Currencies = By.xpath("//*[@id=\"form-currency\"]/div/button/span");
    By Dollar = By.xpath("//*[@id=\"form-currency\"]/div/ul/li[3]/button");
    By Euro = By.xpath("//*[@id=\"form-currency\"]/div/ul/li[1]/button");
    By Pound = By.xpath("//*[@id=\"form-currency\"]/div/ul/li[2]/button");


    // Methods
    public void navigate(String url) {
        driver.navigate().to(url);
    }

    public void navigateToHomePage() {
        navigate("https://awesomeqa.com/ui/index.php?route=common/home");
    }

    public void click_MyAccount() {
        MyAccountButton.click();
    }

    public void click_Login() {
        LoginButton.click();
    }

    // Search Methods
    public void click_SearchBox() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SearchBox));
        driver.findElement(SearchBox).click();
        driver.findElement(SearchBox).clear();
    }

    public void enterSearchText(String product) {
        driver.findElement(SearchBox).sendKeys(product);
    }

    public void clickSearchButton() {
        driver.findElement(SearchButton).click();
    }

    public String getFirstProductTitle() {
        // Wait for the product title element to be visible and retrieve the text
        WebElement productElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4/a")));
        return productElement.getText();
    }

    public void verifyProductAppearsCorrectlyAfterSearch() {
        // Search for a product (e.g., iMac)
        String productName = "iMac";

        // Verify that the product appears in the search results
        String actualProductTitle = getFirstProductTitle();

        // Assert the product name matches what was searched for
        Assert.assertTrue(actualProductTitle.contains(productName),
                "The product title '" + actualProductTitle + "' does not contain the expected product name: '" + productName + "'");
    }

    // Currencies Methods
    public void clickCurrencies() {
        driver.findElement(Currencies).click();
    }

    public void clickDollar() {
        driver.findElement(Dollar).click();
        By DollarSymbol = By.xpath("//*[@id=\"form-currency\"]/div/button/strong"); // DollarSymbol
        String DollarSymbolText = driver.findElement(DollarSymbol).getText();
        Assert.assertEquals(DollarSymbolText, "$");

    }

    public void clickEuro() {
        driver.findElement(Euro).click();

    }

    public void currencyShouldBeChangedtoEuro() {
        By EuroSymbol = By.xpath("//*[@id=\"form-currency\"]/div/button/strong"); // EuroSymbol
        String EuroSymbolText = driver.findElement(EuroSymbol).getText();
        Assert.assertEquals(EuroSymbolText, "€");
    }


    public void click_Register() {
        RegisterButton.click();
    }

//    public void clickLogout() {
//        MyAccountButton.click();
//        LogoutButton.click();
//    }

}

