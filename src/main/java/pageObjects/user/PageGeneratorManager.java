package pageObjects.user;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static UserHomePageObject getUserHomePage(WebDriver driver){
        return new UserHomePageObject(driver);
    }
    public static UserRegisterPageObject getUserRegisterPage(WebDriver driver){
        return new UserRegisterPageObject(driver);
    }
    public static UserLoginPageObject getUserLoginPage(WebDriver driver){
        return new UserLoginPageObject(driver);
    }

    public static UserCustomerPageObject getUserCustomerPage(WebDriver driver){
        return new UserCustomerPageObject(driver);
    }

    public static UserChangePasswordPageObject getUserChangePasswordPage(WebDriver driver){
        return  new UserChangePasswordPageObject(driver);
    }

    public static UserAddressesPageObject getUserAddressesPage(WebDriver driver){
        return  new UserAddressesPageObject(driver);
    }

    public static UserProductDesktopPageObject getUserProductDesktopPage(WebDriver driver){
        return  new UserProductDesktopPageObject(driver);
    }

    public static UserDetailProductPageObject getUserDetailProductPage(WebDriver driver){
        return  new UserDetailProductPageObject(driver);
    }

    public static UserProductReviewPageObject getUserProductReviewPage(WebDriver driver){
        return  new UserProductReviewPageObject(driver);
    }

    public static UserMyProductReviewPageObject getUserMyProductReviewPage(WebDriver driver){
        return  new UserMyProductReviewPageObject(driver);
    }

}
