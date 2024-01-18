package pageObjects.user;

import org.openqa.selenium.WebDriver;
import pageUIs.user.UserCompareProductsPageUI;

public class UserCompareProductsPageObject extends UserFooterPageObject {
    public UserCompareProductsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isDisplayedNameByProductName(String productName) {
        int columnIndex = getElementsSize(UserCompareProductsPageUI.COLUM_INDEX_BY_NAME, productName) + 1;
        waitForElementVisible(UserCompareProductsPageUI.NAME_PRODUCT_BY_COLUM_INDEX, String.valueOf(columnIndex));
        return isElementDisplayed(UserCompareProductsPageUI.NAME_PRODUCT_BY_COLUM_INDEX, String.valueOf(columnIndex));
    }

    public boolean isDisplayedRemoveButtonByProductName(String productName) {
        int columnIndex = getElementsSize(UserCompareProductsPageUI.COLUM_INDEX_BY_NAME, productName) + 1;
        waitForElementVisible(UserCompareProductsPageUI.REMOVE_BUTTON_BY_COLUM_INDEX, String.valueOf(columnIndex));
        return isElementDisplayed(UserCompareProductsPageUI.REMOVE_BUTTON_BY_COLUM_INDEX, String.valueOf(columnIndex));
    }

    public boolean isDisplayedPriceByProductName(String productName) {
        int columnIndex = getElementsSize(UserCompareProductsPageUI.COLUM_INDEX_BY_NAME, productName) + 1;
        waitForElementVisible(UserCompareProductsPageUI.PRICE_PRODUCT_BY_COLUM_INDEX, String.valueOf(columnIndex));
        return isElementDisplayed(UserCompareProductsPageUI.PRICE_PRODUCT_BY_COLUM_INDEX, String.valueOf(columnIndex));
    }

    public void clickClearListButton() {
        waitForElementClickable(UserCompareProductsPageUI.CLEAR_LIST_BUTTON);
        clickToElement(UserCompareProductsPageUI.CLEAR_LIST_BUTTON);
    }

    public Object getProductCompareMessage() {
        waitForElementVisible(UserCompareProductsPageUI.NO_COMPARE_PRODUCT_MESSAGE);
        return getElementText(UserCompareProductsPageUI.NO_COMPARE_PRODUCT_MESSAGE);
    }

    public boolean isUndisplayProductByName(String productName) {
        return isElementUndisplayed(UserCompareProductsPageUI.PRODUCT_NAME_LINK_BY_NAME, productName);
    }
}
