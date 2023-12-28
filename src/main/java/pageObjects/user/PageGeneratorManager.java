package pageObjects.user;

import commons.CommonPageObject;
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static CommonPageObject getCommonPage(WebDriver driver){
        return new CommonPageObject(driver);
    }
    public static UserHomePageObject getUserHomePage(WebDriver driver){
        return new UserHomePageObject(driver);
    }
    public static UserRegisterPageObject getUserRegisterPage(WebDriver driver){
        return new UserRegisterPageObject(driver);
    }
}
