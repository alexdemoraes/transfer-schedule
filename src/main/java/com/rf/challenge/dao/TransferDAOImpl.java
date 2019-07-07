package com.rf.challenge.dao;

import com.rf.challenge.dao.model.TransferEntity;
import com.rf.challenge.dao.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransferDAOImpl implements TransferDAO {

    @Autowired
    private TransferRepository repository;

    @Override
    public void create(TransferEntity entity) {
        repository.save(entity);
    }

    @Override
    public Iterable<TransferEntity> list() {
        return repository.findAll();
    }

}
