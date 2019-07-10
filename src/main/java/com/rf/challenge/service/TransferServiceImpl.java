package com.rf.challenge.service;

import com.rf.challenge.dao.TransferDAO;
import com.rf.challenge.dao.model.TransferEntity;
import com.rf.challenge.service.mapper.TransferEntityMapper;
import com.rf.challenge.web.model.TransferViewModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private FeeCalculationService feeCalculationService;

    @Autowired
    private TransferDAO dao;

    private static Logger logger = LoggerFactory.getLogger(TransferServiceImpl.class);

    @Override
    public List<TransferViewModel> list() {
        List<TransferViewModel> list = new ArrayList<>();
        for (TransferEntity entity : dao.list()) {
            list.add(TransferEntityMapper.from(entity));
        }
        return list;
    }

    @Override
    public TransferViewModel schedule(TransferViewModel viewModel) throws Exception {
        logger.info("schedule()");
        viewModel.setCreationDate(LocalDate.now());
        viewModel.setFee(
                feeCalculationService.calculateFee(
                        viewModel.getCreationDate(),
                        viewModel.getTransferDate(),
                        viewModel.getAmount()
                )
        );
        TransferEntity entity = TransferEntityMapper.from(viewModel);
        try {
            dao.create(entity);
            logger.info("New transfer created");
        } catch (PersistenceException e) {
            logger.error("Error creating new transfer schedule" , e);
            throw new Exception("Error creating new transfer schedule", e);
        }
        return viewModel;
    }

}
