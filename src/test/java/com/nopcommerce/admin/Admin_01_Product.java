package com.nopcommerce.admin;

import commons.BaseTest;
import commons.GlobalConstant;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.admin.AdminProductsPageObject;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;

public class Admin_01_Product extends BaseTest {
    @Parameters({"envName", "severName", "browserName", "osName", "ipAddress", "portNumber"})
    @BeforeClass
    public void beforeClass(@Optional("local") String envName, @Optional("dev") String severName, @Optional("chrome")
    String browserName, @Optional("10") String osName, @Optional("142") String ipAddress, @Optional("9999") String portNumber) {
        driver = getBrowserDriver(envName, severName, browserName, osName, ipAddress, portNumber);
        adminEmail = "admin@yourstore.com";
        adminPassword = "admin";
        productName = "Lenovo IdeaCentre 600 All-in-One PC";
        productSKU = "LE_IC_600";
        productPrice = "500";
        stockQuantity = "10000";
        catalogMenu = "Catalog";
        productLink = "Products";
        productNameLabel = "Product name";
        skuLabel = "SKU";
        priceLabel = "Price";
        stockQuantityLabel = "Stock quantity";
        publishedLabel = "Published";
        noDataTable = "No data available in table";
        computerDropdown = "Computers";

        userHomePage = PageGeneratorManager.getUserHomePage(driver);
        userHomePage.openPageURL(GlobalConstant.getGlobalConstants().getAdminPageURL());
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
        adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmail, adminPassword);
        verifyTrue(adminDashboardPage.isAdminDashboardHeaderDisplayed());
    }

    @Test
    public void Product_01_Search_By_Product_name(){
        adminDashboardPage.clickToMenuSideBarByName(catalogMenu);
        adminProductsPage = (AdminProductsPageObject) adminDashboardPage.clickToMenuSideBarByLink(catalogMenu, productLink);
        adminProductsPage.clickToSearchProductTab();
        adminProductsPage.inputToProductNameTextbox(productName);
        adminProductsPage.clickToSearchButton();
        verifyEquals(adminProductsPage.getSizeProductName(productName), 1);
        verifyEquals(adminProductsPage.getProductInforByLabelName(productNameLabel), productName);
        verifyEquals(adminProductsPage.getProductInforByLabelName(skuLabel), productSKU);
        verifyEquals(adminProductsPage.getProductInforByLabelName(priceLabel), productPrice);
        verifyEquals(adminProductsPage.getProductInforByLabelName(stockQuantityLabel), stockQuantity);
        verifyTrue(adminProductsPage.isPublishedSuccessDisplayByLabelName(publishedLabel));
    }

    @Test
    public void Product_02_Search_By_Product_name_And_Parent_Category(){
        adminProductsPage = (AdminProductsPageObject) adminDashboardPage.clickToMenuSideBarByLink(catalogMenu, productLink);
        adminProductsPage.clickToSearchProductTab();
        adminProductsPage.inputToProductNameTextbox(productName);
        adminProductsPage.selectCategoryDropdown(computerDropdown);
        adminProductsPage.clickToSearchButton();
        verifyEquals(adminProductsPage.getNoDataMessage(),noDataTable);
    }

    @Test
    public void Product_03_Search_By_Product_name_And_Parent_Category_With_Sub_Checked(){
        adminProductsPage = (AdminProductsPageObject) adminDashboardPage.clickToMenuSideBarByLink(catalogMenu, productLink);
        adminProductsPage.clickToSearchProductTab();
        adminProductsPage.inputToProductNameTextbox(productName);
        adminProductsPage.selectCategoryDropdown(computerDropdown);
        adminProductsPage.clickToSubCategoriesCheckbox();
        adminProductsPage.clickToSearchButton();
        verifyEquals(adminProductsPage.getSizeProductName(productName), 1);
        verifyEquals(adminProductsPage.getProductInforByLabelName(productNameLabel), productName);
        verifyEquals(adminProductsPage.getProductInforByLabelName(skuLabel), productSKU);
        verifyEquals(adminProductsPage.getProductInforByLabelName(priceLabel), productPrice);
        verifyEquals(adminProductsPage.getProductInforByLabelName(stockQuantityLabel), stockQuantity);
        verifyTrue(adminProductsPage.isPublishedSuccessDisplayByLabelName(publishedLabel));
    }

    @Test
    public void Product_04_Search_By_Product_name_And_Child_Category(){
        adminProductsPage = (AdminProductsPageObject) adminDashboardPage.clickToMenuSideBarByLink(catalogMenu, productLink);
        adminProductsPage.clickToSearchProductTab();
        adminProductsPage.inputToProductNameTextbox(productName);
        adminProductsPage.selectCategoryDropdown("Computers >> Desktops");
        adminProductsPage.clickToSearchButton();
        verifyEquals(adminProductsPage.getSizeProductName(productName), 1);
        verifyEquals(adminProductsPage.getProductInforByLabelName(productNameLabel), productName);
        verifyEquals(adminProductsPage.getProductInforByLabelName(skuLabel), productSKU);
        verifyEquals(adminProductsPage.getProductInforByLabelName(priceLabel), productPrice);
        verifyEquals(adminProductsPage.getProductInforByLabelName(stockQuantityLabel), stockQuantity);
        verifyTrue(adminProductsPage.isPublishedSuccessDisplayByLabelName(publishedLabel));
    }

    @Test
    public void Product_05_Search_By_Product_name_And_Manufacturer(){
        adminProductsPage = (AdminProductsPageObject) adminDashboardPage.clickToMenuSideBarByLink(catalogMenu, productLink);
        adminProductsPage.clickToSearchProductTab();
        adminProductsPage.inputToProductNameTextbox(productName);
        adminProductsPage.selectCategoryDropdown("All");
        adminProductsPage.selectManufacturerDropdown("Apple");
        adminProductsPage.clickToSearchButton();
        verifyEquals(adminProductsPage.getNoDataMessage(),noDataTable);
    }

    @Test
    public void Product_06_Search_By_Product_name_And_Product_SKU(){
        adminProductsPage = (AdminProductsPageObject) adminDashboardPage.clickToMenuSideBarByLink(catalogMenu, productLink);
        adminProductsPage.clickToSearchProductTab();
        adminProductsPage.inputToProductNameTextbox(productName);
        adminProductsPage.inputToDirectlyProductSKUTextbox(productSKU);
        adminProductsPage.clickGoButton();
        adminProductsPage.clickToProductInfoTab();
        verifyTrue(adminProductsPage.isDisplayedProductDetailsTitle(productName));
        verifyEquals(adminProductsPage.getProductNameTextbox(), productName);
        verifyEquals(adminProductsPage.getSKUProductTextbox(), productSKU);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    WebDriver driver;
    String adminEmail, adminPassword, productName, productSKU, productPrice, stockQuantity, catalogMenu,
            productLink, productNameLabel, skuLabel, priceLabel, stockQuantityLabel, publishedLabel, noDataTable,
            computerDropdown;
    UserHomePageObject userHomePage;
    AdminLoginPageObject adminLoginPage;
    private AdminDashboardPageObject adminDashboardPage;
    private AdminProductsPageObject adminProductsPage;
}
