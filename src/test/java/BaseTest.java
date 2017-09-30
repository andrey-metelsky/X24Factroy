import client.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class BaseTest {

    protected WebDriver getWebDriver() {
        return DriverFactory.getInstance().getWebDriver();
    }

    @AfterClass(groups = {"init"}, alwaysRun = true)
    public void afterClassStop() {
        DriverFactory.getInstance().tearDown();
    }
}