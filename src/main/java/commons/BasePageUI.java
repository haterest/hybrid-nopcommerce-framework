package commons;

public class BasePageUI {
    public static final String MENU_LINK = "xpath=//a[text()='%s']";
    public static final String WISHLIST_MENU_LINK = "css=a.ico-wishlist";
    public static final String HEADER_MENU_LINK = "xpath=//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]";
    public static final String SIDE_BAR_MENU_LINK = "xpath=//div[@class='listbox']//a[text()='%s']";
    public static final String FOOTER_LINK_BY_NAME = "xpath=//div[@class='footer-upper']//a[text()='%s']";
}
