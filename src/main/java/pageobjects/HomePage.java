package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.blocks.rows.CategoryMenu;

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
