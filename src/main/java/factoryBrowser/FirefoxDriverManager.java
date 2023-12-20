package factoryBrowser;

import commons.GlobalConstant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager implements BrowserFactory{
    @Override
    public WebDriver getBrowserDriver() {
//        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
//        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,
//                GlobalConstant.getGlobalConstants().getProjectPath() + "\\browserLogs\\FirefoxLog.log");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-notifications");
        return new FirefoxDriver(options);
    }
}
