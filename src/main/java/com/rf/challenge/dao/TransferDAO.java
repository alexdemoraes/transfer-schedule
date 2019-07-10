package com.rf.challenge.dao;

import com.rf.challenge.dao.model.TransferEntity;

import javax.persistence.PersistenceException;


public interface TransferDAO {

    void create(TransferEntity entity) throws PersistenceException;
    Iterable<TransferEntity> list();

}
