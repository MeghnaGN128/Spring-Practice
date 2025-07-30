package com.xworkz.order.service;

import com.xworkz.order.dto.OrderDTO;

public class OrderServiceImpl implements OrderService{
    public OrderServiceImpl(){
        System.out.println("Running in OrderServiceImpl");
    }
    @Override
    public boolean save(OrderDTO orderDTO) {
        if(orderDTO!=null){
            System.out.println("OrderDTO is not null");
            return true;
        }else{
            System.out.println("OrderDTO is null");
        }
        return false;
    }

    
}
