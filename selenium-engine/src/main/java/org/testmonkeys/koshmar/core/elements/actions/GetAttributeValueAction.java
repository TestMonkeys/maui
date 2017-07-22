package org.testmonkeys.koshmar.core.elements.actions;

import org.openqa.selenium.WebElement;
import org.testmonkeys.koshmar.pageobjects.elements.AbstractComponent;

/**
 * Created by cpascal on 3/29/2017.
 */
public class GetAttributeValueAction extends AbstractAction<String> {

    private String attributeName;

    public GetAttributeValueAction(AbstractComponent component, String attributeName) {
        super(component);
        this.attributeName = attributeName;
    }

    @Override
    protected String executeAction(WebElement webElement) {
        return webElement.getAttribute(attributeName);
    }
}
