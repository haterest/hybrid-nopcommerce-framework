package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.user.UserWishListPageUI;

public class UserWishListPageObject extends BasePage {
    public UserWishListPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isProductNameAdded(String productName) {
        waitForElementVisible(UserWishListPageUI.PRODUCT_NAME_LINK, productName);
        return isElementDisplayed(UserWishListPageUI.PRODUCT_NAME_LINK, productName);
    }

    public void clickToWishListShareLink() {
        waitForElementClickable(UserWishListPageUI.WISHLIST_SHARE_LINK);
        clickToElement(UserWishListPageUI.WISHLIST_SHARE_LINK);
    }

    public Object getUserWishListTitle() {
        waitForElementVisible(UserWishListPageUI.USER_WISHLIST_PAGE_TITLE);
        return getElementText(UserWishListPageUI.USER_WISHLIST_PAGE_TITLE);
    }

    public void clickToAddToCartCheckBox() {
        waitForElementClickable(UserWishListPageUI.ADD_TO_CART_CHECKBOX);
        clickToDefautCheckboxOrRadio(UserWishListPageUI.ADD_TO_CART_CHECKBOX);
    }

    public UserShoppingCartPageObject clickToAddToCartButton() {
        waitForElementClickable(UserWishListPageUI.ADD_TO_CART_BUTTON);
        clickToElement(UserWishListPageUI.ADD_TO_CART_BUTTON);
        return PageGeneratorManager.getUserShoppingCartPage(driver);
    }

    public Object getWishListMessage() {
        waitForElementVisible(UserWishListPageUI.WISHLIST_PAGE_MESSAGE);
        return getElementText(UserWishListPageUI.WISHLIST_PAGE_MESSAGE);
    }

    public void clickToRemoveIconByProductName(String productName) {
        waitForElementClickable(UserWishListPageUI.REMOVE_BUTTON_BY_PRODUCT_NAME, productName);
        clickToElement(UserWishListPageUI.REMOVE_BUTTON_BY_PRODUCT_NAME, productName);
    }
}
