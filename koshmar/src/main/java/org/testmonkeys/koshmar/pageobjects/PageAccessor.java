package org.testmonkeys.koshmar.pageobjects;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PageAccessor {

    String url();

    String name();

    String application() default "";
}
