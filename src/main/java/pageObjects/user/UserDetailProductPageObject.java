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
}
