package com.nopcommerce.admin;

import commons.BaseTest;
import commons.GlobalConstant;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;

public class Admin_02_Customer extends BaseTest {
    @Parameters({"envName", "severName", "browserName", "osName", "ipAddress", "portNumber"})
    @BeforeClass
    public void beforeClass(@Optional("local") String envName, @Optional("dev") String severName, @Optional("chrome")
    String browserName, @Optional("10") String osName, @Optional("142") String ipAddress, @Optional("9999") String portNumber) {
        driver = getBrowserDriver(envName, severName, browserName, osName, ipAddress, portNumber);

        adminEmail = "admin@yourstore.com";
        adminPassword = "admin";

        userHomePage = PageGeneratorManager.getUserHomePage(driver);
        userHomePage.openPageURL(GlobalConstant.getGlobalConstants().getAdminPageURL());
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
        adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmail, adminPassword);
        verifyTrue(adminDashboardPage.isAdminDashboardHeaderDisplayed());
    }

    @Test
    public void Customer_01_Create_New_Customer(){
    }

    @Test
    public void Customer_02_Search_Customer_With_Email(){
    }

    @Test
    public void Customer_03_Search_Customer_With_FirstName_And_LastName(){
    }

    @Test
    public void Customer_04_Search_Customer_With_Company(){
    }

    @Test
    public void Customer_05_Search_Customer_With_Full_Data(){
    }

    @Test
    public void Customer_06_Edit_Customer(){
    }

    @Test
    public void Customer_07_Add_New_Address_In_Customer_Detail(){
    }

    @Test
    public void Customer_08_Edit_Address_In_Customer_Detail(){
    }

    @Test
    public void Customer_09_Delete_Address_In_Customer_Detail(){
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    private WebDriver driver;
    private String adminEmail, adminPassword;
    private UserHomePageObject userHomePage;
    private AdminLoginPageObject adminLoginPage;
    private AdminDashboardPageObject adminDashboardPage;
}
