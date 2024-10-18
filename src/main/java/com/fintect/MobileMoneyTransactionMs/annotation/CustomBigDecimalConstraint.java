package com.fintect.MobileMoneyTransactionMs.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CustomDecimalValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomBigDecimalConstraint {
    String message() default "wrong decimal format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}