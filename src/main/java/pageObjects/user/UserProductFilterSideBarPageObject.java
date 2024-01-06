package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class UserProductFilterSideBarPageObject extends BasePage {
    WebDriver driver;
    public UserProductFilterSideBarPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

}
