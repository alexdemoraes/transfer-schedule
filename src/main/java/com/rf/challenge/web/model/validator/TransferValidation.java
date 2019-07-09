package com.rf.challenge.web.model.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TransferValidator.class)
@Documented
public @interface TransferValidation {

    String message() default "For Transfer Date longer than 40 days the amount must be over $ 100.000!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
