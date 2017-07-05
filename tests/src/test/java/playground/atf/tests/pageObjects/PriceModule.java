package playground.atf.tests.pageObjects;

import org.testmonkeys.selenium.engine.pageobjects.ElementAccessor;
import org.testmonkeys.selenium.engine.pageobjects.modules.AbstractModule;
import org.testmonkeys.selenium.engine.pageobjects.elements.GenericWebElement;

/**
 * Created by cpascal on 3/29/2017.
 */
public class PriceModule extends AbstractModule {

    @ElementAccessor(elementName = "old price", byXPath = ".//span[@class='old initial_price']/span[1]")
    private GenericWebElement oldPrice;

    @ElementAccessor(elementName = "current price", byXPath = ".//span[@class='price-over']/span[1]")
    private GenericWebElement newPrice;

    public GenericWebElement getOldPrice() {
        return oldPrice;
    }

    public GenericWebElement getNewPrice() {
        return newPrice;
    }
}
