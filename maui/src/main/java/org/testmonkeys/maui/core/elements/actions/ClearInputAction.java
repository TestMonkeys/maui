package org.testmonkeys.maui.core.elements.actions;

import org.openqa.selenium.WebElement;
import org.testmonkeys.maui.pageobjects.elements.AbstractComponent;

public class ClearInputAction extends AbstractVoidAction {

    public ClearInputAction(AbstractComponent component) {
        super(component);
    }

    @Override
    protected void executeVoidAction(WebElement webElement) {
        webElement.clear();
    }

    @Override
    protected String describeAction() {
        return "Performing Clear on " + component;
    }
}
