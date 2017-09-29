package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.BasePage;
import pageobjects.blocks.rows.CategoryMenu;

public class HomePage extends BasePage {

    @FindBy(css = "[data-nav-menu-btn]")
    private WebElement categoryMenuBtn;

    public CategoryMenu openCategoryMenu() {
        click(categoryMenuBtn);
        return new CategoryMenu();
    }
}
