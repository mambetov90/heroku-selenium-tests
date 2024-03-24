package example.example.tests;

import example.example.context.WebDriverContext;
import example.example.enums.Browser;
import example.example.factory.PageinstancesFactory;

import example.example.factory.WebDriverFactory;
import example.example.pages.HerokuLogOutPage;
import example.example.pages.HerokuLoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class BaseTest {

    /**
     * The driver.
     */
    protected WebDriver driver;

    /**
     * Instanced classes.
     */
    HerokuLoginPage herokuLoginPage;

    HerokuLogOutPage herokuLogoutPage;

    /**
     * Global info.
     */
    @BeforeSuite(alwaysRun = true)
    public void globalLogInfo() {
        log.info("************************** Test Execution Started ************************************");
    }

    /**
     * Setup.
     */
    @BeforeClass
    protected void setup() {

        List<Browser> browsers = Arrays.asList(Browser.CHROME, Browser.EDGE, Browser.FIREFOX);
        driver = null;

        for (Browser browser : browsers) {
            try {
                driver = WebDriverFactory.createWebDriver(browser);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                WebDriverContext.setDriver(driver);
                if (driver != null) {
                    break;
                }
            } catch (Exception e) {
                log.error("Failed to create WebDriver for " + browser + ": " + e.getMessage());
            }
        }

        if (driver == null) {
            throw new RuntimeException("Unable to create WebDriver instance for any browser");
        }

        herokuLoginPage = PageinstancesFactory.getInstance(HerokuLoginPage.class);
        herokuLogoutPage = PageinstancesFactory.getInstance(HerokuLogOutPage.class);
    }

    /**
     * Tear down.
     */
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
            WebDriverContext.removeDriver();

        }
    }
}
