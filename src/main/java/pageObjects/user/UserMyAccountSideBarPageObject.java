package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.user.UserMyAccountSideBarPageUI;

public class UserMyAccountSideBarPageObject extends BasePage {
    WebDriver driver;
    public UserMyAccountSideBarPageObject (WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public UserChangePasswordPageObject clickToChangePasswordPage() {
        waitForElementClickable(UserMyAccountSideBarPageUI.CHANGE_PASSWORD_LINK);
        clickToElement(UserMyAccountSideBarPageUI.CHANGE_PASSWORD_LINK);
        return PageGeneratorManager.getUserChangePasswordPage(driver);
    }

    public UserAddressesPageObject clickToAddressesPage() {
        waitForElementClickable(UserMyAccountSideBarPageUI.ADDRESSES_LINK);
        clickToElement(UserMyAccountSideBarPageUI.ADDRESSES_LINK);
        return PageGeneratorManager.getUserAddressesPage(driver);
    }
}
