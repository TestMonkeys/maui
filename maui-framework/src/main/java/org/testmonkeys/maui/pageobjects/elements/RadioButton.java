package org.testmonkeys.maui.pageobjects.elements;

import org.testmonkeys.maui.core.elements.actions.ClickAction;
import org.testmonkeys.maui.core.elements.actions.GetAttributeValueAction;
import org.testmonkeys.maui.core.elements.actions.GetTextAction;
import org.testmonkeys.maui.core.elements.actions.IsSelectedAction;

public class RadioButton extends AbstractComponent {

    public void select() {
        new ClickAction(this).execute();
    }

    public boolean isSelected(){
        return new IsSelectedAction(this).execute();
    }

    public String getValue(){
        return new GetAttributeValueAction(this,"value").execute();
    }

    public String getText() {
        return new GetTextAction(this).execute();
    }
}
