package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.user.UserShoppingCartPageUI;

public class UserShoppingCartPageObject extends BasePage {
    public UserShoppingCartPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isProductAddedToShoppingCart(String productName) {
        waitForElementVisible(UserShoppingCartPageUI.PRODUCT_NAME, productName);
        return isElementDisplayed(UserShoppingCartPageUI.PRODUCT_NAME, productName);
    }
}
