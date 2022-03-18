package com.example.rewardpoints.service.impl;

import com.example.rewardpoints.service.RewardPointsCalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RewardPointsCalculatorServiceImplTest {

    @Autowired
    RewardPointsCalculatorService rewardPointsCalculatorService;

    @Test
    public void test0Dollars(){
        float res = rewardPointsCalculatorService.calculateRewardPoints(0f);
        assertEquals(0, res);
    }

    @Test
    public void test30Dollars(){
        float res = rewardPointsCalculatorService.calculateRewardPoints(30f);
        assertEquals(0, res);
    }


    @Test
    public void test50Dollars(){
        float res = rewardPointsCalculatorService.calculateRewardPoints(50f);
        assertEquals(0, res);
    }

    @Test
    public void test70Dollars(){
        float res = rewardPointsCalculatorService.calculateRewardPoints(70f);
        assertEquals(20, res);
    }

    @Test
    public void test100Dollars(){
        float res = rewardPointsCalculatorService.calculateRewardPoints(100f);
        assertEquals(50, res);
    }

    @Test
    public void test120Dollars(){
        float res = rewardPointsCalculatorService.calculateRewardPoints(120f);
        assertEquals(90, res);
    }
}