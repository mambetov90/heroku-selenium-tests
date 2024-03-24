package example.example.tests;

import org.junit.jupiter.api.DisplayName;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


@Test(testName = "Heroku login test", description = "Heroku login test")
public class HerokuLoginTest extends BaseTest {

    @BeforeClass
    public void open() {
        driver.get("https://the-internet.herokuapp.com/login");
        Assert.assertEquals(herokuLoginPage.getTitle(), "Login Page");
    }

    @DisplayName("Login to the Heroku website with the valid credentials")
    @Test
    public void herokuLoginWithValidCredentialsTest() {
        herokuLoginPage.enterUsername("tomsmith").enterPassword("SuperSecretPassword!").clickSignIn();
        Assert.assertEquals(herokuLogoutPage.getFlashMessage(), "You logged into a secure area!\n" +
                "×");
    }

    @DisplayName("Login to the Heroku website with the invalid credentials")
    @Test
    public void herokuLoginWithInvalidCredentialsTest() {
        herokuLoginPage.enterUsername("tomyam").enterPassword("SuperSecretPassword!").clickSignIn();
        Assert.assertEquals(herokuLoginPage.getFlashMessage(), "Your username is invalid!\n" +
                "×");
    }
}
