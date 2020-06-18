package net.gichain.genergy.eam.common.annotations;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TokenAnnotation {
    boolean required() default true;
}


