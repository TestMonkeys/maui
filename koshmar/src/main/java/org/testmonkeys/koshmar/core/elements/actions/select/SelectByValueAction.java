package org.testmonkeys.koshmar.core.elements.actions.select;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testmonkeys.koshmar.core.elements.actions.AbstractVoidAction;
import org.testmonkeys.koshmar.pageobjects.elements.AbstractComponent;

/**
 * Created by cpascal on 3/31/2017.
 */
public class SelectByValueAction extends AbstractVoidAction {


    private String value;

    public SelectByValueAction(AbstractComponent component, String value) {
        super(component);
        this.value = value;
    }

    @Override
    protected void executeVoidAction(WebElement webElement) {
        new Select(webElement).selectByValue(value);
    }
}
