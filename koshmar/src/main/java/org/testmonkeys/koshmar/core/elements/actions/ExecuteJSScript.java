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
    private Object[] args;

    public ExecuteJSScript(AbstractComponent component, String script, Object... args) {
        super(component);

        this.args = args;
        this.script = createExecutableScript(script, args);
    }

    private String createExecutableScript(String script, Object[] args) {
        StringBuilder arguments = new StringBuilder();
        for (int i = 0; i <= args.length; i++) {
            arguments.append("arguments[").append(i).append("]");
            if (i < args.length)
                arguments.append(",");
        }
        return getScript(script) + "\nreturn fun(" + arguments + ");";
    }

    @Override
    protected Object executeAction(WebElement webElement) {
        WebDriver webDriver = component.getBrowser().getDriver();
        JavascriptExecutor jsExecutor;
        if (webDriver instanceof JavascriptExecutor)
            jsExecutor = (JavascriptExecutor) webDriver;
        else
            throw new RuntimeException("Browser can't execute java script");

        return jsExecutor.executeScript(script, aggregateArgs(webElement));
    }

    private Object[] aggregateArgs(WebElement webElement) {
        Object[] aggregatedArgs = new Object[args.length + 1];
        aggregatedArgs[0] = webElement;
        System.arraycopy(args, 0, aggregatedArgs, 1, args.length);
        return aggregatedArgs;
    }

    private String getScript(String fileName) {
        StringBuilder result = new StringBuilder("");

        InputStream in = getClass().getResourceAsStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        try {
            while ((line = reader.readLine()) != null)
                result.append(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();

    }
}
