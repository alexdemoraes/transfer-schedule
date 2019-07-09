package com.rf.challenge.util;

import com.rf.challenge.web.model.TransferViewModel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Util {

    private Util() {

    }


    public static TransferViewModel validTransferRequest() {
        return new TransferViewModel(
                "02",
                "03",
                new BigDecimal(100),
                null,
                LocalDate.now(),
                null);
    }

    public static TransferViewModel validTransferResponse() {
        TransferViewModel viewModel = validTransferRequest();
        viewModel.setFee(new BigDecimal(3.00));
        viewModel.setCreationDate(LocalDate.now());
        return viewModel;
    }

    public static List<TransferViewModel> listWith4Transfers() {
        List<TransferViewModel> list = new ArrayList<>();
        list.add(validTransferResponse());
        list.add(validTransferResponse());
        list.add(validTransferResponse());
        list.add(validTransferResponse());
        return list;
    }

}
