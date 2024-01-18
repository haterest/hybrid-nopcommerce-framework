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

    public static UserDesktopPageObject getUserDesktopPage(WebDriver driver){
        return  new UserDesktopPageObject(driver);
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

    public static UserSearchPageObject getUserSearchPage(WebDriver driver){
        return  new UserSearchPageObject(driver);
    }

    public static UserNotebooksPageObject getUserNotebooksPage(WebDriver driver){
        return  new UserNotebooksPageObject(driver);
    }

    public static UserWishListPageObject getUserWishListPage(WebDriver driver){
        return  new UserWishListPageObject(driver);
    }

    public static UserShoppingCartPageObject getUserShoppingCartPage(WebDriver driver){
        return  new UserShoppingCartPageObject(driver);
    }

    public static UserCompareProductsPageObject getUserCompareProductsPage(WebDriver driver){
        return  new UserCompareProductsPageObject(driver);
    }

    public static UserRecentlyProductsPageObject getUserRecentlyProductsPage(WebDriver driver){
        return  new UserRecentlyProductsPageObject(driver);
    }

}
