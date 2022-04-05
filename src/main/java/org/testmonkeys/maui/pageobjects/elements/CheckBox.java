package org.testmonkeys.maui.pageobjects.elements;

import org.testmonkeys.maui.core.elements.actions.ClickAction;

public class CheckBox extends AbstractComponent {

    public boolean isChecked() {
        return this.find().isSelected();
    }

    /**
     * Checks the checkbox.
     * If the checkbox is already checked no action will be taken
     */
    public void check() {
        if (!isChecked()) {
            new ClickAction(this).execute();
        }
    }

    /**
     * Uncheck the checkbox.
     * If the checkbox is already unchecked no action will be taken
     */
    public void uncheck() {
        if (isChecked()) {
            new ClickAction(this).execute();
        }
    }

    /**
     * Returns the value of the attribute 'value'
     *
     * @return - value attribute
     */
    public String getValue() {
        return this.find().getAttribute("value");
    }
}
