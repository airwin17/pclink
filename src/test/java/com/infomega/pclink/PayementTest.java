package com.infomega.pclink;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import com.infomega.pclink.Services.PayService;
import com.stripe.exception.StripeException;

@SpringBootTest
@AutoConfigureMockMvc
public class PayementTest {
    @Autowired
    private PayService payementService;

    @Test
    public void testGetCheckoutUrl() throws StripeException {
        payementService.getCheckoutUrl();
    }
}
