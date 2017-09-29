package client;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobjects.BasePage;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.currentThread;
import static org.apache.logging.log4j.LogManager.getLogger;
import static org.testng.Assert.assertEquals;

public class DriverFactory {

    private WebDriver webDriver;

    public static final int TIME_WAIT_SECONDS = 30;
    private static DriverFactory instance = new DriverFactory();
    private static final Logger LOGGER = getLogger(DriverFactory.class);

    public static DriverFactory getInstance() {
        return instance;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void setDriver(String browserType, String appURL) {
      try {
            switch (browserType) {
                case "chrome":
                    webDriver = startChrome(appURL);
                    break;
                case "firefox":
                    webDriver = startFirefox(appURL);
                    break;
                default:
                    webDriver = startChrome(appURL);
                    break;
            }
        } catch (Exception e) {
            LOGGER.error("", e);
        }
    }

    private static WebDriver startChrome(String appURL) {
        String chromedriverPath = currentThread().getContextClassLoader().getResource("chromedriver.exe").getPath();
        System.setProperty("webdriver.chrome.driver", chromedriverPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        return driver;
    }

    private static WebDriver startFirefox(String appURL) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        return driver;
    }
}
