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
    private final String GET_INNER_HTML_SCRIPT = "/javaScript/htmlElement/getInnerHtml.js";
    private final String SET_INNER_HTML_SCRIPT = "/javaScript/htmlElement/setInnerHtml.js";
    private final String GET_OUTER_HTML_SCRIPT = "/javaScript/htmlElement/getOuterHtml.js";
    private final String SET_OUTER_HTML_SCRIPT = "/javaScript/htmlElement/setOuterHtml.js";
    private final String GET_TAG_NAME_SCRIPT = "/javaScript/htmlElement/getTagName.js";
    private final String GET_TAG_HIDDEN_SCRIPT = "/javaScript/htmlElement/getHidden.js";
    private final String SET_TAG_HIDDEN_SCRIPT = "/javaScript/htmlElement/setHidden.js";
    private final String GET_TAB_INDEX_SCRIPT = "/javaScript/htmlElement/getTabIndex.js";
    private final String SET_TAB_INDEX_SCRIPT = "/javaScript/htmlElement/setTabIndex.js";
    private final String GET_TITLE_SCRIPT = "/javaScript/htmlElement/getTitle.js";
    private final String SET_TITLE_SCRIPT = "/javaScript/htmlElement/setTitle.js";

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

    /**
     * Gets the innerHTML property of the element
     *
     * @return string value of the innerHTML
     */
    public String getInnerHtml() {
        Object jsResult = new ExecuteJSScript(component, GET_INNER_HTML_SCRIPT).execute();
        return (String) jsResult;
    }

    /**
     * Sets the innerHTML property of the element
     *
     * @param value - new value of the innerHTML
     */
    public void setInnerHtml(String value) {
        new ExecuteJSScript(component, SET_INNER_HTML_SCRIPT, value).execute();
    }

    /**
     * Gets the outerHTML property of the element
     *
     * @return string value of the outerHTML
     */
    public String getOuterHtml() {
        Object jsResult = new ExecuteJSScript(component, GET_OUTER_HTML_SCRIPT).execute();
        return (String) jsResult;
    }

    /**
     * Sets the outerHTML property of the element
     *
     * @param value - new value of the outerHTML
     */
    public void setOuterHtml(String value) {
        new ExecuteJSScript(component, SET_OUTER_HTML_SCRIPT, value).execute();
    }

    /**
     * Gets the Tag Name of the element
     *
     * @return string - name of the tag
     */
    public String getTagName() {
        Object jsResult = new ExecuteJSScript(component, GET_TAG_NAME_SCRIPT).execute();
        return (String) jsResult;
    }

    /**
     * Gets the Hidden property of the element
     *
     * @return true if element is hidden
     */
    public boolean getHidden() {
        Object jsResult = new ExecuteJSScript(component, GET_TAG_HIDDEN_SCRIPT).execute();
        return (boolean) jsResult;
    }

    /**
     * Sets the Hidden property of the element
     *
     * @param value - boolean value
     */
    public void setHidden(boolean value) {
        new ExecuteJSScript(component, SET_TAG_HIDDEN_SCRIPT, value).execute();
    }

    /**
     * Gets the Tab Index of the element
     *
     * @return int index or -1 if element does not have a Tab Index
     */
    public int getTabIndex() {
        Object jsResult = new ExecuteJSScript(component, GET_TAB_INDEX_SCRIPT).execute();
        return (int) ((long) jsResult);
    }

    /**
     * Sets the Tab Index of the element
     *
     * @param value - int index
     */
    public void setTabIndex(int value) {
        new ExecuteJSScript(component, SET_TAB_INDEX_SCRIPT, value).execute();
    }

    /**
     * Gets the Title property of the element, also known as hint text
     *
     * @return string title
     */
    public String getTitle() {
        Object jsResult = new ExecuteJSScript(component, GET_TITLE_SCRIPT).execute();
        return (String) jsResult;
    }

    /**
     * Sets the Title property of the element, also known as hint text
     *
     * @param value - string title
     */
    public void setTitle(String value) {
        new ExecuteJSScript(component, SET_TITLE_SCRIPT, value).execute();
    }
}
