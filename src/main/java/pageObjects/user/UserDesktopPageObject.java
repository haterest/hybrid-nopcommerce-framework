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
}
