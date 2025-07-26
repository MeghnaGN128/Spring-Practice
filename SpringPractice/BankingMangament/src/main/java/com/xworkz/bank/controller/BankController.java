package com.xworkz.bank.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class BankController {
    public BankController(){
        System.out.println("running in BankController");
    }
    @RequestMapping("/deatils")
    public String onDetails(){
        System.out.println("onDetails in BankController");
        return "index.jsp";
    }
}
