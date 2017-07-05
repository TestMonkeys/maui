package org.testmonkeys.selenium.engine.pageobjects.elements;

import org.testmonkeys.selenium.engine.core.elements.actions.GetTextAction;

/**
 * Created by cpascal on 3/29/2017.
 */
public class Label extends AbstractComponent {

    public String getText() {
        return new GetTextAction(this).execute();
    }
}
