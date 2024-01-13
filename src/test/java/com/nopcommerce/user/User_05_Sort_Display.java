package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserNotebooksPageObject;
import utilities.ElementData;

public class User_05_Sort_Display extends BaseTest {
    @Parameters({"envName", "severName", "browserName", "osName", "ipAddress", "portNumber"})
    @BeforeClass
    public void beforeClass(@Optional("local") String envName, @Optional("dev") String severName, @Optional("chrome")
    String browserName, @Optional("10") String osName, @Optional("142") String ipAddress, @Optional("9999") String portNumber) {
        driver = getBrowserDriver(envName, severName, browserName, osName, ipAddress, portNumber);
        numberDropdownIs3 = "3";
        numberDropdownIs6 = "6";
        numberDropdownIs9 = "9";

        userHomePage = PageGeneratorManager.getUserHomePage(driver);
    }

    @Test
    public void Sort_Display_01_Sort_With_Name_A_to_Z(){
        userHomePage.openCategoriesPageByName(ElementData.BasePage.HEADER_CATEGORY,
                ElementData.BasePage.COMPUTER_CATEGORY, ElementData.BasePage.NOTEBOOKS_SUB_CATEGORY);
        userNotebooksPage = PageGeneratorManager.getUserNotebooksPage(driver);
        userNotebooksPage.selectSortByDropDownByName("Name: A to Z");
        verifyTrue(userNotebooksPage.isProductNameSortedByAToZ());
    }

    @Test
    public void Sort_Display_02_Sort_With_Name_Z_to_A(){
        userHomePage.openCategoriesPageByName(ElementData.BasePage.HEADER_CATEGORY,
                ElementData.BasePage.COMPUTER_CATEGORY, ElementData.BasePage.NOTEBOOKS_SUB_CATEGORY);
        userNotebooksPage = PageGeneratorManager.getUserNotebooksPage(driver);
        userNotebooksPage.selectSortByDropDownByName("Name: Z to A");
        verifyTrue(userNotebooksPage.isProductNameSortedByZToA());
    }

    @Test
    public void Sort_Display_03_Sort_With_Price_Low_to_High(){
        userHomePage.openCategoriesPageByName(ElementData.BasePage.HEADER_CATEGORY,
                ElementData.BasePage.COMPUTER_CATEGORY, ElementData.BasePage.NOTEBOOKS_SUB_CATEGORY);
        userNotebooksPage = PageGeneratorManager.getUserNotebooksPage(driver);
        userNotebooksPage.selectSortByDropDownByName("Price: Low to High");
        verifyTrue(userNotebooksPage.isProductPriceSortedByLowToHigh());
    }

    @Test
    public void Sort_Display_04_Sort_With_Price_High_to_Low(){
        userHomePage.openCategoriesPageByName(ElementData.BasePage.HEADER_CATEGORY,
                ElementData.BasePage.COMPUTER_CATEGORY, ElementData.BasePage.NOTEBOOKS_SUB_CATEGORY);
        userNotebooksPage = PageGeneratorManager.getUserNotebooksPage(driver);
        userNotebooksPage.selectSortByDropDownByName("Price: High to Low");
        verifyTrue(userNotebooksPage.isProductPriceSortedByHighToLow());
    }

    @Test
    public void Sort_Display_05_Display_In_3_Page(){
        userHomePage.openCategoriesPageByName(ElementData.BasePage.HEADER_CATEGORY,
                ElementData.BasePage.COMPUTER_CATEGORY, ElementData.BasePage.NOTEBOOKS_SUB_CATEGORY);
        userNotebooksPage = PageGeneratorManager.getUserNotebooksPage(driver);
        userNotebooksPage.selectDisplayDropDownByNumberName(numberDropdownIs3);
        verifyTrue(userNotebooksPage.isProductDisplayFollowNumber(numberDropdownIs3));
        verifyTrue(userNotebooksPage.isCurrentPagingDisplay("1"));
        verifyTrue(userNotebooksPage.isPagingNextIconDisplayed());
        userNotebooksPage.clickToPagingNextIcon();
        verifyTrue(userNotebooksPage.isCurrentPagingDisplay("2"));
        verifyTrue(userNotebooksPage.isPagingPreviousIconDisplayed());
    }

    @Test
    public void Sort_Display_06_Display_In_6_Page(){
        userHomePage.openCategoriesPageByName(ElementData.BasePage.HEADER_CATEGORY,
                ElementData.BasePage.COMPUTER_CATEGORY, ElementData.BasePage.NOTEBOOKS_SUB_CATEGORY);
        userNotebooksPage = PageGeneratorManager.getUserNotebooksPage(driver);
        userNotebooksPage.selectDisplayDropDownByNumberName(numberDropdownIs6);
        verifyTrue(userNotebooksPage.isProductDisplayFollowNumber(numberDropdownIs6));
        verifyTrue(userNotebooksPage.isPagingNotDisplay());
    }

    @Test
    public void Sort_Display_07_Display_In_9_Page(){
        userHomePage.openCategoriesPageByName(ElementData.BasePage.HEADER_CATEGORY,
                ElementData.BasePage.COMPUTER_CATEGORY, ElementData.BasePage.NOTEBOOKS_SUB_CATEGORY);
        userNotebooksPage = PageGeneratorManager.getUserNotebooksPage(driver);
        userNotebooksPage.selectDisplayDropDownByNumberName(numberDropdownIs9);
        verifyTrue(userNotebooksPage.isProductDisplayFollowNumber(numberDropdownIs9));
        verifyTrue(userNotebooksPage.isPagingNotDisplay());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
    private WebDriver driver;
    private String numberDropdownIs3, numberDropdownIs6, numberDropdownIs9;
    private UserHomePageObject userHomePage;
    private UserNotebooksPageObject userNotebooksPage;
}
