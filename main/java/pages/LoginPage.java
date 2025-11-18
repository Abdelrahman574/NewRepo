package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class,'error')]")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        sendKeysToElement(usernameInput, username);
        sendKeysToElement(passwordInput, password);
        clickElement(loginButton);
    }

    public boolean isErrorMessageDisplayed() {
        return isElementDisplayed(errorMessage);
    }

    public String getErrorMessage() {
        return isErrorMessageDisplayed() ? getElementText(errorMessage) : "";
    }
}
