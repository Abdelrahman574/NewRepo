package tests;

import driverfactory.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;
import utilities.TestBase;

import java.time.Duration;

public class SearchTests extends TestBase {

    @Test
    public void testSearchForRockStations() {
        HomePage homePage = new HomePage((Driver) driver);
        SearchPage searchPage = new SearchPage(driver);


        homePage.searchFor("rock");


        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("search"));


        Assert.assertTrue(searchPage.hasResults(), "Should find rock stations");
        Assert.assertTrue(searchPage.getResultsCount() > 0, "Should have multiple results");

        System.out.println("Found " + searchPage.getResultsCount() + " rock stations");
        System.out.println("First station: " + searchPage.getFirstStationName());
    }

    @Test
    public void testSearchForNewsStations() {
        HomePage homePage = new HomePage((Driver) driver);
        SearchPage searchPage = new SearchPage(driver);

        homePage.searchFor("news");

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("search"));

        Assert.assertTrue(searchPage.hasResults(), "Should find news stations");
        System.out.println("Found " + searchPage.getResultsCount() + " news stations");
    }

    @Test
    public void testSearchForJazzStations() {
        HomePage homePage = new HomePage((Driver) driver);
        SearchPage searchPage = new SearchPage(driver);

        homePage.searchFor("jazz");

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("search"));

        Assert.assertTrue(searchPage.hasResults(), "Should find jazz stations");
        System.out.println("Found " + searchPage.getResultsCount() + " jazz stations");
    }

    @Test
    public void testSearchWithInvalidTerm() {
        HomePage homePage = new HomePage((Driver) driver);
        SearchPage searchPage = new SearchPage(driver);

        homePage.searchFor("invalidstation12345");

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("search"));

        System.out.println("Results for invalid search: " + searchPage.getResultsCount());
    }

    @Test
    public void testPlayStation() {
        HomePage homePage = new HomePage((Driver) driver);
        SearchPage searchPage = new SearchPage(driver);

        homePage.searchFor("bbc");

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("search"));

        if (searchPage.hasResults()) {
            searchPage.playFirstStation();
            System.out.println("Playing station: " + searchPage.getFirstStationName());
        }
    }
}