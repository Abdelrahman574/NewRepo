package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class StationsPage extends BasePage {

    @FindBy(css = ".station-list .station-item, table tbody tr")
    private List<WebElement> stationRows;

    @FindBy(tagName = "h1")
    private WebElement pageTitle;

    @FindBy(css = "input[placeholder*='Filter'], input[placeholder*='Search']")
    private WebElement filterInput;

    @FindBy(css = "button[type*='submit'], .filter-button")
    private WebElement filterButton;

    @FindBy(css = ".station-count, .results-count")
    private WebElement stationsCount;

    public StationsPage(WebDriver driver) {
        super(driver);
    }

    public int getStationsCount() {
        wait.until(ExpectedConditions.visibilityOfAllElements(stationRows));
        return stationRows.size();
    }

    public boolean isStationsPageDisplayed() {
        return getElementText(pageTitle).toLowerCase().contains("station");
    }

    public void filterStations(String filterText) {
        sendKeysToElement(filterInput, filterText);
        clickElement(filterButton);
    }

    public String getPageTitle() {
        return getElementText(pageTitle);
    }

    public String getStationsCountText() {
        return isElementDisplayed(stationsCount) ? getElementText(stationsCount) : "";
    }
}