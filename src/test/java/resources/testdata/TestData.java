package resources.testdata;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "JobsFound")
    public Object[][] getData() {
        Object[][] data = new Object[][]{
                {"Tester", "Harrow",1, "30000","50000", 1, 1}};

        return data;
    }
}
