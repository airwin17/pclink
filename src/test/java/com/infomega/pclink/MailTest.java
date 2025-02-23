package com.infomega.pclink;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.infomega.pclink.Services.MailService;

@SpringBootTest
@AutoConfigureMockMvc
public class MailTest {
    @Autowired
    private MailService mailService;
@Test
public void testSendMail() {
    mailService.sendMail("kkk","mmm");
}
}
