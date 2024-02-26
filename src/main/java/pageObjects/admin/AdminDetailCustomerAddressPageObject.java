package pageObjects.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.user.PageGeneratorManager;
import pageUIs.admin.AdminDetailCustomerAddressPageUI;

public class AdminDetailCustomerAddressPageObject extends BasePage {
    public AdminDetailCustomerAddressPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isDisplayedAddNewAddressHeader() {
        waitForElementVisible(AdminDetailCustomerAddressPageUI.ADD_NEW_ADDRESS_HEADER);
        return isElementDisplayed(AdminDetailCustomerAddressPageUI.ADD_NEW_ADDRESS_HEADER);
    }

    public void inputToTextboxByID(String textboxID, String keyword) {
        waitForElementVisible(AdminDetailCustomerAddressPageUI.TEXTBOX_BY_ID, textboxID);
        sendKeyToElement(AdminDetailCustomerAddressPageUI.TEXTBOX_BY_ID, keyword, textboxID);
    }

    public void selectCountryDropdown(String country) {
        waitForElementVisible(AdminDetailCustomerAddressPageUI.COUNTRY_DROPDOWN);
        selectItemInDefaultDropDown(AdminDetailCustomerAddressPageUI.COUNTRY_DROPDOWN, country);
        waitForElementInvisible(AdminDetailCustomerAddressPageUI.LOADING_ICON);
    }

    public void clickSaveButton() {
        scrollToElement(AdminDetailCustomerAddressPageUI.SAVE_BUTTON);
        clickToElementByJS(AdminDetailCustomerAddressPageUI.SAVE_BUTTON);
    }

    public Object getSuccessfulMessage() {
        waitForElementVisible(AdminDetailCustomerAddressPageUI.SUCCESSFUL_MESSAGE);
        return getElementText(AdminDetailCustomerAddressPageUI.SUCCESSFUL_MESSAGE).trim().substring(1).trim();
    }

    public Object getValueTextboxByID(String textboxID) {
        waitForElementVisible(AdminDetailCustomerAddressPageUI.TEXTBOX_BY_ID, textboxID);
        return getElementAttribute(AdminDetailCustomerAddressPageUI.TEXTBOX_BY_ID, "value", textboxID);
    }

    public String getValueDropdownCountry() {
        waitForElementVisible(AdminDetailCustomerAddressPageUI.COUNTRY_DROPDOWN);
        return getFirstSelectedItemDefaultDropDown(AdminDetailCustomerAddressPageUI.COUNTRY_DROPDOWN);
    }

    public AdminDetailCustomerPageObject clickBackToCustomerDetailsLink() {
        waitForElementClickable(AdminDetailCustomerAddressPageUI.BACK_TO_CUSTOMER_DETAILS_LINK);
        clickToElement(AdminDetailCustomerAddressPageUI.BACK_TO_CUSTOMER_DETAILS_LINK);
        waitForElementInvisible(AdminDetailCustomerAddressPageUI.LOADING_ICON);
        return PageGeneratorManager.getAdminDetailCustomerPage(driver);
    }

    public boolean isDisplayedEditAddressHeader() {
        waitForElementVisible(AdminDetailCustomerAddressPageUI.EDIT_ADDRESS_HEADER);
        return isElementDisplayed(AdminDetailCustomerAddressPageUI.EDIT_ADDRESS_HEADER);
    }
}
