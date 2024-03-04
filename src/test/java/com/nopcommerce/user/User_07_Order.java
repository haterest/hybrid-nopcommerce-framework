package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.user.*;

public class User_07_Order extends BaseTest {
    @Parameters({"envName", "severName", "browserName", "osName", "ipAddress", "portNumber"})
    @BeforeClass
    public void beforeClass(@Optional("local") String envName, @Optional("dev") String severName, @Optional("chrome")
    String browserName, @Optional("10") String osName, @Optional("142") String ipAddress, @Optional("9999") String portNumber) {
        driver = getBrowserDriver(envName, severName, browserName, osName, ipAddress, portNumber);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        buildComputerProduct = "Build your own computer";
        value1Processor = "2.2 GHz Intel Pentium Dual-Core E2200";
        value2Processor = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
        value4GBRam = "4GB [+$20.00]";
        value8GBRam = "8GB [+$60.00]";
        value400GB = "400 GB [+$100.00]";
        value320GB = "320 GB";
        valueVistaHome = "Vista Home [+$50.00]";
        valueVistaPremium = "Vista Premium [+$60.00]";
        valueMicrosoft = "Microsoft Office [+$50.00]";
        valueAcrobat = "Acrobat Reader [+$10.00]";
        valueCommander = "Total Commander [+$5.00]";
        value2Quantity = "2";
        value5Quantity = "5";
        lenovo600Product = "Lenovo IdeaCentre 600 All-in-One PC";
        successCartMess = "The product has been added to your shopping cart";

    }

    @Test
    public void Order_01_Add_product_to_Cart (){
        userHomePage.openCategoriesPageByName("HeaderMenu",
                "Computers", "Desktops");
        userDesktopPage = PageGeneratorManager.getUserDesktopPage(driver);
        userDetailProductPage = userDesktopPage.openDetailProductPageByName(buildComputerProduct);
        userDetailProductPage.clickToRadioOrCheckboxButtonByName(value400GB);
        userDetailProductPage.clickToRadioOrCheckboxButtonByName(valueVistaPremium);
        userDetailProductPage.clickToRadioOrCheckboxButtonByName(valueMicrosoft);
        userDetailProductPage.clickToRadioOrCheckboxButtonByName(valueAcrobat);
        userDetailProductPage.clickToRadioOrCheckboxButtonByName(valueCommander);
        userDetailProductPage.selectItemInProcessorDropDown(value2Processor);
        userDetailProductPage.selectItemInRamDropDown(value8GBRam);
        unitPrice = userDetailProductPage.getPriceProduct();
        String totalQuantity = userDetailProductPage.getQuantityProductDetail();
        totalPrice = userDetailProductPage.getTotalPriceProductDetail(unitPrice, totalQuantity);
        userDetailProductPage.clickAddToCartButton();
        verifyEquals(userDetailProductPage.getSuccessfulMessageDisplayed(),successCartMess);
        userDetailProductPage.closeSuccessfulMessage();
        userDetailProductPage.hoverMouseToShoppingCardMenuLink();
        verifyEquals(userDetailProductPage.getCountNumberProductCart(),"There are "+ totalQuantity +" item(s) in your cart.");
        verifyEquals(userDetailProductPage.getNameProductTitleMiniCart(),buildComputerProduct);
        verifyEquals(userDetailProductPage.getSpecificProductMiniCart(), "Processor: " + value2Processor + "\nRAM: " + value8GBRam
                + "\nHDD: " + value400GB + "\nOS: " + valueVistaPremium + "\nSoftware: " + valueMicrosoft + "\nSoftware: " + valueAcrobat + "\nSoftware: " + valueCommander);
        verifyEquals(userDetailProductPage.getUnitPriceProductMiniCart(),"Unit price: " + unitPrice);
        verifyEquals(userDetailProductPage.getQuantityProductMiniCart(),"Quantity: " + totalQuantity);
        verifyEquals(userDetailProductPage.getTotalPriceProductMiniCart(), "Sub-Total: " + totalPrice);
    }

    @Test
    public void Order_02_Edit_Product_in_Shopping_Cart (){
        userShoppingCartPage = userDetailProductPage.clickGoToCartButton();
        userDetailProductPage = userShoppingCartPage.clickEditProductLink();
        userDetailProductPage.clickToRadioOrCheckboxButtonByName(value320GB);
        userDetailProductPage.clickToRadioOrCheckboxButtonByName(valueVistaHome);
        userDetailProductPage.unclickToCheckboxButtonByName(valueAcrobat);
        userDetailProductPage.unclickToCheckboxButtonByName(valueCommander);
        userDetailProductPage.selectItemInProcessorDropDown(value1Processor);
        userDetailProductPage.selectItemInRamDropDown(value4GBRam);
        userDetailProductPage.inputQuantityProductDetail(value2Quantity);
        unitPrice = userDetailProductPage.getPriceProduct();
        totalPrice = userDetailProductPage.getTotalPriceProductDetail(unitPrice, value2Quantity);
        userDetailProductPage.clickAddToCartButton();
        verifyEquals(userDetailProductPage.getSuccessfulMessageDisplayed(),successCartMess);
        userDetailProductPage.closeSuccessfulMessage();
        userDetailProductPage.hoverMouseToShoppingCardMenuLink();
        verifyEquals(userDetailProductPage.getCountNumberProductCart(),"There are "+ value2Quantity +" item(s) in your cart.");
        verifyEquals(userDetailProductPage.getNameProductTitleMiniCart(),buildComputerProduct);
        verifyEquals(userDetailProductPage.getSpecificProductMiniCart(), "Processor: " + value1Processor + "\nRAM: " + value4GBRam
                + "\nHDD: " + value320GB + "\nOS: " + valueVistaHome + "\nSoftware: " + valueMicrosoft);
        verifyEquals(userDetailProductPage.getUnitPriceProductMiniCart(),"Unit price: " + unitPrice);
        verifyEquals(userDetailProductPage.getQuantityProductMiniCart(),"Quantity: " + value2Quantity);
        verifyEquals(userDetailProductPage.getTotalPriceProductMiniCart(), "Sub-Total: " + totalPrice);
    }

    @Test
    public void Order_03_Remove_product_from_Cart (){
        userShoppingCartPage = userDetailProductPage.clickGoToCartButton();
        userShoppingCartPage.clickRemoveProductButton();
        verifyEquals(userShoppingCartPage.getNoProductMessage(),"Your Shopping Cart is empty!");
        verifyTrue(userShoppingCartPage.isUndisplayedProductNameLink(buildComputerProduct));
    }

    @Test
    public void Order_04_Update_Shopping_Cart (){
        userShoppingCartPage.openCategoriesPageByName("HeaderMenu", "Computers", "Desktops");
        userDesktopPage = PageGeneratorManager.getUserDesktopPage(driver);
        userDetailProductPage = userDesktopPage.openDetailProductPageByName(lenovo600Product);
        userDetailProductPage.inputQuantityProductDetail(value5Quantity);
        unitPrice = userDetailProductPage.getPriceProduct();
        totalPrice = userDetailProductPage.getTotalPriceProductDetail(unitPrice, value5Quantity);
        userDetailProductPage.clickAddToCartButton();
        verifyEquals(userDetailProductPage.getSuccessfulMessageDisplayed(),successCartMess);
        userDetailProductPage.closeSuccessfulMessage();
        userDetailProductPage.hoverMouseToShoppingCardMenuLink();
        verifyEquals(userDetailProductPage.getCountNumberProductCart(),"There are "+ value5Quantity +" item(s) in your cart.");
        verifyEquals(userDetailProductPage.getNameProductTitleMiniCart(),lenovo600Product);
        verifyEquals(userDetailProductPage.getUnitPriceProductMiniCart(),"Unit price: " + unitPrice);
        verifyEquals(userDetailProductPage.getQuantityProductMiniCart(),"Quantity: " + value5Quantity);
        verifyEquals(userDetailProductPage.getTotalPriceProductMiniCart(), "Sub-Total: " + totalPrice);
        userShoppingCartPage = userDetailProductPage.clickGoToCartButton();
        userShoppingCartPage.clickRemoveProductButton();
        verifyEquals(userShoppingCartPage.getNoProductMessage(),"Your Shopping Cart is empty!");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }
    private WebDriver driver;
    private String buildComputerProduct, value1Processor, value2Processor, value8GBRam, value4GBRam, value400GB, value320GB,
            valueVistaHome, valueVistaPremium, valueMicrosoft, valueAcrobat, valueCommander, value2Quantity, value5Quantity,
            unitPrice, totalPrice, lenovo600Product, successCartMess;
    private UserHomePageObject userHomePage;
    private UserDesktopPageObject userDesktopPage;
    private UserDetailProductPageObject userDetailProductPage;
    private UserShoppingCartPageObject userShoppingCartPage;

}
