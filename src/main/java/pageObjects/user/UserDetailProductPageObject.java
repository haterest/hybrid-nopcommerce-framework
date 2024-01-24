package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.user.UserDetailProductPageUI;

public class UserDetailProductPageObject extends BasePage {
    public UserDetailProductPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public UserProductReviewPageObject clickToAddYourReviewLink() {
        waitForElementClickable(UserDetailProductPageUI.ADD_YOUR_REVIEW_LINK);
        clickToElement(UserDetailProductPageUI.ADD_YOUR_REVIEW_LINK);
        return PageGeneratorManager.getUserProductReviewPage(driver);
    }

    public void clickToAddToWishListButton() {
        waitForElementClickable(UserDetailProductPageUI.ADD_TO_WISHLIST_BUTTON);
        clickToElement(UserDetailProductPageUI.ADD_TO_WISHLIST_BUTTON);
    }

    public Object getSuccessfulMessageDisplayed() {
        waitForElementVisible(UserDetailProductPageUI.SUCCESSFULL_MESSAGE);
        return getElementText(UserDetailProductPageUI.SUCCESSFULL_MESSAGE);
    }

    public void closeSuccessfulMessage() {
        waitForElementClickable(UserDetailProductPageUI.CLOSE_SUCCESSFULL_MESSAGE_ICON);
        clickToElement(UserDetailProductPageUI.CLOSE_SUCCESSFULL_MESSAGE_ICON);
        waitForElementUndisplayed(UserDetailProductPageUI.CLOSE_SUCCESSFULL_MESSAGE_ICON);
    }

    public UserNotebooksPageObject backToNotebooksProductPage() {
        backToPage();
        return PageGeneratorManager.getUserNotebooksPage(driver);
    }

    public void selectItemInProcessorDropDown(String valueProcessor) {
        waitForElementVisible(UserDetailProductPageUI.PROCESSOR_DROP_DOWN);
        selectItemInDefaultDropDown(UserDetailProductPageUI.PROCESSOR_DROP_DOWN, valueProcessor);
        sleepInSecond(2);
    }

    public void selectItemInRamDropDown(String valueRam) {
        waitForElementVisible(UserDetailProductPageUI.RAM_DROP_DOWN);
        selectItemInDefaultDropDown(UserDetailProductPageUI.RAM_DROP_DOWN, valueRam);
        sleepInSecond(2);
    }

    public void clickToRadioOrCheckboxButtonByName(String nameLabel) {
        waitForElementClickable(UserDetailProductPageUI.RADIO_OR_CHECKBOX_BUTTON_BY_LABEL, nameLabel);
        clickToDefautCheckboxOrRadio(UserDetailProductPageUI.RADIO_OR_CHECKBOX_BUTTON_BY_LABEL, nameLabel);
    }

    public String getPriceProduct() {
        waitForElementVisible(UserDetailProductPageUI.PRODUCT_PRICE);
        return getElementText(UserDetailProductPageUI.PRODUCT_PRICE).trim();
    }

    public String getQuantityProductDetail() {
        waitForElementVisible(UserDetailProductPageUI.QUANTITY_PRODUCT_TEXTBOX);
        return getElementAttribute(UserDetailProductPageUI.QUANTITY_PRODUCT_TEXTBOX, "value");
    }

    public String getTotalPriceProductDetail(String unitPrice, String totalQuantity) {
        Double numberPrice = Double.parseDouble(unitPrice.replaceAll("[^0-9.]", ""));
        Double numberQuantity = Double.parseDouble(totalQuantity);
        String totalPriceNoCommas = "$" + numberPrice*numberQuantity + "0";
        String[] parts = totalPriceNoCommas.split("\\.");
        String totalPrice = parts[0].substring(1).replaceAll("(?<=\\d)(?=(\\d{3})+$)", ",");
        return "$" + totalPrice + "." + parts[1];
    }

    public void clickAddToCartButton() {
        waitForElementClickable(UserDetailProductPageUI.ADD_TO_CART_BUTTON);
        clickToElement(UserDetailProductPageUI.ADD_TO_CART_BUTTON);
    }

    public void hoverMouseToShoppingCardMenuLink() {
        waitForElementVisible(UserDetailProductPageUI.SHOPING_CART_MENU_LINK);
        hoverMouseToElement(UserDetailProductPageUI.SHOPING_CART_MENU_LINK);
        sleepInSecond(1);
    }

    public Object getCountNumberProductCart() {
        waitForElementVisible(UserDetailProductPageUI.COUNT_PRODUCT_MINI_SHOP_CART);
        return getElementText(UserDetailProductPageUI.COUNT_PRODUCT_MINI_SHOP_CART);
    }

    public Object getNameProductTitleMiniCart() {
        waitForElementVisible(UserDetailProductPageUI.NAME_PRODUCT_MINI_SHOP_CART);
        return getElementText(UserDetailProductPageUI.NAME_PRODUCT_MINI_SHOP_CART);
    }

    public Object getSpecificProductMiniCart() {
        waitForElementVisible(UserDetailProductPageUI.SPECIFIC_PRODUCT_MINI_SHOP_CART);
        return getElementText(UserDetailProductPageUI.SPECIFIC_PRODUCT_MINI_SHOP_CART).trim();
    }

    public Object getUnitPriceProductMiniCart() {
        waitForElementVisible(UserDetailProductPageUI.UNIT_PRICE_MINI_SHOP_CART);
        return getElementText(UserDetailProductPageUI.UNIT_PRICE_MINI_SHOP_CART);
    }

    public Object getQuantityProductMiniCart() {
        waitForElementVisible(UserDetailProductPageUI.QUANTITY_PRODUCT_MINI_SHOP_CART);
        return getElementText(UserDetailProductPageUI.QUANTITY_PRODUCT_MINI_SHOP_CART);
    }

    public Object getTotalPriceProductMiniCart() {
        waitForElementVisible(UserDetailProductPageUI.TOTAL_PRICE_MINI_SHOP_CART);
        return getElementText(UserDetailProductPageUI.TOTAL_PRICE_MINI_SHOP_CART);
    }

    public UserShoppingCartPageObject clickGoToCartButton() {
        waitForElementClickable(UserDetailProductPageUI.GO_TO_CART_BUTTON_MINI_SHOP_CART);
        clickToElement(UserDetailProductPageUI.GO_TO_CART_BUTTON_MINI_SHOP_CART);
        return PageGeneratorManager.getUserShoppingCartPage(driver);
    }

    public void unclickToCheckboxButtonByName(String nameValue) {
        waitForElementClickable(UserDetailProductPageUI.RADIO_OR_CHECKBOX_BUTTON_BY_LABEL, nameValue);
        unClickToDefaultCheckbox(UserDetailProductPageUI.RADIO_OR_CHECKBOX_BUTTON_BY_LABEL, nameValue);
    }

    public void inputQuantityProductDetail(String valueQuantity) {
        waitForElementVisible(UserDetailProductPageUI.QUANTITY_PRODUCT_TEXTBOX);
        sendKeyToElement(UserDetailProductPageUI.QUANTITY_PRODUCT_TEXTBOX, valueQuantity);
    }
}
