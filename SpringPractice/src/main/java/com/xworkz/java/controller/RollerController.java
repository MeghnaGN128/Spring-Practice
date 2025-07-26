package com.xworkz.java.controller;

import com.xworkz.java.dto.RollerDTO;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class RollerController {
    public RollerController(){
        System.out.println("running in RollerController");
    }
    @RequestMapping("/submit")
    public String onSubmit(RollerDTO rollerDTO, Model model){
        System.out.println("onSubmit in RollerController");
        System.out.println(rollerDTO);
        model.addAttribute("rollerDTO",rollerDTO);
        return "RollerResult.jsp";
    }
}
