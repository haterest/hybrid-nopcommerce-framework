package pageUIs.user;

public class UserOrderPageUI {
    public static final String INFOR_ORDER_BY_TITLE_AND_CLASS = "xpath=//strong[text()='%s']/parent::div/following-sibling::ul/li[@class='%s']";
    public static final String ORDER_TITLE_BY_NUMBER = "xpath=//div[@class='title']/strong[text()='Order Number: %s']";
    public static final String ORDER_DETAILS_BUTTON_BY_NUMBER = "xpath=//strong[text()='Order Number: %s']/parent::div/following-sibling::div/button";
    public static final String ORDER_NUMBER_OVERVIEW = "css=div.order-number>strong";
    public static final String ORDER_DATE_OVERVIEW = "css=li.order-date";
    public static final String ORDER_TOTAL_PRICE_OVERVIEW = "css=li.order-total>strong";
    public static final String PAYMENT_METHOD_INFOR = "xpath=//li[@class='payment-method']/span[@class='value']";
    public static final String SHIPPING_METHOD_INFOR = "xpath=//li[@class='shipping-method']/span[@class='value']";
    public static final String DATA_TABLE_BY_VALUE = "xpath=//td/span[@class='%s']";
    public static final String PRODUCT_NAME_TABLE = "css=td.product>em>a";
    public static final String GIFT_WRAPPING_STATUS = "css=div.selected-checkout-attributes";
    public static final String PRICE_BILL_BY_LABEL_NAME = "xpath=//label[text()='%s']/parent::td/following-sibling::td/span";
    public static final String TOTAL_PRICE_BILL = "css=td.cart-total-right>span>strong";
}
