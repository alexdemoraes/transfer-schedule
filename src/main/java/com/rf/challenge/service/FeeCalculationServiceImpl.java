package com.rf.challenge.service;

import static com.rf.challenge.service.TransferService.MINIMUM_AMOUNT_40_DAYS_LONGER;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class FeeCalculationServiceImpl implements FeeCalculationService {

    private final static BigDecimal ZERO = BigDecimal.ZERO;

    /* Type A constants */
    private final static BigDecimal SAME_DAY_FIXED_FEE = new BigDecimal(3);
    private final static BigDecimal SAME_DAY_AMOUNT_RATE = new BigDecimal(.03);

    /* Type B constants */
    private final static BigDecimal FIRST_10_DAYS_FEE_PER_DAY = new BigDecimal(12);

    /* Type C constants */
    private final static BigDecimal UNTIL_20_DAYS_AMOUNT_RATE = new BigDecimal(.08);
    private final static BigDecimal UNTIL_30_DAYS_AMOUNT_RATE = new BigDecimal(.06);
    private final static BigDecimal UNTIL_40_DAYS_AMOUNT_RATE = new BigDecimal(.04);
    private final static BigDecimal ABOVE_40_DAYS_AMOUNT_RATE = new BigDecimal(.02);


    public BigDecimal calculateFee(LocalDate scheduledDate, LocalDate transferDate, BigDecimal amount) {
        int days = (int) ChronoUnit.DAYS.between(scheduledDate, transferDate);

        BigDecimal fee = ZERO;
        BigDecimal fixedPortion = BigDecimal.ZERO;
        BigDecimal percentual = BigDecimal.ZERO;
        if (days < 0) {
            fee = ZERO;
        } else if (days == 0) {
            fee = calculateFee(amount, SAME_DAY_FIXED_FEE, SAME_DAY_AMOUNT_RATE);
        } else if (days <= 10) {
            fee = calculateFee(amount, fixedPortion, percentual,
                    days, FIRST_10_DAYS_FEE_PER_DAY);
        } else {

            if (days < 20) {
                percentual = UNTIL_20_DAYS_AMOUNT_RATE;
            } else if (days < 30) {
                percentual = UNTIL_30_DAYS_AMOUNT_RATE;
            } else if (days < 40) {
                percentual = UNTIL_40_DAYS_AMOUNT_RATE;
            } else if (amount.compareTo(MINIMUM_AMOUNT_40_DAYS_LONGER) >= 0) {
                percentual = ABOVE_40_DAYS_AMOUNT_RATE;
            } else {

            }
            fee = calculateFee(amount, SAME_DAY_FIXED_FEE, SAME_DAY_AMOUNT_RATE);
        }
        return fee;
    }

    private BigDecimal calculateFee(BigDecimal amount,
                                    BigDecimal fixedPortion,
                                    BigDecimal percentual) {
        return calculateFee(amount, fixedPortion, percentual,
                0, new BigDecimal(0));
    }

    private BigDecimal calculateFee(BigDecimal amount,
                                    BigDecimal fixedPortion,
                                    BigDecimal percentual,
                                    long days, BigDecimal feePerDay ) {
        return fixedPortion.
                add(amount.multiply(percentual)).
                add(feePerDay.multiply(new BigDecimal(days)));
    }
}