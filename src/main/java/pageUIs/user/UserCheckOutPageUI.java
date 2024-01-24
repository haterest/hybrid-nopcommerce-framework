package pageUIs.user;

public class UserCheckOutPageUI {
    public static final String CONTINUE_BUTTON_BY_PARENT_ID = "xpath=//div[@id='%s']/button[text()='Continue']";
    public static final String SHIP_TO_SAME_ADDRESS_CHECKBOX = "css=input#ShipToSameAddress";
    public static final String TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
    public static final String DROPDOWN_BY_ID = "xpath=//select[@id='%s']";
    public static final String SHIP_METHOD_RADIO_BY_LABEL = "xpath=//label[text()='%s']/preceding-sibling::input";
    public static final String INFOR_CHECKOUT_BY_TITLE_AND_VALUE = "xpath=//strong[text()='%s']/parent::div/following-sibling::ul/li[@class='%s']";
    public static final String INFOR_PAYMENT_METHOD = "xpath=//li[@class='payment-method']/span[@class='value']";
    public static final String INFOR_SHIPPING_METHOD = "xpath=//li[@class='shipping-method']/span[@class='value']";
    public static final String SKU_NUMBER_PRODUCT_TABLE = "css=span.sku-number";
    public static final String PRODUCT_NAME_LINK_TABLE = "css=a.product-name";
    public static final String PRODUCT_UNIT_PRICE_TABLE = "css=span.product-unit-price";
    public static final String PRODUCT_QUANTITY_TABLE = "css=span.product-quantity";
    public static final String PRODUCT_TOTAL_PRICE_TABLE = "css=span.product-subtotal";
    public static final String GIFT_WRAPPING_STATUS = "css=div.selected-checkout-attributes";
    public static final String PRICE_BY_LABEL_BILL = "xpath=//label[text()='%s']/parent::td/following-sibling::td/span";
    public static final String SHIPPING_METHOD_BILL = "css=span.selected-shipping-method";
    public static final String TOTAL_PRICE_BILL = "xpath=//label[text()='Total:']/parent::td/following-sibling::td/span/strong";
    public static final String CONFIRM_BUTTON = "xpath=//div[@id='confirm-order-buttons-container']/button[text()='Confirm']";
    public static final String SUCCESSFUL_ORDER_MESSAGE = "css=div.section.order-completed>div>strong";
    public static final String ORDER_NUMBER = "css=div.order-number>strong";
    public static final String CONTINUE_CHECKOUT_COMPLETED_BUTTON = "xpath=//button[text()='Continue']";
    public static final String DATA_TABLE_BY_VALUE = "xpath=//td/span[@class='%s']";

}
