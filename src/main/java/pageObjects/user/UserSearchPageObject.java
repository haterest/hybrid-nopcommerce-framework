package pageObjects.user;

import org.openqa.selenium.WebDriver;
import pageUIs.user.UserSearchPageUI;

public class UserSearchPageObject extends UserFooterPageObject{
    public UserSearchPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToSearchButton() {
        waitForElementClickable(UserSearchPageUI.SEARCH_BUTTON);
        clickToElement(UserSearchPageUI.SEARCH_BUTTON);
    }

    public Object getSearchWarningText() {
        waitForElementVisible(UserSearchPageUI.WARNING_SEARCH_TEXT);
        return getElementText(UserSearchPageUI.WARNING_SEARCH_TEXT);
    }

    public void inputToSearchKeywordTextbox(String searchKeyword) {
        waitForElementVisible(UserSearchPageUI.SEARCH_KEYWORD_TEXTBOX);
        sendKeyToElement(UserSearchPageUI.SEARCH_KEYWORD_TEXTBOX, searchKeyword);
    }

    public Object getSearchResultMessage() {
        waitForElementVisible(UserSearchPageUI.SEARCH_RESULT_TEXT);
        return getElementText(UserSearchPageUI.SEARCH_RESULT_TEXT);
    }

    public Object getSizeProductSearchResult() {
        waitForAllElementsVisible(UserSearchPageUI.SEARCH_PRODUCT_TITLE);
        return getElementsSize(UserSearchPageUI.SEARCH_PRODUCT_TITLE);
    }

    public boolean isKeywordDisplayInSearchProductResult(String keywordSearch) {
        waitForAllElementsVisible(UserSearchPageUI.SEARCH_PRODUCT_TITLE);
        return isKeywordDisplayInSearchResult(UserSearchPageUI.SEARCH_PRODUCT_TITLE, keywordSearch);
    }

    public void clickToAdvancedSearchCheckbox() {
        waitForElementClickable(UserSearchPageUI.ADVANCED_SEARCH_CHECKBOX);
        clickToDefautCheckboxOrRadio(UserSearchPageUI.ADVANCED_SEARCH_CHECKBOX);
    }

    public void selectCategoryDropdownByName(String nameCategoryDropdown) {
        waitForElementVisible(UserSearchPageUI.CATEGORY_MENU_DROPDOWN);
        selectItemInDefaultDropDown(UserSearchPageUI.CATEGORY_MENU_DROPDOWN, nameCategoryDropdown);
    }

    public void clickToAutomaticallySearchCheckbox() {
        waitForElementClickable(UserSearchPageUI.AUTOMATICALLY_SEARCH_CHECKBOX);
        clickToDefautCheckboxOrRadio(UserSearchPageUI.AUTOMATICALLY_SEARCH_CHECKBOX);
    }

    public void selectManufacturerDropdownByName(String nameManufacturer) {
        waitForElementVisible(UserSearchPageUI.MANUFACTURER_MENU_DROPDOWN);
        selectItemInDefaultDropDown(UserSearchPageUI.MANUFACTURER_MENU_DROPDOWN, nameManufacturer);
    }
}
