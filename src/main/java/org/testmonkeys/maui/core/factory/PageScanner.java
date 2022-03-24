package org.testmonkeys.maui.core.factory;

import org.reflections.ReflectionUtils;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.testmonkeys.maui.core.elements.location.LocatesElements;
import org.testmonkeys.maui.core.page.Page;
import org.testmonkeys.maui.pageobjects.ElementAccessor;
import org.testmonkeys.maui.pageobjects.PageAccessor;
import org.testmonkeys.maui.pageobjects.elements.AbstractComponent;
import org.testmonkeys.maui.pageobjects.modules.AbstractModule;

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

    private Predicate<Field> isComponent() {
        return field -> ReflectionUtils.getAllSuperTypes(field.getType()).contains(AbstractComponent.class);
    }

    private Predicate<Field> isModule() {
        return field -> ReflectionUtils.getAllSuperTypes(field.getType()).contains(AbstractModule.class);
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
        T result = findPageElementByName((LocatesElements) page, name);
        if (result == null)
            throw new RuntimeException("Could not find element with name '" + name + "' on page " + page.getClass().getSimpleName());
        return result;
    }

    private <T extends AbstractComponent> T findPageElementByName(LocatesElements page, String name) {
        try {
            List<Field> fields = extractFieldsByPredicate(page.getClass(), isComponent());
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getAnnotation(ElementAccessor.class).elementName().equalsIgnoreCase(name))
                    return (T) field.get(page);
                if (isModule().test(field)) {
                    T t = findPageElementByName((T) field.get(page), name);
                    if (t != null)
                        return t;
                }
            }
            return null;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Exception during parsing page " + page.getClass().getSimpleName(), e);
        }

    }
}
