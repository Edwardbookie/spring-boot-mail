package com.hup.springboot.mail.config;

import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Data
@Log
@Component
public class MailConfig {

    @Autowired
    private JavaMailSender sender;

    @Value("${mail.from}")
    private String from;

    /**
     * 发送文本邮件
     *
     * @param to      接收人
     * @param subject 主题
     * @param text    文本
     */
    public void sendText(String to, String subject, String text) {
        log.info("start");
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        sender.send(message);
        log.info("===>send text mail finish");
    }
}
