package apiTests.pocTests;

import org.testng.annotations.DataProvider;

public class ApiTestDataProvider {

    @DataProvider(name = "TestData1")
    public Object[][] createTestData1() {

        Object[][] testData = new Object[2][2];

        testData[0][0] = "Transfer Center";
        testData[0][1] = "Business";

        testData[1][0] = "Team";
        testData[1][1] = "Engineering";

        return testData;
    }

    @DataProvider(name = "TestData2")
    public Object[][] createTestData2() {

        return new Object[][]{
                {"Transfer Center", "Business"},
                {"Team2", "Engineering2"}
        };
    }
}
