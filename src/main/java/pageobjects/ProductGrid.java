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

    public ProductGrid verifyQuantityOfProductsPerPage(int quantityOfProducts) {
        assertEquals(productBoxes.size(), quantityOfProducts);
        return this;
    }

    public ProductGrid verifyPaginationInfo(String pagInfo) {
        assertTrue(paginationInfo.getText().contains(pagInfo));
        return this;
    }

    public ProductGrid clickButtonMoreProducts() {
        click(btnMoreProducts);
        return this;
    }

    public ProductGrid clickButtonNext() {
        click(btnMoreProducts);
        return this;
    }

    public List<String> getProductsNames(int qtyOfCategories) {
        List<String> productsNames = productBoxes.subList(0, qtyOfCategories).stream().map(ProductBox::getProductName).collect(Collectors.toList());
        return productsNames;
    }
}
