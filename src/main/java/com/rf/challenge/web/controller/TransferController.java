package com.rf.challenge.web.controller;

import com.rf.challenge.web.model.TransferViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("list")
    public ResponseEntity<List<TransferViewModel>> list() {
        return new ResponseEntity<>(dummy(), HttpStatus.OK);
    }


    private List<TransferViewModel> dummy() {
        List<TransferViewModel> dummy = new ArrayList<>();
        IntStream.range(0, 5).forEach( i -> {
            dummy.add(new TransferViewModel("Hello", "World",
                    new BigDecimal(100 + i), new BigDecimal(i),
                    LocalDate.now(), LocalDate.now().plusDays(i)));
                }
        );
        return dummy;
    }
}
