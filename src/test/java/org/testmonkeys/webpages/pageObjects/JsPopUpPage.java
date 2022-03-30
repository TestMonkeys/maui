package org.testmonkeys.webpages.pageObjects;

import org.testmonkeys.maui.pageobjects.AbstractPage;
import org.testmonkeys.maui.pageobjects.ElementAccessor;
import org.testmonkeys.maui.pageobjects.PageAccessor;
import org.testmonkeys.maui.pageobjects.elements.Button;
import org.testmonkeys.maui.pageobjects.elements.Input;

@PageAccessor(name="JsPopUpPage",url="")
public class JsPopUpPage extends AbstractPage {

    @ElementAccessor(elementName = "alert", byId = "alertButton")
    private Button alertBtn;

    @ElementAccessor(elementName = "confirmation", byId = "confirmationButton")
    private Button confirmationBtn;

    @ElementAccessor(elementName = "prompt", byId = "promptButton")
    private Button promptBtn;

    @ElementAccessor(elementName = "prompt", byId = "confirmationText")
    private Input confirmationTxt;

    @ElementAccessor(elementName = "prompt", byId = "promptText")
    private Input promptTxt;

    public Button alertBtn() {
        return alertBtn;
    }

    public Button confirmationBtn() {
        return confirmationBtn;
    }

    public Button promptBtn() {
        return promptBtn;
    }

    public Input confirmationTxt() {
        return confirmationTxt;
    }

    public Input promptTxt() {
        return promptTxt;
    }
}
