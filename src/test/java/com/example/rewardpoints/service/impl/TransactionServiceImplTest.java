package com.example.rewardpoints.service.impl;

import com.example.rewardpoints.model.Transaction;
import com.example.rewardpoints.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TransactionServiceImplTest {

    @InjectMocks
    TransactionServiceImpl transactionService;
    @Mock
    TransactionRepository transactionRepository;


    @Test
    public void getAllTest(){
        List<Transaction> mockTxns = new ArrayList<>();
        mockTxns.add(new Transaction());
        when(transactionRepository.getAll()).thenReturn(mockTxns);
        List<Transaction> res = transactionService.getAll();
        assertEquals(mockTxns, res);
    }


    @Test
    public void getByCustomerIdTest(){
        List<Transaction> mockTxns = new ArrayList<>();
        mockTxns.add(new Transaction());
        when(transactionRepository.getByCustomerId(123L)).thenReturn(mockTxns);
        List<Transaction> res = transactionService.getByCustomerId(123L);
        assertEquals(mockTxns, res);
    }

    @Test
    public void getByIdTest(){
        Transaction mockTxn = new Transaction();
        when(transactionRepository.getById(123L)).thenReturn(mockTxn);
        Transaction res = transactionService.getById(123L);
        assertEquals(mockTxn, res);
    }

    @Test
    public void saveTest(){
        Transaction mockTxn = new Transaction();
        transactionService.save(mockTxn);
        verify(transactionRepository).save(mockTxn);
    }

}
