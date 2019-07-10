package com.rf.challenge.util;

import com.rf.challenge.dao.model.TransferEntity;
import com.rf.challenge.web.model.TransferViewModel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Util {

    private Util() {

    }


    public static TransferViewModel validTransferRequest() {
        return new TransferViewModel(
                "02",
                "03",
                new BigDecimal(1000),
                null,
                LocalDate.now(),
                null);
    }

    public static TransferViewModel inValidTransferRequestTransferDatePast() {
        return new TransferViewModel(
                "02",
                "03",
                new BigDecimal(1000),
                null,
                LocalDate.now().plus(-1, ChronoUnit.DAYS),
                null);
    }

    public static TransferViewModel inValidTransferRequestTransferDateFuture() {
        return new TransferViewModel(
                "02",
                "03",
                new BigDecimal(1000),
                null,
                LocalDate.now().plus(41, ChronoUnit.DAYS),
                null);
    }

    public static TransferViewModel validTransferRequest41GreaterThan100Thousand() {
        return new TransferViewModel(
                "02",
                "03",
                new BigDecimal(100000.01),
                null,
                LocalDate.now().plus(41, ChronoUnit.DAYS),
                null);
    }



    public static TransferViewModel validTransferResponseEven() {
        TransferViewModel viewModel = validTransferRequest();
        viewModel.setFee(new BigDecimal(2.00));
        viewModel.setCreationDate(LocalDate.now());
        return viewModel;
    }

    public static TransferViewModel validTransferResponseOdd() {
        TransferViewModel viewModel = validTransferRequest();
        viewModel.setFee(new BigDecimal(3.00));
        viewModel.setCreationDate(LocalDate.now());
        return viewModel;
    }

    public static TransferEntity transferEntity(boolean even) {
        return new TransferEntity(
                "02",
                "03",
                new BigDecimal(100),
                new BigDecimal(even ? 2.00 : 3.00),
                LocalDate.now(),
                LocalDate.now());
    }

    public static List<TransferViewModel> listWith4Transfers() {
        List<TransferViewModel> list = new ArrayList<>();
        list.add(validTransferResponseEven());
        list.add(validTransferResponseOdd());
        list.add(validTransferResponseEven());
        list.add(validTransferResponseOdd());
        return list;
    }

    public static List<TransferEntity> listWith4TransferEntities() {
        List<TransferEntity> list = new ArrayList<>();
        list.add(transferEntity(true));
        list.add(transferEntity(false));
        list.add(transferEntity(true));
        list.add(transferEntity(false));
        return list;
    }

}
