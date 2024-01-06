package com.nopcommerce.user;

import commons.BaseTest;
import commons.CommonRegisterLogin;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import utilities.DataHelper;
import utilities.ElementData;

public class User_02_Login extends BaseTest {
    @Parameters({"envName", "severName", "browserName", "osName", "ipAddress", "portNumber"})
    @BeforeClass
    public void beforeClass(@Optional("local") String envName, @Optional("dev") String severName, @Optional("chrome")
    String browserName, @Optional("10") String osName, @Optional("142") String ipAddress, @Optional("9999") String portNumber) {
        driver = getBrowserDriver(envName, severName, browserName, osName, ipAddress, portNumber);
        dataFaker = DataHelper.getData();
        registedEmailAddress = CommonRegisterLogin.emailAddress;
        registedPassword = CommonRegisterLogin.password;
        userHomePage = PageGeneratorManager.getUserHomePage(driver);
    }

    @Test
    public void Login_01_Empty_Data() {
        userHomePage.clickToMenuLinkByName(ElementData.BasePage.LOGIN_MENU_LINK_ID);
        userLoginPage = PageGeneratorManager.getUserLoginPage(driver);
        userLoginPage.clickToLoginButton();
        verifyEquals(userLoginPage.getEmailErrorMessage(),"Please enter your email");
    }

    @Test
    public void Login_02_Invalid_Email() {
        userHomePage.clickToMenuLinkByName(ElementData.BasePage.LOGIN_MENU_LINK_ID);
        userLoginPage = PageGeneratorManager.getUserLoginPage(driver);
        userLoginPage.inputToEmailTextbox(dataFaker.getFullName());
        userLoginPage.inputToPasswordTextbox(dataFaker.getPassword());
        userLoginPage.clickToLoginButton();
        verifyEquals(userLoginPage.getEmailErrorMessage(), "Wrong email");
    }

    @Test
    public void Login_03_Unregisted_Email() {
        userHomePage.clickToMenuLinkByName(ElementData.BasePage.LOGIN_MENU_LINK_ID);
        userLoginPage = PageGeneratorManager.getUserLoginPage(driver);
        userLoginPage.inputToEmailTextbox(dataFaker.getEmail());
        userLoginPage.inputToPasswordTextbox(dataFaker.getPassword());
        userLoginPage.clickToLoginButton();
        verifyEquals(userLoginPage.getAccountErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
    }

    @Test
    public void Login_04_Registed_Email_With_Not_Input_Password() {
        userHomePage.clickToMenuLinkByName(ElementData.BasePage.LOGIN_MENU_LINK_ID);
        userLoginPage = PageGeneratorManager.getUserLoginPage(driver);
        userLoginPage.inputToEmailTextbox(registedEmailAddress);
        userLoginPage.inputToPasswordTextbox("");
        userLoginPage.clickToLoginButton();
        verifyEquals(userLoginPage.getAccountErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }

    @Test
    public void Login_05_Registed_Email_With_Input_Wrong_Password() {
        userHomePage.clickToMenuLinkByName(ElementData.BasePage.LOGIN_MENU_LINK_ID);
        userLoginPage = PageGeneratorManager.getUserLoginPage(driver);
        userLoginPage.inputToEmailTextbox(registedEmailAddress);
        userLoginPage.inputToPasswordTextbox(dataFaker.getInvalidPassword());
        userLoginPage.clickToLoginButton();
        verifyEquals(userLoginPage.getAccountErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }

    @Test
    public void Login_06_Login_Succesful() {
        userHomePage.clickToMenuLinkByName(ElementData.BasePage.LOGIN_MENU_LINK_ID);
        userLoginPage = PageGeneratorManager.getUserLoginPage(driver);
        userLoginPage.inputToEmailTextbox(registedEmailAddress);
        userLoginPage.inputToPasswordTextbox(registedPassword);
        userLoginPage.clickToLoginButton();
        userHomePage = PageGeneratorManager.getUserHomePage(driver);
        verifyTrue(userHomePage.isMyAccountLinkDisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    private WebDriver driver;
    private String registedEmailAddress, registedPassword;
    private DataHelper dataFaker;
    private UserLoginPageObject userLoginPage;
    private UserHomePageObject userHomePage;
}
