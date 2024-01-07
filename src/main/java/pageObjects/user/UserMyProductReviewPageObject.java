package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.user.UserMyProductReviewPageUI;

public class UserMyProductReviewPageObject extends BasePage {
    public UserMyProductReviewPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public Object getReviewTitleText() {
        waitForElementVisible(UserMyProductReviewPageUI.REVIEW_PRODUCT_TITLE);
        return getElementText(UserMyProductReviewPageUI.REVIEW_PRODUCT_TITLE);
    }

    public Object getReviewContentText() {
        waitForElementVisible(UserMyProductReviewPageUI.REVIEW_PRODUCT_CONTENT);
        return getElementText(UserMyProductReviewPageUI.REVIEW_PRODUCT_CONTENT);
    }

    public Object getReviewProductName() {
        waitForElementVisible(UserMyProductReviewPageUI.REVIEW_PRODUCT_NAME_LINK);
        return getElementText(UserMyProductReviewPageUI.REVIEW_PRODUCT_NAME_LINK);
    }
}
