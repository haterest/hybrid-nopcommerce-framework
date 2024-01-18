package commons;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;
import utilities.DataHelper;
import utilities.ElementData;

import java.util.Set;

public class CommonRegisterLogin extends BaseTest {

    @Parameters({"envName", "severName", "browserName", "osName", "ipAddress", "portNumber"})
    @BeforeTest(description = "Create new common user for all classes test")
    public void beforeTest(@Optional("local") String envName, @Optional("dev") String severName, @Optional("chrome")
    String browserName, @Optional("10") String osName, @Optional("142") String ipAddress, @Optional("9999") String portNumber) {
        driver = getBrowserDriver(envName, severName, browserName, osName, ipAddress, portNumber);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        dataFaker = DataHelper.getData();
        emailAddress = dataFaker.getEmail();
        password = dataFaker.getPassword();
        firstName = dataFaker.getFirstName();
        lastName = dataFaker.getLastName();

        userHomePage.clickToMenuLinkByName(ElementData.BasePage.REGISTER_MENU_LINK_ID);
        userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.FIRST_NAME_TEXTBOX_ID, firstName);
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.LAST_NAME_TEXTBOX_ID, lastName);
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.EMAIL_TEXTBOX_ID, emailAddress);
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.PASSWORD_TEXTBOX_ID, password);
        userRegisterPage.inputToTextboxById(ElementData.RegisterPage.CONFIRM_PASSWORD_TEXTBOX_ID, password);
        userRegisterPage.clickToRegisterButton();
        verifyEquals(userRegisterPage.getRegisterSuccesfulMessage(), "Your registration completed");

        userHomePage.clickToMenuLinkByName(ElementData.BasePage.LOGIN_MENU_LINK_ID);
        userLoginPage = PageGeneratorManager.getUserLoginPage(driver);
        userLoginPage.inputToEmailTextbox(emailAddress);
        userLoginPage.inputToPasswordTextbox(password);
        userLoginPage.clickToLoginButton();
        userHomePage = PageGeneratorManager.getUserHomePage(driver);
        verifyTrue(userHomePage.isMyAccountLinkDisplayed());

        loggedCookies = userHomePage.getAllCookie();

        closeBrowserDriver();
    }

    WebDriver driver;
    public static Set<Cookie> loggedCookies;
    DataHelper dataFaker;
    public static String emailAddress, password, firstName, lastName;
    UserRegisterPageObject userRegisterPage;
    UserLoginPageObject userLoginPage;
    UserHomePageObject userHomePage;
}
