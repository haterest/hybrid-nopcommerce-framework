package pageUIs.user;

public class UserNotebooksPageUI {
    public static final String SORT_BY_DROP_DOWN = "xpath=//span[text()='Sort by']/following-sibling::select";
    public static final String DISPLAY_DROP_DOWN = "xpath=//span[text()='Display']/following-sibling::select";
    public static final String PRODUCT_TITLE_LINK = "xpath=//h2[@class='product-title']/a[text()='%s']";
    public static final String PRODUCT_PRICES = "xpath=//div[@class='prices']/span";
    public static final String CURRENT_PAGE_ICON = "xpath=//li[@class='current-page']/span[text()='%s']";
    public static final String NEXT_PAGE_ICON = "xpath=//li[@class='next-page']/a";
    public static final String PREVIOUS_PAGE_ICON = "xpath=//li[@class='previous-page']/a";
    public static final String PAGING_TAB = "xpath=//div[@class='pager']";
}
