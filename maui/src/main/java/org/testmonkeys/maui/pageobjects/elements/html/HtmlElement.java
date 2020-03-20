package org.testmonkeys.maui.pageobjects.elements.html;

import org.testmonkeys.maui.core.elements.actions.ExecuteJSScript;
import org.testmonkeys.maui.pageobjects.elements.AbstractComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.testmonkeys.maui.pageobjects.elements.html.JsScripts.*;

/**
 * HtmlElement provides access to functionality available for any Element present in DOM
 */
public class HtmlElement {


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
        Object result = new ExecuteJSScript(component, GET_ATTRIBUTE).execute();

        List<HtmlAttribute> attributes = new ArrayList<>();
        try {
            Map<String, Map<String, String>> elementAttributes = (Map<String, Map<String, String>>) result;
            for (Map<String, String> elementAttribute : elementAttributes.values()) {
                attributes.add(getAttribute(elementAttribute));
            }
        } catch (Exception e) {
            throw new JSInteractionException("Could not parse annotations", e);
        }
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
     * Gets html attribute value for this element
     *
     * @param attributeName name of the attribute to be retrieved
     * @return String value of attribute
     */
    public String getAttribute(String attributeName) {
        return component.find().getAttribute(attributeName);
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
        Object jsResult = new ExecuteJSScript(component, GET_COMPUTED_STYLE).execute();

        Map<String, String> result;
        try {
            result = (Map<String, String>) jsResult;
        } catch (ClassCastException e) {
            throw new JSInteractionException("Could not parse style object", e);
        }
        return result;
    }

    /**
     * Gets the style value by a specific key
     *
     * @param key to get style for
     * @return string value representing the style or null if key not found
     */
    public String getStyle(String key) {
        Map<String, String> styles = getStyle();
        if (!styles.containsKey(key))
            return null;
        return styles.get(key);
    }

    /**
     * Gets the innerHTML property of the element
     *
     * @return string value of the innerHTML
     */
    public String getInnerHtml() {
        Object jsResult = new ExecuteJSScript(component, GET_INNER_HTML).execute();
        return (String) jsResult;
    }

    /**
     * Sets the innerHTML property of the element
     *
     * @param value - new value of the innerHTML
     */
    public void setInnerHtml(String value) {
        new ExecuteJSScript(component, SET_INNER_HTML, value).execute();
    }

    /**
     * Gets the outerHTML property of the element
     *
     * @return string value of the outerHTML
     */
    public String getOuterHtml() {
        Object jsResult = new ExecuteJSScript(component, GET_OUTER_HTML).execute();
        return (String) jsResult;
    }

    /**
     * Sets the outerHTML property of the element
     *
     * @param value - new value of the outerHTML
     */
    public void setOuterHtml(String value) {
        new ExecuteJSScript(component, SET_OUTER_HTML, value).execute();
    }

    /**
     * Gets the Tag Name of the element
     *
     * @return string - name of the tag
     */
    public String getTagName() {
        Object jsResult = new ExecuteJSScript(component, GET_TAG_NAME).execute();
        return (String) jsResult;
    }

    /**
     * Gets the Hidden property of the element
     *
     * @return true if element is hidden
     */
    public boolean getHidden() {
        Object jsResult = new ExecuteJSScript(component, GET_TAG_HIDDEN).execute();
        return (boolean) jsResult;
    }

    /**
     * Sets the Hidden property of the element
     *
     * @param value - boolean value
     */
    public void setHidden(boolean value) {
        new ExecuteJSScript(component, SET_TAG_HIDDEN, value).execute();
    }

    /**
     * Gets the Tab Index of the element
     *
     * @return int index or -1 if element does not have a Tab Index
     */
    public int getTabIndex() {
        Object jsResult = new ExecuteJSScript(component, GET_TAB_INDEX).execute();
        return (int) ((long) jsResult);
    }

    /**
     * Sets the Tab Index of the element
     *
     * @param value - int index
     */
    public void setTabIndex(int value) {
        new ExecuteJSScript(component, SET_TAB_INDEX, value).execute();
    }

    /**
     * Gets the Title property of the element, also known as hint text
     *
     * @return string title
     */
    public String getTitle() {
        Object jsResult = new ExecuteJSScript(component, GET_TITLE).execute();
        return (String) jsResult;
    }

    /**
     * Sets the Title property of the element, also known as hint text
     *
     * @param value - string title
     */
    public void setTitle(String value) {
        new ExecuteJSScript(component, SET_TITLE, value).execute();
    }

    /**
     * Gets the Draggable property of the element
     *
     * @return boolean true if draggable
     */
    public boolean getDraggable() {
        Object jsResult = new ExecuteJSScript(component, GET_DRAGGABLE).execute();
        return (boolean) jsResult;
    }

    /**
     * Sets the Draggable property of the element
     *
     * @param value - boolean true to enable draggable
     */
    public void setDraggable(boolean value) {
        new ExecuteJSScript(component, SET_DRAGGABLE, value).execute();
    }
}
