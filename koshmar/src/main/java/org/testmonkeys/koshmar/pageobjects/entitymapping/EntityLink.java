package org.testmonkeys.koshmar.pageobjects.entitymapping;

import org.testmonkeys.koshmar.pageobjects.elements.Input;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class EntityLink {

    private Map<PropertyDescriptor, Method> mapping = new HashMap<>();

    public void addMapping(PropertyDescriptor propertyDescriptor, Method method) {
        mapping.put(propertyDescriptor, method);
    }

    public void fillPage(Object entity, Object page) {
        for (PropertyDescriptor propertyDescriptor : mapping.keySet()) {
            String entityValue = null;
            try {
                entityValue = propertyDescriptor.getReadMethod().invoke(entity).toString();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            Method method = mapping.get(propertyDescriptor);
            Input input = null;
            try {
                input = (Input) method.invoke(page);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            if (input != null)
                input.type(entityValue);
        }
    }
}
