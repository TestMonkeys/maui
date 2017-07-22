package org.testmonkeys.koshmar.pageobjects.elements;

import org.testmonkeys.koshmar.core.elements.actions.ClickAction;
import org.testmonkeys.koshmar.core.elements.actions.GetTextAction;


public class Button extends AbstractComponent {

    public void click() {
        new ClickAction(this).execute();
    }

    public String getText() {
        return new GetTextAction(this).execute();
    }
}
