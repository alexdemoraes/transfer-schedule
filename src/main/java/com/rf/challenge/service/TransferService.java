package com.rf.challenge.service;

import com.rf.challenge.web.model.TransferViewModel;

import java.util.List;

public interface TransferService {

    List<TransferViewModel> list();
    TransferViewModel schedule(TransferViewModel viewModel);

}
