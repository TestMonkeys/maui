package org.testmonkeys.maui.pageobjects.elements;

import org.testmonkeys.maui.core.elements.actions.ClearInputAction;
import org.testmonkeys.maui.core.elements.actions.GetAttributeValueAction;
import org.testmonkeys.maui.core.elements.actions.SendKeysAction;

/**
 * Created by cpascal on 3/29/2017.
 */
public class Input extends AbstractComponent implements FillableComponent<String>, ReadableComponent<String> {

    public void type(String text) {
        new SendKeysAction(this, text).execute();
    }

    public String getText() {
        return (new GetAttributeValueAction(this, "value").execute());
    }

    public void clear() {
        new ClearInputAction(this).execute();
    }

    @Override
    public void fill(String data) {
        type(data);
    }

    @Override
    public String read() {
        return getText();
    }
}
