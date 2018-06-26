package org.testmonkeys.maui.pageobjects.elements.html;

/**
 * HtmlAttribute is the model of a Element attribute in DOM.
 */
public class HtmlAttribute {
    private String name;
    private String value;

    public HtmlAttribute(){}

    public HtmlAttribute(String name, String value){
        this.name=name;
        this.value=value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return "Name: "+name+"; value: "+value+";";
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof HtmlAttribute))
            return false;
        HtmlAttribute obj=(HtmlAttribute)o;
        return obj.getName().equals(name) &&obj.getValue().equals(value);
    }
}
