package dataprovider;

public class DataProviderLogic {
    @org.testng.annotations.DataProvider(name = "dataProvider")
    public Object[][] getDataFromDataProvider() {
        return new Object[][]{
                {"8208139338", "Yasin@786"},

        };
    }
}