package playground.atf.tests.pageObjects;

import org.testmonkeys.koshmar.pageobjects.ElementAccessor;
import org.testmonkeys.koshmar.pageobjects.PageAccessor;
import org.testmonkeys.koshmar.pageobjects.AbstractPage;
import org.testmonkeys.koshmar.pageobjects.elements.GroupComponent;

/**
 * Created by cpascal on 3/29/2017.
 */

@PageAccessor(name = "emagPage", url="/laptopuri/c?ref=hp_menu_quick-nav_1_1&type=category")
public class EmagPage extends AbstractPage {

    public GroupComponent<ItemModule> getPhoneBox() {
        return phoneBox;
    }

    @ElementAccessor(elementName = "item", byXPath = "//div[@class='product-holder-grid']")
    private GroupComponent<ItemModule> phoneBox;


}
