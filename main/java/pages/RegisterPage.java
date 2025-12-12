package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {

    // "Register" button or tab in navigation
    @FindBy(css = "a[href*='register'], a[data-testid*='register']")
    private WebElement registerTab;

    // Form fields
    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordInput;

    // Submit button
    @FindBy(css = "button[type='submit'], button#register, input[type='submit']")
    private WebElement registerButton;

    // Success message after registering
    @FindBy(css = ".success-message, .alert-success")
    private WebElement successMessage;

    // Error messages under fields
    @FindBy(css = ".error-message, .invalid-feedback, .alert-danger")
    private WebElement errorMessage;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    // Open the Register page
    public void openRegisterPage() {
        wait.until(ExpectedConditions.elementToBeClickable(registerTab)).click();
    }

    // Fill username
    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput)).clear();
        usernameInput.sendKeys(username);
    }

    // Fill email
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailInput)).clear();
        emailInput.sendKeys(email);
    }

    // Fill password
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput)).clear();
        passwordInput.sendKeys(password);
    }

    // Fill confirm password
    public void enterConfirmPassword(String confirmPassword) {
        wait.until(ExpectedConditions.visibilityOf(confirmPasswordInput)).clear();
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    // Click Register button
    public void clickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
    }

    // Complete registration in one method
    public void register(String username, String email, String password, String confirmPassword) {
        enterUsername(username);
        enterEmail(email);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
        clickRegisterButton();
    }

    // Check if success message displayed
    public boolean isSuccessMessageDisplayed() {
        try {
            return successMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Get success message text
    public String getSuccessMessageText() {
        try {
            return successMessage.getText();
        } catch (Exception e) {
            return "";
        }
    }

    // Check if an error message appears
    public boolean isErrorMessageDisplayed() {
        try {
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Get error message text
    public String getErrorMessageText() {
        try {
            return errorMessage.getText();
        } catch (Exception e) {
            return "";
        }
    }
}


