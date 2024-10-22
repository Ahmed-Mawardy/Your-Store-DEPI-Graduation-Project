package Pages;

import StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertTrue;

public class Categories {

    public WebDriver driver;

    public Categories(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    // Locators for main and sub categories
    @FindBy(css = "ul.navbar-nav > li > a") // Adjust based on actual locator for main categories
    List<WebElement> mainCategories;

    @FindBy(css = "ul.nav > li > a") // Adjust based on actual locator for subcategories
    List<WebElement> subCategories;

    @FindBy(css = "div.product-grid") // Locator for products in the grid
    private WebElement productGrid;

    // TC_6 Methods to interact with categories
    public void selectRandomMainCategory() {
        Random random = new Random();
        int mainCategoryIndex = random.nextInt(mainCategories.size());
        WebElement selectedMainCategory = mainCategories.get(mainCategoryIndex);
        selectedMainCategory.click();
    }

    public void selectRandomSubCategory() {
        if (subCategories.size() > 0) {
            Random random = new Random();
            int subCategoryIndex = random.nextInt(subCategories.size());
            WebElement selectedSubCategory = subCategories.get(subCategoryIndex);
            selectedSubCategory.click();
        }

    }

    // TC_7 Methods to Hover categories
    public void hoverRandomMainCategory() {
        Random random = new Random();
        int mainCategoryIndex = random.nextInt(mainCategories.size());
        WebElement selectedMainCategory = mainCategories.get(mainCategoryIndex);
        Actions actions = new Actions(Hooks.driver);
        actions.moveToElement(selectedMainCategory).perform(); // Hover over the main category
    }

    // Method to hover over a random sub-category if available
    public void hoverRandomSubCategory() {
        if (subCategories.size() > 0) {
            Random random = new Random();
            int subCategoryIndex = random.nextInt(subCategories.size());
            WebElement selectedSubCategory = subCategories.get(subCategoryIndex);
            Actions actions = new Actions(Hooks.driver);
            actions.moveToElement(selectedSubCategory).perform();
        }
    }

    public void verifyHoverActionsAreSuccessful() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement subCategory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.nav > li > a")));
        // Assert that the sub-category dropdown is displayed
        assertTrue(subCategory.isDisplayed(), "Sub-categories dropdown is visible after hovering.");
    }

    // Method to verify if the product grid is displayed
    public boolean isProductGridDisplayed() {
        return productGrid.isDisplayed();
    }


}

