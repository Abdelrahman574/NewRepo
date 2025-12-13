package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Page Factory Locators
    @FindBy(linkText = "Languages")
    private WebElement languagesLink;

    @FindBy(linkText = "Countries")
    private WebElement countriesLink;

    @FindBy(id = "searchInput")
    private WebElement searchInput;

    @FindBy(id = "searchButton")
    private WebElement searchButton;

    @FindBy(linkText = "Home")
    private WebElement homeLink;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Test Methods with TestNG annotations

    @Test(description = "Test to click on Languages and Countries links")
    public LanguagePage clickOnLanguageAndCountryLinks() {
        wait.until(ExpectedConditions.elementToBeClickable(languagesLink)).click();
        wait.until(ExpectedConditions.elementToBeClickable(countriesLink)).click();
        return new LanguagePage(driver);
    }

    @Test(description = "Search for radio station")
    public SearchPage searchForStation(String searchTerm) {
        wait.until(ExpectedConditions.visibilityOf(searchInput)).sendKeys(searchTerm);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        return new SearchPage(driver);
    }

    @Test(description = "Navigate to homepage")
    public HomePage navigateToHomepage() {
        wait.until(ExpectedConditions.elementToBeClickable(homeLink)).click();
        return this;
    }

    // Navigation method
    public HomePage goToHomePage(String url) {
        driver.get(url);
        return this;
    }

    // Utility methods
    public boolean isSearchInputDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(searchInput)).isDisplayed();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}

