package com.example.proiectcolectiv731_be.pass_reset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class GMailer {
    @Autowired
    private JavaMailSender mailSender;
    public void sendMail(String subject,String message, String destination){
        SimpleMailMessage mail=new SimpleMailMessage();
        mail.setFrom("cardealership731@gmail.com");
        mail.setTo(destination);
        mail.setText(message);
        mail.setSubject(subject);

        mailSender.send(mail);
    }
}
