package com.nopcommerce.user;

import commons.BaseTest;
import commons.CommonRegisterLogin;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.user.*;
import utilities.DataHelper;
import utilities.ElementData;

public class User_08_Payment extends BaseTest {
    @Parameters({"envName", "severName", "browserName", "osName", "ipAddress", "portNumber"})
    @BeforeClass
    public void beforeClass(@Optional("local") String envName, @Optional("dev") String severName, @Optional("chrome")
    String browserName, @Optional("10") String osName, @Optional("142") String ipAddress, @Optional("9999") String portNumber) {
        driver = getBrowserDriver(envName, severName, browserName, osName, ipAddress, portNumber);
        dataFaker = DataHelper.getData();
        emailBill = dataFaker.getEmail();
        firstNameBill = dataFaker.getFirstName();
        lastNameBill = dataFaker.getLastName();
        countryBill = "Viet Nam";
        cityBill = dataFaker.getCity();
        address1Bill = dataFaker.getAddress();
        zipCodeBill = "550000";
        phoneBill = dataFaker.getPhone();
        emailShip = dataFaker.getEmail();
        firstNameShip = dataFaker.getFirstName();
        lastNameShip = dataFaker.getLastName();
        countryShip = "Cape Verde";
        cityShip = dataFaker.getCity();
        address1Ship = dataFaker.getAddress();
        zipCodeShip = "440000";
        phoneShip = dataFaker.getPhone();
        moneyMethod = "Check / Money Order";
        radio2ndDay = "2nd Day Air";
        zip550000 = "550000";
        newAddress = "New Address";
        radio2ndDayLabel = "2nd Day Air ($0.00)";

        appleMacProduct = "Apple MacBook Pro 13-inch";
        successCartMess = "The product has been added to your shopping cart";
        successOrder = "Your order has been successfully processed!";
        billingAddress = "Billing Address";
        nameValue = "name";
        emailValue = "email";
        phoneValue = "phone";
        faxValue = "fax";
        address1Value = "address1";
        cityZipValue = "city-state-zip";
        countryValue = "country";
        shippingAddress = "Shipping Address";
        firstNameBillID = "BillingNewAddress_FirstName";
        lastNameBillID = "BillingNewAddress_LastName";
        emailBillID = "BillingNewAddress_Email";
        countryBillID = "BillingNewAddress_CountryId";
        cityBillID = "BillingNewAddress_City";
        address1BillID = "BillingNewAddress_Address1";
        zipCodeBillID = "BillingNewAddress_ZipPostalCode";
        phoneBillID = "BillingNewAddress_PhoneNumber";
        buttonBillID = "billing-buttons-container";
        firstNameShipID = "ShippingNewAddress_FirstName";
        lastNameShipID = "ShippingNewAddress_LastName";
        emailShipID = "ShippingNewAddress_Email";
        countryShipID = "ShippingNewAddress_CountryId";
        cityShipID = "ShippingNewAddress_City";
        address1ShipID = "ShippingNewAddress_Address1";
        zipCodeShipID = "ShippingNewAddress_ZipPostalCode";
        phoneShipID = "ShippingNewAddress_PhoneNumber";
        buttonShipID = "shipping-buttons-container";
        shippingLabel = "Shipping:";
        taxLabel = "Tax:";
        subTotalPriceLabel = "Sub-Total:";
        skuTableValue = "sku-number";
        unitTableValue = "product-unit-price";
        quantityTableValue = "product-quantity";
        subTotalTableValue = "product-subtotal";
        shippingButtonID = "shipping-method-buttons-container";
        paymentMethodButtonID = "payment-method-buttons-container";
        paymentInfoButtonID = "payment-info-buttons-container";
        countryDropDownID = "shipping-address-select";

        currentDate = getCurrentDate();

        userHomePage = PageGeneratorManager.getUserHomePage(driver);
        userHomePage.clickToMenuLinkByName(ElementData.BasePage.LOGIN_MENU_LINK_ID);
        userLoginPage = PageGeneratorManager.getUserLoginPage(driver);
        userLoginPage.setCookies(CommonRegisterLogin.loggedCookies);
        userLoginPage.refreshCurrentPage();
    }

    @Test
    public void Payment_01_Checkout_Order_Payment_By_Cheque (){
        userLoginPage.openCategoriesPageByName(ElementData.BasePage.HEADER_CATEGORY,
                ElementData.BasePage.COMPUTER_CATEGORY, ElementData.BasePage.NOTEBOOKS_SUB_CATEGORY);
        userNotebooksPage = PageGeneratorManager.getUserNotebooksPage(driver);
        userDetailProductPage = userNotebooksPage.clickToDetaiProductByName(appleMacProduct);
        unitPrice = userDetailProductPage.getPriceProduct();
        totalQuantity = userDetailProductPage.getQuantityProductDetail();
        totalPrice = userDetailProductPage.getTotalPriceProductDetail(unitPrice, totalQuantity);
        userDetailProductPage.clickAddToCartButton();
        verifyEquals(userDetailProductPage.getSuccessfulMessageDisplayed(), successCartMess);
        userDetailProductPage.closeSuccessfulMessage();
        userDetailProductPage.hoverMouseToShoppingCardMenuLink();
        userShoppingCartPage = userDetailProductPage.clickGoToCartButton();
        userShoppingCartPage.clickToEstimateShippingButton();
        userShoppingCartPage.selectCountryDropDownByName(countryBill);
        userShoppingCartPage.inputToZipPostalCodeTextbox(zip550000);
        userShoppingCartPage.clickToRadioButtonByName(radio2ndDay);
        userShoppingCartPage.clickApplyButton();
        skuNumber = userShoppingCartPage.getSKUProduct();
        giftWrap = userShoppingCartPage.getGiftWrappingText();
        shippingMethod = userShoppingCartPage.getShippingMethodValue();
        shipPrice = userShoppingCartPage.getPriceByLabelName(shippingLabel);
        taxPrice = userShoppingCartPage.getPriceByLabelName(taxLabel);
        totalBillPrice = userShoppingCartPage.getTotalBillPrice();
        userShoppingCartPage.clickToLegalCheckbox();
        userCheckoutPage = userShoppingCartPage.clickToCheckoutButton();

        userCheckoutPage.unclickShipToSameAddressCheckbox();
        userCheckoutPage.inputToTextBoxByID(firstNameBillID, firstNameBill);
        userCheckoutPage.inputToTextBoxByID(lastNameBillID, lastNameBill);
        userCheckoutPage.inputToTextBoxByID(emailBillID, emailBill);
        userCheckoutPage.selectCountryDropdownByIDAndName(countryBillID, countryBill);
        userCheckoutPage.inputToTextBoxByID(cityBillID, cityBill);
        userCheckoutPage.inputToTextBoxByID(address1BillID, address1Bill);
        userCheckoutPage.inputToTextBoxByID(zipCodeBillID, zipCodeBill);
        userCheckoutPage.inputToTextBoxByID(phoneBillID, phoneBill);
        userCheckoutPage.clickButtonByID(buttonBillID);
        userCheckoutPage.selectCountryDropdownByIDAndName(countryDropDownID,newAddress);
        userCheckoutPage.inputToTextBoxByID(firstNameShipID, firstNameShip);
        userCheckoutPage.inputToTextBoxByID(lastNameShipID, lastNameShip);
        userCheckoutPage.inputToTextBoxByID(emailShipID, emailShip);
        userCheckoutPage.selectCountryDropdownByIDAndName(countryShipID, countryShip);
        userCheckoutPage.inputToTextBoxByID(cityShipID, cityShip);
        userCheckoutPage.inputToTextBoxByID(address1ShipID, address1Ship);
        userCheckoutPage.inputToTextBoxByID(zipCodeShipID, zipCodeShip);
        userCheckoutPage.inputToTextBoxByID(phoneShipID, phoneShip);
        userCheckoutPage.clickButtonByID(buttonShipID);
        userCheckoutPage.clickRadioButtonByLabel(radio2ndDayLabel);
        userCheckoutPage.clickButtonByID(shippingButtonID);
        verifyTrue(userCheckoutPage.isPaymentMethodRadioSelected(moneyMethod));
        userCheckoutPage.clickButtonByID(paymentMethodButtonID);
        userCheckoutPage.clickButtonByID(paymentInfoButtonID);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue(billingAddress, nameValue), firstNameBill + " " + lastNameBill);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue(billingAddress, emailValue), "Email: " + emailBill);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue(billingAddress, phoneValue), "Phone: " + phoneBill);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue(billingAddress, address1Value), address1Bill);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue(billingAddress, cityZipValue), cityBill + "," + zipCodeBill);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue(billingAddress, countryValue), countryBill);
        verifyEquals(userCheckoutPage.getPaymentMethodBilling(), moneyMethod);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue(shippingAddress, nameValue), firstNameShip + " " + lastNameShip);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue(shippingAddress, emailValue), "Email: " + emailShip);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue(shippingAddress, phoneValue), "Phone: " + phoneShip);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue(shippingAddress, address1Value), address1Ship);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue(shippingAddress, cityZipValue), cityShip + "," + zipCodeShip);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue(shippingAddress, countryValue), countryShip);
        verifyEquals(userCheckoutPage.getShippingMethodShipping(), radio2ndDay);
        verifyEquals(userCheckoutPage.getDataTableCheckout(skuTableValue), skuNumber);
        verifyEquals(userCheckoutPage.getProductNameCheckout(), appleMacProduct);
        verifyEquals(userCheckoutPage.getDataTableCheckout(unitTableValue), unitPrice);
        verifyEquals(userCheckoutPage.getDataTableCheckout(quantityTableValue), totalQuantity);
        verifyEquals(userCheckoutPage.getDataTableCheckout(subTotalTableValue), totalPrice);
        verifyEquals(userCheckoutPage.getGiftWrappingCheckout(), giftWrap);
        verifyEquals(userCheckoutPage.getPriceByLabelCheckout(subTotalPriceLabel), totalPrice);
        verifyEquals(userCheckoutPage.getShippingMethodCheckout(), shippingMethod);
        verifyEquals(userCheckoutPage.getPriceByLabelCheckout(shippingLabel), shipPrice);
        verifyEquals(userCheckoutPage.getPriceByLabelCheckout(taxLabel), taxPrice);
        verifyEquals(userCheckoutPage.getTotalBillPriceCheckout(), totalBillPrice);
        userCheckoutPage.clickToConfirmButton();
        verifyEquals(userCheckoutPage.getSuccessfulOrderMessage(),successOrder);
        String orderNumber = userCheckoutPage.getOrderNumber();
        userHomePage = userCheckoutPage.clickContinueButton();
        userHomePage.clickToMenuLinkByName(ElementData.BasePage.MY_ACCOUNT_MENU_LINK_ID);
        userCustomerPage = PageGeneratorManager.getUserCustomerPage(driver);
        userOrderPage = userCustomerPage.clickToOrderPage();
        verifyTrue(userOrderPage.isOrderTitleDisplayByNumber(orderNumber));
        userOrderPage.clickDetailsButtonByNumBer(orderNumber);

        verifyEquals(userOrderPage.getOrderNumberTitle(),orderNumber);
        verifyEquals(userOrderPage.getOrderDate(), "Order Date: " + currentDate);
        verifyEquals(userOrderPage.getOrderTotalPrice(),totalPrice);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue(billingAddress, nameValue), firstNameBill + " " + lastNameBill);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue(billingAddress, emailValue), "Email: " + emailBill);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue(billingAddress, phoneValue), "Phone: " + phoneBill);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue(billingAddress, address1Value), address1Bill);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue(billingAddress, cityZipValue), cityBill + "," + zipCodeBill);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue(billingAddress, countryValue), countryBill);
        verifyEquals(userOrderPage.getPaymentMethodOrder(), moneyMethod);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue(shippingAddress, nameValue), firstNameShip + " " + lastNameShip);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue(shippingAddress, emailValue), "Email: " + emailShip);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue(shippingAddress, phoneValue), "Phone: " + phoneShip);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue(shippingAddress, address1Value), address1Ship);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue(shippingAddress, cityZipValue), cityShip + "," + zipCodeShip);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue(shippingAddress, countryValue), countryShip);
        verifyEquals(userOrderPage.getShippingMethodOrder(), radio2ndDay);

        verifyEquals(userOrderPage.getDataTableByValue(skuTableValue), skuNumber);
        verifyEquals(userOrderPage.getProductNameOrder(), appleMacProduct);
        verifyEquals(userOrderPage.getDataTableByValue(unitTableValue), unitPrice);
        verifyEquals(userOrderPage.getDataTableByValue(quantityTableValue), totalQuantity);
        verifyEquals(userOrderPage.getDataTableByValue(subTotalTableValue), totalPrice);
        verifyEquals(userOrderPage.getGiftWrappingOrder(), giftWrap);
        verifyEquals(userOrderPage.getPriceBillByLabelName(subTotalPriceLabel), totalPrice);
        verifyEquals(userOrderPage.getPriceBillByLabelName(shippingLabel), shipPrice);
        verifyEquals(userOrderPage.getPriceBillByLabelName(taxLabel), taxPrice);
        verifyEquals(userOrderPage.getTotalBillPriceOrder(), totalBillPrice);
    }

    @Test
    public void Payment_02_Checkout_Order_Payment_By_Card (){

    }

    @Test
    public void Payment_03_Re_Order (){

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    private WebDriver driver;
    private String radio2ndDay, emailBill,  firstNameBill, lastNameBill, countryBill, cityBill, address1Bill, zipCodeBill, phoneBill,
            emailShip, firstNameShip, lastNameShip, countryShip, cityShip, address1Ship, zipCodeShip, phoneShip, moneyMethod, countryDropDownID,
            appleMacProduct, unitPrice, totalPrice, totalQuantity, successCartMess, currentDate, shippingLabel, taxLabel, subTotalPriceLabel,
            billingAddress, nameValue, emailValue, phoneValue, faxValue, address1Value, cityZipValue, countryValue, shippingAddress,
            firstNameBillID, lastNameBillID, emailBillID, cityBillID, address1BillID, zipCodeBillID, phoneBillID, buttonBillID, countryBillID,
            firstNameShipID, lastNameShipID, emailShipID, cityShipID, address1ShipID, zipCodeShipID, phoneShipID, buttonShipID, countryShipID,
            skuTableValue, unitTableValue, quantityTableValue, subTotalTableValue, shippingButtonID, paymentMethodButtonID, paymentInfoButtonID,
            skuNumber, giftWrap, shippingMethod, shipPrice, taxPrice, totalBillPrice, zip550000, newAddress, radio2ndDayLabel, successOrder;
    private DataHelper dataFaker;
    private UserHomePageObject userHomePage;
    private UserLoginPageObject userLoginPage;
    private UserNotebooksPageObject userNotebooksPage;
    private UserDetailProductPageObject userDetailProductPage;
    private UserShoppingCartPageObject userShoppingCartPage;
    private UserCheckoutPageObject userCheckoutPage;
    private UserCustomerPageObject userCustomerPage;
    private UserOrderPageObject userOrderPage;
}
