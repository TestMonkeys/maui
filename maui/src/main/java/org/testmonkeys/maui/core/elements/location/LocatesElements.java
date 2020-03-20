package org.testmonkeys.maui.core.elements.location;

import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by cpascal on 3/29/2017.
 */
public interface LocatesElements {
    WebElement findElement(Locator locator);

    List<WebElement> findElements(Locator locator);

    WebElement instantFind(Locator locator);
}
