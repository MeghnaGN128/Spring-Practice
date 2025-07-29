package com.xworkz.icecream.service;

import com.xworkz.icecream.dto.OrderDTO;

public interface OrderService {
    boolean save(OrderDTO orderDTO);
    double calculateTotal(OrderDTO orderDTO);
}
