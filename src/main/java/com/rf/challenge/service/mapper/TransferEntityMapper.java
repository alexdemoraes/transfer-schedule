package com.rf.challenge.service.mapper;

import com.rf.challenge.dao.model.TransferEntity;
import com.rf.challenge.web.model.TransferViewModel;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransferEntityMapper {

    private TransferEntityMapper() {
    }

    public static TransferEntity from(TransferViewModel viewModel) {
        TransferEntity entity = new TransferEntity();
        entity.setOriginAccountNumber(viewModel.getOriginAccountNumber());
        entity.setDestinationAccountNumber(viewModel.getDestinationAccountNumber());
        entity.setAmount(viewModel.getAmount());
        entity.setFee(viewModel.getFee());
        entity.setTransferDate(viewModel.getTransferDate());
        entity.setScheduleDate(viewModel.getScheduleDate());
        return entity;
    }

    public static TransferViewModel from(TransferEntity entity) {
        TransferViewModel viewModel = new TransferViewModel();
        viewModel.setOriginAccountNumber(entity.getOriginAccountNumber());
        viewModel.setDestinationAccountNumber(entity.getDestinationAccountNumber());
        viewModel.setAmount(entity.getAmount());
        viewModel.setFee(entity.getFee());
        viewModel.setTransferDate(entity.getTransferDate());
        viewModel.setScheduleDate(entity.getScheduleDate());
        return viewModel;
    }

}
