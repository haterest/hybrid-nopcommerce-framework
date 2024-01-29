package pageObjects.admin;

import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminProductsPageUI;

public class AdminProductsPageObject extends AdminLeftSideBarPageObject{
    public AdminProductsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputToProductNameTextbox(String productName) {
        waitForElementVisible(AdminProductsPageUI.PRODUCT_NAME_TEXTBOX);
        sendKeyToElement(AdminProductsPageUI.PRODUCT_NAME_TEXTBOX, productName);
    }

    public void clickToSearchButton() {
        waitForElementClickable(AdminProductsPageUI.SEARCH_BUTTON);
        clickToElement(AdminProductsPageUI.SEARCH_BUTTON);
        waitForElementInvisible(AdminProductsPageUI.LOADING_ICON);
    }

    public Object getProductInforByLabelName(String labelName) {
        int columnIndex = getElementsSize(AdminProductsPageUI.COLUMN_INDEX_BY_LABEL_NAME, labelName) + 1;
        waitForElementVisible(AdminProductsPageUI.PRODUCT_INFOR_BY_COLUMN_INDEX, String.valueOf(columnIndex));
        return getElementText(AdminProductsPageUI.PRODUCT_INFOR_BY_COLUMN_INDEX, String.valueOf(columnIndex));
    }

    public Object getSizeProductName(String productName) {
        waitForAllElementsVisible(AdminProductsPageUI.PRODUCT_NAME, productName);
        return getElementsSize(AdminProductsPageUI.PRODUCT_NAME, productName);
    }

    public boolean isPublishedSuccessDisplayByLabelName(String publishedLabel) {
        int columnIndex = getElementsSize(AdminProductsPageUI.COLUMN_INDEX_BY_LABEL_NAME, publishedLabel) + 1;
        waitForElementVisible(AdminProductsPageUI.PUBLISHED_ICON_BY_COLUMN_INDEX, String.valueOf(columnIndex));
        return isElementDisplayed(AdminProductsPageUI.PUBLISHED_ICON_BY_COLUMN_INDEX, String.valueOf(columnIndex));
    }
}
