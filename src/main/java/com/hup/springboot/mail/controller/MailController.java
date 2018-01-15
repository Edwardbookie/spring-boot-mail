package com.hup.springboot.mail.controller;

import com.hup.springboot.mail.config.MailConfig;
import com.hup.springboot.mail.entity.Send;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired
    private MailConfig mailConfig;

    @PostMapping(value = "/send")
    public void sendMail(@RequestBody Send send){
        mailConfig.sendText(send.getTo(),send.getSubject(),send.getText());
    }
}
