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

    public List<HtmlAttribute> getAttributes(){
        Object result = new ExecuteJSAction(component,"return arguments[0].attributes;").execute();
        List<HtmlAttribute> attributes = new ArrayList<>();
        if (result instanceof ArrayList){
            ArrayList<Map<String,String>> htmlAttributes=(ArrayList<Map<String,String>>)result;
            for(Map<String,String> htlmAttribute : htmlAttributes){
                HtmlAttribute attribute = new HtmlAttribute();
                if (htlmAttribute.containsKey("name")){
                    attribute.setName(htlmAttribute.get("name"));
                }
                if (htlmAttribute.containsKey("value")){
                    attribute.setValue(htlmAttribute.get("value"));
                }
                attributes.add(attribute);
            }
        }

        return attributes;
    }
}
