package example.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HerokuLogOutPage extends BasePage {

    /**
     * Login button.
     */
    @FindBy(css = ".button")
    private WebElement logout;

    /**
     * Title.
     */
    @FindBy(id = "flash-messages")
    private WebElement flashMsg;

    /**
     * Instantiates a new Heroku logout page.
     */
    public HerokuLogOutPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Click logout.
     */
    public void clickLogout() {
        logout.click();
    }

    /**
     * Get login page title.
     */
    public String getFlashMessage() {
        return flashMsg.getText();
    }
}
