package org.testmonkeys.maui.core.elements.actions;

import org.openqa.selenium.WebElement;
import org.testmonkeys.maui.pageobjects.elements.AbstractComponent;

/**
 * Created by cpascal on 3/29/2017.
 */
public abstract class AbstractVoidAction extends AbstractAction<Void> {
    public AbstractVoidAction(AbstractComponent component) {
        super(component);
    }

    @Override
    protected Void executeAction(WebElement webElement) {
        executeVoidAction(webElement);
        return null;
    }

    protected abstract void executeVoidAction(WebElement webElement);


}
