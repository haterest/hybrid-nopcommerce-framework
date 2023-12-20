package commons;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GridFactory {
    private WebDriver driver;
    private String browserName;
    private String osName;
    private String ipAddress;
    private String portNumber;
    public GridFactory(String browserName, String osName, String ipAddress, String portNumber) {
        this.browserName = browserName;
        this.osName = osName;
        this.ipAddress = ipAddress;
        this.portNumber = portNumber;
    }

    public WebDriver createDriver() {
        DesiredCapabilities capability = null;
        Platform platform;

        if (osName.contains("windows")) {
            platform = Platform.WINDOWS;
        } else {
            platform = Platform.MAC;
        }
        switch (browserName) {
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability("browserName", "Firefox");
                firefoxOptions.setPlatformName(platform.toString());
                break;
            case "chrome":
                MutableCapabilities capabilities = new MutableCapabilities();
                ChromeOptions chromeOptions = new ChromeOptions();
                capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                capabilities.setCapability("browserName", "Chrome");
                chromeOptions.setPlatformName(platform.toString());
                chromeOptions.merge(capabilities);
                break;
            case "edge":
                EdgeOptions eOptions = new EdgeOptions();
                eOptions.setCapability("browserName","Edge");
                eOptions.setPlatformName(platform.toString());
                break;
            default:
                throw new RuntimeException("Browser is not valid!");
        }

        try {
            driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, portNumber)), capability);
            // waiting for fixing
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
