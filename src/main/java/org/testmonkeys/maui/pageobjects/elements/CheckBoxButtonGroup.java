package org.testmonkeys.maui.pageobjects.elements;

import java.util.*;
//TODO: this is a rough copy of RaioButtonGroup - need to adjust to specifics of checkboxes

/**
 * RadioButtonGroup represents a set of radio buttons on a web page. As per radio group definition,
 * it is bound by the name attribute in a select tag, of radio type. Due to this, this component
 * requires that you use the locator to the radio buttons, as you would in a list. Our recommendation
 * would be to bind either to the name or with an xPath, binding to type and name.
 * Example usage binding by name:
 *
 * <code>
 * &#064;ElementAccessor(elementName="marital status", byName = "radio_4")
 * private RadioButtonGroup maritalStatus;
 * </code>
 * Example usage binding by xpath:
 * <code>
 * &#064;ElementAccessor(elementName="marital status", byXPath = "/select[@type='radio' and @name='radio_4']")
 * private RadioButtonGroup maritalStatus;
 * </code>
 */
public class CheckBoxButtonGroup extends GroupComponent<CheckBox> implements FillableComponent<Set<Enum>> {

    public CheckBoxButtonGroup() {
        setItemType(CheckBox.class);
    }

    /**
     * Gets all values from Radio Buttons in group. This is done using the value attribute.
     *
     * @return List - list of values
     */
    public List<String> getValues() {
        List<CheckBox> options = getAll();
        List<String> values = new ArrayList<>();
        for (CheckBox element : options)
            values.add(element.getValue());
        return values;
    }

    /**
     * Selects a Radio Button by value. The value should be present in the value attribute.
     *
     * @param value - value to be selected
     * @throws NoSuchElementException - if value is not present in group
     */
    public void selectByValue(String value) {
        Optional<CheckBox> option = getAll().stream().filter(o -> value.equalsIgnoreCase(o.getValue())).findFirst();
        if (option.isPresent())
            option.get().check();
        else
            throw new NoSuchElementException("Could not find radio button by value " + value);
    }

    /**
     * Selects a Radio Button by index.
     *
     * @param index - zero based index to be selected
     * @throws IndexOutOfBoundsException - if index is outside the bounds of the group
     */
    public void selectByIndex(int index) {
        List<CheckBox> options = getAll();
        if (options.size() > index)
            options.get(index).check();
        else
            throw new IndexOutOfBoundsException("Could not find radio button by index " + index +
                    ", radio button group size is " + options.size());
    }

    @Override
    public void fill(Set<Enum> values) {
        for (Object value : values)
            this.selectByValue(value.toString());
    }
//
//    /**
//     * Gets the selected value from the Radio Button Group, by finding the selected radio button and
//     * retrieving the value attribute from it.
//     *
//     * @return String value of the selected radio button or NULL if no radio button was selected
//     */
//    public String getSelectedValues() {
//        List<CheckBox> options = getAll();
//        for (CheckBox element : options)
//            if (element.isSelected())
//                return element.getValue();
//        return null;
//    }

//    /**
//     * Gets the selected index from the Radio Button Group
//     *
//     * @return int index of the selected radio button or -1 if no radio button was selected
//     */
//    public int getSelectedIndex() {
//        List<RadioButton> options = getAll();
//        for (int i = 0; i < options.size(); i++)
//            if (options.get(i).isSelected())
//                return i;
//        return -1;
//    }
}
