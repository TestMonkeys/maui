package org.testmonkeys.koshmar.pageobjects.elements;

import org.openqa.selenium.WebElement;
import org.testmonkeys.koshmar.core.elements.location.Locator;
import org.testmonkeys.koshmar.core.factory.PageInitializer;
import org.testmonkeys.koshmar.core.elements.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by cpascal on 3/30/2017.
 */
public class GroupComponent<T extends AbstractComponent> extends AbstractComponent {

    private Type type;
    private PageInitializer pageInitializer;

    public GroupComponent(){
        pageInitializer=new PageInitializer();
    }

    @Override
    public WebElement findElement(Locator locator){
        return findElements(this.getLocator()).get(locator.getPosition());

    }

    public T get(int position){
        Locator itemLocator = new Locator(getLocator().getLocatorType(),getLocator().getLocatorValue());
        itemLocator.setPosition(position);
        T t= (T) (
        pageInitializer.createComponent(getBrowser(), (Class<? extends Component>) type,this,itemLocator,this.getName()+"["+position+"]"));
        return t;
    }

    public List<T> getAll(){
        List<WebElement> elements=getParent().findElements(getLocator());
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
