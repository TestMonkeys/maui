package org.testmonkeys.koshmar.pageobjects.elements.html;

import org.testmonkeys.koshmar.core.elements.actions.ExecuteJSAction;
import org.testmonkeys.koshmar.pageobjects.elements.AbstractComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * HtmlElement provides access to functionality available for any Element present in DOM
 */
public class HtmlElement {

    private AbstractComponent component;

    public HtmlElement(AbstractComponent component){
        this.component = component;
    }

    /**
     * Gets all attributes declared on this DOM element with their values.
     *
     * @return List of {@link=HtmlAttribute}
     */
    public List<HtmlAttribute> getAttributes() {
        Object result = new ExecuteJSAction(component, "return arguments[0].attributes;").execute();


        List<HtmlAttribute> attributes = new ArrayList<>();
        try {
            ArrayList<Map<String, String>> elementAttributes = (ArrayList<Map<String, String>>) result;
            for (Map<String, String> elementAttribute : elementAttributes) {
                HtmlAttribute attribute = new HtmlAttribute();
                if (elementAttribute.containsKey("name")) {
                    attribute.setName(elementAttribute.get("name"));
                }
                if (elementAttribute.containsKey("value")) {
                    attribute.setValue(elementAttribute.get("value"));
                }
                attributes.add(attribute);
            }
        }catch (Exception e){
            //TODO: log error
        }

        return attributes;
    }

}
