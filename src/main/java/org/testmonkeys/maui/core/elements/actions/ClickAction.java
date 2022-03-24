package org.testmonkeys.maui.core.elements.actions;

import org.openqa.selenium.WebElement;
import org.testmonkeys.maui.pageobjects.elements.AbstractComponent;

/**
 * Created by cpascal on 3/29/2017.
 */
public class ClickAction extends AbstractVoidAction {

    public ClickAction(AbstractComponent component) {
        super(component);
    }

    @Override
    protected void executeVoidAction(WebElement webElement) {
        webElement.click();
    }

    @Override
    protected String describeAction() {
        return "Performing Click on " + component;
    }
}
