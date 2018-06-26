package org.testmonkeys.sut.demoqa;

import org.testmonkeys.maui.pageobjects.AbstractPage;
import org.testmonkeys.maui.pageobjects.ElementAccessor;
import org.testmonkeys.maui.pageobjects.PageAccessor;
import org.testmonkeys.maui.pageobjects.elements.CheckBox;
import org.testmonkeys.maui.pageobjects.elements.GroupComponent;
import org.testmonkeys.maui.pageobjects.elements.RadioButtonGroup;

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
