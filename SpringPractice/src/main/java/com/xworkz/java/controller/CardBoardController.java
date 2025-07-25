package com.xworkz.java.controller;

import com.xworkz.java.dto.CardBoardDTO;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Component

public class CardBoardController {
    public CardBoardController(){
        System.out.println("running in CardBoardController ");
    }
    @RequestMapping("/saveboard")
    public String onSaveboard(CardBoardDTO cardBoardDTO, Model model){
        System.out.println("onSaveboard in CardBoardController");
        System.out.println(cardBoardDTO);
        model.addAttribute("cardboardDTO",cardBoardDTO);
        return "cardboardResult.jsp";
    }
    @RequestMapping("/store")
    public String onStore(){
        return "cardboard.jsp";
    }
}
