package com.nopcommerce.admin;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.GlobalConstant;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.admin.*;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import reportConfig.ExtentTestManager;
import utilities.DataHelper;

import java.lang.reflect.Method;

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

        userHomePage = PageGeneratorManager.getUserHomePage(driver);
        userHomePage.openPageURL(GlobalConstant.getGlobalConstants().getAdminPageURL());
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
        adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmail, adminPassword);
        verifyTrue(adminDashboardPage.isAdminDashboardHeaderDisplayed());
    }

    @Test
    public void Customer_01_Create_New_Customer(Method method){
        ExtentTestManager.startTest(method.getName(), "Customer_01_Create_new_customer");
        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 01: Click to " + customerMenu + " Menu Sidebar");
        adminDashboardPage.clickToMenuSideBarByName(customerMenu);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 02: Click to " + customerMenu + " Menu Sidebar Link");
        adminCustomersPage = (AdminCustomersPageObject) adminDashboardPage.clickToMenuSideBarByLink(customerMenu, customerMenu);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 03: Click to Search customer Tab");
        adminCustomersPage.clickToSearchCustomerTab();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 04: Click add new button");
        adminDetailCustomerPage = adminCustomersPage.clickAddNewButton();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 05: Verify displayed add new customer page");
        verifyTrue(adminDetailCustomerPage.isDisplayedAddNewCustomerPage());

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 06: Input " + email + " to email textbox");
        adminDetailCustomerPage.inputToTextBoxById("Email", email);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 07: Input " + password + " to password textbox");
        adminDetailCustomerPage.inputToTextBoxById("Password", password);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 07: Input " + firstName + " to first name textbox");
        adminDetailCustomerPage.inputToTextBoxById("FirstName", firstName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 08: Input " + lastName + " to last name textbox");
        adminDetailCustomerPage.inputToTextBoxById("LastName", lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 09: Select female radio button");
        adminDetailCustomerPage.selectFemaleRadioButton();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 10: Input " + dobCustomer + " to date of birth textbox");
        adminDetailCustomerPage.inputToTextBoxById("DateOfBirth", dobCustomer);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 11: Input " + companyName + " to company name textbox");
        adminDetailCustomerPage.inputToTextBoxById("Company", companyName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 12: Click to remove Registed option in customer roles");
        adminDetailCustomerPage.clickToRemoveRegistedOption();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 13: Select " + guestOption + " option in customer roles");
        adminDetailCustomerPage.selectItemInCustomerRolesMenu(guestOption);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 14: Input " + adminComment + " to admin comment text area");
        adminDetailCustomerPage.inputToAdminComment(adminComment);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 15: Click to Save and continue edit button");
        adminDetailCustomerPage.clickToSaveAndContinueEditButton();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 16: Verify displayed successfull create new customer message");
        verifyEquals(adminDetailCustomerPage.getSuccessfulMessage(), "The new customer has been added successfully.");

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 17: Verify " + email + " added in email textbox");
        verifyEquals(adminDetailCustomerPage.getValueTextboxByID("Email"),email);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 18: Verify " + firstName + " added in first name textbox");
        verifyEquals(adminDetailCustomerPage.getValueTextboxByID("FirstName"),firstName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 19: Verify " + lastName + " added in last name textbox");
        verifyEquals(adminDetailCustomerPage.getValueTextboxByID("LastName"),lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 20: Verify female gender is selected");
        verifyTrue(adminDetailCustomerPage.isFemaleRadioButtonSelected());

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 21: Verify " + dobCustomer + " added in date of birth textbox");
        verifyEquals(adminDetailCustomerPage.getValueTextboxByID("DateOfBirth"),dobCustomer);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 22: Verify " + companyName + " added in company name textbox");
        verifyEquals(adminDetailCustomerPage.getValueTextboxByID("Company"),companyName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 23: Verify " + guestOption + " selected in customer roles");
        verifyTrue(adminDetailCustomerPage.isDisplayedOptionInCustomerRoles(guestOption));

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 24: Verify active checkbox is selected");
        verifyTrue(adminDetailCustomerPage.isActiveCheckboxSelected());

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 25: Verify " + adminComment + " added in admin comment text area");
        verifyEquals(adminDetailCustomerPage.getAdminCommentTextArea(),adminComment);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 26: Click back to customer list link");
        adminCustomersPage = adminDetailCustomerPage.clickBackToCustomerListLink();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 27: Click to remove Registed option in customer roles");
        adminCustomersPage.clickToDeleteRegisted();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 28: Select " + guestOption + " option in customer roles");
        adminCustomersPage.selectItemInCustomerRolesMenu(guestOption);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 29: Input " + email + " to email textbox");
        adminCustomersPage.inputToTextboxById("SearchEmail", email);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 30: Click search button");
        adminCustomersPage.clickSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 31: Verify that display customer name in search table");
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName("Name"), firstName + " " + lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 01 - Create new customer - Step 32: Verify that display company name in search table");
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName("Company name"), companyName);
    }

    @Test
    public void Customer_02_Search_Customer_With_Email(Method method){
        ExtentTestManager.startTest(method.getName(), "Customer_02_Search_customer_with_Email");
        ExtentTestManager.getTest().log(Status.INFO, "Customer 02 - Search customer with email - Step 01: Click to " + customerMenu + " Menu Sidebar Link");
        adminCustomersPage = (AdminCustomersPageObject) adminDashboardPage.clickToMenuSideBarByLink(customerMenu, customerMenu);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 02 - Search customer with email - Step 02: Click to Search customer Tab");
        adminCustomersPage.clickToSearchCustomerTab();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 02 - Search customer with email - Step 03: Click to remove Registed option in customer roles");
        adminCustomersPage.clickToDeleteRegisted();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 02 - Search customer with email - Step 04: Select " + guestOption + " option in customer roles");
        adminCustomersPage.selectItemInCustomerRolesMenu(guestOption);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 02 - Search customer with email - Step 05: Input " + email + " to email textbox");
        adminCustomersPage.inputToTextboxById("SearchEmail", email);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 02 - Search customer with email - Step 06: Click search button");
        adminCustomersPage.clickSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 02 - Search customer with email - Step 07: Verify that display customer name in search table");
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName("Name"), firstName + " " + lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 02 - Search customer with email - Step 08: Verify that display customer roles in search table");
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName("Customer roles"), guestOption);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 02 - Search customer with email - Step 09: Verify that display company name in search table");
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName("Company name"), companyName);
    }

    @Test
    public void Customer_03_Search_Customer_With_FirstName_And_LastName(Method method){
        ExtentTestManager.startTest(method.getName(), "Customer_03_Search_customer_with_FirstName_and_LastName");
        ExtentTestManager.getTest().log(Status.INFO, "Customer 03 - Search customer with FirstName and LastName - Step 01: Click to " + customerMenu + " Menu Sidebar Link");
        adminCustomersPage = (AdminCustomersPageObject) adminDashboardPage.clickToMenuSideBarByLink(customerMenu, customerMenu);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 03 - Search customer with FirstName and LastName - Step 02: Click to Search customer Tab");
        adminCustomersPage.clickToSearchCustomerTab();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 03 - Search customer with FirstName and LastName - Step 03: Click to remove Registed option in customer roles");
        adminCustomersPage.clickToDeleteRegisted();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 03 - Search customer with FirstName and LastName - Step 04: Select " + guestOption + " option in customer roles");
        adminCustomersPage.selectItemInCustomerRolesMenu(guestOption);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 03 - Search customer with FirstName and LastName - Step 05: Input " + firstName + " to first name textbox");
        adminCustomersPage.inputToTextboxById("SearchFirstName", firstName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 03 - Search customer with FirstName and LastName - Step 06: Input " + lastName + " to last name textbox");
        adminCustomersPage.inputToTextboxById("SearchLastName", lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 03 - Search customer with FirstName and LastName - Step 07: Click search button");
        adminCustomersPage.clickSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 03 - Search customer with FirstName and LastName - Step 08: Verify that display customer name in search table");
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName("Name"), firstName + " " + lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 03 - Search customer with FirstName and LastName - Step 09: Verify that display customer roles in search table");
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName("Customer roles"), guestOption);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 03 - Search customer with FirstName and LastName - Step 10: Verify that display company name in search table");
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName("Company name"), companyName);
    }

    @Test
    public void Customer_04_Search_Customer_With_Company(Method method){
        ExtentTestManager.startTest(method.getName(), "Customer_04_Search_customer_with_Company");
        ExtentTestManager.getTest().log(Status.INFO, "Customer 04 - Search customer with company - Step 01: Click to " + customerMenu + " Menu Sidebar Link");
        adminCustomersPage = (AdminCustomersPageObject) adminDashboardPage.clickToMenuSideBarByLink(customerMenu, customerMenu);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 04 - Search customer with company - Step 02: Click to Search customer Tab");
        adminCustomersPage.clickToSearchCustomerTab();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 04 - Search customer with company - Step 03: Click to remove Registed option in customer roles");
        adminCustomersPage.clickToDeleteRegisted();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 04 - Search customer with company - Step 04: Select " + guestOption + " option in customer roles");
        adminCustomersPage.selectItemInCustomerRolesMenu(guestOption);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 04 - Search customer with company - Step 05: Input " + companyName + " to company textbox");
        adminCustomersPage.inputToTextboxById("SearchCompany", companyName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 04 - Search customer with company - Step 06: Click search button");
        adminCustomersPage.clickSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 04 - Search customer with company - Step 07: Verify that display customer name in search table");
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName("Name"), firstName + " " + lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 04 - Search customer with company - Step 08: Verify that display customer roles in search table");
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName("Customer roles"), guestOption);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 04 - Search customer with company - Step 09: Verify that display company name in search table");
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName("Company name"), companyName);
    }

    @Test
    public void Customer_05_Search_Customer_With_Full_Data(Method method){
        ExtentTestManager.startTest(method.getName(), "Customer_05_Search_customer_with_Full_Data");
        ExtentTestManager.getTest().log(Status.INFO, "Customer 05 - Search customer with Full data - Step 01: Click to " + customerMenu + " Menu Sidebar Link");
        adminCustomersPage = (AdminCustomersPageObject) adminDashboardPage.clickToMenuSideBarByLink(customerMenu, customerMenu);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 05 - Search customer with Full data - Step 02: Click to Search customer Tab");
        adminCustomersPage.clickToSearchCustomerTab();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 05 - Search customer with Full data - Step 03: Click to remove Registed option in customer roles");
        adminCustomersPage.clickToDeleteRegisted();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 05 - Search customer with Full data - Step 04: Select " + guestOption + " option in customer roles");
        adminCustomersPage.selectItemInCustomerRolesMenu(guestOption);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 05 - Search customer with Full data - Step 05: Input " + email + " to email textbox");
        adminCustomersPage.inputToTextboxById("SearchEmail", email);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 05 - Search customer with Full data - Step 06: Input " + firstName + " to first name textbox");
        adminCustomersPage.inputToTextboxById("SearchFirstName", firstName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 05 - Search customer with Full data - Step 07: Input " + lastName + " to last name textbox");
        adminCustomersPage.inputToTextboxById("SearchLastName", lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 05 - Search customer with Full data - Step 08: Select " + monthOfBirth + " in Month of birth dropdown");
        adminCustomersPage.selectMonthOfBirthDropdown(monthOfBirth);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 05 - Search customer with Full data - Step 09: Select " + dayOfBirth + " in Day of birth dropdown");
        adminCustomersPage.selectDayOfBirthDropdown(dayOfBirth);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 05 - Search customer with Full data - Step 10: Input " + companyName + " to company textbox");
        adminCustomersPage.inputToTextboxById("SearchCompany", companyName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 05 - Search customer with Full data - Step 11: Click search button");
        adminCustomersPage.clickSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 05 - Search customer with Full data - Step 12: Verify that display customer name in search table");
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName("Name"), firstName + " " + lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 05 - Search customer with Full data - Step 13: Verify that display customer roles in search table");
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName("Customer roles"), guestOption);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 05 - Search customer with Full data - Step 14: Verify that display company name in search table");
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName("Company name"), companyName);
    }

    @Test
    public void Customer_06_Edit_Customer(Method method){
        ExtentTestManager.startTest(method.getName(), "Customer_06_Edit_Customer");
        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 01: Click to " + customerMenu + " Menu Sidebar Link");
        adminCustomersPage = (AdminCustomersPageObject) adminDashboardPage.clickToMenuSideBarByLink(customerMenu, customerMenu);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 02: Click to Search customer Tab");
        adminCustomersPage.clickToSearchCustomerTab();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 03: Click to remove Registed option in customer roles");
        adminCustomersPage.clickToDeleteRegisted();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 04: Select " + guestOption + " option in customer roles");
        adminCustomersPage.selectItemInCustomerRolesMenu(guestOption);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 05: Input " + email + " to email textbox");
        adminCustomersPage.inputToTextboxById("SearchEmail", email);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 06: Input " + firstName + " to first name textbox");
        adminCustomersPage.inputToTextboxById("SearchFirstName", firstName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 07: Input " + lastName + " to last name textbox");
        adminCustomersPage.inputToTextboxById("SearchLastName", lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 08: Select " + monthOfBirth + " in Month of birth dropdown");
        adminCustomersPage.selectMonthOfBirthDropdown(monthOfBirth);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 09: Select " + dayOfBirth + " in Day of birth dropdown");
        adminCustomersPage.selectDayOfBirthDropdown(dayOfBirth);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 10: Input " + companyName + " to company textbox");
        adminCustomersPage.inputToTextboxById("SearchCompany", companyName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 11: Click search button");
        adminCustomersPage.clickSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 12: Verify that display customer name in search table");
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName("Name"), firstName + " " + lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 13: Verify that display customer roles in search table");
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName("Customer roles"), guestOption);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 14: Verify that display company name in search table");
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName("Company name"), companyName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 15: Click Edit customer button in search table");
        adminDetailCustomerPage = adminCustomersPage.clickEditButtonByName("Edit");

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 16: Input " + emailEdited + " to email textbox");
        adminDetailCustomerPage.inputToTextBoxById("Email", emailEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 17: Input " + firstNameEdited + " to first name textbox");
        adminDetailCustomerPage.inputToTextBoxById("FirstName", firstNameEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 18: Input " + lastNameEdited + " to last name textbox");
        adminDetailCustomerPage.inputToTextBoxById("LastName", lastNameEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 19: Input " + dobEdited + " to date of birth textbox");
        adminDetailCustomerPage.inputToTextBoxById("DateOfBirth", dobEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 20: Input " + companyEdited + " to company name textbox");
        adminDetailCustomerPage.inputToTextBoxById("Company", companyEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 21: Input " + adminCommentEdited + " to admin comment text area");
        adminDetailCustomerPage.inputToAdminComment(adminCommentEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 22: Click to Save and continue edit button");
        adminDetailCustomerPage.clickToSaveAndContinueEditButton();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 23: Verify displayed successfull message update customer");
        verifyEquals(adminDetailCustomerPage.getSuccessfulMessage(), "The customer has been updated successfully.");

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 24: Verify " + emailEdited + " added in email textbox");
        verifyEquals(adminDetailCustomerPage.getValueTextboxByID("Email"),emailEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 25: Verify " + firstNameEdited + " added in first name textbox");
        verifyEquals(adminDetailCustomerPage.getValueTextboxByID("FirstName"),firstNameEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 26: Verify " + lastNameEdited + " added in last name textbox");
        verifyEquals(adminDetailCustomerPage.getValueTextboxByID("LastName"),lastNameEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 27: Verify " + dobEdited + " added in date of birth textbox");
        verifyEquals(adminDetailCustomerPage.getValueTextboxByID("DateOfBirth"),dobEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 28: Verify " + companyEdited + " added in company name textbox");
        verifyEquals(adminDetailCustomerPage.getValueTextboxByID("Company"), companyEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 29: Verify " + adminCommentEdited + " added in admin comment text area");
        verifyEquals(adminDetailCustomerPage.getAdminCommentTextArea(),adminCommentEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 30: Click to Save button");
        adminCustomersPage = adminDetailCustomerPage.clickSaveButton();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 31: Verify displayed successfull update customer message");
        verifyEquals(adminCustomersPage.getSuccessfulMessage(), "The customer has been updated successfully.");

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 32: Click to remove Registed option in customer roles");
        adminCustomersPage.clickToDeleteRegisted();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 33: Select " + guestOption + " option in customer roles");
        adminCustomersPage.selectItemInCustomerRolesMenu(guestOption);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 34: Input " + emailEdited + " to email textbox");
        adminCustomersPage.inputToTextboxById("SearchEmail", emailEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 35: Input " + firstNameEdited + " to first name textbox");
        adminCustomersPage.inputToTextboxById("SearchFirstName", firstNameEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 36: Input " + lastNameEdited + " to last name textbox");
        adminCustomersPage.inputToTextboxById("SearchLastName", lastNameEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 37: Select " + monthOfBirthEdited + " in Month of birth dropdown");
        adminCustomersPage.selectMonthOfBirthDropdown(monthOfBirthEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 38: Select " + dayOfBirthEdited + " in Day of birth dropdown");
        adminCustomersPage.selectDayOfBirthDropdown(dayOfBirthEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 39: Input " + companyEdited + " to company textbox");
        adminCustomersPage.inputToTextboxById("SearchCompany", companyEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 40: Click search button");
        adminCustomersPage.clickSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 41: Verify that display customer name in search table");
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName("Name"), firstNameEdited + " " + lastNameEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 42: Verify that display customer roles in search table");
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName("Customer roles"), guestOption);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 06 - Edit customer - Step 43: Verify that display company name in search table");
        verifyEquals(adminCustomersPage.getFirstRowCustomerByName("Company name"), companyEdited);
    }

    @Test
    public void Customer_07_Add_New_Address_In_Customer_Detail(Method method){
        ExtentTestManager.startTest(method.getName(), "Customer_07_Add_new_address_in_Customer_detail");
        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 01: Click to " + customerMenu + " Menu Sidebar Link");
        adminCustomersPage = (AdminCustomersPageObject) adminDashboardPage.clickToMenuSideBarByLink(customerMenu, customerMenu);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 02: Click to Search customer Tab");
        adminCustomersPage.clickToSearchCustomerTab();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 03: Input " + emailEdited + " to email textbox");
        adminCustomersPage.inputToTextboxById("SearchEmail", emailEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 04: Input " + firstNameEdited + " to first name textbox");
        adminCustomersPage.inputToTextboxById("SearchFirstName", firstNameEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 05: Input " + lastNameEdited + " to last name textbox");
        adminCustomersPage.inputToTextboxById("SearchLastName", lastNameEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 06: Select " + monthOfBirthEdited + " in Month of birth dropdown");
        adminCustomersPage.selectMonthOfBirthDropdown(monthOfBirthEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 07: Select " + dayOfBirthEdited + " in Day of birth dropdown");
        adminCustomersPage.selectDayOfBirthDropdown(dayOfBirthEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 08: Input " + companyEdited + " to company textbox");
        adminCustomersPage.inputToTextboxById("SearchCompany", companyEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 09: Click to remove Registed option in customer roles");
        adminCustomersPage.clickToDeleteRegisted();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 10: Select " + guestOption + " option in customer roles");
        adminCustomersPage.selectItemInCustomerRolesMenu(guestOption);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 11: Click search button");
        adminCustomersPage.clickSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 12: Click Edit customer button in search table");
        adminDetailCustomerPage = adminCustomersPage.clickEditButtonByName("Edit");

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 13: Click to Addresses Tab");
        adminDetailCustomerPage.clickToAddressesTab();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 14: Click to Add new address button");
        adminDetailCustomerAddressPage = adminDetailCustomerPage.clickToAddNewAddressButton();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 15: Verify displayed Add new address customer page");
        verifyTrue(adminDetailCustomerAddressPage.isDisplayedAddNewAddressHeader());

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 16: Input " + firstName + " to first name textbox");
        adminDetailCustomerAddressPage.inputToTextboxByID("Address_FirstName", firstName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 17: Input " + lastName + " to last name textbox");
        adminDetailCustomerAddressPage.inputToTextboxByID("Address_LastName", lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 18: Input " + email + " to email textbox");
        adminDetailCustomerAddressPage.inputToTextboxByID("Address_Email", email);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 19: Input " + companyName + " to company textbox");
        adminDetailCustomerAddressPage.inputToTextboxByID("Address_Company", companyName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 20: Select " + vietNamCountry + " in Country dropdown");
        adminDetailCustomerAddressPage.selectCountryDropdown(vietNamCountry);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 21: Input " + cityName + " to City textbox");
        adminDetailCustomerAddressPage.inputToTextboxByID("Address_City", cityName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 22: Input " + address1 + " to Address 1 textbox");
        adminDetailCustomerAddressPage.inputToTextboxByID("Address_Address1", address1);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 23: Input " + address2 + " to Address 2 textbox");
        adminDetailCustomerAddressPage.inputToTextboxByID("Address_Address2", address2);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 24: Input " + zipPostalCode + " to Zip / postal Code textbox");
        adminDetailCustomerAddressPage.inputToTextboxByID("Address_ZipPostalCode", zipPostalCode);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 25: Input " + phoneNumber + " to Phone number textbox");
        adminDetailCustomerAddressPage.inputToTextboxByID("Address_PhoneNumber", phoneNumber);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 26: Click Save button");
        adminDetailCustomerAddressPage.clickSaveButton();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 27: Verify that displayed successful add new address message");
        verifyEquals(adminDetailCustomerAddressPage.getSuccessfulMessage(), "The new address has been added successfully.");

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 28: Verify " + firstName + " added in first name textbox");
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID("Address_FirstName"), firstName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 29: Verify " + lastName + " added in last name textbox");
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID("Address_LastName"), lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 30: Verify " + email + " added in email textbox");
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID("Address_Email"), email);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 31: Verify " + companyName + " added in company name textbox");
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID("Address_Company"), companyName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 32: Verify " + vietNamCountry + " is selected in Country dropdown");
        verifyEquals(adminDetailCustomerAddressPage.getValueDropdownCountry(), vietNamCountry);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 33: Verify " + cityName + " added in City textbox");
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID("Address_City"), cityName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 34: Verify " + address1 + " added in Address 1 textbox");
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID("Address_Address1"), address1);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 35: Verify " + address2 + " added in Address 2 textbox");
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID("Address_Address2"), address2);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 36: Verify " + zipPostalCode + " added in Zip / postal Code textbox");
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID("Address_ZipPostalCode"), zipPostalCode);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 37: Verify " + phoneNumber + " added in Phone number textbox");
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID("Address_PhoneNumber"), phoneNumber);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 38: Click Back to customer details link");
        adminDetailCustomerPage = adminDetailCustomerAddressPage.clickBackToCustomerDetailsLink();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 39: Verify that display " + firstName + " in Addresses table");
        verifyEquals(adminDetailCustomerPage.getFirstRowAddressesByName("First name"), firstName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 40: Verify that display " + lastName + " in Addresses table");
        verifyEquals(adminDetailCustomerPage.getFirstRowAddressesByName("Last name"), lastName);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 41: Verify that display " + email + " in Addresses table");
        verifyEquals(adminDetailCustomerPage.getFirstRowAddressesByName("Email"), email);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 42: Verify that display " + phoneNumber + " in Addresses table");
        verifyEquals(adminDetailCustomerPage.getFirstRowAddressesByName("Phone number"), phoneNumber);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 07 - Add new address in Customer details - Step 43: Verify that display Address in Addresses table");
        verifyEquals(adminDetailCustomerPage.getFirstRowAddressesByName("Address"),
                companyName + "\n" + address1 + "\n" + address2 + "\n" + cityName + "," + zipPostalCode + "\n" + vietNamCountry);
    }

    @Test
    public void Customer_08_Edit_Address_In_Customer_Detail(Method method){
        ExtentTestManager.startTest(method.getName(), "Customer_08_Edit_Address_in_customer_detail");
        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 01: Click to " + customerMenu + " Menu Sidebar Link");
        adminCustomersPage = (AdminCustomersPageObject) adminDashboardPage.clickToMenuSideBarByLink(customerMenu, customerMenu);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 02: Click to Search customer Tab");
        adminCustomersPage.clickToSearchCustomerTab();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 03: Input " + emailEdited + " to email textbox");
        adminCustomersPage.inputToTextboxById("SearchEmail", emailEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 04: Input " + firstNameEdited + " to first name textbox");
        adminCustomersPage.inputToTextboxById("SearchFirstName", firstNameEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 05: Input " + lastNameEdited + " to last name textbox");
        adminCustomersPage.inputToTextboxById("SearchLastName", lastNameEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 06: Select " + monthOfBirthEdited + " in Month of birth dropdown");
        adminCustomersPage.selectMonthOfBirthDropdown(monthOfBirthEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 07: Select " + dayOfBirthEdited + " in Day of birth dropdown");
        adminCustomersPage.selectDayOfBirthDropdown(dayOfBirthEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 08: Input " + companyEdited + " to company textbox");
        adminCustomersPage.inputToTextboxById("SearchCompany", companyEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 09: Click to remove Registed option in customer roles");
        adminCustomersPage.clickToDeleteRegisted();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 10: Select " + guestOption + " option in customer roles");
        adminCustomersPage.selectItemInCustomerRolesMenu(guestOption);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 11: Click search button");
        adminCustomersPage.clickSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 12: Click Edit customer button in search table");
        adminDetailCustomerPage = adminCustomersPage.clickEditButtonByName("Edit");

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 13: Click to Addresses Tab");
        adminDetailCustomerPage.clickToAddressesTab();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 14: Click Edit button in Addresses table");
        adminDetailCustomerPage.clickButtonFirstRowAddressesByName("Edit");
        adminDetailCustomerAddressPage = PageGeneratorManager.getAdminDetailCustomerAddressPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 15: Verify displayed Edit Address Page");
        verifyTrue(adminDetailCustomerAddressPage.isDisplayedEditAddressHeader());

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 16: Input " + firstNameEdited + " to first name textbox");
        adminDetailCustomerAddressPage.inputToTextboxByID("Address_FirstName", firstNameEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 17: Input " + lastNameEdited + " to last name textbox");
        adminDetailCustomerAddressPage.inputToTextboxByID("Address_LastName", lastNameEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 18: Input " + emailEdited + " to email textbox");
        adminDetailCustomerAddressPage.inputToTextboxByID("Address_Email", emailEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 19: Input " + companyEdited + " to company textbox");
        adminDetailCustomerAddressPage.inputToTextboxByID("Address_Company", companyEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 20: Select " + germanyCountry + " in Country dropdown");
        adminDetailCustomerAddressPage.selectCountryDropdown(germanyCountry);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 21: Input " + cityEdited + " to City textbox");
        adminDetailCustomerAddressPage.inputToTextboxByID("Address_City", cityEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 22: Input " + address1Edited + " to Address 1 textbox");
        adminDetailCustomerAddressPage.inputToTextboxByID("Address_Address1", address1Edited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 23: Input " + address2Edited + " to Address 2 textbox");
        adminDetailCustomerAddressPage.inputToTextboxByID("Address_Address2", address2Edited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 24: Input " + zipPostalCodeEdited + " to Zip / postal Code textbox");
        adminDetailCustomerAddressPage.inputToTextboxByID("Address_ZipPostalCode", zipPostalCodeEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 25: Input " + phoneNumberEdited + " to Phone number textbox");
        adminDetailCustomerAddressPage.inputToTextboxByID("Address_PhoneNumber", phoneNumberEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 26: Click Save button");
        adminDetailCustomerAddressPage.clickSaveButton();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 27: Verify that displayed successful update address message");
        verifyEquals(adminDetailCustomerAddressPage.getSuccessfulMessage(), "The address has been updated successfully.");

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 28: Verify " + firstNameEdited + " added in first name textbox");
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID("Address_FirstName"), firstNameEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 29: Verify " + lastNameEdited + " added in last name textbox");
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID("Address_LastName"), lastNameEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 30: Verify " + emailEdited + " added in email textbox");
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID("Address_Email"), emailEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 31: Verify " + companyEdited + " added in company name textbox");
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID("Address_Company"), companyEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 32: Verify " + germanyCountry + " is selected in Country dropdown");
        verifyEquals(adminDetailCustomerAddressPage.getValueDropdownCountry(), germanyCountry);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 33: Verify " + cityEdited + " added in City textbox");
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID("Address_City"), cityEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 34: Verify " + address1Edited + " added in Address 1 textbox");
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID("Address_Address1"), address1Edited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 35: Verify " + address2Edited + " added in Address 2 textbox");
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID("Address_Address2"), address2Edited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 36: Verify " + zipPostalCodeEdited + " added in Zip / postal Code textbox");
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID("Address_ZipPostalCode"), zipPostalCodeEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 37: Verify " + phoneNumberEdited + " added in Phone number textbox");
        verifyEquals(adminDetailCustomerAddressPage.getValueTextboxByID("Address_PhoneNumber"), phoneNumberEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 38: Click Back to customer details link");
        adminDetailCustomerPage = adminDetailCustomerAddressPage.clickBackToCustomerDetailsLink();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 39: Verify that display " + firstNameEdited + " in Addresses table");
        verifyEquals(adminDetailCustomerPage.getFirstRowAddressesByName("First name"), firstNameEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 40: Verify that display " + lastNameEdited + " in Addresses table");
        verifyEquals(adminDetailCustomerPage.getFirstRowAddressesByName("Last name"), lastNameEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 41: Verify that display " + emailEdited + " in Addresses table");
        verifyEquals(adminDetailCustomerPage.getFirstRowAddressesByName("Email"), emailEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 42: Verify that display " + phoneNumberEdited + " in Addresses table");
        verifyEquals(adminDetailCustomerPage.getFirstRowAddressesByName("Phone number"), phoneNumberEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 08 - Edit Address in Customer details - Step 43: Verify that display Address in Addresses table");
        verifyEquals(adminDetailCustomerPage.getFirstRowAddressesByName("Address"),
                companyEdited + "\n" + address1Edited + "\n" + address2Edited + "\n" + cityEdited + "," + zipPostalCodeEdited + "\n" + germanyCountry);
    }

    @Test
    public void Customer_09_Delete_Address_In_Customer_Detail(Method method){
        ExtentTestManager.startTest(method.getName(), "Customer_09_Delete_Address_in_customer_detail");
        ExtentTestManager.getTest().log(Status.INFO, "Customer 09 - Delete Address in Customer details - Step 01: Click to " + customerMenu + " Menu Sidebar Link");
        adminCustomersPage = (AdminCustomersPageObject) adminDashboardPage.clickToMenuSideBarByLink(customerMenu, customerMenu);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 09 - Delete Address in Customer details - Step 02: Click to Search customer Tab");
        adminCustomersPage.clickToSearchCustomerTab();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 09 - Delete Address in Customer details - Step 03: Input " + emailEdited + " to email textbox");
        adminCustomersPage.inputToTextboxById("SearchEmail", emailEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 09 - Delete Address in Customer details - Step 04: Input " + firstNameEdited + " to first name textbox");
        adminCustomersPage.inputToTextboxById("SearchFirstName", firstNameEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 09 - Delete Address in Customer details - Step 05: Input " + lastNameEdited + " to last name textbox");
        adminCustomersPage.inputToTextboxById("SearchLastName", lastNameEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 09 - Delete Address in Customer details - Step 06: Select " + monthOfBirthEdited + " in Month of birth dropdown");
        adminCustomersPage.selectMonthOfBirthDropdown(monthOfBirthEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 09 - Delete Address in Customer details - Step 07: Select " + dayOfBirthEdited + " in Day of birth dropdown");
        adminCustomersPage.selectDayOfBirthDropdown(dayOfBirthEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 09 - Delete Address in Customer details - Step 08: Input " + companyEdited + " to company textbox");
        adminCustomersPage.inputToTextboxById("SearchCompany", companyEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 09 - Delete Address in Customer details - Step 09: Click to remove Registed option in customer roles");
        adminCustomersPage.clickToDeleteRegisted();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 09 - Delete Address in Customer details - Step 10: Select " + guestOption + " option in customer roles");
        adminCustomersPage.selectItemInCustomerRolesMenu(guestOption);

        ExtentTestManager.getTest().log(Status.INFO, "Customer 09 - Delete Address in Customer details - Step 11: Click search button");
        adminCustomersPage.clickSearchButton();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 09 - Delete Address in Customer details - Step 12: Click Edit customer button in search table");
        adminDetailCustomerPage = adminCustomersPage.clickEditButtonByName("Edit");

        ExtentTestManager.getTest().log(Status.INFO, "Customer 09 - Delete Address in Customer details - Step 13: Click to Addresses Tab");
        adminDetailCustomerPage.clickToAddressesTab();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 09 - Delete Address in Customer details - Step 14: Click Delete button in Addresses table");
        adminDetailCustomerPage.clickButtonFirstRowAddressesByName("Delete");

        ExtentTestManager.getTest().log(Status.INFO, "Customer 09 - Delete Address in Customer details - Step 15: Accept pop up alert");
        adminDetailCustomerPage.acceptAlertMessage();

        ExtentTestManager.getTest().log(Status.INFO, "Customer 09 - Delete Address in Customer details - Step 16: Verify delete successfully address");
        verifyEquals(adminDetailCustomerPage.getNoDataAddressMessage(),"No data available in table");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    private String customerMenu, email, password, firstName, lastName, maleGender, dob, companyName, guestRole,
            adminComment, dobCustomer, guestOption, monthOfBirth, dayOfBirth, emailEdited, firstNameEdited, lastNameEdited,
            dobEdited, companyEdited, adminCommentEdited, monthOfBirthEdited, dayOfBirthEdited,
            vietNamCountry, cityName, address1, address2, zipPostalCode, phoneNumber, germanyCountry,
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
