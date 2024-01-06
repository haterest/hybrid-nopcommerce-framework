package pageObjects.user;

import org.openqa.selenium.WebDriver;
import pageUIs.user.UserAddressesPageUI;

public class UserAddressesPageObject extends UserMyAccountSideBarPageObject{
    WebDriver driver;
    public UserAddressesPageObject(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void clickToAddNewButton() {
        waitForElementClickable(UserAddressesPageUI.ADD_NEW_BUTTON);
        clickToElement(UserAddressesPageUI.ADD_NEW_BUTTON);
    }

    public void inputToFirstNameTextbox(String addressFirstName) {
        waitForElementVisible(UserAddressesPageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(UserAddressesPageUI.FIRST_NAME_TEXTBOX, addressFirstName);
    }

    public void inputToLastNameTextbox(String addressLastName) {
        waitForElementVisible(UserAddressesPageUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(UserAddressesPageUI.LAST_NAME_TEXTBOX, addressLastName);
    }

    public void inputToEmailTextbox(String addressEmail) {
        waitForElementVisible(UserAddressesPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(UserAddressesPageUI.EMAIL_TEXTBOX, addressEmail);
    }

    public void inputToCompanyTextbox(String addressCompanyName) {
        waitForElementVisible(UserAddressesPageUI.COMPANY_TEXTBOX);
        sendKeyToElement(UserAddressesPageUI.COMPANY_TEXTBOX, addressCompanyName);
    }

    public void selectCountryDropDown(String addressCountry) {
        waitForElementVisible(UserAddressesPageUI.COUNTRY_DROPDOWN);
        selectItemInDefaultDropDown(UserAddressesPageUI.COUNTRY_DROPDOWN, addressCountry);
    }

    public void selectStateProvinceDropDown(String addressStateProvincy) {
        waitForElementVisible(UserAddressesPageUI.STATE_PROVINCE_DROPDOWN);
        selectItemInDefaultDropDown(UserAddressesPageUI.STATE_PROVINCE_DROPDOWN, addressStateProvincy);
    }

    public void inputToCityTextbox(String addressCity) {
        waitForElementVisible(UserAddressesPageUI.CITY_TEXTBOX);
        sendKeyToElement(UserAddressesPageUI.CITY_TEXTBOX, addressCity);
    }

    public void inputToAddress1Textbox(String addressAddress1) {
        waitForElementVisible(UserAddressesPageUI.ADDRESS_1_TEXTBOX);
        sendKeyToElement(UserAddressesPageUI.ADDRESS_1_TEXTBOX, addressAddress1);
    }

    public void inputToAddress2Textbox(String addressAddress2) {
        waitForElementVisible(UserAddressesPageUI.ADDRESS_2_TEXTBOX);
        sendKeyToElement(UserAddressesPageUI.ADDRESS_2_TEXTBOX, addressAddress2);
    }

    public void inputToZipPostalCodeTextbox(String addressZipPostalCode) {
        waitForElementVisible(UserAddressesPageUI.ZIP_POSTAL_CODE_TEXTBOX);
        sendKeyToElement(UserAddressesPageUI.ZIP_POSTAL_CODE_TEXTBOX, addressZipPostalCode);
    }

    public void inputToPhoneNumberTextbox(String addressPhoneNumber) {
        waitForElementVisible(UserAddressesPageUI.PHONE_NUMBER_TEXTBOX);
        sendKeyToElement(UserAddressesPageUI.PHONE_NUMBER_TEXTBOX, addressPhoneNumber);
    }

    public void inputToFaxNumberTextbox(String addressFaxNumber) {
        waitForElementVisible(UserAddressesPageUI.FAX_NUMBER_TEXTBOX);
        sendKeyToElement(UserAddressesPageUI.FAX_NUMBER_TEXTBOX, addressFaxNumber);
    }

    public void clickToSaveButton() {
        waitForElementClickable(UserAddressesPageUI.SAVE_BUTTON);
        clickToElement(UserAddressesPageUI.SAVE_BUTTON);
    }

    public String getSuccessfulMessageDisplayed() {
        waitForElementVisible(UserAddressesPageUI.SUCCESSFUL_MESSAGE);
        return getElementText(UserAddressesPageUI.SUCCESSFUL_MESSAGE);
    }

    public void closeSuccessfulMessage() {
        waitForElementClickable(UserAddressesPageUI.CLOSE_SUCCESSFUL_MESSAGE_BUTTON);
        clickToElement(UserAddressesPageUI.CLOSE_SUCCESSFUL_MESSAGE_BUTTON);
    }


    public Object getFullNameText() {
        waitForElementVisible(UserAddressesPageUI.FULL_NAME_ADDRESS_INFO);
        return getElementText(UserAddressesPageUI.FULL_NAME_ADDRESS_INFO);
    }

    public String getEmailAddressText() {
        waitForElementVisible(UserAddressesPageUI.EMAIL_ADDRESS_INFO);
        return getElementText(UserAddressesPageUI.EMAIL_ADDRESS_INFO).substring(7);
    }

    public String getPhoneNumberAddress() {
        waitForElementVisible(UserAddressesPageUI.PHONE_NUMBER_ADDRESS_INFO);
        return getNumberFromElementText(UserAddressesPageUI.PHONE_NUMBER_ADDRESS_INFO);
    }

    public String getFaxNumberAddress() {
        waitForElementVisible(UserAddressesPageUI.FAX_NUMBER_ADDRESS_INFO);
        return getNumberFromElementText(UserAddressesPageUI.FAX_NUMBER_ADDRESS_INFO);
    }

    public Object getTextCompany() {
        waitForElementVisible(UserAddressesPageUI.COMPANY_ADDRESS_INFO);
        return getElementText(UserAddressesPageUI.COMPANY_ADDRESS_INFO);
    }

    public Object getTextAddress1() {
        waitForElementVisible(UserAddressesPageUI.ADDRESS_1_ADDRESS_INFO);
        return getElementText(UserAddressesPageUI.ADDRESS_1_ADDRESS_INFO);
    }

    public Object getTextAddress2() {
        waitForElementVisible(UserAddressesPageUI.ADDRESS_2_ADDRESS_INFO);
        return getElementText(UserAddressesPageUI.ADDRESS_2_ADDRESS_INFO);
    }

    public Object getTextCityAndZipPostalCode() {
        waitForElementVisible(UserAddressesPageUI.CITY_ZIP_POSTAL_CODE_ADDRESS_INFO);
        return getElementText(UserAddressesPageUI.CITY_ZIP_POSTAL_CODE_ADDRESS_INFO);
    }

    public Object getTextCountry() {
        waitForElementVisible(UserAddressesPageUI.COUNTRY_ADDRESS_INFO);
        return getElementText(UserAddressesPageUI.COUNTRY_ADDRESS_INFO);
    }
}
