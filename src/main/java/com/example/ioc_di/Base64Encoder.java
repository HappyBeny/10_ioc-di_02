package com.example.ioc_di;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component("base64Encoder")
public class Base64Encoder implements IEncoder{

    public String encode(String message){
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
