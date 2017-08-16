package org.testmonkeys.koshmar.core.elements.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testmonkeys.koshmar.pageobjects.elements.AbstractComponent;

import java.io.File;
import java.io.IOException;
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

        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();

    }
}
