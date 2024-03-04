package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserRegisterPageObject;
import utilities.DataHelper;

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
        userHomePage.clickToMenuLinkByName("Register");
        userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
        userRegisterPage.clickToRegisterButton();
        verifyEquals(userRegisterPage.getErrorMessageBelowTextboxById("FirstName-error"), "First name is required.");
        verifyEquals(userRegisterPage.getErrorMessageBelowTextboxById("LastName-error"), "Last name is required.");
        verifyEquals(userRegisterPage.getErrorMessageBelowTextboxById("Email-error"), "Email is required.");
        verifyEquals(userRegisterPage.getErrorMessageBelowTextboxById("Password-error"), "Password is required.");
        verifyEquals(userRegisterPage.getErrorMessageBelowTextboxById("ConfirmPassword-error"), "Password is required.");
    }

    @Test
    public void Register_02_Invalid_Email() {
        userHomePage.clickToMenuLinkByName("Register");
        userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
        userRegisterPage.inputToTextboxById("FirstName", firstName);
        userRegisterPage.inputToTextboxById("LastName", lastName);
        userRegisterPage.inputToTextboxById("Email", dataFaker.getFullName());
        userRegisterPage.inputToTextboxById("Password", password);
        userRegisterPage.inputToTextboxById("ConfirmPassword", password);
        userRegisterPage.clickToRegisterButton();
        verifyEquals(userRegisterPage.getErrorMessageBelowTextboxById("Email-error"), "Wrong email");
    }

    @Test
    public void Register_03_Register_Successful() {
        userHomePage.clickToMenuLinkByName("Register");
        userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
        userRegisterPage.inputToTextboxById("FirstName", firstName);
        userRegisterPage.inputToTextboxById("LastName", lastName);
        userRegisterPage.inputToTextboxById("Email", emailAdress);
        userRegisterPage.inputToTextboxById("Password", password);
        userRegisterPage.inputToTextboxById("ConfirmPassword", password);
        userRegisterPage.clickToRegisterButton();
        verifyEquals(userRegisterPage.getRegisterSuccesfulMessage(), "Your registration completed");
    }

    @Test
    public void Register_04_Email_Already_Exists() {
        userHomePage.clickToMenuLinkByName("Register");
        userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
        userRegisterPage.inputToTextboxById("FirstName", firstName);
        userRegisterPage.inputToTextboxById("LastName", lastName);
        userRegisterPage.inputToTextboxById("Email", emailAdress);
        userRegisterPage.inputToTextboxById("Password", password);
        userRegisterPage.inputToTextboxById("ConfirmPassword", password);
        userRegisterPage.clickToRegisterButton();
        verifyTrue(userRegisterPage.isErrorMessageEmailAlreadyExists("The specified email already exists"));
    }

    @Test
    public void Register_05_Password_Less_Than_6_Characters() {
        userHomePage.clickToMenuLinkByName("Register");
        userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
        userRegisterPage.inputToTextboxById("FirstName", firstName);
        userRegisterPage.inputToTextboxById("LastName", lastName);
        userRegisterPage.inputToTextboxById("Email", emailAdress);
        userRegisterPage.inputToTextboxById("Password", invalidPassword);
        userRegisterPage.inputToTextboxById("ConfirmPassword", invalidPassword);
        userRegisterPage.clickToRegisterButton();
        verifyEquals(userRegisterPage.getErrorMessageBelowTextboxById("Password-error"), "Password must meet the following rules:\nmust have at least 6 characters");
    }

    @Test
    public void Register_06_Confirmation_Password_Does_not_Match() {
        userHomePage.clickToMenuLinkByName("Register");
        userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
        userRegisterPage.inputToTextboxById("FirstName", firstName);
        userRegisterPage.inputToTextboxById("LastName", lastName);
        userRegisterPage.inputToTextboxById("Email", emailAdress);
        userRegisterPage.inputToTextboxById("Password", password);
        userRegisterPage.inputToTextboxById("ConfirmPassword", invalidPassword);
        userRegisterPage.clickToRegisterButton();
        verifyEquals(userRegisterPage.getErrorMessageBelowTextboxById("ConfirmPassword-error"), "The password and confirmation password do not match.");
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
