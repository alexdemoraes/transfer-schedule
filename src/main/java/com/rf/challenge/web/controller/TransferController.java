package com.rf.challenge.web.controller;

import com.rf.challenge.service.TransferService;
import com.rf.challenge.web.model.TransferViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@RestController
@RequestMapping(value="",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
//        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TransferController {

    @Autowired
    private TransferService service;

    @GetMapping("list")
    public ResponseEntity<List<TransferViewModel>> list() {

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @PostMapping("schedule")
    public ResponseEntity<TransferViewModel> schedule(@RequestBody TransferViewModel viewModel) {
        TransferViewModel returnViewModel = service.schedule(viewModel);
        return new ResponseEntity<>(returnViewModel, HttpStatus.CREATED);
    }

}
