package org.testmonkeys.koshmar.pageobjects.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * RadioButtonGroup represents a set of radio buttons on a web page. As per radio group definition,
 * it is bound by the name attribute in a select tag, of radio type. Due to this, this component
 * requires that you use the locator to the radio buttons, as you would in a list. Our recommendation
 * would be to bind either to the name or with an xPath, binding to type and name.
 * Example usage binding by name:
 * <code>
 *     @ElementAccessor(elementName="marital status", byName = "radio_4")
 *     private RadioButtonGroup maritalStatus;
 * </code>
 * Example usage binding by xpath:
 * <code>
 *     @ElementAccessor(elementName="marital status", byXPath = "/select[@type='radio' and @name='radio_4']")
 *     private RadioButtonGroup maritalStatus;
 * </code>
 */
public class RadioButtonGroup extends GroupComponent<RadioButton> {

    public List<String> getValues(){
        List<RadioButton> options=getAll();
        List<String> values = new ArrayList<>();
        for (RadioButton element: options)
            values.add(element.getValue());
        return values;
    }

    public void selectByValue(String value){
        Optional<RadioButton> option =getAll().stream().filter(o->value.equals(o.getValue())).findFirst();
        if (option.isPresent())
            option.get().select();
        else
            throw new RuntimeException("Could not find radio button by value");
    }

    public void selectByIndex(int index){
        List<RadioButton> options=getAll();
        if (options.size()>index)
            options.get(index).select();
        else
            throw new RuntimeException("Could not find radio button by index");
    }

    public String getSelectedValue(){
        List<RadioButton> options=getAll();
        for (RadioButton element:options)
            if (element.isSelected())
                return element.getValue();
        return "NONE";
    }

    public int getSelectedIndex(){
        List<RadioButton> options=getAll();
        for (int i=0; i<options.size();i++)
            if (options.get(i).isSelected())
                return i;
        return -1;
    }
}
