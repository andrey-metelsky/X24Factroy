import client.DriverFactory;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver webDriver = DriverFactory.getInstance().getWebDriver();

    public void setDriver (String browserType, String appURL) {
        DriverFactory.getInstance().setDriver(browserType, appURL);
    }

    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    public void tearDown() {
        DriverFactory.getInstance().getWebDriver().quit();
    }
}