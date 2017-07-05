package org.testmonkeys.selenium.engine.pageobjects.elements;

import org.testmonkeys.selenium.engine.core.elements.actions.ClickAction;
import org.testmonkeys.selenium.engine.core.elements.actions.GetTextAction;


public class Button extends AbstractComponent {

    public void click() {
        new ClickAction(this).execute();
    }

    public String getText() {
        return new GetTextAction(this).execute();
    }
}
