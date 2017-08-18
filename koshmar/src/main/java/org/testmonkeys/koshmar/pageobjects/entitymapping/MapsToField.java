package org.testmonkeys.koshmar.pageobjects.entitymapping;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MapsToField {
    String value();
}
