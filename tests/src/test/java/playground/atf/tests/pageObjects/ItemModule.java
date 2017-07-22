package playground.atf.tests.pageObjects;

import org.testmonkeys.koshmar.pageobjects.ElementAccessor;
import org.testmonkeys.koshmar.pageobjects.elements.GroupItem;

/**
 * Created by cpascal on 3/29/2017.
 */
public class ItemModule extends GroupItem {

    @ElementAccessor(elementName = "priceModule",byClassName = "produs-listing-price-box")
    private PriceModule priceModule;

    public PriceModule getPriceModule() {
        return priceModule;
    }
}
