package com.rf.challenge.service;

import com.rf.challenge.dao.TransferDAO;
import com.rf.challenge.dao.model.TransferEntity;
import com.rf.challenge.util.Util;
import com.rf.challenge.web.model.TransferViewModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.any;

@RunWith(SpringRunner.class)
public class TransferServiceImplTest {

    @Mock
    private TransferDAO dao;

    @Mock
    private FeeCalculationService feeCalculationService;

    @InjectMocks
    private TransferServiceImpl service;

    @Test
    public void list() {
        List<TransferEntity> entityList = Util.listWith4TransferEntities();
        given(dao.list()).willReturn(entityList);

        List<TransferViewModel> viewModelList = service.list();

        Assert.assertEquals(entityList.get(0).getOriginAccountNumber(), viewModelList.get(0).getOriginAccountNumber());
        Assert.assertEquals(entityList.get(0).getOriginAccountNumber(), viewModelList.get(0).getOriginAccountNumber());
        Assert.assertEquals(entityList.get(0).getOriginAccountNumber(), viewModelList.get(0).getOriginAccountNumber());
        Assert.assertEquals(entityList.get(0).getOriginAccountNumber(), viewModelList.get(0).getOriginAccountNumber());
    }

    @Test
    public void schedule() throws Exception {
        given(feeCalculationService.calculateFee(
                any(LocalDate.class),
                any(LocalDate.class),
                any(BigDecimal.class))).
                willReturn(new BigDecimal(5.00));

        TransferViewModel request = Util.validTransferRequest();
        TransferViewModel response = service.schedule(request);
        Assert.assertNotNull(response.getFee());
        Assert.assertNotNull(response.getCreationDate());
        Assert.assertEquals(response.getCreationDate(), LocalDate.now());
    }
}
