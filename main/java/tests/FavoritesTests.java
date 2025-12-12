package tests;

import driverfactory.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FavoritesPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;
import utilities.TestBase;

public class FavoritesTests extends TestBase {

    @Test
    public void testFavoritesPageNavigation() {
        HomePage homePage = new HomePage((Driver) driver);


        FavoritesPage favoritesPage = new FavoritesPage(driver);


        Assert.assertTrue(favoritesPage.isFavoritesPageDisplayed() ||
                        driver.getCurrentUrl().contains("login"),
                "Should navigate to favorites page or login");
    }

    @Test
    public void testAddToFavoritesWithoutLogin() {
        WebDriver driver = null;
        HomePage homePage = new HomePage((Driver) driver);

        SearchPage searchPage = new SearchPage(driver);
        searchPage.clickFirstFavoriteButton();


        Assert.assertTrue(searchPage.getSearchResultsCount() > 0,
                "Page should remain functional after favorite attempt");
    }

    @Test
    public <HomePage> void testLoginFunctionality() {
        WebDriver driver = null;
        pages.HomePage homePage = new pages.HomePage((Driver) driver);


        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("testuser", "testpass");


        Assert.assertTrue(loginPage.isErrorMessageDisplayed() ||
                        !driver.getCurrentUrl().contains("login"),
                "Login attempt should result in error or redirection");
    }
}

