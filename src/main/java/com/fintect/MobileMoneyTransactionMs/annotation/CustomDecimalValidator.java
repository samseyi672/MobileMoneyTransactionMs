package com.fintect.MobileMoneyTransactionMs.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class CustomDecimalValidator implements ConstraintValidator<CustomBigDecimalConstraint, BigDecimal> {

    @Override
    public void initialize(CustomBigDecimalConstraint constraintAnnotation) {
        // ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(BigDecimal bigDecimal, ConstraintValidatorContext constraintValidatorContext) {
      //  log.info("bigDecimal.toString() ", bigDecimal);
        try {
            if (!bigDecimal.toString().isEmpty() && bigDecimal != null) {
        //        log.info("bigDecimal.toString() correct ", bigDecimal);
                return true;
            }
        } catch (RuntimeException r) {
          //  log.info("bigDecimal error", r.getMessage());
            return false ;
        }
        return true ;
    }
}
