package org.testmonkeys.koshmar.pageobjects.elements;

import org.openqa.selenium.WebElement;
import org.testmonkeys.koshmar.core.elements.actions.ClickAction;

public class CheckBox extends AbstractComponent {

    public boolean isChecked() {
        return this.find().isSelected();
    }

    /**
     * Checks the checkbox.
     * If the checkbox is already checked no action will be taken
     */
    public void check() {
        WebElement element = this.find();
        if (!element.isSelected()) {
            new ClickAction(this).execute();
        }
    }

    /**
     * Uncheck the checkbox.
     * If the checkbox is already unchecked no action will be taken
     */
    public void uncheck() {
        WebElement element = this.find();
        if (element.isSelected()) {
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
