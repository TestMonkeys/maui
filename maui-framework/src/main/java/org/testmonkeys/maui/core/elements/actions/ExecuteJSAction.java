package org.testmonkeys.maui.core.elements.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testmonkeys.maui.pageobjects.elements.AbstractComponent;

/**
 * Created by cpascal on 3/29/2017.
 */
public class ExecuteJSAction extends AbstractAction<Object> {

    private String script;

    public ExecuteJSAction(AbstractComponent component, String script) {
        super(component);
        this.script = script;
    }

    @Override
    protected Object executeAction(WebElement webElement){
        WebDriver webDriver=component.getBrowser().getDriver();
        JavascriptExecutor jsExecutor;
        if (webDriver instanceof JavascriptExecutor)
            jsExecutor=(JavascriptExecutor)webDriver;
        else
            throw new RuntimeException("Browser can't execute java script");
        return jsExecutor.executeScript(script,webElement);
    }
}
