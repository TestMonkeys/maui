package org.testmonkeys.koshmar.pageobjects.entitymapping;

import java.lang.annotation.*;
import java.lang.reflect.Type;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MapsToField {
    Class clazz();
    String value();
}
