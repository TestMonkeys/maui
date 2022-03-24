package org.testmonkeys.maui.pageobjects.entitymapping;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MapsToField {
    Class clazz();

    String value();
}
