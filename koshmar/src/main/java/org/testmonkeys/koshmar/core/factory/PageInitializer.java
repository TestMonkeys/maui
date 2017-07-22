package org.testmonkeys.koshmar.core.factory;

import org.testmonkeys.koshmar.core.elements.location.LocatesElements;
import org.testmonkeys.koshmar.core.browser.Browser;
import org.testmonkeys.koshmar.core.elements.Component;
import org.testmonkeys.koshmar.core.elements.location.Locator;
import org.testmonkeys.koshmar.core.utils.ReflectionUtils;
import org.testmonkeys.koshmar.core.elements.Module;
import org.testmonkeys.koshmar.pageobjects.ElementAccessor;
import org.testmonkeys.koshmar.pageobjects.elements.GroupComponent;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by cpascal on 3/29/2017.
 */
public class PageInitializer {

    private final LocatorProvider locatorProvider;
    private final ReflectionUtils reflectionUtils;

    public PageInitializer() {
        locatorProvider = new LocatorProvider();
        reflectionUtils = new ReflectionUtils();
    }

    public <T extends LocatesElements> void createPageContent(Browser browser, T parent) {
        List<Field> elements = reflectionUtils.extractFieldsByPredicate(parent.getClass(), isComponent());

        for (Field field : elements) {
            Component component = createComponent(browser, field, parent);
            setFieldValue(field, parent, component);
        }
    }

    private Component createComponent(Browser browser, Field field, LocatesElements parent) {
        ElementAccessor annotation = field.getAnnotation(ElementAccessor.class);

        Class<? extends Component> elementType = (Class<? extends Component>) field.getType();


        Component component = reflectionUtils.instantiate(elementType);
        component.setBrowser(browser);
        component.setLocator(locatorProvider.getLocatorFromAnnotation(annotation));
        component.setParent(parent);
        component.setName(annotation.elementName());

        Type genericType =  field.getGenericType();

        if (genericType!=null && GroupComponent.class.equals(elementType)){
            Type[] params=((ParameterizedType)genericType).getActualTypeArguments();
            if (params.length!=0) {
                Type genericParam = params[0];
                ((GroupComponent) component).setItemType(genericParam);
            }
        }

        if (component instanceof Module)
            createPageContent(browser, component);

        return component;
    }

    public Component createComponent(Browser browser, Class<? extends Component> elementType, LocatesElements parent, Locator locator, String elementName) {
        Component component = reflectionUtils.instantiate(elementType);
        component.setBrowser(browser);
        component.setLocator(locator);
        component.setParent(parent);
        component.setName(elementName);

        if (component instanceof Module)
            createPageContent(browser, component);

        return component;
    }

    private Predicate<Field> isComponent() {
        return field -> Component.class.isAssignableFrom(field.getType());
    }

    private void setFieldValue(Field field, Object container, Object value) {
        field.setAccessible(true);
        try {
            field.set(container, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
