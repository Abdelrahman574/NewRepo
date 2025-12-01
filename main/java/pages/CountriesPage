package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CountriesPage extends BasePage {

    // Button/Tab to open the countries section
    @FindBy(css = "a[href*='country'], a[data-testid*='country']")
    private WebElement countriesTab;

    // List of all countries displayed
    @FindBy(css = ".list-group-item, .country-item, li a[href*='/country/']")
    private List<WebElement> countryList;

    // Page title after selecting a country
    @FindBy(css = "h1, .page-title")
    private WebElement selectedCountryTitle;

    // Station results for the selected country
    @FindBy(css = ".station-item, .list-group-item")
    private List<WebElement> stationResults;

    // "No results" message
    @FindBy(xpath = "//*[contains(text(),'No results') or contains(text(),'not found')]")
    private WebElement noResultsMessage;

    public CountriesPage(WebDriver driver) {
        super(driver);
    }

    // Open countries tab/menu
    public void openCountriesTab() {
        wait.until(ExpectedConditions.elementToBeClickable(countriesTab)).click();
    }

    // Get the total number of countries displayed
    public int getCountriesCount() {
        wait.until(ExpectedConditions.visibilityOfAllElements(countryList));
        return countryList.size();
    }

    // Get all country names as text list
    public List<String> getAllCountryNames() {
        wait.until(ExpectedConditions.visibilityOfAllElements(countryList));
        return countryList.stream()
                .map(WebElement::getText)
                .toList();
    }

    // Select a country by its visible name
    public void selectCountry(String countryName) {
        wait.until(ExpectedConditions.visibilityOfAllElements(countryList));

        for (WebElement country : countryList) {
            if (country.getText().equalsIgnoreCase(countryName)) {
                clickElement(country);
                return;
            }
        }
        throw new RuntimeException("Country not found: " + countryName);
    }

    // Select a country by its index
    public void selectCountryByIndex(int index) {
        wait.until(ExpectedConditions.visibilityOfAllElements(countryList));
        if (index < countryList.size()) {
            clickElement(countryList.get(index));
        } else {
            throw new IndexOutOfBoundsException("Invalid country index");
        }
    }

    // Get page title after selecting a country
    public String getSelectedCountryTitle() {
        return getElementText(selectedCountryTitle);
    }

    // Get number of stations found for the selected country
    public int getStationsCount() {
        wait.until(ExpectedConditions.visibilityOfAllElements(stationResults));
        return stationResults.size();
    }

    // Check if this country has at least one station result
    public boolean hasResults() {
        try {
            return stationResults.size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    // Check whether the "No results" message appears
    public boolean isNoResultsMessageDisplayed() {
        try {
            return noResultsMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}


