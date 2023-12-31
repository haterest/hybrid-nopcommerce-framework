package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    public BasePage (WebDriver driver){
        this.driver = driver;
    }

    protected void openPageURL(String pageURL) {
        driver.get(pageURL);
    }

    protected void quitPageURL() {
        driver.quit();
    }

    protected String getPageTitle() {
        return driver.getTitle();
    }

    protected String getPageURL( ) {
        return driver.getCurrentUrl();
    }

    protected void backToPage( ) {
        driver.navigate().back();
    }

    protected void forwardToPage( ) {
        driver.navigate().forward();
    }

    protected void refreshCurrentPage( ) {
        driver.navigate().refresh();
    }

    protected Alert waitForAlertPresence() {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    protected void acceptAlert() {
        waitForAlertPresence().accept();
    }

    protected void cancelAlert() {
        waitForAlertPresence().dismiss();
    }

    protected String getAlertText() {
        return waitForAlertPresence().getText();
    }

    protected void sendKeyToAlert(String textToAlert) {
        waitForAlertPresence().sendKeys(textToAlert);
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private By getByLocator(String locatorType) {
        By by = null;
        if (locatorType.startsWith("id=") || locatorType.startsWith("Id=") || locatorType.startsWith("ID=")) {
            by = By.id(locatorType.substring(3));
        } else if (locatorType.startsWith("class=") || locatorType.startsWith("Class=")
                || locatorType.startsWith("CLASS=")) {
            by = By.className(locatorType.substring(6));
        } else if (locatorType.startsWith("name=") || locatorType.startsWith("Name=")
                || locatorType.startsWith("NAME=")) {
            by = By.name(locatorType.substring(5));
        } else if (locatorType.startsWith("css=") || locatorType.startsWith("Css=") || locatorType.startsWith("CSS=")) {
            by = By.cssSelector(locatorType.substring(4));
        } else if (locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=")
                || locatorType.startsWith("XPATH=") || locatorType.startsWith("XPath=")) {
            by = By.xpath(locatorType.substring(6));
        } else {
            throw new RuntimeException("Locator type is not supported");
        }
        return by;
    }

    private String getDynamicXpath(String locator, String... values) {
        if (locator.startsWith("xpath=") || locator.startsWith("Xpath=") || locator.startsWith("XPATH=")
                || locator.startsWith("XPath=")) {
            locator = String.format(locator, (Object[]) values);
        }
        return locator;
    }

    private WebElement getWebElement(String locatorType) {
        return driver.findElement(getByLocator(locatorType));
    }

    private List<WebElement> getListWebElement(String locatorType) {
        return driver.findElements(getByLocator(locatorType));
    }

    protected void clickToElement(String locator) {
        getWebElement(locator).click();
    }

    protected void clickToElement(String locator, String... dynamicValues) {
        getWebElement(getDynamicXpath(locator, dynamicValues)).click();
    }

    protected void sendKeyToElement(String locator, String textValue) {
        WebElement element = getWebElement(locator);
        element.clear();
        element.sendKeys(textValue);
    }

    protected void sendKeyToElement(String locator, String textValue, String... dynamicValues) {
        WebElement element = getWebElement(getDynamicXpath(locator, dynamicValues));
        element.clear();
        element.sendKeys(textValue);
    }

    protected void clearValueInElementByDeleteKey(String locator) {
        WebElement element = getWebElement(locator);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    protected void selectItemInDefaultDropDown(String locator, String textItem) {
        Select select = new Select(getWebElement(locator));
        select.selectByVisibleText(textItem);
    }

    protected void selectItemInDefaultDropDown(String locator, String textItem, String... dynamicValues) {
        Select select = new Select(getWebElement(getDynamicXpath(locator, dynamicValues)));
        select.selectByVisibleText(textItem);
    }

    protected String getFirstSelectedItemDefaultDropDown(String locator) {
        Select select = new Select(getWebElement(locator));
        return select.getFirstSelectedOption().getText();
    }

    protected String getFirstSelectedItemDefaultDropDown(String locator, String... dynamicValues) {
        Select select = new Select(getWebElement(getDynamicXpath(locator, dynamicValues)));
        return select.getFirstSelectedOption().getText();
    }

    protected boolean isDropDownMultiple(String locator) {
        Select select = new Select(getWebElement(locator));
        return select.isMultiple();
    }

    protected void selectItemInCustomDropdown(String parentLocator, String childItemLocator, String expectedItem) {
        getWebElement(parentLocator).click();
        sleepInSecond(1);
        WebDriverWait explicitWait;
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        explicitWait = new WebDriverWait(driver, longTimeout);
        List<WebElement> allItems = explicitWait
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));
        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSecond(1);
                item.click();
                break;
            }
        }
    }

    protected String getElementAttribute(String locator, String attributeName) {
        return getWebElement(locator).getAttribute(attributeName);
    }

    protected String getElementAttribute(String locator, String attributeName, String... dynamicValues) {
        return getWebElement(getDynamicXpath(locator, dynamicValues)).getAttribute(attributeName);
    }

    protected String getElementText(String locator) {
        return getWebElement(locator).getText();
    }

    protected String getElementText(String locator, String... dynamicValues) {
        return getWebElement(getDynamicXpath(locator, dynamicValues)).getText();
    }

    protected int getElementsSize(String locator) {
        return getListWebElement(locator).size();
    }

    protected int getElementsSize(String locator, String... dynamicValues) {
        return getListWebElement(getDynamicXpath(locator, dynamicValues)).size();
    }

    protected void checkToDefautCheckboxOrRadio(String locator) {
        WebElement element = getWebElement(locator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    protected void checkToDefautCheckboxOrRadio(String locator, String... dynamicValues) {
        WebElement element = getWebElement(getDynamicXpath(locator, dynamicValues));
        if (!element.isSelected()) {
            element.click();
        }
    }

    protected void uncheckToDefaultCheckbox(String locator) {
        WebElement element = getWebElement(locator);
        if (element.isSelected()) {
            element.click();
        }
    }

    protected void uncheckToDefaultCheckbox(String locator, String... dynamicValues) {
        WebElement element = getWebElement(getDynamicXpath(locator, dynamicValues));
        if (element.isSelected()) {
            element.click();
        }
    }

    protected boolean isElementDisplayed(String locator) {
        return getWebElement(locator).isDisplayed();
    }

    protected boolean isElementDisplayed(String locator, String... dynamicValues) {
        return getWebElement(getDynamicXpath(locator, dynamicValues)).isDisplayed();
    }

    protected boolean isElementUndisplayed(String locator) {
        overrideGlobalTimeout(shortTimeout);
        List<WebElement> elements = getListWebElement(locator);
        overrideGlobalTimeout(longTimeout);
        if (elements.size() == 0) {
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    protected boolean isElementUndisplayed(String locator, String... dynamicValues) {
        overrideGlobalTimeout(shortTimeout);
        List<WebElement> elements = getListWebElement(getDynamicXpath(locator, dynamicValues));
        overrideGlobalTimeout(longTimeout);
        if (elements.size() == 0) {
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * Wait for element undisplayed in DOM or not in DOM and override implicit Timeout
     */
    protected void waitForElementUndisplayed(String locator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeout);
        overrideGlobalTimeout(shortTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
        overrideGlobalTimeout(longTimeout);
    }

    protected void waitForAllElementsInvisible(String locator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(locator)));
    }

    protected void waitForAllElementsInvisible(String locator, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions
                .invisibilityOfAllElements(getListWebElement(getDynamicXpath(locator, dynamicValues))));
    }

    private void overrideGlobalTimeout(Duration timeOut) {
        driver.manage().timeouts().implicitlyWait(timeOut);
    }

    protected boolean isElementEnabled(String locator) {
        return getWebElement(locator).isEnabled();
    }

    protected boolean isElementSelected(String locator) {
        return getWebElement(locator).isSelected();
    }

    protected void switchToFrameiFrame(String locator) {
        driver.switchTo().frame(getWebElement(locator));
    }

    protected void switchToDefaultContent(String locator) {
        driver.switchTo().defaultContent();
    }

    protected void hoverMouseToElement(String locator) {
        Actions action = new Actions(driver);
        action.moveToElement(getWebElement(locator)).perform();
    }

    protected void pressKeyToElement(String locator, Keys key) {
        Actions action = new Actions(driver);
        action.sendKeys(getWebElement(locator), key).perform();
    }

    protected void pressKeyToElement(String locator, Keys key, String... dynamicValues) {
        Actions action = new Actions(driver);
        action.sendKeys(getWebElement(getDynamicXpath(locator, dynamicValues)), key).perform();
    }

    protected Object executeForBrowser(String javaScript) {
        return ((JavascriptExecutor) driver).executeScript(javaScript);
    }

    protected String getInnerText() {
        return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
    }

    protected boolean areExpectedTextInInnerText(String textExpected) {
        String textActual = (String) ((JavascriptExecutor) driver)
                .executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
        return textActual.equals(textExpected);
    }

    protected void scrollToBottomPage() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    protected void navigateToUrlByJS(String url) {
        ((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
    }

    protected void highlightElement(String locator) {
        WebElement element = getWebElement(locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element,
                "style", "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element,
                "style", originalStyle);
    }

    protected void highlightElement(String locator, String... dynamicValues) {
        WebElement element = getWebElement( getDynamicXpath(locator, dynamicValues));
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element,
                "style", "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element,
                "style", originalStyle);
    }

    protected void clickToElementByJS(String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(  locator));
    }

    protected void clickToElementByJS(String locator, String... dynamicValues) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                getWebElement( getDynamicXpath(locator, dynamicValues)));
    }

    protected void scrollToElement(String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                getWebElement( locator));
    }

    protected void sendkeyToElementByJS(String locator, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')",
                getWebElement( locator));
    }

    protected void removeAttributeInDOM(String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
                getWebElement( locator));
    }

    protected boolean areJQueryAndJSLoadedSuccess() {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        };
        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    protected String getElementValidationMessage(String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;",
                getWebElement(locator));
    }

    protected boolean isImageLoaded(String locator) {
        boolean status = (boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
                getWebElement(locator));
        if (status) {
            return true;
        } else {
            return false;
        }
    }

    protected boolean isImageLoaded(String locator, String... dynamicValues) {
        boolean status = (boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
                getWebElement(getDynamicXpath(locator, dynamicValues)));
        return status;
    }

    protected void waitForElementVisible(String locator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }


    protected void waitForElementVisible(String locator, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(
                ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(locator, dynamicValues))));
    }

    protected void waitForAllElementsVisible(String locator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locator)));
    }

    protected void waitForAllElementsVisible(String locator, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locator, dynamicValues))));
    }

    protected void waitForElementInvisible(String locator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    protected void waitForElementInvisible(String locator, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(
                ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locator, dynamicValues))));
    }

    protected void waitForElementClickable(String locator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    protected void waitForElementClickable(String locator, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait
                .until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locator, dynamicValues))));
    }

    protected boolean isKeywordDisplayInSearchResult(String locator, String keywords) {
        List<WebElement> listElement = getListWebElement(locator);
        for (WebElement eachElement : listElement) {
            if (eachElement.getText().contains(keywords)) {
                return true;
            }
        }
        return false;
    }

    private WebDriver driver;
    private Duration longTimeout = Duration.ofSeconds(GlobalConstant.getGlobalConstants().getLongTimeout());
    private Duration shortTimeout = Duration.ofSeconds(GlobalConstant.getGlobalConstants().getShortTimeout());
}
