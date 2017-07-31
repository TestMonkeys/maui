package org.testmonkeys.koshmar.core.elements.actions;

import org.openqa.selenium.WebElement;
import org.testmonkeys.koshmar.pageobjects.elements.AbstractComponent;

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
}
