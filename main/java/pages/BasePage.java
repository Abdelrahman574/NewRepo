package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BrowserUtils;
import utilities.ConfigReader;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("timeout"))));
        PageFactory.initElements(driver, this);
    }

    protected void clickElement(WebElement element) {
        BrowserUtils.waitForClickable(element, driver);
        element.click();
    }

    protected void sendKeysToElement(WebElement element, String text) {
        BrowserUtils.waitForVisible(element, driver);
        element.clear();
        element.sendKeys(text);
    }

    protected String getElementText(WebElement element) {
        BrowserUtils.waitForVisible(element, driver);
        return element.getText();
    }

    protected boolean isElementDisplayed(WebElement element) {
        try {
            BrowserUtils.waitForVisible(element, driver);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

