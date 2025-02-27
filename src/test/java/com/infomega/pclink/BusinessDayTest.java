package com.infomega.pclink;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.infomega.pclink.Services.BusinessDaysService;

@SpringBootTest
@AutoConfigureMockMvc
public class BusinessDayTest {
    @Autowired
    private BusinessDaysService businessDaysService;
    @Test
    public void testGetAllBusinessDays() {
        System.out.println(businessDaysService.getAllBusinessDays());
    }
}
