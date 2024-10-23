package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AddItemsAndCheckout {
    public WebDriver driver;
    WebDriverWait wait;

    public AddItemsAndCheckout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By MobileCategory = By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[6]/a");
    By Mobile1 = By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[2]/div[2]/button[2]");
    By Mobile2 = By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[2]/div[2]/button[2]");
    By wishListButton = By.id("wishlist-total");
    By QuantityField = By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/input");
    By RemoveQuantityButton = By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button[2]");
    By UpdateQuantityButton = By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button[1]");
    By Checkout_Button = By.xpath("//*[@id=\"top-links\"]/ul/li[5]/a/span");
    By ShoppingCart_Button = By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[4]/a[1]/i[1]");
    // TC_9,14  Methods to add items to wish list then delete them
    public void clickMobileCategory() {
        driver.findElement(MobileCategory).click();

    }

    public void clickMobile1() {
        driver.findElement(Mobile1).click();
    }

    public void clickMobile2() {
        driver.findElement(Mobile2).click();
    }

    public void clickWishListButton() {
        driver.findElement(wishListButton).click();
    }

    public void deleteItemsFromWishList() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr[1]/td[6]/a")).click();

    }

    public void verifyThatItemsAreDeletedFromWishList() {
        String text = driver.findElement(By.xpath("//*[@id=\"content\"]/p")).getText();
        Assert.assertEquals(text, "Your wish list is empty.");
    }

    //TC10,15 Methods to Add Items To Compare List then delete them

    public void addItemsToCompareList() {
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/a")).click(); // Select Main Category
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/div/div/ul/li[2]/a")).click(); // Select Sub Category
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[2]/button[3]")).click(); // Select First Product
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/div/div[2]/div[2]/button[3]")).click(); // Select Second Product
        driver.findElement(By.xpath("//*[@id=\"compare-total\"]")).click(); // Click on Compare Button


    }

    public void userShouldBeAbleToSeeItemsInCompareList() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody[1]/tr[1]/td[2]/a/strong")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody[1]/tr[1]/td[3]/a/strong")).isDisplayed());

    }

    public void deleteItemsFromCompareList() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody[3]/tr/td[2]/a")).click();
    }

    public void verifyThatItemsAreDeletedFromCompareList() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"product-compare\"]/div[1]")).isDisplayed());


    }

    // TC11,16 Methods to Add Items To the Shopping cart then delete them

    public void addItemsToShoppingCart() {
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/a")).click(); // Select Main Category
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/div/div/ul/li[2]/a")).click(); // Select Sub Category
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/div/div[2]/div[2]/button[1]/span")).click(); // Select Product
    }

    public void userShouldBeAbleToSeeItemsInShoppingCart() {
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a/span")).click(); // click on Shopping Cart Button
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[2]/a")).isDisplayed());

    }

    public void deleteItemsFromShoppingCart() {
        driver.findElement(RemoveQuantityButton).click();
    }

    public void verifyThatItemsAreDeletedFromShoppingCart() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/p")).isDisplayed());

    }
    // update quantity count
    public void UserUpdateQuantity() {
        wait.until(ExpectedConditions.elementToBeClickable(QuantityField));
        driver.findElement(QuantityField).click();
        driver.findElement(QuantityField).clear(); // clear the quantity field
        driver.findElement(QuantityField).sendKeys("5"); // enter new quantity
        driver.findElement(UpdateQuantityButton).click(); // click on Update Button
    }

    public void verifyQuantity() {
        wait.until(ExpectedConditions.elementToBeClickable(QuantityField));
        String text = driver.findElement(QuantityField).getAttribute("value");
        Assert.assertEquals(text, "5");
    }


    public void verifyTheCartIsEmpty() {
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div/div/a")));
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
        driver.findElement(ShoppingCart_Button).click();
       String text = driver.findElement(By.xpath("//*[@id=\"content\"]/p")).getText();
        Assert.assertEquals(text, "Your shopping cart is empty!");

    }



    public void clickShoppingCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ShoppingCart_Button));
        driver.findElement(ShoppingCart_Button).click();
    }

    public void clickContinueShoppingButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div/div/a")));
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
    }

    public void ValidateUserNavigateToHomePage() {
       String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://awesomeqa.com/ui/index.php?route=common/home");
    }


}
