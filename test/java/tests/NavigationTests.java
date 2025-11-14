package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.StationsPage;
import utilities.TestBase;

public class NavigationTests extends TestBase {

    @Test
    public void testStationsPageNavigation() {
        HomePage homePage = new HomePage(driver);
        homePage.clickStationsLink();

        StationsPage stationsPage = new StationsPage(driver);

        Assert.assertTrue(stationsPage.isStationsPageDisplayed(),
                "Stations page should be displayed");
        Assert.assertTrue(stationsPage.getStationsCount() > 0,
                "Stations page should display stations");
    }

    @Test
    public void testCountriesPageNavigation() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCountriesLink();

        Assert.assertTrue(driver.getCurrentUrl().contains("countries") ||
                        driver.getCurrentUrl().contains("country"),
                "Should navigate to countries page");
    }

    @Test
    public void testLanguagesPageNavigation() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLanguagesLink();

        Assert.assertTrue(driver.getCurrentUrl().contains("languages") ||
                        driver.getCurrentUrl().contains("language"),
                "Should navigate to languages page");
    }

    @Test
    public void testTagsPageNavigation() {
        HomePage homePage = new HomePage(driver);
        homePage.clickTagsLink();

        Assert.assertTrue(driver.getCurrentUrl().contains("tags") ||
                        driver.getCurrentUrl().contains("tag"),
                "Should navigate to tags page");
    }

    @Test
    public void testHomePageElements() {
        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(homePage.isSearchInputDisplayed(),
                "Search input should be displayed on home page");
    }
}