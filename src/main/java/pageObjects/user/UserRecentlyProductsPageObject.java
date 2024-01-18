package pageObjects.user;

import org.openqa.selenium.WebDriver;
import pageUIs.user.UserRecentlyProductsPageUI;

public class UserRecentlyProductsPageObject extends UserFooterPageObject{
    public UserRecentlyProductsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isDisplayedProductByName(String productName) {
        waitForElementVisible(UserRecentlyProductsPageUI.PRODUCT_NAME_LINK, productName);
        return isElementDisplayed(UserRecentlyProductsPageUI.PRODUCT_NAME_LINK, productName);
    }
}
