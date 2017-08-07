package org.testmonkeys.sut.demoqa;

import org.testmonkeys.koshmar.pageobjects.AbstractPage;
import org.testmonkeys.koshmar.pageobjects.ElementAccessor;
import org.testmonkeys.koshmar.pageobjects.PageAccessor;
import org.testmonkeys.koshmar.pageobjects.elements.CheckBox;
import org.testmonkeys.koshmar.pageobjects.elements.GroupComponent;
import org.testmonkeys.koshmar.pageobjects.elements.RadioButtonGroup;

@PageAccessor(name = "Registration Page", url = "")
public class RegistrationPage extends AbstractPage {

    @ElementAccessor(elementName = "Interactions", byName = "radio_4[]")
    private RadioButtonGroup maritalStatus;

    @ElementAccessor(elementName = "Hobby", byXPath = "//div[@class='radio_wrap']/input[@type='checkbox']")
    private GroupComponent<CheckBox> hobby;


    public RadioButtonGroup getMaritalStatus() {
        return maritalStatus;
    }

    public GroupComponent<CheckBox> hobbyCheckBoxes() {
        return hobby;
    }
}
