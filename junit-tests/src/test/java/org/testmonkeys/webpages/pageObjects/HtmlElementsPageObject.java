package org.testmonkeys.webpages.pageObjects;

import org.testmonkeys.koshmar.core.page.Page;
import org.testmonkeys.koshmar.pageobjects.AbstractPage;
import org.testmonkeys.koshmar.pageobjects.ElementAccessor;
import org.testmonkeys.koshmar.pageobjects.PageAccessor;
import org.testmonkeys.koshmar.pageobjects.elements.Input;

@PageAccessor(name="HtmlElements",url = "")
public class HtmlElementsPageObject extends AbstractPage {

    @ElementAccessor(elementName="input",byId = "name_3_firstname")
    private Input firstName;

    @ElementAccessor(elementName="input2",byXPath = "//div[@id='attributesTest']/input[2]")
    private Input firstName2;

    public Input firstName(){
        return firstName;
    }

    public Input firstName2(){
        return firstName2;
    }
}
