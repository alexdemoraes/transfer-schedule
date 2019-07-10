package com.rf.challenge.dao;

import com.rf.challenge.dao.model.TransferEntity;
import com.rf.challenge.dao.repository.TransferRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;

@Repository
public class TransferDAOImpl implements TransferDAO {

    @Autowired
    private TransferRepository repository;

    private static Logger logger = LoggerFactory.getLogger(TransferDAOImpl.class);

    @Override
    public void create(TransferEntity entity) throws PersistenceException {
        logger.info("create entity");
        repository.save(entity);
        logger.info("entity created");
    }

    @Override
    public Iterable<TransferEntity> list() {
        return repository.findAll();
    }

}
