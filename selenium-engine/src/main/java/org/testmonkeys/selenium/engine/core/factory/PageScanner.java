package org.testmonkeys.selenium.engine.core.factory;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.testmonkeys.selenium.engine.pageobjects.PageAccessor;
import org.testmonkeys.selenium.engine.core.page.Page;

import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PageScanner {

    private String pagesPackage;

    public PageScanner(String pagesPackage) {
        this.pagesPackage = pagesPackage;
    }

    private Predicate<Class<?>> isPageWithName(String name) {
        return clazz -> clazz.getDeclaredAnnotation(PageAccessor.class).name().equals(name);
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
}
