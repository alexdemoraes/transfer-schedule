package com.rf.challenge.web.model.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TransferValidator.class)
@Documented
public @interface TransferValidation {

    String message() default TransferValidator._40_DAYS_LONGER_TRANSFER_MESSAGE;

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
