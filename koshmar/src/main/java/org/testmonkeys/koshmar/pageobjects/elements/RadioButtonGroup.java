package org.testmonkeys.koshmar.pageobjects.elements;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RadioButtonGroup extends AbstractComponent {

    public List<String> getValues(){
        List<WebElement> options=findAll();
        List<String> values = new ArrayList<>();
        for (WebElement element: options)
            values.add(element.getAttribute("value"));
        return values;
    }

    public void selectByValue(String value){
        Optional<WebElement> option =findAll().stream().filter(o->value.equals(o.getAttribute("value"))).findFirst();
        if (option.isPresent())
            option.get().click();
    }

    public void selectByIndex(int index){
        List<WebElement> options=findAll();
        if (options.size()-1<index)
            throw new RuntimeException("Could not find radio button by index");
        else
            options.get(index).click();
    }

    public String getSelectedValue(){
        List<WebElement> options=findAll();
        for (WebElement element:options)
            if (element.isSelected())
                return element.getAttribute("value");
        return "NONE";
    }

    public int getSelectedIndex(){
        List<WebElement> options=findAll();
        for (int i=0; i<options.size();i++)
            if (options.get(i).isSelected())
                return i;
        return -1;
    }
}
