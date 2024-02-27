package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.user.UserNotebooksPageUI;

public class UserNotebooksPageObject extends BasePage {
    public UserNotebooksPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void selectSortByDropDownByName(String nameSortByDropDown) {
        waitForElementVisible(UserNotebooksPageUI.SORT_BY_DROP_DOWN);
        selectItemInDefaultDropDown(UserNotebooksPageUI.SORT_BY_DROP_DOWN, nameSortByDropDown);
        sleepInSecond(1);
    }

    public boolean isProductNameSortedByAToZ() {
        waitForAllElementsVisible(UserNotebooksPageUI.PRODUCT_TITLE_LINK_LIST);
        return isNameSortByAscending(UserNotebooksPageUI.PRODUCT_TITLE_LINK_LIST);
    }
    public boolean isProductNameSortedByZToA() {
        waitForAllElementsVisible(UserNotebooksPageUI.PRODUCT_TITLE_LINK_LIST);
        return isNameSortByDescending(UserNotebooksPageUI.PRODUCT_TITLE_LINK_LIST);
    }

    public boolean isProductPriceSortedByLowToHigh() {
        waitForAllElementsVisible(UserNotebooksPageUI.PRODUCT_PRICES);
        return isPriceSortByAscending(UserNotebooksPageUI.PRODUCT_PRICES);
    }

    public boolean isProductPriceSortedByHighToLow() {
        waitForAllElementsVisible(UserNotebooksPageUI.PRODUCT_PRICES);
        return isPriceSortByDescending(UserNotebooksPageUI.PRODUCT_PRICES);
    }

    public void selectDisplayDropDownByNumberName(String numberDropdown) {
        waitForElementVisible(UserNotebooksPageUI.DISPLAY_DROP_DOWN);
        selectItemInDefaultDropDown(UserNotebooksPageUI.DISPLAY_DROP_DOWN, numberDropdown);
        sleepInSecond(1);
    }

    public boolean isProductDisplayFollowNumber(String numberDropdown) {
        waitForAllElementsVisible(UserNotebooksPageUI.PRODUCT_TITLE_LINK_LIST);
        int size = getElementsSize(UserNotebooksPageUI.PRODUCT_TITLE_LINK_LIST);
        return size <= Integer.parseInt(numberDropdown);
    }

    public boolean isCurrentPagingDisplay(String number) {
        waitForElementVisible(UserNotebooksPageUI.CURRENT_PAGE_ICON, number);
        return isElementDisplayed(UserNotebooksPageUI.CURRENT_PAGE_ICON, number);
    }

    public boolean isPagingNextIconDisplayed() {
        waitForElementVisible(UserNotebooksPageUI.NEXT_PAGE_ICON);
        return isElementDisplayed(UserNotebooksPageUI.NEXT_PAGE_ICON);
    }

    public void clickToPagingNextIcon() {
        waitForElementClickable(UserNotebooksPageUI.NEXT_PAGE_ICON);
        clickToElement(UserNotebooksPageUI.NEXT_PAGE_ICON);
    }

    public boolean isPagingPreviousIconDisplayed() {
        waitForElementVisible(UserNotebooksPageUI.PREVIOUS_PAGE_ICON);
        return isElementDisplayed(UserNotebooksPageUI.PREVIOUS_PAGE_ICON);
    }

    public boolean isPagingNotDisplay() {
        return isElementUndisplayed(UserNotebooksPageUI.PAGING_TAB);
    }

    public UserDetailProductPageObject clickToDetaiProductByName(String productName) {
        waitForElementClickable(UserNotebooksPageUI.PRODUCT_TITLE_LINK_BY_NAME, productName);
        clickToElement(UserNotebooksPageUI.PRODUCT_TITLE_LINK_BY_NAME, productName);
        return PageGeneratorManager.getUserDetailProductPage(driver);
    }
}
