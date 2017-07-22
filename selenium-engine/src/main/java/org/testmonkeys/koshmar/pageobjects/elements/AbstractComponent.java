package org.testmonkeys.koshmar.pageobjects.elements;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testmonkeys.koshmar.core.browser.Browser;
import org.testmonkeys.koshmar.core.elements.Component;
import org.testmonkeys.koshmar.core.elements.location.LocatesElements;
import org.testmonkeys.koshmar.core.elements.location.Locator;
import org.testmonkeys.koshmar.pageobjects.modules.LazyLoading;

import java.util.List;


public abstract class AbstractComponent implements Component {

    protected WebElement webElement;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    protected Logger getLogger(){
        return logger;
    }

    private String name;
    private Locator locator;
    private Browser browser;

    private LocatesElements parent;

    public AbstractComponent() {

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
        if (isAlive(webElement)){
            return webElement;
        }

        if (parent == null)
            webElement= browser.findElement(locator);
        else
            webElement= parent.findElement(locator);
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
        return find().findElement(elementLocator.getSeleniumLocator());
    }

    protected boolean isAlive(WebElement webElement) {
        boolean alive;
//        if (webElement==null)
//            alive= false;
//
        try{
            webElement.isDisplayed();

            alive= true;
        }catch(Exception e){
            alive= false;
        }
        getLogger().info("element is alive="+alive+"; "+this);
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
