package pageObjects.user;

import org.openqa.selenium.WebDriver;
import pageUIs.user.UserOrderPageUI;

public class UserOrderPageObject extends UserMyAccountSideBarPageObject{
    public UserOrderPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isOrderTitleDisplayByNumber(String orderNumber) {
        waitForElementVisible(UserOrderPageUI.ORDER_TITLE_BY_NUMBER, orderNumber);
        return isElementDisplayed(UserOrderPageUI.ORDER_TITLE_BY_NUMBER, orderNumber);
    }

    public void clickDetailsButtonByNumBer(String orderNumber) {
        waitForElementClickable(UserOrderPageUI.ORDER_DETAILS_BUTTON_BY_NUMBER, orderNumber);
        clickToElement(UserOrderPageUI.ORDER_DETAILS_BUTTON_BY_NUMBER, orderNumber);
    }

    public Object getOrderNumberTitle() {
        waitForElementVisible(UserOrderPageUI.ORDER_NUMBER_OVERVIEW);
        return getNumberFromElementText(UserOrderPageUI.ORDER_NUMBER_OVERVIEW);
    }

    public Object getOrderTotalPrice() {
        waitForElementVisible(UserOrderPageUI.ORDER_TOTAL_PRICE_OVERVIEW);
        return getElementText(UserOrderPageUI.ORDER_TOTAL_PRICE_OVERVIEW);
    }

    public Object getOrderDate() {
        waitForElementVisible(UserOrderPageUI.ORDER_DATE_OVERVIEW);
        return getElementText(UserOrderPageUI.ORDER_DATE_OVERVIEW);
    }

    public Object getInforOrderByNameAndValue(String nameTitle, String nameValue) {
        waitForElementVisible(UserOrderPageUI.INFOR_ORDER_BY_TITLE_AND_CLASS, nameTitle, nameValue);
        return getElementText(UserOrderPageUI.INFOR_ORDER_BY_TITLE_AND_CLASS, nameTitle, nameValue);
    }

    public Object getPaymentMethodOrder() {
        waitForElementVisible(UserOrderPageUI.PAYMENT_METHOD_INFOR);
        return getElementText(UserOrderPageUI.PAYMENT_METHOD_INFOR).trim();
    }

    public Object getShippingMethodOrder() {
        waitForElementVisible(UserOrderPageUI.SHIPPING_METHOD_INFOR);
        return getElementText(UserOrderPageUI.SHIPPING_METHOD_INFOR).trim();
    }

    public Object getDataTableByValue(String value) {
        waitForElementVisible(UserOrderPageUI.DATA_TABLE_BY_VALUE, value);
        return getElementText(UserOrderPageUI.DATA_TABLE_BY_VALUE, value);
    }

    public Object getProductNameOrder() {
        waitForElementVisible(UserOrderPageUI.PRODUCT_NAME_TABLE);
        return getElementText(UserOrderPageUI.PRODUCT_NAME_TABLE);
    }

    public Object getGiftWrappingOrder() {
        waitForElementVisible(UserOrderPageUI.GIFT_WRAPPING_STATUS);
        return getElementText(UserOrderPageUI.GIFT_WRAPPING_STATUS);
    }

    public Object getPriceBillByLabelName(String labelName) {
        waitForElementVisible(UserOrderPageUI.PRICE_BILL_BY_LABEL_NAME, labelName);
        return getElementText(UserOrderPageUI.PRICE_BILL_BY_LABEL_NAME, labelName);
    }

    public Object getTotalBillPriceOrder() {
        waitForElementVisible(UserOrderPageUI.TOTAL_PRICE_BILL);
        return getElementText(UserOrderPageUI.TOTAL_PRICE_BILL);
    }

    public UserShoppingCartPageObject clickReOrderButton() {
        waitForElementClickable(UserOrderPageUI.RE_ORDER_BUTTON);
        clickToElement(UserOrderPageUI.RE_ORDER_BUTTON);
        return PageGeneratorManager.getUserShoppingCartPage(driver);
    }
}
