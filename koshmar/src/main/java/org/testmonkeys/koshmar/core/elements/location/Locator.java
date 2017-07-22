package org.testmonkeys.koshmar.core.elements.location;

import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by cpascal on 3/28/2017.
 */
public class Locator {

    private LocatorType locatorType;

    private String locatorValue;

    private int position;

    public Locator(LocatorType locatorType, String locatorValue) {
        this.locatorType = locatorType;
        this.locatorValue = locatorValue;
    }

    public LocatorType getLocatorType() {
        return locatorType;
    }

    public void setLocatorType(LocatorType locatorType) {
        this.locatorType = locatorType;
    }

    public String getLocatorValue() {
        return locatorValue;
    }

    public void setLocatorValue(String locatorValue) {
        this.locatorValue = locatorValue;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public By getSeleniumLocator() {
        switch (locatorType) {
            case Id:
                return new By.ById(locatorValue);
            case Name:
                return new By.ByName(locatorValue);
            case XPath:
                return new By.ByXPath(locatorValue);
            case TagName:
                return new By.ByTagName(locatorValue);
            case LinkText:
                return new By.ByLinkText(locatorValue);
            case ClassName:
                return new By.ByClassName(locatorValue);
            case CssSelector:
                return new By.ByCssSelector(locatorValue);
            case PartialLinkText:
                return new By.ByPartialLinkText(locatorValue);
//            default:
//                throw new Exception("no such locator");
        }
        return new By.ByXPath(locatorValue);
    }
}
