package com.nopcommerce.admin;

import commons.BaseTest;
import commons.GlobalConstant;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.admin.*;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import utilities.DataHelper;

public class Admin_02_Customer extends BaseTest {
    @Parameters({"envName", "severName", "browserName", "osName", "ipAddress", "portNumber"})
    @BeforeClass
    public void beforeClass(@Optional("local") String envName, @Optional("dev") String severName, @Optional("chrome")
    String browserName, @Optional("10") String osName, @Optional("142") String ipAddress, @Optional("9999") String portNumber) {
        driver = getBrowserDriver(envName, severName, browserName, osName, ipAddress, portNumber);
        dataFaker = DataHelper.getData();

        adminEmail = "admin@yourstore.com";
        adminPassword = "admin";
        customerMenu = "Customers";
        dobCustomer = "11/1/2003";
        adminComment = "This is comment of AdminPage";
        guestOption = "Guests";
        monthOfBirth = "11";
        dayOfBirth = "1";
        dobEdited = "2/13/1994";
        monthOfBirthEdited = "2";
        dayOfBirthEdited = "13";
        adminCommentEdited = "This is edited comment of AdminPage";
        vietNamCountry = "Viet Nam";
        germanyCountry = "Germany";
        email = dataFaker.getEmail();
        password = dataFaker.getPassword();
        firstName = dataFaker.getFirstName();
        lastName = dataFaker.getLastName();
        companyName = dataFaker.getCompanyName();
        emailEdited = dataFaker.getEmail();
        firstNameEdited = dataFaker.getFirstName();
        lastNameEdited = dataFaker.getLastName();
        companyEdited = dataFaker.getCompanyName();
        cityName = dataFaker.getCity();
        address1 = dataFaker.getAddress();
        address2 = dataFaker.getAddress();
        zipPostalCode = dataFaker.getZipCode();
        phoneNumber = dataFaker.getPhone();
        cityEdited = dataFaker.getCity();
        address1Edited = dataFaker.getAddress();
        address2Edited = dataFaker.getAddress();
        zipPostalCodeEdited = dataFaker.getZipCode();
        phoneNumberEdited = dataFaker.getPhone();

        emailID = "Email";
        passwordID = "Password";
        firstNameID = "FirstName";
        lastNameID = "LastName";
        dobID = "DateOfBirth";
        companyID = "Company";
        nameTable = "Name";
        companyNameTable = "Company name";
        editTable = "Edit";
        searchEmailID = "SearchEmail";
        customerRoleTable = "Customer roles";
        searchFirstNameID = "SearchFirstName";
        searchLastNameID = "SearchLastName";
        searchCompanyID = "SearchCompany";
        addressFirstNameID = "Address_FirstName";
        addressLastNameID = "Address_LastName";
        addressEmailID = "Address_Email";
        addressCompanyID = "Address_Company";
        addressCityID = "Address_City";
        addressAddress1ID = "Address_Address1";
        addressAddress2ID = "Address_Address2";
        addressZipID = "Address_ZipPostalCode";
        addressPhoneID = "Address_PhoneNumber";
        firstNameTable = "First name";
        lastNameTable = "Last name";
        emailTable = "Email";
        phoneTable = "Phone number";
        addressTable = "Address";
        deleteTable = "Delete";

        userHomePage = PageGeneratorManager.getUserHomePage(driver);
        userHomePage.openPageURL(GlobalConstant.getGlobalConstants().getAdminPageURL());
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
        adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmail, adminPassword);
        verifyTrue(adminDashboardPage.isAdminDashboardHeaderDisplayed());
    }

    @Test
    public void Customer_01_Create_New_Customer(){
        adminDashboardPage.clickToMenuSideBarByName(customerMenu);
        adminCustomersPage = (AdminCustomersPageObject) adminDashboardPage.clickToMenuSideBarByLink(customerMenu, customerMenu);
        adminCustomersPage.clickToSearchCustomerTab();
        adminDetailCustomerPage = adminCustomersPage.clickAddNewButton();
        verifyTrue(adminDetailCustomerPage.isDisplayedAddNewCustomerPage());
        adminDetailCustomerPage.inputToTextBoxById(emailID, email);
        adminDetailCustomerPage.inputToTextBoxById(passwordID, password);
        adminDetailCustomerPage.inputToTextBoxById(firstNameID, firstName);
        adminDetailCustomerPage.inputToTextBoxById(lastNameID, lastName);
        adminDetailCustomerPage.selectFemaleRadioButton();
        adminDetailCustomerPage.inputToTextBoxById(dobID, dobCustomer);
        adminDetailCustomerPage.inputToTextBoxById(companyID, companyName);
        adminDetailCustomerPage.clickToRemoveRegistedOption();
        adminDetailCustomerPage.selectItemInCustomerRolesMenu(guestOption);
        adminDetailCustomerPage.inputToAdminComment(adminComment);
        adminDetailCustomerPage.clickToSaveAndContinueEditButton();
        verifyEquals(adminDetailCustomerPage.getSuccessfulMessage(), "The new customer has been added successfully.");
        verifyEquals(adminDetailCustomerPage.getValueTextboxByID(emailID),email);
        verifyEquals(adminDetailCustomerPage.getValueTextboxByID(firstNameID),firstName);
        verifyEquals(adminDetailCustomerPage.getValueTextboxByID(lastNameID),lastName);
        verifyTrue(adminDetailCustomerPage.isFemaleRadioButtonSelected());
        verifyEquals(adminDetailCustomerPage.getValueTextboxByID(dobID),dobCustomer);
        verifyEquals(adminDetailCustomerPage.getValueTextboxByID(companyID),companyName);
        verifyTrue(adminDetailCustomerPage.isDisplayedOptionInCustomerRoles(guestOption));
        verifyTrue(adminDetailCustomerPage.isActiveCheckboxSelected());
        verifyEquals(adminDetailCustomerPage.getAdminCommentTextArea(),adminComment);
        adminCustomersPage = adminDetailCustomerPage.clickBackToCustomerListLink();
        adminCustomersPage.clickToDeleteRegisted();
        adminCustomersPage.selectItemInCustomerRolesMenu(guestOption);
        adminCustomersPage.inputToTextboxById(searchEmailID, email);
        adminCustomersPage.clickSearchButton();
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName(nameTable), firstName + " " + lastName);
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName(companyNameTable), companyName);
    }

    @Test
    public void Customer_02_Search_Customer_With_Email(){
        adminCustomersPage = (AdminCustomersPageObject) adminDashboardPage.clickToMenuSideBarByLink(customerMenu, customerMenu);
        adminCustomersPage.clickToSearchCustomerTab();
        adminCustomersPage.clickToDeleteRegisted();
        adminCustomersPage.selectItemInCustomerRolesMenu(guestOption);
        adminCustomersPage.inputToTextboxById(searchEmailID, email);
        adminCustomersPage.clickSearchButton();
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName(nameTable), firstName + " " + lastName);
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName(customerRoleTable), guestOption);
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName(companyNameTable), companyName);
    }

    @Test
    public void Customer_03_Search_Customer_With_FirstName_And_LastName(){
        adminCustomersPage = (AdminCustomersPageObject) adminDashboardPage.clickToMenuSideBarByLink(customerMenu, customerMenu);
        adminCustomersPage.clickToSearchCustomerTab();
        adminCustomersPage.clickToDeleteRegisted();
        adminCustomersPage.selectItemInCustomerRolesMenu(guestOption);
        adminCustomersPage.inputToTextboxById(searchFirstNameID, firstName);
        adminCustomersPage.inputToTextboxById(searchLastNameID, lastName);
        adminCustomersPage.clickSearchButton();
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName(nameTable), firstName + " " + lastName);
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName(customerRoleTable), guestOption);
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName(companyNameTable), companyName);
    }

    @Test
    public void Customer_04_Search_Customer_With_Company(){
        adminCustomersPage = (AdminCustomersPageObject) adminDashboardPage.clickToMenuSideBarByLink(customerMenu, customerMenu);
        adminCustomersPage.clickToSearchCustomerTab();
        adminCustomersPage.clickToDeleteRegisted();
        adminCustomersPage.selectItemInCustomerRolesMenu(guestOption);
        adminCustomersPage.inputToTextboxById(searchCompanyID, companyName);
        adminCustomersPage.clickSearchButton();
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName(nameTable), firstName + " " + lastName);
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName(customerRoleTable), guestOption);
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName(companyNameTable), companyName);
    }

    @Test
    public void Customer_05_Search_Customer_With_Full_Data(){
        adminCustomersPage = (AdminCustomersPageObject) adminDashboardPage.clickToMenuSideBarByLink(customerMenu, customerMenu);
        adminCustomersPage.clickToSearchCustomerTab();
        adminCustomersPage.clickToDeleteRegisted();
        adminCustomersPage.selectItemInCustomerRolesMenu(guestOption);
        adminCustomersPage.inputToTextboxById(searchEmailID, email);
        adminCustomersPage.inputToTextboxById(searchFirstNameID, firstName);
        adminCustomersPage.inputToTextboxById(searchLastNameID, lastName);
        adminCustomersPage.selectMonthOfBirthDropdown(monthOfBirth);
        adminCustomersPage.selectDayOfBirthDropdown(dayOfBirth);
        adminCustomersPage.inputToTextboxById(searchCompanyID, companyName);
        adminCustomersPage.clickSearchButton();
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName(nameTable), firstName + " " + lastName);
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName(customerRoleTable), guestOption);
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName(companyNameTable), companyName);
    }

    @Test
    public void Customer_06_Edit_Customer(){
        adminCustomersPage = (AdminCustomersPageObject) adminDashboardPage.clickToMenuSideBarByLink(customerMenu, customerMenu);
        adminCustomersPage.clickToSearchCustomerTab();
        adminCustomersPage.clickToDeleteRegisted();
        adminCustomersPage.selectItemInCustomerRolesMenu(guestOption);
        adminCustomersPage.inputToTextboxById(searchEmailID, email);
        adminCustomersPage.inputToTextboxById(searchFirstNameID, firstName);
        adminCustomersPage.inputToTextboxById(searchLastNameID, lastName);
        adminCustomersPage.selectMonthOfBirthDropdown(monthOfBirth);
        adminCustomersPage.selectDayOfBirthDropdown(dayOfBirth);
        adminCustomersPage.inputToTextboxById(searchCompanyID, companyName);
        adminCustomersPage.clickSearchButton();
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName(nameTable), firstName + " " + lastName);
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName(customerRoleTable), guestOption);
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName(companyNameTable), companyName);
        adminDetailCustomerPage = adminCustomersPage.clickEditButtonByName(editTable);
        adminDetailCustomerPage.inputToTextBoxById(emailID, emailEdited);
        adminDetailCustomerPage.inputToTextBoxById(firstNameID, firstNameEdited);
        adminDetailCustomerPage.inputToTextBoxById(lastNameID, lastNameEdited);
        adminDetailCustomerPage.inputToTextBoxById(dobID, dobEdited);
        adminDetailCustomerPage.inputToTextBoxById(companyID, companyEdited);
        adminDetailCustomerPage.inputToAdminComment(adminCommentEdited);
        adminDetailCustomerPage.clickToSaveAndContinueEditButton();
        verifyEquals(adminDetailCustomerPage.getSuccessfulMessage(), "The customer has been updated successfully.");
        verifyEquals(adminDetailCustomerPage.getValueTextboxByID(emailID),emailEdited);
        verifyEquals(adminDetailCustomerPage.getValueTextboxByID(firstNameID),firstNameEdited);
        verifyEquals(adminDetailCustomerPage.getValueTextboxByID(lastNameID),lastNameEdited);
        verifyEquals(adminDetailCustomerPage.getValueTextboxByID(dobID),dobEdited);
        verifyEquals(adminDetailCustomerPage.getValueTextboxByID(companyID), companyEdited);
        verifyEquals(adminDetailCustomerPage.getAdminCommentTextArea(),adminCommentEdited);
        adminCustomersPage = adminDetailCustomerPage.clickSaveButton();
        verifyEquals(adminCustomersPage.getSuccessfulMessage(), "The customer has been updated successfully.");
        adminCustomersPage.clickToDeleteRegisted();
        adminCustomersPage.selectItemInCustomerRolesMenu(guestOption);
        adminCustomersPage.inputToTextboxById(searchEmailID, emailEdited);
        adminCustomersPage.inputToTextboxById(searchFirstNameID, firstNameEdited);
        adminCustomersPage.inputToTextboxById(searchLastNameID, lastNameEdited);
        adminCustomersPage.selectMonthOfBirthDropdown(monthOfBirthEdited);
        adminCustomersPage.selectDayOfBirthDropdown(dayOfBirthEdited);
        adminCustomersPage.inputToTextboxById(searchCompanyID, companyEdited);
        adminCustomersPage.clickSearchButton();
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName(nameTable), firstNameEdited + " " + lastNameEdited);
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName(customerRoleTable), guestOption);
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName(companyNameTable), companyEdited);
    }

    @Test
    public void Customer_07_Add_New_Address_In_Customer_Detail(){
        adminCustomersPage = (AdminCustomersPageObject) adminDashboardPage.clickToMenuSideBarByLink(customerMenu, customerMenu);
        adminCustomersPage.clickToSearchCustomerTab();
        adminCustomersPage.inputToTextboxById(searchEmailID, emailEdited);
        adminCustomersPage.inputToTextboxById(searchFirstNameID, firstNameEdited);
        adminCustomersPage.inputToTextboxById(searchLastNameID, lastNameEdited);
        adminCustomersPage.selectMonthOfBirthDropdown(monthOfBirthEdited);
        adminCustomersPage.selectDayOfBirthDropdown(dayOfBirthEdited);
        adminCustomersPage.inputToTextboxById(searchCompanyID, companyEdited);
        adminCustomersPage.clickToDeleteRegisted();
        adminCustomersPage.selectItemInCustomerRolesMenu(guestOption);
        adminCustomersPage.clickSearchButton();
        adminDetailCustomerPage = adminCustomersPage.clickEditButtonByName(editTable);
        adminDetailCustomerPage.clickToAddressesTab();
        adminDetailCustomerAddressPage = adminDetailCustomerPage.clickToAddNewAddressButton();
        verifyTrue(adminDetailCustomerAddressPage.isDisplayedAddNewAddressHeader());
        adminDetailCustomerAddressPage.inputToTextboxByID(addressFirstNameID, firstName);
        adminDetailCustomerAddressPage.inputToTextboxByID(addressLastNameID, lastName);
        adminDetailCustomerAddressPage.inputToTextboxByID(addressEmailID, email);
        adminDetailCustomerAddressPage.inputToTextboxByID(addressCompanyID, companyName);
        adminDetailCustomerAddressPage.selectCountryDropdown(vietNamCountry);
        adminDetailCustomerAddressPage.inputToTextboxByID(addressCityID, cityName);
        adminDetailCustomerAddressPage.inputToTextboxByID(addressAddress1ID, address1);
        adminDetailCustomerAddressPage.inputToTextboxByID(addressAddress2ID, address2);
        adminDetailCustomerAddressPage.inputToTextboxByID(addressZipID, zipPostalCode);
        adminDetailCustomerAddressPage.inputToTextboxByID(addressPhoneID, phoneNumber);
        adminDetailCustomerAddressPage.clickSaveButton();
        verifyEquals(adminDetailCustomerAddressPage.getSuccessfulMessage(), "The new address has been added " +
                "successfully.");
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID(addressFirstNameID), firstName);
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID(addressLastNameID), lastName);
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID(addressEmailID), email);
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID(addressCompanyID), companyName);
        verifyEquals(adminDetailCustomerAddressPage.getValueDropdownCountry(), vietNamCountry);
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID(addressCityID), cityName);
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID(addressAddress1ID), address1);
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID(addressAddress2ID), address2);
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID(addressZipID), zipPostalCode);
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID(addressPhoneID), phoneNumber);
        adminDetailCustomerPage = adminDetailCustomerAddressPage.clickBackToCustomerDetailsLink();
        verifyEquals(adminDetailCustomerPage.getFirstRowAddressesByName(firstNameTable), firstName);
        verifyEquals(adminDetailCustomerPage.getFirstRowAddressesByName(lastNameTable), lastName);
        verifyEquals(adminDetailCustomerPage.getFirstRowAddressesByName(emailTable), email);
        verifyEquals(adminDetailCustomerPage.getFirstRowAddressesByName(phoneTable), phoneNumber);
        verifyEquals(adminDetailCustomerPage.getFirstRowAddressesByName(addressTable),
                companyName + "\n" + address1 + "\n" + address2 + "\n" + cityName + "," + zipPostalCode + "\n" + vietNamCountry);
    }

    @Test
    public void Customer_08_Edit_Address_In_Customer_Detail(){
        adminCustomersPage = (AdminCustomersPageObject) adminDashboardPage.clickToMenuSideBarByLink(customerMenu, customerMenu);
        adminCustomersPage.clickToSearchCustomerTab();
        adminCustomersPage.inputToTextboxById(searchEmailID, emailEdited);
        adminCustomersPage.inputToTextboxById(searchFirstNameID, firstNameEdited);
        adminCustomersPage.inputToTextboxById(searchLastNameID, lastNameEdited);
        adminCustomersPage.selectMonthOfBirthDropdown(monthOfBirthEdited);
        adminCustomersPage.selectDayOfBirthDropdown(dayOfBirthEdited);
        adminCustomersPage.inputToTextboxById(searchCompanyID, companyEdited);
        adminCustomersPage.clickToDeleteRegisted();
        adminCustomersPage.selectItemInCustomerRolesMenu(guestOption);
        adminCustomersPage.clickSearchButton();
        adminDetailCustomerPage = adminCustomersPage.clickEditButtonByName(editTable);
        adminDetailCustomerPage.clickToAddressesTab();
        adminDetailCustomerPage.clickButtonFirstRowAddressesByName(editTable);
        adminDetailCustomerAddressPage = PageGeneratorManager.getAdminDetailCustomerAddressPage(driver);
        verifyTrue(adminDetailCustomerAddressPage.isDisplayedEditAddressHeader());
        adminDetailCustomerAddressPage.inputToTextboxByID(addressFirstNameID, firstNameEdited);
        adminDetailCustomerAddressPage.inputToTextboxByID(addressLastNameID, lastNameEdited);
        adminDetailCustomerAddressPage.inputToTextboxByID(addressEmailID, emailEdited);
        adminDetailCustomerAddressPage.inputToTextboxByID(addressCompanyID, companyEdited);
        adminDetailCustomerAddressPage.selectCountryDropdown(germanyCountry);
        adminDetailCustomerAddressPage.inputToTextboxByID(addressCityID, cityEdited);
        adminDetailCustomerAddressPage.inputToTextboxByID(addressAddress1ID, address1Edited);
        adminDetailCustomerAddressPage.inputToTextboxByID(addressAddress2ID, address2Edited);
        adminDetailCustomerAddressPage.inputToTextboxByID(addressZipID, zipPostalCodeEdited);
        adminDetailCustomerAddressPage.inputToTextboxByID(addressPhoneID, phoneNumberEdited);
        adminDetailCustomerAddressPage.clickSaveButton();
        verifyEquals(adminDetailCustomerAddressPage.getSuccessfulMessage(), "The address has been updated " +
                "successfully.");
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID(addressFirstNameID), firstNameEdited);
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID(addressLastNameID), lastNameEdited);
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID(addressEmailID), emailEdited);
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID(addressCompanyID), companyEdited);
        verifyEquals(adminDetailCustomerAddressPage.getValueDropdownCountry(), germanyCountry);
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID(addressCityID), cityEdited);
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID(addressAddress1ID), address1Edited);
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID(addressAddress2ID), address2Edited);
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID(addressZipID), zipPostalCodeEdited);
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID(addressPhoneID), phoneNumberEdited);
        adminDetailCustomerPage = adminDetailCustomerAddressPage.clickBackToCustomerDetailsLink();
        verifyEquals(adminDetailCustomerPage.getFirstRowAddressesByName(firstNameTable), firstNameEdited);
        verifyEquals(adminDetailCustomerPage.getFirstRowAddressesByName(lastNameTable), lastNameEdited);
        verifyEquals(adminDetailCustomerPage.getFirstRowAddressesByName(emailTable), emailEdited);
        verifyEquals(adminDetailCustomerPage.getFirstRowAddressesByName(phoneTable), phoneNumberEdited);
        verifyEquals(adminDetailCustomerPage.getFirstRowAddressesByName(addressTable),
                companyEdited + "\n" + address1Edited + "\n" + address2Edited + "\n" + cityEdited + "," + zipPostalCodeEdited + "\n" + germanyCountry);
    }

    @Test
    public void Customer_09_Delete_Address_In_Customer_Detail(){
        adminCustomersPage = (AdminCustomersPageObject) adminDashboardPage.clickToMenuSideBarByLink(customerMenu, customerMenu);
        adminCustomersPage.clickToSearchCustomerTab();
        adminCustomersPage.inputToTextboxById(searchEmailID, emailEdited);
        adminCustomersPage.inputToTextboxById(searchFirstNameID, firstNameEdited);
        adminCustomersPage.inputToTextboxById(searchLastNameID, lastNameEdited);
        adminCustomersPage.selectMonthOfBirthDropdown(monthOfBirthEdited);
        adminCustomersPage.selectDayOfBirthDropdown(dayOfBirthEdited);
        adminCustomersPage.inputToTextboxById(searchCompanyID, companyEdited);
        adminCustomersPage.clickToDeleteRegisted();
        adminCustomersPage.selectItemInCustomerRolesMenu(guestOption);
        adminCustomersPage.clickSearchButton();
        adminDetailCustomerPage = adminCustomersPage.clickEditButtonByName(editTable);
        adminDetailCustomerPage.clickToAddressesTab();
        adminDetailCustomerPage.clickButtonFirstRowAddressesByName(deleteTable);
        adminDetailCustomerPage.acceptAlertMessage();
        verifyEquals(adminDetailCustomerPage.getNoDataAddressMessage(),"No data available in table");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    private String customerMenu, email, password, firstName, lastName, maleGender, dob, companyName, guestRole,
            adminComment, emailID, passwordID, firstNameID, lastNameID, dobID, companyID, dobCustomer, guestOption,
            nameTable, companyNameTable, searchEmailID, customerRoleTable, searchFirstNameID, searchLastNameID,
            searchCompanyID, monthOfBirth, dayOfBirth, editTable, emailEdited, firstNameEdited, lastNameEdited,
            dobEdited, companyEdited, adminCommentEdited, monthOfBirthEdited, dayOfBirthEdited, addressFirstNameID,
            addressLastNameID, addressEmailID, addressCompanyID, addressCityID, addressAddress1ID, addressAddress2ID,
            addressZipID, addressPhoneID, vietNamCountry, cityName, address1, address2, zipPostalCode, phoneNumber,
            firstNameTable, lastNameTable, emailTable, phoneTable, addressTable, deleteTable, germanyCountry,
            cityEdited, address1Edited, address2Edited, zipPostalCodeEdited, phoneNumberEdited;
    private WebDriver driver;
    DataHelper dataFaker;
    String adminEmail, adminPassword;
    UserHomePageObject userHomePage;
    AdminLoginPageObject adminLoginPage;
    private AdminDashboardPageObject adminDashboardPage;
    private AdminCustomersPageObject adminCustomersPage;
    private AdminDetailCustomerPageObject adminDetailCustomerPage;
    private AdminDetailCustomerAddressPageObject adminDetailCustomerAddressPage;
}
