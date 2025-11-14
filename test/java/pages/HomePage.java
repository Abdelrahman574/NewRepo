package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    // Locators الحقيقية من الموقع
    @FindBy(css = "input[placeholder='Search for stations']")
    private WebElement searchInput;

    @FindBy(css = "button[type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[contains(@href, '/stations')]")
    private WebElement stationsLink;

    @FindBy(xpath = "//a[contains(@href, '/countries')]")
    private WebElement countriesLink;

    @FindBy(xpath = "//a[contains(@href, '/languages')]")
    private WebElement languagesLink;

    @FindBy(xpath = "//a[contains(@href, '/tags')]")
    private WebElement tagsLink;

    @FindBy(xpath = "//a[contains(@href, '/login')]")
    private WebElement loginLink;

    @FindBy(xpath = "//a[contains(@href, '/favorites')]")
    private WebElement favoritesLink;

    @FindBy(css = ".navbar-brand")
    private WebElement logo;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHome() {
        driver.get("https://www.radio-browser.info/");
    }

    public void searchForStation(String stationName) {
        wait.until(ExpectedConditions.elementToBeClickable(searchInput));
        searchInput.clear();
        searchInput.sendKeys(stationName);
        searchButton.click();
    }

    public void clickStationsLink() {
        clickElement(stationsLink);
    }

    public void clickCountriesLink() {
        clickElement(countriesLink);
    }

    public void clickLanguagesLink() {
        clickElement(languagesLink);
    }

    public void clickTagsLink() {
        clickElement(tagsLink);
    }

    public void clickLoginLink() {
        clickElement(loginLink);
    }

    public void clickFavoritesLink() {
        clickElement(favoritesLink);
    }

    public boolean isSearchInputDisplayed() {
        return isElementDisplayed(searchInput);
    }

    public boolean isLogoDisplayed() {
        return isElementDisplayed(logo);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void searchFor(String rock) {
    }
}