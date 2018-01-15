package com.hup.springboot.mail.entity;

import lombok.Data;

@Data
public class Send {
    String to;
    String subject;
    String text;
}
