package pageUIs.user;

public class UserShoppingCartPageUI {
    public static final String PRODUCT_NAME = "xpath=//td[@class='product']/a[text()='%s']";
    public static final String EDIT_PRODUCT_LINK = "xpath=//div[@class='edit-item']/a";
    public static final String REMOVE_PRODUCT_BUTTON = "css=.remove-btn";
    public static final String NO_DATA_MESSAGE = "css=.no-data";
    public static final String ESTIMATE_SHIPPING_BUTTON = "xpath=//a[contains(text(),'Estimate shipping')]";
    public static final String SHIPPING_LOADING_ICON = "css=div.shipping-options-loading";
    public static final String LOADING_PAGE_ICON = "css=.ajax-loading-block-window";
    public static final String COUNTRY_DROPDOWN = "css=select#CountryId";
    public static final String ZIP_CODE_TEXTBOX = "css=input#ZipPostalCode";
    public static final String SHIP_METHOD_RADIO_BY_NAME = "xpath=//div[text()='%s']/preceding-sibling::div/label";
    public static final String APPLY_BUTTON = "xpath=//button[text()='Apply']";
    public static final String SKU_PRODUCT = "css=span.sku-number";
    public static final String GIFT_WRAPPING_STATUS = "css=div.selected-checkout-attributes";
    public static final String SHIPPING_METHOD_INFOR = "css=span.selected-shipping-method";
    public static final String CART_PRICE_BY_LABEL_NAME = "xpath=//label[text()='%s']/parent::td/following-sibling::td/span";
    public static final String CART_PRICE_TOTAL = "xpath=//label[text()='Total:']/parent::td/following-sibling::td/span/strong";
    public static final String LEGAL_CHECKBOX = "css=input#termsofservice";
    public static final String CHECKOUT_BUTTON = "css=button#checkout";
    public static final String QUANTITY_TEXTBOX = "css=input.qty-input";
    public static final String UPDATE_SHOPPING_CART_BUTTON = "xpath=//button[text()='Update shopping cart']";
}
