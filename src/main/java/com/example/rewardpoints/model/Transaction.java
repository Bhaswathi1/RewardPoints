package com.example.rewardpoints.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private Long txnId;
    private Float amount;
    private Date createdOn;
    private Customer initiatedBy;
    private String refId;
}
