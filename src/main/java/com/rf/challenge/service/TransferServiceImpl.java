package com.rf.challenge.service;

import com.rf.challenge.web.model.TransferViewModel;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class TransferServiceImpl implements TransferService {

    @Override
    public List<TransferViewModel> list() {
        return dummy();
    }

    @Override
    public TransferViewModel schedule(TransferViewModel viewModel) {
        return null;
    }

    private List<TransferViewModel> dummy() {
        List<TransferViewModel> dummy = new ArrayList<>();
        IntStream.range(0, 5).forEach(i -> {
                    dummy.add(new TransferViewModel("Hello", "World",
                            new BigDecimal(100 + i), new BigDecimal(i),
                            LocalDate.now(), LocalDate.now().plusDays(i)));
                }
        );
        return dummy;
    }

}
