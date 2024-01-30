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

    public void selectCategoryDropdown(String nameCategory) {
        waitForElementVisible(AdminProductsPageUI.CATEGORY_DROPDOWN);
        selectItemInDefaultDropDown(AdminProductsPageUI.CATEGORY_DROPDOWN, nameCategory);
    }

    public void clickToSubCategoriesCheckbox() {
        waitForElementClickable(AdminProductsPageUI.SUB_CATEGORIES_CHECKBOX);
        clickToDefautCheckboxOrRadio(AdminProductsPageUI.SUB_CATEGORIES_CHECKBOX);
    }

    public void selectManufacturerDropdown(String manufacturerName) {
        waitForElementVisible(AdminProductsPageUI.MANUFACTURER_DROPDOWN);
        selectItemInDefaultDropDown(AdminProductsPageUI.MANUFACTURER_DROPDOWN, manufacturerName);
    }

    public Object getNoDataMessage() {
        waitForElementVisible(AdminProductsPageUI.NO_DATA_TABLE_MESSAGE);
        return getElementText(AdminProductsPageUI.NO_DATA_TABLE_MESSAGE);
    }

    public void inputToDirectlyProductSKUTextbox(String productSKU) {
        waitForElementVisible(AdminProductsPageUI.DIRECTLY_PRODUCT_SKU_TEXTBOX);
        sendKeyToElement(AdminProductsPageUI.DIRECTLY_PRODUCT_SKU_TEXTBOX, productSKU);
    }

    public void clickGoButton() {
        waitForElementClickable(AdminProductsPageUI.GO_PRODUCT_SKU_BUTTON);
        clickToElement(AdminProductsPageUI.GO_PRODUCT_SKU_BUTTON);
        waitForElementInvisible(AdminProductsPageUI.LOADING_ICON);
    }

    public boolean isDisplayedProductDetailsTitle(String productName) {
        waitForElementVisible(AdminProductsPageUI.PRODUCT_DETAIL_TITLE_BY_NAME, productName);
        return isElementDisplayed(AdminProductsPageUI.PRODUCT_DETAIL_TITLE_BY_NAME, productName);
    }

    public Object getProductNameTextbox() {
        waitForElementVisible(AdminProductsPageUI.DETAIL_PRODUCT_NAME_TEXTBOX);
        return getElementAttribute(AdminProductsPageUI.DETAIL_PRODUCT_NAME_TEXTBOX, "value");
    }

    public Object getSKUProductTextbox() {
        waitForElementVisible(AdminProductsPageUI.DETAIL_SKU_TEXTBOX);
        return getElementAttribute(AdminProductsPageUI.DETAIL_SKU_TEXTBOX, "value");
    }
}
