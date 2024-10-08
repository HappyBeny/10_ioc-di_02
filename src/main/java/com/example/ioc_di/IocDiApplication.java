package com.example.ioc_di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class IocDiApplication {

    public static void main(String[] args) {
        SpringApplication.run(IocDiApplication.class, args);
        ApplicationContext context = ApplicationContextProvider.getContext();

        //Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
        //UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);

        Encoder encoder = context.getBean("urlEncode", Encoder.class);
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        String result = encoder.encode(url);
        System.out.println(result);
    }

}


@Configuration
class AppConfig{

    @Bean("base64Encode")
    public Encoder base64Encoder (Base64Encoder base64Encoder){
        return new Encoder(base64Encoder);
    }

    @Bean("urlEncode")
    public Encoder urlEncoder(UrlEncoder urlEncoder){
        return new Encoder(urlEncoder);
    }
}