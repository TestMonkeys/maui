package org.testmonkeys.maui.pageobjects.elements;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testmonkeys.maui.core.browser.Browser;
import org.testmonkeys.maui.core.elements.Component;
import org.testmonkeys.maui.core.elements.location.LocatesElements;
import org.testmonkeys.maui.core.elements.location.Locator;
import org.testmonkeys.maui.pageobjects.elements.html.HtmlElement;
import org.testmonkeys.maui.pageobjects.modules.LazyLoading;

import java.util.List;


public abstract class AbstractComponent implements Component {

    protected WebElement webElement;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private String name;
    private Locator locator;
    private Browser browser;
    private LocatesElements parent;

    public AbstractComponent() {

    }

    protected Logger getLogger() {
        return logger;
    }

    public HtmlElement getHtmlElement() {
        return new HtmlElement(this);
    }

    public void setWebElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Locator getLocator() {
        return locator;
    }

    @Override
    public void setLocator(Locator locator) {
        this.locator = locator;
    }

    @Override
    public LocatesElements getParent() {
        return parent;
    }

    @Override
    public void setParent(LocatesElements parent) {
        this.parent = parent;
    }

    @Override
    public WebElement find() {
        if (webElement != null && isAlive(webElement)) {
            return webElement;
        }

        if (parent == null)
            webElement = browser.findElement(locator);
        else
            webElement = parent.findElement(locator);
        return webElement;
    }

    @Override
    public Browser getBrowser() {
        return browser;
    }

    @Override
    public void setBrowser(Browser browser) {
        this.browser = browser;
    }

    @Override
    public List<WebElement> findAll() {
        if (parent == null)
            return browser.findElements(locator);
        else {
            if (parent instanceof LazyLoading) {
                browser.getDynamicWaiter().until(p -> ((LazyLoading) parent).isReady());
            }
            return parent.findElements(locator);
        }
    }

    @Override
    public WebElement findElement(Locator elementLocator) {
        WebElement element = null;

        try {
            element = find().findElement(elementLocator.getSeleniumLocator());
        } catch (StaleElementReferenceException e) {
            element = find().findElement(elementLocator.getSeleniumLocator());
        }
        return element;
    }

    protected boolean isAlive(WebElement webElement) {
        boolean alive;
//        if (webElement==null)
//            alive= false;
//
        try {
            webElement.isDisplayed();

            alive = true;
        } catch (Exception e) {
            alive = false;
        }
        getLogger().info("element is alive=" + alive + "; " + this);
        return alive;
    }

    @Override
    public List<WebElement> findElements(Locator elementLocator) {
        return find().findElements(elementLocator.getSeleniumLocator());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "(name=" + this.getName() +
                ", locator[" + this.getLocator().getLocatorType() +
                ", \"" + this.getLocator().getLocatorValue() +
                "\"])";
    }
}
