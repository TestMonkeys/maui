package org.testmonkeys.maui.core.utils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReflectionUtils {

    public List<Field> extractFieldsByPredicate(Class<?> type, Predicate<Field> predicate) {
        List<Field> fields = Arrays.asList(getAllFields(type));
        return fields.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    private Field[] getAllFields(Class<?> clazz) {
        List<Class<?>> classes = getAllSuperclasses(clazz);
        classes.add(clazz);
        return getAllFields(classes);
    }

    private Field[] getAllFields(List<Class<?>> classes) {
        Set<Field> fields = new HashSet<>();

        classes.forEach(c -> fields.addAll(Arrays.asList(c.getDeclaredFields())));

        return fields.toArray(new Field[fields.size()]);
    }

    private List<Class<?>> getAllSuperclasses(Class<?> clazz) {
        ArrayList<Class<?>> classes = new ArrayList<>();

        Class<?> superclass = clazz.getSuperclass();
        while (superclass != null) {
            classes.add(superclass);
            superclass = superclass.getSuperclass();
        }
        return classes;
    }

    public <T> T instantiate(Class<T> type) {
        try {
            return type.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
