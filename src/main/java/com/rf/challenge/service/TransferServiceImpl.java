package com.rf.challenge.service;

import com.rf.challenge.dao.TransferDAO;
import com.rf.challenge.dao.model.TransferEntity;
import com.rf.challenge.service.mapper.TransferEntityMapper;
import com.rf.challenge.web.model.TransferViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private FeeCalculationService feeCalculationService;

    @Autowired
    private TransferDAO dao;


    @Override
    public List<TransferViewModel> list() {
        List<TransferViewModel> list = new ArrayList<>();
        for (TransferEntity entity : dao.list()) {
            list.add(TransferEntityMapper.from(entity));
        }
        return list;
    }

    @Override
    public TransferViewModel schedule(TransferViewModel viewModel) {
        viewModel.setCreationDate(LocalDate.now());
        viewModel.setFee(
                feeCalculationService.calculateFee(
                        viewModel.getCreationDate(),
                        viewModel.getTransferDate(),
                        viewModel.getAmount()
                )
        );
        TransferEntity entity = TransferEntityMapper.from(viewModel);
        dao.create(entity);
        return viewModel;
    }

}
