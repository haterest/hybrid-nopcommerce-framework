package pageObjects.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.user.PageGeneratorManager;
import pageUIs.admin.AdminLeftSideBarPageUI;

public class AdminLeftSideBarPageObject extends BasePage {
    public AdminLeftSideBarPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public AdminLeftSideBarPageObject clickToMenuSideBarByLink(String nameMenu, String nameLink) {
        waitForElementClickable(AdminLeftSideBarPageUI.MENU_SIDE_BAR_BY_NAME_AND_LINK, nameMenu, nameLink);
        clickToElement(AdminLeftSideBarPageUI.MENU_SIDE_BAR_BY_NAME_AND_LINK, nameMenu, nameLink);
        waitForElementInvisible(AdminLeftSideBarPageUI.LOADING_ICON);
        switch (nameLink){
            case "Products":
                return PageGeneratorManager.getAdminProductsPage(driver);
            case "Customers":
                return PageGeneratorManager.getAdminCustomersPage(driver);
            default:
                throw new RuntimeException("Invalid Page Name at My Account area");
        }
    }

    public void clickToMenuSideBarByName(String menuName) {
        waitForElementClickable(AdminLeftSideBarPageUI.MENU_SIDE_BAR_BY_NAME, menuName);
        clickToElement(AdminLeftSideBarPageUI.MENU_SIDE_BAR_BY_NAME, menuName);
        sleepInSecond(1);
    }
}
