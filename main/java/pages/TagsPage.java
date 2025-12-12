package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class TagsPage extends BasePage {

    // Button/Tab to open the Tags section
    @FindBy(css = "a[href*='tag'], a[data-testid*='tag']")
    private WebElement tagsTab;

    // List of all tags visible on the page
    @FindBy(css = ".list-group-item, .tag-item, li a[href*='/tag/']")
    private List<WebElement> tagList;

    // Page title after selecting a tag
    @FindBy(css = "h1, .page-title")
    private WebElement selectedTagTitle;

    // Station results after selecting a tag
    @FindBy(css = ".station-item, .list-group-item")
    private List<WebElement> stationResults;

    // "No results" message
    @FindBy(xpath = "//*[contains(text(),'No results') or contains(text(),'not found')]")
    private WebElement noResultsMessage;

    public TagsPage(WebDriver driver) {
        super(driver);
    }

    // Open tags tab
    public void openTagsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(tagsTab)).click();
    }

    // Get number of available tags
    public int getTagsCount() {
        wait.until(ExpectedConditions.visibilityOfAllElements(tagList));
        return tagList.size();
    }

    // Return list of all tag names
    public List<String> getAllTagNames() {
        wait.until(ExpectedConditions.visibilityOfAllElements(tagList));
        return tagList.stream()
                .map(WebElement::getText)
                .toList();
    }

    // Select a tag by its visible text
    public void selectTag(String tagName) {
        wait.until(ExpectedConditions.visibilityOfAllElements(tagList));

        for (WebElement tag : tagList) {
            if (tag.getText().equalsIgnoreCase(tagName)) {
                clickElement(tag);
                return;
            }
        }
        throw new RuntimeException("Tag not found: " + tagName);
    }

    // Select tag by index
    public void selectTagByIndex(int index) {
        wait.until(ExpectedConditions.visibilityOfAllElements(tagList));
        if (index < tagList.size()) {
            clickElement(tagList.get(index));
        } else {
            throw new IndexOutOfBoundsException("Invalid tag index");
        }
    }

    // Get the selected tag title displayed on the page
    public String getSelectedTagTitle() {
        return getElementText(selectedTagTitle);
    }

    // Get how many stations appear for this tag
    public int getStationsCount() {
        wait.until(ExpectedConditions.visibilityOfAllElements(stationResults));
        return stationResults.size();
    }

    // Check if results exist for the selected tag
    public boolean hasResults() {
        try {
            return stationResults.size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    // Check if "No results" message is displayed
    public boolean isNoResultsMessageDisplayed() {
        try {
            return noResultsMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}


