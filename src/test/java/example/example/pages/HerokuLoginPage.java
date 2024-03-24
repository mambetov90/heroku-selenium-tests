package example.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HerokuLoginPage extends BasePage {

    /**
     * The email input.
     */
    @FindBy(id = "username")
    private WebElement userName;

    /**
     * The pass.
     */
    @FindBy(id = "password")
    private WebElement pass;

    /**
     * Login button.
     */
    @FindBy(css = "#login > button[type='submit']")
    private WebElement loginBtn;

    /**
     * Title.
     */
    @FindBy(css = ".example > h2")
    private WebElement titleName;

    /**
     * Title.
     */
    @FindBy(id = "flash-messages")
    private WebElement flashMsg;

    /**
     * Instantiates a new Heroku login page.
     */
    public HerokuLoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Enter username.
     *
     * @param username the username
     */
    public HerokuLoginPage enterUsername(String username) {
        userName.sendKeys(username);
        return this;
    }

    /**
     * Enter password.
     *
     * @param password the password
     */
    public HerokuLoginPage enterPassword(String password) {
        pass.sendKeys(password);
        return this;
    }

    /**
     * Click login.
     */
    public void clickSignIn() {
        loginBtn.submit();
    }

    /**
     * Get login page title.
     */
    public String getTitle() {
        return titleName.getText();
    }

    /**
    * Get login flash message.
     * */
    public String getFlashMessage() {
        return flashMsg.getText();
    }
}
