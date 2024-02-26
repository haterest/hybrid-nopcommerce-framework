package pageUIs.admin;

public class AdminDetailCustomerAddressPageUI {
    public static final String ADD_NEW_ADDRESS_HEADER = "xpath=//div[@class='content-header clearfix']/h1[contains" +
            "(text(),'Add a new address')]";
    public static final String TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
    public static final String COUNTRY_DROPDOWN = "css=select#Address_CountryId";
    public static final String SAVE_BUTTON = "xpath=//button[contains(.,'Save')]";
    public static final String SUCCESSFUL_MESSAGE = "xpath=//div[starts-with(@class,'alert alert-success')]";
    public static final String BACK_TO_CUSTOMER_DETAILS_LINK = "xpath=//a[text()='back to customer details']";
    public static final String LOADING_ICON = "css=div#ajaxBusy";
    public static final String EDIT_ADDRESS_HEADER = "xpath=//div[@class='content-header clearfix']/h1[contains(text" +
            "(),'Edit address')]";
}
