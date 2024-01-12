package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserSearchPageObject;
import utilities.ElementData;


public class User_04_Search_Advanced_Search extends BaseTest {
    @Parameters({"envName", "severName", "browserName", "osName", "ipAddress", "portNumber"})
    @BeforeClass
    public void beforeClass(@Optional("local") String envName, @Optional("dev") String severName, @Optional("chrome")
    String browserName, @Optional("10") String osName, @Optional("142") String ipAddress, @Optional("9999") String portNumber) {
        driver = getBrowserDriver(envName, severName, browserName, osName, ipAddress, portNumber);

        keywordImplicitSearch = "Lenovo";
        keywordExplicitSearch = "ThinkPad X1 Carbon";
        keywordAdvancedSearch = "Apple Macbook Pro";
        nameCategoryDropdown = "Computers";
        expectedResultMessage = "No products were found that matched your criteria.";

        userHomePage = PageGeneratorManager.getUserHomePage(driver);

    }

    @Test
    public void Search_01_Empty_Data(){
        userHomePage.clickToLinkFooterByName(ElementData.FooterPage.SEARCH_LINK);
        userSearchPage = PageGeneratorManager.getUserSearchPage(driver);
        userSearchPage.clickToSearchButton();
        verifyEquals(userSearchPage.getSearchWarningText(), "Search term minimum length is 3 characters");
    }

    @Test
    public void Search_02_Data_Not_Exist(){
        userHomePage.clickToLinkFooterByName(ElementData.FooterPage.SEARCH_LINK);
        userSearchPage = PageGeneratorManager.getUserSearchPage(driver);
        userSearchPage.inputToSearchKeywordTextbox("Macbook Pro 2050");
        userSearchPage.clickToSearchButton();
        verifyEquals(userSearchPage.getSearchResultMessage(), expectedResultMessage);
    }

    @Test
    public void Search_03_Search_With_Implicit_Product_Name(){
        userHomePage.clickToLinkFooterByName(ElementData.FooterPage.SEARCH_LINK);
        userSearchPage = PageGeneratorManager.getUserSearchPage(driver);
        userSearchPage.inputToSearchKeywordTextbox(keywordImplicitSearch);
        userSearchPage.clickToSearchButton();
        verifyEquals(userSearchPage.getSizeProductSearchResult(), 2);
        verifyTrue(userSearchPage.isKeywordDisplayInSearchProductResult(keywordImplicitSearch));
    }

    @Test
    public void Search_04_Search_With_Explicit_Product_Name(){
        userHomePage.clickToLinkFooterByName(ElementData.FooterPage.SEARCH_LINK);
        userSearchPage = PageGeneratorManager.getUserSearchPage(driver);
        userSearchPage.inputToSearchKeywordTextbox(keywordExplicitSearch);
        userSearchPage.clickToSearchButton();
        verifyEquals(userSearchPage.getSizeProductSearchResult(), 1);
        verifyTrue(userSearchPage.isKeywordDisplayInSearchProductResult(keywordExplicitSearch));
    }

    @Test
    public void Search_05_Advanced_Search_Parent_Categories(){
        userHomePage.clickToLinkFooterByName(ElementData.FooterPage.SEARCH_LINK);
        userSearchPage = PageGeneratorManager.getUserSearchPage(driver);
        userSearchPage.inputToSearchKeywordTextbox(keywordAdvancedSearch);
        userSearchPage.clickToAdvancedSearchCheckbox();
        userSearchPage.selectCategoryDropdownByName(nameCategoryDropdown);
        userSearchPage.clickToSearchButton();
        verifyEquals(userSearchPage.getSearchResultMessage(), expectedResultMessage);
    }

    @Test
    public void Search_06_Advanced_Search_Sub_Categories(){
        userHomePage.clickToLinkFooterByName(ElementData.FooterPage.SEARCH_LINK);
        userSearchPage = PageGeneratorManager.getUserSearchPage(driver);
        userSearchPage.inputToSearchKeywordTextbox(keywordAdvancedSearch);
        userSearchPage.clickToAdvancedSearchCheckbox();
        userSearchPage.selectCategoryDropdownByName(nameCategoryDropdown);
        userSearchPage.clickToAutomaticallySearchCheckbox();
        userSearchPage.clickToSearchButton();
        verifyEquals(userSearchPage.getSizeProductSearchResult(), 1);
        verifyTrue(userSearchPage.isKeywordDisplayInSearchProductResult(keywordAdvancedSearch));
    }

    @Test
    public void Search_07_Advanced_Search_Incorrect_Manufacturer(){
        userHomePage.clickToLinkFooterByName(ElementData.FooterPage.SEARCH_LINK);
        userSearchPage = PageGeneratorManager.getUserSearchPage(driver);
        userSearchPage.inputToSearchKeywordTextbox(keywordAdvancedSearch);
        userSearchPage.clickToAdvancedSearchCheckbox();
        userSearchPage.selectCategoryDropdownByName(nameCategoryDropdown);
        userSearchPage.clickToAutomaticallySearchCheckbox();
        userSearchPage.selectManufacturerDropdownByName("HP");
        userSearchPage.clickToSearchButton();
        verifyEquals(userSearchPage.getSearchResultMessage(), expectedResultMessage);
    }

    @Test
    public void Search_08_Advanced_Search_Correct_Manufacturer(){
        userHomePage.clickToLinkFooterByName(ElementData.FooterPage.SEARCH_LINK);
        userSearchPage = PageGeneratorManager.getUserSearchPage(driver);
        userSearchPage.inputToSearchKeywordTextbox(keywordAdvancedSearch);
        userSearchPage.clickToAdvancedSearchCheckbox();
        userSearchPage.selectCategoryDropdownByName(nameCategoryDropdown);
        userSearchPage.clickToAutomaticallySearchCheckbox();
        userSearchPage.selectManufacturerDropdownByName("Apple");
        userSearchPage.clickToSearchButton();
        verifyEquals(userSearchPage.getSizeProductSearchResult(), 1);
        verifyTrue(userSearchPage.isKeywordDisplayInSearchProductResult(keywordAdvancedSearch));
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
    private WebDriver driver;
    private String keywordImplicitSearch, keywordExplicitSearch, keywordAdvancedSearch,
            nameCategoryDropdown, expectedResultMessage;
    private UserHomePageObject userHomePage;
    private UserSearchPageObject userSearchPage;
}
