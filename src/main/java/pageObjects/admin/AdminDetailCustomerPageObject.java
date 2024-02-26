package pageObjects.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.user.PageGeneratorManager;
import pageUIs.admin.AdminDetailCustomerPageUI;

public class AdminDetailCustomerPageObject extends BasePage {
    public AdminDetailCustomerPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isDisplayedAddNewCustomerPage() {
        waitForElementVisible(AdminDetailCustomerPageUI.ADD_NEW_HEADER);
        return isElementDisplayed(AdminDetailCustomerPageUI.ADD_NEW_HEADER);
    }

    public void inputToTextBoxById(String idTextbox, String keyword) {
        waitForElementVisible(AdminDetailCustomerPageUI.TEXTBOX_BY_ID, idTextbox);
        sendKeyToElement(AdminDetailCustomerPageUI.TEXTBOX_BY_ID, keyword, idTextbox);
    }

    public void selectFemaleRadioButton() {
        waitForElementClickable(AdminDetailCustomerPageUI.FEMALE_RADIO_BUTTON);
        clickToDefautCheckboxOrRadio(AdminDetailCustomerPageUI.FEMALE_RADIO_BUTTON);
    }

    public void clickToRemoveRegistedOption() {
        waitForElementClickable(AdminDetailCustomerPageUI.REGISTED_CLOSE_BUTTON);
        clickToElement(AdminDetailCustomerPageUI.REGISTED_CLOSE_BUTTON);
    }

    public void selectItemInCustomerRolesMenu(String optionMenu) {
        waitForElementClickable(AdminDetailCustomerPageUI.CUSTOMER_ROLE_MENU_PARENT);
        selectItemInCustomDropdown(AdminDetailCustomerPageUI.CUSTOMER_ROLE_MENU_PARENT,
                AdminDetailCustomerPageUI.CUSTOMER_ROLE_MENU_CHILD, optionMenu);
    }

    public void inputToAdminComment(String adminComment) {
        waitForElementVisible(AdminDetailCustomerPageUI.ADMIN_COMMENT_TEXTAREA);
        sendKeyToElement(AdminDetailCustomerPageUI.ADMIN_COMMENT_TEXTAREA, adminComment);
    }

    public void clickToSaveAndContinueEditButton() {
        waitForElementClickable(AdminDetailCustomerPageUI.SAVE_CONTINUE_BUTTON);
        clickToElement(AdminDetailCustomerPageUI.SAVE_CONTINUE_BUTTON);
        waitForElementInvisible(AdminDetailCustomerPageUI.LOADING_ICON);
    }

    public Object getSuccessfulMessage() {
        waitForElementVisible(AdminDetailCustomerPageUI.SUCCESSFUL_MESSAGE);
        return getElementText(AdminDetailCustomerPageUI.SUCCESSFUL_MESSAGE).trim().substring(1).trim();
    }

    public Object getValueTextboxByID(String idTextbox) {
        waitForElementVisible(AdminDetailCustomerPageUI.TEXTBOX_BY_ID, idTextbox);
        return getElementAttribute(AdminDetailCustomerPageUI.TEXTBOX_BY_ID, "value", idTextbox);
    }

    public boolean isFemaleRadioButtonSelected() {
        waitForElementVisible(AdminDetailCustomerPageUI.FEMALE_RADIO_BUTTON);
        return isElementSelected(AdminDetailCustomerPageUI.FEMALE_RADIO_BUTTON);
    }

    public boolean isDisplayedOptionInCustomerRoles(String option) {
        waitForElementVisible(AdminDetailCustomerPageUI.OPTION_CUSTOMER_ROLE, option);
        return isElementDisplayed(AdminDetailCustomerPageUI.OPTION_CUSTOMER_ROLE, option);
    }

    public boolean isActiveCheckboxSelected() {
        waitForElementVisible(AdminDetailCustomerPageUI.ACTIVE_CHECKBOX);
        return isElementSelected(AdminDetailCustomerPageUI.ACTIVE_CHECKBOX);
    }

    public Object getAdminCommentTextArea() {
        waitForElementVisible(AdminDetailCustomerPageUI.ADMIN_COMMENT_TEXTAREA);
        return getElementText(AdminDetailCustomerPageUI.ADMIN_COMMENT_TEXTAREA);
    }

    public AdminCustomersPageObject clickBackToCustomerListLink() {
        waitForElementClickable(AdminDetailCustomerPageUI.BACK_TO_CUSTOMER_PAGE_LINK);
        clickToElement(AdminDetailCustomerPageUI.BACK_TO_CUSTOMER_PAGE_LINK);
        waitForElementInvisible(AdminDetailCustomerPageUI.LOADING_ICON);
        return PageGeneratorManager.getAdminCustomersPage(driver);
    }

    public AdminCustomersPageObject clickSaveButton() {
        waitForElementClickable(AdminDetailCustomerPageUI.SAVE_BUTTON);
        clickToElement(AdminDetailCustomerPageUI.SAVE_BUTTON);
        waitForElementInvisible(AdminDetailCustomerPageUI.LOADING_ICON);
        return PageGeneratorManager.getAdminCustomersPage(driver);
    }

    public void clickToAddressesTab() {
        waitForElementClickable(AdminDetailCustomerPageUI.ADDRESSES_TAB);
        scrollToElement(AdminDetailCustomerPageUI.ADDRESSES_TAB);
        if (isElementUndisplayed(AdminDetailCustomerPageUI.ADD_NEW_ADDRESS_BUTTON)){
            clickToElement(AdminDetailCustomerPageUI.ADDRESSES_TAB);
            waitForElementInvisible(AdminDetailCustomerPageUI.LOADING_ICON);
        }
    }

    public AdminDetailCustomerAddressPageObject clickToAddNewAddressButton() {
        waitForElementClickable(AdminDetailCustomerPageUI.ADD_NEW_ADDRESS_BUTTON);
        clickToElement(AdminDetailCustomerPageUI.ADD_NEW_ADDRESS_BUTTON);
        return PageGeneratorManager.getAdminDetailCustomerAddressPage(driver);
    }

    public Object getFirstRowAddressesByName(String nameTable) {
        scrollToElement(AdminDetailCustomerPageUI.ADDRESSES_TAB);
        int indexColumn = getElementsSize(AdminDetailCustomerPageUI.ADDRESSES_COLUMN_INDEX, nameTable) + 1;
        return getElementText(AdminDetailCustomerPageUI.ADDRESSES_FIRST_ROW_BY_INDEX, String.valueOf(indexColumn)).trim();
    }

    public void clickButtonFirstRowAddressesByName(String nameTable) {
        scrollToElement(AdminDetailCustomerPageUI.ADDRESSES_TAB);
        int indexColumn = getElementsSize(AdminDetailCustomerPageUI.ADDRESSES_COLUMN_INDEX, nameTable) + 1;
        clickToElement(AdminDetailCustomerPageUI.ADDRESSES_BUTTON_FIRST_ROW_BY_INDEX, String.valueOf(indexColumn));
    }

    public void acceptAlertMessage() {
        acceptAlert();
        waitForElementInvisible(AdminDetailCustomerPageUI.LOADING_ICON);
    }

    public Object getNoDataAddressMessage() {
        waitForElementVisible(AdminDetailCustomerPageUI.NO_DATA_ADDRESS_MESSAGE);
        return getElementText(AdminDetailCustomerPageUI.NO_DATA_ADDRESS_MESSAGE);
    }
}
