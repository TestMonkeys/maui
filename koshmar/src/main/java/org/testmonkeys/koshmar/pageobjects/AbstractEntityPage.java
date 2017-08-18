package org.testmonkeys.koshmar.pageobjects;

import org.testmonkeys.koshmar.pageobjects.elements.Input;
import org.testmonkeys.koshmar.pageobjects.entitymapping.MapsToField;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractEntityPage extends AbstractPage {

    public void fillEntity(Object entity) {
        BeanInfo beanInfo = null;
        try {
            beanInfo = beanInfo = Introspector.getBeanInfo(this.getClass(), Object.class);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }

        for (PropertyDescriptor propertyDescriptor : beanInfo.getPropertyDescriptors()) {
            Field field = getField(this.getClass(), propertyDescriptor);
            //Field level processing
            if (field != null) {
                if (isMappable(field)) {
                    //getting field from entity that maps to this one.
                    String entityField = getEntityField(field);

                    if (field.getType() != Input.class)
                        throw new RuntimeException("can't fill anything except inputs for now.");
                    try {
                        Input input = (Input) propertyDescriptor.getReadMethod().invoke(this);
                        input.type(getFieldValueFromEntity(entityField, entity));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

                }
            }
        }

    }

    private String getFieldValueFromEntity(String entityField, Object entity) throws InvocationTargetException, IllegalAccessException {
        BeanInfo beanInfo = null;
        try {
            beanInfo = beanInfo = Introspector.getBeanInfo(entity.getClass(), Object.class);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }

        for (PropertyDescriptor propertyDescriptor : beanInfo.getPropertyDescriptors()) {
            if (propertyDescriptor.getName().equals(entityField)) {
                return propertyDescriptor.getReadMethod().invoke(entity).toString();
            }
        }
        return null;
    }

    private boolean isMappable(AnnotatedElement member) {
        List<Annotation> knownAnnotations = new ArrayList<>();
        for (Annotation candidate : member.getAnnotations()) {
            if (candidate instanceof MapsToField)
                return true;
        }
        return false;
    }

    private String getEntityField(AnnotatedElement member) {
        List<Annotation> knownAnnotations = new ArrayList<>();
        for (Annotation candidate : member.getAnnotations()) {
            if (candidate instanceof MapsToField)
                return ((MapsToField) candidate).value();
        }
        return null;
    }

    private Field getField(Class clazz, PropertyDescriptor propertyDescriptor) {
        Field field = null;
        try {
            field = clazz.getDeclaredField(propertyDescriptor.getName());
        } catch (NoSuchFieldException ignored) {
            //do nothing as this means that field was named differently than accessor methods
        }
        return field;
    }
}
