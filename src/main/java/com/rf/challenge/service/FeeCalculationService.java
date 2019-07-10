package com.rf.challenge.service;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface FeeCalculationService {


    BigDecimal calculateFee(LocalDate scheduledDate, LocalDate transferDate, BigDecimal amount) throws Exception;


}
