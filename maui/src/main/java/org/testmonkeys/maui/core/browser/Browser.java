package org.testmonkeys.maui.core.browser;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.testmonkeys.maui.core.browser.popups.BrowserPopUps;
import org.testmonkeys.maui.core.elements.location.LocatesElements;
import org.testmonkeys.maui.core.elements.location.Locator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Browser implements LocatesElements {

    Logger logger = LoggerFactory.getLogger(Browser.class);

    private WebDriver driver;
    private FluentWait<WebDriver> dynamicWaiter;
    private int pageTimeout;
    private int elementTimeout;
    private TimeUnit unit;
    private int step = 1;
    private BrowserPopUps browserPopUps = new BrowserPopUps(this);

    public Browser(WebDriver driver) {
        this.driver = driver;
        //TODO maximize based on external parameter
        //this.driver.manage().window().maximize();
        dynamicWaiter = initWaitter(10, step, TimeUnit.SECONDS);
    }

    public Browser(WebDriver driver, TimeUnit unit, int elementTimeout, int pageTimeout) {
        this.driver = driver;
        this.driver.manage().timeouts().pageLoadTimeout(pageTimeout, unit);
        //TODO maximize based on external parameter
        //this.driver.manage().window().maximize();
        dynamicWaiter = initWaitter(elementTimeout, 1, unit);
    }

    public byte[] takeScreenshot() {
        return ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
    }

    public FluentWait<WebDriver> getDynamicWaiter() {
        return dynamicWaiter;
    }

    @Override
    public WebElement findElement(Locator locator) {
        return dynamicWaiter.until(webDriver -> webDriver.findElement(locator.getSeleniumLocator()));
    }

    @Override
    public List<WebElement> findElements(Locator locator) {
        return dynamicWaiter.until(webDriver -> webDriver.findElements(locator.getSeleniumLocator()));
    }

    private FluentWait<WebDriver> initWaitter(int timeout, int step, TimeUnit unit) {
        return new FluentWait<>(this.driver)
                .withTimeout(timeout, unit)
                .pollingEvery(step, unit)
                .ignoring(NoSuchElementException.class);
    }

    /**
     * Gets the browser popup handler
     *
     * @return BrowserPopUps instance
     */
    public BrowserPopUps getPopUps() {
        return browserPopUps;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void goTo(String url) {
        logger.info("Accessing URL:" + url);
        driver.navigate().to(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void quit() {
        this.driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void goBack() {
        driver.navigate().back();
    }

    public void waitForPageToLoad() {
        initWaitter(pageTimeout, step, unit).until(d -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete"));
    }

    public String getPageHtml() {
        return driver.getPageSource();
    }
}
