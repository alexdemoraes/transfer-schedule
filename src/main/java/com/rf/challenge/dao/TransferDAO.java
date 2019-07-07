package com.rf.challenge.dao;

import com.rf.challenge.dao.model.TransferEntity;


public interface TransferDAO {

    void create(TransferEntity entity);
    Iterable<TransferEntity> list();

}
