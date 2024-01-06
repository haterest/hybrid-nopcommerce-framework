package pageUIs.user;

public class UserCustomerPageUI {
    public static final String GENDER_RADIO_BUTTON = "xpath=//label[text()='%s']/preceding-sibling::input";
    public static final String FIRST_NAME_TEXTBOX = "css=#FirstName";
    public static final String LAST_NAME_TEXTBOX = "css=#LastName";
    public static final String DAY_OF_BIRTHDAY_DROPDOWN = "xpath=//select[@name='DateOfBirthDay']";
    public static final String MONTH_OF_BIRTHDAY_DROPDOWN = "xpath=//select[@name='DateOfBirthMonth']";
    public static final String YEAR_OF_BIRTHDAY_DROPDOWN = "xpath=//select[@name='DateOfBirthYear']";
    public static final String EMAIL_TEXTBOX = "css=#Email";
    public static final String COMPANY_TEXTBOX = "css=#Company";
    public static final String SAVE_BUTTON = "css=#save-info-button";
    public static final String SUCCESSFUL_MESSAGE = "css=.bar-notification.success>p";
    public static final String CLOSE_SUCCESSFUL_MESSAGE_BUTTON = "css=.bar-notification.success>span";
}