package pageobjects.blocks.rows;

import data.CategoryName;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import pageobjects.BasePage;
import pageobjects.ProductGrid;

@FindBy(css = "[data-nav-menu]")
public class CategoryMenu extends BasePage {

    public ProductGrid openCategoryByName(CategoryName categoryName) {
        LOGGER.info("Opening category with name: " + categoryName);
        getWebDriver().findElement(By.linkText(categoryName.getValue())).click();
        return new ProductGrid();
    }
}
