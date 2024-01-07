package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.user.UserProductReviewPageUI;

public class UserProductReviewPageObject extends BasePage {
    public UserProductReviewPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputToReviewTextTextArea(String reviewContent) {
        waitForElementVisible(UserProductReviewPageUI.REVIEW_CONTENT_TEXTAREA);
        sendKeyToElement(UserProductReviewPageUI.REVIEW_CONTENT_TEXTAREA, reviewContent);
    }

    public void inputToReviewTitleTextbox(String reviewTitle) {
        waitForElementVisible(UserProductReviewPageUI.REVIEW_TITLE_TEXTBOX);
        sendKeyToElement(UserProductReviewPageUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
    }

    public void clickToSubmitReviewButton() {
        waitForElementClickable(UserProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
        clickToElement(UserProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
    }

    public boolean isSuccessfulReviewMessageDisplayed(String successfulMessage) {
        waitForElementVisible(UserProductReviewPageUI.SUCCESSFUL_REVIEW_PRODUCT_MESSAGE, successfulMessage);
        return isElementDisplayed(UserProductReviewPageUI.SUCCESSFUL_REVIEW_PRODUCT_MESSAGE, successfulMessage);
    }

    public Object getReviewTitleText() {
        waitForElementVisible(UserProductReviewPageUI.REVIEW_PRODUCT_TITLE);
        return getElementText(UserProductReviewPageUI.REVIEW_PRODUCT_TITLE);
    }

    public Object getReviewContentText() {
        waitForElementVisible(UserProductReviewPageUI.REVIEW_PRODUCT_CONTENT);
        return getElementText(UserProductReviewPageUI.REVIEW_PRODUCT_CONTENT);
    }
}
