package com.xworkz.order.controller;

import com.xworkz.order.dto.OrderDTO;
import com.xworkz.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/")
public class OrderController {
    @Autowired
    private OrderService orderService;
public OrderController(){
    System.out.println("Running in OrderController");
}
    @RequestMapping("/ordered")
    public String onOrdered(OrderDTO orderDTO, Model model){
        System.out.println("onOrdered in OrderController");
        System.out.println(orderDTO);
        model.addAttribute("orderDTO",orderDTO);
        return "Ordersuccess.jsp";
    }
}
