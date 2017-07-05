package org.testmonkeys.selenium.engine.core.elements;

import org.openqa.selenium.WebElement;
import org.testmonkeys.selenium.engine.core.browser.Browser;
import org.testmonkeys.selenium.engine.core.elements.location.LocatesElements;
import org.testmonkeys.selenium.engine.core.elements.location.Locator;

import java.util.List;

public interface Component extends LocatesElements {

    Locator getLocator();

    void setLocator(Locator locator);

    LocatesElements getParent();

    void setParent(LocatesElements parent);

    WebElement find();

    Browser getBrowser();

    void setBrowser(Browser browser);

    List<WebElement> findAll();

    void setName(String name);
}
