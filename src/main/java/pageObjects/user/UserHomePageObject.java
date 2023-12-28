package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class UserHomePageObject extends BasePage {
    WebDriver driver;
    public UserHomePageObject (WebDriver driver){
        super(driver);
        this.driver = driver;
    }

}
