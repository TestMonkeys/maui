package org.testmonkeys.maui.pageobjects.elements;

import org.testmonkeys.maui.core.elements.actions.GetTextAction;

/**
 * Created by cpascal on 3/29/2017.
 */
public class Label extends AbstractComponent {

    public String getText() {
        return new GetTextAction(this).execute();
    }
}
