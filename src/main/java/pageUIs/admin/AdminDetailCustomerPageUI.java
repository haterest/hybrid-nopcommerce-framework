package pageUIs.admin;

public class AdminDetailCustomerPageUI {
    public static final String ADD_NEW_HEADER = "xpath=//h1[contains(text(),'Add a new customer')]";
    public static final String TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
    public static final String FEMALE_RADIO_BUTTON = "xpath=//input[@id='Gender_Female']";
    public static final String REGISTED_CLOSE_BUTTON = "xpath=//span[text()='Registered']/following-sibling::span";
    public static final String CUSTOMER_ROLE_MENU_PARENT = "xpath=//label[text()='Customer " +
            "roles']/parent::div/parent::div/following-sibling::div//div[@role='listbox']";
    public static final String CUSTOMER_ROLE_MENU_CHILD = "css=ul#SelectedCustomerRoleIds_listbox>li";
    public static final String ADMIN_COMMENT_TEXTAREA = "css=textarea#AdminComment";
    public static final String SAVE_CONTINUE_BUTTON = "xpath=//button[@name='save-continue']";
    public static final String LOADING_ICON = "css=div#ajaxBusy";
    public static final String SUCCESSFUL_MESSAGE = "xpath=//div[starts-with(@class,'alert alert-success')]";
    public static final String OPTION_CUSTOMER_ROLE = "xpath=//span[text()='%s']/parent::li";
    public static final String ACTIVE_CHECKBOX = "css=input#Active";
    public static final String SAVE_BUTTON = "xpath=//button[@name='save']";
    public static final String BACK_TO_CUSTOMER_PAGE_LINK = "xpath=//a[text()='back to customer list']";
    public static final String PLUS_ICON_ADDRESSES_TAB = "css=div#customer-address i[class$='fa-plus']";
    public static final String ADDRESSES_TAB = "css=div#customer-address";
    public static final String ADD_NEW_ADDRESS_BUTTON = "xpath=//button[contains(text(),'Add new address')]";
    public static final String ADDRESSES_COLUMN_INDEX = "xpath=//th[text()='%s']/preceding-sibling::th";
    public static final String ADDRESSES_FIRST_ROW_BY_INDEX = "xpath=//table[@id='customer-addresses-grid']/tbody/tr" +
            "[1]/td[%s]";
    public static final String ADDRESSES_BUTTON_FIRST_ROW_BY_INDEX = "xpath=//table[@id='customer-addresses-grid" +
            "']/tbody/tr[1]/td[%s]/a";
    public static final String NO_DATA_ADDRESS_MESSAGE = "css=table#customer-addresses-grid td.dataTables_empty";
}
