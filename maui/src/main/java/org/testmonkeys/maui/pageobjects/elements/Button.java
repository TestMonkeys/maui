package org.testmonkeys.maui.pageobjects.elements;

import org.testmonkeys.maui.core.elements.actions.ClickAction;
import org.testmonkeys.maui.core.elements.actions.GetTextAction;


public class Button extends AbstractComponent {

    public void click() {
        new ClickAction(this).execute();
    }

    public String getText() {
        return new GetTextAction(this).execute();
    }
}
