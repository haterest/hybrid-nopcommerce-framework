package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.user.UserLoginPageUI;
import pageUIs.user.UserRegisterPageUI;

public class UserLoginPageObject extends BasePage {
    WebDriver driver;
    public UserLoginPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void clickToLoginButton() {
        waitForElementVisible(UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(UserLoginPageUI.LOGIN_BUTTON);
    }

    public Object getEmailErrorMessage() {
        waitForElementVisible(UserLoginPageUI.ERROR_EMAIL_TEXTBOX);
        return getElementText(UserLoginPageUI.ERROR_EMAIL_TEXTBOX);
    }

    public void inputToEmailTextbox(String emailAdrress) {
        waitForElementVisible(UserLoginPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(UserLoginPageUI.EMAIL_TEXTBOX, emailAdrress);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(UserLoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(UserLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public Object getAccountErrorMessage() {
        waitForElementVisible(UserLoginPageUI.ERROR_ACCOUNT_MESSAGE);
        return getElementText(UserLoginPageUI.ERROR_ACCOUNT_MESSAGE);
    }
}
