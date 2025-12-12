package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LanguagePage extends BasePage {

    // Button to open the Languages section (if available)
    @FindBy(css = "a[href*='language'], a[data-testid*='language']")
    private WebElement languageTab;

    // Languages list (usually UL, DIV, or anchor list)
    @FindBy(css = ".list-group-item, .language-item, li a[href*='/language/']")
    private List<WebElement> languageList;

    // Page title after selecting a language
    @FindBy(css = "h1, .page-title")
    private WebElement selectedLanguageTitle;

    // Radio station results after selecting a language
    @FindBy(css = ".station-item, .list-group-item")
    private List<WebElement> stationResults;

    // "No results" message
    @FindBy(xpath = "//*[contains(text(),'No results') or contains(text(),'not found')]")
    private WebElement noResultsMessage;

    public LanguagePage(WebDriver driver) {
        super(driver);
    }

    // Open the language tab/menu
    public void openLanguageTab() {
        wait.until(ExpectedConditions.elementToBeClickable(languageTab)).click();
    }

    // Get the number of available languages
    public int getLanguagesCount() {
        wait.until(ExpectedConditions.visibilityOfAllElements(languageList));
        return languageList.size();
    }

    // Return a list of all language names
    public List<String> getAllLanguageNames() {
        wait.until(ExpectedConditions.visibilityOfAllElements(languageList));
        return languageList.stream()
                .map(WebElement::getText)
                .toList();
    }

    // Select a language using its text label
    public void selectLanguage(String languageName) {
        wait.until(ExpectedConditions.visibilityOfAllElements(languageList));

        for (WebElement lang : languageList) {
            if (lang.getText().equalsIgnoreCase(languageName)) {
                clickElement(lang);
                return;
            }
        }
        throw new RuntimeException("Language not found: " + languageName);
    }

    // Select a language by its index in the list
    public void selectLanguageByIndex(int index) {
        wait.until(ExpectedConditions.visibilityOfAllElements(languageList));
        if (index < languageList.size()) {
            clickElement(languageList.get(index));
        } else {
            throw new IndexOutOfBoundsException("Invalid language index");
        }
    }

    // Get the title of the page after selecting a language
    public String getSelectedLanguageTitle() {
        return getElementText(selectedLanguageTitle);
    }

    // Get the number of stations displayed for the selected language
    public int getStationsCount() {
        wait.until(ExpectedConditions.visibilityOfAllElements(stationResults));
        return stationResults.size();
    }

    // Whether the language contains any station results
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


