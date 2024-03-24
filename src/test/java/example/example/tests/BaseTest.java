package example.example.tests;

import example.example.context.WebDriverContext;
import example.example.factory.PageinstancesFactory;

import example.example.pages.HerokuLogOutPage;
import example.example.pages.HerokuLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

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
        WebDriverManager.chromedriver().setup();
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("disable-infobars");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverContext.setDriver(driver);

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
