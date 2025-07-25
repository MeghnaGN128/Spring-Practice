package com.xworkz.java.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.java")
public class CardBoardConfiguration {
    public CardBoardConfiguration(){
        System.out.println("running in CardBoardConfiguration");
    }
}
