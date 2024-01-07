package pageObjects.user;

import org.openqa.selenium.WebDriver;
import pageUIs.user.UserChangePasswordPageUI;

public class UserChangePasswordPageObject extends UserMyAccountSideBarPageObject{
    public UserChangePasswordPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void inputToOldPasswordTextbox(String password) {
        waitForElementVisible(UserChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
        sendKeyToElement(UserChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, password);
    }

    public void inputToNewPasswordTextbox(String newPassword) {
        waitForElementVisible(UserChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
        sendKeyToElement(UserChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, newPassword);
    }

    public void inputToConfirmPasswordTextbox(String newPassword) {
        waitForElementVisible(UserChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(UserChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX, newPassword);
    }

    public void clickToChangePasswordButton() {
        waitForElementClickable(UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
        clickToElement(UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
    }

    public Object getSuccessfulMessageDisplayed() {
        waitForElementVisible(UserChangePasswordPageUI.SUCCESSFUL_MESSAGE);
        return getElementText(UserChangePasswordPageUI.SUCCESSFUL_MESSAGE);
    }


    public void closeSuccessfulMessage() {
        waitForElementClickable(UserChangePasswordPageUI.CLOSE_SUCCESSFUL_MESSAGE_BUTTON);
        clickToElement(UserChangePasswordPageUI.CLOSE_SUCCESSFUL_MESSAGE_BUTTON);
        waitForElementUndisplayed(UserChangePasswordPageUI.CLOSE_SUCCESSFUL_MESSAGE_BUTTON);
    }

}
