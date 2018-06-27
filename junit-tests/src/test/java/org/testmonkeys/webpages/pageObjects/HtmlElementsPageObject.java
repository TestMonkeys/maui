package org.testmonkeys.webpages.pageObjects;

import org.testmonkeys.maui.core.page.Page;
import org.testmonkeys.maui.pageobjects.AbstractPage;
import org.testmonkeys.maui.pageobjects.ElementAccessor;
import org.testmonkeys.maui.pageobjects.PageAccessor;
import org.testmonkeys.maui.pageobjects.elements.GenericWebElement;
import org.testmonkeys.maui.pageobjects.elements.Input;

@PageAccessor(name="HtmlElements",url = "")
public class HtmlElementsPageObject extends AbstractPage {

    @ElementAccessor(elementName = "header", byXPath = "//h1")
    private GenericWebElement header;

    @ElementAccessor(elementName="input",byId = "name_3_firstname")
    private Input firstName;

    @ElementAccessor(elementName="input2",byXPath = "//div[@id='attributesTest']/input[1]")
    private Input firstName2;

    @ElementAccessor(elementName = "element3", byId="styled_input")
    private Input styledInput;

    public Input firstName(){
        return firstName;
    }

    public Input firstName2(){
        return firstName2;
    }

    public Input styledInput(){
        return styledInput;
    }

    public GenericWebElement header() {
        return header;
    }
}
