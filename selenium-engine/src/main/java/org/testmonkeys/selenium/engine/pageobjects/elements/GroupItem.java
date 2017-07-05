package org.testmonkeys.selenium.engine.pageobjects.elements;

import org.openqa.selenium.WebElement;
import org.testmonkeys.selenium.engine.core.elements.Module;

/**
 * Created by cpascal on 3/30/2017.
 */
public class GroupItem extends AbstractComponent implements Module {

    private int position;
    private WebElement webElement;

    void setWebElement(WebElement webElement){
        this.webElement=webElement;
    }

    public void setPosition(int position){
        this.position=position;
    }

    public int getPosition(){
        return position;
    }

    @Override
    public WebElement find(){
        if (isAlive(webElement))
            return webElement;
        if (getParent() instanceof GroupComponent)
            return ((GroupComponent)getParent()).find(position);
        else throw new RuntimeException("Group item should be a child of GroupComponent");
    }


}
