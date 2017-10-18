package org.testmonkeys.webpages.pageObjects;

import org.testmonkeys.koshmar.pageobjects.AbstractEntityPage;
import org.testmonkeys.koshmar.pageobjects.AbstractPage;
import org.testmonkeys.koshmar.pageobjects.ElementAccessor;
import org.testmonkeys.koshmar.pageobjects.PageAccessor;
import org.testmonkeys.koshmar.pageobjects.elements.CheckBox;
import org.testmonkeys.koshmar.pageobjects.elements.Input;
import org.testmonkeys.koshmar.pageobjects.entitymapping.MapsToField;
import org.testmonkeys.webpages.tests.entitymapping.UserEntity;

@PageAccessor(name = "HtmlElements", url = "")
public class AutoFillPageObject extends AbstractEntityPage {


    @ElementAccessor(elementName = "input", byId = "phone_9")
    private Input phone;


    @ElementAccessor(elementName = "input2", byId = "username")
    private Input username;

    @ElementAccessor(elementName = "", byName = "checkbox_5[]")
    private CheckBox readingHobby;

    @MapsToField(value = "phone", clazz = UserEntity.class)
    public Input phone() {
        return phone;
    }

    public Input username() {
        return username;
    }

    public CheckBox readingHobby() {
        return readingHobby;
    }
}
