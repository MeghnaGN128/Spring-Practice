package com.xworkz.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class OrderDTO {
    private String name;
    private String flavour;
    private int quantity;
    private boolean takeAway;
    private boolean adsOn;
    private String couponCode;
}
