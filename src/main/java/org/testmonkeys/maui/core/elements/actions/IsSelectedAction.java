package org.testmonkeys.maui.core.elements.actions;

import org.openqa.selenium.WebElement;
import org.testmonkeys.maui.pageobjects.elements.AbstractComponent;

/**
 * Created by cpascal on 3/29/2017.
 */
public class IsSelectedAction extends AbstractAction<Boolean> {

    public IsSelectedAction(AbstractComponent component) {
        super(component);
    }

    @Override
    protected Boolean executeAction(WebElement webElement) {
        return webElement.isSelected();
    }

    @Override
    protected String describeAction() {
        return "Checking if element is selected for " + component;
    }
}
