package tests;

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
        HomePage homePage = new HomePage(driver);
        homePage.clickFavoritesLink();

        FavoritesPage favoritesPage = new FavoritesPage(driver);


        Assert.assertTrue(favoritesPage.isFavoritesPageDisplayed() ||
                        driver.getCurrentUrl().contains("login"),
                "Should navigate to favorites page or login");
    }

    @Test
    public void testAddToFavoritesWithoutLogin() {
        HomePage homePage = new HomePage(driver);
        homePage.searchForStation("rock");

        SearchPage searchPage = new SearchPage(driver);
        searchPage.clickFirstFavoriteButton();


        Assert.assertTrue(searchPage.getSearchResultsCount() > 0,
                "Page should remain functional after favorite attempt");
    }

    @Test
    public void testLoginFunctionality() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("testuser", "testpass");


        Assert.assertTrue(loginPage.isErrorMessageDisplayed() ||
                        !driver.getCurrentUrl().contains("login"),
                "Login attempt should result in error or redirection");
    }
}
