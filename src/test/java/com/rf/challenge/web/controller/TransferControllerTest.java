package com.rf.challenge.web.controller;

import com.rf.challenge.service.TransferService;
import com.rf.challenge.util.Util;
import com.rf.challenge.web.model.TransferViewModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TransferController.class)
public class TransferControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TransferService service;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    private MediaType contentType = MediaType.APPLICATION_JSON_UTF8;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse(null);

        Assert.assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    @Test
    public void scheduleTransferSuccess() throws Exception {
        given(service.schedule(any(TransferViewModel.class))).willReturn(Util.validTransferResponse());

        mvc.perform(
                post("/transfer/schedule").
                content(json(Util.validTransferRequest())).
                contentType(contentType)
        ).
        andDo(print()).
        andExpect(status().isCreated()).
        andExpect(jsonPath("$.fee").value(3.00));

    }


    @Test
    public void listTransfers() throws Exception {
        given(service.list()).willReturn(Util.listWith4Transfers());

        mvc.perform(
                get("/transfer/list").
                        content(json(Util.validTransferRequest())).
                        contentType(contentType)
        ).
                andDo(print()).
                andExpect(status().isOk()).
                andExpect(jsonPath("$[0].fee").value(3.00)).
                andExpect(jsonPath("$[1].fee").value(3.00)).
                andExpect(jsonPath("$[2].fee").value(3.00)).
                andExpect(jsonPath("$[3].fee").value(3.00));
    }



    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
}
