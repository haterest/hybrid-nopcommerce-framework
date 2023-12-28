package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.user.UserRegisterPageObject;

public class CommonPageObject extends BasePage{
    WebDriver driver;
    public CommonPageObject (WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void clickToMenuLinkByName(String titleMenuLink) {
        waitForElementClickable(CommonPageUI.REGISTER_MENU_LINK, titleMenuLink);
        clickToElement(CommonPageUI.REGISTER_MENU_LINK, titleMenuLink);
    }
}
