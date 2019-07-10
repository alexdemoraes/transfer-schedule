package com.rf.challenge.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@RunWith(SpringRunner.class)
public class FeeCalculationServiceImplTest {

    @InjectMocks
    private FeeCalculationServiceImpl service;

    @Test
    public void calculateFees() throws Exception {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate in10Days = today.plus(10, ChronoUnit.DAYS);
        LocalDate in11Days = today.plus(11, ChronoUnit.DAYS);
        LocalDate in20Days = today.plus(20, ChronoUnit.DAYS);
        LocalDate in21Days = today.plus(21, ChronoUnit.DAYS);
        LocalDate in30Days = today.plus(30, ChronoUnit.DAYS);
        LocalDate in31Days = today.plus(31, ChronoUnit.DAYS);
        LocalDate in40Days = today.plus(40, ChronoUnit.DAYS);
        LocalDate in41Days = today.plus(41, ChronoUnit.DAYS);

        BigDecimal aThousand = new BigDecimal(1000);

        /* Type A transfer */
        BigDecimal fee = service.calculateFee(today, today, aThousand);
        Assert.assertEquals(fee, bigDecimal2Decimals(33.00));

        /* Type B transfer */
        fee = service.calculateFee(today, tomorrow, aThousand);
        Assert.assertEquals(fee, bigDecimal2Decimals(12));

        fee = service.calculateFee(today, in10Days, aThousand);
        Assert.assertEquals(fee, bigDecimal2Decimals(120));

        /* Type C transfer */
        fee = service.calculateFee(today, in11Days, aThousand);
        Assert.assertEquals(fee, bigDecimal2Decimals(80));
        fee = service.calculateFee(today, in20Days, aThousand);
        Assert.assertEquals(fee, bigDecimal2Decimals(80));
        fee = service.calculateFee(today, in21Days, aThousand);
        Assert.assertEquals(fee, bigDecimal2Decimals(60));
        fee = service.calculateFee(today, in30Days, aThousand);
        Assert.assertEquals(fee, bigDecimal2Decimals(60));
        fee = service.calculateFee(today, in31Days, aThousand);
        Assert.assertEquals(fee, bigDecimal2Decimals(40));
        fee = service.calculateFee(today, in40Days, aThousand);
        Assert.assertEquals(fee, bigDecimal2Decimals(40));
        fee = service.calculateFee(today, in41Days, new BigDecimal(200000));
        Assert.assertEquals(fee, bigDecimal2Decimals(4000));



    }

    private BigDecimal bigDecimal2Decimals(double value) {
        return new BigDecimal(value).setScale(2);
    }

}
