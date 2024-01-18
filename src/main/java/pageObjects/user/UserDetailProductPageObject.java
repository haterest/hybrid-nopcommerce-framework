package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.user.UserDetailProductPageUI;

public class UserDetailProductPageObject extends BasePage {
    public UserDetailProductPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public UserProductReviewPageObject clickToAddYourReviewLink() {
        waitForElementClickable(UserDetailProductPageUI.ADD_YOUR_REVIEW_LINK);
        clickToElement(UserDetailProductPageUI.ADD_YOUR_REVIEW_LINK);
        return PageGeneratorManager.getUserProductReviewPage(driver);
    }

    public void clickToAddToWishListButton() {
        waitForElementClickable(UserDetailProductPageUI.ADD_TO_WISHLIST_BUTTON);
        clickToElement(UserDetailProductPageUI.ADD_TO_WISHLIST_BUTTON);
    }

    public Object getSuccessfulMessageDisplayed() {
        waitForElementVisible(UserDetailProductPageUI.SUCCESSFULL_MESSAGE);
        return getElementText(UserDetailProductPageUI.SUCCESSFULL_MESSAGE);
    }

    public void closeSuccessfulMessage() {
        waitForElementClickable(UserDetailProductPageUI.CLOSE_SUCCESSFULL_MESSAGE_ICON);
        clickToElement(UserDetailProductPageUI.CLOSE_SUCCESSFULL_MESSAGE_ICON);
        waitForElementUndisplayed(UserDetailProductPageUI.CLOSE_SUCCESSFULL_MESSAGE_ICON);
    }

    public UserNotebooksPageObject backToNotebooksProductPage() {
        backToPage();
        return PageGeneratorManager.getUserNotebooksPage(driver);
    }
}
