package org.testmonkeys.maui.pageobjects.entitymapping;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MapsToEntity {
    String value();
}
