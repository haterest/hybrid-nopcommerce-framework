package com.nopcommerce.user;

import commons.BaseTest;
import commons.CommonRegisterLogin;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.user.*;
import utilities.ElementData;

public class User_06_WishList_Compare_RecentView extends BaseTest {
    @Parameters({"envName", "severName", "browserName", "osName", "ipAddress", "portNumber"})
    @BeforeClass
    public void beforeClass(@Optional("local") String envName, @Optional("dev") String severName, @Optional("chrome")
    String browserName, @Optional("10") String osName, @Optional("142") String ipAddress, @Optional("9999") String portNumber) {
        driver = getBrowserDriver(envName, severName, browserName, osName, ipAddress, portNumber);

        Lenovo600Product = "Lenovo IdeaCentre 600 All-in-One PC";
        DigitalVanquish3Product = "Digital Storm VANQUISH 3 Custom Performance PC";
        appleMacbookProduct = "Apple MacBook Pro 13-inch";
        asusN551JKProduct = "Asus N551JK-XO076H Laptop";
        lenovoThinkpadProduct = "Lenovo Thinkpad X1 Carbon Laptop";
        samsungPremiumProduct = "Samsung Series 9 NP900X4C Premium Ultrabook";
        hpEnvyProduct = "HP Envy 6-1180ca 15.6-Inch Sleekbook";

        wishListMessage = "The product has been added to your wishlist";
        compareProductMessage = "The product has been added to your product comparison";

        userHomePage = PageGeneratorManager.getUserHomePage(driver);
        userHomePage.clickToMenuLinkByName(ElementData.BasePage.LOGIN_MENU_LINK_ID);
        userLoginPage = PageGeneratorManager.getUserLoginPage(driver);
        userLoginPage.setCookies(CommonRegisterLogin.loggedCookies);
        userLoginPage.refreshCurrentPage();
    }

    @Test
    public void Wishlist_Compare_RecentView_01_Add_Product_To_Wishlist(){
        userLoginPage.openCategoriesPageByName(ElementData.BasePage.HEADER_CATEGORY,
                ElementData.BasePage.COMPUTER_CATEGORY, ElementData.BasePage.DESKTOPS_SUB_CATEGORY);
        userDesktopPage = PageGeneratorManager.getUserDesktopPage(driver);
        userDetailProductPage = userDesktopPage.openDetailProductPageByName(Lenovo600Product);
        userDetailProductPage.clickToAddToWishListButton();
        verifyEquals(userDetailProductPage.getSuccessfulMessageDisplayed(),wishListMessage);
        userDetailProductPage.closeSuccessfulMessage();
        userWishListPage = userDetailProductPage.clickToWishListMenuLink();
        verifyTrue(userWishListPage.isProductNameAdded(Lenovo600Product));
        userWishListPage.clickToWishListShareLink();
        verifyEquals(userWishListPage.getUserWishListTitle(), "Wishlist of " +
                CommonRegisterLogin.firstName + " " + CommonRegisterLogin.lastName);
    }

    @Test
    public void Wishlist_Compare_RecentView_02_Add_Product_Cart_From_WishList_Page(){
        userWishListPage.refreshCurrentPage();
        userWishListPage.clickToAddToCartCheckBox();
        userShoppingCartPage = userWishListPage.clickToAddToCartButton();
        verifyTrue(userShoppingCartPage.isProductAddedToShoppingCart(Lenovo600Product));
        userWishListPage = userShoppingCartPage.clickToWishListMenuLink();
        userWishListPage.clickToRemoveIconByProductName(Lenovo600Product);
        verifyEquals(userWishListPage.getWishListMessage(), "The wishlist is empty!");
    }

    @Test
    public void Wishlist_Compare_RecentView_03_Remove_Product_Cart_In_WishList_Page(){
        userWishListPage.refreshCurrentPage();
        userWishListPage.openCategoriesPageByName(ElementData.BasePage.HEADER_CATEGORY,
                ElementData.BasePage.COMPUTER_CATEGORY, ElementData.BasePage.DESKTOPS_SUB_CATEGORY);
        userDesktopPage = PageGeneratorManager.getUserDesktopPage(driver);
        userDetailProductPage = userDesktopPage.openDetailProductPageByName(DigitalVanquish3Product);
        userDetailProductPage.clickToAddToWishListButton();
        verifyEquals(userDetailProductPage.getSuccessfulMessageDisplayed(),wishListMessage);
        userDetailProductPage.closeSuccessfulMessage();
        userWishListPage = userDetailProductPage.clickToWishListMenuLink();
        userWishListPage.clickToRemoveIconByProductName(DigitalVanquish3Product);
        verifyEquals(userWishListPage.getWishListMessage(), "The wishlist is empty!");
    }

    @Test
    public void Wishlist_Compare_RecentView_04_Add_Product_To_Compare(){
        userWishListPage.refreshCurrentPage();
        userWishListPage.openCategoriesPageByName(ElementData.BasePage.HEADER_CATEGORY,
                ElementData.BasePage.COMPUTER_CATEGORY, ElementData.BasePage.DESKTOPS_SUB_CATEGORY);
        userDesktopPage = PageGeneratorManager.getUserDesktopPage(driver);
        userDesktopPage.clickAddToCompareListButtonByName(DigitalVanquish3Product);
        verifyEquals(userDesktopPage.getSuccessfulMessageDisplayed(),compareProductMessage);
        userDesktopPage.clickAddToCompareListButtonByName(Lenovo600Product);
        verifyEquals(userDesktopPage.getSuccessfulMessageDisplayed(),compareProductMessage);
        userDesktopPage.clickToLinkFooterByName(ElementData.FooterPage.COMPARE_PRODUCTS_LIST_LINK);
        userCompareProductsPage = PageGeneratorManager.getUserCompareProductsPage(driver);
        verifyTrue(userCompareProductsPage.isDisplayedNameByProductName(DigitalVanquish3Product));
        verifyTrue(userCompareProductsPage.isDisplayedRemoveButtonByProductName(DigitalVanquish3Product));
        verifyTrue(userCompareProductsPage.isDisplayedPriceByProductName(DigitalVanquish3Product));
        verifyTrue(userCompareProductsPage.isDisplayedNameByProductName(Lenovo600Product));
        verifyTrue(userCompareProductsPage.isDisplayedRemoveButtonByProductName(Lenovo600Product));
        verifyTrue(userCompareProductsPage.isDisplayedPriceByProductName(Lenovo600Product));
        userCompareProductsPage.clickClearListButton();
        verifyEquals(userCompareProductsPage.getProductCompareMessage(), "You have no items to compare.");
        verifyTrue(userCompareProductsPage.isUndisplayProductByName(DigitalVanquish3Product));
        verifyTrue(userCompareProductsPage.isUndisplayProductByName(Lenovo600Product));
    }

    @Test
    public void Wishlist_Compare_RecentView_05_Recently_Viewd_Products(){
        userCompareProductsPage.openCategoriesPageByName(ElementData.BasePage.HEADER_CATEGORY,
                ElementData.BasePage.COMPUTER_CATEGORY, ElementData.BasePage.NOTEBOOKS_SUB_CATEGORY);
        userNotebooksPage = PageGeneratorManager.getUserNotebooksPage(driver);
        userDetailProductPage = userNotebooksPage.clickToDetaiProductByName(appleMacbookProduct);
        userNotebooksPage = userDetailProductPage.backToNotebooksProductPage();
        userDetailProductPage = userNotebooksPage.clickToDetaiProductByName(asusN551JKProduct);
        userNotebooksPage = userDetailProductPage.backToNotebooksProductPage();
        userDetailProductPage = userNotebooksPage.clickToDetaiProductByName(hpEnvyProduct);
        userNotebooksPage = userDetailProductPage.backToNotebooksProductPage();
        userDetailProductPage = userNotebooksPage.clickToDetaiProductByName(lenovoThinkpadProduct);
        userNotebooksPage = userDetailProductPage.backToNotebooksProductPage();
        userDetailProductPage = userNotebooksPage.clickToDetaiProductByName(samsungPremiumProduct);
        userNotebooksPage = userDetailProductPage.backToNotebooksProductPage();
        userNotebooksPage.clickToLinkFooterByName(ElementData.FooterPage.RECENTLY_VIEWED_PRODUCTS_LINK);
        userRecentlyProductsPage = PageGeneratorManager.getUserRecentlyProductsPage(driver);
        verifyTrue(userRecentlyProductsPage.isDisplayedProductByName(samsungPremiumProduct));
        verifyTrue(userRecentlyProductsPage.isDisplayedProductByName(lenovoThinkpadProduct));
        verifyTrue(userRecentlyProductsPage.isDisplayedProductByName(hpEnvyProduct));
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
    private WebDriver driver;
    private String Lenovo600Product, DigitalVanquish3Product, appleMacbookProduct, asusN551JKProduct, hpEnvyProduct,
            lenovoThinkpadProduct, samsungPremiumProduct, wishListMessage,compareProductMessage;
    private UserLoginPageObject userLoginPage;
    private UserDesktopPageObject userDesktopPage;
    private UserDetailProductPageObject userDetailProductPage;
    private UserWishListPageObject userWishListPage;
    private UserCompareProductsPageObject userCompareProductsPage;
    UserShoppingCartPageObject userShoppingCartPage;
    UserHomePageObject userHomePage;
    UserNotebooksPageObject userNotebooksPage;
    UserRecentlyProductsPageObject userRecentlyProductsPage;
}
