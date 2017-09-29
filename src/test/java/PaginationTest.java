import data.CategoryName;
import org.junit.runners.Parameterized;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.ProductGrid;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import static data.CategoryName.*;
import static data.Parameters.BROWSER;
import static data.Parameters.SITEURL;

public class PaginationTest extends BaseTest {
    private HomePage homePage;

    @BeforeClass(groups = {"init"}, alwaysRun = true)
    public void beforeClassInit() {
        setDriver(BROWSER.getValue(), SITEURL.getValue());
        homePage = new HomePage();
    }

    @AfterClass(groups = {"init"}, alwaysRun = true)
    public void afterClassInit() {
        tearDown();
    }


    @DataProvider
    private Object[][] categoriesNames() {
        return new Object[][] {
                {HOCKER},
                {SESSEL},
                {REGALE}};
    }

    @Test(dataProvider = "categoriesNames")
    public void testVerifyPagination(CategoryName categoryName) {
        int qtyOfProductsPerPage = 56;
        String firstPagePaginationInfo = "1   -   56";
        String secondPagePaginationInfo = "57   -   112";

        homePage
                .openCategoryMenu()
                .openCategoryByName(categoryName)
                .verifyQuantityOfProductsPerPage(qtyOfProductsPerPage)
                .verifyPaginationInfo(firstPagePaginationInfo)
                .clickButtonMoreProducts()
                .verifyQuantityOfProductsPerPage(qtyOfProductsPerPage)
                .verifyPaginationInfo(secondPagePaginationInfo)
                .clickButtonNext()
                .verifyQuantityOfProductsPerPage(qtyOfProductsPerPage);
        List<String> productsNames = new ProductGrid().getProductsNames(5);
        storeCategoriesNamesFoFile(productsNames.toString());
    }

    public void storeCategoriesNamesFoFile(String categoriesNames) {
        try{
            File file = new File("categoriesNames.txt");

            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(categoriesNames);
            file.getAbsolutePath();
            bw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
