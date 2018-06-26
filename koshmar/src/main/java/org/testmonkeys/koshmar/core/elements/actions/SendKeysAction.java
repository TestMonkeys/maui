package org.testmonkeys.koshmar.core.elements.actions;

import org.openqa.selenium.WebElement;
import org.testmonkeys.koshmar.pageobjects.elements.AbstractComponent;

/**
 * Created by cpascal on 3/29/2017.
 */
public class SendKeysAction extends AbstractVoidAction {

    private AbstractComponent component;
    private String keys;

    public SendKeysAction(AbstractComponent component, String keys) {
        super(component);
        this.component = component;
        this.keys = keys;
    }

    @Override
    protected void executeVoidAction(WebElement webElement) {
        webElement.sendKeys(keys);
    }

    @Override
    protected String describeAction() {
        return "Sending text '" + keys + "' to " + component;
    }
}
