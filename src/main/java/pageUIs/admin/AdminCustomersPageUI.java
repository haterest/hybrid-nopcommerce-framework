package pageUIs.admin;

public class AdminCustomersPageUI {
    public static final String ADD_NEW_BUTTON = "css=a[class$='btn-primary']";
    public static final String REGISTED_CLOSE_BUTTON = "xpath=//span[text()='Registered']/following-sibling::span";
    public static final String CUSTOMER_ROLE_MENU_PARENT = "xpath=//label[text()='Customer " +
            "roles']/parent::div/parent::div/following-sibling::div//div[@role='listbox']";
    public static final String CUSTOMER_ROLE_MENU_CHILD = "css=ul#SelectedCustomerRoleIds_listbox>li";
    public static final String SEARCH_BUTTON = "css=button#search-customers";
    public static final String LOADING_ICON = "css=div#ajaxBusy";
    public static final String CUSTOMER_TABLE = "css=div#customers-grid_wrapper";
    public static final String CUSTOMER_COLUMN_INDEX = "xpath=//th[text()='%s']/preceding-sibling::th";
    public static final String CUSTOMER_FIRST_ROW_BY_INDEX_COLUMN = "xpath=//tbody/tr[1]/td[%s]";
    public static final String VALUE_CUSTOMER_BY_TEXT = "xpath=//tbody/tr/td[text()='%S']";
    public static final String EDIT_BUTTON_FIRST_ROW_BY_INDEX_COLUMN = "xpath=//tbody/tr[1]/td[%s]/a";
    public static final String TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
    public static final String MONTH_OF_BIRTH_DROPDOWN = "css=select#SearchMonthOfBirth";
    public static final String DAY_OF_BIRTH_DROPDOWN = "css=select#SearchDayOfBirth";
    public static final String SUCCESSFUL_MESSAGE = "xpath=//div[starts-with(@class,'alert alert-success')]";
}
