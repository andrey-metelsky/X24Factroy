package pageobjects;

import client.DriverFactory;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import static org.apache.logging.log4j.LogManager.getLogger;

public class BasePage extends HtmlElement{

    protected WebDriver webDriver = DriverFactory.getInstance().getWebDriver();
    private WebDriverWait webDriverWait = new WebDriverWait(this.webDriver, DriverFactory.TIME_WAIT_SECONDS);

    protected static final Logger LOGGER = getLogger(BasePage.class);
    protected static final By progressBar = By.cssSelector("#progress");

    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    public BasePage() {
        PageFactory.initElements(new HtmlElementDecorator( new HtmlElementLocatorFactory(webDriver)), this);
    }

    public void sendKeys(final WebElement webElement, String text) {
        waitForClickable(webElement);
        webElement.clear();
        webElement.sendKeys(text);
    }

    public WebElement waitForVisibility(WebElement webElement) {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        } catch ( NoSuchElementException nse ) {
            LOGGER.error("", nse);
            return null;
        }
        return webElement;
    }

    public void waitForInvisibility(By locator) {
        try {
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch ( NoSuchElementException e ) {
            LOGGER.error("", e);
        }
    }

    public WebElement waitForClickable(WebElement webElement) {
        waitForVisibility(webElement);
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch ( NoSuchElementException nse ) {
            LOGGER.error("Try to wait little more (wait for clickable)", nse);
        }
        return webElement;
    }

    public void pressEnter(final WebElement webElement) {
        waitForClickable(webElement);
        webElement.sendKeys(Keys.ENTER);
    }

    public void click(WebElement webElement) {
        safeClick(webElement);
    }

    private void safeClick(WebElement webElement) {
        waitForClickable(webElement);
        pureSafeClick(webElement);
    }

    private void pureSafeClick(WebElement webElement) {
        for (int i = 0; i < 10; i++) {
            try {
                webElement.click();
                break;
            } catch ( Exception e ) {
                LOGGER.error("Click failed", e);
                pause();
            }
        }
    }

    public boolean isElementPresent(final WebElement we) {
        webDriver.getPageSource();
        try {
            return we.isDisplayed();
        } catch ( Exception e ) {
            LOGGER.error("Element is not displayed", e);
            return false;
        }
    }

    public void pause() {
        try {
            Thread.sleep(5000);
        } catch ( InterruptedException e ) {
            LOGGER.error("", e);
        }
    }
}