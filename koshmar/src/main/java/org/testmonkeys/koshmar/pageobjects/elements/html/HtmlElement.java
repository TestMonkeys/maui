package org.testmonkeys.koshmar.pageobjects.elements.html;

import org.testmonkeys.koshmar.core.elements.actions.ExecuteJSScript;
import org.testmonkeys.koshmar.pageobjects.elements.AbstractComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * HtmlElement provides access to functionality available for any Element present in DOM
 */
public class HtmlElement {

    private final String GET_ATTRIBUTE_SCRIPT = "/javaScript/htmlElement/getAttributes.js";
    private final String GET_COMPUTED_STYLE_SCRIPT = "/javaScript/htmlElement/getComputedStyle.js";
    private AbstractComponent component;

    public HtmlElement(AbstractComponent component) {
        this.component = component;
    }

    /**
     * Gets all attributes declared on this DOM element with their values.
     *
     * @return List of HtmlAttribute
     */
    public List<HtmlAttribute> getAttributes() {
        Object result = new ExecuteJSScript(component, GET_ATTRIBUTE_SCRIPT).execute();

        List<HtmlAttribute> attributes = new ArrayList<>();
        try {
            ArrayList<Map<String, String>> elementAttributes = (ArrayList<Map<String, String>>) result;
            for (Map<String, String> elementAttribute : elementAttributes) {
                attributes.add(getAttribute(elementAttribute));
            }
        } catch (Exception e) {
            throw new JSInteractionException("Could not parse annotations", e);
        }

        return attributes;
    }

    /**
     * Parses the HashMap of each attribute and builds an the HtmlAttribute model
     *
     * @param attributeDetails hash map of attribute properties
     * @return HtmlAttribute
     */
    private HtmlAttribute getAttribute(Map<String, String> attributeDetails) {
        HtmlAttribute attribute = new HtmlAttribute();
        if (attributeDetails.containsKey("name")) {
            attribute.setName(attributeDetails.get("name"));
        } else {
            throw new JSInteractionException("Could not understand the attribute list");
        }

        if (attributeDetails.containsKey("value")) {
            attribute.setValue(attributeDetails.get("value"));
        }

        return attribute;
    }

    /**
     * Gets the computed style of the element. This will include both the style declared on the element
     * as well as any generic style that was applied to it.
     *
     * @return Map of style-name to style-value pairs
     */
    public Map<String, String> getStyle() {
        Object jsResult = new ExecuteJSScript(component, GET_COMPUTED_STYLE_SCRIPT).execute();

        Map<String, String> result;
        try {
            result = (Map<String, String>) jsResult;
        } catch (ClassCastException e) {
            throw new JSInteractionException("Could not parse style object", e);
        }
        return result;
    }


}
