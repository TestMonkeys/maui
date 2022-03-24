package org.testmonkeys.webpages.pageObjects;

import org.testmonkeys.maui.pageobjects.ElementAccessor;
import org.testmonkeys.maui.pageobjects.elements.Input;
import org.testmonkeys.maui.pageobjects.modules.AbstractModule;

public class TestModule extends AbstractModule {

    @ElementAccessor(elementName = "inside module", byXPath = ".//input[1]")
    private Input firstName2;
}
