package org.testmonkeys.sut.demoqa;

import org.testmonkeys.koshmar.pageobjects.AbstractPage;
import org.testmonkeys.koshmar.pageobjects.ElementAccessor;
import org.testmonkeys.koshmar.pageobjects.PageAccessor;
import org.testmonkeys.koshmar.pageobjects.elements.Button;
import org.testmonkeys.koshmar.pageobjects.elements.GroupComponent;
import org.testmonkeys.koshmar.pageobjects.elements.RadioButtonGroup;

@PageAccessor(name = "Registration Page", url="/registration")
public class RegistrationPage extends AbstractPage {

    @ElementAccessor(elementName="Interactions", byName = "radio_4[]")
    private RadioButtonGroup maritalStatus;


    public RadioButtonGroup getMaritalStatus() {
        return maritalStatus;
    }
}
