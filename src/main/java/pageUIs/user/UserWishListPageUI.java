package pageUIs.user;

public class UserWishListPageUI {
    public static final String PRODUCT_NAME_LINK = "xpath=//a[text()='%s']";
    public static final String WISHLIST_SHARE_LINK = "xpath=//span[text()='Your wishlist URL for sharing:']/following-sibling::a";
    public static final String USER_WISHLIST_PAGE_TITLE = "css=.page-title>h1";
    public static final String ADD_TO_CART_CHECKBOX = "css=.add-to-cart>input";
    public static final String ADD_TO_CART_BUTTON = "xpath=//button[text()='Add to cart']";
    public static final String WISHLIST_PAGE_MESSAGE = "css=.no-data";
    public static final String REMOVE_BUTTON_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/parent::td/following-sibling::td/button[@class='remove-btn']";

}
