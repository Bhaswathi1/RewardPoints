package com.example.rewardpoints.service.impl;

import com.example.rewardpoints.model.Transaction;
import com.example.rewardpoints.repository.TransactionRepository;
import com.example.rewardpoints.service.TransactionService;
import com.example.rewardpoints.service.RewardPointsCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.DoubleStream;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    RewardPointsCalculatorService rewardPointsCalculatorService;

    @Override
    public Transaction getById(Long id) {
        return transactionRepository.getById(id);
    }

    @Override
    public List<Transaction> getAll() {
        return transactionRepository.getAll();
    }

    @Override
    public List<Transaction> getByCustomerId(Long customerId) {
        return transactionRepository.getByCustomerId(customerId);
    }

    @Override
    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public Float getRewardPointsByCustomerId(Long customerId) {
        Float sum = (float) transactionRepository.getByCustomerId(customerId).stream().flatMapToDouble(txn -> DoubleStream.of(txn.getAmount())).sum();
        return rewardPointsCalculatorService.calculateRewardPoints(sum);
    }
}
