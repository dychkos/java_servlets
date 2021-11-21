package com.unrgo.javaee_1.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {ValidateURL.class}
)
public @interface CheckURL {
    String message() default "wrong url";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload () default {};

    int port() default 3030;
    String host() default "";
    String protocol() default "";
}
