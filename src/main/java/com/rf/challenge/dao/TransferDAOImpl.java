package com.rf.challenge.dao;

import com.rf.challenge.dao.model.TransferEntity;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class TransferDAOImpl implements TransferDAO {

    @Override
    public void create(TransferEntity entity) {

    }

    @Override
    public List<TransferEntity> list() {
        return dummy();
    }

    private List<TransferEntity> dummy() {
        List<TransferEntity> dummy = new ArrayList<>();
        IntStream.range(0, 5).forEach(i -> {
                    dummy.add(new TransferEntity("Hello", "World",
                            new BigDecimal(100 + i), new BigDecimal(i),
                            LocalDate.now(), LocalDate.now().plusDays(i)));
                }
        );
        return dummy;
    }

}
