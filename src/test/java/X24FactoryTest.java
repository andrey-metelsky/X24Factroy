import client.DriverFactory;
import data.CategoryName;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.ProductGrid;

import static data.CategoryName.*;
import static data.DefaultValues.*;
import static data.Parameters.BROWSER;
import static data.Parameters.SITEURL;
import static utils.Utils.storeProductNamesFoFile;

public class X24FactoryTest extends BaseTest {
    private HomePage homePage;

    @BeforeClass(groups = {"init"}, alwaysRun = true)
    public void beforeClassInit() {
        DriverFactory.getInstance().setDriver(BROWSER.getValue(), SITEURL.getValue());
        homePage = new HomePage();
    }

    @BeforeMethod(groups = {"init"}, alwaysRun = true)
    public void beforeMethodInit() {
        getWebDriver().get(SITEURL.getValue());
    }

    @DataProvider
    private Object[][] categoriesNames() {
        return new Object[][]{
                {HOCKER},
                {SESSEL},
                {REGALE}};
    }

    @Test(dataProvider = "categoriesNames")
    public void testTaskForX24Factory(CategoryName categoryName) {
        homePage
                .openCategoryMenu()
                .openCategoryByName(categoryName)
                .verifyQuantityOfProductsPerPage(QTY_OF_PRODUCTS_PER_PAGE.getValue())
                .verifyPaginationInfo(FIRST_PAGE_PAGINATION_INFO.getValue())
                .clickButtonMoreProducts()
                .verifyQuantityOfProductsPerPage(QTY_OF_PRODUCTS_PER_PAGE.getValue())
                .verifyPaginationInfo(SECOND_PAGE_PAGINATION_INFO.getValue())
                .clickButtonNext()
                .verifyQuantityOfProductsPerPage(QTY_OF_PRODUCTS_PER_PAGE.getValue());
        String productsNames = String.join("; ", new ProductGrid().getProductsNames(5));
        storeProductNamesFoFile(categoryName, productsNames.toString());
    }
}
