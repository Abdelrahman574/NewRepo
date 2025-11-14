package utilities;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "searchData")
    public Object[][] searchData() {
        return new Object[][] {
                {"rock"},
                {"news"},
                {"jazz"},
                {"classical"}
        };
    }

    @DataProvider(name = "stationData")
    public Object[][] stationData() {
        return new Object[][] {
                {"BBC"},
                {"NPR"},
                {"Radio France"},
                {"Deutschlandfunk"}
        };
    }
}