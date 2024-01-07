package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
    public UserRegisterPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void clickToRegisterButton() {
        waitForElementClickable(UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(UserRegisterPageUI.REGISTER_BUTTON);
    }

    public Object getErrorMessageBelowTextboxById(String idTextbox) {
        waitForElementVisible(UserRegisterPageUI.ERROR_MESSAGE_BY_ID, idTextbox);
        return getElementText(UserRegisterPageUI.ERROR_MESSAGE_BY_ID, idTextbox);
    }

    public void inputToTextboxById(String idTextbox, String textToTextbox) {
        waitForElementVisible(UserRegisterPageUI.TEXTBOX_BY_ID, idTextbox);
        sendKeyToElement(UserRegisterPageUI.TEXTBOX_BY_ID, textToTextbox, idTextbox);
    }

    public Object getRegisterSuccesfulMessage() {
        waitForElementVisible(UserRegisterPageUI.SUCCESSFUL_REGISTER_MESSAGE);
        return getElementText(UserRegisterPageUI.SUCCESSFUL_REGISTER_MESSAGE);
    }

    public boolean isErrorMessageEmailAlreadyExists(String emailAlreadyExists) {
        waitForElementVisible(UserRegisterPageUI.ERROR_MESSAGE_EMAIL_ALREADY_EXISTS, emailAlreadyExists);
        return isElementDisplayed(UserRegisterPageUI.ERROR_MESSAGE_EMAIL_ALREADY_EXISTS, emailAlreadyExists);
    }
}
