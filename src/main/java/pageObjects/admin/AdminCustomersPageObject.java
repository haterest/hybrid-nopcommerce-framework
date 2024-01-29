package pageObjects.admin;

import org.openqa.selenium.WebDriver;

public class AdminCustomersPageObject extends AdminLeftSideBarPageObject{
    public AdminCustomersPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
