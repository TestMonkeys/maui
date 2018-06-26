package org.testmonkeys.maui.core.factory;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.testmonkeys.maui.core.page.Page;
import org.testmonkeys.maui.pageobjects.PageAccessor;

import org.testmonkeys.maui.pageobjects.ElementAccessor;
import org.testmonkeys.maui.pageobjects.elements.AbstractComponent;


import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.testmonkeys.maui.core.utils.ReflectionUtils.extractFieldsByPredicate;

public class PageScanner {

    private String pagesPackage;

    public PageScanner(String pagesPackage) {
        this.pagesPackage = pagesPackage;
    }

    private Predicate<Class<?>> isPageWithName(String name) {
        return clazz -> clazz.getDeclaredAnnotation(PageAccessor.class).name().equals(name);
    }

    private Predicate<Field> isElement() {
        return field -> field.getType().getSuperclass().equals(AbstractComponent.class);
    }

    private Supplier pageWithNameNotFound(String name) {
        return () -> new RuntimeException("Could not find page with name [" + name + "]");
    }

    public Class<? extends Page> getPageByName(final String name) {
        ConfigurationBuilder builder = new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage(this.pagesPackage))
                .setScanners(new TypeAnnotationsScanner(), new SubTypesScanner());
        Reflections reflections = new Reflections(builder);
        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(PageAccessor.class);
        Optional<Class<?>> first = typesAnnotatedWith.stream().filter(isPageWithName(name)).findFirst();
        return first.orElseThrow(pageWithNameNotFound(name));
    }

    public <T extends AbstractComponent> T findPageElementByName(Page page, String name) {
        try {
            List<Field> fields = extractFieldsByPredicate(page.getClass(), isElement());
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getAnnotation(ElementAccessor.class).elementName().equalsIgnoreCase(name))
                    return (T) field.get(page);
            }
            return null;
        }catch (IllegalAccessException e) {
            throw new RuntimeException("Exception during parsing page " + page.getClass().getSimpleName(),e);
        }
    }
}
