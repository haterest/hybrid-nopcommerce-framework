package pageObjects.user;

import org.openqa.selenium.WebDriver;
import pageUIs.user.UserCustomerPageUI;

public class UserCustomerPageObject extends UserMyAccountSideBarPageObject {
    public UserCustomerPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void selectGenderRadioButton(String genderName) {
        waitForElementClickable(UserCustomerPageUI.GENDER_RADIO_BUTTON, genderName);
        clickToDefautCheckboxOrRadio(UserCustomerPageUI.GENDER_RADIO_BUTTON, genderName);
    }

    public void inputToFirstNameTextbox(String firstName) {
        waitForElementVisible(UserCustomerPageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(UserCustomerPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void inputToLastNameTextbox(String lastName) {
        waitForElementVisible(UserCustomerPageUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(UserCustomerPageUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void selectDayOfBirthDayDropdown(String dayOfBirthDay) {
        waitForElementClickable(UserCustomerPageUI.DAY_OF_BIRTHDAY_DROPDOWN);
        selectItemInDefaultDropDown(UserCustomerPageUI.DAY_OF_BIRTHDAY_DROPDOWN, dayOfBirthDay);
    }

    public void selectMonthOfBirthDayDropdown(String monthOfBirthDay) {
        waitForElementClickable(UserCustomerPageUI.MONTH_OF_BIRTHDAY_DROPDOWN);
        selectItemInDefaultDropDown(UserCustomerPageUI.MONTH_OF_BIRTHDAY_DROPDOWN, monthOfBirthDay);
    }

    public void selectYearOfBirthDayDropdown(String yearOfBirthDay) {
        waitForElementClickable(UserCustomerPageUI.YEAR_OF_BIRTHDAY_DROPDOWN);
        selectItemInDefaultDropDown(UserCustomerPageUI.YEAR_OF_BIRTHDAY_DROPDOWN, yearOfBirthDay);
    }

    public void inputToEmailTextbox(String emailAddress) {
        waitForElementVisible(UserCustomerPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(UserCustomerPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void inputToCompanyNameTextbox(String companyName) {
        waitForElementVisible(UserCustomerPageUI.COMPANY_TEXTBOX);
        sendKeyToElement(UserCustomerPageUI.COMPANY_TEXTBOX, companyName);
    }

    public void clickToSaveButton() {
        waitForElementClickable(UserCustomerPageUI.SAVE_BUTTON);
        clickToElement(UserCustomerPageUI.SAVE_BUTTON);
    }

    public String getSuccessfulMessageDisplayed() {
        waitForElementVisible(UserCustomerPageUI.SUCCESSFUL_MESSAGE);
        return getElementText(UserCustomerPageUI.SUCCESSFUL_MESSAGE);
    }

    public void closeSuccessfulMessage() {
        waitForElementClickable(UserCustomerPageUI.CLOSE_SUCCESSFUL_MESSAGE_BUTTON);
        clickToElement(UserCustomerPageUI.CLOSE_SUCCESSFUL_MESSAGE_BUTTON);
    }

    public boolean isGenderRadioButtonSelected(String genderName) {
        waitForElementVisible(UserCustomerPageUI.GENDER_RADIO_BUTTON,genderName);
        return isElementSelected(UserCustomerPageUI.GENDER_RADIO_BUTTON,genderName);
    }

    public String getAttributeOfFirstNameTextbox() {
        waitForElementVisible(UserCustomerPageUI.FIRST_NAME_TEXTBOX);
        return getElementAttribute(UserCustomerPageUI.FIRST_NAME_TEXTBOX, "value");
    }

    public String getAttributeOfLastNameTextbox() {
        waitForElementVisible(UserCustomerPageUI.LAST_NAME_TEXTBOX);
        return getElementAttribute(UserCustomerPageUI.LAST_NAME_TEXTBOX, "value");
    }

    public String getTextFromDayOfBirthdayDropdown() {
        waitForElementVisible(UserCustomerPageUI.DAY_OF_BIRTHDAY_DROPDOWN);
        return getFirstSelectedItemDefaultDropDown(UserCustomerPageUI.DAY_OF_BIRTHDAY_DROPDOWN);
    }

    public String getTextFromMonthOfBirthdayDropdown() {
        waitForElementVisible(UserCustomerPageUI.MONTH_OF_BIRTHDAY_DROPDOWN);
        return getFirstSelectedItemDefaultDropDown(UserCustomerPageUI.MONTH_OF_BIRTHDAY_DROPDOWN);
    }

    public String getTextFromYearOfBirthdayDropdown() {
        waitForElementVisible(UserCustomerPageUI.YEAR_OF_BIRTHDAY_DROPDOWN);
        return getFirstSelectedItemDefaultDropDown(UserCustomerPageUI.YEAR_OF_BIRTHDAY_DROPDOWN);
    }

    public String getAttributeOfEmailTextbox() {
        waitForElementVisible(UserCustomerPageUI.EMAIL_TEXTBOX);
        return getElementAttribute(UserCustomerPageUI.EMAIL_TEXTBOX, "value");
    }

    public String getAttributeOfCompanyNameTextbox() {
        waitForElementVisible(UserCustomerPageUI.COMPANY_TEXTBOX);
        return getElementAttribute(UserCustomerPageUI.COMPANY_TEXTBOX, "value");
    }


}
