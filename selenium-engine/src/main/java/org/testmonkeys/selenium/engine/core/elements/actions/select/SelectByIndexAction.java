package org.testmonkeys.selenium.engine.core.elements.actions.select;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testmonkeys.selenium.engine.core.elements.actions.AbstractVoidAction;
import org.testmonkeys.selenium.engine.pageobjects.elements.AbstractComponent;

/**
 * Created by cpascal on 3/31/2017.
 */
public class SelectByIndexAction extends AbstractVoidAction {


    private int value;

    public SelectByIndexAction(AbstractComponent component, int value) {
        super(component);
        this.value = value;
    }

    @Override
    protected void executeVoidAction(WebElement webElement) {
        new Select(webElement).selectByIndex(value);
    }
}
