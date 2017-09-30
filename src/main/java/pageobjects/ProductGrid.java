package pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.blocks.rows.ProductBox;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductGrid extends BasePage {

    @FindBy(css = ".pagiInfo")
    private WebElement paginationInfo;

    @FindBy(css = "#mehrProduckttezeigen_btn")
    private WebElement btnMoreProducts;

    @FindBy(css = ".btnNext i")
    private WebElement btnNext;

    List<ProductBox> productBoxes;

    public ProductGrid verifyQuantityOfProductsPerPage(String quantityOfProducts) {
        LOGGER.info("Verifying that quantity of products is " + quantityOfProducts);
        assertEquals(productBoxes.size(), Integer.parseInt(quantityOfProducts), "Quantity of products is not expected.");
        return this;
    }

    public ProductGrid verifyPaginationInfo(String pagInfo) {
        LOGGER.info("Verifying pagination info");
        assertTrue(paginationInfo.getText().contains(pagInfo), "Pagination info is not expected.");
        return this;
    }

    public ProductGrid clickButtonMoreProducts() {
        LOGGER.info("Clicking button More Products");
        click(btnMoreProducts);
        return this;
    }

    public ProductGrid clickButtonNext() {
        LOGGER.info("Clicking button Next");
        click(btnMoreProducts);
        return this;
    }

    public List<String> getProductsNames(int qtyOfProducts) {
        LOGGER.info("Collecting names of first " + qtyOfProducts + " products.");
        List<String> productsNames = productBoxes.subList(0, qtyOfProducts).stream().map(ProductBox::getProductName).collect(Collectors.toList());
        return productsNames;
    }
}
