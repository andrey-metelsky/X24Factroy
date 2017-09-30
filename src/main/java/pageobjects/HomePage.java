package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.BasePage;
import pageobjects.blocks.rows.CategoryMenu;

import static data.Parameters.SITEURL;

public class HomePage extends BasePage {

    @FindBy(css = "[data-nav-menu-btn]")
    private WebElement categoryMenuBtn;

    public CategoryMenu openCategoryMenu() {
        LOGGER.info("Opening category menu.");
        click(categoryMenuBtn);
        waitForVisibility(categoryMenuBtn);
        return new CategoryMenu();
    }
}
