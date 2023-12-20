package commons;

import factoryBrowser.*;
import org.openqa.selenium.WebDriver;

public class LocalFactory {
    private WebDriver driver;
    private String browserName;
    public LocalFactory(String browserName) {
        this.browserName = browserName;
    }
    public WebDriver createDriver() {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case CHROME:
                driver = new ChromeDriverManager().getBrowserDriver();
                break;
            case H_CHROME:
                driver = new HeadlessChromeDriverManager().getBrowserDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriverManager().getBrowserDriver();
                break;
            case H_FIREFOX:
                driver = new HeadlessFirefoxDriverManager().getBrowserDriver();
                break;
            case EDGE:
                driver = new EdgeDriverManager().getBrowserDriver();
                break;
            case SAFARI:
                driver = new SafariDriverManager().getBrowserDriver();
                break;
            default:
                throw new BrowserNotSupport(browserName);
        }
        return driver;
    }
}
