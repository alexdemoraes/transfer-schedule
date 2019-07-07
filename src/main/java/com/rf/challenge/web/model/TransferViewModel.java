package com.rf.challenge.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;


public class TransferViewModel {

    @JsonProperty("origin_account_number")
    private String originAccountNumber;
    @JsonProperty("destination_account_number")
    private String destinationAccountNumber;
    private BigDecimal amount;
    private BigDecimal fee;
    @JsonProperty("transfer_date")
    private LocalDate transferDate;
    @JsonProperty("creation_date")
    private LocalDate creationDate;

    public TransferViewModel() {

    }

    public TransferViewModel(String originAccountNumber, String destinationAccountNumber,
                             BigDecimal amount, BigDecimal fee,
                             LocalDate transferDate, LocalDate creationDate) {
        this.originAccountNumber = originAccountNumber;
        this.destinationAccountNumber = destinationAccountNumber;
        this.amount = amount;
        this.fee = fee;
        this.transferDate = transferDate;
        this.creationDate = creationDate;
    }

    public String getOriginAccountNumber() {
        return originAccountNumber;
    }

    public void setOriginAccountNumber(String originAccountNumber) {
        this.originAccountNumber = originAccountNumber;
    }

    public String getDestinationAccountNumber() {
        return destinationAccountNumber;
    }

    public void setDestinationAccountNumber(String destinationAccountNumber) {
        this.destinationAccountNumber = destinationAccountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public LocalDate getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDate transferDate) {
        this.transferDate = transferDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
