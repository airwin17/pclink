package com.infomega.pclink.Services;

import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Service
public class MailService {
    
public void sendMail(String from, String message) {
    JavaMailSenderImpl emailSender=new JavaMailSenderImpl();
    emailSender.setHost("smtp-relay.gmail.com");
    emailSender.setPort(587);
    emailSender.setUsername("faitourdja@gmail.com");
    emailSender.setPassword("Malik2000/21/24");
    SimpleMailMessage mailMessage = new SimpleMailMessage();
    mailMessage.setFrom(from);
    mailMessage.setTo("faitourdja@gmail.com");
    mailMessage.setSubject("Subject");
    mailMessage.setText(message);
    emailSender.send(mailMessage);
}
}
