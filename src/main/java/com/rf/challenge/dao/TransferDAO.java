package com.rf.challenge.dao;

import com.rf.challenge.dao.model.TransferEntity;

import java.util.List;

public interface TransferDAO {

    void create(TransferEntity entity);
    List<TransferEntity> list();

}
