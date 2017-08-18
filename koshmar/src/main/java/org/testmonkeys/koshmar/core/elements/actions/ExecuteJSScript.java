package org.testmonkeys.koshmar.core.elements.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testmonkeys.koshmar.pageobjects.elements.AbstractComponent;

import java.io.*;
import java.util.Scanner;

/**
 * Created by cpascal on 3/29/2017.
 */
public class ExecuteJSScript extends AbstractAction<Object> {

    private String script;

    public ExecuteJSScript(AbstractComponent component, String script) {
        super(component);
        this.script = getScript(script) + "\nreturn fun(arguments[0]);";
    }

    @Override
    protected Object executeAction(WebElement webElement) {
        WebDriver webDriver = component.getBrowser().getDriver();
        JavascriptExecutor jsExecutor;
        if (webDriver instanceof JavascriptExecutor)
            jsExecutor = (JavascriptExecutor) webDriver;
        else
            throw new RuntimeException("Browser can't execute java script");
        return jsExecutor.executeScript(script, webElement);
    }

    private String getScript(String fileName) {
        StringBuilder result = new StringBuilder("");

        InputStream in = getClass().getResourceAsStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line = null;
        try {
            while ((line = reader.readLine()) != null)
                result.append(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();

    }
}
