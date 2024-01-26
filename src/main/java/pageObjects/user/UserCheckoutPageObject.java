package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.user.UserCheckOutPageUI;

public class UserCheckoutPageObject extends BasePage{
    public UserCheckoutPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void unclickShipToSameAddressCheckbox() {
        waitForElementClickable(UserCheckOutPageUI.SHIP_TO_SAME_ADDRESS_CHECKBOX);
        unClickToDefaultCheckbox(UserCheckOutPageUI.SHIP_TO_SAME_ADDRESS_CHECKBOX);
    }

    public void inputToTextBoxByID(String textboxID, String keyToSend) {
        waitForElementVisible(UserCheckOutPageUI.TEXTBOX_BY_ID, textboxID);
        sendKeyToElement(UserCheckOutPageUI.TEXTBOX_BY_ID, keyToSend, textboxID);
    }

    public void selectDropdownByIDAndName(String dropdownID, String countryName) {
        waitForElementVisible(UserCheckOutPageUI.DROPDOWN_BY_ID, dropdownID);
        selectItemInDefaultDropDown(UserCheckOutPageUI.DROPDOWN_BY_ID, countryName, dropdownID);
    }

    public void clickButtonByID(String buttonID) {
        waitForElementClickable(UserCheckOutPageUI.CONTINUE_BUTTON_BY_PARENT_ID, buttonID);
        clickToElement(UserCheckOutPageUI.CONTINUE_BUTTON_BY_PARENT_ID, buttonID);
    }

    public void clickRadioButtonByLabel(String labelName) {
        waitForElementClickable(UserCheckOutPageUI.RADIO_BUTTON_BY_LABEL, labelName);
        clickToDefautCheckboxOrRadio(UserCheckOutPageUI.RADIO_BUTTON_BY_LABEL, labelName);
    }

    public boolean isPaymentMethodRadioSelected(String paymentMethod) {
        waitForElementVisible(UserCheckOutPageUI.RADIO_BUTTON_BY_LABEL, paymentMethod);
        return isElementSelected(UserCheckOutPageUI.RADIO_BUTTON_BY_LABEL, paymentMethod);
    }

    public Object getInforCheckoutByNameAndValue(String titleName, String nameValue) {
        waitForElementVisible(UserCheckOutPageUI.INFOR_CHECKOUT_BY_TITLE_AND_VALUE, titleName, nameValue);
        return getElementText(UserCheckOutPageUI.INFOR_CHECKOUT_BY_TITLE_AND_VALUE, titleName, nameValue).trim();
    }

    public Object getPaymentMethodBilling() {
        waitForElementVisible(UserCheckOutPageUI.INFOR_PAYMENT_METHOD);
        return getElementText(UserCheckOutPageUI.INFOR_PAYMENT_METHOD).trim();
    }

    public Object getShippingMethodShipping() {
        waitForElementVisible(UserCheckOutPageUI.INFOR_SHIPPING_METHOD);
        return getElementText(UserCheckOutPageUI.INFOR_SHIPPING_METHOD).trim();
    }

    public Object getProductNameCheckout() {
        waitForElementVisible(UserCheckOutPageUI.PRODUCT_NAME_LINK_TABLE);
        return getElementText(UserCheckOutPageUI.PRODUCT_NAME_LINK_TABLE);
    }

    public Object getGiftWrappingCheckout() {
        waitForElementVisible(UserCheckOutPageUI.GIFT_WRAPPING_STATUS);
        return getElementText(UserCheckOutPageUI.GIFT_WRAPPING_STATUS).trim();
    }

    public Object getPriceByLabelCheckout(String labelName) {
        waitForElementVisible(UserCheckOutPageUI.PRICE_BY_LABEL_BILL, labelName);
        return getElementText(UserCheckOutPageUI.PRICE_BY_LABEL_BILL, labelName);
    }

    public Object getShippingMethodCheckout() {
        waitForElementVisible(UserCheckOutPageUI.SHIPPING_METHOD_BILL);
        return getElementText(UserCheckOutPageUI.SHIPPING_METHOD_BILL).replaceAll("[()]", "");
    }

    public Object getTotalBillPriceCheckout() {
        waitForElementVisible(UserCheckOutPageUI.TOTAL_PRICE_BILL);
        return getElementText(UserCheckOutPageUI.TOTAL_PRICE_BILL);
    }

    public void clickToConfirmButton() {
        waitForElementClickable(UserCheckOutPageUI.CONFIRM_BUTTON);
        clickToElement(UserCheckOutPageUI.CONFIRM_BUTTON);
    }

    public Object getSuccessfulOrderMessage() {
        waitForElementVisible(UserCheckOutPageUI.SUCCESSFUL_ORDER_MESSAGE);
        return getElementText(UserCheckOutPageUI.SUCCESSFUL_ORDER_MESSAGE);
    }

    public String getOrderNumber() {
        waitForElementVisible(UserCheckOutPageUI.ORDER_NUMBER);
        return getNumberFromElementText(UserCheckOutPageUI.ORDER_NUMBER);
    }

    public UserHomePageObject clickContinueButton() {
        waitForElementClickable(UserCheckOutPageUI.CONTINUE_CHECKOUT_COMPLETED_BUTTON);
        clickToElement(UserCheckOutPageUI.CONTINUE_CHECKOUT_COMPLETED_BUTTON);
        return PageGeneratorManager.getUserHomePage(driver);
    }

    public Object getDataTableCheckout(String value) {
        waitForElementVisible(UserCheckOutPageUI.DATA_TABLE_BY_VALUE, value);
        return getElementText(UserCheckOutPageUI.DATA_TABLE_BY_VALUE, value);
    }

    public void waitForOrderComplete() {
        sleepInSecond(10);
    }
}
