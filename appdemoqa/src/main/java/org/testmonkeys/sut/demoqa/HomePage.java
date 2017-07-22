package org.testmonkeys.sut.demoqa;

import org.testmonkeys.koshmar.pageobjects.AbstractPage;
import org.testmonkeys.koshmar.pageobjects.ElementAccessor;
import org.testmonkeys.koshmar.pageobjects.PageAccessor;
import org.testmonkeys.koshmar.pageobjects.elements.Button;
import org.testmonkeys.koshmar.pageobjects.elements.GroupComponent;

import java.awt.*;

@PageAccessor(name = "Home Page", url="/")
public class HomePage extends AbstractPage {

    @ElementAccessor(elementName="Interactions", byXPath = "//ul[@id='menu-interactions']/li")
    private GroupComponent<Button> interactions;


    public GroupComponent<Button> getInteractions() {
        return interactions;
    }
}
