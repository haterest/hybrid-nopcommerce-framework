package com.nopcommerce.user;

import commons.BaseTest;
import commons.CommonRegisterLogin;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.user.*;
import utilities.DataHelper;

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
        zipCodeBill = dataFaker.getZipCode();
        phoneBill = dataFaker.getPhone();
        emailShip = dataFaker.getEmail();
        firstNameShip = dataFaker.getFirstName();
        lastNameShip = dataFaker.getLastName();
        countryShip = "Cape Verde";
        cityShip = dataFaker.getCity();
        address1Ship = dataFaker.getAddress();
        zipCodeShip = dataFaker.getZipCode();
        phoneShip = dataFaker.getPhone();
        moneyMethod = "Check / Money Order";
        radio2ndDay = "2nd Day Air";
        newAddress = "New Address";
        radio2ndDayLabel = "2nd Day Air ($0.00)";
        cardCode = String.valueOf(getRandomNumber());
        cardMethod = "Credit Card";
        quantity10 = "10";
        nextDayAirMethod = "Next Day Air";

        appleMacProduct = "Apple MacBook Pro 13-inch";
        successCartMess = "The product has been added to your shopping cart";
        successOrder = "Your order has been successfully processed!";

        userHomePage = PageGeneratorManager.getUserHomePage(driver);
        userHomePage.clickToMenuLinkByName("Log in");
        userLoginPage = PageGeneratorManager.getUserLoginPage(driver);
        userLoginPage.setCookies(CommonRegisterLogin.loggedCookies);
        userLoginPage.refreshCurrentPage();
    }

    @Test
    public void Payment_01_Checkout_Order_Payment_By_Cheque() {
        userLoginPage.openCategoriesPageByName("HeaderMenu", "Computers", "Notebooks");
        userNotebooksPage = PageGeneratorManager.getUserNotebooksPage(driver);
        userDetailProductPage = userNotebooksPage.clickToDetaiProductByName(appleMacProduct);
        userDetailProductPage.clickAddToCartButton();
        verifyEquals(userDetailProductPage.getSuccessfulMessageDisplayed(), successCartMess);
        unitPrice = userDetailProductPage.getPriceProduct();
        totalQuantity = userDetailProductPage.getQuantityProductDetail();
        totalPrice = userDetailProductPage.getTotalPriceProductDetail(unitPrice, totalQuantity);
        userDetailProductPage.closeSuccessfulMessage();
        userDetailProductPage.hoverMouseToShoppingCardMenuLink();
        userShoppingCartPage = userDetailProductPage.clickGoToCartButton();

        userShoppingCartPage.clickToEstimateShippingButton();
        userShoppingCartPage.selectCountryDropDownByName(countryBill);
        userShoppingCartPage.inputToZipPostalCodeTextbox("550000");
        userShoppingCartPage.clickToRadioButtonByName(radio2ndDay);
        userShoppingCartPage.clickApplyButton();
        skuNumber = userShoppingCartPage.getSKUProduct();
        giftWrap = userShoppingCartPage.getGiftWrappingText();
        shippingMethod = userShoppingCartPage.getShippingMethodValue();
        shipPrice = userShoppingCartPage.getPriceByLabelName("Shipping:");
        taxPrice = userShoppingCartPage.getPriceByLabelName("Tax:");
        totalBillPrice = userShoppingCartPage.getTotalBillPrice();
        userShoppingCartPage.clickToLegalCheckbox();
        userCheckoutPage = userShoppingCartPage.clickToCheckoutButton();

        userCheckoutPage.unclickShipToSameAddressCheckbox();
        userCheckoutPage.inputToTextBoxByID("BillingNewAddress_FirstName", firstNameBill);
        userCheckoutPage.inputToTextBoxByID("BillingNewAddress_LastName", lastNameBill);
        userCheckoutPage.inputToTextBoxByID("BillingNewAddress_Email", emailBill);
        userCheckoutPage.selectDropdownByIDAndName("BillingNewAddress_CountryId", countryBill);
        userCheckoutPage.inputToTextBoxByID("BillingNewAddress_City", cityBill);
        userCheckoutPage.inputToTextBoxByID("BillingNewAddress_Address1", address1Bill);
        userCheckoutPage.inputToTextBoxByID("BillingNewAddress_ZipPostalCode", zipCodeBill);
        userCheckoutPage.inputToTextBoxByID("BillingNewAddress_PhoneNumber", phoneBill);
        userCheckoutPage.clickButtonByID("billing-buttons-container");
        userCheckoutPage.selectDropdownByIDAndName("shipping-address-select", newAddress);
        userCheckoutPage.inputToTextBoxByID("ShippingNewAddress_FirstName", firstNameShip);
        userCheckoutPage.inputToTextBoxByID("ShippingNewAddress_LastName", lastNameShip);
        userCheckoutPage.inputToTextBoxByID("ShippingNewAddress_Email", emailShip);
        userCheckoutPage.selectDropdownByIDAndName("ShippingNewAddress_CountryId", countryShip);
        userCheckoutPage.inputToTextBoxByID("ShippingNewAddress_City", cityShip);
        userCheckoutPage.inputToTextBoxByID("ShippingNewAddress_Address1", address1Ship);
        userCheckoutPage.inputToTextBoxByID("ShippingNewAddress_ZipPostalCode", zipCodeShip);
        userCheckoutPage.inputToTextBoxByID("ShippingNewAddress_PhoneNumber", phoneShip);
        userCheckoutPage.clickButtonByID("shipping-buttons-container");
        userCheckoutPage.clickRadioButtonByLabel(radio2ndDayLabel);
        userCheckoutPage.clickButtonByID("shipping-method-buttons-container");
        verifyTrue(userCheckoutPage.isPaymentMethodRadioSelected(moneyMethod));
        userCheckoutPage.clickButtonByID("payment-method-buttons-container");
        userCheckoutPage.clickButtonByID("payment-info-buttons-container");

        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Billing Address", "name"), firstNameBill + " " + lastNameBill);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Billing Address", "email"), "Email: " + emailBill);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Billing Address", "phone"), "Phone: " + phoneBill);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Billing Address", "address1"), address1Bill);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Billing Address", "city-state-zip"), cityBill + "," + zipCodeBill);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Billing Address", "country"), countryBill);
        verifyEquals(userCheckoutPage.getPaymentMethodBilling(), moneyMethod);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Shipping Address", "name"), firstNameShip + " " + lastNameShip);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Shipping Address", "email"), "Email: " + emailShip);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Shipping Address", "phone"), "Phone: " + phoneShip);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Shipping Address", "address1"), address1Ship);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Shipping Address", "city-state-zip"), cityShip + "," + zipCodeShip);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Shipping Address", "country"), countryShip);
        verifyEquals(userCheckoutPage.getShippingMethodShipping(), radio2ndDay);
        verifyEquals(userCheckoutPage.getDataTableCheckout("sku-number"), skuNumber);
        verifyEquals(userCheckoutPage.getProductNameCheckout(), appleMacProduct);
        verifyEquals(userCheckoutPage.getDataTableCheckout("product-unit-price"), unitPrice);
        verifyEquals(userCheckoutPage.getDataTableCheckout("product-quantity"), totalQuantity);
        verifyEquals(userCheckoutPage.getDataTableCheckout("product-subtotal"), totalPrice);
        verifyEquals(userCheckoutPage.getGiftWrappingCheckout(), giftWrap);
        verifyEquals(userCheckoutPage.getPriceByLabelCheckout("Sub-Total:"), totalPrice);
        verifyEquals(userCheckoutPage.getShippingMethodCheckout(), shippingMethod);
        verifyEquals(userCheckoutPage.getPriceByLabelCheckout("Shipping:"), shipPrice);
        verifyEquals(userCheckoutPage.getPriceByLabelCheckout("Tax:"), taxPrice);
        verifyEquals(userCheckoutPage.getTotalBillPriceCheckout(), totalBillPrice);
        userCheckoutPage.clickToConfirmButton();

        verifyEquals(userCheckoutPage.getSuccessfulOrderMessage(), successOrder);
        orderNumber = userCheckoutPage.getOrderNumber();
        userHomePage = userCheckoutPage.clickContinueButton();
        userHomePage.clickToMenuLinkByName("My account");
        userCustomerPage = PageGeneratorManager.getUserCustomerPage(driver);
        userOrderPage = userCustomerPage.clickToOrderPage();
        verifyTrue(userOrderPage.isOrderTitleDisplayByNumber(orderNumber));
        userOrderPage.clickDetailsButtonByNumBer(orderNumber);

        verifyEquals(userOrderPage.getOrderNumberTitle(), orderNumber);
        verifyEquals(userOrderPage.getOrderTotalPrice(), totalPrice);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Billing Address", "name"), firstNameBill + " " + lastNameBill);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Billing Address", "email"), "Email: " + emailBill);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Billing Address", "phone"), "Phone: " + phoneBill);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Billing Address", "address1"), address1Bill);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Billing Address", "city-state-zip"), cityBill + "," + zipCodeBill);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Billing Address", "country"), countryBill);
        verifyEquals(userOrderPage.getPaymentMethodOrder(), moneyMethod);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Shipping Address", "name"), firstNameShip + " " + lastNameShip);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Shipping Address", "email"), "Email: " + emailShip);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Shipping Address", "phone"), "Phone: " + phoneShip);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Shipping Address", "address1"), address1Ship);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Shipping Address", "city-state-zip"), cityShip + "," + zipCodeShip);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Shipping Address", "country"), countryShip);
        verifyEquals(userOrderPage.getShippingMethodOrder(), radio2ndDay);

        verifyEquals(userOrderPage.getDataTableByValue("sku-number"), skuNumber);
        verifyEquals(userOrderPage.getProductNameOrder(), appleMacProduct);
        verifyEquals(userOrderPage.getDataTableByValue("product-unit-price"), unitPrice);
        verifyEquals(userOrderPage.getDataTableByValue("product-quantity"), totalQuantity);
        verifyEquals(userOrderPage.getDataTableByValue("product-subtotal"), totalPrice);
        verifyEquals(userOrderPage.getGiftWrappingOrder(), giftWrap);
        verifyEquals(userOrderPage.getPriceBillByLabelName("Sub-Total:"), totalPrice);
        verifyEquals(userOrderPage.getPriceBillByLabelName("Shipping:"), shipPrice);
        verifyEquals(userOrderPage.getPriceBillByLabelName("Tax:"), taxPrice);
        verifyEquals(userOrderPage.getTotalBillPriceOrder(), totalBillPrice);
    }

    @Test
    public void Payment_02_Checkout_Order_Payment_By_Card() {
        userOrderPage.openCategoriesPageByName("HeaderMenu", "Computers", "Notebooks");
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
        skuNumber = userShoppingCartPage.getSKUProduct();
        giftWrap = userShoppingCartPage.getGiftWrappingText();
        shipPrice = userShoppingCartPage.getPriceByLabelName("Shipping:");
        taxPrice = userShoppingCartPage.getPriceByLabelName("Tax:");
        totalBillPrice = userShoppingCartPage.getTotalBillPrice();
        userShoppingCartPage.clickToLegalCheckbox();
        userCheckoutPage = userShoppingCartPage.clickToCheckoutButton();

        userCheckoutPage.unclickShipToSameAddressCheckbox();
        userCheckoutPage.selectDropdownByIDAndName("billing-address-select", newAddress);
        userCheckoutPage.inputToTextBoxByID("BillingNewAddress_FirstName", firstNameBill);
        userCheckoutPage.inputToTextBoxByID("BillingNewAddress_LastName", lastNameBill);
        userCheckoutPage.inputToTextBoxByID("BillingNewAddress_Email", emailBill);
        userCheckoutPage.selectDropdownByIDAndName("BillingNewAddress_CountryId", countryBill);
        userCheckoutPage.inputToTextBoxByID("BillingNewAddress_City", cityBill);
        userCheckoutPage.inputToTextBoxByID("BillingNewAddress_Address1", address1Bill);
        userCheckoutPage.inputToTextBoxByID("BillingNewAddress_ZipPostalCode", zipCodeBill);
        userCheckoutPage.inputToTextBoxByID("BillingNewAddress_PhoneNumber", phoneBill);
        userCheckoutPage.clickButtonByID("billing-buttons-container");
        userCheckoutPage.selectDropdownByIDAndName("shipping-address-select", newAddress);
        userCheckoutPage.inputToTextBoxByID("ShippingNewAddress_FirstName", firstNameShip);
        userCheckoutPage.inputToTextBoxByID("ShippingNewAddress_LastName", lastNameShip);
        userCheckoutPage.inputToTextBoxByID("ShippingNewAddress_Email", emailShip);
        userCheckoutPage.selectDropdownByIDAndName("ShippingNewAddress_CountryId", countryShip);
        userCheckoutPage.inputToTextBoxByID("ShippingNewAddress_City", cityShip);
        userCheckoutPage.inputToTextBoxByID("ShippingNewAddress_Address1", address1Ship);
        userCheckoutPage.inputToTextBoxByID("ShippingNewAddress_ZipPostalCode", zipCodeShip);
        userCheckoutPage.inputToTextBoxByID("ShippingNewAddress_PhoneNumber", phoneShip);
        userCheckoutPage.clickButtonByID("shipping-buttons-container");
        userCheckoutPage.clickRadioButtonByLabel(radio2ndDayLabel);
        userCheckoutPage.clickButtonByID("shipping-method-buttons-container");
        userCheckoutPage.clickRadioButtonByLabel(cardMethod);
        userCheckoutPage.clickButtonByID("payment-method-buttons-container");
        userCheckoutPage.selectDropdownByIDAndName("CreditCardType", "Visa");
        userCheckoutPage.inputToTextBoxByID("CardholderName", dataFaker.getFullName());
        userCheckoutPage.inputToTextBoxByID("CardNumber", dataFaker.getVisaCard());
        userCheckoutPage.selectDropdownByIDAndName("ExpireMonth", "12");
        userCheckoutPage.selectDropdownByIDAndName("ExpireYear", "2035");
        userCheckoutPage.inputToTextBoxByID("CardCode", cardCode);
        userCheckoutPage.clickButtonByID("payment-info-buttons-container");

        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Billing Address", "name"), firstNameBill + " " + lastNameBill);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Billing Address", "email"), "Email: " + emailBill);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Billing Address", "phone"), "Phone: " + phoneBill);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Billing Address", "address1"), address1Bill);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Billing Address", "city-state-zip"), cityBill + "," + zipCodeBill);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Billing Address", "country"), countryBill);
        verifyEquals(userCheckoutPage.getPaymentMethodBilling(), cardMethod);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Shipping Address", "name"), firstNameShip + " " + lastNameShip);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Shipping Address", "email"), "Email: " + emailShip);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Shipping Address", "phone"), "Phone: " + phoneShip);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Shipping Address", "address1"), address1Ship);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Shipping Address", "city-state-zip"), cityShip + "," + zipCodeShip);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Shipping Address", "country"), countryShip);
        verifyEquals(userCheckoutPage.getShippingMethodShipping(), radio2ndDay);
        verifyEquals(userCheckoutPage.getDataTableCheckout("sku-number"), skuNumber);
        verifyEquals(userCheckoutPage.getProductNameCheckout(), appleMacProduct);
        verifyEquals(userCheckoutPage.getDataTableCheckout("product-unit-price"), unitPrice);
        verifyEquals(userCheckoutPage.getDataTableCheckout("product-quantity"), totalQuantity);
        verifyEquals(userCheckoutPage.getDataTableCheckout("product-subtotal"), totalPrice);
        verifyEquals(userCheckoutPage.getGiftWrappingCheckout(), giftWrap);
        verifyEquals(userCheckoutPage.getPriceByLabelCheckout("Sub-Total:"), totalPrice);
        verifyEquals(userCheckoutPage.getShippingMethodCheckout(), shippingMethod);
        verifyEquals(userCheckoutPage.getPriceByLabelCheckout("Shipping:"), shipPrice);
        verifyEquals(userCheckoutPage.getPriceByLabelCheckout("Tax:"), taxPrice);
        verifyEquals(userCheckoutPage.getTotalBillPriceCheckout(), totalBillPrice);
        userCheckoutPage.waitForOrderComplete();
        userCheckoutPage.clickToConfirmButton();

        verifyEquals(userCheckoutPage.getSuccessfulOrderMessage(), successOrder);
        orderNumber = userCheckoutPage.getOrderNumber();
        userHomePage = userCheckoutPage.clickContinueButton();
        userHomePage.clickToMenuLinkByName("My account");
        userCustomerPage = PageGeneratorManager.getUserCustomerPage(driver);
        userOrderPage = userCustomerPage.clickToOrderPage();
        verifyTrue(userOrderPage.isOrderTitleDisplayByNumber(orderNumber));
        userOrderPage.clickDetailsButtonByNumBer(orderNumber);

        verifyEquals(userOrderPage.getOrderNumberTitle(), orderNumber);
        verifyEquals(userOrderPage.getOrderTotalPrice(), totalPrice);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Billing Address", "name"), firstNameBill + " " + lastNameBill);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Billing Address", "email"), "Email: " + emailBill);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Billing Address", "phone"), "Phone: " + phoneBill);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Billing Address", "address1"), address1Bill);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Billing Address", "city-state-zip"), cityBill + "," + zipCodeBill);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Billing Address", "country"), countryBill);
        verifyEquals(userOrderPage.getPaymentMethodOrder(), cardMethod);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Shipping Address", "name"), firstNameShip + " " + lastNameShip);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Shipping Address", "email"), "Email: " + emailShip);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Shipping Address", "phone"), "Phone: " + phoneShip);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Shipping Address", "address1"), address1Ship);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Shipping Address", "city-state-zip"), cityShip + "," + zipCodeShip);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Shipping Address", "country"), countryShip);
        verifyEquals(userOrderPage.getShippingMethodOrder(), radio2ndDay);

        verifyEquals(userOrderPage.getDataTableByValue("sku-number"), skuNumber);
        verifyEquals(userOrderPage.getProductNameOrder(), appleMacProduct);
        verifyEquals(userOrderPage.getDataTableByValue("product-unit-price"), unitPrice);
        verifyEquals(userOrderPage.getDataTableByValue("product-quantity"), totalQuantity);
        verifyEquals(userOrderPage.getDataTableByValue("product-subtotal"), totalPrice);
        verifyEquals(userOrderPage.getGiftWrappingOrder(), giftWrap);
        verifyEquals(userOrderPage.getPriceBillByLabelName("Sub-Total:"), totalPrice);
        verifyEquals(userOrderPage.getPriceBillByLabelName("Shipping:"), shipPrice);
        verifyEquals(userOrderPage.getPriceBillByLabelName("Tax:"), taxPrice);
        verifyEquals(userOrderPage.getTotalBillPriceOrder(), totalBillPrice);
    }

    @Test
    public void Payment_03_Re_Order() {
        userOrderPage.clickToMenuLinkByName("My account");
        userCustomerPage = PageGeneratorManager.getUserCustomerPage(driver);
        userOrderPage = userCustomerPage.clickToOrderPage();
        userOrderPage.clickDetailsButtonByNumBer(orderNumber);
        userShoppingCartPage = userOrderPage.clickReOrderButton();
        userShoppingCartPage.inputToQuantityTextbox(quantity10);
        userShoppingCartPage.clickUpdateShoppingCartButton();
        shipPrice = userShoppingCartPage.getPriceByLabelName("Shipping:");
        taxPrice = userShoppingCartPage.getPriceByLabelName("Tax:");
        totalBillPrice = userShoppingCartPage.getTotalBillPrice();
        userShoppingCartPage.clickToLegalCheckbox();
        userCheckoutPage = userShoppingCartPage.clickToCheckoutButton();

        userCheckoutPage.unclickShipToSameAddressCheckbox();
        userCheckoutPage.selectDropdownByIDAndName("billing-address-select", newAddress);
        userCheckoutPage.inputToTextBoxByID("BillingNewAddress_FirstName", firstNameBill);
        userCheckoutPage.inputToTextBoxByID("BillingNewAddress_LastName", lastNameBill);
        userCheckoutPage.inputToTextBoxByID("BillingNewAddress_Email", emailBill);
        userCheckoutPage.selectDropdownByIDAndName("BillingNewAddress_CountryId", countryBill);
        userCheckoutPage.inputToTextBoxByID("BillingNewAddress_City", cityBill);
        userCheckoutPage.inputToTextBoxByID("BillingNewAddress_Address1", address1Bill);
        userCheckoutPage.inputToTextBoxByID("BillingNewAddress_ZipPostalCode", zipCodeBill);
        userCheckoutPage.inputToTextBoxByID("BillingNewAddress_PhoneNumber", phoneBill);
        userCheckoutPage.clickButtonByID("billing-buttons-container");
        userCheckoutPage.selectDropdownByIDAndName("shipping-address-select", newAddress);
        userCheckoutPage.inputToTextBoxByID("ShippingNewAddress_FirstName", firstNameShip);
        userCheckoutPage.inputToTextBoxByID("ShippingNewAddress_LastName", lastNameShip);
        userCheckoutPage.inputToTextBoxByID("ShippingNewAddress_Email", emailShip);
        userCheckoutPage.selectDropdownByIDAndName("ShippingNewAddress_CountryId", countryShip);
        userCheckoutPage.inputToTextBoxByID("ShippingNewAddress_City", cityShip);
        userCheckoutPage.inputToTextBoxByID("ShippingNewAddress_Address1", address1Ship);
        userCheckoutPage.inputToTextBoxByID("ShippingNewAddress_ZipPostalCode", zipCodeShip);
        userCheckoutPage.inputToTextBoxByID("ShippingNewAddress_PhoneNumber", phoneShip);
        userCheckoutPage.clickButtonByID("shipping-buttons-container");
        userCheckoutPage.clickRadioButtonByLabel("Next Day Air ($0.00)");
        userCheckoutPage.clickButtonByID("shipping-method-buttons-container");
        verifyTrue(userCheckoutPage.isPaymentMethodRadioSelected(moneyMethod));
        userCheckoutPage.clickButtonByID("payment-method-buttons-container");
        userCheckoutPage.clickButtonByID("payment-info-buttons-container");

        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Billing Address", "name"), firstNameBill + " " + lastNameBill);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Billing Address", "email"), "Email: " + emailBill);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Billing Address", "phone"), "Phone: " + phoneBill);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Billing Address", "address1"), address1Bill);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Billing Address", "city-state-zip"), cityBill + "," + zipCodeBill);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Billing Address", "country"), countryBill);
        verifyEquals(userCheckoutPage.getPaymentMethodBilling(), moneyMethod);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Shipping Address", "name"), firstNameShip + " " + lastNameShip);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Shipping Address", "email"), "Email: " + emailShip);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Shipping Address", "phone"), "Phone: " + phoneShip);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Shipping Address", "address1"), address1Ship);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Shipping Address", "city-state-zip"), cityShip + "," + zipCodeShip);
        verifyEquals(userCheckoutPage.getInforCheckoutByNameAndValue("Shipping Address", "country"), countryShip);
        verifyEquals(userCheckoutPage.getShippingMethodShipping(), nextDayAirMethod);
        verifyEquals(userCheckoutPage.getDataTableCheckout("sku-number"), skuNumber);
        verifyEquals(userCheckoutPage.getProductNameCheckout(), appleMacProduct);
        verifyEquals(userCheckoutPage.getDataTableCheckout("product-unit-price"), unitPrice);
        verifyEquals(userCheckoutPage.getDataTableCheckout("product-quantity"), quantity10);
        verifyEquals(userCheckoutPage.getDataTableCheckout("product-subtotal"), totalBillPrice);
        verifyEquals(userCheckoutPage.getGiftWrappingCheckout(), giftWrap);
        verifyEquals(userCheckoutPage.getPriceByLabelCheckout("Sub-Total:"), totalBillPrice);
        verifyEquals(userCheckoutPage.getShippingMethodCheckout(), nextDayAirMethod);
        verifyEquals(userCheckoutPage.getPriceByLabelCheckout("Shipping:"), shipPrice);
        verifyEquals(userCheckoutPage.getPriceByLabelCheckout("Tax:"), taxPrice);
        verifyEquals(userCheckoutPage.getTotalBillPriceCheckout(), totalBillPrice);
        userCheckoutPage.waitForOrderComplete();
        userCheckoutPage.waitForOrderComplete();
        userCheckoutPage.clickToConfirmButton();

        verifyEquals(userCheckoutPage.getSuccessfulOrderMessage(), successOrder);
        orderNumber = userCheckoutPage.getOrderNumber();
        userHomePage = userCheckoutPage.clickContinueButton();
        userHomePage.clickToMenuLinkByName("My account");
        userCustomerPage = PageGeneratorManager.getUserCustomerPage(driver);
        userOrderPage = userCustomerPage.clickToOrderPage();
        verifyTrue(userOrderPage.isOrderTitleDisplayByNumber(orderNumber));
        userOrderPage.clickDetailsButtonByNumBer(orderNumber);

        verifyEquals(userOrderPage.getOrderNumberTitle(), orderNumber);
        verifyEquals(userOrderPage.getOrderTotalPrice(), totalBillPrice);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Billing Address", "name"), firstNameBill + " " + lastNameBill);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Billing Address", "email"), "Email: " + emailBill);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Billing Address", "phone"), "Phone: " + phoneBill);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Billing Address", "address1"), address1Bill);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Billing Address", "city-state-zip"), cityBill + "," + zipCodeBill);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Billing Address", "country"), countryBill);
        verifyEquals(userOrderPage.getPaymentMethodOrder(), moneyMethod);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Shipping Address", "name"), firstNameShip + " " + lastNameShip);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Shipping Address", "email"), "Email: " + emailShip);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Shipping Address", "phone"), "Phone: " + phoneShip);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Shipping Address", "address1"), address1Ship);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Shipping Address", "city-state-zip"), cityShip + "," + zipCodeShip);
        verifyEquals(userOrderPage.getInforOrderByNameAndValue("Shipping Address", "country"), countryShip);
        verifyEquals(userOrderPage.getShippingMethodOrder(), nextDayAirMethod);

        verifyEquals(userOrderPage.getDataTableByValue("sku-number"), skuNumber);
        verifyEquals(userOrderPage.getProductNameOrder(), appleMacProduct);
        verifyEquals(userOrderPage.getDataTableByValue("product-unit-price"), unitPrice);
        verifyEquals(userOrderPage.getDataTableByValue("product-quantity"), quantity10);
        verifyEquals(userOrderPage.getDataTableByValue("product-subtotal"), totalBillPrice);
        verifyEquals(userOrderPage.getGiftWrappingOrder(), giftWrap);
        verifyEquals(userOrderPage.getPriceBillByLabelName("Sub-Total:"), totalBillPrice);
        verifyEquals(userOrderPage.getPriceBillByLabelName("Shipping:"), shipPrice);
        verifyEquals(userOrderPage.getPriceBillByLabelName("Tax:"), taxPrice);
        verifyEquals(userOrderPage.getTotalBillPriceOrder(), totalBillPrice);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    private WebDriver driver;
    private String radio2ndDay, emailBill, firstNameBill, lastNameBill, countryBill, cityBill, address1Bill, zipCodeBill, phoneBill, emailShip, firstNameShip, lastNameShip, countryShip, cityShip, address1Ship, zipCodeShip, phoneShip, moneyMethod,
            appleMacProduct, unitPrice, totalPrice, totalQuantity, successCartMess, skuNumber, giftWrap, shippingMethod, shipPrice, taxPrice, totalBillPrice, newAddress, radio2ndDayLabel, successOrder, cardCode, orderNumber, cardMethod,  quantity10, nextDayAirMethod;
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
