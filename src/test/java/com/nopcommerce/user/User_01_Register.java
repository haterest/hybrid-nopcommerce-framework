package com.nopcommerce.user;

import commons.BaseTest;
import commons.CommonPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.user.PageGeneratorManager;
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
        invalidEmail = "invalidemail.com4546";
        invalidPassword = "123";
        registerMenuID = "Register";
        firstNameErrorID = "FirstName-error";
        lastNameErrorID = "LastName-error";
        emailErrorID = "Email-error";
        passwordErrorID = "Password-error";
        cfPasswordErrorID = "ConfirmPassword-error";
        firstNameTextboxID = "FirstName";
        lastNameTextboxID = "LastName";
        emailTextboxID = "Email";
        passwordTextboxID = "Password";
        cfPasswordTextboxID = "ConfirmPassword";

        commonPage = PageGeneratorManager.getCommonPage(driver);
    }

    @Test
    public void Register_01_Empty_Data() {
        commonPage.clickToMenuLinkByName(registerMenuID);
        userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
        userRegisterPage.clickToRegisterButton();
        verifyEquals(userRegisterPage.getErrorMessageBelowTextboxById(firstNameErrorID), "First name is required.");
        verifyEquals(userRegisterPage.getErrorMessageBelowTextboxById(lastNameErrorID), "Last name is required.");
        verifyEquals(userRegisterPage.getErrorMessageBelowTextboxById(emailErrorID), "Email is required.");
        verifyEquals(userRegisterPage.getErrorMessageBelowTextboxById(passwordErrorID), "Password is required.");
        verifyEquals(userRegisterPage.getErrorMessageBelowTextboxById(cfPasswordErrorID), "Password is required.");
    }

    @Test
    public void Register_02_Invalid_Email() {
        commonPage.clickToMenuLinkByName(registerMenuID);
        userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
        userRegisterPage.inputToTextboxById(firstNameTextboxID, firstName);
        userRegisterPage.inputToTextboxById(lastNameTextboxID, lastName);
        userRegisterPage.inputToTextboxById(emailTextboxID, invalidEmail);
        userRegisterPage.inputToTextboxById(passwordTextboxID, password);
        userRegisterPage.inputToTextboxById(cfPasswordTextboxID, password);
        userRegisterPage.clickToRegisterButton();
        verifyEquals(userRegisterPage.getErrorMessageBelowTextboxById(emailErrorID), "Wrong email");
    }

    @Test
    public void Register_03_Register_Successful() {
        commonPage.clickToMenuLinkByName(registerMenuID);
        userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
        userRegisterPage.inputToTextboxById(firstNameTextboxID, firstName);
        userRegisterPage.inputToTextboxById(lastNameTextboxID, lastName);
        userRegisterPage.inputToTextboxById(emailTextboxID, emailAdress);
        userRegisterPage.inputToTextboxById(passwordTextboxID, password);
        userRegisterPage.inputToTextboxById(cfPasswordTextboxID, password);
        userRegisterPage.clickToRegisterButton();
        verifyEquals(userRegisterPage.getRegisterSuccesfulMessage(), "Your registration completed");
    }

    @Test
    public void Register_04_Email_Already_Exists() {
        commonPage.clickToMenuLinkByName(registerMenuID);
        userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
        userRegisterPage.inputToTextboxById(firstNameTextboxID, firstName);
        userRegisterPage.inputToTextboxById(lastNameTextboxID, lastName);
        userRegisterPage.inputToTextboxById(emailTextboxID, emailAdress);
        userRegisterPage.inputToTextboxById(passwordTextboxID, password);
        userRegisterPage.inputToTextboxById(cfPasswordTextboxID, password);
        userRegisterPage.clickToRegisterButton();
        verifyTrue(userRegisterPage.isErrorMessageEmailAlreadyExists("The specified email already exists"));
    }

    @Test
    public void Register_05_Password_Less_Than_6_Characters() {
        commonPage.clickToMenuLinkByName(registerMenuID);
        userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
        userRegisterPage.inputToTextboxById(firstNameTextboxID, firstName);
        userRegisterPage.inputToTextboxById(lastNameTextboxID, lastName);
        userRegisterPage.inputToTextboxById(emailTextboxID, emailAdress);
        userRegisterPage.inputToTextboxById(passwordTextboxID, invalidPassword);
        userRegisterPage.inputToTextboxById(cfPasswordTextboxID, invalidPassword);
        userRegisterPage.clickToRegisterButton();
        verifyEquals(userRegisterPage.getErrorMessageBelowTextboxById(passwordErrorID), "Password must meet the following rules: /nmust have at least 6 characters");
    }

    @Test
    public void Register_06_Confirmation_Password_Does_not_Match() {
        commonPage.clickToMenuLinkByName(registerMenuID);
        userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
        userRegisterPage.inputToTextboxById(firstNameTextboxID, firstName);
        userRegisterPage.inputToTextboxById(lastNameTextboxID, lastName);
        userRegisterPage.inputToTextboxById(emailTextboxID, emailAdress);
        userRegisterPage.inputToTextboxById(passwordTextboxID, password);
        userRegisterPage.inputToTextboxById(cfPasswordTextboxID, invalidPassword);
        userRegisterPage.clickToRegisterButton();
        verifyEquals(userRegisterPage.getErrorMessageBelowTextboxById(cfPasswordErrorID), "The password and confirmation password do not match.");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    private WebDriver driver;
    private DataHelper dataFaker;
    private String firstName, lastName, password, emailAdress, invalidEmail, invalidPassword,
            registerMenuID, firstNameErrorID, lastNameErrorID, emailErrorID, passwordErrorID, cfPasswordErrorID,
            firstNameTextboxID, lastNameTextboxID, emailTextboxID, passwordTextboxID, cfPasswordTextboxID;
    private CommonPageObject commonPage;
    private UserRegisterPageObject userRegisterPage;
}
