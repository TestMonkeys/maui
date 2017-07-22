package org.testmonkeys.koshmar.core.elements.actions;

import org.openqa.selenium.WebElement;
import org.testmonkeys.koshmar.pageobjects.elements.AbstractComponent;

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
}
