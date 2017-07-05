package playground.atf.tests.pageObjects;

import org.testmonkeys.selenium.engine.pageobjects.ElementAccessor;
import org.testmonkeys.selenium.engine.pageobjects.PageAccessor;
import org.testmonkeys.selenium.engine.pageobjects.AbstractPage;
import org.testmonkeys.selenium.engine.pageobjects.elements.GroupComponent;
import org.testmonkeys.selenium.engine.pageobjects.elements.GroupItem;

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
