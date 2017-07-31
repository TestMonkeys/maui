package org.testmonkeys.koshmar.pageobjects.elements;

import org.testmonkeys.koshmar.core.elements.actions.ClickAction;
import org.testmonkeys.koshmar.core.elements.actions.GetAttributeValueAction;
import org.testmonkeys.koshmar.core.elements.actions.GetTextAction;
import org.testmonkeys.koshmar.core.elements.actions.IsSelectedAction;

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
