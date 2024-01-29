package pageObjects.admin;

import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends AdminLeftSideBarPageObject {
    public AdminDashboardPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isAdminDashboardHeaderDisplayed() {
        waitForElementInvisible(AdminDashboardPageUI.BUSY_LOADING_ICON);
        waitForElementVisible(AdminDashboardPageUI.DASHBOARD_HEADER);
        return isElementDisplayed(AdminDashboardPageUI.DASHBOARD_HEADER);
    }
}
