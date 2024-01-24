package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.user.UserShoppingCartPageUI;

public class UserShoppingCartPageObject extends BasePage {
    public UserShoppingCartPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isProductAddedToShoppingCart(String productName) {
        waitForElementVisible(UserShoppingCartPageUI.PRODUCT_NAME, productName);
        return isElementDisplayed(UserShoppingCartPageUI.PRODUCT_NAME, productName);
    }

    public UserDetailProductPageObject clickEditProductLink() {
        waitForElementClickable(UserShoppingCartPageUI.EDIT_PRODUCT_LINK);
        clickToElement(UserShoppingCartPageUI.EDIT_PRODUCT_LINK);
        return PageGeneratorManager.getUserDetailProductPage(driver);
    }

    public void clickRemoveProductButton() {
        waitForElementClickable(UserShoppingCartPageUI.REMOVE_PRODUCT_BUTTON);
        clickToElement(UserShoppingCartPageUI.REMOVE_PRODUCT_BUTTON);
    }

    public Object getNoProductMessage() {
        waitForElementVisible(UserShoppingCartPageUI.NO_DATA_MESSAGE);
        return getElementText(UserShoppingCartPageUI.NO_DATA_MESSAGE);
    }

    public boolean isUndisplayedProductNameLink(String productName) {
        return isElementUndisplayed(UserShoppingCartPageUI.PRODUCT_NAME, productName);
    }

    public void clickToEstimateShippingButton() {
        waitForElementClickable(UserShoppingCartPageUI.ESTIMATE_SHIPPING_BUTTON);
        clickToElement(UserShoppingCartPageUI.ESTIMATE_SHIPPING_BUTTON);
    }

    public void selectCountryDropDownByName(String countryName) {
        waitForElementVisible(UserShoppingCartPageUI.COUNTRY_DROPDOWN);
        selectItemInDefaultDropDown(UserShoppingCartPageUI.COUNTRY_DROPDOWN, countryName);
    }

    public void inputToZipPostalCodeTextbox(String number) {
        waitForElementVisible(UserShoppingCartPageUI.ZIP_CODE_TEXTBOX);
        sendKeyToElement(UserShoppingCartPageUI.ZIP_CODE_TEXTBOX, number);
    }

    public void clickToRadioButtonByName(String nameLabel) {
        waitForElementUndisplayed(UserShoppingCartPageUI.SHIPPING_LOADING_ICON);
        waitForElementClickable(UserShoppingCartPageUI.SHIP_METHOD_RADIO_BY_NAME, nameLabel);
        clickToElementByJS(UserShoppingCartPageUI.SHIP_METHOD_RADIO_BY_NAME, nameLabel);
    }

    public void clickApplyButton() {
        waitForElementClickable(UserShoppingCartPageUI.APPLY_BUTTON);
        clickToElement(UserShoppingCartPageUI.APPLY_BUTTON);
        waitForElementInvisible(UserShoppingCartPageUI.LOADING_PAGE_ICON);
    }

    public String getSKUProduct() {
        waitForElementVisible(UserShoppingCartPageUI.SKU_PRODUCT);
        return getElementText(UserShoppingCartPageUI.SKU_PRODUCT);
    }

    public String getGiftWrappingText() {
        waitForElementVisible(UserShoppingCartPageUI.GIFT_WRAPPING_STATUS);
        return getElementText(UserShoppingCartPageUI.GIFT_WRAPPING_STATUS).trim();
    }

    public String getShippingMethodValue() {
        waitForElementVisible(UserShoppingCartPageUI.SHIPPING_METHOD_INFOR);
        return getElementText(UserShoppingCartPageUI.SHIPPING_METHOD_INFOR).replaceAll("[()]", "");
    }

    public String getPriceByLabelName(String labelName) {
        waitForElementVisible(UserShoppingCartPageUI.CART_PRICE_BY_LABEL_NAME, labelName);
        return getElementText(UserShoppingCartPageUI.CART_PRICE_BY_LABEL_NAME, labelName);
    }

    public String getTotalBillPrice() {
        waitForElementVisible(UserShoppingCartPageUI.CART_PRICE_TOTAL);
        return getElementText(UserShoppingCartPageUI.CART_PRICE_TOTAL);
    }

    public void clickToLegalCheckbox() {
        waitForElementClickable(UserShoppingCartPageUI.LEGAL_CHECKBOX);
        clickToDefautCheckboxOrRadio(UserShoppingCartPageUI.LEGAL_CHECKBOX);
    }

    public UserCheckoutPageObject clickToCheckoutButton() {
        waitForElementClickable(UserShoppingCartPageUI.CHECKOUT_BUTTON);
        clickToElement(UserShoppingCartPageUI.CHECKOUT_BUTTON);
        return PageGeneratorManager.getUserCheckoutPage(driver);
    }
}
