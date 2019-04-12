package com.example.fluxdemo;

import com.example.fluxdemo.controller.GreetingWebClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FluxdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FluxdemoApplication.class, args);

        GreetingWebClient gwc = new GreetingWebClient();
        System.out.println(gwc.getResult());
    }


}
