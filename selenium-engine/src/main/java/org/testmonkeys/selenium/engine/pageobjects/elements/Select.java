package org.testmonkeys.selenium.engine.pageobjects.elements;

import org.testmonkeys.selenium.engine.core.elements.actions.select.SelectByIndexAction;
import org.testmonkeys.selenium.engine.core.elements.actions.select.SelectByValueAction;
import org.testmonkeys.selenium.engine.core.elements.actions.select.SelectByVisibleTextAction;

/**
 * Created by cpascal on 3/31/2017.
 */
public class Select extends AbstractComponent {

    public void selectByValue(String value){
        new SelectByValueAction(this,value).execute();
    }

    public void selectByText(String value){
        new SelectByVisibleTextAction(this,value).execute();
    }

    public void selectByIndext(int index){
        new SelectByIndexAction(this,index).execute();
    }

}
