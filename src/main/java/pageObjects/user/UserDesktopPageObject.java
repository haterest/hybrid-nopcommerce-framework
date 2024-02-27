package pageObjects.user;


import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.user.UserDesktopPageUI;

public class UserDesktopPageObject extends BasePage {

    public UserDesktopPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public UserDetailProductPageObject openDetailProductPageByName(String productName) {
        waitForElementClickable(UserDesktopPageUI.PRODUCT_TITLE_LINK_BY_NAME, productName);
        clickToElement(UserDesktopPageUI.PRODUCT_TITLE_LINK_BY_NAME, productName);
        return PageGeneratorManager.getUserDetailProductPage(driver);
    }

    public void clickAddToCompareListButtonByName(String productName) {
        waitForElementClickable(UserDesktopPageUI.ADD_TO_COMPARE_BUTTON_BY_NAME, productName);
        clickToElementByJS(UserDesktopPageUI.ADD_TO_COMPARE_BUTTON_BY_NAME, productName);
        waitForElementInvisible(UserDesktopPageUI.LOADING_PAGE_ICON);
    }

    public Object getSuccessfulMessageDisplayed() {
        waitForElementVisible(UserDesktopPageUI.SUCCESSFUL_MESSAGE);
        return getElementText(UserDesktopPageUI.SUCCESSFUL_MESSAGE);
    }

}
