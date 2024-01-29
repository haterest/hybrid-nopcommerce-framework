package pageUIs.admin;

public class AdminProductsPageUI {
    public static final String PRODUCT_NAME_TEXTBOX = "css=input#SearchProductName";
    public static final String SEARCH_BUTTON = "css=button#search-products";
    public static final String LOADING_ICON = "css=div#ajaxBusy";
    public static final String COLUMN_INDEX_BY_LABEL_NAME = "xpath=//th[text()='%s']/preceding-sibling::th";
    public static final String PRODUCT_INFOR_BY_COLUMN_INDEX = "xpath=//table[@id='products-grid']/tbody//td[%s]";
    public static final String PUBLISHED_ICON_BY_COLUMN_INDEX = "xpath=//table[@id='products-grid']/tbody//td[%s]/i" +
            "[@nop-value='true']";
    public static final String PRODUCT_NAME = "xpath=//td[text()='%s']";
}
