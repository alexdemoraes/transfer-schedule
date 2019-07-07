package com.rf.challenge.dao.repository;

import com.rf.challenge.dao.model.TransferEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository
        extends CrudRepository<TransferEntity, Integer> {
}
