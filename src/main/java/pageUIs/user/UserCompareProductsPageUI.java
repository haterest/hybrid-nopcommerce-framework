package pageUIs.user;

public class UserCompareProductsPageUI {
    public static final String COLUM_INDEX_BY_NAME = "xpath=//a[text()='%s']/parent::td/preceding-sibling::td";
    public static final String NAME_PRODUCT_BY_COLUM_INDEX = "xpath=//label[text()='Name']/parent::td/parent::tr/td[%s]/a";
    public static final String PRICE_PRODUCT_BY_COLUM_INDEX = "xpath=//label[text()='Price']/parent::td/parent::tr/td[%s]";
    public static final String REMOVE_BUTTON_BY_COLUM_INDEX = "xpath=//tr[@class='remove-product']/td[%s]/button";
    public static final String CLEAR_LIST_BUTTON = "xpath=//a[text()='Clear list']";
    public static final String NO_COMPARE_PRODUCT_MESSAGE = "css=div.no-data";
    public static final String PRODUCT_NAME_LINK_BY_NAME = "xpath=//td/a[text()='%s']";
}
