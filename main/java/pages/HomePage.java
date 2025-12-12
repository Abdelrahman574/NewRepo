package pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage<LanguagesPage> {

    private Driver driver;

    // Locators
    By searchInput = By.xpath("//input[@placeholder='Search for stations']");
    By searchButton = By.xpath("//button[contains(text(),'Search')]");
    By advancedSearchLink = By.xpath("//a[contains(text(),'Advanced search')]");
    By tagsLink = By.xpath("//a[contains(text(),'Tags')]");
    By countriesLink = By.xpath("//a[contains(text(),'Countries')]");
    By languagesLink = By.xpath("//a[contains(text(),'Languages')]");
    By loginLink = By.xpath("//a[contains(text(),'Login')]");
    By registerLink = By.xpath("//a[contains(text(),'Register')]");
    By homepageHeader = By.xpath("//h1[contains(text(),'Radio Browser')]");
    By stationListSection = By.xpath("//div[contains(@class,'station-list') or contains(@class,'stations')]");
    By featuredStationsSection = By.xpath("//h2[contains(text(),'Featured')]/following-sibling::div");
    By popularStationsSection = By.xpath("//h2[contains(text(),'Popular')]/following-sibling::div");
    By recentStationsSection = By.xpath("//h2[contains(text(),'Recent')]/following-sibling::div");
    By footerSection = By.tagName("footer");

    public HomePage(Driver driver) {
        this.driver = this.driver;
    }

    /******************************* Assertions ***********************************/

    @Step("Check That Homepage Should Be Loaded Successfully")
    public HomePage checkThatHomepageShouldBeLoadedSuccessfully() {
        Assert.assertTrue(driver.element().isDisplayed(homepageHeader));
        Assert.assertTrue(driver.element().isDisplayed(searchInput));
        return this;
    }

    @Step("Check That Search Functionality Should Be Available")
    public HomePage checkThatSearchFunctionalityShouldBeAvailable() {
        Assert.assertTrue(driver.element().isDisplayed(searchInput));
        Assert.assertTrue(driver.element().isDisplayed(searchButton));
        return this;
    }

    @Step("Check That Navigation Links Should Be Displayed")
    public HomePage checkThatNavigationLinksShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(advancedSearchLink));
        Assert.assertTrue(driver.element().isDisplayed(tagsLink));
        Assert.assertTrue(driver.element().isDisplayed(countriesLink));
        Assert.assertTrue(driver.element().isDisplayed(languagesLink));
        return this;
    }

    @Step("Check That Authentication Links Should Be Displayed")
    public HomePage checkThatAuthenticationLinksShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(loginLink));
        Assert.assertTrue(driver.element().isDisplayed(registerLink));
        return this;
    }

    @Step("Check That Stations Sections Should Be Displayed")
    public HomePage checkThatStationsSectionsShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(featuredStationsSection) ||
                driver.element().isDisplayed(popularStationsSection) ||
                driver.element().isDisplayed(recentStationsSection));
        return this;
    }

    @Step("Check That Footer Should Be Displayed")
    public HomePage checkThatFooterShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(footerSection));
        return this;
    }

    /******************************** Actions ***********************************/

    @Step("Click on Login Link")
    public LoginPage clickOnLoginLink() {
        driver.element().click(loginLink);
        return new LoginPage((WebDriver) driver);
    }

    @Step("Click on Register Link")
    public RegisterPage clickOnRegisterLink() {
        driver.element().click(registerLink);
        return new RegisterPage((WebDriver) driver);
    }


    @Step("Click on Tags Link")
    public TagsPage clickOnTagsLink() {
        driver.element().click(tagsLink);
        return new TagsPage((WebDriver) driver);
    }

    @Step("Click on Countries Link")
    public CountriesPage clickOnCountriesLink() {
        driver.element().click(countriesLink);
        return new CountriesPage((WebDriver) driver);
    }

    @Step("Click on Languages Link")
    public LanguagesPage clickOnLanguagesLink() {
        driver.element().click(languagesLink);
        driver.element().click(countriesLink);
        return null;
    }

    @Step("Search for Station: {searchTerm}")
    public SearchPage searchForStation(String searchTerm) {
        driver.element().fillField(searchInput, searchTerm);
        driver.element().click(searchButton);
        return new SearchPage((WebDriver) driver);
    }

    @Step("Navigate to Homepage")
    public HomePage navigateToHomepage() {
        driver.get("https://www.radio-browser.info/");
        return this;
    }

    public void searchFor(String rock) {
    }
}