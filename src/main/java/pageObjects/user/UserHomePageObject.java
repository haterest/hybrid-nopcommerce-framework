package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.user.UserHomePageUI;

public class UserHomePageObject extends BasePage {
    public UserHomePageObject (WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(UserHomePageUI.MY_ACCOUNT_LINK_MENU);
        return isElementDisplayed(UserHomePageUI.MY_ACCOUNT_LINK_MENU);
    }




}
