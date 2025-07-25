package com.xworkz.java.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("com.xworkz.java")
public class BucketConfiguration {
    public BucketConfiguration(){
        System.out.println("running in BucketConfiguration ");
    }
}
