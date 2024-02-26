package pageObjects.admin;

import org.openqa.selenium.WebDriver;
import pageObjects.user.PageGeneratorManager;
import pageUIs.admin.AdminCustomersPageUI;

public class AdminCustomersPageObject extends AdminLeftSideBarPageObject{
    public AdminCustomersPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public AdminDetailCustomerPageObject clickAddNewButton() {
        waitForElementClickable(AdminCustomersPageUI.ADD_NEW_BUTTON);
        clickToElement(AdminCustomersPageUI.ADD_NEW_BUTTON);
        return PageGeneratorManager.getAdminDetailCustomerPage(driver);
    }

    public void clickToDeleteRegisted() {
        waitForElementClickable(AdminCustomersPageUI.REGISTED_CLOSE_BUTTON);
        clickToElement(AdminCustomersPageUI.REGISTED_CLOSE_BUTTON);
    }

    public void selectItemInCustomerRolesMenu(String option) {
        waitForElementVisible(AdminCustomersPageUI.CUSTOMER_ROLE_MENU_PARENT);
        selectItemInCustomDropdown(AdminCustomersPageUI.CUSTOMER_ROLE_MENU_PARENT,
                AdminCustomersPageUI.CUSTOMER_ROLE_MENU_CHILD, option);
    }

    public void clickSearchButton() {
        waitForElementClickable(AdminCustomersPageUI.SEARCH_BUTTON);
        clickToElement(AdminCustomersPageUI.SEARCH_BUTTON);
        waitForElementInvisible(AdminCustomersPageUI.LOADING_ICON);
    }

    public String getFirstRowCustomerByName(String nameColumn) {
        scrollToElement(AdminCustomersPageUI.CUSTOMER_COLUMN_INDEX, nameColumn);
        int indexColumn = getElementsSize(AdminCustomersPageUI.CUSTOMER_COLUMN_INDEX, nameColumn) + 1;
        return getElementText(AdminCustomersPageUI.CUSTOMER_FIRST_ROW_BY_INDEX_COLUMN, String.valueOf(indexColumn));
    }

    public void inputToTextboxById(String textboxID, String keyword) {
        waitForElementVisible(AdminCustomersPageUI.TEXTBOX_BY_ID, textboxID);
        sendKeyToElement(AdminCustomersPageUI.TEXTBOX_BY_ID, keyword, textboxID);
    }

    public void selectMonthOfBirthDropdown(String value) {
        waitForElementVisible(AdminCustomersPageUI.MONTH_OF_BIRTH_DROPDOWN);
        selectItemInDefaultDropDown(AdminCustomersPageUI.MONTH_OF_BIRTH_DROPDOWN, value);
    }

    public void selectDayOfBirthDropdown(String value) {
        waitForElementVisible(AdminCustomersPageUI.DAY_OF_BIRTH_DROPDOWN);
        selectItemInDefaultDropDown(AdminCustomersPageUI.DAY_OF_BIRTH_DROPDOWN, value);
    }

    public AdminDetailCustomerPageObject clickEditButtonByName(String nameTable) {
        scrollToElement(AdminCustomersPageUI.CUSTOMER_COLUMN_INDEX, nameTable);
        int indexColumn = getElementsSize(AdminCustomersPageUI.CUSTOMER_COLUMN_INDEX, nameTable) + 1;
        clickToElement(AdminCustomersPageUI.CUSTOMER_FIRST_ROW_BY_INDEX_COLUMN, String.valueOf(indexColumn));
        waitForElementInvisible(AdminCustomersPageUI.LOADING_ICON);
        return PageGeneratorManager.getAdminDetailCustomerPage(driver);
    }

    public Object getSuccessfulMessage() {
        waitForElementVisible(AdminCustomersPageUI.SUCCESSFUL_MESSAGE);
        return getElementText(AdminCustomersPageUI.SUCCESSFUL_MESSAGE).trim().substring(1).trim();
    }

    public boolean isDisplayTableValue(String value) {
        scrollToElement(AdminCustomersPageUI.CUSTOMER_TABLE);
        waitForElementVisible(AdminCustomersPageUI.VALUE_CUSTOMER_BY_TEXT, value);
        return isElementDisplayed(AdminCustomersPageUI.VALUE_CUSTOMER_BY_TEXT, value);
    }
}
