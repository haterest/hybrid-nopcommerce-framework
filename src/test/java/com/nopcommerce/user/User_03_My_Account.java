package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.user.*;
import utilities.DataHelper;

public class User_03_My_Account extends BaseTest {
    @Parameters({"envName", "severName", "browserName", "osName", "ipAddress", "portNumber"})
    @BeforeClass
    public void beforeClass(@Optional("local") String envName, @Optional("dev") String severName, @Optional("chrome")
    String browserName, @Optional("10") String osName, @Optional("142") String ipAddress, @Optional("9999") String portNumber) {
        driver = getBrowserDriver(envName, severName, browserName, osName, ipAddress, portNumber);
        dataFaker = DataHelper.getData();
        emailAddress = dataFaker.getEmail();
        password = dataFaker.getPassword();
        newPassword = dataFaker.getPassword();

        customerGender = "Female";
        customerFirstName = "Automation";
        customerLastName = "FC";
        customerDayOfBirthDay = "1";
        customerMonthOfBirthDay = "January";
        customerYearOfBirthDay = "1999";
        customerEmailAddress = dataFaker.getEmail();
        customerCompanyName = "Automation FC";

        addressFirstName = "Automation";
        addressLastName = "FC";
        addressEmail = dataFaker.getEmail();
        addressCompanyName = "Automation FC";
        addressCountry = "Viet Nam";
        addressStateProvincy = "Other";
        addressCity = "Da Nang";
        addressAddress1 = "123/04 Le Lai";
        addressAddress2 = "234/05 Hai Phong";
        addressZipPostalCode = "550000";
        addressPhoneNumber = "0123456789";
        addressFaxNumber = "0987654321";

        productName  = "Build your own computer";
        reviewTitle = "sample title review " + getRandomNumber();
        reviewContent = "sample content review " + getRandomNumber();

        userHomePage = PageGeneratorManager.getUserHomePage(driver);
        userHomePage.clickToMenuLinkByName("Register");
        userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
        userRegisterPage.inputToTextboxById("FirstName", dataFaker.getFirstName());
        userRegisterPage.inputToTextboxById("LastName", dataFaker.getLastName());
        userRegisterPage.inputToTextboxById("Email", emailAddress);
        userRegisterPage.inputToTextboxById("Password", password);
        userRegisterPage.inputToTextboxById("ConfirmPassword", password);
        userRegisterPage.clickToRegisterButton();
        userHomePage.clickToMenuLinkByName("Log in");
        userLoginPage = PageGeneratorManager.getUserLoginPage(driver);
        userLoginPage.inputToEmailTextbox(emailAddress);
        userLoginPage.inputToPasswordTextbox(password);
        userLoginPage.clickToLoginButton();
        userHomePage = PageGeneratorManager.getUserHomePage(driver);
        verifyTrue(userHomePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void My_Account_01_Customer_Infor() {
        userHomePage.clickToMenuLinkByName("My account");
        userCustomerPage = PageGeneratorManager.getUserCustomerPage(driver);
        userCustomerPage.selectGenderRadioButton(customerGender);
        userCustomerPage.inputToFirstNameTextbox(customerFirstName);
        userCustomerPage.inputToLastNameTextbox(customerLastName);
        userCustomerPage.selectDayOfBirthDayDropdown(customerDayOfBirthDay);
        userCustomerPage.selectMonthOfBirthDayDropdown(customerMonthOfBirthDay);
        userCustomerPage.selectYearOfBirthDayDropdown(customerYearOfBirthDay);
        userCustomerPage.inputToEmailTextbox(customerEmailAddress);
        userCustomerPage.inputToCompanyNameTextbox(customerCompanyName);
        userCustomerPage.clickToSaveButton();

        verifyEquals(userCustomerPage.getSuccessfulMessageDisplayed(), "The customer info has been updated successfully.");
        userCustomerPage.closeSuccessfulMessage();
        verifyTrue(userCustomerPage.isGenderRadioButtonSelected(customerGender));
        verifyEquals(userCustomerPage.getAttributeOfFirstNameTextbox(), customerFirstName);
        verifyEquals(userCustomerPage.getAttributeOfLastNameTextbox(), customerLastName);
        verifyEquals(userCustomerPage.getTextFromDayOfBirthdayDropdown(), customerDayOfBirthDay);
        verifyEquals(userCustomerPage.getTextFromMonthOfBirthdayDropdown(), customerMonthOfBirthDay);
        verifyEquals(userCustomerPage.getTextFromYearOfBirthdayDropdown(), customerYearOfBirthDay);
        verifyEquals(userCustomerPage.getAttributeOfEmailTextbox(), customerEmailAddress);
        verifyEquals(userCustomerPage.getAttributeOfCompanyNameTextbox(), customerCompanyName);
    }

    @Test
    public void My_Account_02_Add_Addresses() {
        userAddressesPage = userCustomerPage.clickToAddressesPage();
        userAddressesPage.clickToAddNewButton();
        userAddressesPage.inputToFirstNameTextbox(addressFirstName);
        userAddressesPage.inputToLastNameTextbox(addressLastName);
        userAddressesPage.inputToEmailTextbox(addressEmail);
        userAddressesPage.inputToCompanyTextbox(addressCompanyName);
        userAddressesPage.selectCountryDropDown(addressCountry);
        userAddressesPage.selectStateProvinceDropDown(addressStateProvincy);
        userAddressesPage.inputToCityTextbox(addressCity);
        userAddressesPage.inputToAddress1Textbox(addressAddress1);
        userAddressesPage.inputToAddress2Textbox(addressAddress2);
        userAddressesPage.inputToZipPostalCodeTextbox(addressZipPostalCode);
        userAddressesPage.inputToPhoneNumberTextbox(addressPhoneNumber);
        userAddressesPage.inputToFaxNumberTextbox(addressFaxNumber);
        userAddressesPage.clickToSaveButton();

        verifyEquals(userAddressesPage.getSuccessfulMessageDisplayed(), "The new address has been added successfully.");
        userAddressesPage.closeSuccessfulMessage();
        verifyEquals(userAddressesPage.getFullNameText(), addressFirstName + " " + addressLastName);
        verifyEquals(userAddressesPage.getEmailAddressText(), addressEmail);
        verifyEquals(userAddressesPage.getPhoneNumberAddress(), addressPhoneNumber);
        verifyEquals(userAddressesPage.getFaxNumberAddress(), addressFaxNumber);
        verifyEquals(userAddressesPage.getTextCompany(), addressCompanyName);
        verifyEquals(userAddressesPage.getTextAddress1(), addressAddress1);
        verifyEquals(userAddressesPage.getTextAddress2(), addressAddress2);
        verifyEquals(userAddressesPage.getTextCityAndZipPostalCode(), addressCity + ", " + addressZipPostalCode);
        verifyEquals(userAddressesPage.getTextCountry(), addressCountry);
    }

    @Test
    public void My_Account_03_Change_Password() {
        userChangePasswordPage = userAddressesPage.clickToChangePasswordPage();
        userChangePasswordPage.inputToOldPasswordTextbox(password);
        userChangePasswordPage.inputToNewPasswordTextbox(newPassword);
        userChangePasswordPage.inputToConfirmPasswordTextbox(newPassword);
        userChangePasswordPage.clickToChangePasswordButton();

        verifyEquals(userChangePasswordPage.getSuccessfulMessageDisplayed(), "Password was changed");
        userChangePasswordPage.closeSuccessfulMessage();
        userChangePasswordPage.clickToMenuLinkByName("Log out");
        userHomePage = PageGeneratorManager.getUserHomePage(driver);
        userHomePage.clickToMenuLinkByName("Log in");
        userLoginPage = PageGeneratorManager.getUserLoginPage(driver);

        userLoginPage.inputToEmailTextbox(customerEmailAddress);
        userLoginPage.inputToPasswordTextbox(password);
        userLoginPage.clickToLoginButton();
        verifyEquals(userLoginPage.getAccountErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

        userLoginPage.refreshCurrentPage();
        userLoginPage.inputToEmailTextbox(customerEmailAddress);
        userLoginPage.inputToPasswordTextbox(newPassword);
        userLoginPage.clickToLoginButton();
        userHomePage = PageGeneratorManager.getUserHomePage(driver);
        verifyTrue(userHomePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void My_Account_04_Product_Reviews() {
        userHomePage.openCategoriesPageByName("HeaderMenu", "Computers", "Desktops");
        userDesktopPage = PageGeneratorManager.getUserDesktopPage(driver);
        userDetailProductPage = userDesktopPage.openDetailProductPageByName(productName);
        userProductReviewPage = userDetailProductPage.clickToAddYourReviewLink();
        userProductReviewPage.inputToReviewTitleTextbox(reviewTitle);
        userProductReviewPage.inputToReviewTextTextArea(reviewContent);
        userProductReviewPage.clickToSubmitReviewButton();
        verifyTrue(userProductReviewPage.isSuccessfulReviewMessageDisplayed("Product review is successfully added."));
        verifyEquals(userProductReviewPage.getReviewTitleText(), reviewTitle);
        verifyEquals(userProductReviewPage.getReviewContentText(), reviewContent);
        userProductReviewPage.clickToMenuLinkByName("My account");
        userCustomerPage = PageGeneratorManager.getUserCustomerPage(driver);
        userMyProductReviewPage = userCustomerPage.clickToMyProductReviewPage();
        verifyEquals(userMyProductReviewPage.getReviewTitleText(), reviewTitle);
        verifyEquals(userMyProductReviewPage.getReviewContentText(),  reviewContent);
        verifyEquals(userMyProductReviewPage.getReviewProductName(), productName);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    private WebDriver driver;
    private String customerGender, customerFirstName, customerLastName, customerDayOfBirthDay,
            customerMonthOfBirthDay, customerYearOfBirthDay, customerEmailAddress, customerCompanyName,
            addressFirstName, addressLastName, addressEmail, addressCompanyName, addressCountry, addressStateProvincy,
            addressCity, addressAddress1, addressAddress2, addressZipPostalCode, addressPhoneNumber, addressFaxNumber,
            emailAddress, password, newPassword, productName, reviewTitle, reviewContent;
    DataHelper dataFaker;
    private UserLoginPageObject userLoginPage;
    private UserCustomerPageObject userCustomerPage;
    private UserHomePageObject userHomePage;
    private UserAddressesPageObject userAddressesPage;
    UserRegisterPageObject userRegisterPage;
    UserChangePasswordPageObject userChangePasswordPage;
    UserDesktopPageObject userDesktopPage;
    UserDetailProductPageObject userDetailProductPage;
    UserProductReviewPageObject userProductReviewPage;
    UserMyProductReviewPageObject userMyProductReviewPage;
}
