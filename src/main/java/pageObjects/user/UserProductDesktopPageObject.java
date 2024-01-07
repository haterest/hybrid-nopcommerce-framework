package pageObjects.user;


import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.user.UserProductDesktopPageUI;

public class UserProductDesktopPageObject extends BasePage {

    public UserProductDesktopPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public UserDetailProductPageObject openDetailProductPageByName(String productName) {
        waitForElementClickable(UserProductDesktopPageUI.PRODUCT_TITLE_LINK_BY_NAME, productName);
        clickToElement(UserProductDesktopPageUI.PRODUCT_TITLE_LINK_BY_NAME, productName);
        return PageGeneratorManager.getUserDetailProductPage(driver);
    }
}
