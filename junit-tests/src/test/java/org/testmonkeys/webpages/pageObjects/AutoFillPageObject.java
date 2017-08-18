package org.testmonkeys.webpages.pageObjects;

import org.testmonkeys.koshmar.pageobjects.AbstractEntityPage;
import org.testmonkeys.koshmar.pageobjects.AbstractPage;
import org.testmonkeys.koshmar.pageobjects.ElementAccessor;
import org.testmonkeys.koshmar.pageobjects.PageAccessor;
import org.testmonkeys.koshmar.pageobjects.elements.Input;
import org.testmonkeys.koshmar.pageobjects.entitymapping.MapsToField;

@PageAccessor(name = "HtmlElements", url = "")
public class AutoFillPageObject extends AbstractEntityPage {

    @MapsToField("phone")
    @ElementAccessor(elementName = "input", byId = "phone_9")
    private Input phone;

    @MapsToField("username")
    @ElementAccessor(elementName = "input2", byId = "username")
    private Input username;

    public Input getPhone() {
        return phone;
    }

    public Input getUsername() {
        return username;
    }
}
