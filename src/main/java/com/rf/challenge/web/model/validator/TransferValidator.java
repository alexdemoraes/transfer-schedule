package com.rf.challenge.web.model.validator;

import static com.rf.challenge.service.TransferService.MINIMUM_AMOUNT_40_DAYS_LONGER;
import com.rf.challenge.web.model.TransferViewModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TransferValidator implements ConstraintValidator<TransferValidation, TransferViewModel>  {

    public final static String _40_DAYS_LONGER_TRANSFER_MESSAGE = "For Transfer Date longer than 40 days the amount must be over $ 100.000!";

    @Override
    public boolean isValid(TransferViewModel viewModel, ConstraintValidatorContext context) {
        if (viewModel != null) {
            if (viewModel.getTransferDate() != null && viewModel.getAmount() != null)  {
                int days = (int) ChronoUnit.DAYS.between(LocalDate.now(), viewModel.getTransferDate());

                if (days <= 40) {
                    return true;
                } else if (viewModel.getAmount().compareTo(MINIMUM_AMOUNT_40_DAYS_LONGER) > 0) {
                    return true;
                }

            }
        }

        return false;
    }

    @Override
    public void initialize(TransferValidation constraintAnnotation) {

    }
}
