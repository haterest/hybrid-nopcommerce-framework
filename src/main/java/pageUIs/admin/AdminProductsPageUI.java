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
    public static final String CATEGORY_DROPDOWN = "css=select#SearchCategoryId";
    public static final String MANUFACTURER_DROPDOWN = "css=select#SearchManufacturerId";
    public static final String DIRECTLY_PRODUCT_SKU_TEXTBOX = "css=input#GoDirectlyToSku";
    public static final String GO_PRODUCT_SKU_BUTTON = "css=button#go-to-product-by-sku";
    public static final String NO_DATA_TABLE_MESSAGE = "css=td.dataTables_empty";
    public static final String SUB_CATEGORIES_CHECKBOX = "css=input#SearchIncludeSubCategories";
    public static final String PRODUCT_DETAIL_TITLE_BY_NAME = "xpath=//div[@class='content-header " +
            "clearfix']/h1[contains(text(),'%s')]";
    public static final String DETAIL_PRODUCT_NAME_TEXTBOX = "css=input#Name";
    public static final String DETAIL_SKU_TEXTBOX = "css=input#Sku";
}
