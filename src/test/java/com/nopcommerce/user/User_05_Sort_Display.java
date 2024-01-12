package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;

public class User_05_Sort_Display extends BaseTest {
    @Parameters({"envName", "severName", "browserName", "osName", "ipAddress", "portNumber"})
    @BeforeClass
    public void beforeClass(@Optional("local") String envName, @Optional("dev") String severName, @Optional("chrome")
    String browserName, @Optional("10") String osName, @Optional("142") String ipAddress, @Optional("9999") String portNumber) {
        driver = getBrowserDriver(envName, severName, browserName, osName, ipAddress, portNumber);

        userHomePage = PageGeneratorManager.getUserHomePage(driver);
    }

    @Test
    public void Sort_Display_01_Sort_With_Name_A_to_Z(){
    }

    @Test
    public void Sort_Display_02_Sort_With_Name_Z_to_A(){
    }

    @Test
    public void Sort_Display_03_Sort_With_Price_Low_to_High(){
    }

    @Test
    public void Sort_Display_04_Sort_With_Price_High_to_Low(){
    }

    @Test
    public void Sort_Display_05_Display_In_3_Page(){
    }

    @Test
    public void Sort_Display_06_Display_In_6_Page(){
    }

    @Test
    public void Sort_Display_07_Display_In_9_Page(){
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
    private WebDriver driver;
    private UserHomePageObject userHomePage;
}
