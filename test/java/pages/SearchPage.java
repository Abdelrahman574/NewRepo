package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchPage extends BasePage {

    // Locators الحقيقية
    @FindBy(css = ".station-item, .list-group-item")
    private List<WebElement> stationResults;

    @FindBy(css = ".station-name, h3")
    private List<WebElement> stationNames;

    @FindBy(xpath = "//*[contains(text(),'No results') or contains(text(),'not found')]")
    private WebElement noResultsMessage;

    @FindBy(css = ".play-button, button[title*='Play']")
    private List<WebElement> playButtons;

    @FindBy(css = ".favorite-btn, button[title*='Favorite']")
    private List<WebElement> favoriteButtons;

    @FindBy(css = ".search-results-count")
    private WebElement resultsCount;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public int getSearchResultsCount() {
        wait.until(ExpectedConditions.visibilityOfAllElements(stationResults));
        return stationResults.size();
    }

    public String getFirstStationName() {
        if (!stationNames.isEmpty()) {
            return getElementText(stationNames.get(0));
        }
        return "";
    }

    public boolean isNoResultsMessageDisplayed() {
        try {
            return noResultsMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickFirstPlayButton() {
        if (!playButtons.isEmpty()) {
            clickElement(playButtons.get(0));
        }
    }

    public void clickFirstFavoriteButton() {
        if (!favoriteButtons.isEmpty()) {
            clickElement(favoriteButtons.get(0));
        }
    }

    public void clickStationByIndex(int index) {
        if (index < stationResults.size()) {
            clickElement(stationResults.get(index));
        }
    }

    public List<String> getAllStationNames() {
        return stationNames.stream()
                .map(WebElement::getText)
                .toList();
    }

    public boolean hasResults() {
        return false;
    }

    public int getResultsCount() {
        return 0;
    }

    public void playFirstStation() {
    }
}