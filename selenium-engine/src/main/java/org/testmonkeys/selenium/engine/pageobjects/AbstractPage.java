package org.testmonkeys.selenium.engine.pageobjects;

import org.openqa.selenium.WebElement;
import org.testmonkeys.selenium.engine.core.browser.Browser;
import org.testmonkeys.selenium.engine.core.elements.location.Locator;
import org.testmonkeys.selenium.engine.core.page.Page;

import java.util.List;

public abstract class AbstractPage implements Page {

    private String url;
    private String name;
    private Browser browser;

    public AbstractPage() {
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Browser getBrowser() {
        return browser;
    }

    @Override
    public void setBrowser(Browser browser) {
        this.browser = browser;
    }

    @Override
    public void open() {
        browser.goTo(url);
    }

    @Override
    public String title() {
        return browser.getTitle();
    }

    @Override
    public boolean isCurrentPage() {
        return browser.getDriver().getCurrentUrl().startsWith(url);
    }

    @Override
    public WebElement findElement(Locator locator){
        return browser.findElement(locator);
    }

    @Override
    public List<WebElement> findElements(Locator locator){
        return browser.findElements(locator);
    }


}
