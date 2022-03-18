package com.example.rewardpoints.repository;

import com.example.rewardpoints.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository {

    Transaction getById(Long id);

    List<Transaction> getByCustomerId(Long customerId);
    List<Transaction> getAll();
    void save(Transaction transaction);


}
