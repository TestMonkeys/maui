package org.testmonkeys.koshmar.pageobjects;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ElementAccessor {

    String elementName();

    String byXPath() default "";

    String byCssSelector() default "";

    String byClassName() default  "";

    String byTagName() default "";

    String byName() default "";

    String byPartialLinkText() default "";

    String byLinkText() default "";

    String byId() default "";
}
