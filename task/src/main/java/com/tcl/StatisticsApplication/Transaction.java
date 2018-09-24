package com.tcl.StatisticsApplication;

import java.io.Serializable;
//as we send and recievce obecjts we are serializing the class
public class Transaction implements Serializable {
    // The input for which getter and setter are used
    private Double amount;
    private Long timestamp;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}