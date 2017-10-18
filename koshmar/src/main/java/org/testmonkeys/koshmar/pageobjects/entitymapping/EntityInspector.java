package org.testmonkeys.koshmar.pageobjects.entitymapping;

import org.testmonkeys.koshmar.pageobjects.AbstractPage;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EntityInspector {

    private static EntityInspector instance;

    private EntityInspector() {
    }

    public static synchronized EntityInspector getInstance() {
        if (instance == null)
            instance = new EntityInspector();
        return instance;
    }

    public EntityLink inspectLink(Type type, AbstractPage page) {
        return inspectLink(type.getClass(), page);
    }

    public EntityLink inspectLink(Class<?> entityClazz, AbstractPage page) {

        EntityLink link = new EntityLink();
        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(entityClazz, Object.class);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }

        Method[] pageMethods = page.getClass().getMethods();
        Map<String, Method> customLinkDictionary = new HashMap<>();
        for (Method method : pageMethods) {
            String fieldName = getCustomMapping(method, entityClazz);
            if (fieldName != null) {
                customLinkDictionary.put(fieldName, method);
            }
        }


        for (PropertyDescriptor propertyDescriptor : beanInfo.getPropertyDescriptors()) {

            //TODO: invert search, should be on page first
            String name = propertyDescriptor.getName();
            Method method;
            if (customLinkDictionary.containsKey(name))
                method = customLinkDictionary.get(name);
            else
                method = getPageElement(name, pageMethods);
            if (method != null)
                link.addMapping(propertyDescriptor, method);
        }
        return link;
    }

    private String getCustomMapping(AnnotatedElement member, Class clazz) {
        List<Annotation> knownAnnotations = new ArrayList<>();
        for (Annotation candidate : member.getAnnotations()) {
            if (candidate instanceof MapsToField)
                if (((MapsToField) candidate).clazz().equals(clazz))
                    return ((MapsToField) candidate).value();
        }
        return null;
    }

    private Method getPageElement(String name, Method[] methods) {
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase(name) ||
                    method.getName().equalsIgnoreCase("get" + name))
                return method;
        }
        return null;
    }

}
