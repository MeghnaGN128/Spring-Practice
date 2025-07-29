package com.xworkz.icecream.controller;

import com.xworkz.icecream.dto.OrderDTO;
import com.xworkz.icecream.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private Map<String, Double> flavourPriceMap;

    @Autowired
    private Map<String, Double> addOnPriceMap;

    public OrderController() {
        System.out.println("Running in OrderController");
    }

    @GetMapping("/order")
    public String showOrderPage(Model model) {
        model.addAttribute("orderDTO", new OrderDTO());
        model.addAttribute("flavourMap", flavourPriceMap);
        model.addAttribute("addOnMap", addOnPriceMap);
        return "Order"; // Match JSP filename
    }

    @RequestMapping("/save")
    public String onSave(@ModelAttribute OrderDTO orderDTO, Model model,
                         @RequestParam(value = "addOns", required = false) String[] addOns) {

        System.out.println("onSave in OrderController");
        System.out.println("orderDto" + orderDTO);


        if (addOns != null) {
            orderDTO.setAddOns(String.join(",", addOns));
        }

        boolean valid = orderService.save(orderDTO);

        if (valid) {
            double total = orderService.calculateTotal(orderDTO);
            model.addAttribute("name", orderDTO.getName());
            model.addAttribute("total", total);
            return "OrderSuccess";
        } else {
            model.addAttribute("error", "Invalid input, please try again.");
            model.addAttribute("flavourMap", flavourPriceMap);
            model.addAttribute("addOnMap", addOnPriceMap);
            return "Order";
        }
    }
}
