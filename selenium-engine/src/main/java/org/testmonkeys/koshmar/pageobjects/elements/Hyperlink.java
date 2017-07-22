package org.testmonkeys.koshmar.pageobjects.elements;

import org.openqa.selenium.Keys;
import org.testmonkeys.koshmar.core.elements.actions.GetAttributeValueAction;
import org.testmonkeys.koshmar.core.elements.actions.GetTextAction;
import org.testmonkeys.koshmar.core.elements.actions.SendKeysAction;

/**
 * Created by cpascal on 3/29/2017.
 */
public class Hyperlink extends AbstractComponent {

    public String getText() {
        return new GetTextAction(this).execute();
    }

    public String getHref() {
        return new GetAttributeValueAction(this, "href").execute();
    }

    public void go() {
        new SendKeysAction(this, Keys.ENTER.toString()).execute();
    }
}
