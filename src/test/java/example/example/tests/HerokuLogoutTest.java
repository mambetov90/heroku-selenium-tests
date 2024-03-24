package example.example.tests;

import org.junit.jupiter.api.DisplayName;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


@Test(testName = "Heroku logout test", description = "Logout from the Heroku logout form")
public class HerokuLogoutTest extends BaseTest {

    @BeforeClass
    public void open() {
        driver.get("https://the-internet.herokuapp.com/login");
        Assert.assertEquals(herokuLoginPage.getTitle(), "Login Page");
        herokuLoginPage.enterUsername("tomsmith").enterPassword("SuperSecretPassword!").clickSignIn();
    }

    @DisplayName("Logout from the Heroku website")
    @Test
    public void herokuLogoutTest() {
        herokuLogoutPage.clickLogout();
        Assert.assertEquals(herokuLoginPage.getFlashMessage(), "You logged out of the secure area!\n" +
                "×");
    }
}
