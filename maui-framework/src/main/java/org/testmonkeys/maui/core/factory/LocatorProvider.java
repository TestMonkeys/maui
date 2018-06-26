package org.testmonkeys.maui.core.factory;

import org.testmonkeys.maui.core.elements.location.Locator;
import org.testmonkeys.maui.core.elements.location.LocatorType;
import org.testmonkeys.maui.pageobjects.ElementAccessor;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by cpascal on 3/28/2017.
 */
public class LocatorProvider {

    public Locator getLocatorFromAnnotation(ElementAccessor annotation) {
        Map<LocatorType, String> values = new HashMap<>();
        values.put(LocatorType.ClassName, annotation.byClassName());
        values.put(LocatorType.CssSelector, annotation.byCssSelector());
        values.put(LocatorType.Id, annotation.byId());
        values.put(LocatorType.LinkText, annotation.byLinkText());
        values.put(LocatorType.Name, annotation.byName());
        values.put(LocatorType.PartialLinkText, annotation.byPartialLinkText());
        values.put(LocatorType.TagName, annotation.byTagName());
        values.put(LocatorType.XPath, annotation.byXPath());

        Map<LocatorType, String> filteredValues = values.entrySet().stream().filter(entry -> !entry.getValue().isEmpty())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        if (filteredValues.isEmpty())
            try {
                throw new Exception("no locator defined");
            } catch (Exception e) {
                e.printStackTrace();
                //TODO: do something with the error
            }

        Map.Entry<LocatorType, String> actualEntry = filteredValues.entrySet().stream().findFirst().get();
        return new Locator(actualEntry.getKey(), actualEntry.getValue());
    }
}
