package com.xworkz.bank.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.bank")
public class BankConfiguration {
    public BankConfiguration(){
        System.out.println("running in BankConfiguration ");
    }
}
