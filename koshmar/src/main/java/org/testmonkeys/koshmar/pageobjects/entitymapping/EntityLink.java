package org.testmonkeys.koshmar.pageobjects.entitymapping;

import org.testmonkeys.koshmar.pageobjects.elements.FillableComponent;
import org.testmonkeys.koshmar.pageobjects.elements.Input;
import org.testmonkeys.koshmar.pageobjects.elements.ReadableComponent;

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
            Object entityValue = null;
            try {
                entityValue = propertyDescriptor.getReadMethod().invoke(entity);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            Method method = mapping.get(propertyDescriptor);
            FillableComponent input = null;
            try {
                input = (FillableComponent) method.invoke(page);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            if (input != null)
                input.fill(entityValue);
        }
    }

    public <T extends Object> T read(Class<T> clazz, Object page) {
        T ret = null;
        try {
            ret = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        for (PropertyDescriptor propertyDescriptor : mapping.keySet()) {
            Method method = mapping.get(propertyDescriptor);
            ReadableComponent input = null;
            try {
                input = (ReadableComponent) method.invoke(page);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            try {
                propertyDescriptor.getWriteMethod().invoke(ret, input.read());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }
}
