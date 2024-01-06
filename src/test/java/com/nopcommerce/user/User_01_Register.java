package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserRegisterPageObject;
import utilities.DataHelper;
import utilities.ElementData;

public class User_01_Register extends BaseTest {
    @Parameters({"envName", "severName", "browserName", "osName", "ipAddress", "portNumber"})
    @BeforeClass
    public void beforeClass(@Optional("local") String envName, @Optional("dev") String severName, @Optional("chrome")
    String browserName, @Optional("10") String osName, @Optional("142") String ipAddress, @Optional("9999") String portNumber) {
        driver = getBrowserDriver(envName, severName, browserName, osName, ipAddress, portNumber);
        dataFaker = DataHelper.getData();
        firstName = dataFaker.getFirstName();
        lastName = dataFaker.getLastName();
        password = dataFaker.getPassword();
        emailAdress = dataFaker.getEmail();
        invalidPassword = dataFaker.getInvalidPassword();

        userHomePage = PageGeneratorManager.getUserHomePage(driver);
    }

    @Test
    public void Register_01_Empty_Data() {
        userHomePage.clickToMenuLinkByName(ElementData.BasePage.REGISTER_MENU_LINK_ID);
        userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
        userRegisterPage.clickToRegisterButton();
        verifyEquals(userRegisterPage.getErrorMessageBelowTextboxById(ElementData.RegisterPage.FIRST_NAME_ERROR_ID), "First name is required.");
        verifyEquals(userRegisterPage.getErrorMessageBelowTextboxById(ElementData.RegisterPage.LAST_NAME_ERROR_ID), "Last name is required.");
        verifyEquals(userRegisterPage.getErrorMessageBelowTextboxById(ElementData.RegisterPage.EMAIL_ERROR_ID), "Email is required.");
        verifyEquals(userRegisterPage.getErrorMessageBelowTextboxById(ElementData.RegisterPage.PASSWORD_ERROR_ID), "Password is required.");
        verifyEquals(userRegisterPage.getErrorMessageBelowTextboxById(ElementData.RegisterPage.CONFIRM_PASSWORD_ERROR_ID), "Password is required.");
    }

    @Test
    public void Register_02_Invalid_Email() {
        userHomePage.clickToMenuLinkByName(ElementData.BasePage.REGISTER_MENU_LINK_ID);
        userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.FIRST_NAME_TEXTBOX_ID, firstName);
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.LAST_NAME_TEXTBOX_ID, lastName);
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.EMAIL_TEXTBOX_ID, dataFaker.getFullName());
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.PASSWORD_TEXTBOX_ID, password);
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.CONFIRM_PASSWORD_TEXTBOX_ID, password);
        userRegisterPage.clickToRegisterButton();
        verifyEquals(userRegisterPage.getErrorMessageBelowTextboxById(ElementData.RegisterPage.EMAIL_ERROR_ID), "Wrong email");
    }

    @Test
    public void Register_03_Register_Successful() {
        userHomePage.clickToMenuLinkByName(ElementData.BasePage.REGISTER_MENU_LINK_ID);
        userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.FIRST_NAME_TEXTBOX_ID, firstName);
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.LAST_NAME_TEXTBOX_ID, lastName);
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.EMAIL_TEXTBOX_ID, emailAdress);
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.PASSWORD_TEXTBOX_ID, password);
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.CONFIRM_PASSWORD_TEXTBOX_ID, password);
        userRegisterPage.clickToRegisterButton();
        verifyEquals(userRegisterPage.getRegisterSuccesfulMessage(), "Your registration completed");
    }

    @Test
    public void Register_04_Email_Already_Exists() {
        userHomePage.clickToMenuLinkByName(ElementData.BasePage.REGISTER_MENU_LINK_ID);
        userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.FIRST_NAME_TEXTBOX_ID, firstName);
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.LAST_NAME_TEXTBOX_ID, lastName);
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.EMAIL_TEXTBOX_ID, emailAdress);
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.PASSWORD_TEXTBOX_ID, password);
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.CONFIRM_PASSWORD_TEXTBOX_ID, password);
        userRegisterPage.clickToRegisterButton();
        verifyTrue(userRegisterPage.isErrorMessageEmailAlreadyExists("The specified email already exists"));
    }

    @Test
    public void Register_05_Password_Less_Than_6_Characters() {
        userHomePage.clickToMenuLinkByName(ElementData.BasePage.REGISTER_MENU_LINK_ID);
        userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.FIRST_NAME_TEXTBOX_ID, firstName);
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.LAST_NAME_TEXTBOX_ID, lastName);
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.EMAIL_TEXTBOX_ID, emailAdress);
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.PASSWORD_TEXTBOX_ID, invalidPassword);
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.CONFIRM_PASSWORD_TEXTBOX_ID, invalidPassword);
        userRegisterPage.clickToRegisterButton();
        verifyEquals(userRegisterPage.getErrorMessageBelowTextboxById(ElementData.RegisterPage.PASSWORD_ERROR_ID), "Password must meet the following rules: \nmust have at least 6 characters");
    }

    @Test
    public void Register_06_Confirmation_Password_Does_not_Match() {
        userHomePage.clickToMenuLinkByName(ElementData.BasePage.REGISTER_MENU_LINK_ID);
        userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.FIRST_NAME_TEXTBOX_ID, firstName);
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.LAST_NAME_TEXTBOX_ID, lastName);
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.EMAIL_TEXTBOX_ID, emailAdress);
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.PASSWORD_TEXTBOX_ID, password);
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.CONFIRM_PASSWORD_TEXTBOX_ID, invalidPassword);
        userRegisterPage.clickToRegisterButton();
        verifyEquals(userRegisterPage.getErrorMessageBelowTextboxById(ElementData.RegisterPage.CONFIRM_PASSWORD_ERROR_ID), "The password and confirmation password do not match.");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    private WebDriver driver;
    private DataHelper dataFaker;
    private String firstName, lastName, password, emailAdress, invalidPassword, registerMenuID;
    private UserRegisterPageObject userRegisterPage;
    private UserHomePageObject userHomePage;
}
