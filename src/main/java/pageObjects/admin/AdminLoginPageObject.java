package pageObjects.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.user.PageGeneratorManager;
import pageUIs.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
    public AdminLoginPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public AdminDashboardPageObject loginAsAdmin(String adminEmail, String adminPassword) {
        waitForElementVisible(AdminLoginPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(AdminLoginPageUI.EMAIL_TEXTBOX, adminEmail);
        waitForElementVisible(AdminLoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(AdminLoginPageUI.PASSWORD_TEXTBOX, adminPassword);
        waitForElementClickable(AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(AdminLoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getAdminDashboardPage(driver);
    }
}
