package org.testmonkeys.maui.core.elements.actions;

import org.openqa.selenium.WebElement;
import org.testmonkeys.maui.pageobjects.elements.AbstractComponent;

/**
 * Created by cpascal on 3/29/2017.
 */
public class GetTextAction extends AbstractAction<String> {

    public GetTextAction(AbstractComponent component) {
        super(component);
    }

    @Override
    protected String executeAction(WebElement webElement) {
        return webElement.getText();
    }

    @Override
    protected String describeAction() {
        return "Getting text from " + component;
    }
}
