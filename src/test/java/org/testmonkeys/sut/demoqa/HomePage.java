package org.testmonkeys.sut.demoqa;

import org.testmonkeys.maui.pageobjects.AbstractPage;
import org.testmonkeys.maui.pageobjects.ElementAccessor;
import org.testmonkeys.maui.pageobjects.PageAccessor;
import org.testmonkeys.maui.pageobjects.elements.Button;
import org.testmonkeys.maui.pageobjects.elements.GroupComponent;

@PageAccessor(name = "Home Page", url="/")
public class HomePage extends AbstractPage {

    @ElementAccessor(elementName="Interactions", byXPath = "//ul[@id='menu-interactions']/li")
    private GroupComponent<Button> interactions;


    public GroupComponent<Button> getInteractions() {
        return interactions;
    }
}
