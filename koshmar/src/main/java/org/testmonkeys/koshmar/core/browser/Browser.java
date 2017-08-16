package org.testmonkeys.koshmar.core.browser;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testmonkeys.koshmar.core.browser.popups.BrowserPopUps;
import org.testmonkeys.koshmar.core.elements.location.LocatesElements;
import org.testmonkeys.koshmar.core.elements.location.Locator;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Browser implements LocatesElements {

    private WebDriver driver;
    private FluentWait<WebDriver> dynamicWaiter;
    private int timeout;
    private int step;
    private TimeUnit unit;
    private BrowserPopUps browserPopUps = new BrowserPopUps(this);

    public Browser(WebDriver driver) {
        this.driver = driver;
        //TODO maximize based on external parameter
        //this.driver.manage().window().maximize();
        dynamicWaiter = initWaitter(10, 1, TimeUnit.SECONDS);
    }

    public Browser(WebDriver driver, int timeout, int step, TimeUnit unit) {
        this.driver = driver;
        //TODO maximize based on external parameter
        //this.driver.manage().window().maximize();
        dynamicWaiter = initWaitter(timeout, step, unit);
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
}
