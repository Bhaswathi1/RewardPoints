package com.example.rewardpoints.repository.impl;

import com.example.rewardpoints.model.Customer;
import com.example.rewardpoints.model.Transaction;
import com.example.rewardpoints.repository.TransactionRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    private Map<Long, Customer> customersMap = new ConcurrentHashMap<>();
    private Map<Long, Transaction> transactionsMap = new ConcurrentHashMap<>();

    public TransactionRepositoryImpl(){
        customersMap.put(100L, new Customer(100L, "fname1", "lname1", 23, "address1", 500));
        customersMap.put(101L, new Customer(101L, "fname2", "lname2", 45, "address2", 120));
        customersMap.put(102L, new Customer(102L, "fname3", "lname3", 27, "address3", 2500));
        customersMap.put(103L, new Customer(103L, "fname4", "lname4", 33, "address4", 70));
        customersMap.put(104L, new Customer(104L, "fname5", "lname5", 21, "address5", 800));

        transactionsMap.put(1L, new Transaction(1L, 100f, new Date(), customersMap.get(100L), "refid"));
        transactionsMap.put(2L, new Transaction(2L, 240f, new Date(), customersMap.get(100L), "refid"));
        transactionsMap.put(3L, new Transaction(3L, 30f, new Date(), customersMap.get(100L), "refid"));
        transactionsMap.put(4L, new Transaction(4L, 175f, new Date(), customersMap.get(101L), "refid"));
        transactionsMap.put(5L, new Transaction(5L, 80f, new Date(),  customersMap.get(101L), "refid"));
        transactionsMap.put(6L, new Transaction(6L, 1400f, new Date(), customersMap.get(101L), "refid"));
        transactionsMap.put(7L, new Transaction(7L, 140f, new Date(), customersMap.get(101L), "refid"));
        transactionsMap.put(8L, new Transaction(8L, 10f, new Date(), customersMap.get(102L), "refid"));
        transactionsMap.put(9L, new Transaction(9L, 150f, new Date(), customersMap.get(103L), "refid"));
        transactionsMap.put(10L, new Transaction(10L, 370f, new Date(),  customersMap.get(104L), "refid"));
    }


    @Override
    public Transaction getById(Long id) {
        return transactionsMap.get(id);
    }

    @Override
    public List<Transaction> getByCustomerId(Long customerId) {
        return transactionsMap.values().stream().filter(txn -> txn.getInitiatedBy().getId() == customerId).collect(Collectors.toList());
    }

    @Override
    public List<Transaction> getAll() {
        return transactionsMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void save(Transaction transaction) {
        transactionsMap.put(transaction.getTxnId(), transaction);
    }

}
