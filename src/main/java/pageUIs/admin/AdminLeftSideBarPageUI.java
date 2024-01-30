package pageUIs.admin;

public class AdminLeftSideBarPageUI {
    public static final String MENU_SIDE_BAR_BY_NAME = "xpath=//ul[@data-widget='treeview' and " +
            "@role='menu']/li/a/p[contains(text(),'%s')]/parent::a";
    public static final String MENU_SIDE_BAR_BY_NAME_AND_LINK = "xpath=//ul[@data-widget='treeview' and  " +
            "@role='menu']/li/a/p[contains(text(),'%s')]/parent::a/following-sibling::ul//p[contains(text(),'%s')]";
    public static final String LOADING_ICON = "css=div#ajaxBusy";
}
