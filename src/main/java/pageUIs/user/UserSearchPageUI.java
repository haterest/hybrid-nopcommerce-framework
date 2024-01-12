package pageUIs.user;

public class UserSearchPageUI {
    public static final String SEARCH_BUTTON = "xpath=//div/button[text()='Search']";
    public static final String WARNING_SEARCH_TEXT = "css=div.warning";
    public static final String SEARCH_KEYWORD_TEXTBOX = "css=input.search-text";
    public static final String SEARCH_RESULT_TEXT = "css=div.no-result";
    public static final String SEARCH_PRODUCT_TITLE = "css=h2.product-title>a";
    public static final String ADVANCED_SEARCH_CHECKBOX = "xpath=//label[text()='Advanced search']/preceding-sibling::input";
    public static final String AUTOMATICALLY_SEARCH_CHECKBOX = "xpath=//label[text()='Automatically search sub categories']/preceding-sibling::input";
    public static final String CATEGORY_MENU_DROPDOWN = "xpath=//label[text()='Category:']/following-sibling::select";
    public static final String MANUFACTURER_MENU_DROPDOWN = "xpath=//label[text()='Manufacturer:']/following-sibling::select";
}
