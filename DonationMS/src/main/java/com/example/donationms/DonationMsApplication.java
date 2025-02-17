package com.example.donationms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DonationMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DonationMsApplication.class, args);
    }

}
