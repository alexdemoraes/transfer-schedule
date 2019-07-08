package com.rf.challenge.service;

import com.rf.challenge.web.model.TransferViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface TransferService {

    final static BigDecimal MINIMUM_AMOUNT_40_DAYS_LONGER = new BigDecimal(100000);

    List<TransferViewModel> list();
    TransferViewModel schedule(TransferViewModel viewModel);

}
