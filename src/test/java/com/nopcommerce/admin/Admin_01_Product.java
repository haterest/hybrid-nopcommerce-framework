package com.nopcommerce.admin;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.GlobalConstant;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.admin.AdminProductsPageObject;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class Admin_01_Product extends BaseTest {
    WebDriver driver;
    String adminEmail, adminPassword, productName, productSKU, productPrice, stockQuantity, catalogMenu,
            productLink, productNameLabel, skuLabel, priceLabel, stockQuantityLabel, publishedLabel, noDataTable,
            computerDropdown;
    UserHomePageObject userHomePage;
    AdminLoginPageObject adminLoginPage;
    private AdminDashboardPageObject adminDashboardPage;
    private AdminProductsPageObject adminProductsPage;

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
    public void Product_01_Search_By_Product_name(Method method) {
        ExtentTestManager.startTest(method.getName(), "Product_01_Search_by_Product_Name");
        ExtentTestManager.getTest().log(Status.INFO, "Product 01 - Search by Product Name - Step 01: Click to " + catalogMenu + "Menu Side Bar");
        adminDashboardPage.clickToMenuSideBarByName(catalogMenu);

        ExtentTestManager.getTest().log(Status.INFO, "Product 01 - Search by Product Name - Step 02: Click to Sub Category Menu" + productLink);
        adminProductsPage = (AdminProductsPageObject) adminDashboardPage.clickToMenuSideBarByLink(catalogMenu, productLink);

        ExtentTestManager.getTest().log(Status.INFO, "Product 01 - Search by Product Name - Step 03: Click to Search Product Tab");
        adminProductsPage.clickToSearchProductTab();

        ExtentTestManager.getTest().log(Status.INFO, "Product 01 - Search by Product Name - Step 04: Input " + productName + " to product textbox");
        adminProductsPage.inputToProductNameTextbox(productName);

        ExtentTestManager.getTest().log(Status.INFO, "Product 01 - Search by Product Name - Step 05: Click to Search button");
        adminProductsPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Product 01 - Search by Product Name - Step 06: Verify displayed 1 product in search result");
        verifyEquals(adminProductsPage.getSizeProductName(productName), 1);

        ExtentTestManager.getTest().log(Status.INFO, "Product 01 - Search by Product Name - Step 07: Verify displayed product name in search result");
        verifyEquals(adminProductsPage.getProductInforByLabelName(productNameLabel), productName);

        ExtentTestManager.getTest().log(Status.INFO, "Product 01 - Search by Product Name - Step 08: Verify displayed SKU product in search result");
        verifyEquals(adminProductsPage.getProductInforByLabelName(skuLabel), productSKU);

        ExtentTestManager.getTest().log(Status.INFO, "Product 01 - Search by Product Name - Step 09: Verify displayed product price in search result");
        verifyEquals(adminProductsPage.getProductInforByLabelName(priceLabel), productPrice);

        ExtentTestManager.getTest().log(Status.INFO, "Product 01 - Search by Product Name - Step 10: Verify displayed stock quantity in search result");
        verifyEquals(adminProductsPage.getProductInforByLabelName(stockQuantityLabel), stockQuantity);

        ExtentTestManager.getTest().log(Status.INFO, "Product 01 - Search by Product Name - Step 11: Verify displayed Published icon in search result");
        verifyTrue(adminProductsPage.isPublishedSuccessDisplayByLabelName(publishedLabel));
    }

    @Test
    public void Product_02_Search_By_Product_name_And_Parent_Category(Method method) {
        ExtentTestManager.startTest(method.getName(), "Product_02_Search_by_Product_Name_And_Parent_Category");
        ExtentTestManager.getTest().log(Status.INFO, "Product 02 - Search by Product Name And Parent Category - Step 01: Click to Sub Category Menu" + productLink);
        adminProductsPage = (AdminProductsPageObject) adminDashboardPage.clickToMenuSideBarByLink(catalogMenu, productLink);

        ExtentTestManager.getTest().log(Status.INFO, "Product 02 - Search by Product Name And Parent Category - Step 02: Click to Search Product Tab");
        adminProductsPage.clickToSearchProductTab();

        ExtentTestManager.getTest().log(Status.INFO, "Product 02 - Search by Product Name And Parent Category - Step 03: Input " + productName + " to product name textbox");
        adminProductsPage.inputToProductNameTextbox(productName);

        ExtentTestManager.getTest().log(Status.INFO, "Product 02 - Search by Product Name And Parent Category - Step 04: Select " + computerDropdown + " from category dropdown");
        adminProductsPage.selectCategoryDropdown(computerDropdown);

        ExtentTestManager.getTest().log(Status.INFO, "Product 02 - Search by Product Name And Parent Category - Step 05: Click to Search button");
        adminProductsPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Product 02 - Search by Product Name And Parent Category - Step 06: Verify that displayed no data message");
        verifyEquals(adminProductsPage.getNoDataMessage(), noDataTable);
    }

    @Test
    public void Product_03_Search_By_Product_name_And_Parent_Category_With_Sub_Checked(Method method) {
        ExtentTestManager.startTest(method.getName(), "Product_03_Search_by_Product_Name_And_Parent_Category_With_Sub_Checked");
        ExtentTestManager.getTest().log(Status.INFO, "Product 03 - Search by Product Name And Parent Category with sub checked - Step 01: Click to Sub Category Menu" + productLink);
        adminProductsPage = (AdminProductsPageObject) adminDashboardPage.clickToMenuSideBarByLink(catalogMenu, productLink);

        ExtentTestManager.getTest().log(Status.INFO, "Product 03 - Search by Product Name And Parent Category with sub checked - Step 02: Click to Search Product Tab");
        adminProductsPage.clickToSearchProductTab();

        ExtentTestManager.getTest().log(Status.INFO, "Product 03 - Search by Product Name And Parent Category with sub checked - Step 03: Input " + productName + " to product name textbox");
        adminProductsPage.inputToProductNameTextbox(productName);

        ExtentTestManager.getTest().log(Status.INFO, "Product 03 - Search by Product Name And Parent Category with sub checked - Step 04: Select " + computerDropdown + " option from category dropdown");
        adminProductsPage.selectCategoryDropdown(computerDropdown);

        ExtentTestManager.getTest().log(Status.INFO, "Product 03 - Search by Product Name And Parent Category with sub checked - Step 05: Click to Sub categories checkbox");
        adminProductsPage.clickToSubCategoriesCheckbox();

        ExtentTestManager.getTest().log(Status.INFO, "Product 03 - Search by Product Name And Parent Category with sub checked - Step 06: Click to Search button");
        adminProductsPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Product 03 - Search by Product Name And Parent Category with sub checked - Step 07: Verify displayed 1 product in search result");
        verifyEquals(adminProductsPage.getSizeProductName(productName), 1);

        ExtentTestManager.getTest().log(Status.INFO, "Product 03 - Search by Product Name And Parent Category with sub checked - Step 08: Verify displayed product name in search result");
        verifyEquals(adminProductsPage.getProductInforByLabelName(productNameLabel), productName);

        ExtentTestManager.getTest().log(Status.INFO, "Product 03 - Search by Product Name And Parent Category with sub checked - Step 09: Verify displayed SKU product in search result");
        verifyEquals(adminProductsPage.getProductInforByLabelName(skuLabel), productSKU);

        ExtentTestManager.getTest().log(Status.INFO, "Product 03 - Search by Product Name And Parent Category with sub checked - Step 10: Verify displayed product price in search result");
        verifyEquals(adminProductsPage.getProductInforByLabelName(priceLabel), productPrice);

        ExtentTestManager.getTest().log(Status.INFO, "Product 03 - Search by Product Name And Parent Category with sub checked - Step 11: Verify displayed stock quantity in search result");
        verifyEquals(adminProductsPage.getProductInforByLabelName(stockQuantityLabel), stockQuantity);

        ExtentTestManager.getTest().log(Status.INFO, "Product 03 - Search by Product Name And Parent Category with sub checked - Step 11: Verify displayed Published icon in search result");
        verifyTrue(adminProductsPage.isPublishedSuccessDisplayByLabelName(publishedLabel));
    }

    @Test
    public void Product_04_Search_By_Product_name_And_Child_Category(Method method) {
        ExtentTestManager.startTest(method.getName(), "Product_04_Search_by_Product_Name_And_Child_Category");
        ExtentTestManager.getTest().log(Status.INFO, "Product 04 - Search by Product Name And Child Category - Step 01: Click to Sub Category Menu" + productLink);
        adminProductsPage = (AdminProductsPageObject) adminDashboardPage.clickToMenuSideBarByLink(catalogMenu, productLink);

        ExtentTestManager.getTest().log(Status.INFO, "Product 04 - Search by Product Name And Child Category - Step 02: Click to Search Product Tab");
        adminProductsPage.clickToSearchProductTab();

        ExtentTestManager.getTest().log(Status.INFO, "Product 04 - Search by Product Name And Child Category - Step 03: Input " + productName + " to product name textbox");
        adminProductsPage.inputToProductNameTextbox(productName);

        ExtentTestManager.getTest().log(Status.INFO, "Product 04 - Search by Product Name And Child Category - Step 04: Select Computers >> Desktops from category dropdown");
        adminProductsPage.selectCategoryDropdown("Computers >> Desktops");

        ExtentTestManager.getTest().log(Status.INFO, "Product 04 - Search by Product Name And Child Category - Step 05: Click to Search button");
        adminProductsPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Product 04 - Search by Product Name And Child Category - Step 06: Verify displayed 1 product in search result");
        verifyEquals(adminProductsPage.getSizeProductName(productName), 1);

        ExtentTestManager.getTest().log(Status.INFO, "Product 04 - Search by Product Name And Child Category - Step 07: Verify displayed product name in search result");
        verifyEquals(adminProductsPage.getProductInforByLabelName(productNameLabel), productName);

        ExtentTestManager.getTest().log(Status.INFO, "Product 04 - Search by Product Name And Child Category - Step 08: Verify displayed SKU product in search result");
        verifyEquals(adminProductsPage.getProductInforByLabelName(skuLabel), productSKU);

        ExtentTestManager.getTest().log(Status.INFO, "Product 04 - Search by Product Name And Child Category - Step 09: Verify displayed product price in search result");
        verifyEquals(adminProductsPage.getProductInforByLabelName(priceLabel), productPrice);

        ExtentTestManager.getTest().log(Status.INFO, "Product 04 - Search by Product Name And Child Category - Step 10: Verify displayed stock quantity in search result");
        verifyEquals(adminProductsPage.getProductInforByLabelName(stockQuantityLabel), stockQuantity);

        ExtentTestManager.getTest().log(Status.INFO, "Product 04 - Search by Product Name And Child Category - Step 11: Verify displayed Published icon in search result");
        verifyTrue(adminProductsPage.isPublishedSuccessDisplayByLabelName(publishedLabel));
    }

    @Test
    public void Product_05_Search_By_Product_name_And_Manufacturer(Method method) {
        ExtentTestManager.startTest(method.getName(), "Product_05_Search_by_Product_Name_And_Manufacturer");
        ExtentTestManager.getTest().log(Status.INFO, "Product 05 - Search by Product Name And Manufacturer - Step 01: Click to Sub Category Menu" + productLink);
        adminProductsPage = (AdminProductsPageObject) adminDashboardPage.clickToMenuSideBarByLink(catalogMenu, productLink);

        ExtentTestManager.getTest().log(Status.INFO, "Product 05 - Search by Product Name And Manufacturer - Step 02: Click to Search Product Tab");
        adminProductsPage.clickToSearchProductTab();

        ExtentTestManager.getTest().log(Status.INFO, "Product 05 - Search by Product Name And Manufacturer - Step 03: Input " + productName + " to product name textbox");
        adminProductsPage.inputToProductNameTextbox(productName);

        ExtentTestManager.getTest().log(Status.INFO, "Product 05 - Search by Product Name And Manufacturer - Step 04: Select All option from category dropdown");
        adminProductsPage.selectCategoryDropdown("All");

        ExtentTestManager.getTest().log(Status.INFO, "Product 05 - Search by Product Name And Manufacturer - Step 05: Select Apple option from manufacturer dropdown");
        adminProductsPage.selectManufacturerDropdown("Apple");

        ExtentTestManager.getTest().log(Status.INFO, "Product 05 - Search by Product Name And Manufacturer - Step 06: Click to Search button");
        adminProductsPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Product 05 - Search by Product Name And Manufacturer - Step 07: Verify displayed " + noDataTable + " message");
        verifyEquals(adminProductsPage.getNoDataMessage(), noDataTable);
    }

    @Test
    public void Product_06_Search_By_Product_name_And_Product_SKU(Method method) {
        ExtentTestManager.startTest(method.getName(), "Product_06_Search_by_Product_Name_And_Product_SKU");
        ExtentTestManager.getTest().log(Status.INFO, "Product 06 - Search by Product Name And Product SKU - Step 01: Click to Sub Category Menu" + productLink);
        adminProductsPage = (AdminProductsPageObject) adminDashboardPage.clickToMenuSideBarByLink(catalogMenu, productLink);

        ExtentTestManager.getTest().log(Status.INFO, "Product 06 - Search by Product Name And Product SKU - Step 02: Click to Search Product Tab");
        adminProductsPage.clickToSearchProductTab();

        ExtentTestManager.getTest().log(Status.INFO, "Product 06 - Search by Product Name And Product SKU - Step 03: Input " + productName + " to product name textbox");
        adminProductsPage.inputToProductNameTextbox(productName);

        ExtentTestManager.getTest().log(Status.INFO, "Product 06 - Search by Product Name And Product SKU - Step 04: Input " + productSKU + " to product SKU textbox");
        adminProductsPage.inputToDirectlyProductSKUTextbox(productSKU);

        ExtentTestManager.getTest().log(Status.INFO, "Product 06 - Search by Product Name And Product SKU - Step 05: Click Go button");
        adminProductsPage.clickGoButton();

        ExtentTestManager.getTest().log(Status.INFO, "Product 06 - Search by Product Name And Product SKU - Step 06: Click Product Info Tab");
        adminProductsPage.clickToProductInfoTab();

        ExtentTestManager.getTest().log(Status.INFO, "Product 06 - Search by Product Name And Product SKU - Step 07: Verify displayed Product detail page");
        verifyTrue(adminProductsPage.isDisplayedProductDetailsTitle(productName));

        ExtentTestManager.getTest().log(Status.INFO, "Product 06 - Search by Product Name And Product SKU - Step 08: Verify displayed product name in Product detail page");
        verifyEquals(adminProductsPage.getProductNameTextbox(), productName);

        ExtentTestManager.getTest().log(Status.INFO, "Product 06 - Search by Product Name And Product SKU - Step 09: Verify displayed product SKU in Product detail page");
        verifyEquals(adminProductsPage.getSKUProductTextbox(), productSKU);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
}
