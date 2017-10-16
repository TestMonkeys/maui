package org.testmonkeys.koshmar.pageobjects;

import org.testmonkeys.koshmar.pageobjects.entitymapping.EntityInspector;
import org.testmonkeys.koshmar.pageobjects.entitymapping.EntityLink;
import org.testmonkeys.koshmar.pageobjects.entitymapping.MapsToField;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractEntityPage extends AbstractPage {

    public void fillEntity(Object entity) {
        EntityLink inspector = EntityInspector.getInstance().inspectLink(entity, this);
        inspector.fillPage(entity, this);
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
