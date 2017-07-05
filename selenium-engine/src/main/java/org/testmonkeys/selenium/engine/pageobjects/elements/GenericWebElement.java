package org.testmonkeys.selenium.engine.pageobjects.elements;

import org.testmonkeys.selenium.engine.core.elements.actions.ClickAction;
import org.testmonkeys.selenium.engine.core.elements.actions.GetTextAction;

/**
 * Created by cpascal on 3/29/2017.
 */
public class GenericWebElement extends AbstractComponent {


    public String getText() {
        return new GetTextAction(this).execute();

    }

    public void click() {
        new ClickAction(this).execute();
    }
}
