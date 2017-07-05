package org.testmonkeys.selenium.engine.pageobjects.elements;

import org.openqa.selenium.WebElement;
import org.testmonkeys.selenium.engine.core.elements.Component;
import org.testmonkeys.selenium.engine.core.elements.location.Locator;
import org.testmonkeys.selenium.engine.core.factory.PageInitializer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by cpascal on 3/30/2017.
 */
public class GroupComponent<T extends GroupItem> extends AbstractComponent {

    private Type type;
    private PageInitializer pageInitializer;

    public GroupComponent(){
        pageInitializer=new PageInitializer();
    }


    public WebElement find(int position){
        return findElements(this.getLocator()).get(position);

    }

    public T get(int position){
        T t= (T) (
        pageInitializer.createComponent(getBrowser(), (Class<? extends Component>) type,this,this.getLocator(),this.getName()+"["+position+"]"));
        t.setPosition(position);
        return t;
    }

    public List<T> getAll(){
        List<WebElement> elements=this.findElements(getLocator());
        List<T> itemList=new ArrayList<>();
        for (int i=0;i<elements.size();i++){
            T item = get(i);
            item.setWebElement(elements.get(i));
            itemList.add(item);
        }
        return itemList;
    }

    public int size(){
        List<WebElement> elements=this.findElements(getLocator());
        return elements.size();
    }

    public void setItemType(Type itemType) {
        this.type = itemType;
    }
}
