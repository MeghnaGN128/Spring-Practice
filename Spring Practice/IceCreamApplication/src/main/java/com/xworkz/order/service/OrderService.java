package com.xworkz.order.service;

import com.xworkz.order.dto.OrderDTO;

public interface OrderService {
    boolean save(OrderDTO orderDTO);
}
