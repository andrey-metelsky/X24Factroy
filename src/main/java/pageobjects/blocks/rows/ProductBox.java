package pageobjects.blocks.rows;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.BasePage;

@FindBy(css = ".productBoxSec-mbl")
public class ProductBox extends BasePage {

    @FindBy(css = ".productNameSec-mbl")
    private WebElement productName;

    public String getProductName() {
        LOGGER.info("Getting product name.");
        return productName.getText();
    }
}
