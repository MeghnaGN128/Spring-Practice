package com.xworkz.java.controller;

import com.xworkz.java.dto.BucketDTO;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class BucketController {
    public BucketController(){
        System.out.println(" running in BucketController");
    }
    @RequestMapping("/give")
    public String onGive(BucketDTO bucketDTO, Model model){
        System.out.println("onGive in BucketController");
        System.out.println(bucketDTO);
        model.addAttribute("bucketDTO",bucketDTO);
        return "BucketResult.jsp";
    }
}
