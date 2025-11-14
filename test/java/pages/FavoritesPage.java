package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FavoritesPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'favorite')]")
    private List<WebElement> favoriteItems;

    @FindBy(xpath = "//h1[contains(text(),'Favorites')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[contains(text(),'No favorites')]")
    private WebElement noFavoritesMessage;

    public FavoritesPage(WebDriver driver) {
        super(driver);
    }

    public int getFavoritesCount() {
        return favoriteItems.size();
    }

    public boolean isFavoritesPageDisplayed() {
        return isElementDisplayed(pageTitle);
    }

    public boolean isNoFavoritesMessageDisplayed() {
        return isElementDisplayed(noFavoritesMessage);
    }

    public void removeFirstFavorite() {
        if (!favoriteItems.isEmpty()) {
            // Assuming there's a remove button - adjust selector as needed
            WebElement removeButton = favoriteItems.get(0).findElement(org.openqa.selenium.By.xpath(".//button[contains(text(),'Remove')]"));
            clickElement(removeButton);
        }
    }
}
